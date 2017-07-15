import chapter2.MyModul.formatResult
import chapter2.MyModul.fib
import chapter2.MyModul.isSorted
import chapter2.MyModul.curry

formatResult("Fibonacci number", 5, fib)
Range(1, 10).map(fib).toString()

def comp(a: Int, b: Int): Boolean = a < b


isSorted[Int](Array[Int](1, 2, 4, 3), (a: Int, b: Int) => a < b)

isSorted(Array[String]("Apfel", "Banane", "D", "Citrone"), (a: String, b: String) => a < b)

val f = (a: Int, b: Int) => a + b
f(1, 2)
val curried = curry[Int, Int, Int](f)
val threePlus = curried(3)
threePlus(10)
threePlus(1)

