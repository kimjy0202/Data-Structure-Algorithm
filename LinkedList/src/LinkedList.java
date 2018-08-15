public class LinkedList {

    Node head = null;
    Node tail = null;
    int size = 0;

    private class Node
    {
        private Object data;
        private Node next;

        public Node(Object data)
        {
            this.data = data;
            this.next = null;
        }

        public String toString()
        {
            return String.valueOf(this.data);
        }
    }

    public int size()
    {
        return this.size;
    }

    public String toString()
    {
        if(size == 0) {return "[]";}

        String s = "START -> " + head.toString();

        Node curNode = head;
        while(curNode.next != null)
        {
            curNode = curNode.next;
            s +=  " -> " + curNode.toString();
        }

        s += " -> DONE";

        return s;
    }

    public void addFirst(Object obj)
    {
        Node newNode = new Node(obj);

        newNode.next = head;
        head = newNode;

        // 처음으로 노드 추가하는 경우
        if(tail == null)
        {
            tail = newNode;
        }

        size++;
    }

    public void addLast(Object obj)
    {
        Node newNode = new Node(obj);

        if(tail == null) // or if(size ==0)
        {
            tail = newNode;
            head = newNode;
        }

        else
        {
            tail.next = newNode;
            tail = newNode;
        }

        size++;
    }

    // 노드 찾는 함수
    public Node search(int index)
    {
        if(index >= size) return null;

        Node curNode = head;

        for(int i=index; i>0; --i)
        {
            curNode = curNode.next;
        }

        return curNode;
    }

    // index 위치에 노드 삽입
    public void insert(Object obj, int index) {
        if (index == 0) {
            addFirst(obj);
        } else {
            Node newNode = new Node(obj);

            // 포인터 변경 위해 넣고자 하는 index의 이전 node를 찾기
            if (search(index - 1) == null) {
                System.out.println("index error");
                return;
            }

            Node prev = search(index - 1);

            newNode.next = prev.next;
            prev.next = newNode;

            if (newNode.next == null) {
                tail = newNode;
            }

            size++;
        }
    }

    public void removeFirst()
    {
        head = head.next;
        size--;
    }


    // index 위치의 노드 삭제
    public void remove(int index)
    {
        if(index == 0){ removeFirst();}

        else
        {
            // 포인터 변경 위해 넣고자 하는 index의 이전 node를 찾기
            if(search(index-1) == null)
            {
                System.out.println("index error");
                return;
            }

            Node prev = search(index -1);

            //마지막 노드를 제거하는 경우
            if(index == size-1)
            {
                tail = prev;
                prev.next = null;
            }

            else{  prev.next = prev.next.next; }
        }

        size--;
    }

}
