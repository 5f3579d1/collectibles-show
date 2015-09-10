package org.example.myproject.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by k on 9/10/15.
 */
@MappedSuperclass
public class BaseModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;

    @Temporal(TemporalType.TIMESTAMP)
    private Date modifyTime;

    @Transient
    @JsonIgnore
    private boolean updateModifyTime = true;

    @PrePersist
    protected void preCreate() {
        modifyTime = createTime = new Date();
    }

    @PreUpdate
    protected void preUpdate() {
        if (updateModifyTime)
            modifyTime = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public boolean isUpdateModifyTime() {
        return updateModifyTime;
    }

    public void setUpdateModifyTime(boolean updateModifyTime) {
        this.updateModifyTime = updateModifyTime;
    }

}
