package org.uqbar.arena.kotlin.extensions

import org.uqbar.arena.widgets.Spinner
import java.lang.reflect.Field

private val maxValueField: Field = Spinner::class.java.getDeclaredField("maximumValue")
private val minValueField: Field = Spinner::class.java.getDeclaredField("minimumValue")

var Spinner.maxValue: Int
    set(value) {
        maxValueField.isAccessible = true
        maxValueField.set(this, value)
    }
    get() {
        maxValueField.isAccessible = true
        return maxValueField.get(this) as Int
    }
var Spinner.minValue: Int
    set(value) {
        minValueField.isAccessible = true
        minValueField.set(this, value)
    }
    get() {
        minValueField.isAccessible = true
        return minValueField.get(this) as Int
    }