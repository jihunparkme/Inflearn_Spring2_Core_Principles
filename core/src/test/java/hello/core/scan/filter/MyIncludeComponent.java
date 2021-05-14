package hello.core.scan.filter;

import java.lang.annotation.*;

/*
 * @MyIncludeComponent 가 명시된 클래스는 Component Scan 추가 대상
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyIncludeComponent {

}