public class Main {

    public static void main(String[] args) {

        MaxHeap heap = new MaxHeap();

        heap.add(14);
        heap.add(19);
        heap.add(21);
        heap.add(29);
        heap.add(30);
        heap.add(17);
        heap.add(23);
        heap.add(25);
        heap.add(32);

        heap.remove();
        heap.remove();

        heap.add(55);

        System.out.println("size of the heap : " + heap.size);
        heap.printList();

    }
}
