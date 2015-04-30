package tk.theunigame.unigame.app.presentacion.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

import juego.taes.domainmodel.Model.Cliente.BDPreguntas;
import tk.theunigame.unigame.R;

/**
 * Created by John on 08/04/2015.
 *
 * Este clase será modoficada en función de los valores que se quieran mostrar
 * a través de la consulta a la base de datos remota
 */
public class AdaptadorListaBasesDatosSinCB extends BaseAdapter {
    private Context context;
    private List<BDPreguntas> basesDatos;

    @Override
    public int getCount() {
        return basesDatos.size();
    }

    @Override
    public Object getItem(int position) {
        return basesDatos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    //Elemento utilizado para reutilización de instancias
    static class ViewHolder {
        TextView txt;
    }

    public AdaptadorListaBasesDatosSinCB(Context context, List<BDPreguntas> datos){
        this.context=context;
        basesDatos=datos;

    }

    //Inflamos el elemento de la lista con los datos que queremos
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //Optimizamos la creación del layout realizándola solo una primera vez.
        View item= convertView;
        ViewHolder holder;
        if(item==null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            item = inflater.inflate(R.layout.list_item_default, null);

            holder= new ViewHolder();
            holder.txt= (TextView)item.findViewById(R.id.txt_listitem_default);

            //Almacenamos el elemento en como un tag de la View
            item.setTag(holder);
        }else{
            //Si el item ya ha sido instanciado con anterioridad lo recuperamos del convertView
            holder= (ViewHolder)item.getTag();
        }

        holder.txt.setText(basesDatos.get(position).getNombre());

        return item;
    }
}
