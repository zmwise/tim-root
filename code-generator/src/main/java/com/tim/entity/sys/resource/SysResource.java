package com.tim.entity.sys.resource;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author lizhiming
 * @since 2018-06-06
 */
@TableName("sys_resource")
public class SysResource extends Model<SysResource> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
	@TableId(value="id", type= IdType.AUTO)
	private Long id;
    /**
     * 名称
     */
	private String name;
    /**
     * 类型
     */
	private String type;
    /**
     * 路劲
     */
	private String url;
    /**
     * 父编号
     */
	@TableField("parent_id")
	private Long parentId;
    /**
     * 父编号列表
     */
	@TableField("parent_ids")
	private String parentIds;
    /**
     * 权限字符串
     */
	private String permission;
    /**
     * 是否可用
     */
	private Integer available;
    /**
     * 更新时间
     */
	@TableField("update_time")
	private Date updateTime;
    /**
     * 是否删除
     */
	@TableField("is_deleted")
	private Integer isDeleted;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public String getParentIds() {
		return parentIds;
	}

	public void setParentIds(String parentIds) {
		this.parentIds = parentIds;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

	public Integer getAvailable() {
		return available;
	}

	public void setAvailable(Integer available) {
		this.available = available;
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

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "SysResource{" +
			", id=" + id +
			", name=" + name +
			", type=" + type +
			", url=" + url +
			", parentId=" + parentId +
			", parentIds=" + parentIds +
			", permission=" + permission +
			", available=" + available +
			", updateTime=" + updateTime +
			", isDeleted=" + isDeleted +
			"}";
	}
}
