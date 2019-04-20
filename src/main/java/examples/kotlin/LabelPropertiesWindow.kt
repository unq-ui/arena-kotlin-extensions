package examples.kotlin

import java.awt.Color
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.windows.MainWindow
import org.uqbar.arena.kotlin.widgets.Label

fun main () = LabelExamplesWindow(InternalAppModel()).startApplication()

/**
 * Label Extension Window
 */
class LabelExamplesWindow(model: InternalAppModel) : MainWindow<InternalAppModel>(model) {
    override fun createContents(mainPanel: Panel) {
        title = "Ejemplos de uso de Label"

        /**
         * Ejemplo 1
         *  - Contenido Libre
         *  - Propiedades por asignación
         */
        Label(mainPanel) {
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
        Label(mainPanel) {
            content text "Ejemplo 2"
            content width 300
            content height 100
            content fontSize 14
            content align "right"
            content color Color.WHITE
            content bgColor Color.BLACK
        }

        /**
         * Ejemplo 3
         *  - Contenido Libre
         *  - Contexto implícitamente definido por propiedades de los bloques
         *  - Funciones infijas
         */
        Label(mainPanel) {
            it text "Ejemplo 3"
            it width 200
            it height 50
            it fontSize 12
            it align "left"
            it color Color.BLUE
            it bgColor Color.ORANGE
        }

        /**
         * Ejemplo 4
         *  - Contenido Libre
         *  - Contexto explícitamente (this)
         *  - Funciones "normales"
         */
        Label(mainPanel) {
            text("Ejemplo 4")
            width(200)
            height(25)
            fontSize(10)
            align("left")
            color(Color.RED)
            bgColor(Color.LIGHT_GRAY)
        }
    }
}
