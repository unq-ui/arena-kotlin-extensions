package org.uqbar.arena.kotlin.widgets

import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.Label as UqLabel
import org.uqbar.arena.widgets.SkinnableControl as UqSkinnableControl
import org.uqbar.arena.kotlin.extensions.*
import org.uqbar.lacar.ui.model.ControlBuilder


class Label(panel: Panel) : SkinnableControl<UqLabel>(panel) {
    override val content: Label = this
    override val adapter: UqLabel = UqLabel(panel)

    var text: String? = null
        set(value) {
            field = value
            value?.let { adapter.text = it }
        }

    constructor(panel: Panel, block: Label.(Label) -> Unit) : this(panel) {
        this.block(this)
    }

    infix fun text(string: String) { text = string }
}
