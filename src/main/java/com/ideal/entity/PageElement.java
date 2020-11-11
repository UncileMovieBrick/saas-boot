package com.ideal.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 页面元素表
 * </p>
 *
 * @author gongsong
 * @since 2020-11-10
 */
@TableName("t_page_element")
public class PageElement extends Model<PageElement> {

    private static final long serialVersionUID=1L;

    /**
     * 页面元素ID
     */
    @TableId(value = "page_element_id", type = IdType.AUTO)
    private String pageElementId;

    /**
     * 租户ID
     */
    private String tenantId;

    /**
     * 页面元素名称
     */
    private String pageElementName;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 创建人
     */
    private String createStaff;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;

    /**
     * 修改人
     */
    private String updateStaff;

    /**
     * 数据状态（0：有效，1：无效）
     */
    private Integer statusCd;


    public String getPageElementId() {
        return pageElementId;
    }

    public void setPageElementId(String pageElementId) {
        this.pageElementId = pageElementId;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getPageElementName() {
        return pageElementName;
    }

    public void setPageElementName(String pageElementName) {
        this.pageElementName = pageElementName;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public String getCreateStaff() {
        return createStaff;
    }

    public void setCreateStaff(String createStaff) {
        this.createStaff = createStaff;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateStaff() {
        return updateStaff;
    }

    public void setUpdateStaff(String updateStaff) {
        this.updateStaff = updateStaff;
    }

    public Integer getStatusCd() {
        return statusCd;
    }

    public void setStatusCd(Integer statusCd) {
        this.statusCd = statusCd;
    }

    @Override
    protected Serializable pkVal() {
        return this.pageElementId;
    }

    @Override
    public String toString() {
        return "PageElement{" +
        "pageElementId=" + pageElementId +
        ", tenantId=" + tenantId +
        ", pageElementName=" + pageElementName +
        ", createTime=" + createTime +
        ", createStaff=" + createStaff +
        ", updateTime=" + updateTime +
        ", updateStaff=" + updateStaff +
        ", statusCd=" + statusCd +
        "}";
    }
}
