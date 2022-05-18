package algorithm.lightState;


/**
 * 熔断器半断开状态
 * 切换到半断开状态时，将连续成功调用计数重置为0，当执行成功的时候，自增该字段，当达到连读调用成功次数的阈值时，切换到闭合状态。
 * 如果调用失败，立即切换到断开模式。
 */
public class HalfOpenState {
}
