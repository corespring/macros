package org.corespring.macros

import org.specs2.mutable.Specification

class DescribeMacroTest extends Specification{

  import org.corespring.macros.DescribeMacro.{describe => dd}
  "describe" should {
    "return the function name" in {
      def tester(msg:String) = dd()
      tester("hi") must_== "function=tester"
    }

    "return the function name and params" in {
      def tester(msg:String) = dd(msg)
      tester("hi") must_== "function=tester, msg=hi"
    }

    "return the function name and any vals in the function body" in {
      def tester(msg:String) = {
        val a = 10
        dd(a)
      }
      tester("hi") must_== "function=tester, a=10"
    }
  }
}
