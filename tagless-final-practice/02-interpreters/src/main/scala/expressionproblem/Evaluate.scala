package expressionproblem

import cats.Applicative

object Evaluate {
    object Literal {
        def dsl[F[_]: Applicative] = new Literal[F, Int] {
          override def literal(n: Int): F[Int] = {
              Applicative[F].pure(n)
          }
        }
    }

    object Negation {
        def dsl[F[_]: Applicative] = new Literal[F, Int] {
          override def literal(n: Int): F[Int] = {
              Applicative[F].pure(n)
          }
        }
    }

    object Addition {
        def dsl[F[_]: Applicative] = new Addition[F, Int] {
          override def add(fa: F[Int], fb: F[Int]): F[Int] = Applicative[F].map2(fa, fb)(_ + _)
        }
    }

    object Negation {
        def dsl[F[_]: Applicative] = new Negation[F, Int] {
          override def negate(fa: F[Int]): F[Int] = Applicative[F].map(fa)(e => -e)
        }
    }
}