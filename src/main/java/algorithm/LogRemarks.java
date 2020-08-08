package algorithm;


import java.lang.annotation.*;

/**
 * @author jyq
 */
@Documented
@Target(ElementType.FIELD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@interface LogRemarks {

    String name() default "";

    /**
     * arrys字符串数组
     *
     */
    String type() default "";


     Class clazz() default Class.class;

}
