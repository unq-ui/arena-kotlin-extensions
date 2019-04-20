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
        label1.bindTo("labelText")
        label1.bindColorTo("orange")

        val label2 = Label(mainPanel)
        label2.align("left")
        label2.bindToModel(modelObject, "labelText")
        label2.bindColorToModel(modelObject, "blue")

        val textBox1 = TextBox(mainPanel)
        textBox1.bindTo("textBoxText")
        textBox1.bindEnabledTo("enabled")
        textBox1.bindColorTo("blue")

        val textBox2 = TextBox(mainPanel)
        textBox2.bindTo("textBoxText")
        textBox2.bindEnabledToModel(modelObject, "disabled")
        textBox2.bindColorToModel(modelObject, "orange")

        Label(mainPanel)
                .setText("Alineado a la Derecha")
                .align("rIghT")
                .bindBackgroundTo("orange")

        Label(mainPanel).bindBackgroundToModel(modelObject, "blue")

        Label(mainPanel)
                .setText("Soy un Label Visible")
                .bindVisibleTo("enabled")

        Label(mainPanel)
                .setText("Soy un Label Invisible")
                .bindVisibleToModel(modelObject, "disabled")

    }

}