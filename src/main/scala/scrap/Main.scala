//package scala.swing
//
//import swing.event._
//
//import codesamples.{Sample}
////import dialogs.{DialogFactory}
//
//class ReactorPage(title: String, content: Component) extends TabbedPane.Page(title, content, "") with Reactor
////{
////  def this (parent0: scala.swing.TabbedPane,title0: String,content0: scala.swing.Component,tip0: String)
////    = this(title0, content0, tip0)
////  def this(title0: String, content0: Component, tip0: String) = this(null, title0, content0, tip0)
////  def this(title0: String, content0: Component) = this(title0, content0, "")
////
////}
//
//object Dialogs extends SimpleSwingApplication {
//  import TabbedPane._
//
//  def stdTextArea :TextArea = new TextArea {
//    text = ""
//    columns = 25
//    rows = 4
//  }
//
//  val input = stdTextArea
//  val output = stdTextArea
//
//  listenTo(input)
//  reactions += {
//    case EditDone(`input`) => Sample.listline(input.text, output)
//  }
//
//  lazy val status = new Label("")
//  lazy val tabs = new TabbedPane {
//    pages += new Page("File", new GridBagPanel { grid =>
//      import GridBagPanel._
//
//      def setGrid(c: Constraints, grid: scala.Tuple2[scala.Int, scala.Int]) :Constraints = {
//        c.grid = grid
//        c
//      }
//
//      val c = new Constraints { fill = Fill.Horizontal }
//
//      layout(new Label("Input Line")) = setGrid(c, 1 -> 1)
//      layout(input)                   = setGrid(c, 2 -> 1)
//      layout(new Label("Output"))     = setGrid(c, 1 -> 3)
//      layout(output)                  = setGrid(c, 2 -> 3)
//      layout(new Button(Action("Parse"){ Sample.listline(input.text, output) })) = setGrid(c, 2 -> 5)
//
//      border = Swing.EmptyBorder(5, 5, 5, 5)
//    })
//  }
//
//  lazy val ui: Panel = new BorderPanel {
//    layout(tabs) = BorderPanel.Position.Center
//    layout(status) = BorderPanel.Position.South
//  }
//
//  lazy val top = new MainFrame {
//    title = "Dialog Demo"
//    contents = ui
//  }
//}
//
