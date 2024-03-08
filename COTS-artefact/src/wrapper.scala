package <replace_name>

import <replace_name>.api._

object Wrapper {
  def main(args: Array[String]): Unit = {
    if (args.length == 0) {
      println("You need to specify number of tests.")
    }

    def report(msg: String): Unit = {
      print(msg)
    }

    def setup: Unit = {
    }

    def teardown: Unit = {
    }

    var now = System.nanoTime
    val d = new driver(setup, teardown, true, 300, 1, args(0).toInt, report)
    d.run()
    var timeElapsed = System.nanoTime - now
    println("Time elapsed: "+timeElapsed)
  }
}