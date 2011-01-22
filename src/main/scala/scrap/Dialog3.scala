package scrap

import scala.swing._
import scala.swing.event._
import scala.swing.TabbedPane._

/**
* Created by IntelliJ IDEA.
* User: fullerp
* Date: 11/01/11
* Time: 07:45
* To change this template use File | Settings | File Templates.
*/

object DialogFactory {
  def getDialog(name: String, top: MainFrame, label: Label) = name match {
    case "Dialog4" => Dialog3.getDialog(top, label)
  }
}

object Dialog3 {
  def getDialog(top: MainFrame, label: Label) = new Page("More Dialogs", new BorderPanel {
      import BorderPanel._
      val mutex = new ButtonGroup
      val pick = new RadioButton("Pick one of several choices")
      val enter = new RadioButton("Enter some text")
      val custom = new RadioButton("Custom")
      val customUndec = new RadioButton("Custom undecorated")
      val custom2 = new RadioButton("2 custom dialogs")
      val radios = List(pick, enter, custom, customUndec, custom2)
      mutex.buttons ++= radios
      mutex.select(pick)
      val buttons = new BoxPanel(Orientation.Vertical) {
        contents ++= radios
      }
      layout(buttons) = Position.North
      layout(new Button(Action("Show It!") {
        import Dialog._
        mutex.selected.get match {
          case `pick` =>
            val possibilities = List("ham", "spam", "yam")
            val s = showInput(buttons,
                      "Complete the sentence:\n\"Green eggs and...\"",
                      "Customized Dialog",
                      Message.Plain,
                      Swing.EmptyIcon,
                      possibilities, "ham")

            //If a string was returned, say so.
            label.text = if ((s != None) && (s.get.length > 0))
              "Green eggs and... " + s.get + "!"
            else
              "Come on, finish the sentence!"
          case `enter` =>
            val s = showInput(buttons,
                      "Complete the sentence:\n\"Green eggs and...\"",
                      "Customized Dialog",
                      Message.Plain,
                      Swing.EmptyIcon,
                      Nil, "ham")

            //If a string was returned, say so.
            label.text = if ((s != None) && (s.get.length > 0))
              "Green eggs and... " + s.get + "!"
            else
              "Come on, finish the sentence!"
          case `custom` =>
            val dialog = new Dialog(top)
            dialog.open()
            dialog.contents = Button("Close Me!") { dialog.close() }
          case `customUndec` =>
            val dialog = new Dialog with RichWindow.Undecorated
            dialog.open()
            dialog.contents = Button("Close Me!") { dialog.close() }
          case `custom2` =>
            val d1 = new Dialog
            val d2 = new Dialog(d1)
            d1.open()
            d2.open()
            d1.contents = Button("Close Me! I am the owner and will automatically close the other one") { d1.close() }
            d2.contents = Button("Close Me!") { d2.close() }
        }
      })) = Position.South
    })
}