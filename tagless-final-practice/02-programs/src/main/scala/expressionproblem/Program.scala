package expressionproblem

trait Program[F[_], A] {
    def run: F[A]
}

object Program {
    object Expression {
        def dsl[F[_], A](
        implicit
        L: Literal[F, A],
        N: Negation[F, A],
        A: Addition[F, A]): Program[F, A] = new Program[F, A] {
            import L._, N._, A._

            // implicit resolution imports interpreters
            def run: F[A] = {
                add(
                    literal(1), 
                    negate(
                        add(
                            literal(1),
                            literal(2)
                        )
                    )
                )
            }
        } 
    }
}