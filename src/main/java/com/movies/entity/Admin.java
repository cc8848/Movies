
package com.movies.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Entity - 管理员
 * 
 * @author SHOP++ Team
 * @version 4.0
 */
@Entity
@Table(name = "xx_admin")
@SequenceGenerator(name = "sequenceGenerator", sequenceName = "seq_admin")
public class Admin extends BaseEntity<Long> {

	private static final long serialVersionUID = -7476641525390360827L;

	/** "登录令牌"Cookie名称 */
	public static final String LOGIN_TOKEN_COOKIE_NAME = "adminLoginToken";

	/** 用户名 */
	private String username;

	/** 密码 */
	private String password;

	/** E-mail */
	private String email;

	/** 姓名 */
	private String name;

	/** 部门 */
	private String department;

	/** 是否启用 */
	private Boolean isEnabled;

	/** 是否锁定 */
	private Boolean isLocked;

	/** 连续登录失败次数 */
	private Integer loginFailureCount;

	/** 锁定日期 */
	private Date lockedDate;

	/** 最后登录日期 */
	private Date loginDate;

	/** 最后登录IP */
	private String loginIp;

	/** 锁定KEY */
	private String lockKey;

	/** 角色 */
	private Set<Role> roles = new HashSet<Role>();

	/**
	 * 获取用户名
	 * 
	 * @return 用户名
	 */
	@NotEmpty(groups = Save.class)
	@Pattern(regexp = "^[0-9a-zA-Z_\\u4e00-\\u9fa5]+$")
	@Length(min = 2, max = 20)
	@Column(nullable = false, updatable = false, unique = true)
	public String getUsername() {
		return username;
	}

	/**
	 * 设置用户名
	 * 
	 * @param username
	 *            用户名
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * 获取密码
	 * 
	 * @return 密码
	 */
	@NotEmpty(groups = Save.class)
	@Length(min = 4, max = 20)
	@Column(nullable = false)
	public String getPassword() {
		return password;
	}

	/**
	 * 设置密码
	 * 
	 * @param password
	 *            密码
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * 获取E-mail
	 * 
	 * @return E-mail
	 */
	@NotEmpty
	@Email
	@Length(max = 200)
	@Column(nullable = false)
	public String getEmail() {
		return email;
	}

	/**
	 * 设置E-mail
	 * 
	 * @param email
	 *            E-mail
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * 获取姓名
	 * 
	 * @return 姓名
	 */
	@Length(max = 200)
	public String getName() {
		return name;
	}

	/**
	 * 设置姓名
	 * 
	 * @param name
	 *            姓名
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 获取部门
	 * 
	 * @return 部门
	 */
	@Length(max = 200)
	public String getDepartment() {
		return department;
	}

	/**
	 * 设置部门
	 * 
	 * @param department
	 *            部门
	 */
	public void setDepartment(String department) {
		this.department = department;
	}

	/**
	 * 获取是否启用
	 * 
	 * @return 是否启用
	 */
	@NotNull
	@Column(nullable = false)
	public Boolean getIsEnabled() {
		return isEnabled;
	}

	/**
	 * 设置是否启用
	 * 
	 * @param isEnabled
	 *            是否启用
	 */
	public void setIsEnabled(Boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	/**
	 * 获取是否锁定
	 * 
	 * @return 是否锁定
	 */
	@Column(nullable = false)
	public Boolean getIsLocked() {
		return isLocked;
	}

	/**
	 * 设置是否锁定
	 * 
	 * @param isLocked
	 *            是否锁定
	 */
	public void setIsLocked(Boolean isLocked) {
		this.isLocked = isLocked;
	}

	/**
	 * 获取连续登录失败次数
	 * 
	 * @return 连续登录失败次数
	 */
	@Column(nullable = false)
	public Integer getLoginFailureCount() {
		return loginFailureCount;
	}

	/**
	 * 设置连续登录失败次数
	 * 
	 * @param loginFailureCount
	 *            连续登录失败次数
	 */
	public void setLoginFailureCount(Integer loginFailureCount) {
		this.loginFailureCount = loginFailureCount;
	}

	/**
	 * 获取锁定日期
	 * 
	 * @return 锁定日期
	 */
	public Date getLockedDate() {
		return lockedDate;
	}

	/**
	 * 设置锁定日期
	 * 
	 * @param lockedDate
	 *            锁定日期
	 */
	public void setLockedDate(Date lockedDate) {
		this.lockedDate = lockedDate;
	}

	/**
	 * 获取最后登录日期
	 * 
	 * @return 最后登录日期
	 */
	public Date getLoginDate() {
		return loginDate;
	}

	/**
	 * 设置最后登录日期
	 * 
	 * @param loginDate
	 *            最后登录日期
	 */
	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}

	/**
	 * 获取最后登录IP
	 * 
	 * @return 最后登录IP
	 */
	public String getLoginIp() {
		return loginIp;
	}

	/**
	 * 设置最后登录IP
	 * 
	 * @param loginIp
	 *            最后登录IP
	 */
	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}

	/**
	 * 获取锁定KEY
	 * 
	 * @return 锁定KEY
	 */
	@Column(nullable = false, updatable = false)
	public String getLockKey() {
		return lockKey;
	}

	/**
	 * 设置锁定KEY
	 * 
	 * @param lockKey
	 *            锁定KEY
	 */
	public void setLockKey(String lockKey) {
		this.lockKey = lockKey;
	}

	/**
	 * 获取角色
	 * 
	 * @return 角色
	 */
	@NotEmpty
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "xx_admin_role")
	public Set<Role> getRoles() {
		return roles;
	}

	/**
	 * 设置角色
	 * 
	 * @param roles
	 *            角色
	 */
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	/**
	 * 持久化前处理
	 */
	@PrePersist
	public void prePersist() {
		setUsername(StringUtils.lowerCase(getUsername()));
		setEmail(StringUtils.lowerCase(getEmail()));
		setLockKey(DigestUtils.md5Hex(UUID.randomUUID() + RandomStringUtils.randomAlphabetic(30)));
	}

	/**
	 * 更新前处理
	 */
	@PreUpdate
	public void preUpdate() {
		setEmail(StringUtils.lowerCase(getEmail()));
	}

}
