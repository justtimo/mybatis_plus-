package com.wby.mp;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.wby.mp.bean.Product;
import com.wby.mp.bean.User;
import com.wby.mp.mapper.ProductMapper;
import com.wby.mp.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class MpApplicationTests {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private ProductMapper productMapper;

    @Test
    void contextLoads() {
    }
    int i ;
   /* @Test
    public void testInsert(){

            User wby = new User(null, "wby12", 12, "wby6225194@153.com");
            int line = userMapper.insert(wby);
            System.out.println(line);
            System.out.println(wby);

    }
    @Test
    public void testupdate(){

        User wby = new User(7L, "wby13", 12, "wby6225194@153.com");
        int line = userMapper.updateById(wby);
        System.out.println(line);
        System.out.println(wby);
    }*/

    @Test
    public void testFileInsert(){

        User wby = new User();
        wby.setAge(12);
        wby.setEmail("123@123");
        wby.setName("张三");
        int line = userMapper.insert(wby);
        System.out.println(line);
        System.out.println(wby);
    }

    @Test
    public void testFileUpdate(){

        User wby = new User();
        wby.setAge(12);
        wby.setEmail("123@123");
        wby.setName("张三");
        wby.setId(8L);
        int line = userMapper.updateById(wby);

        System.out.println(line);
        System.out.println(wby);
    }

    @Test
    public void testSelectById(){
        User user = userMapper.selectById(1L);
        System.out.println(user);
    }

    /**
     * 并发问题
     * 1.多线程操作统一数据，造成的安全问题
     * 2.redis秒杀，多个并发请求导致库存为负数
     *
     * mp支持表中指定乐观锁的字段，更新数据时会自动检测版本号是否一致
     */
    public void testConCurrentUpdate(){
        //两个人同时修改商品价格，user1+50，user2-30
        Product user1 = productMapper.selectById(1L);
        //修改价格并更新
        user1.setPrice(user1.getPrice()+50);
        productMapper.updateById(user1);

        Product user2 = productMapper.selectById(1L);
        //修改价格并更新
        user2.setPrice(user2.getPrice()-30);
        productMapper.updateById(user2);
        System.out.println("更新后的价格:  "+productMapper.selectById(1L).getPrice());
    }



}
