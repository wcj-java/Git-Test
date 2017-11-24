package com.yct.exception;


/**
 * 业务异常
 * @author wcj
 * @since 1.0.0
 * 
 * 修改记录： <br />
 * 修 改 者    修改日期     文件版本   修改说明
 */
public class BizException extends BaseException {

    private static final long serialVersionUID = 5171771394185469307L;

    public BizException() {
        super ();
    }

    public BizException(String errorCode) {
        this (errorCode, "");
    }

    public BizException(String errorCode, String defaultMessage) {
        super (errorCode, defaultMessage);
    }

    public BizException(String errorCode, String internalCode, String defaultMessage) {
        super (errorCode, internalCode, defaultMessage);
    }

    public BizException(Throwable cause, String errorCode, String defaultMessage) {
        super (cause, errorCode, defaultMessage);
    }

    public BizException(Throwable cause, String errorCode) {
        super (cause, errorCode);
    }

    public BizException(String errorCode, String[] args) {
        super (errorCode, args);
    }

    @Override
    public String getMessage(){
        if (this.defaultMessage != null && defaultMessage.length () != 0) { 
            return this.defaultMessage;
        }
        String message = BizExceptionMessage.getInstance ().getExpInfo (this.getErrorCode ());
        for (int i = 0; this.getArgs () != null && i < this.getArgs ().length; i++) {
            message = message.replaceFirst("\\{\\d{1}\\}", this.getArgs ()[i]);
        }
        return message;
    }
}
