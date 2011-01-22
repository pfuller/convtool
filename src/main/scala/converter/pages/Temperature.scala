package converter.pages

import converter.{ExtensionPage}
import swing.{Publisher, TextField, TabbedPane, FlowPanel, Label }
import swing.TabbedPane.{Page}
import swing.event.{EditDone}

/**
 * Tab that converts Celcius to Fahrenheit and back
 */
abstract class Temperature (ps: Publisher*) extends ExtensionPage {
  private val errorMsg = "invalid"

  // Specialised Text field fo this page
  def newField = new TextField {
    text = "0"
    columns = 5
  }

  // Fields that are available to other classes to run the reactions against
  private lazy val celsius = newField
  private lazy val fahrenheit = newField

  override def createPage : TabbedPane.Page = new Page("Conversion", new FlowPanel {
    System.out.println("Adding Converter Page")
    contents += new Label(" Celsius: ")
    contents += celsius
    contents += new Label(" Fahrenheit: ")
    contents += fahrenheit
  })

  // return tuple as a type
  private def calcFahrenheit(c: Int) :Int = c * 9 / 5 + 32
  private def calcCelcius(f: Int) :Int = (f - 32) * 5 / 9

  private def parseInt(s: String):Option[Int] = try {
       Some(Integer.parseInt(s))
    } catch {
        case e: NumberFormatException => None
        case unknown => None
    }

  override def reactions: PartialFunction[Any, Unit] = {
    case EditDone(`fahrenheit`) => parseInt(fahrenheit.text) match {
      case f: Some[Int] => celsius.text = calcCelcius(f.get).toString
      case _              => fahrenheit.text = errorMsg
    }
    case EditDone(`celsius`) => parseInt(celsius.text) match {
      case c: Some[Int] => fahrenheit.text = calcFahrenheit(c.get).toString
      case _            => celsius.text = errorMsg
    }
  }
}

object Temperature extends Temperature {
  // Callback list of publishers
  val ps: List[Publisher] = List(fahrenheit,celsius)
  def publishers: List[Publisher] = ps
}