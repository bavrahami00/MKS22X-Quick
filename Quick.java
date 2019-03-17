import java.util.Random;
public class Quick {
  public static int partition (int[] data, int start, int end) {
    Random r = new Random();
    int[] values = new int[6];
    for (int x = 0; x < 3; x++) {
      values[2*x] = Math.abs(r.nextInt()%(end-start+1))+start;
      values[2*x+1] = data[values[2*x]];
    }
    int median = values[1]+values[3]+values[5]-Math.min(Math.min(values[1],values[3]),values[5])-Math.max(Math.max(values[1],values[3]),values[5]);
    int pivot;
    if (median == values[1]) {
      pivot = values[0];
    }
    else if (median == values[3]) {
      pivot = values[2];
    }
    else {
      pivot = values[4];
    }
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
      else if (data[pivot] == data[start] && Math.abs(r.nextInt())%2 == 0) {
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
  public static int[] partitionDutch (int[] data, int start, int end) {
    Random r = new Random();
    int[] values = new int[6];
    for (int x = 0; x < 3; x++) {
      values[2*x] = Math.abs(r.nextInt()%(end-start+1))+start;
      values[2*x+1] = data[values[2*x]];
    }
    int median = values[1]+values[3]+values[5]-Math.min(Math.min(values[1],values[3]),values[5])-Math.max(Math.max(values[1],values[3]),values[5]);
    int pivot;
    if (median == values[1]) {
      pivot = values[0];
    }
    else if (median == values[3]) {
      pivot = values[2];
    }
    else {
      pivot = values[4];
    }
    int move = data[start];
    data[start] = data[pivot];
    data[pivot] = move;
    pivot = start+1;
    int slide = start+1;
    int slither = start+1;
    while (pivot != (end+1)) {
      if (data[pivot] < data[start]) {
        move = data[slither];
        data[slither] = data[pivot];
        data[pivot] = move;
        move = data[slither];
        data[slither] = data[slide];
        data[slide] = move;
        slide++;
        slither++;
      }
      else if (data[pivot] == data[start]) {
        move = data[slither];
        data[slither] = data[pivot];
        data[pivot] = move;
        slither++;
      }
      pivot++;
    }
    move = data[start];
    data[start] = data[slide-1];
    data[slide-1] = move;
    int[] ans = new int[2];
    ans[0] = slide-1;
    ans[1] = slither-1;
    return ans;
  }
  public static int quickselectDutch(int[] data, int k) {
    int small = 0;
    int large = data.length-1;
    int[] temp;
    while (true) {
      temp = partitionDutch(data,small,large);
      if (temp[0] <= k && temp[1] >= k) {
        return data[temp[0]];
      }
      else if (temp[0] > k) {
        large = temp[0]-1;
      }
      else {
        small = temp[1]+1;
      }
    }
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
  public static void quicksortDutch(int[] data) {
    quicksortDutchH(data,0,data.length-1);
  }
  public static void quicksortDutchH(int[] data, int start, int end) {
    if (start < end) {
      int[] pivots = partitionDutch(data,start,end);
      quicksortDutchH(data,start,pivots[0]-1);
      quicksortDutchH(data,pivots[1]+1,end);
    }
  }
  public static void quicksort(int[] data) {
    quicksortDutchH(data,0,data.length-1);
  }
  private static void quicksortH(int[] data, int start, int end) {
    if (start < end) {
      int pivot = partition(data,start,end);
      quicksortH(data,start,pivot-1);
      quicksortH(data,pivot+1,end);
    }
  }
}
