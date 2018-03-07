# Objective
Write a program that prints out a multiplication table of the first 10 prime numbers.
- The program must run from the command line and print one table to STDOUT.
- The first row and column of the table should have the 10 primes with each cell containing the product of the primes for the corresponding row and column.

## Running the program/tests

If Groovy is installed, the script can be run from the command line as such
```
groovy src/main/groovy/PrimeTable.groovy
```

For tests:
```
./gradlew test
```

#### Docker
```
docker run --rm -v "$PWD":/home/groovy/scripts -w /home/groovy/scripts groovy groovy src/main/groovy/PrimeTable.groovy
```

For tests:
```
docker run --rm -v "$PWD":/home/gradle/project -w /home/gradle/project gradle-alpine ./gradlew test
```

## Output
```
Getting multiplication table for first 10 prime number(s)

           2     3     5     7    11    13    17    19    23    29
      ------------------------------------------------------------
   2 |     4     6    10    14    22    26    34    38    46    58
   3 |     6     9    15    21    33    39    51    57    69    87
   5 |    10    15    25    35    55    65    85    95   115   145
   7 |    14    21    35    49    77    91   119   133   161   203
  11 |    22    33    55    77   121   143   187   209   253   319
  13 |    26    39    65    91   143   169   221   247   299   377
  17 |    34    51    85   119   187   221   289   323   391   493
  19 |    38    57    95   133   209   247   323   361   437   551
  23 |    46    69   115   161   253   299   391   437   529   667
  29 |    58    87   145   203   319   377   493   551   667   841
```

### Arguments
The number of first primes can be modified by passing a numeric value as an argument.

For example, `groovy PrimeTable.groovy 15` will generate a multiplication table for the first 15 prime numbers. If `0` or no numeric value is passed, the default is to generate a table for the first 10 prime numbers.