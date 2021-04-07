package algorithm.engine;

public interface Pipeline<T> {

    void process(PipelineContext ctx, T t);

    void forward(PipelineContext ctx, T t);
}
