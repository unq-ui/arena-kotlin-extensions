package examples

import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.windows.MainWindow

import org.uqbar.arena.kotlin.extensions.*

fun main () = LabelExtensionsWindow(ExampleAppModel()).startApplication()

/**
 * Label Extension Window
 */
class LabelExtensionsWindow(model: ExampleAppModel) : MainWindow<ExampleAppModel>(model) {
    override fun createContents(mainPanel: Panel) {
        title = "Ejemplo de Extensiones para class Label"

        val labelTxt = Label(mainPanel)
        labelTxt.text = "Arena Framework by Uqbar"

        val labelImg = Label(mainPanel)
        labelImg.bindImageToProp("image")
    }

}