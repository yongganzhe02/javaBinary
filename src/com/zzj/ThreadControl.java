package com.zzj;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ThreadControl extends Thread {
    ServerSocket s1;

    public ThreadControl(ServerSocket s1) {
        this.s1 = s1;
    }

    @Override
    public void run() {
        try {
            //开启服务
            while (true) {
                //等待客户来访问（如果没有客户访问，该方法阻塞）
                Socket socket1 = s1.accept();
                System.out.println("客户端" + socket1.getInetAddress().getHostAddress() + "已连接");

                InputStream input = socket1.getInputStream();
                byte data2[] = new byte[1024];
                input.read(data2);
                String s = new String(data2);
                System.out.println("接受到的命令是:" + s);
                System.out.println();
                if (s.substring(0,4).equals("find")) {
                    //服务器写

                    OutputStream output1 = socket1.getOutputStream();
                    output1.write(DataContainer.data1);
                    String str= new String (DataContainer.data1);

                }

//                if (s.substring(0,3).equals("bye")) {
//                    s1.close();
//                    socket1.close();
//                    input.close();
//                    break;
//
//                }

//                else{
//                    OutputStream output1 = socket1.getOutputStream();
//                    output1.write("命令错误".getBytes());
//                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}