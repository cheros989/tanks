/**
 * @author Roman Pavliukov
 * @version 1.0.0
 *
 */

package game.network;

import com.google.gson.Gson;

import game.models.Tank;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Map;

public class Server {

    public static void main(String[] args) {
        Map<String, String> tanks = new HashMap<>();
        try {
            /*
             * Init sockets and Gson for send tanks
             * as String
             */
            InetSocketAddress socketAddress = new InetSocketAddress("localhost", 3303);
            DatagramSocket server = new DatagramSocket(socketAddress);
            Gson gson = new Gson();
            tanks.put("second", gson.toJson(new TankMeta("JEREMY")));

            /*
             * Initialize buffers for sending and receiving
             * Gson strings.
             * Initialize variables
             */
            byte[] buf;
            byte[] send_buf;
            DatagramPacket receive_packet;
            DatagramPacket send_packet;
            String received_string;
            Tank tank;

            while (true) {
                /*
                 * Create String from actual
                 * tanks list and collect it to DatagramPacket
                 */
                String tanks_json = gson.toJson(tanks);
                send_buf = tanks_json.getBytes();

                /*
                 * Receive package with tank
                 * actual status
                 */
                buf = new byte[256];
                receive_packet = new DatagramPacket(buf, buf.length);
                server.receive(receive_packet);

                /*
                 * Send all tanks statuses to our
                 * client, through packet address
                 */
                send_packet = new DatagramPacket(send_buf, send_buf.length, receive_packet.getSocketAddress());
                server.send(send_packet);

                /*
                 * Below work with our received info
                 * Make string from DatagramPacket, and
                 * remove redundant from our string
                 */
                received_string = new String(receive_packet.getData());
                received_string = received_string.substring(0, received_string.lastIndexOf("}")+1);

                /*
                 * Make Tank object from Gson string
                 */
                tank = gson.fromJson(received_string, Tank.class);

                /*
                 * If tank not exists yet,
                 * add it to tanks, else override it (actualize)
                 */
                tanks.put(tank.getName(), gson.toJson(tank, Tank.class));
                System.out.println(tanks.size());
                System.out.println(tank.getPosX() + " " + tank.getPosY());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}