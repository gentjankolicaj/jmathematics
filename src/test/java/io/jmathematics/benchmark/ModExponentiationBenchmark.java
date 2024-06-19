package io.jmathematics.benchmark;

import io.jmathematics.modular.ModExp;
import java.io.IOException;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.Warmup;

/**
 * More on how <a
 * href="https://hg.openjdk.org/code-tools/jmh/file/6cc1450c6a0f/jmh-core/src/main/java/org/openjdk/jmh/results">result
 * calculation</a> is done.
 */
@SuppressWarnings("ALL")
public class ModExponentiationBenchmark {

  public static void main(String[] args) throws IOException {
    org.openjdk.jmh.Main.main(args);
  }

  @Warmup(iterations = 1)
  @Fork(value = 2)
  @Measurement(iterations = 3)
  @Benchmark
  @BenchmarkMode(Mode.All)
  public void multiplyReduce() {
    ModExp.multiplyReduce(47, 69, 143);
    ModExp.multiplyReduce(3, 1000, 26);
    ModExp.multiplyReduce(3, 94, 17);
    ModExp.multiplyReduce(40, 110, 37);
    ModExp.multiplyReduce(9, 12345, 9);
    ModExp.multiplyReduce(12345, 6789, 143);
  }

  @Warmup(iterations = 1)
  @Fork(value = 2)
  @Measurement(iterations = 3)
  @Benchmark
  @BenchmarkMode(Mode.All)
  public void squareMultiply() {
    ModExp.squareMultiply(47, 69, 143);
    ModExp.squareMultiply(3, 1000, 26);
    ModExp.squareMultiply(3, 94, 17);
    ModExp.squareMultiply(40, 110, 37);
    ModExp.squareMultiply(9, 12345, 9);
    ModExp.squareMultiply(12345, 6789, 143);
  }
}