package examples.extensions.widgets.control

import java.awt.Color
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.CheckBox
import org.uqbar.arena.windows.MainWindow
import org.uqbar.arena.layout.HorizontalLayout
import org.uqbar.arena.kotlin.extensions.*
import org.uqbar.commons.model.annotations.Observable

fun main() = CheckBoxWindows().startApplication()


/**
 * CheckBox extends from Control
 *  - inherits all common behavior
 *  - doesn't add any functionality
 *  - bind value need a boolean property and makes selected/unselected
 */
class CheckBoxWindows : MainWindow<CheckBoxWindows.AppModel>(AppModel()) {
    @Suppress("unused") @Observable class AppModel {
        var selected = true
        var unselected = false
        var enabled = true
        var disabled = false
        var color: Color =  Color.BLUE
    }

    override fun createContents(mainPanel: Panel) {
        title = "CheckBox Windows"

        Panel(mainPanel) with {
            layout = HorizontalLayout()
            CheckBox(it) with { _ ->
                bindTo("selected")
                bindEnabledTo("enabled")
                Label(it) with {
                    text = "Selected and Enabled"
                }
            }
        }

        Panel(mainPanel) props {
            asHorizontal()
            CheckBox(it) with { _ ->
                bindTo("unselected")
                Label(it) with {
                    text = "Unselected"
                }
            }
        }

        Panel(mainPanel) with {
            asHorizontal()
            CheckBox(it) with { content ->
                content bindTo "selected"
                content bindEnabledTo "disabled"
                content bindBackgroundTo "color"
                Label(it) with {
                    text = "Selected, Disabled and Blue"
                }
            }
        }
    }
}
