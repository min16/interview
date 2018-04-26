# JAVA

* #### Java is always pass-by-value
---

## Java is always pass-by-value
> java는 모든 것이 pass-by-value 이다.

#### 변수 타입
1. **primitive type**: 비트로 저장되는 값
2. **reference type**: 객체에 접근 가능한 주소값

#### 선언 위치에 따른 변수 종류
- **지역 변수**: 메소드 내 선언된 변수 or 매개변수
- **인스턴스 변수**: 클래스 내, 메소드 밖에 선언된 모든 원시변수와 레퍼런스 변수
- **static 변수**: 클래스내 static으로 선언된 변수

#### by Value vs by Reference
- **By value**: 메소드 호출시 매개변수를 값으로 전달할 경우, 기존 변수를 복사하여 같은 비트 값을 가진 새로운 변수를 생성하여 전달한다. 그러므로 메소드 내에서 변수값이 변경되어도 기존 변수에 영향을 주지 않는다. (같은 값인 독립된 두개의 변수)
- **By reference**: 메소드 호출시 매개변수를 레퍼런스로 전달할 경우, 변수를 가리키는 주소값을 전달한다. 그러므로 메소드 내에서 값을 변경하면 기존 변수 또한 변경된다. (같은 변수)

#### 1. passing primitive arguments
```java
public static void main(String[] args) {
  int x = 1;
  int y = 2;
  System.out.println("x =" + x + ", y = " + y); // x = 1, y = 2

  modifyPrimitiveTypes(x, y);  
  System.out.println("x =" + x + ", y = " + y); // x = 1, y = 2
}

private static void modifyPrimitiveTypes(int w, int z) {
  w = 5;
  z = 10;
}
```

##### 결과 설명:
x, y 는 `primitive type`으로 stack memory의 `main` 함수 프레임 안에 존재한다.
`modifyPrimitiveTypes()` 함수를 콜하면 stack memory의 `modifyPrimitiveTypes()` 함수 프레임 안에 `x`와 `y`의 복사본으로 `w`와 `z`가 생성된다.
함수 호출결과 `x = 1`, `y = 2`, `w = 6`, `z = 10` 이 된다.
__즉, 값만 전달하여 독립된 두 변수가 생성됨.__

#### 2. passing objects as arguments
```java
public static void main(String[] args) {
  Student student = new Student("Jay");
  System.out.println(student.getName()); // Jay
  modifyStudent(student);
  System.out.println(student.getName()); // Alex
}

private static void modifyStudent(Student student) {
  student.setName("Alex");
  student = new Student("Joe");
}
```

##### 결과 설명:
student object가 heap에 생성되고 stack에 레퍼런스 변수가 student를 가리키고 있다.
`modifyStudent()` 함수를 콜하면 stack에 있는 레퍼런스를 복사하여 값으로 전달한다.
`modifyStudent()` 함수에 새로운 레퍼런스 변수가 생성되어 heap에 있는 같은 student object를 가리킨다.
마지막에는 레퍼런스 변수가 새로운 student object로 가리킨다.
__즉, 값만 전달하여 독립된 두 변수가 생성됨.__
