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


##### jsonTest Method 생성하기 
JSON 데이터로 출력해줄  Map 객체를 생성 후 아무 문자를 입력해 put 해보자
리턴값은 map 객체를 생성한 변수를 리턴해주면 된다. 

###### log 정보
INFO : com.rest.test.RestTestController - json type map value : '{rest test key=im value hihi}'

###### 실행 결과 이미지
![reststudy2](https://user-images.githubusercontent.com/67121077/135415823-46824292-16ad-43a5-97b5-9a8ae203928a.PNG)


#### Service Create
###### Controller에서 요청 자체를 처리하지 않게하기위해 Service로 나눈다.
Service는 패키지와 클래스 생성 후 @Service 어노테이션을 설정해주면 된다. 
Service와 Controller 로직을 나눈 후 (코드 작성 후) 실행결과

##### Controller 에 불러올 Service 객체를 DI를 통해 주입받기
2가지 방법이 있다. 컨트롤러 생성자를 통해 주입 받는 방법과 @AutoWired 어노테이션을 통해 주입받는 방법. 
![reststudy4](https://user-images.githubusercontent.com/67121077/135420337-a3324948-159c-4d56-9252-03bd4e9a8344.PNG)

###### 실행 결과 이미지
![reststudy3](https://user-images.githubusercontent.com/67121077/135419582-594ee4f4-8282-42ce-a651-88d11409f614.PNG)