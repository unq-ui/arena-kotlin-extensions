package examples.extensions.widgets.control

import java.awt.Color
import org.uqbar.arena.widgets.List
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.Selector
import org.uqbar.arena.windows.MainWindow
import org.uqbar.arena.widgets.RadioSelector
import org.uqbar.arena.kotlin.extensions.*
import org.uqbar.commons.model.annotations.Observable

fun main () = SelectorWithBlockWindow().startApplication()

/**
 * CheckBox extends from Control
 *  - inherits all common behavior
 *  - doesn't add any functionality
 *  - bind value need a boolean property and makes selected/unselected
 */
class SelectorWithBlockWindow : MainWindow<SelectorWithBlockWindow.AppModel>(AppModel()) {
    @Observable data class Item(val name: String)
    @Suppress("unused") @Observable class AppModel {
        var color: Color = Color.RED
        var items = listOf(Item("Item 1"), Item("Item 2"), Item("Item 3"))
        var itemSelected = items.first()
    }

    override fun createContents(mainPanel: Panel) {
        title = "Selector Extensions Window"

        Selector<Item>(mainPanel) with {
            bindItemsTo("items").adaptWithProp<Item>("name")
            bindColorTo("color")
        }

        RadioSelector<Item>(mainPanel) with {
            it bindItemsTo "items"
            it bindSelectedTo "itemSelected"
        }

        List<Item>(mainPanel) with { content ->
            bindItemsTo("items").adaptWithProp<Item>("name")
            content bindSelectedTo "itemSelected"
            content bindBackgroundTo "color"
        }

    }

}
