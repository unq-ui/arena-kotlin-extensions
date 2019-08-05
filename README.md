[![](https://jitpack.io/v/unq-ui/arena-kotlin-extensions.svg)](https://jitpack.io/#unq-ui/arena-kotlin-extensions)

# Kotlin Extensions for Arena Framework

## Arena MVVM Framework

* [Home Page](http://arena.uqbar-project.org)
* [Repository](https://github.com/uqbar-project/arena)

## About this repository

This package allows you to use Arena with Kotlin in a more pleasant way.

It provides some extensions that take advantage of Kotlin's functionality,
as well as the possibility of [extending the classes](https://kotlinlang.org/docs/reference/extensions.html)
and [high order functions](https://kotlinlang.org/docs/reference/lambdas.html).

## Dependency

You need to add this code to your `pom.xml`

```xml
<!-- ... project definition ... -->

<repositories>
  <repository>
    <id>jitpack.io</id>
    <url>https://jitpack.io</url>
  </repository>
  <repository>
    <id>uqbar</id>
    <name>Uqbar</name>
    <url>http://maven.uqbar.org/releases/</url>
  </repository>
</repositories>

<parent>
  <groupId>org.uqbar-project</groupId>
  <artifactId>arena-xtend-parent</artifactId>
  <version>3.6.3</version>
</parent>

<!-- ... your stuff ... -->

<dependencies>
  <dependency>
    <groupId>com.github.unq-ui</groupId>
    <artifactId>arena-kotlin-extensions</artifactId>
    <version>1.2.1</version>
  </dependency>
  <!-- ... others dependencies ... -->
</dependencies>

<!-- ... the rest of pom ... -->
```

## How to use

> **Important:** You always have to add this import:

`import org.uqbar.arena.kotlin.extensions.*`

### Quick Start

```kt
package examples

import java.awt.Color
import org.uqbar.arena.widgets.*
import org.uqbar.arena.windows.MainWindow
import org.uqbar.arena.kotlin.extensions.*
import org.uqbar.commons.model.annotations.Observable

fun main() = ExampleWindow(AppModel(42, Color.YELLOW)).startApplication()

@Observable class AppModel(var number: Int, var bg: Color)

class ExampleWindow(model: AppModel) : MainWindow<AppModel>(model) {
  override fun createContents(mainPanel: Panel) {
    title = "Example"
    Label(mainPanel) with {
      text = "Soy un label"
      bindBackgroundTo("bg")
    }
    TextBox(mainPanel) with {
      bindTo("number")
    }
  }
}
```

### Components

* Inputs
  + [Text Boxes](#text-boxes)
  + [Numeric Fields](#numeric-fields)
  + [Password Fields](#password-fields)
  + [Text Areas](#text-areas)
  + [Spinners](#spinners)
* [Labels](#labels)
* Options
  + [Selectors](#selectors)
  + [Lists](#lists)
  + [Radio Selectors](#radio-selectors)
* [Check Boxes](#check-boxes)
* Actions
  + [Buttons](#buttons)
  + [Links](#links)
  + [File Selectors](#file-selectors)
* [Tables](#tables)
* Trees (**TODO**)
* Types of Panels
  + [Panels](#panels)
  + [Group Panels](#group-panels)

#### Inputs

##### Text Boxes

```kt
TextBox(mainPanel) with {
  height = 20
  width = 45
  bindTo("textBoxText")
  bindColorTo("blue")
  bindEnabledTo("enabled")
  withFilter { it.inputText.toString().contains("a") }
}

TextBox(mainPanel) with {
  fontSize = 24
  align = "center" // right, left, center
  color = Color.YELLOW
  bgColor = Color.BLUE
  bindTo("textBoxText")
}
```

##### Numeric Fields

```kt
NumericField(mainPanel) with {
  height = 20
  width = 45
  bindTo("number")
  bindColorTo("blue")
  bindEnabledTo("enabled")
  withDecimals = false  
}

NumericField(mainPanel) with {
  fontSize = 20
  color = Color.WHITE
  bgColor = Color.BLACK
  withDecimals = true
  bindTo("number")
}
```

##### Password Fields

```kt
PasswordField(mainPanel) props {
  bindTo("password")
  fontSize = 20
}
```

##### Text Areas

```kt
KeyWordTextArea(mainPanel) with {
  height = 200
  bindTo("textBoxText")
  bindColorTo("blue")
  bindEnabledTo("enabled")
}
```

##### Spinners

```kt
Spinner(mainPanel) with {
  width = 50
  minValue = 2
  maxValue = 10
}
```

#### Labels

```kt
Label(mainPanel) with {
  text = "Ejemplo"
  width = 400
  height = 200
  fontSize = 16
  align = "center"
  color = Color.BLUE
  bgColor = Color.CYAN
}

Label(mainPanel) with {
  bindTo("text")
  bindColorTo("blue")
  bindBackgroundTo("orange")
  bindEnabledTo("enabled")
  bindVisibleTo("visible")
}
```

#### Options

##### Selectors

```kt
Selector<Item>(mainPanel) with {
  bindItemsTo("items").adaptWithProp<Item>("name")
  bindColorTo("color")
}
```

##### Lists

```kt
List<Item>(mainPanel) with {
  bindItemsTo("items").adaptWithProp<Item>("name")
  bindSelectedTo("itemSelected")
  bindBackgroundTo("color")
}
```

##### Radio Selectors

```kt
RadioSelector<Item>(mainPanel) with {
  bindItemsTo("items")
  bindSelectedTo("itemSelected")
}
```

#### Check Boxes

```kt
CheckBox(it) with {
  bindTo("selected")
  bindEnabledTo("disabled")
  bindBackgroundTo("color")
}
```

#### Actions

##### Buttons

```kt
Button(mainPanel) with {
  caption = "Button 1 Blue"
  color = Color.BLUE
  fontSize = 14

Button(mainPanel) with {
  text = "Click Me again" // text is an alias of caption
  color = Color.RED
  setAsDefault()
}

Button(mainPanel) with {
  bindCaptionTo("buttonName")
  onClick { modelObject.inc() }
}
```

##### Links

```kt
Link(mainPanel) with {
  text = "Click Me!"
  onClick { modelObject.inc() }
}

Link(mainPanel) with {
  caption = "No hago nada!"
}
```

##### File Selectors

```kt
FileSelector(mainPanel) with {
  title = "Title of the selection window"
  caption = "Seleccionar archivo..."
  path = "/home"                // Path where selection window open by default
  bindTo("storage")             // Where file selected will be saved
  extensions("*.txt", "*.png")  // Extensions allowed
}

FileSelector(mainPanel) props {
  path = "/home"
  setAsDefault()
  bindTo("storage")
  bindCaptionTo("caption")
}
```

#### Tables

```kt
table<Item>(mainPanel) {
  bindItemsTo("items")
  bindSelectionTo("selected")
  visibleRows = 5
  column {
    title = "ID"
    fixedSize = 30
    bindContentsTo("id")
    bindBackgroundTo("blue")
  }
  column {
    title = "Name"
    weight = 50
    align("center")
    bindContentsTo("name")
  }
  column {
    title = "Description"
    background = Color.BLACK
    align("right")
    bindContentsTo("description")
  }
}
```

#### Types of Panels

##### Panels

```kt
Panel(mainPanel) with {
  asVertical()
  width = 250
  Label(it) with {
    text = "Label V1-1"
    width = 200
    height = 75
  }
  Label(it) with { text = "Label V1-2" }
}

Panel(mainPanel) with {
  asHorizontal()
  Label(it) props { text = "Label H1-1" }
  Label(it) props { text = "Label H1-2" }
}

Panel(mainPanel) with {
  asColumns(3)
  Label(it) with { text = "Label C1-1" }
  Label(it) with { text = "Label C1-2" }
  Label(it) with { text = "Label C1-3" }
}
```

##### Group Panels

```kt
GroupPanel(mainPanel) with {
  title = "Group Panel"
  asHorizontal()
  Label(it) with { text = "Label H1-1" }
  Label(it) with { text = "Label H1-2" }
}
```
