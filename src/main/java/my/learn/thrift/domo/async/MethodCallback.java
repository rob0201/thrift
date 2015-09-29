package my.learn.thrift.domo.async;

import org.apache.thrift.async.AsyncMethodCallback;

/**
 * Desc:
 * Author:zhangxiaowei03
 * Date: 15/9/29
 * Time: 下午4:41
 */
public class MethodCallback implements AsyncMethodCallback{

  Object response = null;


  public Object getResponse(){
    return this.response;
  }

  @Override
  public void onComplete(Object o) {
    this.response=o;
  }

  @Override
  public void onError(Exception e) {

  }
}
