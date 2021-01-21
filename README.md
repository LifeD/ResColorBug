# ResColorBug
Bug with color resources and changing alpha channel in Android

We have 2 colors with same HEX in colors.xml. In main activity we set first color to background of view and set alpha channel to this view.

Then we go to second activity where we set second color to background of another view via XML. But this color is applied with alpha we set on main activity.
How is it possible? It's not even the same color resource.
