package algorithm.engine;

import java.util.function.Consumer;
import java.util.function.Function;

public class OrdinaryPipelineTest {


    public static void main(String[] args) {
        testFunction("财务退款",(x) -> System.out.println(x + "1111"));
    }

    private static class DemoPipeline extends OrdinaryPipeline<String> {

        public DemoPipeline(String name) {
              super(name);
        }

        @Override
        public void process(PipelineContext ctx, String s) {
            System.out.println("开始");
            System.out.println(s);
            System.out.println("结束");
        }
    }



    public static <T>  void testFunction(String str, Consumer<T> action) {
        System.out.println(str + "开始");
        action.accept(null);
        System.out.println(str + "结束");
    }

  /*  public static <T,R> R testFunction(T i, Function<T,R> function) {
        Function<T, T>  reslut =  Function.identity();
        // reslut.apply();
        return function.apply(i);
    }*/
}
