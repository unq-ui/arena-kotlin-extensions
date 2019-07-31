package examples.extensions.widgets.control.skinnableControl

import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.Link
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.windows.MainWindow
import org.uqbar.arena.kotlin.extensions.*
import org.uqbar.commons.model.annotations.Observable

fun main () = LinkExtensionsWindow().startApplication()

/**
 * Link Extension Window
 *  - inherits all common behavior from Control & SkinnableControl
 *  - adds
 *      + onClick
 *      + disableOnError
 *      + bindCaptionToProperty
 */
class LinkExtensionsWindow : MainWindow<LinkExtensionsWindow.AppModel>(AppModel()) {
    @Observable class AppModel {
        var clicks = 0
        var link = "Binding no muestra como link"
        fun inc() { clicks++ }
    }
    override fun createContents(mainPanel: Panel) {
        title = "Link Extension Window"

        Label(mainPanel) bindTo "clicks"

        val link = Link(mainPanel)
        link.onClick { this.modelObject.inc() }
        link.text = "Click Me!"

        Link(mainPanel) bindCaptionTo ("link")
    }

}