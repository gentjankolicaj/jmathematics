package io.jmathematics.lang;

import org.apache.commons.lang3.ArrayUtils;

public class PrimitiveUtils {


  public static int getInt(byte[] array) {
    if (ArrayUtils.isEmpty(array)) {
      return 0;
    } else if (array.length == 1) {
      return array[0];
    } else if (array.length == 2) {
      return (array[0] << 8) + array[1];
    } else if (array.length == 3) {
      return (array[0] << 16) + (array[1] << 8) + array[2];
    } else if (array.length == 4) {
      return (array[0] << 24) + (array[1] << 16) + (array[2] << 8) + array[3];
    } else {
      throw new UnsupportedOperationException("Byte array holds more values than int can encode.");
    }
  }

  public static byte[] getBytes(int i) {
    if (i >= (1 << 24)) {
      byte[] array = new byte[4];
      array[0] = (byte) (i >> 24);
      array[1] = (byte) (i >> 18);
      array[2] = (byte) (i >> 10);
      array[3] = (byte) i;
      return array;
    } else if (i >= (1 << 18)) {
      byte[] array = new byte[3];
      array[0] = (byte) (i >> 18);
      array[1] = (byte) (i >> 10);
      array[2] = (byte) i;
      return array;
    } else if (i >= (1 << 10)) {
      byte[] array = new byte[2];
      array[0] = (byte) (i >> 10);
      array[1] = (byte) i;
      return array;
    } else {
      return new byte[]{(byte) i};
    }
  }

  public static byte[] getBytes(char c) {
    if (c >= (1 << 8)) {
      byte[] array = new byte[2];
      array[0] = (byte) (c >> 8);
      array[1] = (byte) c;
      return array;
    } else {
      return new byte[]{(byte) c};
    }
  }

}
