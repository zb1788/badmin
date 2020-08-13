package com.boz.bdmin.common.exception.base.user;

import com.boz.bdmin.common.exception.base.BaseException;

public class UserException extends BaseException {

    private static final long serialVersionUID = 3688107019661352514L;

    public UserException(String code, Object[] args) {
        super("user", code, args);
    }
}
