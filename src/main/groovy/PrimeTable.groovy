class PrimeTable {

  /* Use Sieve of Eratosthenes to find the prime numbers up to a given integer.
  *  https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes
  *
  *  Given a list of numbers from 2 to a given integer(bound), assume all numbers are unmarked/prime.
  *  Iterate through the list and unmark/eliminate multiples of each prime, starting with the first prime number, 2.
  *
  *  Notice we do not need to check every number in the list, only up to the square root of the bound. The square root
  *  is the smallest divisor, and any number larger than the square root is not a divisor of the bound.
  *
  */
  static List<Integer> getListOfPrimes(Integer bound) {
    if (bound < 2) {
      throw new IllegalArgumentException("Bound must be larger than 1")
    }

    // Initializing list with [0, 1] to represent the first non-prime numbers. Doing so makes "unmarking" of elements cleaner
    List<Integer> numList = [0, 1]
    numList += (2..bound).toList()

    if (bound > 3) {
      (2..((int) Math.sqrt(bound))).each { n ->
        // Skip to the square of n. All numbers in between have already been checked by previous iterations and unmarked or left as marked
        ((n**2)..bound).step(n) {
          numList[it] = 0
        }
      }
    }

    // Unmarked/non-prime indices have been set to 0
    numList.findAll { it > 1 }
  }

  static void main(String[] args) {
    int bound = args*.toInteger()[0] ?: 16
    try {
      println getListOfPrimes(bound)
    } catch (Exception e) {
      println e.message
    }
  }

}
