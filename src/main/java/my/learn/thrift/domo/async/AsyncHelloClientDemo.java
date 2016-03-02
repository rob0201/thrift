package my.learn.thrift.domo.async;

import my.learn.thrift.domo.HelloWorldService;
import org.apache.thrift.TException;
import org.apache.thrift.async.TAsyncClientManager;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TProtocolFactory;
import org.apache.thrift.transport.TNonblockingSocket;
import org.apache.thrift.transport.TNonblockingTransport;

import java.io.IOException;

public class AsyncHelloClientDemo {

  public static void main(String[] args) {
      AsyncHelloClientDemo clientDemo = new AsyncHelloClientDemo();
    clientDemo.startClient();
  }

  public void startClient(){
    try {
      TAsyncClientManager clientManager = new TAsyncClientManager();
      TNonblockingTransport transport = new TNonblockingSocket("localhost",10005);
      TProtocolFactory protocol = new TCompactProtocol.Factory();

      HelloWorldService.AsyncClient client = new HelloWorldService.AsyncClient(protocol,clientManager,transport);
      System.out.println("Client calls ...");

      MethodCallback callback = new MethodCallback();

      client.sayHello("username", callback);
      Object object = callback.getResponse();
      while (object == null){
        Thread.currentThread().sleep(1000);
        object=callback.getResponse();
      }

      System.out.println(((HelloWorldService.AsyncClient.sayHello_call)object).getResult());
    } catch (IOException e) {
      e.printStackTrace();
    } catch (TException e) {
      e.printStackTrace();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

  }
}
