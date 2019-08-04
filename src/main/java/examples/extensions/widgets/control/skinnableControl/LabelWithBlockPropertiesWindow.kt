package examples.extensions.widgets.control.skinnableControl

import java.awt.Color
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.windows.MainWindow
import org.uqbar.arena.kotlin.extensions.*
import org.uqbar.commons.model.annotations.Observable

fun main () = LabelWithBlockPropertiesWindow().startApplication()

/**
 * Label Extension Window
 */
class LabelWithBlockPropertiesWindow : MainWindow<LabelWithBlockPropertiesWindow.AppModel>(AppModel()) {
    @Observable class AppModel

    override fun createContents(mainPanel: Panel) {
        title = "Ejemplos de uso de Label"

        /**
         * Ejemplo 1
         *  - Contenido Libre
         *  - Propiedades por asignación
         */
        Label(mainPanel) with {
            text = "Ejemplo 1"
            width = 400
            height = 200
            fontSize = 16
            align = "center"
            color = Color.BLUE
            bgColor = Color.CYAN
        }

        /**
         * Ejemplo 2
         *  - Contenido Libre
         *  - Contexto explícitamente definido por propiedad
         *  - Funciones infijas
         */
        Label(mainPanel) props {
            text = "Ejemplo 2"
            width = 300
            height = 100
            fontSize = 14
            align = "right"
            color = Color.WHITE
            bgColor = Color.BLACK
        }

        /**
         * Ejemplo 3
         *  - Contenido Libre
         *  - Contexto implícitamente definido por propiedades de los bloques
         *  - Funciones infijas
         */
        Label(mainPanel) with {
            it.text = "Ejemplo 3"
            it.width = 200
            it.height = 50
            it.fontSize = 12
            it.align = "left"
            it.color = Color.BLUE
            it.bgColor = Color.ORANGE
        }
    }
}
