import scala.util.Success
import scala.util.{Try,Success,Failure}
object Driver extends App {

  private val myList = List(Some(1), Some(2), Some(3), Some(4))
  val operation = "Subtraction"
  private val converter = new ArithmeticOperations
  private val result = converter.performOperation(myList, operation)

  result match {
    case Success(Some(value))=> println(value)
    case Failure(exception) => println(s"Error occurred: ${exception.getMessage}")
  }

}