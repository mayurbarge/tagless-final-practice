package expressionproblem


import cats._
//import cats.data._
//import cats.instances.all._

object Main extends App {

    println("_" * 100)
    println(
    Program
        .Expression
        .dsl[Id, String](
            View.Literal.dsl,
            View.Negation.dsl,
            View.Addition.dsl
        )
        .run
    )
        
    println("_" * 100)
}