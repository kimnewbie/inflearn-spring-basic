package hello.core;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * lombok 설치 후 getter, setter 적용 테스트
 */
@Getter
@Setter
@ToString
public class HelloLombok {
    private String name;
    private int age;

    public static void main(String[] args) {
        HelloLombok helloLombok = new HelloLombok();
        helloLombok.setName("yj");

        System.out.println("helloLombok = " + helloLombok);
    }
}
