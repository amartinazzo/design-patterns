/*
converts the interface of a class into another interface that the clients expect.
*/


interface Duck {
	fun quack()
	fun fly()
}


interface Turkey {
	fun gobble()
	fun fly()
}


// concrete Turkey class

class JumpingTurkey : Turkey {
	override fun gobble() = println("i gobble")
	override fun fly() = println("i jump")
}


// Turkey adapter

class TurkeyAdapter(turkey: Turkey) : Duck {
	var turkey: Turkey = turkey

	override fun quack() = this.turkey.gobble()

	override fun fly() {
		for(i in 0..5) this.turkey.fly()
	}
}


fun main() {
	var turkey = JumpingTurkey()
	turkey.gobble()

	var turkeyDuck = TurkeyAdapter(turkey)
	turkeyDuck.quack()
}