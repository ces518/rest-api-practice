package me.june.restapitest.account.formatter;

import me.june.restapitest.account.domain.AccountDto;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

/**
 * Created by IntelliJ IDEA.
 * User: june
 * Date: 2019-03-10
 * Time: 01:08
 **/
public class AccountDtoFormatter implements Formatter<AccountDto.Req> {

    @Override
    public AccountDto.Req parse(String s, Locale locale) throws ParseException {
        AccountDto.Req dto = new AccountDto.Req(0L,0,s);
        return dto;
    }

    @Override
    public String print(AccountDto.Req req, Locale locale) {
        return req.toString();
    }
}
