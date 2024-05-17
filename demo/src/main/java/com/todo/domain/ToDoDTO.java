package com.todo.domain;

// 룸복(Getter, Setter)을 사용하여 간단히 작성
// 자바 프로그래밍 언어에서 사용되는 라이브러리
//
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ToDoDTO {
    private Long idx;
    private String item;
    private String status;
}
