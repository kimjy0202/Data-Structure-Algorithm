import java.util.*;


// 최대 힙 (max heap) 구현
public class MaxHeap {

    // heap 리스트
    public ArrayList<Integer> heapList = new ArrayList<>();
    int size;

    MaxHeap()
    {
       size = 0;
       heapList.add(0);
    }

    // 배열 끝에 data 추가 후 재구축
    public void add(int data)
    {
        size++;
        heapList.add(data);

        int curIndex = size;
        int parentIndex = curIndex / 2;


        // 새로운 데이터가 부모 데이터보다 클 경우 위치 교환
        while(heapList.get(curIndex) > heapList.get(parentIndex))
        {
            // 현재 인덱스가 root일 경우 리턴
            if(curIndex ==1) return;

            int temp = heapList.get(curIndex);
            heapList.set(curIndex, heapList.get(parentIndex));
            heapList.set(parentIndex, temp);

            // 인덱스 세팅 다시하기
            curIndex = parentIndex;
            parentIndex = curIndex / 2;
        }

    }

    // 루트(index = 1) 제거 후 재구축
    public void remove()
    {
        // 가장 끝의 데이터를 제일 처음으로 가져온 후 사이즈 감소 및 끝 데이터 제거
        heapList.set(1, heapList.get(size));
        heapList.remove(size);
        size--;

        int curIndex = 1;

        //현재 노드의 자식 인덱스
        int leftChildIndex = curIndex * 2;
        int rightChildIndex = curIndex * 2 + 1;

        int compareIndex;

        // 자식이 있으면
        while(leftChildIndex <= size)
        {
            // 자식이 둘다 있으면
            if(rightChildIndex <= size)
            {
                // 둘 중 큰 값을 가지는 인덱스가 현재값과 비교할 인덱스가 됨
                compareIndex = (heapList.get(leftChildIndex) >=
                        heapList.get(rightChildIndex))? leftChildIndex : rightChildIndex;
            }

            // 왼쪽 자식만 있으면 왼쪽 자식이 비교할 인덱스가 됨
            else { compareIndex = leftChildIndex; }

            // 자식의 데이터가 부모보다 클 경우 위치 교환
            if(heapList.get(curIndex) < heapList.get(compareIndex))
            {
                int temp = heapList.get(curIndex);
                heapList.set(curIndex, heapList.get(compareIndex));
                heapList.set(compareIndex, temp);

                // 인덱스 세팅 다시하기
                curIndex = compareIndex;
                leftChildIndex = curIndex * 2;
                rightChildIndex = curIndex * 2 + 1;
            }

            // 부모 데이터가 더 클 경우 종료
            else return;
        }

    }

    public void printList()
    {
        for(int i=1; i<=size; i++)
        {
            System.out.print( heapList.get(i) + " ");
        }
    }
}
