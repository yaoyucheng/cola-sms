package com.yyc.sms.sms;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yyc.sms.domain.sms.entity.Sms;
import com.yyc.sms.domain.sms.gateway.SmsGateway;
import com.yyc.sms.dto.data.SmsDTO;
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
    public List<SmsDTO> getSmsByOutIdsExe(String... outIds) {

        QueryWrapper<SmsDO> wrapper = new QueryWrapper<>();

//        wrapper.ge("",)
//        Wrapper<SmsDO> wrapper =
//        return smsMapper.selectList(null);
        return null;
    }
}
