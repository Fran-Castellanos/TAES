package tk.theunigame.unigame.app.presentacion.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import juego.taes.domainmodel.Model.Cliente.Carrera;
import juego.taes.domainmodel.Model.Cliente.Universidad;
import tk.theunigame.unigame.R;

/**
 * Created by John on 08/04/2015.
 *
 * Este clase será modoficada en función de los valores que se quieran mostrar
 * a través de la consulta a la base de datos remota
 */
public class AdaptadorListaCarreras extends BaseAdapter {
    private Context context;
    private ArrayList<Carrera> carreras;

    @Override
    public int getCount() {
        return carreras.size();
    }

    @Override
    public Object getItem(int position) {
        return carreras.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    //Elemento utilizado para reutilización de instancias
    static class ViewHolder {
        TextView txtView;
    }

    public AdaptadorListaCarreras(Context context, ArrayList<Carrera> datos){
        this.context=context;
        carreras=datos;
    }

    //Inflamos el elemento de la lista con los datos que queremos
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //Optimizamos la creación del layout realizándola solo una primera vez.
        View item= convertView;
        ViewHolder holder;
        if(item==null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            item = inflater.inflate(R.layout.list_item_db, null);

            holder= new ViewHolder();
            holder.txtView= (TextView)item.findViewById(R.id.txt_listitem_db);

            //Almacenamos el elemento en como un tag de la View
            item.setTag(holder);
        }else{
            //Si el item ya ha sido instanciado con anterioridad lo recuperamos del convertView
            holder= (ViewHolder)item.getTag();
        }

        holder.txtView.setText(carreras.get(position).getNombre());

        return item;
    }
}
