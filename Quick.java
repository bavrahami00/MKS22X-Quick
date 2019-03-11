public class Quick {
  public static int partition (int[] data, int start, int end) {
    Random r = new Random();
    int pivot = Math.abs(r.nextInt()%data.length);
    System.out.println(data[pivot]);
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
    return slide-start-1;
  }
  public static int quickselect(int []data, int k){
    
  }
}
