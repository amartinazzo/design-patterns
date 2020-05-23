/*
ensures a class has only one instance.
provides a global point of access to it.

thread pools, caches, dialog boxes


Lazy Singleton:		creates instance only if invoked
Eager Singleton:	creates instance when class is loaded

instance getter must be synchronized
(no two threads can enter the getter method at the same time)

*/


object Singleton {
	init {
		println("Singleton class invoked")
	}

	fun callMe() {
		println("i was called")
	}

}


fun main() {
	Singleton.callMe()
}