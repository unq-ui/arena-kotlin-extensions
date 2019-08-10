package examples.extensions.windows

import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.windows.Dialog
import org.uqbar.arena.windows.MainWindow
import org.uqbar.arena.windows.WindowOwner
import org.uqbar.arena.kotlin.extensions.*
import org.uqbar.commons.model.annotations.Observable

fun main() = DialogWithBlockWindow().startApplication()

class DialogWithBlockWindow : MainWindow<DialogWithBlockWindow.AppModel>(AppModel()) {
    @Observable class AppModel {
        var amount = 0
        var times = timesFun()
        fun inc() {
            amount++
            times = timesFun()
        }
        private fun timesFun() = "Aceptaste el diálogo $amount veces"
    }

    override fun createContents(mainPanel: Panel?) {
        title = "Dialog with block"

        Label(mainPanel) bindTo "times"

        Button(mainPanel) with {
            caption = "extraer"
            onClick {
                MessageDialog(thisWindow, modelObject) with {
                    onAccept { modelObject.inc() }
                    open()
                }
            }
        }
    }

}

class MessageDialog(owner: WindowOwner, model: DialogWithBlockWindow.AppModel)
    : Dialog<DialogWithBlockWindow.AppModel>(owner, model) {
    override fun createFormPanel(mainPanel: Panel?) {
        title = "Soy el diálogo"
        Label(mainPanel) with { text = "Muchas gracias, vuelvas prontos" }

        Button(mainPanel) with {
            caption = "Aceptar"
            onClick { accept() }
        }
    }


}