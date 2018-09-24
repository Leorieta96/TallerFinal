/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import MySQL.MySQLMaterialDAO;
import MySQL.MySQLProveedorDAO;
import java.util.ArrayList;
import java.util.List;
import modelo.Material;
import modelo.Proveedor;

/**
 *
 * @author leori
 */
public class Compra {

    class Rubro {

        String nombre;

        public Rubro(String nombre) {
            this.nombre = nombre;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

    }

    public List<Material> obtenerEscasos() {

        MySQLMaterialDAO listMatAll = new MySQLMaterialDAO();
        List<Material> listMat = listMatAll.obtenerTodos();
        for (Material m : listMat) {
            if (m.getStockMaterial() < 5) {
                listMat.remove(listMat.indexOf(m));
            }
        }
        return listMat;
    }

    public List<String> rubrosPredominantes(List<Material> listMat) {
        List<String> listRubros = new ArrayList<>();
        int[] rubros = {0, 0, 0, 0, 0};
        String desc;/// cambiar a rubro
        for (Material m : listMat) {
            desc = m.getdescripcion();
            switch (desc) {
                case "Pintureria":
                    rubros[0]++;
                    break;
                case "PVC":
                    rubros[1]++;
                    break;
                case "Construccion":
                    rubros[2]++;
                    break;
                case "Ferreteria":
                    rubros[3]++;
                    break;
                case "Electricidad":
                    rubros[4]++;
                    break;
            }
        }
        listRubros = mayores(rubros);
        return listRubros;
    }

    private List<String> mayores(int[] a) {
        List<String> listRubros = new ArrayList<>();
        for (int j = 0; j < 3; j++) {
            int may = a[0];
            int i;
            int p;
            for (i = 0; i < 5; i++) {
                if (a[i] > may) {
                    may = a[i];
                    p = i;
                }
            }
            switch (may) {
                case 0:
                    listRubros.add("Pintureria");
                    a[0] = 0;
                    break;
                case 1:
                    listRubros.add("PVC");
                    a[1] = 0;
                    break;
                case 2:
                    listRubros.add("Construccion");
                    a[2] = 0;
                    break;
                case 3:
                    listRubros.add("Ferreteria");
                    a[3] = 0;
                    break;
                case 4:
                    listRubros.add("Ferreteria");
                    a[4] = 0;
                    break;
            }
        }
        return listRubros;
    }

    public List<Proveedor> obtenerProveedoresRubro(String descripcion) { // cambiar a rubro
        MySQLProveedorDAO listProveedorAll = new MySQLProveedorDAO();
        List<Proveedor> listProveedores = listProveedorAll.obtenerTodos();
        listProveedores.stream().filter((p) -> (p.getRubro().equals(descripcion))).forEach((p) -> {
            listProveedores.remove(listProveedores.indexOf(p));
        });
        return listProveedores;
    }
}
