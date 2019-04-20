package org.uqbar.arena.kotlin.widgets

import java.awt.Color
import org.uqbar.arena.kotlin.extensions.*
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.SkinnableControl as UqSkinnableControl


abstract class SkinnableControl<U: UqSkinnableControl>(panel: Panel) : Control<U>(panel) {
    var fontSize: Int? = null
        set(value) {
            field = value
            value?.let { adapter.fontSize = it }
        }
    var color: Color? = null
        set(value) {
            field = value
            value?.let { adapter.foreground = it }
        }
    var bgColor: Color? = null
        set(value) {
            field = value
            value?.let { adapter.background = it }
        }

    infix fun color(aColor: Color) { color = aColor }
    infix fun bgColor(color: Color) { bgColor = color }
    infix fun fontSize(size: Int) { fontSize = size }
}
