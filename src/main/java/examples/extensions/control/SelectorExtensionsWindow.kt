package examples.extensions.control

import org.uqbar.arena.windows.MainWindow
import org.uqbar.arena.kotlin.extensions.*
import org.uqbar.arena.widgets.*
import org.uqbar.arena.widgets.List
import org.uqbar.commons.model.annotations.Observable
import java.awt.Color

fun main () = SelectorExtensionsWindow().startApplication()

/**
 * CheckBox extends from Control
 *  - inherits all common behavior
 *  - doesn't add any functionality
 *  - bind value need a boolean property and makes selected/unselected
 */
class SelectorExtensionsWindow : MainWindow<SelectorExtensionsWindow.AppModel>(AppModel()) {
    @Observable data class Item(val name: String)
    @Observable class AppModel {
        var color: Color = Color.RED
        var items = listOf(Item("Item 1"), Item("Item 2"), Item("Item 3"))
        var itemSelected = items.first()
    }

    override fun createContents(mainPanel: Panel) {
        title = "Selector Extensions Window"

        val selector = Selector<Item>(mainPanel)
        selector.bindItemsTo("items").adaptWith(Item::class.java, "name")
        selector.bindColorTo("color")

        val radio = RadioSelector<Item>(mainPanel, "items")
        radio bindSelectedTo "itemSelected"

        val list = List<Item>(mainPanel)
        list.bindItemsTo("items").adaptWith(Item::class.java, "name")
        list bindSelectedTo "itemSelected"
        list bindBackgroundTo "color"

    }

}
