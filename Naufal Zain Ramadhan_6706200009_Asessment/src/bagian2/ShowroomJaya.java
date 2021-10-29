package bagian2;

import java.security.spec.MGF1ParameterSpec;
import java.util.ArrayList;

class Mobil{
    private String merk, tahunKeluaran;
    private double harga;
    private int stok;

    public Mobil(String merk, String tahunKeluaran, double harga, int stok) {
        this.merk = merk;
        this.tahunKeluaran = tahunKeluaran;
        this.harga = harga;
        this.stok = stok;
    }

    public String getMerk(){
        return merk;
    }

    public String getTahunKeluaran(){
        return tahunKeluaran;
    }

    public double getHarga(){
        return harga;
    }

    public void setHarga(double harga){
        this.harga = harga;
    }

    public int getstok() {
        return stok;
    }

    public void setstok(int stok) {
        this.stok = stok;
    }

    public void displayInfo() {
        System.out.println();
        System.out.println("Informasi Mobil");
        System.out.println("Merk : " + getMerk());
        System.out.println("Harga: " +getHarga());
        System.out.println("Tahun Keluaran: " + getTahunKeluaran());
        System.out.println("Sisa Stok: " + getstok() + "\n");

    }
}

class ShowroomJaya{
    public static ArrayList<Mobil> arrMobil = new ArrayList<>();

    public static void  tambahMobil(Mobil mobil) {
        arrMobil.add(mobil);
    }

    public static void beliMobil(String merk, String  tahunKeluaran, int jumlah){
        System.out.println("input");
        System.out.println("Merk : " + merk);
        System.out.println("Tahun Keluaran : " + tahunKeluaran);
        System.out.println("Jumlah : " + jumlah + "\n");

        for ( Mobil mobil : arrMobil) {
            if (merk.equalsIgnoreCase(mobil.getMerk())
                &&tahunKeluaran.equals(mobil.getTahunKeluaran())
                &&jumlah < mobil.getstok()) {

                double diskon = 0;
                double hargaDiskon = 0;
                double totalBayar = mobil.getHarga() * jumlah;

                mobil.setstok(mobil.getstok() - jumlah);

                if (jumlah == 1) {
                    diskon = 0;
                    hargaDiskon = diskon;
                }
                if (jumlah == 2) {
                    diskon = 10;
                    hargaDiskon = totalBayar * 0.1;
                    mobil.setHarga(hargaDiskon);
                }
                if (jumlah > 2) {
                    diskon = 20;
                    hargaDiskon = totalBayar * 0.2;
                    mobil.setHarga(hargaDiskon);
                }
                System.out.println("Output");
                System.out.println("Merk : " + mobil.getMerk());
                System.out.println("Harga Satuan : " + mobil.getHarga());
                System.out.println("Tahun Keluaran : " + mobil.getTahunKeluaran());
                System.out.println("Jumlah Beli : " + jumlah);
                System.out.println("Total Harga : " + mobil.getHarga() * jumlah);
                System.out.println("Diskon : " + diskon + "%");
                System.out.println("Total Diskon : " + hargaDiskon);
                System.out.println("Total Bayar : " + (totalBayar - hargaDiskon) + "\n");

                mobil.setstok(mobil.getstok() - jumlah);

            }else if (merk.equalsIgnoreCase(mobil.getMerk())&& tahunKeluaran.equals(mobil.getTahunKeluaran())&& mobil.getstok() < jumlah){
                System.out.println("Maaf Jumlah Stok Tidak Mencukupi");

            }
        }
    }
    public static void viewStok(){
        for (Mobil mobil : arrMobil){
            mobil.displayInfo();
        }
    }
    public static void main(String [] args){
        Mobil mobil1 = new Mobil("Avanza", "2018", 150000000.0, 1);
        Mobil mobil2 = new Mobil("Aston Martin", "2019", 394000000.0, 10);
        Mobil mobil3 = new Mobil("YARIS 1.5 G M/T 3 AirBags", "2020", 248300000.0, 4);

        tambahMobil(mobil1);
        tambahMobil(mobil2);
        tambahMobil(mobil3);

        viewStok();

        beliMobil("Avanza", "2018", 1);
        beliMobil("Aston Martin", "2019", 2);
        beliMobil("YARIS", "2020" ,4);
        beliMobil("Avanza", "2018", 1);

        viewStok();
    }
}
