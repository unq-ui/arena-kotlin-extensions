package examples.kotlin

import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.windows.MainWindow
import org.uqbar.arena.kotlin.widgets.Label

fun main () = LabelTextBindingWindow(InternalAppModel()).startApplication()

/**
 * Label Extension Window
 */
class LabelTextBindingWindow(model: InternalAppModel) : MainWindow<InternalAppModel>(model) {
    override fun createContents(mainPanel: Panel) {
        title = "Ejemplos de uso de Binding"
        val externalModel = ExternalAppModel()

        /**
         * Ejemplo 1:
         *  - Contexto explícito por propiedad
         *  - Internal App Model
         *  - Binding Text
         *  - Binding Background
         */
        Label(mainPanel) {
            content bindTo "text1"
            content bindColorTo "blue"
            content bindBackgroundTo "orange"
        }

        /**
         * Ejemplo 2:
         *  - Contexto it implícito del bloque
         *  - Internal App Model
         *  - Binding Enabled
         */
        Label(mainPanel) {
            it bindTo "text2"
            it bindEnabledTo "enabled"
        }

        /**
         * Ejemplo 3:
         *  - Contexto this explícito
         *  - Internal App Model
         *  - Binding Enabled (disabled)
         */
        Label(mainPanel) {
            this bindTo "text3"
            this bindVisibleTo "visible"
            this bindEnabledTo "disabled"
        }

        /**
         * Ejemplo 4:
         *  - Contexto this implícito
         *  - Internal App Model
         *  - Binding Visible (disabled)
         */
        Label(mainPanel) {
            bindTo("text4")
            bindVisibleTo("invisible")
        }

        /**
         * Ejemplo 5:
         *  - Contexto explícito por propiedad
         *  - Internal App Model
         *  - Binding Image
         */
        Label(mainPanel) {
            content bindImageTo "imgArena"
        }

        /**
         * Ejemplo 6:
         *  - Contexto explícito por propiedad
         *  - External App Model
         *  - Binding Text
         *  - Binding Background
         */
        Label(mainPanel) {
            content.bindToModel(externalModel, "text1")
            content.bindColorToModel(externalModel, "orange")
            content.bindBackgroundToModel(externalModel, "blue")
        }

        /**
         * Ejemplo 7:
         *  - Contexto it implícito del bloque
         *  - External App Model
         *  - Binding Enabled
         */
        Label(mainPanel) {
            it.bindToModel(externalModel, "text2")
            it.bindEnabledToModel(externalModel, "enabled")
        }

        /**
         * Ejemplo 8:
         *  - Contexto this explícito
         *  - External App Model
         *  - Binding Enabled (disabled)
         */
        Label(mainPanel) {
            this.bindToModel(externalModel, "text3")
            this.bindVisibleToModel(externalModel, "visible")
            this.bindEnabledToModel(externalModel, "disabled")
        }

        /**
         * Ejemplo 9:
         *  - Contexto this implícito
         *  - External App Model
         *  - Binding Visible (disabled)
         */
        Label(mainPanel) {
            bindToModel(externalModel, "text4")
            bindVisibleToModel(externalModel, "invisible")
        }

        /**
         * Ejemplo 10:
         *  - Contexto explícito por propiedad
         *  - External App Model
         *  - Binding Image
         */
        Label(mainPanel) {
            content.bindImageToModel(externalModel, "imgKotlin")
        }

        /**
         * Ejemplo 11:
         *  - Contexto explícito por propiedad
         *  - Internal App Model
         *  - Binding Text with sub-prop
         */
        Label(mainPanel) {
            content bindTo "list.size"
        }
    }
}
