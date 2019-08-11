package examples.extensions.widgets.control.skinnableControl

import java.awt.Color
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.windows.MainWindow
import org.uqbar.arena.kotlin.extensions.*
import org.uqbar.commons.model.annotations.Observable

fun main () = LabelWithBlockWindow().startApplication()

/**
 * Label Extension Window
 *  - inherits all common behavior from Control & SkinnableControl
 *  - adds
 *      + text
 */
class LabelWithBlockWindow : MainWindow<LabelWithBlockWindow.AppModel>(AppModel()) {
    @Suppress("unused") @Observable class AppModel {
        var labelText = "Soy un texto para un Label"
        var letText = "Soy un texto dentro del let"
        var image = "uqbar-arena-logo.png"
        var enabled = true
        var disabled = false
        var orange: Color = Color.ORANGE
        var blue: Color = Color.BLUE
    }

    override fun createContents(mainPanel: Panel) {
        title = "Label With Block Window"

        Label(mainPanel) withText "Arena Framework by Uqbar"

        Label(mainPanel) with {
            bindImageTo("image")
        }

        Label(mainPanel) with {
            it bindTo("letText")
            it.bgColor = Color.MAGENTA
        }

        Label(mainPanel) props {
            it bindTo "letText"
            it.bgColor = Color.CYAN
        }

        Label(mainPanel) props { self ->
            self bindTo "letText"
            self.bgColor = Color.CYAN
            self.bindImageToModel(modelObject, "image")
        }

        Label(mainPanel) with {
            align = "center"
            it bindTo "labelText"
            it bindColorTo "orange"
        }

        Label(mainPanel) with {
            align = "left"
            bindToModel(modelObject, "labelText")
            bindColorToModel(modelObject, "blue")
        }

        Label(mainPanel) with {
            text = "Alineado a la Derecha"
            align = "rIghT"
            bindBackgroundTo("orange")
        }

        Label(mainPanel).bindBackgroundToModel(modelObject, "blue")

        Label(mainPanel) props {
            text = "Soy un Label Visible"
            bindVisibleTo("enabled")
        }

        Label(mainPanel) with { content ->
            content.text = "Soy un Label Invisible"
            content.bindVisibleToModel(modelObject, "disabled")
        }
    }
}
