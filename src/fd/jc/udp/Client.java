package fd.jc.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

/**
 * Created by JackieChen on 2016/10/26.
 */
public class Client {

    public static void main(String[]args){
        Scanner scanner=new Scanner(System.in);
        String s=null;
        try {
            DatagramSocket datagramSocket=new DatagramSocket(10087);
            while(true){
                System.out.println("please input msg...");
                s=scanner.next();
                datagramSocket.send(new DatagramPacket(s.getBytes(),s.getBytes().length, InetAddress.getLocalHost(),10086));



            }
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
