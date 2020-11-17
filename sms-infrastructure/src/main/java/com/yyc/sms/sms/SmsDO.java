package com.yyc.sms.sms;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.annotation.Unique;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import com.yyc.sms.BaseDO;
import lombok.Data;

/**
 * 短信数据库映射
 *
 * @author 10916
 */
@Data
@TableName(value = "sms")
@Table(name = "sms")
public class SmsDO extends BaseDO {

    /**
     * 入参----------------------------------------
     */

    /**
     * 接收短信的手机号码，JSON数组格式。
     * 实例：["15900000000","13500000000"]
     */
    @Column(name = "sms_phone_number_json", type = MySqlTypeConstant.VARCHAR, comment = "接收短信的手机号码，JSON数组格式")
    @TableField(value = "sms_phone_number_json")
    private String phoneNumberJson;

    /**
     * 短信模板变量对应的实际值，JSON格式。
     * 对应 templateCode 中的值
     */
    @Column(name = "sms_template_param", type = MySqlTypeConstant.VARCHAR, comment = "短信模板变量对应的实际值，JSON格式")
    @TableField(value = "sms_template_param")
    private String templateParam;

    /**
     * 流水字段
     */
    @Unique
    @Column(name = "sms_out_id", type = MySqlTypeConstant.VARCHAR, comment = "流水字段")
    @TableField(value = "sms_out_id")
    private String outId;

    /**
     * 上行短信扩展码，无特殊需要此字段的用户请忽略此字段。
     */
    @Column(name = "sms_up_extend_code", type = MySqlTypeConstant.VARCHAR, comment = "上行短信扩展码，无特殊需要此字段的用户请忽略此字段。")
    @TableField(value = "sms_up_extend_code")
    private String smsUpExtendCode;

    /**
     * sms-config----------------------------------------
     */

    /**
     * 短信签名名称
     * 实例：阿里云
     */
    @Column(name = "sms_sign_name", type = MySqlTypeConstant.VARCHAR, comment = "短信签名名称")
    @TableField(value = "sms_sign_name")
    private String signName;

    /**
     * 短信模板CODE。请在控制台模板管理页面模板CODE一列查看。
     * 实例：SMS_152550005
     */
    @Column(name = "sms_template_code", type = MySqlTypeConstant.VARCHAR, comment = "短信模板CODE。请在控制台模板管理页面模板CODE一列查看。")
    @TableField(value = "sms_template_code")
    private String templateCode;


    /**
     * 产品域名 domain  dysmsapi.aliyuncs.com
     */
    @Column(name = "sms_domain", type = MySqlTypeConstant.VARCHAR, comment = "产品域名")
    @TableField(value = "sms_domain")
    public String domain;

    /**
     * accessKey
     */
    @Column(name = "sms_access_key", type = MySqlTypeConstant.VARCHAR, comment = "accessKey")
    @TableField(value = "sms_access_key")
    private String accessKey;

    /**
     * sms-identifies-----------------------------------------
     */

    /**
     * 唯一标识
     */
    @Column(name = "sms_identifies", type = MySqlTypeConstant.VARCHAR, comment = "唯一标识")
    @TableField(value = "sms_identifies")
    private String identifies;
}
