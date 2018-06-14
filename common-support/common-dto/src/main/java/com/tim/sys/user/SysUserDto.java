package com.tim.sys.user;

import java.util.Date;

/**
 * <p>
 *  系统用户数据传输对象
 * </p>
 *
 * @author lizhiming
 * @since 2018-04-19
 */
public class SysUserDto {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
	private Long id;
    /**
     * 机构ID
     */
	private Long organizationId;
    /**
     * 用户名
     */
	private String username;
    /**
     * 真实姓名
     */
	private String realName;
    /**
     * 密码
     */
	private String password;
    /**
     * 盐
     */
	private String salt;
    /**
     * 角色列表
     */
	private String roleIds;
    /**
     * 账户是否锁定
     */
	private Integer locked;
	private String email;
	private String phone;
    /**
     * 更新时间
     */
	private Date updateTime;
    /**
     * 是否删除
     */
	private Integer isDeleted;
    /**
     * 合作方主键
     */
	private Long partnerId;
    /**
     * 上次修改密码时间
     */
	private Date updPwdTime;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Long organizationId) {
		this.organizationId = organizationId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(String roleIds) {
		this.roleIds = roleIds;
	}

	public Integer getLocked() {
		return locked;
	}

	public void setLocked(Integer locked) {
		this.locked = locked;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Integer isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Long getPartnerId() {
		return partnerId;
	}

	public void setPartnerId(Long partnerId) {
		this.partnerId = partnerId;
	}

	public Date getUpdPwdTime() {
		return updPwdTime;
	}

	public void setUpdPwdTime(Date updPwdTime) {
		this.updPwdTime = updPwdTime;
	}

	@Override
	public String toString() {
		return "SysUser{" +
			", id=" + id +
			", organizationId=" + organizationId +
			", username=" + username +
			", realName=" + realName +
			", password=" + password +
			", salt=" + salt +
			", roleIds=" + roleIds +
			", locked=" + locked +
			", email=" + email +
			", phone=" + phone +
			", updateTime=" + updateTime +
			", isDeleted=" + isDeleted +
			", partnerId=" + partnerId +
			", updPwdTime=" + updPwdTime +
			"}";
	}
}
