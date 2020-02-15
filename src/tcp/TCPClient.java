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
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();//已经去除了换行符
            //发送数据报到服务端
            pw.println(line);//println发送的数据会加上换行符
            //接收服务端的响应信息
            String response = br.readLine();
            System.out.println("接收到服务端响应：" + response);
        }
    }
}
