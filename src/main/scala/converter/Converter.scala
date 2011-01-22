package converter

import swing.{SimpleSwingApplication, Label, TabbedPane, BorderPanel, MainFrame, Panel}
import converter.pages.{Temperature}

object PageConverter extends SimpleSwingApplication {
  lazy val status = new Label("")
  val extendedPages : List[ExtensionPage] = List(Temperature)

  def tabs = new TabbedPane {
    for(p <- extendedPages) pages += p.addToApp(this)
  }

  lazy val ui: Panel = new BorderPanel {
    layout(tabs) = BorderPanel.Position.Center
    layout(status) = BorderPanel.Position.South
  }

  lazy val top = new MainFrame {
    title = "Convert Celsius / Fahrenheit"
    contents = ui
  }
}