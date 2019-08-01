package examples.extensions.widgets.control

import java.awt.Color
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
        var items = listOf(
                Item(1, "A", "Coso A"),
                Item(2, "B", "Coso B"),
                Item(3, "C", "Coso C"),
                Item(4, "D", "Coso D")
        )
        var selected = items[2]
    }
    @Suppress("unused")
    @Observable
    class Item(val id: Int, val name: String, val description: String) {
        val blue: Color = Color.BLUE
        val yellow: Color = Color.YELLOW
    }
    override fun createContents(mainPanel: Panel) {
        title = "Table Extension Window"

        val table = Table(mainPanel, Item::class.java)
        table bindItemsTo "items"
        table bindSelectionTo "selected"
        table.visibleRows = 5

        val c1 = Column<Item>(table)
        c1.title = "ID"
        c1.fixedSize = 30
        c1 bindContentsTo "id"
        c1 bindBackgroundTo "blue"
        c1 bindColorTo "yellow"

        val c2 = Column<Item>(table)
        c2.background = Color.WHITE
        c2.color = Color.BLACK
        c2.weight = 50
        c2.setTitle("Name")
        c2.align("center")
        c2.bindContentsToProperty("name")

        val c3 = Column<Item>(table)
        c3.title = "Name2"
        c3.background = Color.BLACK
        c3.color = Color.WHITE
        c3.fontSize = 12
        c3.align("right")
        c3.bindContentsToProperty("description")
    }

}