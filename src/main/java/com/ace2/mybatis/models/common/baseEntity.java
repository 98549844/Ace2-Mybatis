package com.ace2.mybatis.models.common;

//import com.baomidou.mybatisplus.annotation.FieldFill;
//import com.baomidou.mybatisplus.annotation.TableField;
//import com.baomidou.mybatisplus.annotation.Version;
import java.time.LocalDateTime;


/**
 * @Classname: baseEntity
 * @Date: 5/5/2021 12:22 上午
 * @Author: garlam
 * @Description:
 */


public class baseEntity {

/*    @TableField(value = "createdDate", fill = FieldFill.INSERT)
    private LocalDateTime createdDate;

    @TableField(value = "lastUpdateDate", fill = FieldFill.UPDATE)
    private LocalDateTime lastUpdateDate;

    @TableField(value = "createdBy", fill = FieldFill.INSERT)
    private Long createdBy = 0l;

    @TableField(value = "lastUpdatedBy", fill = FieldFill.UPDATE)
    private Long lastUpdatedBy = 0l;

    @Version
//    @TableField(value = "version", fill = FieldFill.INSERT_UPDATE)
    private Integer version = 1;*/

//    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime createdDate;

//    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime lastUpdateDate;

//    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Long createdBy;

//    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Long lastUpdatedBy;

//    @Version
//    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Integer version = 1;


    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDateTime getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(LocalDateTime lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Long getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(Long lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        if (version == null || version == 0) {
            version = 1;
        }
        this.version = version;
    }
}

