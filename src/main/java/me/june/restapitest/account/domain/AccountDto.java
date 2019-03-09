package me.june.restapitest.account.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

/**
 * Created by IntelliJ IDEA.
 * User: june
 * Date: 2019-03-09
 * Time: 23:53
 **/
public class AccountDto {

    @Getter
    public static class Req {
        private Long id;
        private int page;
        private String username;

        public Req(Long id, Integer page, String username) {
            this.id = id;
            this.page = Optional.ofNullable(page).orElse(1);
            this.username = username;
        }
    }

    @Getter
    public static class Create {
        private String username;
        private String password;

        @Builder
        public Create(String username, String password) {
            this.username = username;
            this.password = password;
        }
    }

    @Getter
    public static class ResAccount {
        private String username;

        public ResAccount(Account account) {
            this.username = account.getUsername();
        }
    }

    @Getter
    public static class ResAccounts {
        private int page = 1;
        private List<Account> content;

        public ResAccounts(Page<Account> accounts) {
            this.page = accounts.getNumber();
            this.content = accounts.getContent();
        }
    }
}
