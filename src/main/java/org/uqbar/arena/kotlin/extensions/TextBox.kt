package org.uqbar.arena.kotlin.extensions

import java.lang.reflect.Field
import org.uqbar.arena.widgets.NumericField


val withDecimalsCaptionField: Field = NumericField::class.java.getDeclaredField("withDecimals")

var NumericField.withDecimals: Boolean
    set(value) {
        withDecimalsCaptionField.isAccessible = true
        withDecimalsCaptionField.set(this, value)
    }
    get() {
        withDecimalsCaptionField.isAccessible = true
        return withDecimalsCaptionField.get(this) as Boolean
    }

