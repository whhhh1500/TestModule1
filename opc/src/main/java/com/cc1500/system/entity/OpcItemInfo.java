package com.cc1500.system.entity;
import java.io.Serializable;

/**
 * (OpcItemInfo)实体类
 *
 * @author makejava
 * @since 2019-11-12 08:52:21
 */
public class OpcItemInfo implements Serializable {
    private static final long serialVersionUID = 921922664817909438L;
    
    private Integer id;
    
    private String itemId;
    
    private String itemDescription;
    
    private String tagAddress;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public String getTagAddress() {
        return tagAddress;
    }

    public void setTagAddress(String tagAddress) {
        this.tagAddress = tagAddress;
    }

    @Override
    public String toString() {
        return "OpcItemInfo{" +
                "id=" + id +
                ", itemId='" + itemId + '\'' +
                ", itemDescription='" + itemDescription + '\'' +
                ", tagAddress='" + tagAddress + '\'' +
                '}';
    }
}