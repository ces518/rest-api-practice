package me.june.restapitest.account.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AccountControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void getAccounts() throws Exception{
        this.mockMvc.perform(get("/accounts"))
                    .andDo(print())
                    .andExpect(status().isOk());
    }

    @Test
    public void 유저를찾을수없습니다() throws Exception {
        this.mockMvc.perform(get("/accounts/june"))
                    .andDo(print())
                    .andExpect(status().isNotFound());
    }

    @Test
    public void 해당컨텐츠가존재하지않습니다() throws Exception {
        this.mockMvc.perform(get("/accounts"))
                    .andDo(print())
                    .andExpect(status().isNoContent());
    }
}