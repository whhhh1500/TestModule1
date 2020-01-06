package com.cc1500.web.Exceptions;

/**
 * @Author 明建新
 * @Create 2019/11/1 14:42
 * @Version 1.0
 */
public class MeetConflicByRoomException extends RuntimeException{
    public MeetConflicByRoomException() {
        super();
    }

    public MeetConflicByRoomException(String message) {
        super(message);
    }

    public MeetConflicByRoomException(String message, Throwable cause) {
        super(message, cause);
    }

    public MeetConflicByRoomException(Throwable cause) {
        super(cause);
    }

    protected MeetConflicByRoomException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
