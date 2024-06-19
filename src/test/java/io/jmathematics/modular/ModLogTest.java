package io.jmathematics.modular;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class ModLogTest {

  @Test
  void logTable() {
    long[][] mod13Table = ModLog.logTable(12, 12, 13);
    for (int i = 0; i < mod13Table.length; i++) {
      System.out.print("   " + i);
    }
    System.out.println();
    for (int i = 0; i < mod13Table.length; i++) {
      System.out.print(i + "|");
      for (int j = 0; j < mod13Table[i].length; j++) {
        if (mod13Table[i][j] > 10) {
          System.out.print("  " + mod13Table[i][j]);
        } else {
          System.out.print("   " + mod13Table[i][j]);
        }
      }
      System.out.println();
    }
  }


  @Test
  void log() {
    assertThat(ModLog.log(7, 4, 13)).isEqualTo(10);
    assertThat(ModLog.log(5, 8, 13)).isEqualTo(3);
    assertThat(ModLog.log(3, 9, 13)).isEqualTo(2);
  }


}