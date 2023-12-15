package expressionproblem

import cats.Applicative
import cats.Apply
import cats._

object View {
    object Literal {
        def dsl[F[_]: Applicative]: Literal[F, String] =
            new Literal[F, String] {
            override def literal(n: Int): F[String] = Applicative[F].pure(s"${n}")
        }
    }

    object Negation {
        def dsl[F[_]: Functor]: Negation[F, String] = new Negation[F, String] {
            def negate(fa: F[String]): F[String] = Functor[F].fmap(fa)("(-" + _ + ")")
        }
    }

    object Addition {
        def dsl[F[_]: Apply]: Addition[F, String] = new Addition[F, String] {
            def add(fa: F[String], fb: F[String]): F[String] = Apply[F].map2(fa, fb)((a,b) => s"(${a} + ${b}")
        }
    }

    object Multiplication {
        def dsl[F[_]: Apply]: Multiplication[F, String] = new Multiplication[F, String] {
            def multiply(fa: F[String], fb: F[String]): F[String] = Apply[F].map2(fa, fb)((a,b) => s"(${a} * ${b}")
        }
    }
    
    object Division {
        def dsl[F[_]: Apply]: Division[F, String] = new Division[F, String] {
            def divide(fa: F[String], fb: F[String]): F[String] = Apply[F].map2(fa, fb)((a,b) => s"(${a} / ${b}")
        }
    }

}