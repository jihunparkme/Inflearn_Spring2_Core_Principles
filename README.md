# Inflearn_Spring2_Core_Principles

(Inflearn) 스프링 핵심 원리 - 기본편

### Spring

[Spring Documentaion](https://spring.io/projects)

- 필수
  - 스프링 프레임워크
  - 스프링 부트
- 선택
  - 스프링 데이터
  - 스프링 세션
  - 스프링 시큐리티
  - 스프링 Rest Docs
  - 스프링 배치
  - 스프링 클라우드

### 좋은 객체지향의 5가지 원칙 (SOLID)

- SRP: 단일 책임 원칙(single responsibility principle)
  - 하나의 클래스는 하나의 책임만 가져야 한다
  - 변경이 있을 때 파급 효과가 적어야 한다
- OCP: 개방-폐쇄 원칙 (Open/closed principle)
  - 소프으퉤어 요소는 확장에서는 열려 있으나 변경에는 닫혀 있어야 한다
  - 인터페이스를 구현한 새로운 클래스를 하나 만들어서 새로운 기능을 구현
- LSP: 리스코프 치환 원칙 (Liskov substitution principle)
  - 프로그램의 객체는 프로그램의 정확성을 깨뜨리지 않으면서 하위 타입의 인스턴스로 바꿀
    수 있어야 한다
  - 다형성에서 하위 클래스는 인터페이스 규약을 다 지켜야 한다
- ISP: 인터페이스 분리 원칙 (Interface segregation principle)
  - 특정 클라이언트를 위한 인터페이스 여러 개가 범용 인터페이스 하나보다 낫다
  - 인터페이스의 분리로 인터페이스가 명확해지고, 대체 가능성이 높아진다
- DIP: 의존관계 역전 원칙 (Dependency inversion principle)
  - 프로그래머는 “추상화에 의존해야지, 구체화에 의존하면 안된다.”
  - 의존성 주입은 이 원칙을 따르는 방법 중 하나
  - 구현 클래스에 의존하지 말고, `인터페이스`에 의존하라
  - `역할(Interface)`에 의존해야 `구현`의 변경에 유연해질 수 있다

### 스프링과 객체지향

- 스프링은 DI(Dependency Injection, 의존관계, 의존성 주입)과 DI 컨테이너로 `다형성 + OCP, DIP`를 가능하게 지원
- 코드의 변경 없이 기능 확장

### 도메인 설계

- 도메인 `협력, 역할, 책임` 관계 (기획자 시점)
  - `역할과 구현을 분리`하여 자유롭게 구현 객체를 조립할 수 있도로 설계
- 클래스 다이어그램 (개발자 시점)
- 객체 다이어그램 (인스턴스끼리의 참조)
