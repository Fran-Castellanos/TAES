package tk.theunigame.unigame.app.presentacion.util;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;

import tk.theunigame.unigame.R;

/**
 * Created by John on 09/04/2015.
 *
 * Este cursor es recomendado utilizarlo para datos locales tomados generalemte
 * de una base de datos SqlLit, en caso contrario usar AdaptadorListaMultiItem
 */
public class AdaptadorCursorDB extends CursorAdapter {


    public AdaptadorCursorDB(Context context, Cursor c){
        //El "false" indica que la consulta no ha de ser regenerada
        super(context, c, false);
    }

    //Inflamos la vista
    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        LayoutInflater inflater= LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.list_item_db, null);

        return view;
    }

    //Iniciamos los atributos de la lista
    @Override
    public void bindView(View view, Context context, Cursor cursor) {
    }
}
