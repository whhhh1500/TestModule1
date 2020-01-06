package com.cc1500.web.Exceptions;

/**
 * @Author 明建新
 * @Create 2019/11/11 9:09
 * @Version 1.0
 */
public class MeetNoDeptException extends RuntimeException {
    public MeetNoDeptException() {
        super();
    }

    public MeetNoDeptException(String message) {
        super(message);
    }

    public MeetNoDeptException(String message, Throwable cause) {
        super(message, cause);
    }

    public MeetNoDeptException(Throwable cause) {
        super(cause);
    }

    protected MeetNoDeptException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
