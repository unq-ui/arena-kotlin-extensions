package org.uqbar.arena.kotlin.extensions

import org.uqbar.arena.widgets.tables.Table

/**
 * Binding Items
 */
infix fun Table<*>.bindItemsTo(propertyName: String) =
        this.bindItemsToProperty(propertyName)

