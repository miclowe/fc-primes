import org.junit.Before
import org.junit.Test
import org.junit.internal.runners.statements.ExpectException

class PrimeTableTests extends GroovyTestCase {

  PrimeTable solution

  @Before
  void setUp() {
    solution = new PrimeTable()
  }

  @Test
  void test_getListOfPrimes_ReturnsList() {
    assert solution.getListOfPrimes(10) == [2, 3, 5, 7]
  }

  @Test
  void test_getListOfPrimes_BoundLessThan3_ReturnsSinglePrime() {
    assert solution.getListOfPrimes(2) == [2]
  }

  @Test
  void test_getListOfPrimes_BoundLessThan2_ThrowsException() {
    try {
      solution.getListOfPrimes(1)
    } catch (IllegalArgumentException e) {
      assert e.message == 'Bound must be larger than 1'
    }
  }
}
