package com.springboot.springbootusertodo.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TodoRequest {
    private int id;
    private String todo;
    private int userId;
}
