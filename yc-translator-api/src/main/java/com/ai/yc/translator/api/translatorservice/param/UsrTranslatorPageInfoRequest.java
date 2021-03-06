package com.ai.yc.translator.api.translatorservice.param;

import java.io.Serializable;
import java.sql.Timestamp;

import com.ai.opt.base.vo.PageInfo;

/**
 * 译员列表查询请求参数
 * @author hexf3
 *
 */
public class UsrTranslatorPageInfoRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    /**
     * 昵称
     */
    String nickname;
    /**
     * 姓名
     */
    String firstname;
    /**
     * 手机
     */
    String mobilePhone;

    /**
     * 母语
     */
    String motherTongue;
    /**
     * 申请来源
     */
    String userSource;
    /**
     * 1 领域   2 用途
     * 
     */
    String extendType;
    /**
     * 语种方向
     */
    String langire;
    
    /**
     * 当前第几页,必填
     */
    private Integer pageNo;

    /**
     * 每页数据条数,必填
     */
    private Integer pageSize;
    
    /**
     * 状态
     */
    private Integer state;

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getMotherTongue() {
		return motherTongue;
	}

	public void setMotherTongue(String motherTongue) {
		this.motherTongue = motherTongue;
	}

	public String getUserSource() {
		return userSource;
	}

	public void setUserSource(String userSource) {
		this.userSource = userSource;
	}

	public String getExtendType() {
		return extendType;
	}

	public void setExtendType(String extendType) {
		this.extendType = extendType;
	}

	public String getLangire() {
		return langire;
	}

	public void setLangire(String langire) {
		this.langire = langire;
	}

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

    
 
}
