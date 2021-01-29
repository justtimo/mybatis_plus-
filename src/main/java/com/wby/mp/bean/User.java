package com.wby.mp.bean;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.File;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String name;
    private Integer age;
    private String email;

    @TableField(value = "gmt_create",fill = FieldFill.INSERT)
    private Date gmtCreate;
    @TableField(value = "gmt_modified",fill = FieldFill.INSERT_UPDATE)
    private Date gmtModified;

    @TableField(value = "id_deleted")
    @TableLogic//表示当前字段为逻辑删除，0镖师未删除
    private  Integer deleted;
}
