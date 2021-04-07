package algorithm.engine;



import java.util.List;

public  abstract  class OrdinaryPipeline<T> implements Pipeline<T>{

    private  String name;

    private Pipeline<T> next;

    public void setNext(Pipeline<T> next) {
        this.next = next;
    }



    @Override
    public abstract void process(PipelineContext ctx, T t);


    public OrdinaryPipeline(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        if (next != null) {
            return name + "->" + next.toString();
        }
        return name;
    }

    @Override
    public void forward(PipelineContext ctx, T t) {
        if(next != null){
            next.process(ctx, t);
        }
    }

    public static <T>   Pipeline<T> getInstance(List<OrdinaryPipeline> pipelines) {
        if (pipelines == null || pipelines.isEmpty()) {
            throw new IllegalArgumentException("empty pipelines!");
        }
        OrdinaryPipeline<T>[] a = (OrdinaryPipeline<T>[]) pipelines.toArray(new OrdinaryPipeline[0]);
        OrdinaryPipeline<T> p = a[0];
        for (int i = 1; i < a.length; ++i) {
            p.setNext(a[i]);
            p = a[i];
        }
        return a[0];
    }
}
