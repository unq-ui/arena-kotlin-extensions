package org.uqbar.arena.kotlin.extensions

import org.uqbar.arena.widgets.Selector
import org.uqbar.lacar.ui.model.ListBuilder
import org.uqbar.lacar.ui.model.bindings.Binding

/**
 * Binding
 *  - bindItemsToProperty
 *  - bindItems
 *  - items
 *  - allowNull
 *  - onSelection
 */

infix fun Selector<*>.bindItemsTo(propertyName: String): Binding<*, out Selector<*>, out ListBuilder<*>> =
        this.bindItemsToProperty(propertyName)

/**
 * In Selectors, selected binding use bindValueToProperty method, so this is just an alias for convenience
 */
infix fun Selector<*>.bindSelectedTo(propertyName: String) = this.bindTo(propertyName)

/**
 * No extension needed for
 *  - bindItems
 *  - items
 *  - allowNull
 *  - onSelection
 */