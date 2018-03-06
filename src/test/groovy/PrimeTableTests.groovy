import org.junit.Before
import org.junit.Test

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
}
