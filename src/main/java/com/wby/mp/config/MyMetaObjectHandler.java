package com.wby.mp.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 自动填充处理类
 */
@Slf4j
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    //insert操作时，数据标注了file方式为insert，该方法会自动回调
    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("start insert fill ....");
        /*this.setFieldValByName("gmtCreate", new Date(), metaObject);
        this.setFieldValByName("gmtModified", new Date(), metaObject);*/
        metaObject.setValue("gmtCreate", new Date());
        metaObject.setValue("gmtModified", new Date());
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("start update fill ....");
        /*this.setFieldValByName("gmtModified", new Date(), metaObject);*/
        metaObject.setValue("gmtModified", new Date());
    }
}
