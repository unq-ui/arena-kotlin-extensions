package examples.extensions.widgets.control.skinnableControl

import java.awt.Color
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.windows.MainWindow
import org.uqbar.arena.kotlin.extensions.*
import org.uqbar.commons.model.annotations.Observable

fun main () = LabelExtensionsWindow().startApplication()

/**
 * Label Extension Window
 *  - inherits all common behavior from Control & SkinnableControl
 *  - adds
 *      + text
 */
class LabelExtensionsWindow : MainWindow<LabelExtensionsWindow.AppModel>(AppModel()) {
    @Observable class AppModel {
        var labelText = "Soy un texto para un Label"
        var letText = "Soy un texto dentro del let"
        var image = "uqbar-arena-logo.png"
        var enabled = true
        var disabled = false
        var orange: Color = Color.ORANGE
        var blue: Color = Color.BLUE
    }

    override fun createContents(mainPanel: Panel) {
        title = "Label Extensions Window"

        val labelTxt = Label(mainPanel)
        labelTxt.text = "Arena Framework by Uqbar"

        val labelImg = Label(mainPanel)
        labelImg.bindImageTo("image")

        Label(mainPanel).let {
            it bindTo("letText")
            it.background = Color.MAGENTA
        }

        Label(mainPanel) with {
            it bindTo "letText"
            it.background = Color.CYAN
        }

        Label(mainPanel) props { self ->
            self bindTo "letText"
            self.background = Color.CYAN
            self bindImageTo "image"
        }

        val label1 = Label(mainPanel)
        label1.align("center")
        label1.bindTo("labelText")
        label1.bindColorTo("orange")

        val label2 = Label(mainPanel)
        label2.align = "left"
        label2.bindToModel(modelObject, "labelText")
        label2.bindColorToModel(modelObject, "blue")

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