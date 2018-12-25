package com.kkwrite.demo.provider.pojo;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class BaseDO implements Serializable {
    private static final long serialVersionUID = 1873175898346535201L;

    @Column(name = "is_deleted", nullable = false)
    private Integer deleted;

    @Column(name = "gmt_create", nullable = false, insertable = false, updatable = false)
    private Timestamp createTime;

    @Column(name = "creator", length = 20)
    private String creator;

    @Column(name = "gmt_modified", nullable = false, insertable = false, updatable = false)
    private Timestamp modifiedTime;

    @Column(name = "modifier", length = 20)
    private String modifier;

    @Column(name = "ext_0", length = 20)
    private String ext0;

    @Column(name = "ext_1", length = 20)
    private String ext1;

    @Column(name = "ext_2", length = 20)
    private String ext2;

	public Integer getDeleted() {
		return deleted;
	}

	public void setDeleted(Integer deleted) {
		this.deleted = deleted;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public Timestamp getModifiedTime() {
		return modifiedTime;
	}

	public void setModifiedTime(Timestamp modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

	public String getModifier() {
		return modifier;
	}

	public void setModifier(String modifier) {
		this.modifier = modifier;
	}

	public String getExt0() {
		return ext0;
	}

	public void setExt0(String ext0) {
		this.ext0 = ext0;
	}

	public String getExt1() {
		return ext1;
	}

	public void setExt1(String ext1) {
		this.ext1 = ext1;
	}

	public String getExt2() {
		return ext2;
	}

	public void setExt2(String ext2) {
		this.ext2 = ext2;
	}
    
}
