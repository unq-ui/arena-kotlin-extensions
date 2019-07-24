package examples.extensions.widget.control

import org.uqbar.arena.kotlin.extensions.width
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.windows.MainWindow
import org.uqbar.arena.widgets.Spinner
import org.uqbar.commons.model.annotations.Observable

fun main () = SpinnerExtensionsWindow().startApplication()

/**
 * Spinner Extension Window
 *  - inherits all common behavior from Control
 *  - adds
 *      + minimumValue
 *      + maximumValue
 */
class SpinnerExtensionsWindow : MainWindow<SpinnerExtensionsWindow.AppModel>(AppModel()) {
    @Observable class AppModel
    override fun createContents(mainPanel: Panel) {
        title = "Spinner Extension Window"

        val spinner = Spinner(mainPanel)
        spinner.maximumValue = 10
        spinner.minimumValue = 2
        spinner.width = 50
    }

}