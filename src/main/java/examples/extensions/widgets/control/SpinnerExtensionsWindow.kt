package examples.extensions.widgets.control

import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.Spinner
import org.uqbar.arena.windows.MainWindow
import org.uqbar.arena.kotlin.extensions.*
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

        Spinner(mainPanel) with {
            width = 50
            minValue = 2
            maxValue = 10
        }
    }

}