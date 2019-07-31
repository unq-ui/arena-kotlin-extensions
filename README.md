[![](https://jitpack.io/v/unq-ui/arena-kotlin-extensions.svg)](https://jitpack.io/#unq-ui/arena-kotlin-extensions)

# Kotlin Extensions for Arena Framework


## Arena MVVM Framework

* [Home Page](http://arena.uqbar-project.org)
* [Repository](https://github.com/uqbar-project/arena)

## About this repository

In order to use Arena with Kotlin in a more pleasant way,
here are some extensions that can help.

## How to use

There are two ways to use Arena with this Kotlin package: **Extensions** and **Native Components**.

### Extensions

Using Arena without kotlin extensions result in code like this:

```kt
class ExampleWindow(model: AppModel) : MainWindow<AppModel>(model) {
  override fun createContents(mainPanel: Panel) {
    title = "Example" 
    Label(mainPanel)
        .setText("Soy un label")
        .bindBackgroundToProperty<ControlBuilder, Any, Any>("bg")
    TextBox(mainPanel)
        .bindValueToProperty<Double, ControlBuilder>("number")
  }
}
```

Because sometimes Kotlin can't infer types of generics, so you need to write generics explicitly,
making code with a lot of verbosity.

With extensions you can create components in a less verbose way:

```kt
import org.uqbar.arena.kotlin.extensions.*

class ExampleWindow(model: AppModel) : MainWindow<AppModel>(model) {
  override fun createContents(mainPanel: Panel) {
    title = "Example" 
    Label(mainPanel)
        .setText("Soy un label")
        .bindBackgroundTo("bg")
    TextBox(mainPanel).bindTo("number")
  }
}
```

In addition, as Kotlin allows to create
[infix functions](https://kotlinlang.org/docs/reference/functions.html#infix-notation),
you can rewrite that code as follow:

```kt
import org.uqbar.arena.kotlin.extensions.*

class ExampleWindow(model: AppModel) : MainWindow<AppModel>(model) {
  override fun createContents(mainPanel: Panel) {
    title = "Example" 

    val label = Label(mainPanel).setText("Soy un label")
    label bindBackgroundTo "bg"
    
    TextBox(mainPanel) bindTo "number"
  }
}
```

To know how to use all Kotlin extensions for Arena, go to [Kotlin Extensions Page](kotlin_extensions.md).

### Native Components

To go a step further, we can wrap all components to get a better code syntax.

Using [infix functions](https://kotlinlang.org/docs/reference/functions.html#infix-notation)
and
[high order functions](https://kotlinlang.org/docs/reference/lambdas.html)
we can create a [DSL](https://en.wikipedia.org/wiki/Domain-specific_language)
Syntax for Arena.

So now we can write this kind of code

```kt
import org.uqbar.arena.windows.MainWindow
import org.uqbar.arena.kotlin.widgets.Panel
import org.uqbar.arena.kotlin.widgets.Label
import org.uqbar.arena.kotlin.widgets.TextBox

class ExampleWindow(model: AppModel) : MainWindow<AppModel>(model) {
  override fun createContents(mainPanel: Panel) {
    title = "Example" 

    // We can use any of this alternatives
    Label(mainPanel) {
        text = "Soy un label"
        width(200)
        it bindBackgroundTo "bg"
        content color Color.BLUE
    }
    
    TextBox(mainPanel) bindTo "number"
  }
}
```

To see more examples go to [code of Label Examples](./src/main/java/examples/kotlin)
