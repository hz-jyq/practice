package algorithm.bean;

public class BeanImpl implements  Bean {

    @Override
    public <T> T getBean(Class<T> tClass) {
        return (T)"111";
    }
}
