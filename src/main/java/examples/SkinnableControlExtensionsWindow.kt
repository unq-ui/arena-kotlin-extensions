package examples

import java.awt.Color
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.windows.MainWindow

import org.uqbar.arena.kotlin.extensions.*

fun main () = SkinnableControlExtensionsWindow(ExampleAppModel()).startApplication()

/**
 * SkinnableControl Extension Window
 */
class SkinnableControlExtensionsWindow(model: ExampleAppModel) : MainWindow<ExampleAppModel>(model) {
    override fun createContents(mainPanel: Panel) {
        title = "Ejemplo de Extensiones para class Label"

        val firstLabel = Label(mainPanel)
        firstLabel.background = Color.BLUE

        val secondLabel = Label(mainPanel)
        secondLabel.background = firstLabel.background

    }

}