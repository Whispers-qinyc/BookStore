package com.briup.bookstore.mapper;


import com.briup.bookstore.po.Book;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
* @author qinyc
* @description 针对表【es_book】的数据库操作Mapper
* @createDate 2023-07-18 21:32:19
* @Entity com.briup.bookstore.po.Book
*/
@Repository
public interface BookMapper{
    Book selectBookById(Integer id);
    void insertBook(Book book);
    void updateBook(Book book);
    void deleteBookById(Integer id);
    void updateBookStatus(@Param("id") Integer id, @Param("status") Integer status);
    void deleteBookByIds(@Param("ids") List<Integer> ids);

    /**
     * @Author qinyc
     * @Description 根据分类ID获取图书信息
     * @Version: v1.0
     * @Date 17:48 2023/7/24
     * @Param :categoryId
     * @Return: java.util.List<com.briup.bookstore.po.Book>
     **/
    List<Book> selectBooksByCategoryId(Integer categoryId);
}




