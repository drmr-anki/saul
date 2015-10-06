package edu.illinois.cs.cogcomp.saulexamples.nlp.EmailSpam

import edu.illinois.cs.cogcomp.saul.datamodel.DataModel
import edu.illinois.cs.cogcomp.saul.datamodel.DataModel._
import edu.illinois.cs.cogcomp.saul.datamodel.attribute.Attribute
import edu.illinois.cs.cogcomp.saul.datamodel.edge.Edge
import edu.illinois.cs.cogcomp.saul.datamodel.node.Node
import edu.illinois.cs.cogcomp.saulexamples.data.Document

import scala.collection.JavaConversions._
import scala.collection.mutable.{ Map => MutableMap }

object spamDataModel extends DataModel {

  val docs = node[Document]
  val NODES: List[Node[_]] = ~~(docs)

  val wordFeature = discreteAttributesGeneratorOf[Document]('wordF) {
    x: Document => x.getWords.toList
  }

  val bigramFeature = discreteAttributesGeneratorOf[Document]('bigram) {

    x: Document =>
      {
        val words = x.getWords.toList
        var big: List[String] = List()
        for (i <- 0 until words.size - 1)
          big = (words.get(i) + "-" + words.get(i + 1)) :: big
        big
      }
  }

  val spamLable = discreteAttributeOf[Document]('label) {
    x: Document => x.getLabel

  }
  val PROPERTIES: List[Attribute[_]] = List(wordFeature, bigramFeature)
  val EDGES: List[Edge[_, _]] = Nil
}
