package Client;

import Entity.Material;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import Enum.ConnectInstance;
import java.util.ArrayList;

public class MaterialsPrcessing {

    public static ObservableList<Material> returnAllMaterials(){
        ArrayList<Material> list = ConnectInstance.INSTANCE.getInstance().receiveMaterialTable();
        ObservableList<Material> materials = FXCollections.observableArrayList(list);
        return materials;
    }

    public static ArrayList<String> materialByService(){
        ObservableList<Material> list = returnAllMaterials();
        ArrayList<String> materials = new ArrayList<>();
        for (Material material: list) {
            materials.add(material.getMaterialName());
        }
        return materials;
    }

}
