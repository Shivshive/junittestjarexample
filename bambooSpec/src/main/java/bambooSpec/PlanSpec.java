package bambooSpec;

import com.atlassian.bamboo.specs.api.BambooSpec;
import com.atlassian.bamboo.specs.api.builders.plan.Plan;
import com.atlassian.bamboo.specs.api.builders.plan.branches.PlanBranchManagement;
import com.atlassian.bamboo.specs.api.builders.project.Project;
import com.atlassian.bamboo.specs.builders.repository.git.UserPasswordAuthentication;
import com.atlassian.bamboo.specs.builders.task.MavenTask;
import com.atlassian.bamboo.specs.util.BambooServer;
import com.atlassian.bamboo.specs.api.builders.plan.Job;
import com.atlassian.bamboo.specs.api.builders.plan.Stage;
import com.atlassian.bamboo.specs.api.builders.plan.artifact.Artifact;
import com.atlassian.bamboo.specs.api.builders.repository.VcsRepository;
import com.atlassian.bamboo.specs.builders.repository.git.GitRepository;
import com.atlassian.bamboo.specs.builders.task.ScriptTask;
import com.atlassian.bamboo.specs.builders.task.VcsCheckoutTask;

/**
 * Plan configuration for Bamboo.
 * Learn more on: <a href="https://confluence.atlassian.com/display/BAMBOO/Bamboo+Specs">https://confluence.atlassian.com/display/BAMBOO/Bamboo+Specs</a>
 */
@BambooSpec
public class PlanSpec {


    private final static String PROJECT_NAME = "sampleproject";
    private final static String PROJECT_KEY = "SAM";
    private final static String PLAN_NAME = "junittestjarexample_build";
    private final static String REPOSITORY_NAME = "junittestjarexample\n";
    private final static String PLAN_KEY = "SAM-JUN";
    private final static String REPO_URL = "https://github.com/Shivshive/junittestjarexample.git";
    private final static String BRANCH_NAME = "main";
    private final static String LINKED_REPO_NAME="junittestjarexample";

    /**
     * Run main to publish plan on Bamboo
     */
    public static void main(final String[] args) throws Exception {
        //By default credentials are read from the '.credentials' file.
        BambooServer bambooServer = new BambooServer("http://localhost:8085");

        Plan plan = new PlanSpec().createPlan();

        bambooServer.publish(plan);
    }

    Project project() {
        return new Project()
                .name(PROJECT_NAME)
                .key(PROJECT_KEY);
    }

    Plan createPlan() {
        return new Plan(
                project(),
                PLAN_NAME, PLAN_KEY)
                .description("Plan created from (enter repository url of your plan)")
                .enabled(true)
                .variables(BambooConstant.variables())
                .planRepositories(
                        gitRepository()
                )
                .stages(
                        new Stage("Stage 1").jobs( //stage name
                                new Job("Job Name", "JOBKEY") //job name and job key identifier
                                        .tasks(
                                                gitRepositoryCheckoutTask(),
                                                mavenTask("clean test"),
                                                scriptTask()

                                        )
                                        .artifacts(artifact())
                        )
                )
                .linkedRepositories(LINKED_REPO_NAME)
                .planRepositories(gitRepository());
    }

    VcsRepository gitRepository() {
        return new GitRepository()
                .name(REPOSITORY_NAME)
                .url(REPO_URL)
                .branch(BRANCH_NAME)
                .authentication(new UserPasswordAuthentication("shivshive04@yahoo.com").password("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"));
    }

    VcsCheckoutTask gitRepositoryCheckoutTask() {
        return new VcsCheckoutTask()
                .cleanCheckout(true)
                .addCheckoutOfDefaultRepository();
    }

    ScriptTask scriptTask() {
        return new ScriptTask()
                .inlineBody("mkdir -p target" +
                        "echo 'Building branch ${bamboo.BRANCH_NAME} ${bamboo.tags} ${bamboo.runner} ${bamboo.env} ' > target/build.log" +
                        "echo 'Build completed successfully.' >> target/build.log")
                .interpreterShell();
    }

    MavenTask mavenTask(String goalString) {
        return new MavenTask().version3().goal(goalString);
    }

    Artifact artifact() {
        return new Artifact("Build results")
                .location("target")
                .copyPattern("**/*");
    }

}
