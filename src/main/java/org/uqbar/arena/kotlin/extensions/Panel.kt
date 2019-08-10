package org.uqbar.arena.kotlin.extensions

import java.lang.reflect.Field
import org.uqbar.arena.layout.Layout
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.GroupPanel
import org.uqbar.arena.layout.ColumnLayout
import org.uqbar.arena.layout.VerticalLayout
import org.uqbar.arena.layout.HorizontalLayout

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

fun Panel.asVertical(): Panel {
    this.layout = VerticalLayout()
    return this
}

fun Panel.asHorizontal(): Panel {
    this.layout = HorizontalLayout()
    return this
}

infix fun Panel.asColumns(amount: Int): Panel {
    this.layout = ColumnLayout(amount)
    return this
}

/**
 * Group Panel
 */

val groupPanelTitleField: Field = GroupPanel::class.java.getDeclaredField("title")

var GroupPanel.title: String
    set(value) {
        this.setTitle(value)
    }
    get() {
        groupPanelTitleField.isAccessible = true
        return groupPanelTitleField.get(this) as String
    }
