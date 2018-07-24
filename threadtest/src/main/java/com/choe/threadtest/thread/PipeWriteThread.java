package com.choe.threadtest.thread;

import java.io.IOException;
import java.io.PipedOutputStream;
import java.io.PipedWriter;

/**
 * @author cyk
 * @date 2018/7/24/024 11:45
 * @email choe0227@163.com
 * @desc
 * @modifier
 * @modify_time
 * @modify_remark
 */
public class PipeWriteThread extends Thread {

    private PipedWriter pipedWriter;
    private PipedOutputStream pipedOutputStream;

    public PipeWriteThread(PipedWriter pipedWriter) {
        this.pipedWriter = pipedWriter;
    }

    public PipeWriteThread(PipedOutputStream pipedOutputStream) {
        this.pipedOutputStream = pipedOutputStream;
    }

    @Override
    public void run() {

        try {
            if (pipedOutputStream != null){
                pipedOutputStream.write("pipedOutputStream 写过来的信息".getBytes());
            }else if (pipedWriter != null){
                pipedWriter.write("pipedWriter 写过来的信息");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pipedOutputStream != null){
                    pipedOutputStream.close();
                }
                if (pipedWriter != null){
                    pipedWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
