package com.wewin.notes.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorDetail {
    private int code;
    private String message;
}
