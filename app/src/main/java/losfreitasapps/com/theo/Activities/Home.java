package losfreitasapps.com.theo.Activities;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.ramotion.foldingcell.FoldingCell;

import java.util.ArrayList;

import losfreitasapps.com.theo.Adapter.FoldingCellListAdapter;
import losfreitasapps.com.theo.Configuration.ConfiguracaoFirebase;
import losfreitasapps.com.theo.Models.Anuncio;
import losfreitasapps.com.theo.R;

/**
 * Created by Moises on 15/06/17.
 */

public class Home extends AppCompatActivity {
    private ListView adsLoja;
    private ArrayList<Anuncio> anuncios;
    private DatabaseReference firebase;
    private ValueEventListener valueEventListener;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_home);

        anuncios = new ArrayList<>();
        adsLoja = (ListView) findViewById(R.id.adsLoja);
        final FoldingCellListAdapter adapter = new FoldingCellListAdapter(this,anuncios);
        adsLoja.setAdapter(adapter);

        firebase = ConfiguracaoFirebase.getFirebase().child("Ads");
        progressDialog = ProgressDialog.show(this, "", "Carregando...", true);
        valueEventListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for ( DataSnapshot dados: dataSnapshot.getChildren() ){
                    Anuncio anuncio = dados.getValue(Anuncio.class);
                    anuncios.add(anuncio);
                }
                adapter.notifyDataSetChanged();
                progressDialog.dismiss();
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        };
        firebase.addValueEventListener(valueEventListener);

        adsLoja.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
                ((FoldingCell) view).toggle(false);
                adapter.registerToggle(pos);
            }
        });
    }
}