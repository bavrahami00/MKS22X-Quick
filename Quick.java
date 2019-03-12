import java.util.Random;
public class Quick {
  public static void main(String[] args) {
    for (int x = 0; x < 7; x++) {
      int[] test = new int[] {1,4,2,6,3,8,5};
      System.out.println(x+","+quickselect(test,x));
    }
  }
  public static int partition (int[] data, int start, int end) {
    Random r = new Random();
    int pivot = Math.abs(r.nextInt()%(end-start+1))+start;
    int move = data[start];
    data[start] = data[pivot];
    data[pivot] = move;
    pivot = start+1;
    int slide = start+1;
    while (pivot != (end+1)) {
      if (data[pivot] < data[start]) {
        move = data[slide];
        data[slide] = data[pivot];
        data[pivot] = move;
        slide++;
      }
      pivot++;
    }
    move = data[start];
    data[start] = data[slide-1];
    data[slide-1] = move;
    return slide-1;
  }
  public static int quickselect(int []data, int k){
    int small = 0;
    int large = data.length-1;
    while (true) {
      int temp = partition(data,small,large);
      if (temp == k) {
        return data[k];
      }
      if (temp > k) {
        large = temp-1;
      }
      else {
        small = temp+1;
      }
    }
  }
}
