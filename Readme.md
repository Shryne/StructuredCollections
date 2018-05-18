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

```
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

