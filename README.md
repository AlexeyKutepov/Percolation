# Percolation

See the Assessment Guide for information on how to read this report.
Assessment Summary
Compilation:  PASSED
Style:        PASSED
Findbugs:     No potential bugs found.
API:          PASSED

Correctness:  24/24 tests passed
Memory:       9/8 tests passed
Timing:       4/9 tests passed

Aggregate score: 87.36% [Correctness: 65%, Memory: 10%, Timing: 25%, Style: 0%]
Assessment Details
The following files were submitted:
----------------------------------
total 12K
-rw-r--r-- 1 2.9K Jan 27 07:14 Percolation.java
-rw-r--r-- 1 1.9K Jan 27 07:14 PercolationStats.java
-rw-r--r-- 1 1.9K Jan 27 07:14 studentSubmission.zip


******************************************************************************
*  compiling
******************************************************************************


% javac Percolation.java
*-----------------------------------------------------------
================================================================

% javac PercolationStats.java
*-----------------------------------------------------------
================================================================



% checkstyle *.java
*-----------------------------------------------------------
================================================================


% findbugs *.class
*-----------------------------------------------------------
================================================================


Testing the APIs of your programs.
*-----------------------------------------------------------
Percolation:

PercolationStats:

================================================================


******************************************************************************
*  correctness
******************************************************************************

Testing methods in Percolation
*-----------------------------------------------------------
Running 14 total tests.

Tests 1 through 7 create a Percolation object using your code, then repeatedly
open sites using open(i, j). After each call to open(), we check that isFull(),
isOpen(), and percolates() return the correct values.

Test 1: Open predetermined list of sites using files
  *  filename = input6.txt
  *  filename = input8.txt
  *  filename = input8-no.txt
  *  filename = input10-no.txt
  *  filename = greeting57.txt
  *  filename = heart25.txt
==> passed

Test 2: Open random sites until system percolates (then test is terminated)
  *  N = 3
  *  N = 5
  *  N = 10
  *  N = 10
  *  N = 20
  *  N = 20
  *  N = 50
  *  N = 50
==> passed

Test 3: Opens predetermined sites for N = 1 and N = 2 (corner case test)
  *  filename = input1.txt
  *  filename = input1-no.txt
  *  filename = input2.txt
  *  filename = input2-no.txt
==> passed

Test 4: Check for backwash with predetermined sites
  *  filename = input20.txt
  *  filename = input10.txt
  *  filename = input50.txt
  *  filename = sedgewick60.txt
  *  filename = michael61.txt
  *  filename = jerry47.txt
==> passed

Test 5: Check for backwash with predetermined sites that have
        multiple percolating paths
  *  filename = input3.txt
  *  filename = input4.txt
  *  filename = input7.txt
==> passed

Test 6: Predetermined sites with very long percolating path
  *  filename = snake13.txt
  *  filename = snake101.txt
==> passed

Test 7: Opens every site
  *  filename = input5.txt
==> passed

Test 8: Check whether exception is called if (i, j) are out of bounds
  *  N = 10, (i, j) = (0, 6)
  *  N = 10, (i, j) = (12, 6)
  *  N = 10, (i, j) = (11, 6)
  *  N = 10, (i, j) = (6, 0)
  *  N = 10, (i, j) = (6, 12)
  *  N = 10, (i, j) = (6, 11)
==> passed

Test 9: Check that IllegalArgumentException is thrown if N <= 0 in constructor
  *  N = -10
  *  N = -1
  *  N = 0
==> passed

Test 10: Create multiple Percolation objects at the same time
         (to make sure you didn't store data in static variables)
==> passed

Test 11: Open predetermined list of sites using file
         but change the order in which methods are called
  *  filename = input8.txt;  order =     isFull(),     isOpen(), percolates()
  *  filename = input8.txt;  order =     isFull(), percolates(),     isOpen()
  *  filename = input8.txt;  order =     isOpen(),     isFull(), percolates()
  *  filename = input8.txt;  order =     isOpen(), percolates(),     isFull()
  *  filename = input8.txt;  order = percolates(),     isOpen(),     isFull()
  *  filename = input8.txt;  order = percolates(),     isFull(),     isOpen()
==> passed

Test 12: Call all methods in random order until just before system percolates
  *  N = 3
  *  N = 5
  *  N = 7
  *  N = 10
  *  N = 20
  *  N = 50
==> passed

Test 13: Call all methods in random order with inputs not prone to backwash
  *  N = 3
  *  N = 5
  *  N = 7
  *  N = 10
  *  N = 20
  *  N = 50
==> passed

Test 14: Call all methods in random order until all sites are open
  *  N = 3
  *  N = 5
  *  N = 7
  *  N = 10
  *  N = 20
  *  N = 50
==> passed


Total: 14/14 tests passed!

================================================================

******************************************************************************
*  executing (substituting reference Percolation.java)
******************************************************************************

Testing methods in PercolationStats
*-----------------------------------------------------------
Running 10 total tests.

Test 1: Test that PercolateStats creates T Percolation objects, each of size N-by-N
  * N =  20, T =  10
  * N =  50, T =  20
  * N = 100, T =  50
  * N =  64, T = 150
==> passed

Test 2a: Test that PercolationStats calls open() until system percolates
  * N =  20, T =  10
  * N =  50, T =  20
  * N = 100, T =  50
  * N =  64, T = 150
==> passed

Test 2b: Test that PercolationStats does not call open() after system percolates
  * N =  20, T =  10
  * N =  50, T =  20
  * N = 100, T =  50
  * N =  64, T = 150
==> passed

Test 3: Test that mean() is consistent with the number of intercepted calls to open()
  on blocked sites
  * N =  20, T =  10
  * N =  50, T =  20
  * N = 100, T =  50
  * N =  64, T = 150
==> passed

Test 4: Test that stddev() is consistent with the number of intercepted calls to open()
  on blocked sites
  * N =  20, T =  10
  * N =  50, T =  20
  * N = 100, T =  50
  * N =  64, T = 150
==> passed

Test 5: Test that confidenceLo() and confidenceHigh() are consistent with mean() and stddev()
  * N =  20, T =  10
  * N =  50, T =  20
  * N = 100, T =  50
  * N =  64, T = 150
==> passed

Test 6: Check whether exception is thrown if either N or T is out of bounds
  * N = -23, T =  42
  * N =  23, T =   0
  * N = -42, T =   0
  * N =  42, T =  -1
==> passed

Test 7: Create two PercolationStats objects at the same time and check mean()
        (to make sure you didn't store data in static variables)
  * N1 =  50, T1 =  10, N2 =  50, T2 =   5
  * N1 =  50, T1 =   5, N2 =  50, T2 =  10
  * N1 =  50, T1 =  10, N2 =  25, T2 =  10
  * N1 =  25, T1 =  10, N2 =  50, T2 =  10
  * N1 =  50, T1 =  10, N2 =  15, T2 = 100
  * N1 =  15, T1 = 100, N2 =  50, T2 =  10
==> passed

Test 8: Check that the methods return the same value, regardless of
        the order in which they are called
  * N =  20, T =  10
  * N =  50, T =  20
  * N = 100, T =  50
  * N =  64, T = 150
==> passed

Test 9: Check distribution of number of sites opened until percolation
  * N = 2, T = 100000
  * N = 3, T = 100000
  * N = 4, T = 100000
==> passed


Total: 10/10 tests passed!

================================================================

******************************************************************************
*  memory (substituting reference Percolation.java)
******************************************************************************

Computing memory of PercolationStats
*-----------------------------------------------------------
Running 4 total tests.

Test 1a-1d: Memory usage as a function of T for N = 100
            (max allowed: 8 T + 128 bytes)

                 T        bytes
--------------------------------------------
=> passed       16          184         
=> passed       32          312         
=> passed       64          568         
=> passed      128         1080         
==> 4/4 tests passed


Estimated student memory = 8.00 T + 56.00  (R^2 = 1.000)

Total: 4/4 tests passed!

================================================================



******************************************************************************
*  memory
******************************************************************************

Computing memory of Percolation
*-----------------------------------------------------------
Running 4 total tests.

Test 1a-1d: Check that total memory <= 17 N^2 + 128 N + 1024 bytes

                 N        bytes
--------------------------------------------
=> passed       64        45240         
=> passed      256       671928         
=> passed      512      2654392         
=> passed     1024     10551480         
==> 4/4 tests passed


Estimated student memory = 10.00 N^2 + 64.00 N + 184.00  (R^2 = 1.000)


Test 2 (bonus): Check that total memory <= 11 N^2 + 128 N + 1024 bytes
==> passed


Total: 5/4 tests passed!

================================================================



******************************************************************************
*  timing
******************************************************************************

Timing Percolation
*-----------------------------------------------------------
Running 9 total tests.

Tests 1a-1e: Measuring runtime and counting calls to connected(), union() and
             find() in WeightedQuickUnionUF.


For each N, a percolation object is generated and sites are randomly opened
until the system percolates. If you do not pass the correctness tests, these
results may be meaningless.

                                                 2 * connected()
                 N   seconds       union()              + find()        constructor
---------------------------------------------------------------------------------------------
=> FAILED        8     0.00           51                     0   (0.0x)          1         
=> FAILED       32     0.00          717                     0   (0.0x)          1         
=> FAILED      128     0.03        11143                     0   (0.0x)          1         
=> FAILED      512     0.14       184748                     0   (0.0x)          1         
=> FAILED     1024     0.64       727731                     0   (0.0x)          1         
==> 0/5 tests passed

Running time in seconds depends on the machine on which the script runs,
and  varies each time that you submit. If one of the values in the table
violates the performance limits, the factor by which you failed the test
appears in parentheses. For example, (9.6x) in the union() column
indicates that it uses 9.6x too many calls.


Tests 2a-2d: This test checks whether you use a constant number of calls to
union(), connected(), and find() per call to open(), isFull(), and percolates().
The table below shows max(union(), connected(), find()) calls made during a
single call to open(), isFull(), and percolates().

                 N     per open()      per isOpen()    per isFull()    per percolates() 
---------------------------------------------------------------------------------------------
=> passed       32        4               0               0               0         
=> passed      128        4               0               0               0         
=> passed      512        4               0               0               0         
=> passed     1024        4               0               0               0         
==> 4/4 tests passed

Total: 4/9 tests passed!
================================================================
