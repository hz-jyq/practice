package algorithm.bean;

public interface Bean {

    <T> T getBean(Class<T> tClass);
}
