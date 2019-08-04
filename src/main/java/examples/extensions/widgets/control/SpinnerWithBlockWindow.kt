package examples.extensions.widgets.control

import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.Spinner
import org.uqbar.arena.windows.MainWindow
import org.uqbar.arena.kotlin.extensions.*
import org.uqbar.commons.model.annotations.Observable

fun main () = SpinnerWindow().startApplication()

/**
 * Spinner Extension Window
 *  - inherits all common behavior from Control
 *  - adds
 *      + minimumValue
 *      + maximumValue
 */
class SpinnerWindow : MainWindow<SpinnerWindow.AppModel>(AppModel()) {
    @Observable class AppModel
    override fun createContents(mainPanel: Panel) {
        title = "Spinner Window"

        Spinner(mainPanel) with {
            maxValue = 10
            minValue = 2
            width = 50
        }
    }
}