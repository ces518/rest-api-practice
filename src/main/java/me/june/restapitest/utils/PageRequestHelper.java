package me.june.restapitest.utils;

import me.june.restapitest.account.domain.AccountDto;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

/**
 * Created by IntelliJ IDEA.
 * User: june
 * Date: 2019-03-10
 * Time: 00:00
 **/
public class PageRequestHelper {

    public static PageRequest accounts(AccountDto.Req dto, String standardColumn) {
        return PageRequest.of(dto.getPage(),10, Sort.Direction.DESC,standardColumn);
    }
}
