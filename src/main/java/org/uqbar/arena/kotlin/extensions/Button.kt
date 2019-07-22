package org.uqbar.arena.kotlin.extensions

import java.lang.reflect.Field
import org.uqbar.arena.widgets.Button
import org.uqbar.lacar.ui.model.ButtonBuilder
import org.uqbar.lacar.ui.model.bindings.Binding


/**
 * Caption (making it public)
 *  - setter
 *  - getter
 */

val buttonCaptionField: Field = Button::class.java.getDeclaredField("caption")

var Button.text: String
    set(value) {
        buttonCaptionField.isAccessible = true
        buttonCaptionField.set(this, value)
    }
    get() {
        buttonCaptionField.isAccessible = true
        return buttonCaptionField.get(this) as String
    }

/**
 * Binding
 *  - bindCaptionToProperty
 */

infix fun Button.bindCaptionTo(propertyName: String): Binding<*, Button, ButtonBuilder> =
        this.bindCaptionToProperty(propertyName)

/**
 * onClick
 * setAsDefault
 * disableOnError
 * bindCaptionToProperty
 */
