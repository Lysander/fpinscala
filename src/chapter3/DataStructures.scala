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

  /*
  Exercise 3.6
   */
  def init[A](l: List[A]): List[A] = l match {
    case Nil => Nil
    case Cons(_, Nil) => Nil
    case Cons(h, t) => Cons(h, init(t))
  }

  def foldRight[A, B](as: List[A], z: B)(f: (A, B) => B): B = as match {
    case Nil => z
    case Cons(x, xs) => f(x, foldRight(xs, z)(f))
  }

  def sum2(ns: List[Int]): Int = foldRight(ns, 0)(_ + _)

  def product2(ns: List[Double]): Double = foldRight(ns, 1.0)(_ * _)

  /*
  Exercise 3.9
   */
  def length[A](as: List[A]): Int = foldRight(as, 0)((_, y) => 1 + y)

  /*
  Exercise 3.10
   */
  @annotation.tailrec
  def foldLeft[A, B](as: List[A], z: B)(f: (B, A) => B): B = as match {
    case Nil => z
    case Cons(h, t) => foldLeft(t, f(z, h))(f)
  }

  /*
  Exercise 3.11
   */
  def sum3(ns: List[Int]): Int = foldLeft(ns, 0)(_ + _)

  def product3(ns: List[Double]): Double = foldLeft(ns, 1.0)(_ * _)

  def length3[A](as: List[A]): Int = foldLeft(as, 0)((acc, _) => acc + 1)

  /*
  Exercise 3.12
   */
  def reverse[A](l: List[A]): List[A] = foldLeft(l, List[A]())((acc,h) => Cons(h,acc))

  /*
  Exercise 3.14
   */
  //def appendViaFoldLeft[A](l: List[A], x: A): List[A]
}