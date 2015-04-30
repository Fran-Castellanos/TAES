package tk.theunigame.unigame.app.presentacion.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

import juego.taes.domainmodel.Model.Cliente.Asignatura;
import tk.theunigame.unigame.R;

/**
 * Created by John on 08/04/2015.
 *
 * Este clase será modoficada en función de los valores que se quieran mostrar
 * a través de la consulta a la base de datos remota
 */
public class AdaptadorListaAsignaturasSinCB extends BaseAdapter {

    private ArrayList<Asignatura> asignaturas;
    private Context context;

    public int getAsignaturasCantidad(){return asignaturas.size();}

    public Asignatura getAsignatura(int posicionArray){return asignaturas.get(posicionArray);}

    @Override
    public int getCount() {
        return asignaturas.size();
    }

    @Override
    public Object getItem(int position) {
        return asignaturas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    //Elemento utilizado para reutilización de instancias
    static class ViewHolder {
        TextView txt;
    }

    public AdaptadorListaAsignaturasSinCB(Context context, ArrayList<Asignatura> datos){
        this.context=context;
        this.asignaturas=datos;
    }

    //Inflamos el elemento de la lista con los datos que queremos
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //Optimizamos la creación del layout realizándola solo una primera vez.
        View item= convertView;
        ViewHolder holder;
        if(item==null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            holder= new ViewHolder();
            item = inflater.inflate(R.layout.list_item_default, null);

            holder.txt= (TextView)item.findViewById(R.id.txt_listitem_default);

            //Almacenamos el elemento en como un tag de la View
            item.setTag(holder);
        }else{
            //Si el item ya ha sido instanciado con anterioridad lo recuperamos del convertView
            holder= (ViewHolder)item.getTag();
        }

        holder.txt.setText(asignaturas.get(position).getNombre());

        return item;
    }
}
