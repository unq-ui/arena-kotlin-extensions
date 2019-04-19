package examples.extensions

import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.TextBox
import org.uqbar.arena.windows.MainWindow

import org.uqbar.arena.kotlin.extensions.*

fun main () = ControlExtensionsWindow(ExampleAppModel()).startApplication()

/**
 * Control Extension Window
 */
class ControlExtensionsWindow(model: ExampleAppModel) : MainWindow<ExampleAppModel>(model) {
    override fun createContents(mainPanel: Panel) {
        title = "Ejemplo de Extensiones para abstract class Control"

        val label1 = Label(mainPanel)
        label1.align("center")
        label1.bindToProp("labelText")
        label1.bindColorToProp("orange")

        val label2 = Label(mainPanel)
        label2.align("left")
        label2.bindTo(modelObject, "labelText")
        label2.bindColorTo(modelObject, "blue")

        val textBox1 = TextBox(mainPanel)
        textBox1.bindToProp("textBoxText")
        textBox1.bindEnabledToProp("enabled")
        textBox1.bindColorToProp("blue")

        val textBox2 = TextBox(mainPanel)
        textBox2.bindToProp("textBoxText")
        textBox2.bindEnabledTo(modelObject, "disabled")
        textBox2.bindColorTo(modelObject, "orange")

        Label(mainPanel)
                .setText("Alineado a la Derecha")
                .align("rIghT")
                .bindBackgroundToProp("orange")

        Label(mainPanel).bindBackgroundTo(modelObject, "blue")

        Label(mainPanel)
                .setText("Soy un Label Visible")
                .bindVisibleToProp("enabled")

        Label(mainPanel)
                .setText("Soy un Label Invisible")
                .bindVisible(modelObject, "disabled")

    }

}