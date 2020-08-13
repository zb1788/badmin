package com.boz.bdmin.common.exception.base.user;

public class UserNotExistsException extends UserException
{
    private static final long serialVersionUID = -2681404513734310278L;

    public UserNotExistsException()
    {
        super("user.not.exists", null);
    }
}