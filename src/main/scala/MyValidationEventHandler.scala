package generated

import javax.xml.bind.ValidationEvent
import javax.xml.bind.ValidationEventHandler

class MyValidationEventHandler extends ValidationEventHandler {
  def handleEvent(event: ValidationEvent): Boolean = {
    println("\nEVENT")
    println("SEVERITY:  " + event.getSeverity())
    println("MESSAGE:  " + event.getMessage())
    println("LINKED EXCEPTION:  " + event.getLinkedException())
    println("LOCATOR")
    println("    LINE NUMBER:  " + event.getLocator().getLineNumber())
    println("    COLUMN NUMBER:  " + event.getLocator().getColumnNumber())
    println("    OFFSET:  " + event.getLocator().getOffset())
    println("    OBJECT:  " + event.getLocator().getObject())
    println("    NODE:  " + event.getLocator().getNode())
    println("    URL:  " + event.getLocator().getURL())
    true
  }

}
