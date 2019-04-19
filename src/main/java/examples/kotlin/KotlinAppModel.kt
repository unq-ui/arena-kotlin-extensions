package examples.kotlin

import org.uqbar.commons.model.annotations.Observable
import java.awt.Color

@Observable
class KotlinAppModel {
    var text1 = "[K] text 1"
    var text2 = "[K] text 2"
    var text3 = "[K] text 3"
    var text4 = "[K] text 4"
    var text5 = "[K] text 5"
    var enabled: Boolean = true
    var disabled: Boolean = !enabled
    var orange = Color.ORANGE
    var blue = Color.blue
    var imgArena = "uqbar-arena-logo.png"
    var imgKotlin = "kotlin-logo.png"
}