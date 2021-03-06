package org.uqbar.arena.kotlin.extensions

import org.uqbar.arena.widgets.Control
import org.uqbar.lacar.ui.model.ControlBuilder
import org.uqbar.lacar.ui.model.bindings.Binding
import org.uqbar.arena.bindings.ObservableProperty

/**
 * Accessors
 */

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

var Control.align: String?
    get() = null
    set(value) {
        value?.let { this.align(it) }
    }

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

fun Control.bindBackgroundToModel(model: Any, propertyName: String): ControlBinding =
        this.bindBackground<ControlBuilder, Any, Any>(ObservableProperty<Any>(model, propertyName))

infix fun Control.bindBackgroundTo(propertyName: String): ControlBinding =
        this.bindBackgroundToProperty<ControlBuilder, Any, Any>(propertyName)

/**
 * Binding Enabled
 *  - bindEnabled
 *  - bindEnabledToProperty
 */
fun Control.bindEnabledToModel(model: Any, propertyName: String): ControlBinding =
        this.bindEnabled<Any, ControlBuilder>(ObservableProperty(model, propertyName))

infix fun Control.bindEnabledTo(propertyName: String): Binding<out Any, Control, ControlBuilder> =
        this.bindEnabledToProperty(propertyName)

/**
 * Binding Foreground
 *  - bindForeground
 *  - bindForegroundToProperty
 */

fun Control.bindForegroundToModel(model: Any, propertyName: String): ControlBinding =
        this.bindForeground<ControlBuilder, Any, Any>(ObservableProperty<Any>(model, propertyName))

infix fun Control.bindForegroundTo(propertyName: String): ControlBinding =
        this.bindForegroundToProperty<ControlBuilder, Any, Any>(propertyName)

fun Control.bindColorToModel(model: Any, propertyName: String) =
        this.bindForegroundToModel(model, propertyName)

infix fun Control.bindColorTo(propertyName: String) =
        this.bindForegroundTo(propertyName)


/**
 * Binding Values
 *  - bindValue
 *  - bindValueToProperty
 */

fun Control.bindToModel(model: Any, propertyName: String): ControlBinding =
        this.bindValue<Any, ControlBuilder>(ObservableProperty(model, propertyName))

infix fun Control.bindTo(propertyName: String): ControlBinding =
        this.bindValueToProperty<Any, ControlBuilder>(propertyName)

/**
 * Binding Visible
 *  - bindVisibleToModel
 *  - bindVisibleToProperty
 */

fun Control.bindVisibleToModel(model: Any, propertyName: String): ControlBinding =
        this.bindVisible(ObservableProperty<Any>(model, propertyName))

infix fun Control.bindVisibleTo(propertyName: String): ControlBinding =
        this.bindVisibleToProperty(propertyName)


/**
 * Not Extensions needed for:
 *  - background
 *  - enabled
 *  - foreground
 *  - tooltip
 *  - setHeight
 *  - setWidth
 *  - value
 *  - visible
 */
