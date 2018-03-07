import org.junit.Before
import org.junit.Test

class PrimeTableTests extends GroovyTestCase {

  PrimeTable solution
  ByteArrayOutputStream out

  @Before
  void setUp() {
    solution = new PrimeTable()
    out = new ByteArrayOutputStream()
    System.setOut(new PrintStream(out))
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
      fail("expected IllegalArgumentException")
    } catch (IllegalArgumentException e) {
      assert e.message == 'Bound must be larger than 1'
    }
  }

  /* formatTable */
  @Test
  void test_formatTable_CalculatesProducts() {
    List<Integer> primes = [2, 3, 5, 7]
    String output = solution.formatTable(primes)

    primes.each { p ->
      primes.collect { it * p }.each {
        assert output.contains(it.toString())
      }
    }
  }

  @Test
  void test_formatTable_ReturnsCorrectNumberOfRows() {
    List<Integer> primes = [2, 3, 5, 7]
    String output = solution.formatTable(primes)

    // 1) blank line
    // 2)          2    3    5    7
    // 3)      --------------------
    // 4)   2 |    4    6   10   14
    // 5)   3 |    6    9   15   21
    // 6)   5 |   10   15   25   35
    // 7)   7 |   14   21   35   49

    assert output.split('\n').size() == 7
  }

  /* main */
  @Test
  void test_main_DoesNotAcceptNonNumericArgument() {
    solution.main('a')
    assertEquals('There was a problem with the argument. Make sure a number is passed.\r\n', out.toString())
  }

  @Test
  void test_main_AcceptsIntegerArgument() {
    solution.main('2')
    List<String> expected = [
        "",
        "Getting multiplication table for first 2 prime number(s)\r",
        "",
        "         2   3",
        "      --------",
        "   2 |   4   6",
        "   3 |   6   9",
        "",
        "\r"
    ]

    assert out.toString().split('\n').size() == 9
    assertEquals(expected, out.toString().split('\n'))
  }

  @Test
  void test_main_NoArguments_DefaultToTen() {
    solution.main()
    List<String> expected = [
        "",
        "Getting multiplication table for first 10 prime number(s)\r",
        "",
        "           2     3     5     7    11    13    17    19    23    29",
        "      ------------------------------------------------------------",
        "   2 |     4     6    10    14    22    26    34    38    46    58",
        "   3 |     6     9    15    21    33    39    51    57    69    87",
        "   5 |    10    15    25    35    55    65    85    95   115   145",
        "   7 |    14    21    35    49    77    91   119   133   161   203",
        "  11 |    22    33    55    77   121   143   187   209   253   319",
        "  13 |    26    39    65    91   143   169   221   247   299   377",
        "  17 |    34    51    85   119   187   221   289   323   391   493",
        "  19 |    38    57    95   133   209   247   323   361   437   551",
        "  23 |    46    69   115   161   253   299   391   437   529   667",
        "  29 |    58    87   145   203   319   377   493   551   667   841",
        "",
        "\r"
    ]

    assert out.toString().split('\n').size() == 17
    assertEquals(expected, out.toString().split('\n'))
  }

  @Test
  void test_main_ArgumentZero_DefaultsToTen() {
    solution.main('0')
    assert out.toString().split('\n').size() == 17
    assertEquals("Getting multiplication table for first 10 prime number(s)\r", out.toString().split('\n')[1])
  }

}
