package chapter3

sealed trait List[+A]

case object Nil extends List[Nothing]

case class Cons[+A](head: A, tail: List[A]) extends List[A]

object List {
  def sum(ints: List[Int]): Int = ints match {
    case Nil => 0
    case Cons(x, xs) => x + sum(xs)
  }

  def product(ds: List[Double]): Double = ds match {
    case Nil => 1.0
    case Cons(0.0, _) => 0.0
    case Cons(d, tail) => d * product(tail)
  }

  def apply[A](as: A*): List[A] =
    if (as.isEmpty) Nil
    else Cons(as.head, apply(as.tail: _*))

  /*
  Exercise 3.2
   */
  def tail[A](as: List[A]): List[A] = as match {
    case Nil => Nil // could also be an error!
    case Cons(_, tail) => tail
  }

  /*
  Exercise 3.3
   */
  def setHead[A](head: A, as: List[A]): List[A] = as match {
    case Nil => Cons(head, Nil)
    case Cons(_, tail) => Cons(head, tail)
  }

  /*
  Exercise 3.4
   */
  @annotation.tailrec
  def drop[A](l: List[A], n: Int): List[A] =
  if (n > 0) l match {
    case Nil => l
    case Cons(_, tail) => drop(tail, n - 1)
  }
  else l

  /*
  Exercise 3.5
   */
  @annotation.tailrec
  def dropWhile[A](l: List[A], f: A => Boolean): List[A] = l match {
    case Nil => l
    case Cons(head, tail) => if (f(head)) dropWhile(tail, f) else l
  }

}