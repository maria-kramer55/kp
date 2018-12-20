package Entity;

import java.io.Serializable;

public class Material implements Serializable {
    public int materialId;
    public String materialType;
    public String materialName;
    public int materialPrice;

    public Material() {
    }

    public Material(int materialId, String materialType, String materialName, int materialPrice) {
        this.materialId = materialId;
        this.materialType = materialType;
        this.materialName = materialName;
        this.materialPrice = materialPrice;
    }

    public int getMaterialId() {
        return materialId;
    }

    public void setMaterialId(int materialId) {
        this.materialId = materialId;
    }

    public String getMaterialType() {
        return materialType;
    }

    public void setMaterialType(String materialType) {
        this.materialType = materialType;
    }

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }

    public int getMaterialPrice() {
        return materialPrice;
    }

    public void setMaterialPrice(int materialPrice) {
        this.materialPrice = materialPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Material material = (Material) o;

        if (getMaterialId() != material.getMaterialId()) return false;
        if (getMaterialPrice() != material.getMaterialPrice()) return false;
        if (getMaterialType() != null ? !getMaterialType().equals(material.getMaterialType()) : material.getMaterialType() != null)
            return false;
        return getMaterialName() != null ? getMaterialName().equals(material.getMaterialName()) : material.getMaterialName() == null;
    }

    @Override
    public int hashCode() {
        int result = getMaterialId();
        result = 31 * result + (getMaterialType() != null ? getMaterialType().hashCode() : 0);
        result = 31 * result + (getMaterialName() != null ? getMaterialName().hashCode() : 0);
        result = 31 * result + getMaterialPrice();
        return result;
    }

    @Override
    public String toString() {
        return "Material{" +
                "materialId=" + materialId +
                ", materialType='" + materialType + '\'' +
                ", materialName='" + materialName + '\'' +
                ", materialPrice=" + materialPrice +
                '}';
    }
}
