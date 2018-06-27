# StructuredCollections

![SonarQube Build pass](https://sonarcloud.io/api/project_badges/measure?project=de.shryne.structured-collections%3Astructured-collections&metric=alert_status)
![SonarQube Coverage](https://sonarcloud.io/api/project_badges/measure?project=de.shryne.structured-collections%3Astructured-collections&metric=coverage)
![SonarQube Maintability](https://sonarcloud.io/api/project_badges/measure?project=de.shryne.structured-collections%3Astructured-collections&metric=sqale_rating)

## Why?

I started this project, because I was angry about the giant classes in the java standard library. Many of them take thousand of lines of
code within a class hierarchy over 4 levels and more to get even more lines inside a single class. I wondered why my classes usually don't
use any implementation inheritance and take less than 200 hundred lines of code (comments included). Maybe it's just harder to write for
example a collection without exceeding this boundary so I started this to see, if that's the reason.

## Problems and solutions

### 1) Fat interfaces
Example: The list interface. To create your own list implementation one needs to implement at least 23 methods, even if some of them aren't
needed. This means the interfaces forces me to make a big class, because a list is something very complex and big in the java world based
on this interface.
Furthermore I can't implement an immutable list based on the list interface, because some methods don't have the right signature
for this (void add(...)). There is the possibility though to throw an "UnsupportedOperation" Exception and there is even an imutable list
implementation in the standard library doing this, but that's only a workaround.

Solution: Small Interfaces. Get, set and size are inside their own interfaces and the basic implementation of list supports only this
operations. Everything else needs to be added by decorating it.
Example:

```java
// instead of:
new ArrayList<>(Arrays.asList(1, 2, 3, 4)).addAll(
      Arrays.asList(5, 6, 7, 8)
);

// this:
new ConcatList<>(
      new List<>(1, 2, 3, 4),
      new List<>(5, 6, 7, 8)
);
```

### 2) Null, -1, ...
Example: indexOf. If you want to get the index of the element, but the element isn't inside the collection, you get a -1. This leads to code like this:
```java
final int index = list.indexOf(5);
if (index != -1) {
      // do my stuff.
}

// Sometimes even worse:
try {
      doStuff(list.indexOf(5);
} catch (IndexOutOfBounds e) {}
```
That's ugly, procedural and it gives the user the flexibility to do mistakes. Alternative:
```java
new IndexOf(list, 5).apply(
      index -> // gets the call only if the element is actually present
);
```

### 3) Big classes
The collection classes have around thousand lines of code and multiple classes in their inheritance hierarchy. This isn't a necessarily a problem if everything works, but if one needs or wants to look for some functionality inside them, it will be quite difficult.

The classes of this library have mostly less than 100 lines per class and no implementation inheritance is used. 

### 4) Lack of flexibility
Unfortunately there aren't many constructors in the collection classes. ArrayList for example offers three: An empty for an empty list, a Collection<E> constructor to take the elements from another collection and one to specify the initial capacity.  
What about a normal array? An ArrayList with one element? A an iterable? Why does one constructor take collections, when it uses them to get the iterator, but I can't simply construct an ArrayList with an iterable or an iterator.  

In this collection, it's possible:
```java
new ListOf<>(); // empty list
new ListOf<>(1); // list with one element
new ListOf<>(
      new IterableOf<>(5, 2, 33, 4)
); // four elements from an iterable
new ListOf<>(
      new ListOf<>(...)
); // list from another collection
new ListOf<>(
      new Iterator<>(...)
); // from iterator
```
All the classes have multiple constructors to offer much flexibility to create the objects needed and there is at least one constructor that is able to initial every attribute.  

## Things I've learned
1) Writting secondary or primary constructor everywhere or explaining what an envelope is, is just a waste of time. It would be better to add coding guideless for such general cases.
2) I should always write the java docs at the moment I created something new. Otherwise I will have a giant push where I just spend hours to add the documentation.
3) Generally it's no pleasure to write comments, because there so many duplications of them.
4) I am not sure how I should deal with comments based on internal behaivior. For example it could be interesting for the user whether an object is lazy, only once constructed or actually never really transformed (performance wice), but that's something I would maybe change afterwards and then I would've to change the comment, too.
5) Sometimes I threw exceptions even though java would've thrown them anyway. Example: My vector is based on an array and even though an array throws an ArrayIndexOutOfBoundsException in case of an illegal index, I check for it and throw an exception myself. I think I shouldn't do it.
6) I should take care about my IDE settings. It would've helped me, if i didn't need to copy my license comments to everywhere.
7) I should read some books about tests or look inside of github for some examples, because I feel like there is a lot duplication around it. It may be also that it just looks like duplication, but is infact non related.
8) I should look for the matchers. Hopefully they give me more information if a tests fails. Just using asserts isn't always fun.
9) At the beginning I often thought that I couldn't do certain things, because it would cost to much performance. This hindered me enormously. Later when I started to ignore that and thought more about just doing it the design, I got better and noticed, how certain decisions were even better than I expected.
10) Generally it helps a lot creating really small classes. Making them bigger afterwards is easy and that's something that happens anyway in most software projects, but keeping them small is difficult. If they are actually small, testing, locality, decoration and the whole design will get much better.
11) Varargs is a very dangerous feature and there were multiple cases, where I had problems dealing with it. I am thinking about removing it from my code, because it can also lead to problems on the client side.
12) If all methods are defined in interfaces, there is a temptation to create "impl" classes. Example: I have a List interface that defines an immutable list and one implementation of it. I called the implementing class "ListOf", but I think the name is bad, because it seems unnatural to say: "This object is a ListOf". Instead, a better name would be ListView, because it is only a view to a list (a mutable list). Alternatively I could have called the interface ImmutableList and the implementation List, but that's unsatisfying. 
