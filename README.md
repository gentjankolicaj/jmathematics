# jmathematics

* A java module for mathematics.
* Status of the project : work in progress.

## How to use it ?

This is not pushed to Maven central... yet. But still you can use it
via  [![](https://jitpack.io/v/gentjankolicaj/jmathematics.svg)](https://jitpack.io/#gentjankolicaj/jmathematics)

Add the jitpack repository to your maven repositories:

 ```
<repositories>
    <repository>
        <id>JitPack</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>
 ```

Then, add the following to your pom.xml (use any version
from [gitHub releases page](https://github.com/gentjankolicaj/jmathematics/releases)):

 ```
<dependency>
    <groupId>com.github.gentjankolicaj</groupId>
    <artifactId>jmathematics</artifactId>
    <version>main-${jitpack-version}</version>
</dependency>
 ```

## More :

| topic          | implementations                                                                                                                                                                                                       |
|----------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Algebra        |                                                                                                                                                                                                                       |
| Geometry       | <li>Line</li> <li>Triangle</li><li>Rectangle</li><li>Square</li><li>Rhombus</li><li>Parallelogram</li><li>Trapezoid</li><li>Pentagram</li><li>Hexagram</li><li>Circle</li>                                            |
| Algorithms     | <li>Euclidean algorithm</li><li>Extended Euclidean algorithm</li><li>Bezout coefficients</li><li>Heron</li><li>Pythagoras</li>                                                                                        |
| Approximations | <li>Stirling</li>                                                                                                                                                                                                     |
| Functions      | <li>Min, Max, Abs</li><li>Euclidean, Manhattan norms</li><li>Euler totient</li>                                                                                                                                       |
| Modular        | <li>Common residue, least residue, congruence, equivalence classes</li><li>Addition, subtraction, multiplication, exponentiation (multiply-reduce, square-multiply)</li><li>Log (first discrete log)</li><li>CRT</li> |
| Primes         | <li>PNT(Prime number theorem approx)</li><li>Primality & compositeness (Trial-division, Fermat, Miller-Rabin)</li>                                                                                                    |
| Paradox        | <li>Birthday paradox</li>                                                                                                                                                                                             |





