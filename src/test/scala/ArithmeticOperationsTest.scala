import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import scala.util.{Success, Failure}
class ArithmeticOperationsTest extends AnyFlatSpec with Matchers{

  val operation = new ArithmeticOperations

  "performOperation" should "correctly perform addition on the input list" in {
    val inputList = List(Some(2), Some(4), Some(6))
    val result = operation.performOperation(inputList, "Addition")
    assert(result === Success(Some(12)))
  }

  it should "correctly perform subtraction on the input list" in {
    val inputList = List(Some(10), Some(5), Some(3))
    val result = operation.performOperation(inputList, "Subtraction")
    assert(result === Success(Some(2)))
  }

  it should "correctly perform multiplication on the input list" in {
    val inputList = List(Some(2), Some(3))
    val result = operation.performOperation(inputList, "Multiplication")
    assert(result === Success(Some(6)))
  }

  it should "return a Failure if an invalid operation is passed" in {
    val inputList = List(Some(2), Some(3), Some(4))
    val result = operation.performOperation(inputList, "Division")
    result shouldBe a[Failure[_]]
  }

  it should "return None if the input list is empty" in {
    val inputList = List.empty[Option[Int]]
    val result = operation.performOperation(inputList, "Addition")
    assert(result === Success(None))
  }
}

