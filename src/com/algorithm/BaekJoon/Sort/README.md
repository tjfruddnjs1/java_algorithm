# Sort

## Arrays.sort vs Collections.sort
- 정렬 기준 : 오름차순
- Arrays.sort : 배열 정렬
- Collections.sort : List 정렬 -> List.sort (Java 8 이상)
- 성능 차이 : https://sabarada.tistory.com/138

## 내림차순 정렬
- Array Primitive Type 일 경우 type error
- Wrapper Class 를 통해 `Collections.reverseOrder()` 수행
> https://gosasac.tistory.com/11

## 사용자 정의 클래스 정렬
1. Comparable 인터페이스를 상속 받아 compareTo 구현
2. Comparator 인터페이스를 상속 받아 compare 구현
- https://velog.io/@dbtlwns/JavaArrays.sort%EC%99%80-Collections.sort

## 위상 정렬(그래프 정렬)
- 선후 관계가 정해져 있는 그래프 구조에서 정렬을 하기 위해 사용
- 조건 : 방향성이 있으며 사이클이 없는 그래프
- 구현 방법 : (1) DFS , (2) Queue With indegree Array