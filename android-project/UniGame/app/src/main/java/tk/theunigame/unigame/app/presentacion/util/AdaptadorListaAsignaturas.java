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
public class AdaptadorListaAsignaturas extends BaseAdapter {

    private String confirmar = "Confirmar";
    private ArrayList<Asignatura> asignaturas;
    private Context context;

    public int getAsignaturasCantidad(){return asignaturas.size();}

    public Asignatura getAsignatura(int posicionArray){return asignaturas.get(posicionArray);}

    @Override
    public int getCount() {
        return asignaturas.size()+1;
    }

    @Override
    public Object getItem(int position) {
        if(position==0)
            return confirmar;
        else
            return asignaturas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    //Elemento utilizado para reutilización de instancias
    static class ViewHolder {
        CheckBox chkBox;
        TextView txt;
    }

    public AdaptadorListaAsignaturas(Context context, ArrayList<Asignatura> datos){
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
            if(position != 0) {
                item = inflater.inflate(R.layout.list_item_checkbox, null);

            }else {
                item = inflater.inflate(R.layout.list_item_default, null);
            }

            holder.chkBox = (CheckBox) item.findViewById(R.id.chk_listitem_default);
            holder.txt= (TextView)item.findViewById(R.id.txt_listitem_default);

            //Almacenamos el elemento en como un tag de la View
            item.setTag(holder);
        }else{
            //Si el item ya ha sido instanciado con anterioridad lo recuperamos del convertView
            holder= (ViewHolder)item.getTag();
        }

        if(position != 0) {
            holder.txt.setText(asignaturas.get(position - 1).getNombre());
            holder.chkBox.setTag(position-1);
        }else
            holder.txt.setText(confirmar);

        return item;
    }
}
