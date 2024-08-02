package com.example;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({StudentTest.class, SeleniumTest.class})
public class Runner {

}
