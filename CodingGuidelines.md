# Coding Guidelines
## Class/Method/... sizes
<li>Class: 
    <ul> 
        <li>~150 lines of code (with comments)</li>
        <li>1 to 7 methods</li>
        <li>1 to n constructors</li>
    </ul>
</li>

## Constructors
<li>The lowest constructor is the primary constructor. Every constructor above is
a secondary constructor.</li>

## Rules
<li>Every class has an underlying interface</li>
<li>Inheritance is only used for envelopes</li>
<li>Every class is final, besides the envelopes</li>
<li>Envelopes are the only classes that are abstract</li>
<li>Every variable that can be final, is final (except the parameters)</li>

## Immutability  
A class is immutable if it fulfills the following requirements:
<ol>
    <li>By itself doesn't change its state</li>    
    <li>Doesn't return a reference to its to state so that it can be changed</li>    
    <li>Is final (no subclasses possible)</li>    
</ol>

<p>Howevery, a class that accepts a mutable reference from outside and takes it as its own
state, is considered immutable, even if the user can change the state of the object
by using this reference that he supplied.  The user is adviced to pass the reference
without holding it afterwards.</p>

<li>Every class states whether it is immutable or not</li>
<li>An immutable class is thread-safe</li>
<li>An immutable class can be mutable, as long as it seems immutable to the outside world,
by beeing thread-safe and by not appearing mutable. Example: A class that uses
Lazy, can be made immutable</li>

## Comments


## Envelopes
This project relies heavily on decorators instead of inheritance. Since java doesn't
have build in support for decorators, envelopes are used.

Envelopes are abstract classes that are build like this:
```java
public abstract class SomeEnvelope implements Some {
    private final Lazy<Some<T>> lazySome;
    
    public SomeEnvelope(Lazy<Some<T>> lazySome) {
        this.lazySome = lazySome;
    }
    
    @Override
    public final void someMethod() {
        lazySome.value().someMethod();
    }
    
    // Other methods from Some...
}
```
An envelope implements all the methods from a certain interface and delegates all the
calls to a lazy class that has the actual functionality.  
Decorators can now extend this envelope and put a customized version of the
implementation in a Lazy without needing to override all the methods from the
interface.  
Example:
```java
public final class SomeDecorator extends SomeEnvelope {
    public SomeDecorator() {
        super(
                new Lazy<T>(
                        () -> {
                            final var some = new SomeImplementation();
                            // Do some changes to the implementation
                            return some;
                        }
                )
        );
    }
    
    // No need to override the methods, because the envelope already did that.
}
```