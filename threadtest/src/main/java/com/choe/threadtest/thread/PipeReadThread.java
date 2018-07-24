package com.choe.threadtest.thread;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedReader;

/**
 * @author cyk
 * @date 2018/7/24/024 11:45
 * @email choe0227@163.com
 * @desc
 * @modifier
 * @modify_time
 * @modify_remark
 */
public class PipeReadThread extends Thread {

    private PipedReader pipedReader;

    private PipedInputStream pipedInputStream;

    public PipeReadThread(PipedReader pipedReader) {
        this.pipedReader = pipedReader;
    }

    public PipeReadThread(PipedInputStream pipedInputStream) {
        this.pipedInputStream = pipedInputStream;
    }

    @Override
    public void run() {

        try {
            if (pipedReader != null){
                char [] chars = new char[1024];
                int len = -1;

                while ((len = pipedReader.read(chars))!= -1){

                    System.out.println("read:"+new String(chars,0,len));
                }

            } else if (pipedInputStream != null){
                byte [] bytes = new byte[1024];
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                int len = -1;
                while ((len = pipedInputStream.read(bytes))!= -1){
                    byteArrayOutputStream.write(bytes,0,len);
                }
                System.out.println("read:"+byteArrayOutputStream.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
