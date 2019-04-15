package org.uqbar.arena.kotlin.extensions

import org.uqbar.arena.widgets.tables.Table

/**
 * Binding Items
 */
fun Table<*>.bindItemsToProp(propertyName: String) =
        this.bindItemsToProperty(propertyName)

