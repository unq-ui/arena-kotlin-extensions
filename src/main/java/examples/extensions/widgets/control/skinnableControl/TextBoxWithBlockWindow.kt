package examples.extensions.widgets.control.skinnableControl

import java.awt.Color
import org.uqbar.arena.windows.ErrorsPanel
import org.uqbar.arena.kotlin.extensions.*
import org.uqbar.arena.widgets.*
import org.uqbar.arena.windows.MainWindow
import org.uqbar.commons.model.annotations.Observable

fun main () = TextBoxWindow().startApplication()

/**
 * TextBox Extension Window
 *  - inherits all common behavior from Control & SkinnableControl
 *  - adds
 *      + withFilter
 *      + selectFinalLine
 *      + multiLine
*/
class TextBoxWindow : MainWindow<TextBoxWindow.AppModel>(AppModel()) {
    @Suppress("unused") @Observable class AppModel {
        var textBoxText = "Soy un texto para un TextBox"
        var enabled: Boolean = true
        var disabled: Boolean = false
        var orange: Color = Color.ORANGE
        var blue: Color = Color.blue
    }
    override fun createContents(mainPanel: Panel) {
        title = "Ejemplo para TextBoxes"
        ErrorsPanel(mainPanel, "")

        TextBox(mainPanel) with { content ->
            content bindTo "textBoxText"
            content.bindEnabledTo("enabled")
            bindColorTo("blue")
        }

        TextBox(mainPanel) with {
            fontSize = 24
            color = Color.YELLOW
            bgColor = Color.BLUE
            bindTo("textBoxText")
        }

        TextBox(mainPanel) props {
            it.bindTo("textBoxText")
            it.bindEnabledToModel(modelObject, "disabled")
            it.bindColorToModel(modelObject, "orange")
        }

        TextBox(mainPanel) with {
            withFilter { it.inputText.toString().toLowerCase().contains("a") }
        }

        GroupPanel(mainPanel) with {
            title = "Numerics"
            NumericField(it) props {
                withDecimals = true
                isMultiLine = true
                selectFinalLine()
            }

            NumericField(it) with {
                withDecimals = false
            }

            NumericField(it)
        }

        KeyWordTextArea(mainPanel) with {
            keyWords("foo", "bar")
            height = 200
        }

        PasswordField(mainPanel) props {
            fontSize = 20
        }
    }
}
