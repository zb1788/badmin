package com.boz.bdmin.common.exception.base.user;

public class CaptchaException extends UserException
{

    private static final long serialVersionUID = -6050165389055152660L;

    public CaptchaException()
    {
        super("user.jcaptcha.error", null);
    }
}