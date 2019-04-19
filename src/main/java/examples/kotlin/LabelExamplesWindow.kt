package examples.kotlin

import java.awt.Color
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.windows.MainWindow
import org.uqbar.arena.kotlin.widgets.Label

fun main () = LabelExamplesWindow(KotlinAppModel()).startApplication()

/**
 * Label Extension Window
 */
class LabelExamplesWindow(model: KotlinAppModel) : MainWindow<KotlinAppModel>(model) {
    override fun createContents(mainPanel: Panel) {
        title = "Ejemplos de uso de Label"

        /**
         * Ejemplo 1: Contenido Libre & Propiedades
         */
        Label(mainPanel) {
            text = "Soy un texto libre"
            width = 500
            height = 300
            fontSize = 16
            color = Color.BLUE
            bgColor = Color.CYAN
        }

        /**
         * Ejemplo 2: Ídem Ejemplo 1 con sintaxis alternativa
         */
//        Label(mainPanel) {
//            text to "Soy un texto libre"
//            width to 500
//            height to 300
//            fontSize to 16
//            color to Color.BLUE
//            bgColor to Color.CYAN
//        }

        /**
         * Ejemplo 2: Binding Básico
         *  - Content binding
         */
        Label(mainPanel) {
            content bindTo "text1"
        }
    }
}

/*
setWidth
setHeight

alignRight
alignLeft
alignCenter

bindValueToProperty
bindValue
bindEnabled
bindImageToProperty
bindEnabledToProperty
bindVisible
bindVisibleToProperty
bindBackground
bindBackgroundToProperty
bindForegroundToProperty
bindForeground
*/