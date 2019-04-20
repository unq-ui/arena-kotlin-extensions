# Kotlin Extensions for Arena Framework


## Arena MVVM Framework

* [Home Page](http://arena.uqbar-project.org)
* [Repository](https://github.com/uqbar-project/arena)

## About this repository

> **Under development** 

In order to use Arena with Kotlin in a more pleasant way,
here are some extensions that can help.

## How to use

There are two ways to use Arena with this Kotlin package: extensions only or with native components.

### Extensions

The first approach was to create some extensions to write components y a less verbose way.

If you use Arena in kotlin directly, you should write code like this:

```kt
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.TextBox
import org.uqbar.arena.windows.MainWindow

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

Sometimes Kotlin can't infer types of generics, so you need to write it explicitly,
making code with a lot of verbosity.

In order to improve this, extensions can help to wrap this code with a little best syntax.

For example, these extensions for `Control` make code less verbose when you need to bind:

```kt
infix fun Control.bindBackgroundTo(propertyName: String): Binding<*, Control, ControlBuilder> =
        this.bindBackgroundToProperty<ControlBuilder, Any, Any>(propertyName)
        
infix fun Control.bindBackgroundTo(propertyName: String): Binding<*, Control, ControlBuilder> =
        this.bindBackgroundToProperty<ControlBuilder, Any, Any>(propertyName)
```

Now we can code like this: 

```kt
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.TextBox
import org.uqbar.arena.windows.MainWindow
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

But Kotlin allows to create
[infix](https://kotlinlang.org/docs/reference/functions.html#infix-notation)
functions, so we can rewrite that code as follow:

```kt
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.TextBox
import org.uqbar.arena.windows.MainWindow
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

To know how to use all Kotlin extensions for Arena, go to [Kotlin Extensions Page (TODO)](#).

### Native Components

To go a step further, we can wrap all components to get a better code syntax.

Using [infix functions](https://kotlinlang.org/docs/reference/functions.html#infix-notation)
and
[high order functions](https://kotlinlang.org/docs/reference/lambdas.html)
we can create a [DSL](https://en.wikipedia.org/wiki/Domain-specific_language)
Syntax for Arena.

So now we can write this kind of code

```
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
