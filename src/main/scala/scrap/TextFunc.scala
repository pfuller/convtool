package scrap

import swing._
import swing.event._

object TextFunc { // extends SimpleSwingApplication {
  val input = new TextField {
    text = ""
    columns = 5
  }

  val output = new TextArea {
    text = ""
    columns = 5
    rows = 5
  }

  val panel = new BorderPanel()
  panel.preferredSize = new java.awt.Dimension(500,300)
  panel.layout += input ->  BorderPanel.Position.North
  panel.layout += output -> BorderPanel.Position.South

  input.text = "abc,def,ghi, jkl and mno & pqr"

  def top = new MainFrame {
    title = "Text Function"
    contents = panel
  }

//  listenTo(input)
//
//  reactions += {
//    case EditDone(`input`) => Sample.listline(input.text, output)
//  }
}