import scala.util.Try

class ArithmeticOperations {

  // This function performOperation takes a list of Option[Int] and a String representing the arithmetic operation to be performed.
  def performOperation(list: List[Option[Int]], operation: String): Try[Option[Int]] = {
    val requiredList = for {
      number <- list
      element <- number
    } yield element

    operation match {
      case "Addition" => Try(addition(requiredList))
      case "Subtraction" => Try(subtraction(requiredList))
      case "Multiplication" => Try(multiplication(requiredList))
      case _ => Try(throw new IllegalArgumentException(s"Invalid operation: $operation"))
    }

  }

  def addition(list: List[Int]): Option[Int] = {
    list match {
      case Nil => None
      case _ => Some(list.sum)
    }
  }

  def subtraction(list: List[Int]): Option[Int] = {
    list match {
      case Nil => None
      case _ => Some(list.reduceLeft(_ - _))
    }
  }

  def multiplication(list: List[Int]): Option[Int] = {
    list match {
      case Nil => None
      case _ => Some(list.product)
    }
  }

}
