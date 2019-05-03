package com.cts.projectmanager;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ ProjectManagerApplicationTest.class, UserControllerTest.class, ProjectControllerTest.class, TaskControllerTest.class })
public class PMAppTestSuite {

}
