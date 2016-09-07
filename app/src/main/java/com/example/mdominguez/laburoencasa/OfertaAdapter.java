package com.example.mdominguez.laburoencasa;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mdominguez on 07/09/16.
 */
public class OfertaAdapter extends BaseAdapter {

    private List<Trabajo> listaTrabajos;
    private LayoutInflater inflater;
    private Context context;

    public OfertaAdapter(){
        super();

        this.listaTrabajos = new ArrayList<Trabajo>();
    }

    public OfertaAdapter(Context ctx, List<Trabajo> items){
        super();
        this.context=ctx;
        this.listaTrabajos =items;
        inflater = LayoutInflater.from(ctx);
    }

    @Override
    public int getCount() {
        return listaTrabajos.size();
    }

    @Override
    public Object getItem(int i) {
        return listaTrabajos.get(i);
    }

    @Override
    public long getItemId(int i) {
        return listaTrabajos.get(i).getId();
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        DecimalFormat df = new DecimalFormat("#.##");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        View row=convertView;
        if(row==null)  row=inflater.inflate(R.layout.fila_oferta, parent, false);
        OfertaViewHolder ofeVH =(OfertaViewHolder)row.getTag();
        if(ofeVH==null){
            ofeVH = new OfertaViewHolder(row);
            row.setTag(ofeVH);
        }
        /// seteo datos
        Trabajo aux = (Trabajo)getItem(i);
        ofeVH.tvCategoria.setText(aux.getCategoria().getDescripcion());
        ofeVH.tvTitulo.setText(aux.getDescripcion());
        ofeVH.tvHoras.setText("Horas:"+aux.getHorasPresupuestadas());
        ofeVH.tvPrecio.setText("Max $/Hora: "+df.format(aux.getPrecioMaximoHora()));
        ofeVH.tvFecha.setText("Fecha Fin: "+sdf.format(aux.getFechaEntrega()));
        ofeVH.cbIngles.setChecked(aux.getRequiereIngles());

        switch (aux.getMonedaPago()){
            case 1:
                ofeVH.imgMoneda.setImageResource(R.drawable.us);
                break;
            case 2:
                ofeVH.imgMoneda.setImageResource(R.drawable.eu);
                break;
            case 3:
                ofeVH.imgMoneda.setImageResource(R.drawable.ar);
                break;
            case 4:
                ofeVH.imgMoneda.setImageResource(R.drawable.uk);
                break;
            case 5:
                ofeVH.imgMoneda.setImageResource(R.drawable.br);
                break;
        }
        return(row);
    }

    public List<Trabajo> getListaTrabajos() {
        return listaTrabajos;
    }


    class OfertaViewHolder {
        TextView tvCategoria;
        TextView tvTitulo;
        TextView tvHoras;
        TextView tvPrecio;
        TextView tvFecha;
        ImageView imgMoneda ;
        CheckBox cbIngles;

        public OfertaViewHolder(View v){
            tvCategoria = (TextView) v.findViewById(R.id.txtCategoria);
            tvTitulo = (TextView) v.findViewById(R.id.txtTitulo);
            tvHoras = (TextView) v.findViewById(R.id.txtHoras);
            tvPrecio = (TextView) v.findViewById(R.id.txtPrecioMaximo);
            tvFecha= (TextView) v.findViewById(R.id.txtFecha);
            imgMoneda = (ImageView) v.findViewById(R.id.imgMoneda);
            cbIngles = (CheckBox) v.findViewById(R.id.optIngles);

        }
    }

}
