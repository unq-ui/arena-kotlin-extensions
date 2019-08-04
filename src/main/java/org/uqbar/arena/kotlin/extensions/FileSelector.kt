package org.uqbar.arena.kotlin.extensions

import java.lang.reflect.Field
import org.uqbar.arena.widgets.FileSelector

import org.uqbar.lacar.ui.model.bindings.Binding

/**
 * Attributes
 *  - path
 *  - title
 */

val fileSelectorPathField: Field = FileSelector::class.java.getDeclaredField("path")
val fileSelectorTitleField: Field = FileSelector::class.java.getDeclaredField("title")


var FileSelector.path: String
    set(value) {
        this.path(value)
    }
    get() {
        fileSelectorPathField.isAccessible = true
        return fileSelectorPathField.get(this) as String
    }

var FileSelector.title: String
    set(value) {
        this.title(value)
    }
    get() {
        fileSelectorTitleField.isAccessible = true
        return fileSelectorTitleField.get(this) as String
    }
