module mathematics {
  requires java.se;
  requires org.apache.commons.lang3;
  requires org.apache.commons.collections4;
  requires org.apache.commons.io;
  requires lombok;
  requires org.slf4j;

  exports io.mathematics;
  exports io.mathematics.lang;
  exports io.mathematics.algorithm;
  exports io.mathematics.prime;
  exports io.mathematics.random;
  exports io.mathematics.modular;
  exports io.mathematics.func;
}