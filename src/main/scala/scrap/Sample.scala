package scrap

import swing._
import swing.event._

object Sample {
  def splitList(line: String, delim: List[String], tc: TextComponent): Unit = delim match {
    case head :: tail => for (item <- line.split(head).toList) splitList(item, tail, tc)
    case Nil => tc.text = tc.text + "\n" + line.trim
  }

  def listline(line: String, tc: TextComponent) = {
    tc.text = ""
    splitList(line, List(",", "and", "&"), tc)
  }

  // Simple
  // def listline(line: String) = for(i <- line.split(",").toList) println(i.trim)
}