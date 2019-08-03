package examples.extensions.widgets.control.skinnableControl

import java.awt.Color
import org.uqbar.arena.windows.*
import org.uqbar.arena.Application
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.widgets.TextBox
import org.uqbar.arena.kotlin.extensions.*
import org.uqbar.commons.model.annotations.Observable
import org.uqbar.commons.model.exceptions.UserException

fun main() {
    class App : Application() {
        override fun createMainWindow(): Window<*> = ButtonExtensionsWindow(this)
    }
    App().start()
}


class ButtonExtensionsWindow(parent: WindowOwner) : SimpleWindow<ButtonExtensionsWindow.AppModel>(parent, AppModel()) {
    override fun addActions(actionsPanel: Panel?) {}
    override fun createFormPanel(mainPanel: Panel?) {}

    @Suppress("unused") @Observable class AppModel {
        var number = 1
        var makesError = "Button Binding Makes Error"
        fun inc() { number++ }
    }

    override fun createContents(mainPanel: Panel) {
        title = "Button With Block Window"

        TextBox(mainPanel) // Para verificar setAsDefault()

        Button(mainPanel) with {
            caption = "Button 1 Blue"
            color = Color.BLUE
            fontSize = 14
        } with {
            text = "Overwrite"
        }

        Button(mainPanel) props {
            caption = "Button 2 Red Default"
            color = Color.RED
            it.setAsDefault()
        }

        Button(mainPanel) with {
            it bindCaptionTo "makesError"
            onClick { throw UserException("Error para bloquear botón") }
        }

        Button(mainPanel) props { content ->
            content.disableOnError()
            content.caption = "Disabled on Error"
        }

        Button(mainPanel) with {  content ->
            content bindCaptionTo "number"
            content.onClick { modelObject.inc() }
        }
    }

}