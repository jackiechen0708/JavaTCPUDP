package fd.jc.tcp;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by JackieChen on 2016/10/26.
 */
public class Client {
    public static void main(String[]args){
        Socket socket=null;
        PrintStream out ;
        Scanner scanner=new Scanner(System.in);
        String msg=null;
        try {
            socket=new Socket("127.0.0.1",20000);
            out=new PrintStream(socket.getOutputStream());
            while (true){
                System.out.println("Please input msg");
                msg=scanner.next();
                out.println(msg);



            }

        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}
