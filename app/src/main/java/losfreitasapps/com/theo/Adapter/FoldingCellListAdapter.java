package losfreitasapps.com.theo.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ramotion.foldingcell.FoldingCell;

import java.io.InputStream;
import java.util.HashSet;
import java.util.List;

import losfreitasapps.com.theo.Models.Anuncio;
import losfreitasapps.com.theo.R;

/**
 * Simple example of ListAdapter for using with Folding Cell
 * Adapter holds indexes of unfolded elements for correct work with default reusable views behavior
 */
public class FoldingCellListAdapter extends ArrayAdapter<Anuncio> {

    private HashSet<Integer> unfoldedIndexes = new HashSet<>();


    public FoldingCellListAdapter(Context context, List<Anuncio> objects) {
        super(context, 0, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final Anuncio ads = getItem(position);

        FoldingCell cell = (FoldingCell) convertView;
        ViewHolder viewHolder;
        if (cell == null) {
            viewHolder = new ViewHolder();
            LayoutInflater vi = LayoutInflater.from(getContext());
            cell = (FoldingCell) vi.inflate(R.layout.cell, parent, false);

            viewHolder.preco1 = (TextView) cell.findViewById(R.id.preco1);
            viewHolder.dia1 = (TextView) cell.findViewById(R.id.dia1);
            viewHolder.nomePromo1 = (TextView) cell.findViewById(R.id.nomePromo1);
            viewHolder.nomeLoja1 = (TextView) cell.findViewById(R.id.nomeLoja1);
            viewHolder.euVouNumber1 = (TextView) cell.findViewById(R.id.euVouNumber1);
            viewHolder.abreHora1 = (TextView) cell.findViewById(R.id.abreHora1);
            viewHolder.fechaHora1 = (TextView) cell.findViewById(R.id.fechaHora1);
            viewHolder.nomePromo2 = (TextView) cell.findViewById(R.id.nomePromo2);
            viewHolder.nomeLoja2 = (TextView) cell.findViewById(R.id.nomeLoja2);
            viewHolder.ratingNumber = (TextView) cell.findViewById(R.id.ratingNumber);
            viewHolder.endereco1 = (TextView) cell.findViewById(R.id.endereco1);
            viewHolder.endereco2 = (TextView) cell.findViewById(R.id.endereco2);
            viewHolder.abreHora2 = (TextView) cell.findViewById(R.id.abreHora2);
            viewHolder.dia2 = (TextView) cell.findViewById(R.id.dia2);
            viewHolder.fechaHora2 = (TextView) cell.findViewById(R.id.fechaHora2);
            viewHolder.euVouText = (TextView) cell.findViewById(R.id.euVouText);
            viewHolder.euVouBotao = (TextView) cell.findViewById(R.id.euVouBotao);
            viewHolder.arrowLoja = (ImageView) cell.findViewById(R.id.arrowLoja);
            viewHolder.arrowEndereco = (ImageView) cell.findViewById(R.id.arrowEndereco);
            cell.setTag(viewHolder);
        } else {
            if (unfoldedIndexes.contains(position)) {
                cell.unfold(true);
            } else {
                cell.fold(true);
            }
            viewHolder = (ViewHolder) cell.getTag();
        }

        viewHolder.preco1.setText(ads.getPreco());
        viewHolder.dia1.setText(ads.getDia());
        viewHolder.nomePromo1.setText(ads.getNomePromo());
        viewHolder.nomeLoja1.setText(ads.getLoja());
        viewHolder.euVouNumber1.setText(ads.getEuVou());
        viewHolder.abreHora1.setText(String.valueOf(ads.getAbre()));
        viewHolder.fechaHora1.setText(ads.getFecha());
        viewHolder.nomePromo2.setText(ads.getNomePromo());
        viewHolder.nomeLoja2.setText(ads.getLoja());
        viewHolder.ratingNumber.setText(ads.getNumAvaliacoes());
        viewHolder.endereco1.setText(ads.getEndereco1());
        viewHolder.endereco2.setText(ads.getEndereco2());
        viewHolder.abreHora2.setText(String.valueOf(ads.getAbre()));
        viewHolder.dia2.setText(ads.getDia());
        viewHolder.fechaHora2.setText(ads.getFecha());
        viewHolder.euVouText.setText(String.valueOf(ads.getEuVou()) + " disseram que vão");

        new DownloadImageTask((ImageView) cell.findViewById(R.id.fotoPromo)).execute(ads.getFotoPromo());
        new DownloadImageTask((ImageView) cell.findViewById(R.id.logoIV)).execute(ads.getLogo());

        viewHolder.arrowEndereco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse(ads.getMaps());
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(uri);
                getContext().startActivity(i);
            }
        });

        viewHolder.arrowLoja.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"Iniciar lojaActivity",Toast.LENGTH_SHORT).show();
            }
        });

        viewHolder.euVouBotao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"+1 Eu Vou!",Toast.LENGTH_SHORT).show();
            }
        });
        return cell;
    }

    public void registerToggle(int position) {
        if (unfoldedIndexes.contains(position))
            registerFold(position);
        else
            registerUnfold(position);
    }

    public void registerFold(int position) {
        unfoldedIndexes.remove(position);
    }

    public void registerUnfold(int position) {
        unfoldedIndexes.add(position);
    }

    private static class ViewHolder {
        TextView preco1;
        TextView dia1;
        TextView nomePromo1;
        TextView nomeLoja1;
        TextView euVouNumber1;
        TextView abreHora1;
        TextView fechaHora1;
        TextView nomePromo2;
        TextView nomeLoja2;
        TextView ratingNumber;
        TextView endereco1;
        TextView endereco2;
        TextView abreHora2;
        TextView dia2;
        TextView fechaHora2;
        TextView euVouBotao;
        TextView euVouText;
        ImageView arrowLoja;
        ImageView arrowEndereco;
    }

    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        ImageView bmImage;

        public DownloadImageTask(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap mIcon11 = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return mIcon11;
        }

        protected void onPostExecute(Bitmap result) {
            bmImage.setImageBitmap(result);
        }
    }
}
