package lmller.github.io.gofkotlin.observer

import java.util.ArrayList
import kotlin.properties.Delegates

typealias PropertyChangeListener = (Int) -> Unit

class Property {

    private val listeners = arrayListOf<PropertyChangeListener>()

    var value by Delegates.observable(0) { prop, old, new ->
        listeners.forEach { listener -> listener(new) }
    }

    fun registerListener(listener: PropertyChangeListener) {
        listeners.add(listener)
    }
}

fun main(args: Array<String>) {
    val property = Property()
    property.registerListener { new -> println("The new value is $new") }

    property.value = 1989
}