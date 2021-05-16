# Working with Streams and Lambda Expressions

## Lambda expressions
- A Lambda Expressions is an anonymous method which you can pass to other methods
- Passing code as data is the main concept of functional programming
- basic syntax is as follows

```
(p1, p2)            ->            p1.getValue() > p2.getValue()
Parameter list      Arrow sign    Body
```

- expanded form includes parameter types, curly braces and semicolons
  
```
(String s) -> { return s.compareTo("Hello, world"); }
```

- short form leaves out parameter types, curly braces and semicolons

```
s -> s.compareTo("Hello, world")
```

- lambda expression implements a functional interface
- captured local variables must be `final` or at least effectively `final`
- keywords `this` and `super` mean the same as in the surrounding code
- it's not possible to define member variables in a lambda expression 
- checked exceptions need to be handled within a lambda expression
- lambda expressions should avoid side effects


## Method references
- Syntax uses `::` to refer to method references
- There are four types of method references


| **type** | **syntax** | **example** |  
------ | ------ | --------- 
| static methods | `ClassName::methodName` | `Arrays::asList` |  
| instance methods of specific objects | `objectReference::methodName` | `System.out::println` |  
| instance methods of no specific objects | `ClassName::methodName` | `LocalDateTime::getYear` |  
| constructors | `ClassName::new` | `File::new` |  


## Functional Interfaces
- functional interfaces are interfaces with a single abstract method (SAM)
- Standard functional interfaces are located in `java.util.function`
- functional interfaces can be annotated with `@FunctionalInterface`
- Examples
  - `java.util.Function`
  - `java.util.Consumer`
  - `java.util.Supplier`
  - `java.util.Predicate`
  - `java.util.UnaryOperator`
  - `java.util.BiFunction`
  - `java.util.BiConsumer`
  - `java.util.BiPredicate`
- Other examples    
  - `java.util.Comparator`
  - `java.lang.Runnable`
  - `java.io.FileFilter`
  - `java.awt.event.ActionListener`
- [Documentation](https://docs.oracle.com/javase/8/docs/api/java/util/function/package-summary.html)  


## Streams
- stream operations are divided into intermediate and terminal operations 
- they can be combined to form stream pipelines 
- a stream pipeline consists of 
  - a source (such as a Collection, an array, a generator function, or an I/O channel)
  - zero or more intermediate operations such as `Stream.filter` or `Stream.map`
  - a terminal operation such as `Stream.forEach` or `Stream.reduce`
- intermediate operations return a new stream and are always lazy
- executing an intermediate operation such as `filter` does not actually perform any filtering, but instead creates a new stream that, when traversed, contains the elements of the initial stream that match the given predicate
- traversal of the pipeline source does not begin until the terminal operation of the pipeline is executed
- terminal operations don't return a new `Stream`

| **operation type** | **examples** |  
------ | ------ 
| intermediate | `peek`, `filter`, `map` |  
| terminal | `forEach`, `sum`, `reduce`, `count`, `findFirst`, `anyMatch`, `allMatch` |  