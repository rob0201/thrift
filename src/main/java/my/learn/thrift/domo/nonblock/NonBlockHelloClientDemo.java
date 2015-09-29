package my.learn.thrift.domo.nonblock;

import my.learn.thrift.domo.HelloWorldService;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

/**
 * Desc:
 * Author:zhangxiaowei03
 * Date: 15/9/29
 * Time: 下午4:34
 */
public class NonBlockHelloClientDemo {

  public static void main(String[] args) {
    NonBlockHelloClientDemo clientDemo = new NonBlockHelloClientDemo();
    clientDemo.startClient("username");
  }

  public void startClient(String username){
    TTransport transport = new TFramedTransport(new TSocket("localhost",10005,30000));
    TProtocol protocol = new TCompactProtocol(transport);
    HelloWorldService.Client client = new  HelloWorldService.Client(protocol);
    try {
      transport.open();
      String result = client.sayHello(username);
      System.out.println("Thrift client result = " + result);
      transport.close();
    } catch (TTransportException e) {
      e.printStackTrace();
    } catch (TException e) {
      e.printStackTrace();
    }

  }
}
