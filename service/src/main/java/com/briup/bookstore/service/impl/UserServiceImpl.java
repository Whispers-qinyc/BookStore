package com.briup.bookstore.service.impl;

import com.briup.bookstore.constant.BookStoreConstant;
import com.briup.bookstore.dto.UserLoginDTO;
import com.briup.bookstore.dto.UserMessageUpdateDTO;
import com.briup.bookstore.dto.UserRegisterDTO;
import com.briup.bookstore.dto.UserStatusUpdateDTO;
import com.briup.bookstore.exception.BookStoreException;
import com.briup.bookstore.mapper.UserMapper;
import com.briup.bookstore.po.User;
import com.briup.bookstore.service.UserService;
import com.briup.bookstore.utils.BeanCopyUtils;
import com.briup.bookstore.utils.JsonWebTokenUtils;
import com.briup.bookstore.vo.UserInfoVO;
import com.briup.bookstore.vo.UserLoginVO;
import com.briup.bookstore.vo.UserPageVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Objects;

/**
 * @author qinyc
 * @description 针对表【es_user】的数据库操作Service实现
 * @createDate 2023-07-18 21:21:11
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * @Author qinyc
     * @Description 登录
     * @Version: v1.0
     * @Date 10:21 2023/7/21
     * @Param :userLoginDTO
     * @Param :roleId
     * @Return: com.briup.bookstore.vo.UserLoginVO
     **/
    @Override
    public UserLoginVO login(UserLoginDTO userLoginDTO, Integer roleId) {
        //判断用户名是否为空
        if (!StringUtils.hasText(userLoginDTO.getUsername())) {
            throw new BookStoreException(BookStoreException.CodeMsgEnum.USER_USERNAME_IS_NOT_NULL);
        }
        //判断密码是否为空
        if (!StringUtils.hasText(userLoginDTO.getPassword())) {
            throw new BookStoreException(BookStoreException.CodeMsgEnum.USER_PASSWORD_IS_NOT_NULL);
        }
        //判断用户名密码是否正确
        User user = userMapper.getUserByUsernameAndPassword(userLoginDTO.getUsername(), userLoginDTO.getPassword());
        if (Objects.isNull(user)) {
            throw new BookStoreException(BookStoreException.CodeMsgEnum.USER_USERNAME_OR_PASSWORD_ERROR);
        }
        //用户名和密码均正确
        //验证账号状态是否为正常状态
        if (user.getStatus().intValue() == BookStoreConstant.LOGIN_STATUS_CLOSE) {
            throw new BookStoreException(BookStoreException.CodeMsgEnum.USER_STATUS_CLOSE);
        }
        //验证是否为管理员身份
        if (user.getRoleId().intValue() != roleId) {
            //非管理员
            throw new BookStoreException(BookStoreException.CodeMsgEnum.LOGIN_IDENTITY_IS_INVALID);
        }
        //登录者为管理员，根据管理员ID生成JWT
        String jwt = JsonWebTokenUtils.createJWT(user.getId().toString());
        //Bean拷贝
        UserInfoVO userInfo = BeanCopyUtils.copyBean(user, UserInfoVO.class);
        //创建VO对象
        UserLoginVO userLoginVO = new UserLoginVO();
        //封装jwt、用户信息在VO对象中
        userLoginVO.setJwt(jwt).setUserInfo(userInfo);
        //返回统一响应
        return userLoginVO;
    }

    /**
     * @Author qinyc
     * @Description 分页多条件查询用户信息，若存在username，根据username模糊查询，若存在gender，根据gender精确匹配
     * @Version: v1.0
     * @Date 10:22 2023/7/21
     * @Param :pageNum
     * @Param :pageSize
     * @Param :username
     * @Param :status
     * @Param :startTime
     * @Param :endTime
     * @Return: com.github.pagehelper.PageInfo<com.briup.bookstore.vo.UserPageVO>
     **/
    @Override
    public PageInfo<UserPageVO> getUserPage(Integer pageNum, Integer pageSize, String username, String status, String startTime, String endTime) {
        //初始化开始时间
        LocalDateTime registerStartTime = null;
        //初始化结束时间
        LocalDateTime registerEndTime = null;
        if (StringUtils.hasText(startTime)) {
            // 解析带有时区信息的日期时间字符串为Instant对象
            Instant instant = Instant.parse(startTime);
            // 将Instant对象转换为本地时区的LocalDateTime对象
            registerStartTime = instant.atZone(ZoneId.systemDefault()).toLocalDateTime();
        }
        if (StringUtils.hasText(endTime)) {
            // 解析带有时区信息的日期时间字符串为Instant对象
            Instant instant = Instant.parse(endTime);
            // 将Instant对象转换为本地时区的LocalDateTime对象
            registerEndTime = instant.atZone(ZoneId.systemDefault()).toLocalDateTime();
        }
        //开启PageHelper分页插件
        PageHelper.startPage(pageNum, pageSize, true);
        //核心查询
        List<User> users = userMapper.getAllUserByUsernameOrStatus0rRegisterTime(username, status, registerStartTime, registerEndTime);
        //Bean拷贝
        List<UserPageVO> userPageVOS = BeanCopyUtils.copyBeanList(users, UserPageVO.class);
        //封装在PageInfo对象中
        PageInfo<UserPageVO> userPageVOPageInfo = new PageInfo<>(userPageVOS);
        //返回统一响应结果
        return userPageVOPageInfo;
    }

    /**
     * @Author qinyc
     * @Description 新增用户信息
     * @Version: v1.0
     * @Date 10:25 2023/7/21
     * @Param :userRegisterDTO
     * @Return: void
     **/

    @Override
    public void register(UserRegisterDTO userRegisterDTO) {
        //判断用户名是否为空
        if (!StringUtils.hasText(userRegisterDTO.getUsername())) {
            throw new BookStoreException(BookStoreException.CodeMsgEnum.USER_USERNAME_IS_NOT_NULL);
        }
        //判断密码是否为空
        if (!StringUtils.hasText(userRegisterDTO.getPassword())) {
            throw new BookStoreException(BookStoreException.CodeMsgEnum.USER_PASSWORD_IS_NOT_NULL);
        }
        //根据用户名查询用户信息条数
        int count = userMapper.getCountByUsername(userRegisterDTO.getUsername());
        if (count != 0) {
            throw new BookStoreException(BookStoreException.CodeMsgEnum.USER_USERNAME_IS_EXIST);
        }
        //执行新增用户操作
        userMapper.insertUser(userRegisterDTO);
    }

    /**
     * @Author qinyc
     * @Description 修改用户状态
     * @Version: v1.0
     * @Date 10:25 2023/7/21
     * @Param :userStatusUpdateDTO
     * @Return: void
     **/
    @Override
    public void updateUserStatus(UserStatusUpdateDTO userStatusUpdateDTO) {
        if (Objects.isNull(userStatusUpdateDTO)) {
            //id为空
            throw new BookStoreException(BookStoreException.CodeMsgEnum.USER_ID_IS_NOT_NULL);
        }
        //修改用户状态
        userMapper.updateUserStatus(userStatusUpdateDTO);
        //返回响应成功
    }

    /**
     * @Author qinyc
     * @Description 删除与批量删除用户
     * @Version: v1.0
     * @Date 10:25 2023/7/21
     * @Param :ids
     * @Return: void
     **/
    @Override
    public void deleteUser(String ids) {
        //判断ids是否为空
        if (!StringUtils.hasText(ids)) {
            throw new BookStoreException(BookStoreException.CodeMsgEnum.TO_BE_DELETE_USER_IDS_IS_NOT_NULL);
        }
        //批量删除
        try {
            userMapper.deleteBatchIds(ids);
        } catch (Exception e) {
            //遇到异常可能是因为待删除用户有关联的购物车、订单、收货地址信息未被删除
            throw new BookStoreException(BookStoreException.CodeMsgEnum.DELETE_USER_FAIL);
        }

    }

    /**
     * @Author qinyc
     * @Description 获取用户个人信息
     * @Version: v1.0
     * @Date 10:25 2023/7/21
     * @Param :token
     * @Return: com.briup.bookstore.vo.UserInfoVO
     **/
    @Override
    public UserInfoVO getUserInfo(String id) {

        //根据用户ID查询用户信息
        User user = userMapper.getUserById(Integer.parseInt(id));
        //bean拷贝
        UserInfoVO userInfoVO = BeanCopyUtils.copyBean(user, UserInfoVO.class);
        return userInfoVO;
    }

    @Override
    public UserInfoVO updateUserMessage(UserMessageUpdateDTO userMessageUpdateDTO) {
        if (Objects.isNull(userMessageUpdateDTO.getId())) {
            throw new BookStoreException(BookStoreException.CodeMsgEnum.USER_ID_IS_NOT_NULL);
        }
        int i = userMapper.getCountByUsername(userMessageUpdateDTO.getUsername());
        if (i > 0) {
            throw new BookStoreException(BookStoreException.CodeMsgEnum.USER_USERNAME_IS_EXIST);
        }
//        修改用户信息
        userMapper.updateUserMessage(userMessageUpdateDTO);
//        获取修改之后最新的用户信息
        User user = userMapper.getUserById(userMessageUpdateDTO.getId());
        //bean拷贝
        UserInfoVO userInfoVO = BeanCopyUtils.copyBean(user, UserInfoVO.class);

        return userInfoVO;
    }
}




