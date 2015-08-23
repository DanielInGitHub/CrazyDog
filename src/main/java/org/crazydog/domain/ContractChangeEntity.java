package org.crazydog.domain;

import javax.persistence.*;

/**
 * Created by never on 2015/8/23.
 */
@Entity
@Table(name = "contract_change", schema = "", catalog = "crazydog")
public class ContractChangeEntity {
    private Integer id;
    private Integer contractId;
    private Integer unitId;
    private Integer deptId;
    private String position;
    private String changeCause;
    private Integer renewTime;
    private String comment;
    private ContractEntity contractByContractId;
    private UnitEntity unitByUnitId;
    private DepartmentEntity departmentByDeptId;

    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "contract_id", nullable = true, insertable = true, updatable = true)
    public Integer getContractId() {
        return contractId;
    }

    public void setContractId(Integer contractId) {
        this.contractId = contractId;
    }

    @Basic
    @Column(name = "unit_id", nullable = true, insertable = true, updatable = true)
    public Integer getUnitId() {
        return unitId;
    }

    public void setUnitId(Integer unitId) {
        this.unitId = unitId;
    }

    @Basic
    @Column(name = "dept_id", nullable = true, insertable = true, updatable = true)
    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    @Basic
    @Column(name = "position", nullable = false, insertable = true, updatable = true, length = 20)
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Basic
    @Column(name = "change_cause", nullable = false, insertable = true, updatable = true, length = 100)
    public String getChangeCause() {
        return changeCause;
    }

    public void setChangeCause(String changeCause) {
        this.changeCause = changeCause;
    }

    @Basic
    @Column(name = "renew_time", nullable = false, insertable = true, updatable = true)
    public Integer getRenewTime() {
        return renewTime;
    }

    public void setRenewTime(Integer renewTime) {
        this.renewTime = renewTime;
    }

    @Basic
    @Column(name = "comment", nullable = true, insertable = true, updatable = true, length = 255)
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContractChangeEntity that = (ContractChangeEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (contractId != null ? !contractId.equals(that.contractId) : that.contractId != null) return false;
        if (unitId != null ? !unitId.equals(that.unitId) : that.unitId != null) return false;
        if (deptId != null ? !deptId.equals(that.deptId) : that.deptId != null) return false;
        if (position != null ? !position.equals(that.position) : that.position != null) return false;
        if (changeCause != null ? !changeCause.equals(that.changeCause) : that.changeCause != null) return false;
        if (renewTime != null ? !renewTime.equals(that.renewTime) : that.renewTime != null) return false;
        if (comment != null ? !comment.equals(that.comment) : that.comment != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (contractId != null ? contractId.hashCode() : 0);
        result = 31 * result + (unitId != null ? unitId.hashCode() : 0);
        result = 31 * result + (deptId != null ? deptId.hashCode() : 0);
        result = 31 * result + (position != null ? position.hashCode() : 0);
        result = 31 * result + (changeCause != null ? changeCause.hashCode() : 0);
        result = 31 * result + (renewTime != null ? renewTime.hashCode() : 0);
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "contract_id", referencedColumnName = "id")
    public ContractEntity getContractByContractId() {
        return contractByContractId;
    }

    public void setContractByContractId(ContractEntity contractByContractId) {
        this.contractByContractId = contractByContractId;
    }

    @ManyToOne
    @JoinColumn(name = "unit_id", referencedColumnName = "id")
    public UnitEntity getUnitByUnitId() {
        return unitByUnitId;
    }

    public void setUnitByUnitId(UnitEntity unitByUnitId) {
        this.unitByUnitId = unitByUnitId;
    }

    @ManyToOne
    @JoinColumn(name = "dept_id", referencedColumnName = "id")
    public DepartmentEntity getDepartmentByDeptId() {
        return departmentByDeptId;
    }

    public void setDepartmentByDeptId(DepartmentEntity departmentByDeptId) {
        this.departmentByDeptId = departmentByDeptId;
    }
}
