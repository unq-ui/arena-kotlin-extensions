package examples.kotlin

import org.uqbar.commons.model.annotations.Observable
import java.awt.Color

@Observable
class ExternalAppModel {
    var text1 = "External App Model Text 1"
    var text2 = "External App Model Text 2"
    var text3 = "External App Model Text 3"
    var text4 = "External App Model Text 4"
    var text5 = "External App Model Text 5"
    var enabled: Boolean = true
    var disabled: Boolean = !enabled
    var visible: Boolean = true
    var invisible: Boolean = !visible
    var orange = Color.ORANGE
    var blue = Color.blue
    var imgArena = "uqbar-arena-logo.png"
    var imgKotlin = "kotlin-logo.png"
}