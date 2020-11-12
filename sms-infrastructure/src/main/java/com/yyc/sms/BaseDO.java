package com.yyc.sms;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

/**
 * BaseDO
 * 数据基础类,提供默认字段：
 * <br/>id  主键
 * <br/>createBy    创建人
 * <br/>updateBy    更新人
 * <br/>createTime  创建时间
 * <br/>updateTime  更新时间
 *
 * @author 10916
 */
@Data
public class BaseDO {

    @TableId(value = "id", type = IdType.ASSIGN_UUID)
    private String id;

    @TableField(value = "status")
    private String status;

    @TableField(value = "create_by", fill = FieldFill.INSERT)
    private String createBy;

    @TableField(value = "update_by", fill = FieldFill.UPDATE)
    private String updateBy;

    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(value = "update_time", fill = FieldFill.UPDATE)
    private Date updateTime;

}
