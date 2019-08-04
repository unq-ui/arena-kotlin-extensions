package org.uqbar.arena.kotlin.extensions

import org.uqbar.arena.widgets.Widget

/**
 * Functions to use component as Block
 */

infix fun <T: Widget> T.with(block: T.(T) -> Unit): T {
    this.block(this)
    return this
}
infix fun <T: Widget> T.props(block: T.(T) -> Unit): T = with(block)
