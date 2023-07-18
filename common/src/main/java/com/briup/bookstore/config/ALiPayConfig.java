package com.briup.bookstore.config;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.briup.bookstore.constant.BookStoreConstant;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ALiPayConfig {

    @Bean
    public  AlipayClient getALiPayClient() {
        return new DefaultAlipayClient(BookStoreConstant.SERVER_URL,BookStoreConstant.APP_ID,BookStoreConstant.APP_PRIVATE_KEY,BookStoreConstant.FORMAT,
                BookStoreConstant.CHARSET,BookStoreConstant.ALIPAY_PUBLIC_KEY,BookStoreConstant.SIGN_TYPE);
    }

}
