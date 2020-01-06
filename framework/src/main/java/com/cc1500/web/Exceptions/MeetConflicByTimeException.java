package com.cc1500.web.Exceptions;

/**
 * @Author 明建新
 * @Create 2019/11/1 14:22
 * @Version 1.0
 */
public class MeetConflicByTimeException extends RuntimeException{
    public MeetConflicByTimeException() {
        super();
    }

    public MeetConflicByTimeException(String message) {
        super(message);
    }

    public MeetConflicByTimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public MeetConflicByTimeException(Throwable cause) {
        super(cause);
    }

    protected MeetConflicByTimeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
