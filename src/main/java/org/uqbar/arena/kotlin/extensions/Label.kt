package org.uqbar.arena.kotlin.extensions

import org.uqbar.arena.bindings.ObservableProperty
import org.uqbar.arena.bindings.observables.ViewObservables
import java.lang.reflect.Field
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.Widget
import org.uqbar.arena.graphics.Image
import org.uqbar.lacar.ui.model.WidgetBuilder
import org.uqbar.lacar.ui.model.bindings.Binding

/**
 * Text extension (make it public)
 *  - setter
 *  - getter
 */

val textField: Field = Label::class.java.getDeclaredField("text")

var Label.text: String
    set(value) {
        textField.isAccessible = true
        textField.set(this, value)
    }
    get() {
        textField.isAccessible = true
        return textField.get(this) as String
    }

/**
 * Binding Background
 *  - bindBackground
 *  - bindBackgroundToProperty
 */

infix fun Label.bindImageTo(propertyName: String): Binding<*, Widget, WidgetBuilder> =
        this.bindImageToProperty<String>(propertyName) { prop -> Image(prop) }

fun Label.bindImageToModel(model: Any, propertyName: String): Binding<Any, Label, WidgetBuilder>? {
    return this.addBinding(
            ObservableProperty<Any>(model, propertyName),
            ViewObservables.observableImage<Label, String>(this, { prop -> Image(prop) })
    )
}

/**
 * alias to make "Texted" Labels simplest
 */

infix fun Label.withText(text: String): Label {
    this.text = text
    return this
}
