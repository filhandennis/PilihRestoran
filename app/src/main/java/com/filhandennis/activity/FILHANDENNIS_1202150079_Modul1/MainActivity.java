package com.filhandennis.activity.FILHANDENNIS_1202150079_Modul1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.filhandennis.activity.FILHANDENNIS_1202150079_Modul1.R;

public class MainActivity extends AppCompatActivity {

    //Atrribut-Attribut yang disimpan di Extra
    //Attribut untuk menampung nilai Uang yang disimpan di Extra
    public final static String UANG = "com.filhandennis.activity.FILHANDENNIS_1202150079_Modul1.extra.UANG";
    //Attribut untuk menampung nilai ID RESTORAN yang disimpan di Extra
    public final static String idRestoran = "com.filhandennis.activity.FILHANDENNIS_1202150079_Modul1.extra.ID_RESTORAN";
    //Attribut untuk menampung nilai NAMA MENU yang disimpan di Extra
    public final static String menuNama = "com.filhandennis.activity.FILHANDENNIS_1202150079_Modul1.extra.MENU_NAMA";
    //Attribut untuk menampung nilai BANYAK PORSI yang disimpan di Extra
    public final static String menuPorsi = "com.filhandennis.activity.FILHANDENNIS_1202150079_Modul1.extra.MENU_PORSI";

    //Element Attribut
    //Element input untuk NAMA MENU dan BANYAK PORSI
    private EditText txtNamaMenu, txtPorsi;
    //Attribut yang digunakan untuk menampung nilai NAMA MENU dari Element Input
    private String namaMenu;
    //Attribut yang digunakan untuk menampung nilai BANYAK PORSI dari Element Input
    private String porsiMenu;

    //Activity onCreatea, method yang akan dijalankan saat Aplikasi Dibuka (Buat)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Inisialisasi Nilai dari Element EditText untuk NAMA MENU
        txtNamaMenu = (EditText)findViewById(R.id.txtNamaMakanan);
        //Inisialisasi Nilai dari Element EditText untuk NAMA MENU
        txtPorsi = (EditText)findViewById(R.id.txtPorsi);
    }

    //Method yang digunakan untuk memberikan nilai/set ke NAMA MENU dan BANYAK PORSI kemudian membuka Activity Deskripsi sebagai Hasilnya
    public void setMenu(String id){
        //Intent dari Activity Deskripsi
        Intent n = new Intent(this,Deskripsi.class);

        //Tangkapan nilai NAMA MENU
        namaMenu = txtNamaMenu.getText().toString();
        //Tangkapan nilai BANYAK PORSI
        porsiMenu = txtPorsi.getText().toString();

        //Pengecekan Validasi nilai yang belum terisi dan Pengecekan Menu, jika salah satu kondisi tidak terpenuhi maka eksekusi kode selanjutnya akan dihentikan
        if(check_validation()==false || check_menu()==false){return;}

        //Ambil nilai NAMA MENU
        String nama = namaMenu;
        //Ambil nilai BANYAK PORSI dan diubah dari String ke Integer
        int porsi = Integer.parseInt(porsiMenu);

        //Memberikan&Menyimpan nilai ID RESTORAN ke EXTRA
        n.putExtra(idRestoran,id);
        //Memberikan&Menyimpan nilai NAMA MENU ke EXTRA
        n.putExtra(menuNama,nama);
        //Memberikan&Menyimpan nilai BANYAK PORSI ke EXTRA
        n.putExtra(menuPorsi,""+porsi);
        //Memberikan&Menyimpan nilai UANG ke EXTRA
        n.putExtra(UANG,"65000");
        startActivity(n);
    }

    //Method yang digunakan untuk melakukan pengecekan Nilai pada nama dan porsi, jika ada yang kosong/tidak terisi maka akan diberikan peringatan dan eksekusi ke activity selanjutnya akan dibatalkan
    public boolean check_validation(){
        String nama = namaMenu;
        String porsi = porsiMenu;
        //Jika NAMA MENU atau BANYAK PORSI kosong/tidak terisi maka akan mengeluarkan warning dengan Toast
        if( ( nama.equals("")||nama.isEmpty() ) || ( porsi.equals("")||porsi.isEmpty() ) ){
            //Membuat & Menampilkan TOAST
            Toast.makeText(this,"Nama menu atau Porsi menu tidak boleh Kosong",Toast.LENGTH_SHORT).show();
            //Batalkan jika nilai kosong/tidak terisi
            return false;
        }
        //Nilai berisi
        return true;
    }

    //Method yang digunakan untuk melakukan pengcekan menu yang diinputkan, jika menu yang diinputkan termasuk ke dalam daftar yang dibuat maka akan dijalannya, jika tidak maka eksekusi akan dibatalkan dan diberikan notif
    public boolean check_menu(){
        //Daftar Menu yang ada
        String[] menus = {"Nasi Uduk","Pizza","Steak","Mie Telor"};
        //Input NAMA MENU
        String nama = namaMenu;
        //Hasil Pencarian
        boolean res=false;
        //Loop untuk menyocokkan nama menu dengan daftar menu
        for(String menu: menus){
            //Penyocokan menu dan item dari daftar menu
            if(menu.equalsIgnoreCase(nama)){res=true; break;}
        }
        //Jika item yang di masukkan tidak ditemukan maka akan diberikan Warning
        if(res==false){Toast.makeText(this,"Menu '"+nama+"' Tidak Ditemukan dalam Daftar",Toast.LENGTH_SHORT).show();}
        //Hasil dari method
        return res;
    }

    //Digunakan untuk mengeksekusi tombol sesuai dengan ID RESTORAN (EATBUS = 001)
    public void eatbus(View view){
        setMenu("001");
    }
    //Digunakan untuk mengeksekusi tombol sesuai dengan ID RESTORAN (APNORMAL = 002)
    public void apnormal(View view){
        setMenu("002");
    }
}
