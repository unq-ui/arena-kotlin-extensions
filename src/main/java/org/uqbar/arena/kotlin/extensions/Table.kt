package org.uqbar.arena.kotlin.extensions

import java.awt.Color
import org.uqbar.arena.widgets.Control
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.Widget
import org.uqbar.arena.widgets.tables.Table
import org.uqbar.arena.widgets.tables.Column
import org.uqbar.arena.widgets.tables.labelprovider.BackgroundProvider
import org.uqbar.arena.widgets.tables.labelprovider.ForegroundProvider
import org.uqbar.arena.widgets.tables.labelprovider.PropertyLabelProvider
import org.uqbar.lacar.ui.model.ControlBuilder
import org.uqbar.lacar.ui.model.TableBuilder
import org.uqbar.lacar.ui.model.bindings.Binding

/**
 * Builder to write code as block:
 *
 *     table<Item>(mainPanel) { ... }
 */
inline fun <reified T> table(panel: Panel, noinline block: Table<T>.(Table<T>) -> Unit): Table<T> {
    return Table(panel, T::class.java) with block
}

/**
 * Builder to write code as block and with "with" (like components extensions):
 *
 *     table<Item>(mainPanel) with { ... }
 */
inline fun <reified T> table(panel: Panel): Table<T> {
    return Table(panel, T::class.java)
}

/**
 * Binding Items
 *  - bindItemsToProperty
 *  - bindSelectionToProperty
 */

infix fun Table<*>.bindItemsTo(propertyName: String): Binding<out MutableCollection<*>, out Table<*>, out TableBuilder<*>> =
        this.bindItemsToProperty(propertyName)

infix fun Table<*>.bindSelectionTo(propertyName: String): Binding<*, Control, ControlBuilder> =
        this.bindSelectionToProperty<ControlBuilder>(propertyName)

/**
 * Accessors
 *  - setNumberVisibleRows
 */

var Table<*>.visibleRows: Int
    get() = 0
    set(value) {
        this.setNumberVisibleRows(value)
    }

/**
 * Columns constructor inside Table block
 */

infix fun <T> Table<T>.column(block: Column<T>.(Column<T>) -> Unit) = Column(this) with block

/**
 * No needed
 *  - addColumn
 *  - setItemType
 *  - getItemType
 *  - getColumns
 */

/**
 * Column
 */

/**
 * Functions to use component as Block
 */

infix fun <T> Column<T>.with(block: Column<T>.(Column<T>) -> Unit): Column<T> {
    this.block(this)
    return this
}
infix fun <T> Column<T>.props(block: Column<T>.(Column<T>) -> Unit): Column<T>   = with(block)


var Column<*>.title: String?
    get() = null
    set(value) {
        value?.let { this.setTitle(value) }
    }
var Column<*>.weight: Int?
    get() = null
    set(value) {
        value?.let { this.setWeight(value) }
    }
var Column<*>.fixedSize: Int?
    get() = null
    set(value) {
        value?.let { this.setFixedSize(value) }
    }
var Column<*>.background: Color?
    get() = null
    set(value) {
        value?.let { this.setBackground(value) }
    }
var Column<*>.color: Color?
    get() = null
    set(value) {
        value?.let { this.setForeground(value) }
    }
var Column<*>.fontSize: Int?
    get() = null
    set(value) {
        value?.let { this.setFont(value) }
    }

infix fun Column<*>.align(position: String): Column<*> =
        when (position.toLowerCase()) {
            "left" -> this.alignLeft()
            "right" -> this.alignRight()
            "center" -> this.alignCenter()
            else -> this.alignLeft()
        }

infix fun Column<*>.bindContentsTo(propertyName: String): PropertyLabelProvider<*> =
        this.bindContentsToProperty(propertyName)

infix fun Column<*>.bindBackgroundTo(propertyName: String): BackgroundProvider<*, Color> =
        this.bindBackground(propertyName)

infix fun Column<*>.bindColorTo(propertyName: String): ForegroundProvider<*, Color> =
        this.bindForeground(propertyName)
