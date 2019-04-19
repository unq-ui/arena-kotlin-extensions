![Under Development](https://img.shields.io/badge/-under%20development-important.svg)

# Kotlin Extensions for Arena Framework


## Arena MVVM Framework

* [Home Page](http://arena.uqbar-project.org)
* [Repository](https://github.com/uqbar-project/arena)

## About this repository

In order to use Arena with Kotlin in a more pleasant way,
here are some extensions that can help.

## Examples of use

### AppModel using for testing components

```kotlin
@Observable
class ExampleAppModel {
    var labelText = "Soy un texto para un Label"
    var textBoxText = "Soy un texto para un TextBox"
    var enabled: Boolean = true
    var disabled: Boolean = !enabled
    var orange = Color.ORANGE
    var blue = Color.blue
    var image = "uqbar-arena-logo.png"
}
```

### All common abstract Control

```kotlin
import org.uqbar.arena.kotlin.extensions.*

fun main () = ControlExtensionsWindow(ExampleAppModel()).startApplication()

/**
 * Control Extension Window
 */
class ControlExtensionsWindow(model: ExampleAppModel) : MainWindow<ExampleAppModel>(model) {
    override fun createContents(mainPanel: Panel) {
        title = "Ejemplo de Extensiones para abstract class Control"

        val label1 = Label(mainPanel)
        label1.align("center")
        label1.bindToProp("labelText")
        label1.bindColorToProp("orange")

        val label2 = Label(mainPanel)
        label1.align("left")
        label2.bindTo(modelObject, "labelText")
        label2.bindColorTo(modelObject, "blue")

        val textBox1 = TextBox(mainPanel)
        textBox1.bindToProp("textBoxText")
        textBox1.bindEnabledToProp("enabled")
        textBox1.bindColorToProp("blue")

        val textBox2 = TextBox(mainPanel)
        textBox2.bindToProp("textBoxText")
        textBox2.bindEnabledTo(modelObject, "disabled")
        textBox2.bindColorTo(modelObject, "orange")

        Label(mainPanel)
                .setText("Alineado a la Derecha")
                .align("rIghT")
                .bindBackgroundToProp("orange")

        Label(mainPanel)
                .bindBackgroundTo(modelObject, "blue")

        Label(mainPanel)
                .setText("Soy un Label Visible")
                .bindVisibleToProp("enabled")

        Label(mainPanel)
                .setText("Soy un Label Invisible")
                .bindVisible(modelObject, "disabled")
    }
}
```

### All common abstract SkinnableControl

```kotlin
import org.uqbar.arena.kotlin.extensions.*

class SkinnableControlExtensionsWindow(model: ExampleAppModel) : MainWindow<ExampleAppModel>(model) {
    override fun createContents(mainPanel: Panel) {
        title = "Ejemplo de Extensiones para abstract class SkinnableControl"

        val firstLabel = Label(mainPanel)
        firstLabel.background = Color.BLUE

        val secondLabel = Label(mainPanel)
        secondLabel.background = firstLabel.background
    }
}
```

### Label specific properties

```kotlin
import org.uqbar.arena.kotlin.extensions.*

class LabelExtensionsWindow(model: ExampleAppModel) : MainWindow<ExampleAppModel>(model) {
    override fun createContents(mainPanel: Panel) {
        title = "Ejemplo de Extensiones para class Label"
        val labelTxt = Label(mainPanel)
        labelTxt.text = "Arena Framework by Uqbar"
        
        val labelImg = Label(mainPanel)
        labelImg.bindImageToProp("image")
    }
}
```
