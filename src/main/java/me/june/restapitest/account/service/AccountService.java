package me.june.restapitest.account.service;

import lombok.extern.slf4j.Slf4j;
import me.june.restapitest.Exception.NotFoundContentsException;
import me.june.restapitest.Exception.NotFoundUserException;
import me.june.restapitest.account.domain.Account;
import me.june.restapitest.account.domain.AccountDto;
import me.june.restapitest.account.repository.AccountRepository;
import me.june.restapitest.utils.PageRequestHelper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 * Created by IntelliJ IDEA.
 * User: june
 * Date: 2019-03-09
 * Time: 23:57
 **/
@Slf4j
@Service
public class AccountService {

    private final AccountRepository repository;

    public AccountService(AccountRepository repository) {
        this.repository = repository;
    }

    public Page<Account> findAccounts(AccountDto.Req dto) {
        PageRequest pageRequest = PageRequestHelper.accounts(dto, "id");
        Page<Account> accounts = repository.findAll(pageRequest);

        if(!accounts.hasContent()) {
            throw new NotFoundContentsException();
        }
        return accounts;
    }

    public Account findAccount(String username) {
        log.debug("username = {}",username);
        Assert.notNull(username,"username should be not null");
        Account account = repository.findByUsername(username);

        if(account == null) {
            throw new NotFoundUserException(username);
        }
        return account;
    }
}
