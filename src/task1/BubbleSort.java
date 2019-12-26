package task1;

public class BubbleSort {
    public static void main(String[] args) {
        int[] testArray={11, 3, 14, 16, 7};
        BubbleSort bs=new BubbleSort();
        bs.sort(testArray);
        for (int a:testArray) {
            System.out.println(a);
        }
    }

    private void swap(int first, int second, int[] a){
        int buff = a[first];
        a[first] = a[second];
        a[second] = buff;
    }

    public void sort(int[] a){
        for (int out = a.length - 1; out >= 1; out--){
            for (int in = 0; in < out; in++){
                if(a[in] > a[in + 1])
                    swap(in, in + 1,a);
            }
        }
    }
}
