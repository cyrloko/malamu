package com.rissslow.malamu.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class DefaultException extends Exception {
    public final int code;
    public final String message;
}
