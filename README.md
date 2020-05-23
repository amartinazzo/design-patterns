## design patterns in Kotlin

code can be compiled and run using the Makefile run method and passing the filename (without its extension) as an argument:

```
make run f=01_strategy
```

(kotlin and java must be installed)


## some notes

* HAS-A (composition) can be better than IS-A (inheritance)

* open-closed principle: classes should be open for extension, but closed for modification

* dependency inversion principle: depend upon abstractions, not concrete classes
	* no variable should hold a reference to a class

	* no class should derive from a concrete class

	* no method should override an implemented method of any of its base classes

* Null Object (an object that does nothing) can be used to avoid handling null