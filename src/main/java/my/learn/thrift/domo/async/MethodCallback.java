package my.learn.thrift.domo.async;

import org.apache.thrift.async.AsyncMethodCallback;

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
