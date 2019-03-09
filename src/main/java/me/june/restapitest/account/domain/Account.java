package me.june.restapitest.account.domain;

import lombok.*;
import me.june.restapitest.model.BaseEntity;

import javax.persistence.Entity;

/**
 * Created by IntelliJ IDEA.
 * User: june
 * Date: 2019-03-09
 * Time: 23:50
 **/
@Entity
@Getter @NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Account extends BaseEntity {

    private String username;

    private String password;

    @Builder
    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
