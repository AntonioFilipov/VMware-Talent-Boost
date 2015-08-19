package main;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.Socket;

/**
 * Represents a client which has receive and send functionalities via sockets
 * 
 * @author Antonio
 *
 */
public class Client {

    private String host;
    private int port;
    private InputStream in;
    private PrintStream out;

    private Thread receiverThread;
    private Thread emitterThread;

    private Socket socket;
    private ChatInputObserver cio;

    /**
     * Constructor without ChatInputObserver
     * 
     * @param host
     *            name of host
     * @param port
     *            port of host
     * @param in
     *            input stream
     * @param out
     *            output stream
     */
    public Client(String host, int port, InputStream in, PrintStream out) {
        this(host, port, in, out, null);
    }

    /**
     * Constructor with ChatInputObserver
     * 
     * @param host
     *            name of host
     * @param port
     *            port of host
     * @param in
     *            input stream
     * @param out
     *            output stream
     */
    public Client(String host, int port, InputStream in, PrintStream out, ChatInputObserver cio) {
        this.host = host;
        this.port = port;
        this.in = in;
        this.out = out;
        this.cio = cio;
    }

    /**
     * creates new socket, receiverThread and emitterThread
     */
    public void start() {
        try {
            socket = new Socket(host, port);

            receiverThread = new Thread(new Receiver(socket, out));
            emitterThread = new Thread(new Emitter(socket, in, cio));

            receiverThread.start();
            emitterThread.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * stop receiverThread and emitterThread and close socket
     * 
     * @throws IOException
     */
    public void stop() throws IOException {
        receiverThread.interrupt();
        emitterThread.interrupt();

        if (!socket.isClosed()) {
            socket.close();
        }
    }
}