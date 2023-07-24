package com.briup.bookstore.mapper.ext;

import com.briup.bookstore.po.ext.BookExtend;
import com.briup.bookstore.vo.BookSearchVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookExtendMapper {

    List<BookExtend> selectBooksByCondition(@Param("bookSearchVO") BookSearchVO bookSearchVO);
}
