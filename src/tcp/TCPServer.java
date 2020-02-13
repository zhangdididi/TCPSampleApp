package tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

    private static final int PORT = 8888;

    public static void main(String[] args) throws IOException {
        //启动TCP服务器
        ServerSocket serverSocket = new ServerSocket(PORT);

        //循环获取新的客户端连接
        while (true) {
            //阻塞等待新的客户端连接
            Socket socket = serverSocket.accept();
            //处理该客户端连接的业务，但有可能发生阻塞（后面需要处理）
            //首先不考虑阻塞
            //获取二进制输入输出流
            InputStream is = socket.getInputStream();
            //缓冲字符流。字节流转换成字符流。中间流InputStreamReader
            BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            OutputStream os = socket.getOutputStream();
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
            //1. 先接收客户端传输过来的数据，然后打印
            //2. 响应返回给客户端一个数据："我已经接收到数据"
            String line;
            //阻塞等待客户端传来的新的行数据
            while ((line = br.readLine()) != null) {
                System.out.println("服务端接收到数据：" + line);
                //write是写到缓冲区内
                bw.write("已接收到 " + line + "消息");
                //刷新缓冲区，才能发送出数据
                bw.flush();
            }
        }
    }
}