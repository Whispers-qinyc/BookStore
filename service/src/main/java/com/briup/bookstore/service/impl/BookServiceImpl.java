package com.briup.bookstore.service.impl;


import com.briup.bookstore.exception.BookStoreException;
import com.briup.bookstore.mapper.BookMapper;
import com.briup.bookstore.mapper.CategoryMapper;
import com.briup.bookstore.mapper.ext.BookExtendMapper;
import com.briup.bookstore.po.Book;
import com.briup.bookstore.po.Category;
import com.briup.bookstore.po.ext.BookExtend;
import com.briup.bookstore.service.BookService;
import com.briup.bookstore.vo.BookSearchVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
* @author qinyc
* @description 针对表【es_book】的数据库操作Service实现
* @createDate 2023-07-18 21:32:19
*/
@Service
public class BookServiceImpl implements BookService{
    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private BookExtendMapper bookExtendMapper;

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public Book getBookById(Integer id) {
        return bookMapper.selectBookById(id);
    }

    @Override
    public PageInfo<BookExtend> getPageBook(Integer pageNum, Integer pageSize, BookSearchVO bookSearchVO) {
        // 开启分页
        PageHelper.startPage(pageNum, pageSize, true);
        // 条件查询图书信息
        List<BookExtend> books = bookExtendMapper.selectBooksByCondition(bookSearchVO);
        // 封装分页对象返回
        return new PageInfo<>(books);
    }

    @Override
    public void saveBook(Book book) {
        // 参数校验
        this.validate(book);
        // 判断分类信息是否存在
        if (book.getCategoryId() != null) {
            categoryIsOrNotExist(book.getCategoryId());
        }
        // 执行添加
        bookMapper.insertBook(book);
    }

    @Override
    public void modifyBook(Book book) {
        // 参数校验
        this.validate(book);
        // 判断图书信息是否存在
        bookIsOrNotExist(book.getId());
        // 判断分类信息是否存在
        if (book.getCategoryId() != null) {
            categoryIsOrNotExist(book.getCategoryId());
        }
        // 执行修改，返回是否修改成功
        bookMapper.updateBook(book);
    }

    @Override
    public void removeBook(Integer id) {
        // 判断图书信息是否存在
        bookIsOrNotExist(id);
        // 执行删除
        bookMapper.deleteBookById(id);
    }

    @Override
    public void removeBatchByIds(List<Integer> ids) {
        // 判断要删除的图书信息是否都存在
        for (Integer id : ids) {
            bookIsOrNotExist(id);
        }
        // 都存在，则全部删除
        bookMapper.deleteBookByIds(ids);
    }

    @Override
    public void modifyStatus(Integer id, Integer status) {
        // 判断图书信息是否存在
        bookIsOrNotExist(id);
        // 执行修改图书状态
        bookMapper.updateBookStatus(id,status);
    }

    // 参数校验方法
    private void validate(Book book) {
        if (!StringUtils.hasText(book.getName())) {
            throw new BookStoreException(BookStoreException.CodeMsgEnum.BOOK_NAME_IS_NULL);
        }

        if (!StringUtils.hasText(book.getAuthor())) {
            throw new BookStoreException(BookStoreException.CodeMsgEnum.BOOK_AUTHOR_IS_NULL);
        }

        if (!StringUtils.hasText(book.getPublisher())) {
            throw new BookStoreException(BookStoreException.CodeMsgEnum.BOOK_PUBLISHER_IS_NULL);
        }
    }

    // 校验图书是否存在
    private void bookIsOrNotExist(Integer id) {
        Book book = this.getBookById(id);
        if (book == null) {
            throw new BookStoreException(BookStoreException.CodeMsgEnum.BOOK_NOT_EXIST);
        }
    }

    // 校验分类是否存在
    private void categoryIsOrNotExist(Integer id) {
        Category category = categoryMapper.selectCategoryById(id);
        if (category == null) {
            throw new BookStoreException(BookStoreException.CodeMsgEnum.CATEGORY_NOT_EXIST);
        }
    }
}




