package org.uqbar.arena.kotlin.extensions

import java.lang.reflect.Field
import org.uqbar.arena.widgets.Link
import org.uqbar.lacar.ui.model.ButtonBuilder
import org.uqbar.lacar.ui.model.bindings.Binding

/**
 * Caption (making it public)
 *  - setter
 *  - getter
 */

val linkCaptionField: Field = Link::class.java.getDeclaredField("caption")

var Link.caption: String
    set(value) {
        this.setCaption(value)
    }
    get() {
        linkCaptionField.isAccessible = true
        return linkCaptionField.get(this) as String
    }

// Alias for content
var Link.text: String
    set(value) {
        caption = value
    }
    get() = caption

/**
 * Binding
 *  - bindCaptionToProperty
 */

infix fun Link.bindCaptionTo(propertyName: String): Binding<*, Link, ButtonBuilder> =
        this.bindCaptionToProperty(propertyName)

