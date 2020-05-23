/*
factory method:
defines an interface for creating an object,
but lets subclasses decide which class to instantiate.
lets a class defer instantiation to subclasses.

abstract factory:
defines an interface for creating families of
related or dependent objects
without specifying their concrete classes.
*/


// Factory method


// Pizzas

interface Pizza {
	fun prepare()
	fun bake() = println("baking")
	fun box() = println("boxing")
}

class VeganPizza : Pizza {
	override fun prepare() = println("adding cashew cheese")
}

class OvolactoPizza : Pizza {
	override fun prepare() = println("adding cow cheese")
}


// Pizza factory

class PizzaFactory {
	fun createPizza(type: String): Pizza {
		if(type=="vegan") {
			return VeganPizza()
		} else {
			return OvolactoPizza()
		}
	}
}


// Pizza store that uses factory to create pizzas

class PizzaStore(factory: PizzaFactory) {
	var factory: PizzaFactory

	init {
		this.factory = factory
	}

	fun orderPizza(type: String): Pizza {
		var pizza: Pizza = factory.createPizza(type)
		pizza.prepare()
		pizza.bake()
		pizza.box()
		return pizza
	}
}

/*

TODO: Abstract Factory

interface PizzaIngredientFactory {
	fun createDough()
	fun createSauce()
	fun createCheese()
	fun createVeggies()
}


abstract class Pizza {
	var name: String
	var dough: Dough
	var sauce: Sauce
	var veggies: Veggies
}

class SPIngredientFactory : PizzaIngredientFactory {
	override fun createDough() {
		return ThinDough()
	}

	override fun createSauce() {
		return TomatoSauce()
	}

	override fun createVeggies() {
		return 
	}
}

*/


fun main() {
	var factory = PizzaFactory()
	var store = PizzaStore(factory)
	store.orderPizza("vegan")
	store.orderPizza("other")
}