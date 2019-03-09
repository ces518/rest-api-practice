package me.june.restapitest.Exception;

import lombok.Getter;

/**
 * Created by IntelliJ IDEA.
 * User: june
 * Date: 2019-03-10
 * Time: 00:21
 **/
@Getter
public class NotFoundUserException extends RuntimeException{

    private String username;

    public NotFoundUserException(String username) {
        this.username = username;
    }
}
