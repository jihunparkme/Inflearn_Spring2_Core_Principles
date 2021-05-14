package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

/*
 * ComponentScan을 사용할 경우 @Bean 등록이 필요 없다.
 * 
 * @Component annotation이 붙은 class를 scan해서 Spring Bean으로 등록
 * @Autowired로 의존관계 자동 주입
 */
@Configuration
@ComponentScan(
        basePackages = "hello.core", // 탐색할 패키지의 시작 위치 지정
        basePackageClasses = AutoAppConfig.class, // 해당 class의 패키지를 탐색 시작 위치로
        // default는 @ComponentScan 이 붙은 설정 정보 클래스의 패키지가 시작 위치
        // 권장 방법 : 패키지 위치를 지정하지 않고, 설정 정보 클래스의 위치를 프로젝트 최상단에 위치
        // 사실 SpringBot를 사용하면 @SpringBootApplication에서 이미 ComponentScan을 하기 때문에 따로 해줄 필요는 없음

        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
        // SpringBean 자동 등록에서 제외할 class 설정
        // ComponentScan을 하게되면 @Configuration으로 등록된 설정 정보도 함께 등록되므로, Configuration class는 제외해주자.
        // 실무에서는 잘 사용되지 않지만 예제(AppConfig, TestConfig)에서 등록된 설정이 있으므로 사용
)
public class AutoAppConfig {
    
}
