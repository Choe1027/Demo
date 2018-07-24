package com.choe.threadtest.tests;

import com.choe.threadtest.thread.PipeReadThread;
import com.choe.threadtest.thread.PipeWriteThread;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PipedReader;
import java.io.PipedWriter;

/**
 * @author cyk
 * @date 2018/7/24/024 11:58
 * @email choe0227@163.com
 * @desc
 * @modifier
 * @modify_time
 * @modify_remark
 */
public class PipeTests {

    public static void main(String[] args) {

//        testCase1();
        testCase2();
    }

    public static void testCase1(){
        try {
            PipedInputStream pipedInputStream = new PipedInputStream();
            PipedOutputStream pipedOutputStream = new PipedOutputStream();
            pipedInputStream.connect(pipedOutputStream);
            PipeReadThread pipeReadThread = new PipeReadThread(pipedInputStream);
            PipeWriteThread pipeWriteThread = new PipeWriteThread(pipedOutputStream);
            pipeReadThread.start();
            pipeWriteThread.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void testCase2(){

        try {
            PipedWriter pipedWriter = new PipedWriter();
            PipedReader pipedReader = new PipedReader();
            pipedReader.connect(pipedWriter);
            PipeReadThread pipeReadThread = new PipeReadThread(pipedReader);
            PipeWriteThread pipeWriteThread = new PipeWriteThread(pipedWriter);
            pipeReadThread.start();
            pipeWriteThread.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
