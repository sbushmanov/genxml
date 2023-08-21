package generated

import java.io.BufferedOutputStream
import java.io.FileOutputStream
import java.io.PrintWriter
import java.io.File

import java.math.BigDecimal

import javax.xml.bind.JAXBContext
import javax.xml.bind.JAXBElement
import javax.xml.bind.Marshaller

import javax.xml.validation.Schema
import javax.xml.validation.SchemaFactory
import javax.xml.XMLConstants


object Main extends App {

  val sourceFile = io.Source.fromFile("file.csv")

  sourceFile.getLines.zipWithIndex.foreach { case (line, i) =>
    val col = line.split(";").map(_.trim)

    val target  = new BufferedOutputStream(new FileOutputStream(s"out.xml_$i"))
    val factory = new ObjectFactory()
    val expense = factory.createExpenseT()

    val user     = factory.createUserT()
    val item     = factory.createItemT()
    val itemList = factory.createItemListT()

    user.setUserName(col(0))
    item.setItemName(col(1))
    item.setPurchasedOn(col(2))
    item.setAmount(new BigDecimal(col(3).toInt))

    expense.setUser(user)
    itemList.getItem().add(item)
    itemList.getItem().add(item)
    itemList.getItem().add(item)
    expense.setItems(itemList)
    
    val sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI)
    val schema = sf.newSchema(new File("expense.xsd"))

    val element    = factory.createExpenseReport(expense)
    val context    = JAXBContext.newInstance("generated")
    val marshaller = context.createMarshaller()
    marshaller.setProperty("jaxb.formatted.output", true)
    marshaller.setSchema(schema)
    marshaller.setEventHandler(new MyValidationEventHandler())
    marshaller.marshal(element, target)
    target.close

  }

  sourceFile.close()
}
