// package lectures.part3fp

object MapFlatmapFilterFor extends App {

  // list
  val list = List(1,2,3)                  // calling the print function on this list returns List(1, 2, 3) in the console
  println(list.head)
  println(list.tail)

  // map
  println(list.map(_ + 1))                // map iterates over each value in the list. you can use math operators to add 1 to each value up like this
  println(list.map(_ + " is a number"))

  // filter
  println(list.filter(_ % 2 == 0)) 

  // flatMap
  val toPair = (x: Int) => List(x, x+1)   // flat map is used to add reach iteration to the list in a pair-like sequence
  println(list.flatMap(toPair))           // so for each iteration flat map will return 2 values for 1

  // print all combinations between two lists
  val numbers = List(1,2,3,4)
  val chars = List('a','b','c','d')
  val colors = List("black", "white")

  // List("a1", "a2"... "d4")

  // "iterating" using functional programming
  val combinations = numbers.filter(_ % 2 == 0).flatMap(n => chars.flatMap(c => colors.map(color => "" + c + n + "-" + color)))
  println(combinations)

  /** A better view of whats going on:
    val combinations = numbers
      .filter(_ % 2 == 0)
      .flatMap(n => chars                           // for each element in numbers, this generates a list by traversing across chars
        .flatMap(c => colors                        // to find the possibilities adding colors, we also traverse across colors for every element in chars
          .map(color => "" + c + n + "-" + color)   
        )
      )
    println(combinations)
    
    This is an example of a 3-dimensional function

   */

  // foreach
  list.foreach(println)

  // for-comprehensions
  val forCombinations = for {
    n <- numbers if n % 2 == 0
    c <- chars
    color <- colors
  } yield "" + c + n + "-" + color
  println(forCombinations)

  for {
    n <- numbers
  } println(n)

  // syntax overload
  list.map { x =>
    x * 2
  }

  /*
    1.  MyList supports for comprehensions?
        map(f: A => B) => MyList[B]
        filter(p: A => Boolean) => MyList[A]
        flatMap(f: A => MyList[B]) => MyList[B]
    2.  A small collection of at most ONE element - Maybe[+T]
        - map, flatMap, filter
   */
}
