# List

## vs Array
- 가장 큰 차이점 : 길이를 조정할 수 있는가 없는가
- Array : 고정 길이, ArrayList : 가변 길이
- 편리함의 대가로 Array 보다 속도가 느림

1. Resizable : 크기 초과시 배열 크기를 1.5배 증가시킴
2. Performance : resize 시 성능 저하
3. Primitives
- Array : Primitive Type, Object
- ArrayList : Object
4. Size
- Array : length
- ArrayList : size()
5. Add elements
- Array : Assign Operator(=)을 통해 요소 추가
- ArrayList : add()
6. Multi-dimensional
- Array : 다차원 가능
- ArrayList : 불가능

- https://velog.io/@humblechoi/%EC%9E%90%EB%A3%8C%EA%B5%AC%EC%A1%B0-Array-vs-ArrayList


## vs ArrayList
- List : 인터페이스 , ArrayList : 클래스
- 하지만, List 사용시 유연성에서 효과적
- 특정 타입을 `미리 지정하는 것이 아닌` 외부에서 필요에 의해 지정
```
ArrayList<Object> list = new ArrayList<>();
List<Object> list = new ArrayList<>();
```

## 특정 값 포함 여부 확인

- https://hianna.tistory.com/556