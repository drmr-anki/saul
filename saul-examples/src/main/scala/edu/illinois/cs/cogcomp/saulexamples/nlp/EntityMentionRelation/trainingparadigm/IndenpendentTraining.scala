package edu.illinois.cs.cogcomp.saulexamples.nlp.EntityMentionRelation.trainingparadigm

import edu.illinois.cs.cogcomp.saulexamples.nlp.EntityMentionRelation.Classifiers._
import edu.illinois.cs.cogcomp.saulexamples.nlp.EntityMentionRelation.ErDataModelExample

/** Created by haowu on 5/6/15.
  */
object IndenpendentTraining {

  val it = 5

  def trainIndepedent(it: Int): Unit = {
    println("Indepent Training with iteration " + it)
    PersonClassifier.learn(it)
    PersonClassifier.test()
    orgClassifier.learn(it)
    orgClassifier.test()
    LocClassifier.learn(it)
    LocClassifier.test()
    workForClassifier.learn(it)
    workForClassifier.test()
    LivesInClassifier.learn(it)
    LivesInClassifier.test()
  }

  def cv(it: Int): Unit = {

    println("Running CV " + it)

    PersonClassifier.crossValidation(it)
    orgClassifier.crossValidation(it)
    LocClassifier.crossValidation(it)

    workForClassifier.crossValidation(it)
    LivesInClassifier.crossValidation(it)

  }

  //
  //This is for to remove the models and start training from scratch.
  def forgotEverything() = {
    PersonClassifier.forget()
    orgClassifier.forget()
    //    PersonClassifier.forgot()
    workForClassifier.forget()
  }

  def main(args: Array[String]) {
    forgotEverything()
    ErDataModelExample.readAll()
    trainIndepedent(it)
  }

}
