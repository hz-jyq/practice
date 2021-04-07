package algorithm.engine;


import java.util.function.Function;

public class Piepline implements  Runnable {

    public Piepline(Object o) {
    }

    public String getName(){
      return  "";
    }


   public  Piepline(IFunction iFunction) {
         //  String name =    iFunction.trigger();
      // iFunction.
       // System.out.println(name);
           //  iFunction.trigger("222");
  }

    @Override
    public void run() {

    }

    public  static void  get(){

        IFunction iFunction = p -> System.out.println("Hello " + p);
        //iFunction.sayMessage("1111");
     //new Piepline((x) -> "2222");
    }

    public static void main(String[] args) {
        get();
    }

}
