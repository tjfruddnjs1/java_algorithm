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

2. BufferedWriter 사용법

-
