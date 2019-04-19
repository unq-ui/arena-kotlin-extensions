package org.uqbar.arena.kotlin.extensions

import java.awt.Color
import java.lang.reflect.Field
import org.uqbar.arena.widgets.SkinnableControl


/**
 * Background extension (make it public)
 *  - setter
 *  - getter
 */

val bgField: Field = SkinnableControl::class.java.getDeclaredField("background")
val fgField: Field = SkinnableControl::class.java.getDeclaredField("foreground")

var SkinnableControl.background: Color?
    set(value) {
        bgField.isAccessible = true
        bgField.set(this, value)
    }
    get() {
        bgField.isAccessible = true
        return bgField.get(this) as Color
    }

var SkinnableControl.foreground: Color?
    set(value) {
        bgField.isAccessible = true
        bgField.set(this, value)
    }
    get() {
        bgField.isAccessible = true
        return bgField.get(this) as Color
    }

/**
 * Not needed Extensions for:
 *  - getFontSize
 *  - setFontSize
 */