package com.filhandennis.activity.FILHANDENNIS_1202150079_Modul1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.filhandennis.activity.FILHANDENNIS_1202150079_Modul1.R;

public class Deskripsi extends AppCompatActivity {

    //Deklarasi dari TextView Element Attribut yang akan digunakan.
    // namaRestoran = NAMA RESTORAN
    // namaMenu = NAMA MENU
    // porsiMenu = BANYAK PORSI
    // totHargaMenu = TOTAL HARGA MENU = HARGA MENU*PORSI
    private TextView namaRestoran, namaMenu, porsiMenu, totHargaMenu;

    //Activity onCreatea, method yang akan dijalankan saat Aplikasi Dibuka (Buat)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deskripsi);

        //Inisialisasi Nilai dari Element TextView untuk NAMA RESTORAN
        namaRestoran = (TextView)findViewById(R.id.lblRestoran);
        //Inisialisasi Nilai dari Element TextView untuk NAMA MENU
        namaMenu = (TextView)findViewById(R.id.lblNamaMenu);
        //Inisialisasi Nilai dari Element TextView untuk BANYAK PORSI
        porsiMenu = (TextView)findViewById(R.id.lblBanyakPorsi);
        //Inisialisasi Nilai dari Element TextView untuk HARGA TOTAL
        totHargaMenu = (TextView)findViewById(R.id.lblHarga);


        //Membuat Intent Activity ini
        Intent n = getIntent();
        //Deklarasi variable yang akan digunakan: ID RESTORAN, NAMA MENU, BANYAK PORSI
        String idrestoran, nama, porsi;
        //Deklarasi variable uang untuk menampung nilai 65000
        int uang;
        //Mengisi nilai variable dengan Extra dari MainActivity
        idrestoran = n.getStringExtra(MainActivity.idRestoran);
        //Mengisi nilai variable dengan Extra dari MainActivity
        nama = n.getStringExtra(MainActivity.menuNama);
        //Mengisi nilai variable dengan Extra dari MainActivity
        porsi = n.getStringExtra(MainActivity.menuPorsi);
        //Mengisi nilai variable dengan Extra dari MainActivity
        uang = Integer.parseInt(n.getStringExtra(MainActivity.UANG));

        //Mengisi nilai variable RESTORAN
        String restoran = "";
        //Mengisi nilai variable HARGA, jika ada input 001 maka harga yang diberikan adalah harga 1 porsi dari restoran Eatbus atau Apnormal
        long harga = 0;
            //Jika ID RESTORAN = 001 (Eatbus), Harga=30000/Porsi
            if(idrestoran.equals("001")){
            restoran = "Eatbus";
            harga = 30000;
            //Jika ID RESTORAN = 002 (Apnormal), Harga=50000/Porsi
            }else if(idrestoran.equals("002")){
            restoran = "Apnormal";
            harga = 50000;
        }

        //Perhitungan Harga Total: harga 1 porsi x jumlah porsi
        harga = harga*Integer.parseInt(porsi);

        //Pengecekan UANG dan Harga
        //Jika HARGA TOTAL lebih kecil sama dengan UANG:
        if(harga<=uang){
            //Maka, akan diberikan notif dengan TOAST yang isinya:
            Toast.makeText(this,"Disini aja Makan Malamnya",Toast.LENGTH_LONG).show();
        }else{
            //,Jika tidak, akan diberikan notif dengan TOAST yang isinya:
            Toast.makeText(this,"Jangan disini Makan Malamnya, Uang kamu tidak cukup.",Toast.LENGTH_LONG).show();
        }

        //metod setText digunakan untuk mengubah kata/kalimat didalam element TextView
        namaRestoran.setText(restoran);
        namaMenu.setText(nama);
        porsiMenu.setText(porsi);
        totHargaMenu.setText(""+harga);
    }

    //Method untuk menutup Activity Deskripsi
    public void tutup(View view){
        finish();
    }
}
