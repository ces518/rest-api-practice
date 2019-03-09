package me.june.restapitest.account.repository;

import me.june.restapitest.account.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * Created by IntelliJ IDEA.
 * User: june
 * Date: 2019-03-09
 * Time: 23:59
 **/
public interface AccountRepository extends JpaRepository<Account,Long> {
    Account findByUsername(String username);
}
