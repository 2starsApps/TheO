package losfreitasapps.com.theo.Transfer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import losfreitasapps.com.theo.Models.Anuncio;
import losfreitasapps.com.theo.R;

public class AdsTransfer extends AppCompatActivity {
    private DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
    private DatabaseReference adstransfer = databaseReference.child("Ads");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ads_transfer);

        Anuncio ads = new Anuncio();

        ads.setAbre("17:00");
        ads.setAvalicao("3");
        ads.setDia("TERÇA-FEIRA");
        ads.setEndereco1("Av. João XXIII, 3200");
        ads.setEndereco2("Recanto das Palmeiras, Teresina - PI");
        ads.setEuVou("23");
        ads.setFecha("22:00");
        ads.setFotoPromo("https://nutricionyadolecentes.files.wordpress.com/2012/10/comida-chatarra-escuelas-estados-unidos.jpg");
        ads.setLogo("https://img.igeeksblog.com/wp-content/uploads/2013/05/Jumbo-Logo-Design-iPhone-and-iPad-App-Icon.jpg");
        ads.setLoja("Restaurante Maresia");
        ads.setMaps("https://goo.gl/maps/aVDK3auDd9k");
        ads.setNomePromo("Peixe Assado");
        ads.setNumAvaliacoes("(312)");
        ads.setPreco("R$40");
        adstransfer.child("0003").setValue(ads);

        ads.setAbre("12:00");
        ads.setAvalicao("5");
        ads.setDia("HOJE");
        ads.setEndereco1("R. Juíz João Almeida, 2287");
        ads.setEndereco2("Planalto, Teresina - PI");
        ads.setEuVou("45");
        ads.setFecha("01:35");
        ads.setFotoPromo("http://2.bp.blogspot.com/_aJT3I8ICB-8/S3GxhYzZOcI/AAAAAAAAAZc/BCwoqqcD_Kc/s400/JACARE.jpg");
        ads.setLogo("http://igorodrigues.com.br/wp-content/uploads/2016/09/igo-rodrigues-web-designer.png");
        ads.setLoja("Moinho de Pedra");
        ads.setMaps("https://goo.gl/maps/gjJLB1C83oR2");
        ads.setNomePromo("0,5kg de Picanha");
        ads.setNumAvaliacoes("(400)");
        ads.setPreco("R$14");
        adstransfer.child("0004").setValue(ads);

        ads.setAbre("18:40");
        ads.setAvalicao("3");
        ads.setDia("AMANHÃ");
        ads.setEndereco1("Av. N. Sra. de Fátima, 1681");
        ads.setEndereco2("Fátima, Teresina - PI");
        ads.setEuVou("55");
        ads.setFecha("23:00");
        ads.setFotoPromo("http://www.acontecedigital.com.br/portal/images/festivalgastronomicopg001.JPG");
        ads.setLogo("http://ieee-collabratec.ieee.org/assets/img/collabratec_logo_tablet_img.png");
        ads.setLoja("Restaurante Labareda");
        ads.setMaps("https://goo.gl/maps/sNzxBKadKFz");
        ads.setNomePromo("Frango Desossado");
        ads.setNumAvaliacoes("(101)");
        ads.setPreco("R$23");
        adstransfer.child("0005").setValue(ads);

        ads.setAbre("20:00");
        ads.setAvalicao("1");
        ads.setDia("HOJE");
        ads.setEndereco1("Av. N. Sra. de Fátima, 671");
        ads.setEndereco2("Jóquei, Teresina - PI");
        ads.setEuVou("35");
        ads.setFecha("03:00");
        ads.setFotoPromo("https://lh4.googleusercontent.com/-z9h6SKNO1dk/UiUbGTHxoyI/AAAAAAAADAg/WQHxwRrcRs4/s640/blogger-image-369829684.jpg");
        ads.setLogo("https://logodownload.org/wp-content/uploads/2014/02/Volkswagen-logo-vw-logo-15.png");
        ads.setLoja("Bacalhau & Companhia");
        ads.setMaps("https://goo.gl/maps/V4yoDmqcR3n");
        ads.setNomePromo("Bacanhau ao Molho");
        ads.setNumAvaliacoes("(90)");
        ads.setPreco("R$55");
        adstransfer.child("0006").setValue(ads);

        ads.setAbre("14:00");
        ads.setAvalicao("5");
        ads.setDia("HOJE");
        ads.setEndereco1("Av. D. Severino, 3091");
        ads.setEndereco2("Horto, Teresina - PI");
        ads.setEuVou("20");
        ads.setFecha("18:00");
        ads.setFotoPromo("https://s-media-cache-ak0.pinimg.com/originals/14/33/ec/1433ec2a0c699712c12c732803c47ce2.jpg");
        ads.setLogo("http://img.ibxk.com.br/2015/08/18/18134403977437-t100x100.jpg");
        ads.setLoja("Restaurante Cajuína");
        ads.setMaps("https://goo.gl/maps/67mnEHp6Gys");
        ads.setNomePromo("Picanha - 500g");
        ads.setNumAvaliacoes("(1286)");
        ads.setPreco("R$102");
        adstransfer.child("0007").setValue(ads);
    }
}
