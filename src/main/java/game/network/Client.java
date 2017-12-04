package game.network;

import com.google.gson.Gson;
import game.models.Tank;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.Map;

public class Client implements Runnable {

    public Client() {

    }

    public void run() {

        try {
            DatagramSocket socket = new DatagramSocket(null);
            InetSocketAddress socketAddress = new InetSocketAddress("localhost", 3306);
            InetAddress inetAddress = InetAddress.getByName("localhost");
            socket.bind(socketAddress);
            Gson gson = new Gson();
            Map<String, Tank> tanks;
            TankMeta meta_me = new TankMeta("me");
            Tank me = game.map.Map.tanks.get("me");

            while (true) {
                byte[] buf;
                byte[] received_buf = new byte[256];
                meta_me.setPosition(me.getPosx(), me.getPosY());
                String tank_json = gson.toJson(meta_me);
                buf = tank_json.getBytes();
                DatagramPacket send_packet = new DatagramPacket(buf, buf.length, inetAddress, 3303);
                DatagramPacket received_packet = new DatagramPacket(received_buf, received_buf.length);
                socket.send(send_packet);
                socket.receive(received_packet);
                String receive_string = new String(received_packet.getData());
                receive_string = receive_string.substring(0, receive_string.lastIndexOf("}")+1);
                tanks = gson.fromJson(receive_string, Map.class);
//                for (Map.Entry<String, Tank> t : tanks.entrySet()) {
//                    Tank tnk = gson.fromJson(String.valueOf(t.getValue()), Tank.class);
//                    System.out.println(tnk.getName() + tnk.getPosx());
//                }
                Thread.sleep(1000);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}