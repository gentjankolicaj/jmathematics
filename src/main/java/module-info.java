module io.jmathematics {
  requires java.se;
  requires org.apache.commons.lang3;
  requires org.apache.commons.collections4;
  requires org.apache.commons.io;
  requires static lombok;
  requires org.slf4j;

  exports io.jmathematics;
  exports io.jmathematics.lang;
  exports io.jmathematics.algorithm;
  exports io.jmathematics.prime;
  exports io.jmathematics.random;
  exports io.jmathematics.modular;
  exports io.jmathematics.func;
  exports io.jmathematics.exception;
}