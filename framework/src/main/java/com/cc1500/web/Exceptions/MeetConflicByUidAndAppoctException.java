package com.cc1500.web.Exceptions;

/**会议冲突异常
 * @Author 明建新
 * @Create 2019/11/1 13:59
 * @Version 1.0
 */
public class MeetConflicByUidAndAppoctException extends RuntimeException{
    public MeetConflicByUidAndAppoctException() {
        super();
    }

    public MeetConflicByUidAndAppoctException(String message) {
        super(message);
    }

    public MeetConflicByUidAndAppoctException(String message, Throwable cause) {
        super(message, cause);
    }

    public MeetConflicByUidAndAppoctException(Throwable cause) {
        super(cause);
    }

    protected MeetConflicByUidAndAppoctException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
