package org.uqbar.arena.kotlin.widgets

import java.awt.Color
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.Label as UqLabel
import org.uqbar.arena.kotlin.extensions.*

class Label(private val panel: Panel) {
    val content: Label = this
    private val uqbarLabel: UqLabel = UqLabel(this.panel)

    var text: String? = null
        set(value) {
            field = value
            value?.let { uqbarLabel.text = it }
        }
    var width: Int? = null
        set(value) {
            field = value
            value?.let { uqbarLabel.width = it }
        }
    var height: Int? = null
        set(value) {
            field = value
            value?.let { uqbarLabel.height = it }
        }
    var fontSize: Int? = null
        set(value) {
            field = value
            value?.let { uqbarLabel.fontSize = it }
        }
    var color: Color? = null
        set(value) {
            field = value
            value?.let { uqbarLabel.foreground = it }
        }
    var bgColor: Color? = null
        set(value) {
            field = value
            value?.let { uqbarLabel.background = it }
        }


    constructor(panel: Panel, block: Label.(Label) -> Unit) : this(panel) {
        this.block(this)
    }

    infix fun bindTo(propName: String) = uqbarLabel.bindToProp(propName)
}