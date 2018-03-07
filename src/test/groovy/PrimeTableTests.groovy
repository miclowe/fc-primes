import org.junit.Before
import org.junit.Test

class PrimeTableTests extends GroovyTestCase {

  PrimeTable solution

  @Before
  void setUp() {
    solution = new PrimeTable()
  }

  /* estimateUpperBound */
  @Test
  void test_estimateUpperBound_NumOfPrimesLessThan6() {
    int num = 3
    assert solution.estimateUpperBound(num) == (2 * num) + 1
  }

  @Test
  void test_estimateUpperBound_NumOfPrimesGreaterThan6() {
    Map<Integer, Integer> nums = [10:32, 50:264, 100:614, 1000:8841, 10000:114307]
    nums.each { k, v ->
      assert solution.estimateUpperBound(k) == v
    }
  }

  /* getListOfPrimes */
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
