/* 
defines a family of algorithms, encapsulates each,
and makes them interchangeable.
*/


// Fly Behaviors

interface FlyBehavior {
	fun fly()
}

class FlyWithWings : FlyBehavior {
	override fun fly() = println("i fly!")
}

class NoFly : FlyBehavior {
	override fun fly() = println("i don't fly")
}


// Quack Behaviors

interface QuackBehavior {
	fun quack()
}

class Quack : QuackBehavior {
	override fun quack() = println("quack")
}

class MuteQuack : QuackBehavior {
	override fun quack() = println("<< silence >>")
}


// abstract Duck class

abstract class Duck {
	abstract var flyBehavior: FlyBehavior
	abstract var quackBehavior: QuackBehavior

	abstract fun display()

	fun performFly() = flyBehavior.fly()
	fun performQuack() = quackBehavior.quack()
	fun swim() = println("all ducks swim")

	fun setFlyBehaviorVar(b: FlyBehavior) {
		flyBehavior = b
	}

	fun setQuackBehaviorVar(b: QuackBehavior) {
		quackBehavior = b
	}
}


// concrete Duck classes

class MallardDuck : Duck() {
	override var quackBehavior: QuackBehavior = Quack()
	override var flyBehavior: FlyBehavior = FlyWithWings()

	override fun display() = println("i am a real Mallard duck")
}


fun main() {
	var mallard = MallardDuck()
	mallard.performQuack()
	mallard.performFly()

	mallard.setQuackBehaviorVar(MuteQuack())
	mallard.performQuack()
}