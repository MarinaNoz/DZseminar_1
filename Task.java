 // Пункты реализовать в методе main
      // 1. Выбросить случайное целое число в диапазоне от -1000 до 1000 и сохранить в i

       
import java.util.ArrayList;
import java.util.Random;
import java.io.FileWriter;
import  java.io.IOException;

public class Task {
  
  
  static int randomNumber() {
        int min = -1000;
        int max = 1000;
        int randNumber = new Random().nextInt((max - min)+1)+min;
        return randNumber;
        
  }
  //2. Посчитать и сохранить в n номер старшего значащего бита выпавшего числа

  static int bitNumber(int enterNum) {
    int result = 0;
    while (enterNum !=0) {
      enterNum >>= 1;
      result++;
    }
    return result;

  }
  //3. Найти все кратные n числа в диапазоне от i до Short.MAX_VALUE сохранить в массив m1

  static Integer[] getMultiples (int multNumber, int number) {
    ArrayList <Integer> tempArrayList = new ArrayList<>();
      for ( int i = number; i <= Short.MAX_VALUE; i++) {
        if (i % multNumber == 0) {
          tempArrayList.add(i);
        }
      } 
      Integer[]array = new Integer[tempArrayList.size()];
      tempArrayList.toArray(array);
      return array;
    }
//4. Найти все некратные n числа в диапазоне от Short.MIN_VALUE до i и сохранить в массив m2

    static Integer[] getNotMults (int multNumber, int number) {
      ArrayList <Integer> tempArrayList = new ArrayList<>();
        for ( int i = number; i >= Short.MIN_VALUE; i--) {
          if (i % multNumber != 0) {
            tempArrayList.add(i);
          }
        } 
        Integer[]array = new Integer[tempArrayList.size()];
        tempArrayList.toArray(array);
        return array;
      }
 //5. Сохранить оба массива в файлы с именами m1 и m2 соответственно.

 static void saveFile(Integer[] array, String fileName) {
  try (FileWriter fw = new FileWriter(fileName + ".txt", false)) {
    fw.append("["); {
      for (int i =0; i <array.length; i++) {
        fw.append(array[i].toString());
        if (i <array.length - 1) {
          fw.append(",");
        }
      }
    fw.append("]");
      }
  } catch (IOException ex) {
      System.out.println(ex.getMessage());
  }
}
  
public static void main(String[] args) {
  int i = randomNumber();
  System.out.println(i);
  int n = bitNumber(i);
  System.out.println(n);
  Integer[] m1 = getMultiples(n, i);
  Integer[] m2 = getNotMults(n, i);
  //System.out.println(Arrays.toString(m1));
 // System.out.println(Arrays.toString(m2));
 saveFile(m1,"m1");
 saveFile(m2, "m2");
 

}
}





   
 

 

