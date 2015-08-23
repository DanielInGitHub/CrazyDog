package org.crazydog.domain;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by never on 2015/8/23.
 */
@Entity
@Table(name = "department", schema = "", catalog = "crazydog")
public class DepartmentEntity {
    private Integer id;
    private String deptName;
    private Integer unitId;
    private Collection<ContractChangeEntity> contractChangesById;
    private UnitEntity unitByUnitId;
    private Collection<EmployeeEntity> employeesById;

    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "dept_name", nullable = false, insertable = true, updatable = true, length = 255)
    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    @Basic
    @Column(name = "unit_id", nullable = false, insertable = true, updatable = true)
    public Integer getUnitId() {
        return unitId;
    }

    public void setUnitId(Integer unitId) {
        this.unitId = unitId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DepartmentEntity that = (DepartmentEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (deptName != null ? !deptName.equals(that.deptName) : that.deptName != null) return false;
        if (unitId != null ? !unitId.equals(that.unitId) : that.unitId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (deptName != null ? deptName.hashCode() : 0);
        result = 31 * result + (unitId != null ? unitId.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "departmentByDeptId")
    public Collection<ContractChangeEntity> getContractChangesById() {
        return contractChangesById;
    }

    public void setContractChangesById(Collection<ContractChangeEntity> contractChangesById) {
        this.contractChangesById = contractChangesById;
    }

    @ManyToOne
    @JoinColumn(name = "unit_id", referencedColumnName = "id", nullable = false)
    public UnitEntity getUnitByUnitId() {
        return unitByUnitId;
    }

    public void setUnitByUnitId(UnitEntity unitByUnitId) {
        this.unitByUnitId = unitByUnitId;
    }

    @OneToMany(mappedBy = "departmentByDepId")
    public Collection<EmployeeEntity> getEmployeesById() {
        return employeesById;
    }

    public void setEmployeesById(Collection<EmployeeEntity> employeesById) {
        this.employeesById = employeesById;
    }
}
