/*
attaches additional responsibilities to an object dinamically.
provides a flexible alternative to subclassing for extending functionality.
*/

abstract class Beverage {
	abstract var description: String

	fun printDescription() {
		println(this.getDescriptionVar() + " $" + cost().toString())
	}

	open fun getDescriptionVar(): String {
		return description
	}

	abstract fun cost(): Float
}


// concrete base Beverages

class Espresso : Beverage() {
	override var description: String = "Espresso"

	override fun cost(): Float {
		return 1.99f
	}
}

class DarkRoast : Beverage() {
	override var description: String = "Dark Roast Coffee"

	override fun cost(): Float {
		return 0.99f
	}
}


// condiment Decorators

abstract class CondimentDecorator : Beverage() {
	override var description: String = "Beverage decorator"
}

class Mocha(beverage: Beverage) : CondimentDecorator() {
	var beverage: Beverage
	override var description: String = "Mocha"

	init {
		this.beverage = beverage
	}

	override fun getDescriptionVar(): String {
		return beverage.getDescriptionVar() + " " + this.description
	}

	override fun cost(): Float {
		return 0.20f + beverage.cost()
	}
}


fun main() {
	var espresso = Espresso()
	espresso.printDescription()

	var darkRoast = DarkRoast()
	darkRoast.printDescription()
	
	var darkMocha = Mocha(darkRoast)
	darkMocha.printDescription()
}