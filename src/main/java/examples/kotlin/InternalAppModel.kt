package examples.kotlin

import org.uqbar.commons.model.annotations.Observable
import java.awt.Color

@Observable
class InternalAppModel {
    var text1 = "Internal App Model Text 1"
    var text2 = "Internal App Model Text 2"
    var text3 = "Internal App Model Text 3"
    var text4 = "Internal App Model Text 4"
    var text5 = "Internal App Model Text 5"
    var list = listOf("Primer elemento", "Segundo elemento")
    var listFirst = list.size
    var enabled: Boolean = true
    var visible: Boolean = true
    var disabled: Boolean = !enabled
    var invisible: Boolean = !visible
    var orange = Color.ORANGE
    var blue = Color.blue
    var imgArena = "uqbar-arena-logo.png"
    var imgKotlin = "kotlin-logo.png"
}