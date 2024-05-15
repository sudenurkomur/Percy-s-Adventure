public class InsertionSort {


    public void Sort(int[] A , String[] B , String[] C) {

        int key;
        String name;
        String surname;
        int i;
        //2, 5, 3, 1, 9, 6
        for(int j=2; j<A.length; j++) {
            key=A[j];
            name =B[j];
            surname =C[j];
            i=j-1;
            while(i>=0 && A[i]>key) {
                A[i+1]=A[i];
                B[i+1]=B[i];
                C[i+1]=C[i];
                i=i-1;
            }
            A[i+1]=key;
            B[i+1]=name;
            C[i+1]=surname;
        }
    }
}