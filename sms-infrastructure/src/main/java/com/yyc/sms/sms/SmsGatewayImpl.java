package com.yyc.sms.sms;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.yyc.sms.domain.sms.entity.Sms;
import com.yyc.sms.domain.sms.gateway.SmsGateway;
import com.yyc.sms.dto.data.SmsDTO;
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
    public List<SmsDTO> getSmsByOutIdsExe(String... smsUpExtendCodes) {

        QueryWrapper<SmsDO> wrapper = new QueryWrapper<>();


//        wrapper.ge("",)
//        Wrapper<SmsDO> wrapper =
//        return smsMapper.selectList(null);
        return null;
    }
}
