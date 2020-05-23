/*
defines a one-to-many dependency between objects so that
when one object changes state, all of its
dependents are notified and updates automatically.

subject owns the state
observers use the state

push vs pull state (pull is preferred)
*/


// Subject interface

interface Subject {
	fun registerObserver(o: Observer)
	fun removeObserver(o: Observer)
	fun notifyObservers()
}


// Observer interface

interface Observer {
	fun update(temperature: Float, humidity: Float, pressure: Float)
}


interface DisplayElement {
	fun display()
}


// Subject implementation

class WeatherData : Subject {
	var observers: MutableList<Observer> = mutableListOf()
	var temperature: Float = 0.0f
	var humidity: Float = 0.0f
	var pressure: Float = 0.0f

	override fun registerObserver(o: Observer) {
		observers.add(o)
	}
	
	override fun removeObserver(o: Observer) {
		var i: Int = observers.indexOf(o)
		if(i>=0) {
			observers.removeAt(i)
		}
	}

	override fun notifyObservers() {
		for(i in 0..observers.count()-1) {
			var observer = observers.get(i)
			observer.update(temperature, humidity, pressure)
		}
	}

	fun measurementsChanged() = notifyObservers()

	fun setMeasurements(temperature: Float, humidity: Float, pressure: Float) {
		this.temperature = temperature
		this.humidity = humidity
		this.pressure = pressure
		measurementsChanged()
	}

	fun getT(): Float {
		return this.temperature
	}
	
	fun getH(): Float {
		return this.humidity
	}
	
	fun getP(): Float {
		return this.pressure
	}
}


// Observers implementation

class CurrentConditionsDisplay(weatherData: WeatherData) : Observer {
	var temperature: Float = 0.0f
	var humidity: Float = 0.0f
	var weatherData: WeatherData

	init {
		this.weatherData = weatherData
		this.weatherData.registerObserver(this)
	}

	override fun update(temperature: Float, humidity: Float, pressure: Float) {
		this.temperature = this.weatherData.getT()
		this.humidity = this.weatherData.getH()
		println("current conditions display")
		println("temperature: %.1f C".format(this.temperature))
		println("humidity: %.1f".format(this.humidity))
	}
}


fun main() {
	var weatherData = WeatherData()
	var currentDisplay = CurrentConditionsDisplay(weatherData)
	// more displays can be added

	weatherData.setMeasurements(25.0f, 80.0f, 30.4f)

}