package org.uqbar.arena.kotlin.extensions

import org.uqbar.arena.layout.ColumnLayout
import org.uqbar.arena.layout.HorizontalLayout
import org.uqbar.arena.layout.Layout
import org.uqbar.arena.layout.VerticalLayout
import org.uqbar.arena.widgets.Panel
import java.lang.reflect.Field

/**
 * Caption (making it public)
 *  - setter
 *  - getter
 */

val panelLayoutField: Field = Panel::class.java.getDeclaredField("layout")

var Panel.layout: Layout
    set(value) {
        this.setLayout(value)
    }
    get() {
        panelLayoutField.isAccessible = true
        return panelLayoutField.get(this) as Layout
    }

fun Panel.vertical(): Panel {
    this.layout = VerticalLayout()
    return this
}

fun Panel.horizontal(): Panel {
    this.layout = HorizontalLayout()
    return this
}

infix fun Panel.columns(num: Int): Panel {
    this.layout = ColumnLayout(num)
    return this
}
