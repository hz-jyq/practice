package algorithm.lightState;

/**
 * 熔断器断开状态
 * 断开状态内部维护一个计数器，如果断开达到一定的时间，则自动切换到半断开状态，并且，在断开状态下，如果需要执行操作，则直接抛出异常。
 */
public class OpenState {
}
