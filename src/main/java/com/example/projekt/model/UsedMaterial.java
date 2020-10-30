package com.example.projekt.model;


import javax.persistence.*;

@Entity
@Table(name = "zuzyte_materialy")
public class UsedMaterial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_zuzytego_materialu")
    private int usedMaterialId;

    @Column(name = "ilosc")
    private float quantity;

    @ManyToOne
    @JoinColumn(name = "materialy_id_materialu")
    private Material material;

    @ManyToOne
    @JoinColumn(name = "raport_dzienny_brygady_id_raport_dzienny_brygady")
    private DailyWorkReport dailyWorkReport;

    public int getUsedMaterialId() {
        return usedMaterialId;
    }

    public void setUsedMaterialId(int usedMaterialId) {
        this.usedMaterialId = usedMaterialId;
    }

    public float getQuantity() {
        return quantity;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }
}
