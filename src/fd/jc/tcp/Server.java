package fd.jc.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by JackieChen on 2016/10/26.
 */
public class Server {
    public static void main(String[]args){
        try {
            ServerSocket serverSocket=new ServerSocket(20000);

           while(true){
               System.out.println("Server waiting for connection");
               Socket socket=serverSocket.accept();
               System.out.println("ready");
               BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
               new Thread(new Runnable() {// 此处建议封装成线程类，每个连接一个线程
                   @Override
                   public void run() {
                       while (true) {
                           try {
                               System.out.println("received:" + socket.getPort()+ bufferedReader.readLine());
                           } catch (IOException e) {
                               e.printStackTrace();
                           }
                       }
                   }
               }).start();
           }
            //没处理关闭情况可能会造成内存泄露


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
