package examples.extensions.widgets.control

import org.uqbar.arena.kotlin.extensions.*
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.tables.Column
import org.uqbar.arena.windows.MainWindow
import org.uqbar.arena.widgets.tables.Table
import org.uqbar.commons.model.annotations.Observable

fun main () = TableExtensionsWindow().startApplication()

/**
 * Table Extension Window
 *  - inherits all common behavior from Control
 *  - adds
 *      + bindItemsToProperty
 *      + bindSelectionToProperty
 *      + addColumn
 *      + setItemType
 *      + getItemType
 *      + getColumns
 *      + setNumberVisibleRows
 */
class TableExtensionsWindow : MainWindow<TableExtensionsWindow.AppModel>(AppModel()) {
    @Observable class AppModel {
        var items = listOf(Item(1, "A"), Item(2, "B"), Item(3, "C"), Item(4, "D"))
        var selected = items[2]
    }
    @Observable class Item(val id: Int, val name: String)
    override fun createContents(mainPanel: Panel) {
        title = "Table Extension Window"

        val table = Table(mainPanel, Item::class.java)
        table bindItemsTo "items"
        table bindSelectionTo "selected"
        table.visibleRows = 5

        Column<Item>(table).setTitle("ID").bindContentsToProperty("id")
        Column<Item>(table).setTitle("Name").bindContentsToProperty("name")
    }

}