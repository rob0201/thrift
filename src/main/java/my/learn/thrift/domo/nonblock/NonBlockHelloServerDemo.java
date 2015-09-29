package my.learn.thrift.domo.nonblock;

import my.learn.thrift.domo.HelloWorldImpl;
import my.learn.thrift.domo.HelloWorldService;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.server.TNonblockingServer;
import org.apache.thrift.server.TServer;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.apache.thrift.transport.TNonblockingServerTransport;
import org.apache.thrift.transport.TTransportException;

/**
 * Desc:
 * Author:zhangxiaowei03
 * Date: 15/9/29
 * Time: 下午4:24
 */
public class NonBlockHelloServerDemo {


  public static void main(String[] args) {
    NonBlockHelloServerDemo serverDemo = new NonBlockHelloServerDemo();
    serverDemo.startServer();

  }

  public void startServer(){
    try {
      TNonblockingServerTransport serverTransport = new TNonblockingServerSocket(10005);
      HelloWorldService.Processor<HelloWorldService.Iface> processor = new HelloWorldService.Processor<HelloWorldService.Iface>(new HelloWorldImpl());
      TNonblockingServer.Args args = new TNonblockingServer.Args(serverTransport);
      args.processor(processor);
      args.protocolFactory(new TCompactProtocol.Factory());
      TServer server = new TNonblockingServer(args);
      System.out.println("Start server on port 10005 ...");
      server.serve();
    } catch (TTransportException e) {
      e.printStackTrace();
    }
  }
}
