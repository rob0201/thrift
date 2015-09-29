package my.learn.thrift.domo;

import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;

/**
 * Desc:
 * Author:zhangxiaowei03
 * Date: 15/9/29
 * Time: 下午2:14
 */
public class HelloServerDemo {
  public static final int SERVER_PORT = 8090;

  public static void main(String[] args) {
    HelloServerDemo server = new HelloServerDemo();
    server.startServer();
  }

  public void startServer(){
    System.out.println("Hello World Thrift Simple Server start ...");
    HelloWorldService.Processor<HelloWorldService.Iface> tprocessor = new HelloWorldService.Processor<HelloWorldService.Iface>(new HelloWorldImpl());

    try {
      TServerSocket serverTransport = new TServerSocket(SERVER_PORT);
      TServer.Args tArgs = new TServer.Args(serverTransport);
      tArgs.processor(tprocessor);
      tArgs.protocolFactory(new TCompactProtocol.Factory());

      TServer server = new TSimpleServer(tArgs);
      server.serve();
    } catch (TTransportException e) {
      System.out.println("Server start error !!!");
      e.printStackTrace();
    }


  }
}
