package tk.theunigame.unigame.app.presentacion.util;

import tk.theunigame.unigame.R;

/**
 * Created by John on 26/04/2015.
 */
public enum EIDANSWER {
    A(0, R.id.btn_edit_answer_a), B(1, R.id.btn_edit_answer_b), C(2, R.id.btn_edit_answer_c), D(3, R.id.btn_edit_answer_d);

    private final int id;
    private final int b_id;

    private EIDANSWER(int id, int b_id){
        this.id=id;
        this.b_id=b_id;
    }

    //Devuelve el valor de la Id
    public int getId(){return id;}

    //Devuelve el id del batón
    public int getButtonId(){return b_id;}

    public static EIDANSWER getByButtonId(int id) {
        EIDANSWER salida;
        switch (id){
            case R.id.btn_edit_answer_a: salida= A;
                break;
            case R.id.btn_edit_answer_b: salida= B;
                break;
            case R.id.btn_edit_answer_c: salida= C;
                break;
            case R.id.btn_edit_answer_d: salida= D;
                break;
            default: throw new RuntimeException("No se ha introducido un Id de Botón válido");
        }

        return salida;
    }

    public static EIDANSWER getById(int id) {
        EIDANSWER salida;
        switch (id){
            case 0: salida= A;
                break;
            case 1: salida= B;
                break;
            case 2: salida= C;
                break;
            case 3: salida= D;
                break;
            default: throw new RuntimeException("No se ha introducido un Id Botón válido");
        }

        return salida;
    }
}
