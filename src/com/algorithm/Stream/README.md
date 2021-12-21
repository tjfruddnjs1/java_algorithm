# Stream

## 정의
- Java8 부터 지원하는 컬렉션, 배열 등에 대해 저장되어 있는 요소들을 하나씩 참조하며 반복적인 처리를 가능케 하는 기능
- Stream 이용시 불필요한 for, if 등의 분기 처리를 하지 않고 직관적인 코드로 변형

## 특징
1. 데이터 변경 X : 읽기만 할 뿐 변경 X
2. 일회용 : 한번 사용시 재사용 불가능
3. 작업을 내부 반복으로 처리 : 반복문을 메서드 내부에 숨김

## 구조
1. Stream 생성
2. 중개 연산
3. 최종 연산

> 데이터소스객체집합.Stream().중개연산().최종연산();

## 1. Stream 생성

> 데이터 소스 객체 집합

1. 컬렉션
2. 배열
3. 가변 매개변수
4. 지정된 범위의 연속되 정수
5. 특정 타입의 난수들
6. 람다 표현식
7. 파일
8. 빈 스트림

## 2. 중개 연산

- Stream 전달 받아 Stream 반환
- 중개 연산을 연속으로 사용 가능
- 필터-맵 기반의 API 사용함으로 지연(lazy) 연산을 통해 성능을 최적화 가능

1. Stream 필터링 : filter() : 필터링 , distinct() : 중복제거
2. Stream 변환 : map(), flatMap()
> https://madplay.github.io/post/difference-between-map-and-flatmap-methods-in-java
3. Stream 제한 : limit(), skip()
4. Stream 정렬 : sorted()
5. Stream 연산 결과 확인 : peek()


## 3. 최종 연산

- 중개 연산을 통해 만들어진 stream 있는 요소들에 대해 마지막으로 각 요소를 소모하며 최종 결과 표시
- 지연(lazy)되었던 모든 중개 연산들이 최종 연산 시에 모두 수행
- `모든 요소를 소모한 해당 stream 더이상 사용 불가`

1. 출력 : forEach()
2. 소모 : reduce()
3. 검색 : findFirst(), findAny()
4. 검사 : anyMatch(), allMatch(), noneMatch()
5. 통계 : count(), min(), max()
6. 연산 : sum(), average)
7. 수집 : collect()

> 참고 : https://ahndding.tistory.com/23
