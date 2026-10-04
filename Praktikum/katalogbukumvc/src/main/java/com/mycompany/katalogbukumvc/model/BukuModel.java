/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.katalogbukumvc.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class BukuModel {
    private final List<Buku> daftarBuku = new ArrayList<>();

    public void tambahBuku(Buku buku) {
        daftarBuku.add(buku);
    }

    public void hapusBuku(int index) {
        if(index >= 0 && index < daftarBuku.size()) {
            daftarBuku.remove(index);
        }
    }

    public void hapussemua() {
        daftarBuku.clear();
    }

    public List<Buku> getsemuabuku() {
        return List.copyOf(daftarBuku);
    }
}
