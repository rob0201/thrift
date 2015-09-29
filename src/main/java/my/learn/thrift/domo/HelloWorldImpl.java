package my.learn.thrift.domo;

import org.apache.thrift.TException;

/**
 * Desc:
 * Author:zhangxiaowei03
 * Date: 15/9/29
 * Time: 下午2:12
 */
public class HelloWorldImpl implements HelloWorldService.Iface{
  public String sayHello(String username) throws TException {
    return "Hi,"+ username +",Welcome to the thrift's world !";
  }
}
