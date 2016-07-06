# macros

A few little macros to make life better.

## DescribeMacro

Generates a string that describes the function name + any val/var name and value.

Useful for removing boilerplate when logging.

```scala

import org.corespring.macros.DescribeMacro._

def ping(msg:String) = {
  describe(msg)
}
ping('hi') // returns 'function=ping, msg=hi'
```