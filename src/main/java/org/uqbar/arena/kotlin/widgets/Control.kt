package org.uqbar.arena.kotlin.widgets

import org.uqbar.arena.kotlin.extensions.*
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.Control as UqControl

abstract class Control<U: UqControl>(private val panel: Panel) {
    abstract val content: Control<U>
    protected abstract val adapter: U

    var align: String? = null
        set(value) {
            field = value
            value?.let { adapter align it }
        }
    var width: Int? = null
        set(value) {
            field = value
            value?.let { adapter width it }
        }
    var height: Int? = null
        set(value) {
            field = value
            value?.let { adapter height it }
        }


    infix fun width(size: Int) { width = size }
    infix fun height(size: Int) { height = size }
    infix fun align(position: String) { align = position }
    infix fun bindTo(propName: String) = adapter bindTo propName
}