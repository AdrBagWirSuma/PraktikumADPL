/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.katalogbukumvc.controller;

import com.mycompany.katalogbukumvc.model.BukuModel;
import com.mycompany.katalogbukumvc.view.BukuView;

/**
 *
 * @author ADMIN
 */
public class BukuController {

    private final BukuModel model;
    private final BukuView view;

    public BukuController(BukuModel model, BukuView view) {
        this.model = model;
        this.view = view;

        view.addSimpanListener(event -> simpanBuku());
        view.addHapusListener(event -> hapusBuku());
        view.addClearListener(event -> clearBuku());

        view.tampilkanData(model.getsemuabuku());
    }

    public void simpanBuku() {
        String judul = view.getJudul().trim();
        String penulis = view.getPenulis().trim();
        String teksTahun = view.getTahunTerbit().trim();

        if (judul.isEmpty() || penulis.isEmpty() || teksTahun.isEmpty()) {
            view.tampilkanPeringatan(
                "Input tidak valid",
                "Judul, Penulis, dan Tahun Terbit harus diisi.");
            return;
        }

        int tahunTerbit;
        try {
            tahunTerbit = Integer.parseInt(teksTahun);
        } catch (Exception e) {
            view.tampilkanPeringatan(
                "Input tidak valid",
                "Tahun Terbit harus berupa angka."
            );
            return;
        }

        model.tambahBuku(new com.mycompany.katalogbukumvc.model.Buku(judul, penulis, tahunTerbit));
        view.tampilkanData(model.getsemuabuku());
        view.kosongkanForm();
    }

    public void hapusBuku() {
        int baris = view.getBarisTerpilih();
        if (baris == -1) {
            view.tampilkanInfo(
                "hapus buku",
                "Pilih buku yang ingin dihapus dari tabel.");
            return;
        }
        model.hapusBuku(baris);
        view.tampilkanData(model.getsemuabuku());
    }

    public void clearBuku() {
       model.hapussemua();
       view.tampilkanData(model.getsemuabuku());
       view.kosongkanForm();
    }

}
