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

---

## 좋은 객체지향의 5가지 원칙 (SOLID)

- SRP: 단일 책임 원칙(single responsibility principle)
  - `하나의 클래스는 하나의 책임만 가져야 한다`
  - 변경이 있을 때 파급 효과가 적어야 한다
- OCP: 개방-폐쇄 원칙 (Open/closed principle)
  - 소프트웨어 요소는 `확장에서는 열려 있으나 변경에는 닫혀 있어야 한다`
  - 인터페이스를 구현한 새로운 클래스를 하나 만들어서 새로운 기능을 구현
- LSP: 리스코프 치환 원칙 (Liskov substitution principle)
  - 프로그램의 `객체는 프로그램의 정확성을 깨뜨리지 않으면서 하위 타입의 인스턴스로 바꿀 수 있어야 한다`
  - 다형성에서 하위 클래스는 인터페이스 규약을 다 지켜야 한다
- ISP: 인터페이스 분리 원칙 (Interface segregation principle)
  - `특정 클라이언트를 위한 인터페이스 여러 개`가 범용 인터페이스 하나보다 낫다
  - 인터페이스의 분리로 인터페이스가 명확해지고, 대체 가능성이 높아진다
- DIP: 의존관계 역전 원칙 (Dependency inversion principle)
  - 프로그래머는 `“추상화에 의존해야지, 구체화에 의존하면 안된다.”`
  - 의존성 주입은 이 원칙을 따르는 방법 중 하나
  - 구현 클래스에 의존하지 말고, `인터페이스`에 의존하라
  - `역할(Interface)`에 의존해야 `구현`의 변경에 유연해질 수 있다

---

## 스프링과 객체지향

- 스프링은 DI(Dependency Injection, 의존관계, 의존성 주입)과 DI 컨테이너로 `다형성 + OCP, DIP`를 가능하게 지원
- 코드의 변경 없이 기능 확장

---

## IoC, DI, Container

- IoC(Inversion of Control, 제어의 역전)
  - 프로그램의 제어 흐름을 직접 제어하는 것이 아니라 외부에서 관리하는 것 (ex. AppConfig.java)
- DI(Dependency Injection, 의존관계 주입)
  - 의존관계는 정적인 클래스 의존 관계와, 실행 시점에 결정되는 동적인 객체(인스턴스) 의존 관계 둘을 분리해서 생각
  - `정적인 클래스 의존관계`
    - 클래스가 사용하는 import 코드만 보고 의존관계를 쉽게 판단
  - `동적인 객체 인스턴스 의존 관계`
    - 애플리케이션 실행 시점에 실제 생성된 객체 인스턴스의 참조가 연결된 의존 관계
- IoC, DI Container
  - AppConfig 처럼 객체를 생성하고 관리하면서 의존관계를 연결해 주는 것
  - 의존관계 주입에 초점을 맞추면 DI 컨테이너라고 불리는게 적합

---

## 도메인 설계

- 도메인 `협력, 역할, 책임` 관계 (기획자 시점)
  - `역할과 구현을 분리`하여 자유롭게 구현 객체를 조립할 수 있도로 설계
- 클래스 다이어그램 (개발자 시점)
- 객체 다이어그램 (인스턴스끼리의 참조)

---

## 싱글톤 컨테이너

- 싱글톤 패턴 : 클래스의 인스턴스가 딱 1개만 생성되는 것을 보장하는 디자인 패턴
- 싱글톤 객체(스프링 빈)는 상태를 무상태(stateless)로 설계해야 한다.
  - 특정 클라이언트에 의존적인 필드가 있으면 안된다.
  - 특정 클라이언트가 값을 변경할 수 있는 필드가 있으면 안된다!
  - 가급적 읽기만 가능해야 한다.
  - 필드 대신에 자바에서 공유되지 않는, 지역변수, 파라미터, ThreadLocal 등을 사용해야 한다.
- 스프링 설정 정보는 항상 @Configuration을 사용하여 싱글톤을 보장하자.

---

## Component Scan

- Config class에 @ComponentScan을 명시해주면, 자동으로 class path를 탐색해서 @Component가 명시된 class들을 Spring Container의 Spring Bean으로 등록해준다.
- 의존관계 주입은 @Autowired가 해결해준다.
  - 기본 조회 전략은 타입이 같은 빈을 찾아서 주입

---

> IntelliJ
>
> Generate : Alt + Insert
>
> 오류 해결 : Alt + Enter
>
> 오류 코드로 이동 : F2
>
> 변수명 자동 생성 : Ctrl + Alt + V
>
> RecentFile : Ctrl + E
>
> (;)포함 엔터 : Ctrl + Shift + Enter
>
> 이전 File : Ctrl + Alt + <- or ->
>
> Extract Mathod : Ctrl + Alt + M
>
> 코드 복사 : Ctrl + D
>
> 파일 검색 : Ctrl + N
>
> Find in Path : Ctrl + Shift + F
>
> Find All : Shift x 2
