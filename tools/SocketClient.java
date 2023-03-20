import java.io.*;
import java.net.*;
import java.util.Timer;
import java.util.TimerTask;

public class SocketClient {
    private static final String HOST = "localhost";
    private static final int PORT = 1234;
    private static final String XML_MESSAGE = "<xml>...</xml>";
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                try {
                    Socket socket = new Socket(HOST, PORT);
                    OutputStream out = socket.getOutputStream();
                    out.write(XML_MESSAGE.getBytes());
                    out.flush();
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }, 0, 5000); 
    }
}