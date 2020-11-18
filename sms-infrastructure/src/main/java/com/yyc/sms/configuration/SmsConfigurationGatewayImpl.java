package com.yyc.sms.configuration;

import cn.hutool.cache.CacheUtil;
import cn.hutool.cache.impl.FIFOCache;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yyc.sms.domain.sms.gateway.SmsConfigurationGateway;
import com.yyc.sms.domain.util.CollectionCopyUtil;
import com.yyc.sms.dto.SmsConfigurationQry;
import com.yyc.sms.dto.data.SmsConfigurationDTO;
import lombok.NonNull;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yuchengyao
 */
@Component
public class SmsConfigurationGatewayImpl implements SmsConfigurationGateway {

    @Resource
    private SmsConfigurationMapper smsConfigurationMapper;

    /**
     * 短信配置缓存
     */
    private static FIFOCache<String, SmsConfigurationDTO> smsConfigurationCache = CacheUtil.newFIFOCache(1024);

    /**
     * 标记 smsConfigurationCache 是否需要更新
     */
    private static boolean updateFlag = true;

    @Override
    public boolean checkInitialization() {
        return updateFlag;
    }

    @Override
    public List<SmsConfigurationDTO> getSmsConfiguration() {
        return getSmsConfiguration(SmsConfigurationQry.builder().build());
    }

    @Override
    public List<SmsConfigurationDTO> getSmsConfiguration(@NonNull SmsConfigurationQry smsConfigurationQry) {

        if (updateFlag) {
            initConfiguration();
        }

        SmsConfigurationDTO qry = new SmsConfigurationDTO();
        BeanUtils.copyProperties(smsConfigurationQry, qry);

        List<SmsConfigurationDTO> result = new ArrayList<>();

        smsConfigurationCache.forEach(value -> {
            result.add(value);
        });

        return result.stream().filter(value -> value.filter(qry)).collect(Collectors.toList());
    }

    /**
     * 初始化
     */
    private void initConfiguration() {

        smsConfigurationCache.clear();

        getDBSmsConfiguration().forEach((value) -> {
            smsConfigurationCache.put(value.getAccessKey(), value);
        });

        changeUpdateFlag();
    }

    private List<SmsConfigurationDTO> getDBSmsConfiguration() {

        QueryWrapper<SmsConfigurationDO> queryWrapper = new QueryWrapper<>();

        List<SmsConfigurationDO> smsConfigurationDOS = smsConfigurationMapper.selectList(queryWrapper);

        return CollectionCopyUtil.copyList(smsConfigurationDOS, SmsConfigurationDTO.class);
    }

    private void changeUpdateFlag() {
        updateFlag = !updateFlag;
    }


}
