package examples.extensions.widgets.control.skinnableControl

import org.uqbar.arena.windows.*
import org.uqbar.arena.Application
import org.uqbar.arena.kotlin.extensions.*
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.TextBox
import org.uqbar.arena.widgets.FileSelector
import org.uqbar.commons.model.annotations.Observable

fun main() {
    class App : Application() {
        override fun createMainWindow(): Window<*> = FileSelectorWithBlockWindow(this)
    }
    App().start()
}

/**
 * File Selector extends from Button
 *  - inherits all common behavior from Control, SkinnableControl & Button
 *  - adds
 *      + title
 *      + path
 *      + extensions
 */
class FileSelectorWithBlockWindow(parent: WindowOwner) : SimpleWindow<FileSelectorWithBlockWindow.AppModel>(parent, AppModel()) {
    override fun addActions(actionsPanel: Panel) {}
    override fun createFormPanel(mainPanel: Panel) {}

    @Suppress("unused") @Observable class AppModel {
        var number = 0
        var path: String? = null
        var caption = "Abstract Text Box"
        fun inc() { number++ }
    }

    override fun createContents(mainPanel: Panel) {
        title = "File Selector Wth Block Window"

        TextBox(mainPanel)

        FileSelector(mainPanel) with {
            title = "Title"
            caption = "Seleccionar archivo..."
            path = "/home"
            it bindTo "path"
            extensions("*.txt", "*.png")
        }

        Label(mainPanel) bindTo "path"
        Label(mainPanel) bindTo "number"

        FileSelector(mainPanel) props {
            path = "/home"
            setAsDefault()
            disableOnError()
            bindTo("path")
            bindCaptionTo("caption")
        }
    }
}
