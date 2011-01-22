package converter

import swing.{TabbedPane, Reactor, Publisher}

trait ExtensionPage {
  def publishers: List[Publisher]
  def reactions : PartialFunction[Any, Unit]
  def createPage : TabbedPane.Page

  def setListeners(func: (Publisher*) => Unit) = {
      for(p <- publishers) func(p)
  }

  def addToApp(parent: Reactor) : TabbedPane.Page = {
    setListeners(parent.listenTo)
    parent.reactions += reactions
    createPage
  }
}