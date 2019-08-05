package examples.extensions.widgets.control

import org.uqbar.arena.kotlin.extensions.*
import org.uqbar.arena.layout.HorizontalLayout
import org.uqbar.arena.widgets.CheckBox
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.windows.MainWindow
import org.uqbar.commons.model.annotations.Observable
import java.awt.Color

fun main() = CheckBoxExtensionsWindow().startApplication()


/**
 * CheckBox extends from Control
 *  - inherits all common behavior
 *  - doesn't add any functionality
 *  - bind value need a boolean property and makes selected/unselected
 */
class CheckBoxExtensionsWindow : MainWindow<CheckBoxExtensionsWindow.AppModel>(AppModel()) {
    @Observable class AppModel {
        var selected = true
        var unselected = false
        var enabled = true
        var disabled = false
        var color =  Color.BLUE
    }

    override fun createContents(mainPanel: Panel) {
        title = "CheckBox Extensions Windows"

        val panel1 = Panel(mainPanel).setLayout(HorizontalLayout())
        val cb1 = CheckBox(panel1)
        cb1.bindTo("selected")
        cb1.bindEnabledTo("enabled")
        Label(panel1).setText("Selected and Enabled")

        val panel2 = Panel(mainPanel).setLayout(HorizontalLayout())
        val cb2 = CheckBox(panel2)
        cb2 bindTo "unselected"
        Label(panel2).setText("Unselected")

        val panel3 = Panel(mainPanel).setLayout(HorizontalLayout())
        val cb3 = CheckBox(panel3)
        cb3 bindTo "selected"
        cb3 bindEnabledTo "disabled"
        cb3 bindBackgroundTo "color"
        Label(panel3).setText("Selected, Disabled and Blue")
    }
}

