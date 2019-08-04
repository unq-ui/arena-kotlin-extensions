package examples.extensions.widgets.control

import java.awt.Color
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.windows.MainWindow
import org.uqbar.arena.widgets.tables.Table
import org.uqbar.arena.widgets.tables.Column
import org.uqbar.arena.kotlin.extensions.*
import org.uqbar.commons.model.annotations.Observable

fun main () = TableWindow().startApplication()

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
class TableWindow : MainWindow<TableWindow.AppModel>(AppModel()) {
    @Observable @Suppress("unused")
    class AppModel {
        var items = listOf(
                Item(1, "A", "Coso A"),
                Item(2, "B", "Coso B"),
                Item(3, "C", "Coso C"),
                Item(4, "D", "Coso D")
        )
        var selected = items[2]
    }
    @Observable @Suppress("unused")
    data class Item(val id: Int, val name: String, val description: String) {
        val blue: Color = Color.BLUE
        val yellow: Color = Color.YELLOW
    }

    override fun createContents(mainPanel: Panel) {
        title = "Table Window"

        newTable<Item>(mainPanel) with {
            it bindItemsTo "items"
            it bindSelectionTo "selected"
            visibleRows = 5
        }

        newTable<Item>(mainPanel) {
            it bindItemsTo "items"
            it bindSelectionTo "selected"
            visibleRows = 5
            column {
                title = "ID"
                bindContentsTo("id")
            }
            column { col ->
                col.title = "Name"
                col bindContentsTo "name"
            }
        }

        Table(mainPanel, Item::class.java) with {
            it bindItemsTo "items"
            it bindSelectionTo "selected"
            visibleRows = 5
            Column(it) with {
                title = "ID"
                bindContentsTo("id")
            }
            Column(it) with {
                title = "Name"
                bindContentsTo("name")
            }
            Column(it) with { col ->
                col.title = "Descrip"
                col bindContentsTo "description"
            }
        }


        newTable<Item>(mainPanel) {
            it bindItemsTo "items"
            it bindSelectionTo "selected"
            visibleRows = 5

            column {
                title = "ID"
                fixedSize = 30
                bindColorTo("yellow")
                bindContentsTo("id")
                bindBackgroundTo("blue")
            }

            column {
                title = "Name"
                weight = 50
                color = Color.BLACK
                background = Color.WHITE
                align("center")
                bindContentsTo("name")
            }

            column {
                title = "Description"
                fontSize = 20
                color = Color.WHITE
                background = Color.BLACK
                align("right")
                bindContentsTo("description")
            }
        }
    }
}
