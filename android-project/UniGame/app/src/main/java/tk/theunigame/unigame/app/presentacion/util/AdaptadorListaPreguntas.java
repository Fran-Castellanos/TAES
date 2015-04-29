package tk.theunigame.unigame.app.presentacion.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import juego.taes.domainmodel.Model.Cliente.BDPreguntas;
import juego.taes.domainmodel.Model.Cliente.Pregunta;
import tk.theunigame.unigame.R;

/**
 * Created by Pedro on 29/04/2015.
 */
public class AdaptadorListaPreguntas extends BaseAdapter {
    private Context context;
    private List<Pregunta> preguntas;

    @Override
    public int getCount() {
        return preguntas.size();
    }

    @Override
    public Object getItem(int position) {
        return preguntas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    //Elemento utilizado para reutilización de instancias
    static class ViewHolder {
        TextView txt;
    }

    public AdaptadorListaPreguntas(Context context, List<Pregunta> datos){
        this.context=context;
        preguntas=datos;

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

        holder.txt.setText(preguntas.get(position).getId());


        return item;
    }
}