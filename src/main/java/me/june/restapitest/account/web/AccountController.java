package me.june.restapitest.account.web;

import me.june.restapitest.Exception.Errors;
import me.june.restapitest.Exception.NotFoundContentsException;
import me.june.restapitest.Exception.NotFoundUserException;
import me.june.restapitest.account.domain.Account;
import me.june.restapitest.account.domain.AccountDto;
import me.june.restapitest.account.formatter.AccountDtoFormatter;
import me.june.restapitest.account.service.AccountService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

/**
 * Created by IntelliJ IDEA.
 * User: june
 * Date: 2019-03-09
 * Time: 23:55
 **/
@RestController
@RequestMapping("/accounts")
public class AccountController {

    private final AccountService service;

    public AccountController(AccountService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity getAccounts(AccountDto.Req dto) {
        Page<Account> accounts = service.findAccounts(dto);
        AccountDto.ResAccounts res = new AccountDto.ResAccounts(accounts);
        return ResponseEntity.ok(res);
    }

    @GetMapping("/{username}")
    public ResponseEntity getAccount(@PathVariable String username) {
        Account account = service.findAccount(username);
        AccountDto.ResAccount response = new AccountDto.ResAccount(account);
        return ResponseEntity.ok(response);
    }

    @ExceptionHandler(NotFoundUserException.class)
    public ResponseEntity notFoundUser(NotFoundUserException e) {
        Errors errors = Errors.ofNotFound(e.getUsername());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errors);
    }

    @ExceptionHandler(NotFoundContentsException.class)
    public ResponseEntity notFoundContents(NotFoundContentsException e) {
        Errors errors = Errors.ofNotFound();
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(errors);
    }
}
