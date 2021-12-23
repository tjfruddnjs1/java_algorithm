# Sort

## Arrays.sort vs Collections.sort
- 정렬 기준 : 오름차순
- Arrays.sort : 배열 정렬
- Collections.sort : List 정렬 -> List.sort (Java 8 이상)
- 성능 차이 : https://sabarada.tistory.com/138

## 사용자 정의 클래스 정렬
1. Comparable 인터페이스를 상속 받아 compareTo 구현
2. Comparator 인터페이스를 상속 받아 compare 구현
- https://velog.io/@dbtlwns/JavaArrays.sort%EC%99%80-Collections.sort