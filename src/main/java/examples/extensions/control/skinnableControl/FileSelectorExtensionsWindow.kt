package examples.extensions.control.skinnableControl

import org.uqbar.arena.Application
import java.awt.Color
import org.uqbar.arena.kotlin.extensions.*
import org.uqbar.arena.widgets.*
import org.uqbar.arena.windows.*
import org.uqbar.commons.model.annotations.Observable
import org.uqbar.commons.model.exceptions.UserException

fun main() {
    class App : Application() {
        override fun createMainWindow(): Window<*> = FileSelectorExtensionsWindow(this)
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
class FileSelectorExtensionsWindow(parent: WindowOwner) : SimpleWindow<FileSelectorExtensionsWindow.AppModel>(parent, AppModel()) {
    override fun addActions(actionsPanel: Panel?) {}
    override fun createFormPanel(mainPanel: Panel?) {}

    @Observable class AppModel {
        var path: String? = null
    }

    override fun createContents(mainPanel: Panel) {
        title = "File Selector Extensions Window"

        val file1 = FileSelector(mainPanel)
        file1.title("Title")
        file1.text = "Seleccionar archivo..."
        file1.path("/home")
        file1 bindTo "path"
        file1.extensions("*.txt", "*.png")

        Label(mainPanel) bindTo "path"

    }

}