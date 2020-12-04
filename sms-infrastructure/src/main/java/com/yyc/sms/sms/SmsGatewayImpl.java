package com.yyc.sms.sms;

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

        QueryWrapper<SmsDO> wrapper = new QueryWrapper<>();

        wrapper
                //  查询
                .eq("sms_up_extend_code", smsQry.getSmsUpExtendCode())
                .eq("identifies", smsQry.getIdentifies())
                .like("phone_number", smsQry.getPhoneNumber())
                .in("identifies", smsQry.getIdentifiesList())

                //  排序
                .orderByDesc("create_time");

        return CollectionCopyUtil.copyList(smsMapper.selectList(wrapper), SmsDTO.class);
    }

}
