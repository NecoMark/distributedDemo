package com.hillstone.scalademo

/**
  * var表示变量，可以修改
  * val表示值，不可以修改
  */



object ScalaDemo {
  def main(args: Array[String]): Unit = {
    var c: Int = {
        var a = 10
        var b = 4
        a * b
    }
    if(c == 10){
      println("222")
    } else if(c == 40){
      println(10)
    }
    println(func1(arg2=2,arg1=3))

    var temp = for{i <- Range(1, 10)
      if (i % 2 == 0)}yield i

    for (x <- temp){
      println(temp)
    }


    def innerfunc(str: String): String ={
      str + "qwe"
    }

  }

  def func1(arg1: Int, arg2: Int): Int ={
    arg1 + arg2

  }

}
 