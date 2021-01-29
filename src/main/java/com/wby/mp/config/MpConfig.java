package com.wby.mp.config;

import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import org.springframework.context.annotation.Bean;

/**
 * 提供乐观锁配置类,用来检测版本号
 * 检测版本号方式：
 *  查询数据时，会一起查询数据的版本号；
 *  更新数据时，会判断版本号：
 *  update product set k=v,version=查询版本号+1 where id=x and version=查询是的版本号
 */
public class MpConfig {
    @Bean
    public OptimisticLockerInterceptor optimisticLockerInterceptor(){
        return new OptimisticLockerInterceptor();
    }
}
