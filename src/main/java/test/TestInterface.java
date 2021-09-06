package test;


@FunctionalInterface
public interface  TestInterface<V> {
    public void log(V v);

    public  default  void defalut(){

    }


}
