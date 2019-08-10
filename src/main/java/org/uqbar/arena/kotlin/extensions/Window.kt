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

// When Widgets or Windows are written with blocks
// they can't use `this` to reference parent window
// because context has changes.
// Example:
//  # This code does not work because `this` references to `Dialog`, not to `Window`
//  Button with {
//      Dialog(this, modelObject)
//  }
//
//  # This code works
//  Button with {
//      Dialog(thisWindow, modelObject)
//  }
var <T: Window<*>> T.thisWindow
    get() = this
    private set(_) = throw IllegalStateException("Override this property is not allowed.")
