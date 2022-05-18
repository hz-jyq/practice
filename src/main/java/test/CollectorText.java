package test;

import com.google.common.collect.Lists;

import java.awt.*;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author jyq
 * @Date 2022/4/19 17:14
 */
public class CollectorText {

    class CollectorImpl implements Collector {

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
    }



    public static void main(String[] args) {
      //  Collector.of(List::new);
      /*  List<String>  strings = Lists.newArrayList("1");
       Stream s = strings.stream();*/
        Optional.of("1").ifPresent(x -> System.out.print(x.length() + 1));

    }
}
