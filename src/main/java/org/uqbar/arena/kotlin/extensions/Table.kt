package org.uqbar.arena.kotlin.extensions

import org.uqbar.arena.widgets.Control
import org.uqbar.arena.widgets.tables.Table
import org.uqbar.lacar.ui.model.ControlBuilder
import org.uqbar.lacar.ui.model.TableBuilder
import org.uqbar.lacar.ui.model.bindings.Binding

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
 * No needed
 *  - addColumn
 *  - setItemType
 *  - getItemType
 *  - getColumns
 */