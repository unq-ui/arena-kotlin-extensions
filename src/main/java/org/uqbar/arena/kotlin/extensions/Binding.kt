package org.uqbar.arena.kotlin.extensions

import org.uqbar.arena.widgets.Control
import org.uqbar.lacar.ui.model.ControlBuilder
import org.uqbar.lacar.ui.model.bindings.Binding

typealias ControlBinding = Binding<*, out Control, out ControlBuilder>

inline fun <reified T: Any> ControlBinding.adaptWithProp(property: String): ControlBinding =
        this.adaptWith(T::class.java, property)
