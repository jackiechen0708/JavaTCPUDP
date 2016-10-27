package fd.jc.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * Created by JackieChen on 2016/10/26.
 */
public class Server {
    public static void main(String[]args){



        try {
            DatagramSocket datagramSocket=new DatagramSocket(10086);
            byte[] bytes=new byte[32];
            DatagramPacket datagramPacket=new DatagramPacket(bytes,bytes.length);
            while (true) {
                System.out.println("waiting for data...");
                datagramSocket.receive(datagramPacket);
                System.out.println(datagramPacket.getAddress().toString()+":"+datagramPacket.getPort()
                        +"msg:"+new String(datagramPacket.getData(),0,datagramPacket.getLength()));
            }

        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
