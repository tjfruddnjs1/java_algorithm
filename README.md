# Algorithm using Java

## Scanner VS BufferedReader

> Scanner : 기본형과 String Type 정규표현식을 사용해서 `파싱`

- **Parse** : 사용자가 입력한 텍스트를 token 단위로 잘라서 특정 형태로 변환

> BufferedReader : 사용자가 입력한 `문자 스트림`을 읽는 것

- **Read** : 사용자가 입력한 데이터를 그대로 읽음
- https://yeon-kr.tistory.com/151

## Scanner next() vs nextLine()

- next : 띄어쓰기 인식 X
- nextLine : enter 치기 전까지 문장 전체를 읽음

## BufferedReader, BufferedWriter 사용법

> BufferedReader : Scanner 유사
>
> BufferedWriter : System.out.println() 유사

- 속도 측면에서 훨씬 빠름 (입력 데이터가 바로 전달되지 않고 버퍼를 거쳐 전달 > 처리 효율성 증대)
- 하지만 Enter 만을 경계로 인식하고 받은 데이터가 String 고정 > 가공을 필요로함

1. BufferedReader 사용법

- 선언

> BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

- 입력 : readLine() 메서드 이용
    - return String 고정 > 형변환 필요
    - 예외처리 필수 main 클래스 옆에 `IOException` 작성
        - public static void main(String[] args) throws IOException {}

- 사용 : StringTokenizer, String.split()
    - StringTokenizer > nextToken() 함수 > 입력 값 공백단위로 구분하여 호출
    - String.split() > 배열에 공백단위로 끊어 데이터 넣고 사용하는 방식

- void close() : 입력 스트림을 닫고 사용하던 자원 해제
- int read() : 한 글자만 읽어 정수형으로 반환 > '3' > (int)'3' = return 51
- boolean ready() : 입력 스트림이 사용할 준비가 되었는지 확인
- void mark(int, readAheadLimit) : 스트림의 현재 위치를 마킹

2. BufferedWriter 사용법

- 선언

> BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

- 출력 : write() 메서드 이용
    - 자동개행 X > newLine(), `\n` 을 통해 개행

- 버퍼를 잡아 놓았기 때문에 flush(), close()를 통해 뒤처리 필요

- void newLine() : 개행
- void write(int c) : 한 글자 쓰기
- void write(String s, int offset, int length) : offset 부터 일정 길이만큼 write

## StringBuilder

- String : 불변성 O, StringBuilder : 불변성 X
- 값 변경시(concat, +) 기존 String 메모리가 아닌 새로운 값을 재할당
- String : 변하지 않는 문자열에 사용시 유리
- StringBuilder/StringBuffer : 가변성을 가지기 때문에 문자열 변경이 빈번할 때 사용

- 선언

> StringBuilder sb = new StringBuilder();

- append(String s) : 뒤에 문자열 s 붙임
- delete(int start, int end) : start ~ end 인덱스 삭제
- insert(int offset, any primitive of a char[]) : 문자 삽입
- reverse() : 순서를 뒤집음
- setCharAt(int index, char ch) : 주어진 문자를 치환
- indexOf(string s) : 값이 어느 인덱스에 들어있는지 확인
- subString(int start, int end) : start ~ end 사이 값 잘라옴

> https://codevang.tistory.com/121?category=827592