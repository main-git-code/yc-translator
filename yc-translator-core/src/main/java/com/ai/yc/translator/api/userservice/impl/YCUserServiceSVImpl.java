package com.ai.yc.translator.api.userservice.impl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.vo.ResponseHeader;
import com.ai.opt.sdk.util.BeanUtils;
import com.ai.yc.translator.api.userservice.interfaces.IYCUserServiceSV;
import com.ai.yc.translator.api.userservice.param.SearchYCTranslatorRequest;
import com.ai.yc.translator.api.userservice.param.SearchYCTranslatorSkillListRequest;
import com.ai.yc.translator.api.userservice.param.YCLSPInfoReponse;
import com.ai.yc.translator.api.userservice.param.YCTranslatorInfoResponse;
import com.ai.yc.translator.api.userservice.param.YCTranslatorSkillListResponse;
import com.ai.yc.translator.api.userservice.param.searchYCLSPInfoRequest;
import com.ai.yc.translator.constants.ExceptCodeConstants;
import com.ai.yc.translator.dao.mapper.bo.UsrTranslator;
import com.ai.yc.translator.service.business.interfaces.IYCUserServiceBusiSV;
import com.alibaba.dubbo.config.annotation.Service;

@Service(validation = "true")
@Component
public class YCUserServiceSVImpl implements IYCUserServiceSV {

	private static final Logger LOGGER = LoggerFactory.getLogger(YCUserServiceSVImpl.class);
    @Autowired
    public IYCUserServiceBusiSV ycUsrServiceBusiSv;

	
	

	@Override
	public YCTranslatorInfoResponse searchYCTranslatorInfo(SearchYCTranslatorRequest tUsrId) {
		ResponseHeader responseHeader = null;
		UsrTranslator usrTranslator = null;
		YCTranslatorInfoResponse result = new YCTranslatorInfoResponse();
		try{
			
			usrTranslator = ycUsrServiceBusiSv.searchYCUsrTranslatorInfo(tUsrId);
			responseHeader = new ResponseHeader(true,ExceptCodeConstants.SUCCESS,"查询成功");
			if (null != usrTranslator){
				BeanUtils.copyProperties(result, usrTranslator);
			}
			result.setResponseCode(ExceptCodeConstants.SUCCESS);
		}catch(BusinessException e){
			LOGGER.error("修改失败",e);
			responseHeader = new ResponseHeader(false,ExceptCodeConstants.FAILD,e.getErrorMessage());
		}
		
		result.setResponseHeader(responseHeader);
		return result;
	}
	

	@Override
	public YCTranslatorSkillListResponse getTranslatorSkillList(SearchYCTranslatorSkillListRequest getSkillList) {
		ResponseHeader responseHeader = new ResponseHeader(true, ExceptCodeConstants.SUCCESS, "更新成功");
		YCTranslatorSkillListResponse result = new YCTranslatorSkillListResponse();
		try{
			result = ycUsrServiceBusiSv.getTranslatorSkillList(getSkillList.getUserId());
			responseHeader = new ResponseHeader(true, ExceptCodeConstants.SUCCESS, "查询成功");
		}catch(Exception e){
			responseHeader = new ResponseHeader(false, ExceptCodeConstants.SUCCESS, e.getMessage());
		}
		result.setResponseHeader(responseHeader);
		return result;
	}

	@Override
	public YCLSPInfoReponse searchLSPInfo(searchYCLSPInfoRequest searchLSPParams) {
		ResponseHeader responseHeader = new ResponseHeader(true, ExceptCodeConstants.SUCCESS, "更新成功");
		YCLSPInfoReponse result = new YCLSPInfoReponse();
		try{
			result = ycUsrServiceBusiSv.searchLSPInfoBussiness(searchLSPParams);
			responseHeader = new ResponseHeader(true, ExceptCodeConstants.SUCCESS, "查询成功");
		}catch(Exception e){
			responseHeader = new ResponseHeader(false, ExceptCodeConstants.SUCCESS, e.getMessage());
		}
		result.setResponseHeader(responseHeader);
		return result;
	}

}