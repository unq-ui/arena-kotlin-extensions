package examples.extensions.widgets.control.skinnableControl

import java.awt.Color
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.windows.MainWindow
import org.uqbar.arena.kotlin.extensions.*
import org.uqbar.commons.model.annotations.Observable

fun main () = LabelWithBlockTextBindingWindow().startApplication()

/**
 * Label Extension Window
 */
class LabelWithBlockTextBindingWindow : MainWindow<LabelWithBlockTextBindingWindow.AppModel>(AppModel()) {
    @Suppress("unused") @Observable class AppModel {
        var text1 = "Internal App Model Text 1"
        var text2 = "Internal App Model Text 2"
        var text3 = "Internal App Model Text 3"
        var text4 = "Internal App Model Text 4"
        var list = listOf("Primer elemento", "Segundo elemento")
        var listFirst = list.size
        var enabled: Boolean = true
        var visible: Boolean = true
        var disabled: Boolean = false
        var invisible: Boolean = false
        var orange: Color = Color.ORANGE
        var blue: Color = Color.blue
        var imgArena = "uqbar-arena-logo.png"
    }

    override fun createContents(mainPanel: Panel) {
        title = "Ejemplos de uso de Binding"
        val externalModel = ExternalAppModel()

        /**
         * Ejemplo 1:
         *  - Contexto explícito por argumento
         *  - Internal App Model
         *  - Binding Text
         *  - Binding Background
         */
        Label(mainPanel) with { content ->
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
        Label(mainPanel) props {
            it bindTo "text2"
            it bindEnabledTo "enabled"
        }

        /**
         * Ejemplo 3:
         *  - Contexto this explícito
         *  - Internal App Model
         *  - Binding Enabled (disabled)
         */
        Label(mainPanel) with {
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
        Label(mainPanel) props {
            bindTo("text4")
            bindVisibleTo("invisible")
        }

        /**
         * Ejemplo 5:
         *  - Contexto explícito por argumento
         *  - Internal App Model
         *  - Binding Image
         */
        Label(mainPanel) with { content ->
            content bindImageTo "imgArena"
        }

        /**
         * Ejemplo 6:
         *  - Contexto explícito por argumento
         *  - External App Model
         *  - Binding Text
         *  - Binding Background
         */
        Label(mainPanel) with { content ->
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
        Label(mainPanel) with {
            it.bindToModel(externalModel, "text2")
            it.bindEnabledToModel(externalModel, "enabled")
        }

        /**
         * Ejemplo 8:
         *  - Contexto this explícito
         *  - External App Model
         *  - Binding Enabled (disabled)
         */
        Label(mainPanel) props {
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
        Label(mainPanel) with {
            bindToModel(externalModel, "text4")
            bindVisibleToModel(externalModel, "invisible")
        }

        /**
         * Ejemplo 10:
         *  - Contexto explícito por argumento
         *  - External App Model
         *  - Binding Image
         */
        Label(mainPanel) props { content ->
            content.bindImageToModel(externalModel, "imgKotlin")
        }

        /**
         * Ejemplo 11:
         *  - Contexto explícito por argumento
         *  - Internal App Model
         *  - Binding Text with sub-prop
         */
        Label(mainPanel) with { content ->
            content bindTo "list.size"
        }
    }
}


@Suppress("unused") @Observable class ExternalAppModel {
    var text1 = "External App Model Text 1"
    var text2 = "External App Model Text 2"
    var text3 = "External App Model Text 3"
    var text4 = "External App Model Text 4"
    var enabled: Boolean = true
    var disabled: Boolean = false
    var visible: Boolean = true
    var invisible: Boolean = false
    var orange: Color = Color.ORANGE
    var blue: Color = Color.blue
    var imgKotlin = "kotlin-logo.png"
}
