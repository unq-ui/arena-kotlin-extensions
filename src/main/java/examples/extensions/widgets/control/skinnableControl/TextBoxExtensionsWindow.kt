package examples.extensions.widgets.control.skinnableControl

import org.uqbar.arena.windows.MainWindow

import org.uqbar.arena.kotlin.extensions.*
import org.uqbar.arena.widgets.*
import org.uqbar.arena.windows.ErrorsPanel
import org.uqbar.commons.model.annotations.Observable
import java.awt.Color

fun main () = TextBoxExtensionsWindow().startApplication()

/**
 * TextBox Extension Window
 *  - inherits all common behavior from Control & SkinnableControl
 *  - adds
 *      + withFilter
 *      + selectFinalLine
 *      + multiLine
*/
class TextBoxExtensionsWindow : MainWindow<TextBoxExtensionsWindow.AppModel>(AppModel()) {
    @Observable class AppModel {
        var textBoxText = "Soy un texto para un TextBox"
        var enabled: Boolean = true
        var disabled: Boolean = false
        var orange: Color = Color.ORANGE
        var blue: Color = Color.blue
    }
    override fun createContents(mainPanel: Panel) {
        title = "Ejemplo de Extensiones para abstract class Control"
        ErrorsPanel(mainPanel, "")

        val textBox1 = TextBox(mainPanel)
        textBox1.bindTo("textBoxText")
        textBox1.bindEnabledTo("enabled")
        textBox1.bindColorTo("blue")

        val textBox2 = TextBox(mainPanel)
        textBox2.bindTo("textBoxText")
        textBox2.bindEnabledToModel(modelObject, "disabled")
        textBox2.bindColorToModel(modelObject, "orange")

        val textBox3 = TextBox(mainPanel)
        textBox3.withFilter { it.inputText.toString().toLowerCase().contains("a") }

        val numeric = NumericField(mainPanel)
        numeric.isMultiLine = true
        numeric.selectFinalLine()

        NumericField(mainPanel, true)

        val key = KeyWordTextArea(mainPanel)
        key.height = 200

        val pass = PasswordField(mainPanel)
        pass.fontSize = 20
    }

}