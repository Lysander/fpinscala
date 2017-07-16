import chapter3._


val ex1: List[Double] = Nil
val ex2: List[Int] = Cons(1, Nil)
val ex3: List[String] = Cons("a", Cons("b", Nil))

val ex4 = Cons(41, ex2)

List.sum(ex4)

List.tail(ex4)

List.setHead(69, ex4)

val ex5 = List(1, 2, 3, 4, 5)

List.drop(ex5, 3)
List.drop(Nil, 1)
List.drop(ex5, 6)

List.dropWhile(ex5, (x: Int) => x < 3)

