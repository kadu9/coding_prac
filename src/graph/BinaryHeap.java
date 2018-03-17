package graph;

public class BinaryHeap {
    int heapSize;
    int[] data;

    BinaryHeap(int size){
        this.heapSize=0;
        this.data = new int[size];
    }

    public BinaryHeap() {

    }

    public int getLeftChildIndex(int i){
        return (2*i)+1;
    }

    public int getRightChildIndex(int i){
        return (2*i)-1;
    }

    public int getParentIndex(int i){
        return (i-1)/2;
    }

    public int getMin() throws Exception {
        if (this.data.length <= 0) {
            throw new Exception("No data in the heap");
        } else {
            return data[0];
        }
    }
    public boolean isEmpty(){
           return data.length==0;
        }
    public void printHeap(){
        for (int i = 0; i < data.length-1; i++) {
            System.out.print(" "+data[i]);
        }
    }

    public void shiftUp(int val){
        int temp;
        int parentIndex;
        if (val !=0 ){
            parentIndex = getParentIndex(val);
            if (data[parentIndex] >data[val]){
                temp = data[val];
                data[val] = data[parentIndex];
                data[parentIndex] = temp;
                shiftUp(parentIndex);
            }
        }
    }

        public void insert(int ele) throws Exception{
            if (heapSize == data.length){
                throw  new Exception("Overflow");
            } else {
                heapSize++;
                data[heapSize - 1] =ele;
                shiftUp(heapSize -1);
            }

        }

        public void removeMin() throws Exception {
            data[0] = data[heapSize -1];
            heapSize--;
            if (heapSize >0){
                shiftDown(0);
            }
        }

        public void shiftDown(int ele) throws Exception{
            int leftIndex,rightIndex,minIndex = -99999,tmp;
            leftIndex = getLeftChildIndex(ele);
            rightIndex = getRightChildIndex(ele);
            if (rightIndex >= heapSize) {
                if (leftIndex >= heapSize){
                    return;
                }
                    minIndex = leftIndex;
            }
             else {
                if (data[leftIndex] <= data[rightIndex]) {
                    minIndex = leftIndex;
                } else {
                    minIndex = rightIndex;
                }
            }
            if (data[ele] > data[minIndex]) {
                tmp = data[ele];
                data[ele] = data[minIndex];
                data[minIndex] = tmp;
                shiftDown(minIndex);
            }
        }

        public static void main(String[] args) throws Exception {
           BinaryHeap heap = new BinaryHeap(7);
//            heap.insert(-2);
            heap.insert(1);
            heap.insert(5);
            heap.insert(8);
            heap.insert(3);
            heap.insert(9);
            heap.insert(6);
            heap.insert(-2);
//            heap.insert(-9);
            System.out.println("Min : "+heap.getMin());
            heap.printHeap();
            heap.removeMin();
            heap.printHeap();


        }
}
