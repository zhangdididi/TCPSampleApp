package tcp;

import java.io.*;
import java.net.Socket;

public class TCPClient {
    //本机默认的域名 localhost
    private static final String HOST = "localhost";
    private static final int PORT = 8888;

    public static void main(String[] args) throws IOException {
        //建立了客户端到服务器的TCP连接
        Socket socket = new Socket(HOST, PORT);

        InputStream is = socket.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));

        OutputStream os = socket.getOutputStream();
        //第二个参数为true表示自动刷新
        PrintWriter pw = new PrintWriter(os, true);
        pw.println("hello world!!!");
    }
}
