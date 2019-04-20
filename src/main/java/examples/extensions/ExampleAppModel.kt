package examples.extensions

import org.uqbar.commons.model.annotations.Observable
import java.awt.Color

@Observable
class ExampleAppModel {
    var letText = "Soy un texto dentro del let"
    var labelText = "Soy un texto para un Label"
    var textBoxText = "Soy un texto para un TextBox"
    var enabled: Boolean = true
    var disabled: Boolean = !enabled
    var orange = Color.ORANGE
    var blue = Color.blue
    var image = "uqbar-arena-logo.png"
}