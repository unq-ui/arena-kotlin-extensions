package org.uqbar.arena.kotlin.extensions

import java.lang.reflect.Field
import org.uqbar.arena.widgets.Control
import org.uqbar.lacar.ui.model.ControlBuilder
import org.uqbar.lacar.ui.model.bindings.Binding
import org.uqbar.arena.bindings.ObservableProperty


var Control.width: Int?
    get() = null
    set(value) {
        value?.let { this.setWidth(it) }
    }

var Control.height: Int?
    get() = null
    set(value) {
        value?.let { this.setHeight(it) }
    }

/**
 * Infix functions
 */

infix fun Control.bind(paramName: String) = bindToProp(paramName)

/**
 * Align
 *  - alignCenter
 *  - alignLeft
 *  - alignRight
 */

infix fun Control.align(position: String): Control =
        when (position.toLowerCase()) {
            "left" -> this.alignLeft()
            "right" -> this.alignRight()
            "center" -> this.alignCenter()
            else -> this.alignLeft()
        }


/**
 * Binding Background
 *  - bindBackground
 *  - bindBackgroundToProperty
 */

fun Control.bindBackgroundTo(model: Any, propertyName: String): Binding<*, Control, ControlBuilder> =
        this.bindBackground<ControlBuilder, Any, Any>(ObservableProperty<Any>(model, propertyName))

fun Control.bindBackgroundToProp(propertyName: String): Binding<*, Control, ControlBuilder> =
    this.bindBackgroundToProperty<ControlBuilder, Any, Any>(propertyName)

/**
 * Binding Enabled
 *  - bindEnabled
 *  - bindEnabledToProperty
 */
fun Control.bindEnabledTo(model: Any, propertyName: String): Binding<*, Control, ControlBuilder> =
        this.bindEnabled<Any, ControlBuilder>(ObservableProperty(model, propertyName))

fun Control.bindEnabledToProp(propertyName: String): Binding<*, Control, ControlBuilder> =
        this.bindEnabledToProperty(propertyName)

/**
 * Binding Foreground
 *  - bindForeground
 *  - bindForegroundToProperty
 */

fun Control.bindForegroundTo(model: Any, propertyName: String): Binding<*, Control, ControlBuilder> =
        this.bindForeground<ControlBuilder, Any, Any>(ObservableProperty<Any>(model, propertyName))

fun Control.bindForegroundToProp(propertyName: String): Binding<*, Control, ControlBuilder> =
        this.bindForegroundToProperty<ControlBuilder, Any, Any>(propertyName)

fun Control.bindColorTo(model: Any, propertyName: String) =
        this.bindForegroundTo(model, propertyName)

fun Control.bindColorToProp(propertyName: String) =
        this.bindForegroundToProp(propertyName)


/**
 * Binding Values
 *  - bindValue
 *  - bindValueToProperty
 */

fun Control.bindTo(model: Any, propertyName: String): Binding<*, Control, ControlBuilder> =
        this.bindValue<Any, ControlBuilder>(ObservableProperty(model, propertyName))

fun Control.bindToProp(propertyName: String): Binding<*, Control, ControlBuilder> =
        this.bindValueToProperty<Any, ControlBuilder>(propertyName)

/**
 * Binding Visible
 *  - bindVisible
 *  - bindVisibleToProperty
 */

fun Control.bindVisible(model: Any, propertyName: String): Binding<*, Control, ControlBuilder> =
        this.bindVisible<ControlBuilder>(ObservableProperty<Any>(model, propertyName))

fun Control.bindVisibleToProp(propertyName: String): Binding<*, Control, ControlBuilder> =
        this.bindVisibleToProperty<ControlBuilder>(propertyName)


/**
 * Not Extensions for:
 *  - background
 *  - enabled
 *  - foreground
 *  - tooltip
 *  - setHeight
 *  - setWidth
 *  - value
 *  - visible
 */