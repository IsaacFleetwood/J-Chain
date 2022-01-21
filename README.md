# J-Chain

J-Chain is a GUI framework for Java that allows for compact, fluid code via method chaining and callback functions (using lambdas).
The resulting code is verbose, reduces much of Swing's redundancy, and automatically handles storage of the GUI elements.

## Getting Started
In order to get started, you can add add the JChain.jar as a dependency to your project, or compile the project source code yourself. J-Chain has no dependencies, and so it can be easily compiled via standard means. 


To start wiritng code with J-Chain, one simply needs to create a Panel.
```java
Panel panel = new Panel();
```

From there, any GUI items can be added. Then, once the panel is fully created, it can be opened as a GUI window via running the `.open()` method on it.

```java
panel.open();
```

The size of the panel must be set before opening it. This can be done via

```java
panel.setPanelSize(width, height);
```

There are also many other things that can be done to the panel, such as setting the layout manager

```java
panel.setLayout(new GridLayout(2,2))
panel.boxLayout(BoxLayout.Y_AXIS)
```

Then, panels also support tabs and modals.

Tabs are structures where only one tab can be visible at a time, allowing for a menu to have many different views at different times.

```java
panel.addTabPanel("tab-id", new Panel());
panel.openTabPanel("tab-id");
```

Modals are pop-ups that overlay a panel. This allows information to be shown to the user very directly.

```java
panel.addModal("modal-id", new Panel
panel.showModal("modal-id");
```

It should be noted that modals require the user to set the panel size before they become visible. If the panel size is not set, they will be invisible.

## Encapsulations
J-Chain also provides encapsulations of common Swing components to allow for more seamless GUI building.

A Label is a piece of text that is a normal size.

```java
panel.add(new Label("Hello!"));
```

A Heading is a piece of text that is large and bold.

```java
panel.add(new Heading("Hello!"));
```

A TextField is a text field input that has a label above it. It also automatically stores the input for later retrieval.

```java
panel.add(new TextField("Enter your username", "username"));
```

A Button is a button that can run a callback function whenever it is clicked

```java
panel.add(new Button("Click Me!")
    .onClick((Panel __) -> {
      System.out.println("I was clicked!");
    })
);
```

And there are many more, such as a Dropdown, a GapComponent, and a RadioButton.


And lastly, J-Chain also keeps track of user input such that you can access it anywhere.

This is done via a "key" system where keys are given to inputs, and then mapped to the panel they reside in.
This means that you can do something like the following:

```java
panel
  .add(new TextField("Type here!", "key"))
  .add(new Button("Click Me!")
    .onClick((Panel p) -> {
      // The variable p is the panel that the button resides in, which is equal to the panel variable.
      String typedText = p.getInput("key");
      System.out.println(typedText);
    })
  );
```

## Method Chaining

Almost all of the methods in J-Chain support method chaining. This means that running the method returns the object that the method was ran on.

In code, this can allow for reducing unnecessary variables and removing redundant code.

For example,

```java
(new Panel()) // Initialize the panel
  .setPanelSize(300, 200) // Set the panel size
  .add(new Label("Hello!")) // Add a new label
  .add(new Label("Second Label!")) // Add a second label
  .add(new Label("Third!")  // Add a third label
    .margin(50)  // Give the label some margin.
  )
  .open();  // Open the panel
```

Each of the methods were ran via method chaining, which allowed for no variables to have been unneccessarily defined.

## Demos

```java
Panel panel = new Panel();
panel
  .boxLayout(BoxLayout.Y_AXIS)
  .setPanelSize(400, 300)
  .setMargin(0, 50)
  .add(new TextField("Username"))
      .compSetSize(280, 70)
  .add(new TextField("Password"))
      .compSetSize(280, 70)
  .add(new Button("Login")
    .onClick((Panel p) -> {
      String username = p.getInput("Username");
      String password = p.getInput("Password");
      if(username.equals("user") && password.equals("pass")) {
        p.openModal("success");
        return;
      }
      p.openModal("fail");
    })
  )
  .addModal("success", new Panel()
    .setPanelSize(300, 200)
    .add(new Label("Successfully logged in!"))
    .add(new Button("Close")
      .onClick((Panel __) -> {
        panel.closeModal();
      })
    )
  )
  .addModal("fail", new Panel()
    .setPanelSize(300, 200)
    .add(new Label("Unable to login!"))
    .add(new Button("Close")
      .onClick((Panel __) -> {
        panel.closeModal();
      })
    )
  )
  .setFrameName("Login");
panel.open();
```
![Basic Login Menu](https://github.com/IsaacFleetwood/J-Chain/blob/main/screenshots/login-demo.png?raw=true)
![Success Modal](https://github.com/IsaacFleetwood/J-Chain/blob/main/screenshots/login-demo-modal.png?raw=true)
* The panel name, and close/minimize buttons are not visible because I am using a tiling window manager. In normal floating window managers, they will be visible like any other window.
