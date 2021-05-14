package hello.core.scan.filter;

import java.lang.annotation.*;

/*
 * @MyExcludeComponent 가 명시된 클래스는 Component Scan 제외 대상
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyExcludeComponent {

}