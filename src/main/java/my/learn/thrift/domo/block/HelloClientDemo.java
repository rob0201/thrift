package my.learn.thrift.domo.block;

import my.learn.thrift.domo.HelloWorldService;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;


public class HelloClientDemo {

  public static final String SERVER_IP = "localhost";
  public static final int SERVER_PORT = 8090;
  public static final int TIMEOUT = 30000;

  public static void main(String[] args) {
    HelloClientDemo client = new HelloClientDemo();
    client.startClient("username");
  }

  public void startClient(String username){
    TTransport transport = new TSocket(SERVER_IP,SERVER_PORT,TIMEOUT);
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
