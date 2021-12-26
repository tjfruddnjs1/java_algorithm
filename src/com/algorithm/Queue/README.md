# Queue

## 큐 함수 Return Type

<img src="https://user-images.githubusercontent.com/41010744/147411295-82dcedfb-f5a9-4f39-9cce-17d113b1a5fd.png">

> 출처 : http://www.tcpschool.com/java/java_collectionFramework_stackQueue

## 우선순위 큐

- Heap 구조를 가지며 정렬 순서에 따라 가장 큰 값이 먼저 나오는 MaxHeap, 가장 작은 값이 먼저 나오는 MinHeap

> 사용 : 기본적으로 오름차순
```
    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
```

> 정렬 기준 만들기 1 : https://tosuccess.tistory.com/155
> 정렬 기준 만들기 2 : https://woovictory.github.io/2020/05/13/PriorityQueue/

