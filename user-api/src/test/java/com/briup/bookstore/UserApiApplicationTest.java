package com.briup.bookstore;

import com.briup.bookstore.dto.UserMessageUpdateDTO;
import com.briup.bookstore.service.UserService;
import com.briup.bookstore.vo.UserInfoVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author briup-adam
 * @Date 2023/7/25 上午10:16
 * @Description
 **/

@SpringBootTest
public class UserApiApplicationTest {
    @Autowired
    UserService userService;

    @Test
    void  updateUser(){
        UserMessageUpdateDTO dto = new UserMessageUpdateDTO();
        dto.setId(1);
        dto.setUsername("tom");
        dto.setPassword("tom");
        UserInfoVO user = userService.updateUserMessage(dto);

    }


}
