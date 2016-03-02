package my.learn.thrift.domo;

import org.apache.thrift.TException;


public class HelloWorldImpl implements HelloWorldService.Iface{
  public String sayHello(String username) throws TException {
    return "Hi,"+ username +",Welcome to the thrift's world !";
  }
}
