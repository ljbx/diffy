package com.twitter.diffy.lifter



import org.json4s._
import org.json4s.native._
;

import scala.collection.JavaConversions._
import scala.xml.NodeSeq

object XmlLifter {
  def lift(node: NodeSeq): FieldMap[Any] = node match {
    case doc: NodeSeq =>

      FieldMap(
        Map(
          "content" -> JsonLifter.lift(JsonLifter.decode( prettyJson(renderJValue(decode(doc)))))
        )
      )
  }

  def decode(xml: NodeSeq): JValue = Xml.toJson(xml)
}