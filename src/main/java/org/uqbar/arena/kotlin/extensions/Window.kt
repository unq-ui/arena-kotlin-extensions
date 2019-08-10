package org.uqbar.arena.kotlin.extensions

import org.uqbar.arena.windows.Window

/**
 * Functions to use component as Block
 */

infix fun <T: Window<*>> T.with(block: T.(T) -> Unit): T {
    this.block(this)
    return this
}
infix fun <T: Window<*>> T.props(block: T.(T) -> Unit): T = with(block)

// When components or Windows are written with blocks
// we can't use `this` to reference parent window.
// Example:
//  - `Dialog(this, modelObject)`       # Does not work because `this` references to `Dialog`
//  - `Dialog(thisWindow, modelObject)` # Works
var Window<*>.thisWindow
    get() = this
    private set(_) = throw IllegalStateException("Override this property is not allowed.")
