package examples.kotlin

import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.windows.MainWindow
import org.uqbar.arena.kotlin.widgets.Label

fun main () = LabelBindingsWindow(KotlinAppModel()).startApplication()

/**
 * Label Extension Window
 */
class LabelBindingsWindow(model: KotlinAppModel) : MainWindow<KotlinAppModel>(model) {
    override fun createContents(mainPanel: Panel) {
        title = "Ejemplos de uso de Binding"

        /**
         * Ejemplo 1:
         *  - Binding Básico
         *  - Content binding
         */
        Label(mainPanel) {
            content bindTo "text1"
        }
    }
}

/*
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