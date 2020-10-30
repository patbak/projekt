package com.example.projekt.model;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "materialy")
public class Material {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_materialu")
    private int materialId;

    @Column(name = "nazwa")
    private String materialName;

    @Column(name = "jednostka")
    private String materialUnit;

    @OneToMany
    private List<UsedMaterial> usedMaterials;

    public List<UsedMaterial> getUsedMaterials() {
        return usedMaterials;
    }

    public void setUsedMaterials(List<UsedMaterial> usedMaterials) {
        this.usedMaterials = usedMaterials;
    }

    public int getMaterialId() {
        return materialId;
    }

    public void setMaterialId(int materialId) {
        this.materialId = materialId;
    }

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }

    public String getMaterialUnit() {
        return materialUnit;
    }

    public void setMaterialUnit(String materialUnit) {
        this.materialUnit = materialUnit;
    }
}
