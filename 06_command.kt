/*
encapsulates a request as an object, letting other objects
be parameterized with different requests, queue or log requests.
supports undoable operations.
*/


interface Command {
	fun execute()
	fun undo()
}


interface Receiver {
	fun on()
	fun off()
}


class Light : Receiver {
	override fun on() = println("light is on")
	override fun off() = println("light is off")
}


// concrete Commands

class NullCommand : Command {
	override fun execute() {}
	override fun undo() {}
}


class LightOnCommand(var light: Light) : Command {
	override fun execute() {
		light.on()
	}

	override fun undo() {
		light.off()
	}
}


// remote control (invoker)

class RemoteControl() {
	var cmd: Command = NullCommand()
	var lastCmd: Command = NullCommand()

	fun setCommand(command: Command) {
		cmd = command
	}

	fun buttonWasPressed() {
		lastCmd = cmd
		cmd.execute()
	}

	fun undoButtonWasPressed() {
		lastCmd.undo()
	}
}


fun main() {
	var remote = RemoteControl()
	var light = Light()
	var lightOn = LightOnCommand(light)

	remote.setCommand(lightOn)
	remote.buttonWasPressed()
	remote.undoButtonWasPressed()
}