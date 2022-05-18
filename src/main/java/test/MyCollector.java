package test;

import com.google.common.collect.Lists;
import sun.plugin.dom.html.common.HTMLCollection;

import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @Author jyq
 * @Date 2022/4/21 11:32
 */
public class MyCollector<T, A, R> implements Collector<T, A, R>  {
    @Override
    public Supplier supplier() {

        return null;
    }

    @Override
    public BiConsumer accumulator() {
        return null;
    }

    @Override
    public BinaryOperator combiner() {
        return null;
    }

    @Override
    public Function finisher() {
        return null;
    }

    @Override
    public Set<Characteristics> characteristics() {
        return null;
    }



    public static void main(String[] args) {

        List<Long> longList = Lists.newArrayList(1L,2l,3L);
        Collector<Long,String,String> collector =   new MyCollector();

       // longList.stream().collect(Collectors.joining("."));
    }

    public   static  class Collectors{
     /*   public  static MyCollector  joining(String string){
              return MyCollector();
        }*/
    }


}

