package com.example.worksystem.domain

import com.baomidou.mybatisplus.annotation.FieldFill
import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableId
import com.baomidou.mybatisplus.annotation.TableName

@TableName("storagetoken")
class Token(
        @TableId
        var id: Int? = null,
        var accesstoken: String? = null,
//        @TableField(fill=FieldFill.UPDATE)
        var begintime: Long? = null
)