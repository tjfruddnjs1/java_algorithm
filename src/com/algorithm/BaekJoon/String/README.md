# String

## char to int
1. `char - '0'`
2. `Character.getNumbericValue(char)`

## char to String
```
char[] arrChr = {'a','b','c'};

String str = new String(arrChr);
String str_1 = String.valueOf(arrChr); 
``` 

## String Method
1. `char charAt(int index)`
- index 번째 문자 반환

2. `int indexOf(String str, [int fromIndex])`
- str 존재시 위치 index 리턴, 없으면 -1 리턴

3. `char[] toCharArray()`
- string to char[]

4. `String[] split(String regex, int limit)`
- `limit`으로 배열의 크기 한정
- https://jamesdreaming.tistory.com/84
