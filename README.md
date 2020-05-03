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