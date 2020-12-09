package com.yyc.sms.sms;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.yyc.sms.domain.sms.entity.Sms;
import com.yyc.sms.domain.sms.gateway.SmsGateway;
import com.yyc.sms.domain.util.CollectionCopyUtil;
import com.yyc.sms.dto.data.SmsDTO;
import com.yyc.sms.dto.qry.SmsQry;
import lombok.NonNull;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 10916
 */
@Component
public class SmsGatewayImpl implements SmsGateway {

    @Resource
    private SmsMapper smsMapper;

    @Override
    public void insert(Sms sms) {

        SmsDO smsDO = new SmsDO();

        BeanUtils.copyProperties(sms, smsDO);

        smsMapper.insert(smsDO);

    }

    @Override
    public void update(@NonNull String identifies, @NonNull Sms sms) {

        SmsDO smsDO = new SmsDO();

        BeanUtils.copyProperties(sms, smsDO);

        UpdateWrapper<SmsDO> smsDOUpdateWrapper = new UpdateWrapper<>();

        //  更具smsUpExtendCode 字段更新值
        smsDOUpdateWrapper
                .eq("sms_identifies", identifies);

        smsMapper.update(smsDO, smsDOUpdateWrapper);
    }

    @Override
    public List<SmsDTO> list(@NonNull SmsQry smsQry) {

        //  查询
        Wrapper<SmsDO> wrapper = new QueryWrapper<SmsDO>()
                .eq(smsQry.getSmsUpExtendCode() != null, "sms_up_extend_code", smsQry.getSmsUpExtendCode())
                .eq(smsQry.getIdentifies() != null, "sms_identifies", smsQry.getIdentifies())
                .like(smsQry.getPhoneNumber() != null, "sms_phone_number_json", smsQry.getPhoneNumber())
                .in(smsQry.getIdentifiesList() != null, "sms_identifies", smsQry.getIdentifiesList())
                .orderByDesc("create_time");

        List<SmsDO> smsDOS = smsMapper.selectList(wrapper);

        return CollectionCopyUtil.copyList(smsDOS, SmsDTO.class);
    }

}
