## What is Spring

- Spring is a dependency injection framework

## What is dependency?

- 3 layers: Web - Business - Data
- Business layer is "dependent" on Data layer. Like that, Web layer is also "dependent" on Business layer.
- In class below, class ComplexBusinessService is dependent on sortAlgorithm. In other words, sortAlgorithm is dependency of the class.
```
// ...
public class ComplexBusinessService {
    SortAlgorithm sortAlgorithm;
// ...
```
- Dependencies of a class is data that the class needs to provide service.
- Consider below example. There will be many of classes that directly instantiate classes. They are all "tightly coupled". Just say you want to change the algorithm for a class.
```
// ...
public class ComplexBusinessService {
    SortAlgorithm sortAlgorithm = new BubbleSortAlgorithm();
// ...
public class BubbleSortAlgorithm implements SortAlgorithm {
// ...
```
- Tightly coupled parts are not considered good in software architecture.
- Normally, people solve like below without Spring:
```
// ...
public class ComplexBusinessService {
    SortAlgorithm sortAlgorithm;

    public ComplexBusinessService(SortAlgorithm sortAlgorithm) {
        this.sortAlgorithm = sortAlgorithm;
    }
// ...
```
- When you use above logic you will write codes like:
```
// ...
SortAlgorithm sortAlgorithm = new BubbleSortAlgorithm();
ComplexBusinessService businessService = new ComplexBusinessService(sortAlgorithm);
//...
```
- Spring will instantiate a class and pass it to the logic(like above).

## How Spring works then?

- You, as a programmer, need to let Spring framework know what objects need to be managed and what are the dependencies.
```
// ...
@Component
public class ComplexBusinessService {

    @Autowired
    SortAlgorithm sortAlgorithm;
// ...
@Component
public class BubbleSortAlgorithm implements SortAlgorithm {
// ...
```
- By using @Component you tell the framework, "Okay, these are object you gotta manage."
- @Autowired let Spring know this is a dependency and Spring will start among the component and instances(classes) to find this one.
- Then the framework will populate the dependency with an instance that matches.
- This process is called "Dependency Injection".

## Basic terminology

- Beans: Instances managed by Spring framework.
- Autowiring: The process where Spring identifies the dependencies, identifies the matches for the dependencies and populates them.
- Dependency injection: Explained already :p
- Inversion of control: As you see in the example above, classes were usually in charge of instantiating object it needs. If you use Spring, however, the framework instantiates classes on behalf of controlled objects. This concept is IOC.
- IOC Container: Framework for implementing automatic dependency injection.
- Application context: IOC Container Spring framework concerns. Application context is the one where all the beans are created and managed.

## Setting up a Spring project

- https://start.spring.io would help when you start from scratch.

## When you use Spring, you need to tell the framework about:

- What are beans? => @Component
- What are dependencies of a bean? @Autowired
- Where to search for beans? => basically no need to(package)

## If there are instances that implement same interface?

- Spring will generate exception as it cannot decide which bean to use
- You can set @Primary in this case.
- Or you can simply use name directly ...
- @Primary has priority.
- There is another option: @Qualifire("name")

## Setter injection and constructor injection

- If a dependency is mandatory, constructor injection is recommended.
- Else, in case of optional dependency, you can use setter injection.
- In real world, however, just setter injection(actually, just @Autowired) is preferred.

## AOP

- Aspect Oriented Programming

## Crosscutting Concerns

- Considering many layers: like test modules

## ORM

- Object Relational Mapping

## Spring Modules

- Data Access/Integration: JDBC, ORM(like Hibernate), Transaction...
- Web: WebSocket, Servlet, Web...
- AOP
- Aspects
- Messaging
- Core Container: Beans, Core, Context...
- Test 

## Spring Projects

- Spring Boot: quickly build application
- Spring Cloud: build cloud native apps
- Spring Data: consistent data access
- Spring Integration: application integration
- Spring Batch: batch application
- Spring Security: protect your application
- ...

## Why Spring?

- it enables testable code. With JUnit, Mockito...
- There is no plumbing code: makes your code simple and clear.
- Flexible architecture. Lots of projects and modules.
- Staying current.

## Bean Scope

- singleton: One instance per Spring Context. Default.
- prototype: New bean whenever requested. @Scope("prototype") or @Scope(ConfigurableBeanFactory.SCOPE.PROTOTYPE) below @Component
- request: One bean per HTTP request
- session: One bean per HTTP session
- You ought to keep minimum number of instances.

## DAO

- Data Access Object

## GOF

- Gang of Four Design Patterns in Java. It refers design patterns which were defined by four authors: Erich Gamma, Richard Helm, Ralph Johnson and John Vlissides in their book Design Patterns: Elements of Reusable Object-Oriented Software.

## Difference betwoen GOF singletone and Spring singletone

- GOF singletone is "one instance in JVM" while Spring singletone is "one instance per Spring Context.

## What if spring applcation scan components in other package(s)?

- @ComponentScan("com.root.to.package")

## Bean Lifecycle

- @PostConstruct
- @PreDestroy

## CDI

- JAVA EE Dependency Injection Standard (JSR-330)
- Spring supports most anntations
    - @Inject: @Autowired
    - @Named: @Component & @Qualifier
    - @Singleton: @Scope

## Very basic two dependencies

```
<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-core</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-context</artifactId>
		</dependency>
```

## Spring without Spring Boot

- @SpringBootApplication => @Configuration & @ComponentScan
- You cannot SpringApplication.run() to get application context.
- Instead, you will do 
```
new AnnotationConfigApplicationContext(ContextClass.class)
```
- And, you need to edit pom.xml

## XML setting for application context(without Spring Boot)

- https://docs.spring.io/spring/docs/3.0.x/spring-framework-reference/html/beans.html
- In case ling changes, google spring documentation application context example

## How are they different from each other? - Disambiguation

- IOC Container: Program or framework provide IOC.
- Application Context
    - In Spring, there are two implementation of IOC Container. Application context is one of them.
    - It is actually Bean Factory++
        - Spring's AOP features
        - Intenationallization: I18n capabilities. Like currency, language kind of locale stuffs.
        - WebApplicationContext for web applications etc.
- Bean Factory
    - It only provides basic contols of beans.

## Few more annotations for components

- @Component: Generic Component.
- @Repository: encapsulating storage, retrieval and search behavior typically from a relational datbase.
- @Service: Buisness Service Facade or Buisness Logic.
- @Controller: Controller in MVC pattern.

## To read values from property file

- @Value("${value.name}") from component side
- @PropertySource("classpath:property.file.name")

## Let's take a look at Maven

- POM stands for Projects Object Model
- Meven has a lifecycle
    - Validate: checks if pom.xml and codes are valid
    - Compile: compiles main codes and test codes
    - Test: unit test
    - Package: it will create jar
    - Integration Test
    - Verify
    - Install: install artifacts to local storage
    - Deploy: to remote maven repository
- If you do "mvn clean install" then it will do all the lifecycle up to Install.
- You must follow the structure for maven. You can search it (or your IDE will do this).
- Local Repository: Repository on your local system. It's like cache for remote mvn repo.
- Remote Maven Repository: Central Repositories. It stores all the versions of all dependencies.
- You can google and add dependencies to your pom.xml.
- mvn --version check version
- "clean" cleans up previous files. mvn clean: deletes target directory.
- mvn compile: just validate and compile.
- mvn test-compile: compiles source coes and test codes.
- mvn package: create a jar
- mvn test: all the unit tests will run(up to test: compile and test)
- help:effective-settings: will show all the mvn settings
- help:effective-pom: it will print pom and its super poms
- dependency:tree
- dependency:sources
- --debug: provides details for debugging

## JUnit

- Unit test: testing a specific method or group of methods
- Screen test: testing total deployment
- Junit is a framework that helps us to do unit test.
- As Junit is automated it's convenient to run test.
