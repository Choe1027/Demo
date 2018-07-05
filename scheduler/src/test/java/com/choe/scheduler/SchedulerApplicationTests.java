package com.choe.scheduler;

import com.choe.scheduler.tasks.AllTasks;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SchedulerApplicationTests {

    @Autowired
    private AllTasks allTasks;

    @Test
    public void contextLoads() {
    }

}
