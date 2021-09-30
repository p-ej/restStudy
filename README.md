# restStudy
## source URL : " https://devkingdom.tistory.com/105?category=761188 "
### Config : Spring Framework(5.1.1), Windows 10, Eclipse 2021.03

> RestFul Web Service


> Spring MVC RestFul Developer (1)
#### RESTFul
###### API의 엔드포인트가 단 하나이고, 요청과 응답에 대한 메타데이터는 HTTP 프로토콜을 사용해서 전달해야 함.
###### 요청 메서드는 POST, GET, PUT, DELETE를 사용한다.
###### 요청 URL에는 동사를 사용하지 않아야 한다.
#### Spring Layered Architecture
###### 스프링의 계층은 프레젠테이션(Controller), 비즈니스(Service), 데이터(Model, DAO) 영역으로 나뉜다.

#### Controller Create
##### 스프링 레거시 프로젝트를 생성하면 기본 패키지 안에 HomeController가 있다. 기본 컨트롤러는 구동이 잘되는지만 확인하고 새로운 컨트롤러를 만들었다.
##### RestTestController Create
###### 해당 컨트롤러로 들어오는 전체 매핑은 " / "으로 지정
###### @RestController 어노테이션 지정 후 test메소드 생성 매핑 어노테이션은 GetMapping, test 메소드 리턴 값은 문자열 아무거나.

![reststudy1](https://user-images.githubusercontent.com/67121077/135414269-ba83d1ba-b1c5-44ef-bacd-523309448b95.PNG)
