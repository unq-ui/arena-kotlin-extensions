package examples.extensions.widgets

import org.uqbar.arena.layout.HorizontalLayout
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.windows.MainWindow
import org.uqbar.arena.kotlin.extensions.*
import org.uqbar.commons.model.annotations.Observable

fun main () = PanelWindow().startApplication()

/**
 * Panel Window
 */
class PanelWindow : MainWindow<PanelWindow.AppModel>(AppModel()) {
    @Observable class AppModel

    override fun createContents(mainPanel: Panel) {
        title = "Panel Window"

        mainPanel.layout = HorizontalLayout()
        Label(mainPanel) with { text = "Label H1-1" }
        Label(mainPanel) props { text = "Label H1-2" }

        Panel(mainPanel) with {
            it.asVertical()
            width = 250
            Label(it) with {
                text = "Label V1-1"
                width = 200
                height = 75
            }
            Label(it) with { text = "Label V1-2" }

        }

        Panel(mainPanel) with {
            asHorizontal()
            Label(it) with { text = "Label H1-1" }
            Label(it) with { text = "Label H1-2" }
        }

        Panel(mainPanel) props {
            layout = HorizontalLayout()
            Label(it) props { text = "Label H1-1" }
            Label(it) props { text = "Label H1-2" }
        }

        Panel(mainPanel) with {
            it asColumns 3
            Label(it) with { text = "Label C1-1" }
            Label(it) with { text = "Label C1-2" }
            Label(it) with { text = "Label C1-3" }
            Label(it) with { text = "Label C1-4" }
        }
    }
}
