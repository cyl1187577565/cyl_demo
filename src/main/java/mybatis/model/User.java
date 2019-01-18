package mybatis.model;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class User implements Serializable {
	
    private Long id;

    private Long orgId;

    private Long groupId;

    private String phone;

    private String userName;

    private String realName;

    private String password;

    private Integer caseNum;

    private String productList;

    private String defaultProduct;

    private Integer useStatus;

    private Integer deleteStatus;

    private Long updateBy;

    private Date updateTime;

    private Long createBy;

    private Date createTime;

    private String remark;

    private String affix1;

    private String affix2;

    private String affix3;

    private List<Long> roleIds;

    private String roleName;
    
    private String signStatus;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public Integer getCaseNum() {
        return caseNum;
    }

    public void setCaseNum(Integer caseNum) {
        this.caseNum = caseNum;
    }

    public String getProductList() {
        return productList;
    }

    public void setProductList(String productList) {
        this.productList = productList;
    }

    public String getDefaultProduct() {
        return defaultProduct;
    }

    public void setDefaultProduct(String defaultProduct) {
        this.defaultProduct = defaultProduct;
    }

    public Integer getUseStatus() {
        return useStatus;
    }

    public void setUseStatus(Integer useStatus) {
        this.useStatus = useStatus;
    }

    public Integer getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(Integer deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    public Long getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Long updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getAffix1() {
        return affix1;
    }

    public void setAffix1(String affix1) {
        this.affix1 = affix1;
    }

    public String getAffix2() {
        return affix2;
    }

    public void setAffix2(String affix2) {
        this.affix2 = affix2;
    }

    public String getAffix3() {
        return affix3;
    }

    public void setAffix3(String affix3) {
        this.affix3 = affix3;
    }

    public List<Long> getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(List<Long> roleIds) {
        this.roleIds = roleIds;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

	
	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}
    
}