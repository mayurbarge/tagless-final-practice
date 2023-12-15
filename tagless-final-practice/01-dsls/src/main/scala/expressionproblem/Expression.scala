package expressionproblem

trait Literal[F[_], A] {
  def literal(n: Int): F[A]
}

trait Negation[F[_], A] {
    def negate(a: F[A]): F[A]
}

trait Addition[F[_], A] {
    def add(fa: F[A], fb: F[A]): F[A]
}

trait Multiplication[F[_], A] {
    def multiply(fa: F[A], fb: F[A]): F[A]
}

trait Division[F[_], A] {
    def divide(fa: F[A], fb: F[A]): F[A]
}
