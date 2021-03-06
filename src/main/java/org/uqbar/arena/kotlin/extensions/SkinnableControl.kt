package org.uqbar.arena.kotlin.extensions

import java.awt.Color
import java.lang.reflect.Field
import org.uqbar.arena.widgets.SkinnableControl


/**
 * Background & Foreground extension (making it public)
 *  - setter
 *  - getter
 */

val bgField: Field = SkinnableControl::class.java.getDeclaredField("background")
val fgField: Field = SkinnableControl::class.java.getDeclaredField("foreground")

var SkinnableControl.background: Color
    set(value) {
        bgField.isAccessible = true
        bgField.set(this, value)
    }
    get() {
        bgField.isAccessible = true
        return bgField.get(this) as Color
    }

var SkinnableControl.foreground: Color
    set(value) {
        fgField.isAccessible = true
        fgField.set(this, value)
    }
    get() {
        fgField.isAccessible = true
        return bgField.get(this) as Color
    }

// Alias for background
var SkinnableControl.bgColor: Color
    get() = background
    set(value) {
        background = value
    }

// Alias for foreground
var SkinnableControl.color: Color
    get() = foreground
    set(value) {
        foreground = value
    }

/**
 * Not needed Extensions for:
 *  - getFontSize
 *  - setFontSize
 */
