package chapter2

/**
  * Created by christian on 09.07.2017.
  */
object MyModul {

  def fib(n: Int): Int = {
    @annotation.tailrec
    def go(a: Int, b: Int, count: Int): Int =
      if (count > 0) go(b, a + b, count - 1)
      else a + b

    go(0, 1, n)
  }

  def formatResult(name: String, n: Int, f: Int => Int): String = {
    val message = "The %s of %d id %d."
    message.format(name, n, f(n))
  }

  /*
  Exercise 2.2
   */
  def isSorted[A](as: Array[A], ordered: (A, A) => Boolean): Boolean = {
    @annotation.tailrec
    def loop(n: Int): Boolean =
      if (n >= as.length - 1) true
      else if (!ordered(as(n), as(n + 1))) false
      else loop(n + 1)

    if (as.length < 2) true
    else loop(0)
  }

  /*
  Exercise 2.3
   */
  def curry[A, B, C](f: (A, B) => C): A => (B => C) =
    (a: A) => (b: B) => f(a, b)

  /*
  Exercise 2.4
   */
  def uncurry[A, B, C](f: A => B => C): (A, B) => C =
    (a: A, b: B) => f(a)(b)

  /*
  Exercise 2.5
   */
  def compose[A, B, C](f: B => C, g: A => B): A => C =
    (a: A) => f(g(a))
}

