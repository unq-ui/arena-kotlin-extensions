package examples.extensions.widget.control.skinnableControl

import org.uqbar.arena.Application
import java.awt.Color
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.kotlin.extensions.*
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.widgets.TextBox
import org.uqbar.arena.windows.*
import org.uqbar.commons.model.annotations.Observable
import org.uqbar.commons.model.exceptions.UserException

fun main() {
    class App : Application() {
        override fun createMainWindow(): Window<*> = ButtonExtensionsWindow(this)
    }
    App().start()
}

/**
 * Button extends from SkinnableControl
 *  - inherits all common behavior from Control
 *  - inherits foreground, background & fontSize from SkinnableControl
 *  - adds
 *      + caption
 *      + onClick
 *      + setAsDefault
 *      + disableOnError
 *      + bindCaptionToProperty
 */
class ButtonExtensionsWindow(parent: WindowOwner) : SimpleWindow<ButtonExtensionsWindow.AppModel>(parent, AppModel()) {
    override fun addActions(actionsPanel: Panel?) {}
    override fun createFormPanel(mainPanel: Panel?) {}

    @Observable class AppModel {
        var number = 1
        var makesError = "Button Binding Makes Error"
        fun inc() { number++ }
    }

    override fun createContents(mainPanel: Panel) {
        title = "Button Extensions Window"

        TextBox(mainPanel)

        val button1 = Button(mainPanel)
        button1.text = "Button 1 Blue"
        button1.foreground = Color.BLUE
        button1.fontSize = 14

        val button2 = Button(mainPanel)
        button2.text = "Button 2 Red Default"
        button2.color = Color.RED
        button2.setAsDefault()

        val button3 = Button(mainPanel)
        button3 bindCaptionTo "makesError"
        button3.onClick { throw UserException("Error para bloquear botón") }

        val button4 = Button(mainPanel)
        button4.disableOnError()
        button4.text = "Disabled on Error"

        val button5 = Button(mainPanel)
        button5.bindCaptionTo("number")
        button5.onClick { this.modelObject.inc() }
    }

}