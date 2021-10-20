package br.com.codenation;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class StatisticUtil {


  public static int average(int[] elements) {
    return Arrays.stream(elements).sum() / elements.length;
  }

  public static int mode(int[] elements) {
    Map<Integer, Integer> occ = new HashMap<>();
    int result = 0;
    int counter = 0;

    for (int num : elements) {
      if (occ.get(num) == null) {
        occ.put(num, 0);
      } else {
        int el = occ.get(num);
        occ.put(num, el + 1);
        if (el + 1 > counter) {
          counter = el;
          result = num;
//        }
        }
      }
    }
    return result;
  }


  public static int median(int[] elements) {
    Arrays.sort(elements);
    if (elements.length % 2 != 0) {
      return elements[(elements.length - 1) / 2];
    } else {
      int[] arr = {elements[elements.length / 2 - 1], elements[elements.length / 2]};
      return average(arr);
    }
  }
}