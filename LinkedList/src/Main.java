public class Main {

    public static void main(String[] args) {

        LinkedList list = new LinkedList();

        list.addFirst(3);
        list.addLast(2);
        list.insert(5, 1);
        list.insert(1, 1);
        list.removeFirst();
        list.remove(2);
        list.insert(3,2);
        list.addLast(44);
        list.addFirst(0);
        list.remove(3);
        list.removeFirst();
        list.insert(33333,3);
        list.insert(22, 4);

        System.out.println("size of the linked list : " + list.size());
        System.out.println(list.toString());

    }
}
