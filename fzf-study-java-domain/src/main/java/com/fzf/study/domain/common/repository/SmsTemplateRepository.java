package com.fzf.study.domain.common.repository;


import com.fzf.study.domain.common.sms.SmsTemplate;
import com.github.pagehelper.PageInfo;

/**
 * @Author: cepheus
 * @CreateTime: 2020/10/18
 * @Version:
 * @Description:
 */


public interface SmsTemplateRepository {
    String querySmsTemplateContentBySmsId(Integer smsID);

    PageInfo<SmsTemplate> querySmsTemplateByName(String templateName, int pageIndex, int pageSize);

    SmsTemplate querySmsTemplateById(Integer smsID);

    int updateSmsTemplateById(SmsTemplate smsTemplate);

    int querySmsTemplateMaxId();

    int addSmsTemplate(SmsTemplate smsTempalte);
}
