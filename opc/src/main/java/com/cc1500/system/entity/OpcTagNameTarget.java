package com.cc1500.system.entity;
import java.io.Serializable;

/**
 * (OpcTagNameTarget)实体类
 *
 * @author makejava
 * @since 2019-11-14 11:04:15
 */
public class OpcTagNameTarget implements Serializable {
    private static final long serialVersionUID = -44036318301359952L;
    
    private Integer targetId;
    //目标
    private String target;
    //中文别名
    private String targetAlias;
    
    private Integer isactive;


    public Integer getTargetId() {
        return targetId;
    }

    public void setTargetId(Integer targetId) {
        this.targetId = targetId;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getTargetAlias() {
        return targetAlias;
    }

    public void setTargetAlias(String targetAlias) {
        this.targetAlias = targetAlias;
    }

    public Integer getIsactive() {
        return isactive;
    }

    public void setIsactive(Integer isactive) {
        this.isactive = isactive;
    }

}