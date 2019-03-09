package me.june.restapitest.Exception;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by IntelliJ IDEA.
 * User: june
 * Date: 2019-03-10
 * Time: 00:32
 **/
@Getter @Setter
public class Errors {
    private String errorCode;
    private String cause;

    @Builder
    public Errors(String errorCode, String cause) {
        this.errorCode = errorCode;
        this.cause = cause;
    }

    public static Errors ofNotFound(String data) {
        return Errors.builder()
                .errorCode("404")
                .cause(String.format("[%s] 는 존재하지않는 유저입니다.", data))
                .build();
    }

    public static Errors ofNotFound() {
        return Errors.builder()
                .errorCode("204")
                .cause("해당 컨텐츠를 찾을 수 없습니다.")
                .build();
    }
}
