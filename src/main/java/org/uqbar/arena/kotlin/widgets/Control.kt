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
    infix fun bindColorTo(propName: String) = adapter bindColorTo propName
    infix fun bindEnabledTo(propName: String) = adapter bindEnabledTo propName
    infix fun bindVisibleTo(propName: String) = adapter bindVisibleTo propName
    infix fun bindBackgroundTo(propName: String) = adapter bindBackgroundTo propName

    fun bindToModel(model: Any, propName: String) = adapter.bindToModel(model, propName)
    fun bindColorToModel(model: Any, propName: String) = adapter.bindColorToModel(model, propName)
    fun bindEnabledToModel(model: Any, propName: String) = adapter.bindEnabledToModel(model, propName)
    fun bindVisibleToModel(model: Any, propName: String) = adapter.bindVisibleToModel(model, propName)
    fun bindBackgroundToModel(model: Any, propName: String) = adapter.bindBackgroundToModel(model, propName)
}
