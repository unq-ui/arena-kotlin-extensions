package examples.extensions.widgets

import org.uqbar.arena.kotlin.extensions.*
import org.uqbar.arena.layout.HorizontalLayout
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.windows.MainWindow
import org.uqbar.commons.model.annotations.Observable

fun main () = PanelExtensionWindow().startApplication()

/**
 * Table Extension Window
 *  - inherits all common behavior from Widget
 *  - adds
 *      + setLayout
 *      + getModelObject
 *      + setWidth
 *      + getWidth
 */
class PanelExtensionWindow : MainWindow<PanelExtensionWindow.AppModel>(AppModel()) {
    @Observable class AppModel

    override fun createContents(mainPanel: Panel?) {
        title = "Panel Extension Window"

        val h1 = Panel(mainPanel)
        h1.layout = HorizontalLayout()
        Label(h1).text = "Label H1-1"
        Label(h1).text = "Label H1-2"

        val v1 = Panel(mainPanel)
        v1.vertical()
        val l = Label(v1)
        l.text = "Label V1-1"
        l.width = 200
        l.height = 75
        Label(v1).text = "Label V1-2"

        val h2 = Panel(mainPanel)
        h2.horizontal()
        Label(h2).text = "Label H1-1"
        Label(h2).text = "Label H1-2"

        val c1 = Panel(mainPanel)
        c1 columns 3
        Label(c1).text = "Label C1-1"
        Label(c1).text = "Label C1-2"
        Label(c1).text = "Label C1-3"
        Label(c1).text = "Label C1-4"
    }
}