package juego.taes.domainmodel.Model.Cliente;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

import juego.taes.domainmodel.Data.Dao.BDPreguntasDao;
import juego.taes.domainmodel.Data.Dao.PreguntaDao;

/**
 * Created by felix on 22-4-2015.
 */

@DatabaseTable(tableName = "pregunta", daoClass = PreguntaDao.class)
public class Pregunta {

    //Nombres de las columnas
    public static final String ID="_id";
    public static final String CONTENIDO="contenido";
    public static final String ENSERVIDOR="en_servidor";
    public static final String IDSINCRONIZACION="id_sincronizacion";
    public static final String FECHASINCRONIZACION="fecha_sincronizacion";
    public static final String MODIFICADODESDEULTIMASINCRONIZACION="modificado";

    //Relaciones
    public static final String RESPUESTA_CORRECTA="fk_respuesta_correcta";
    public static final String RESPUESTAS="fk_respuestas";
    public static final String BD="fk_bd_preguntas";

    //Atributos de la base de datos
    @DatabaseField(columnName=ID, generatedId = true, useGetSet = true)
    private int id;

    @DatabaseField(columnName=CONTENIDO, canBeNull=false, useGetSet = true)
    private String contenido;

    @DatabaseField(columnName= ENSERVIDOR, canBeNull = false, defaultValue="false", useGetSet = true)
    private boolean enServidor;

    @DatabaseField(columnName= IDSINCRONIZACION, unique = true, useGetSet = true)
    private int idSincronizacion;

    @DatabaseField(columnName= FECHASINCRONIZACION, useGetSet = true)
    private Date fechaSincronizacion;

    @DatabaseField(columnName = MODIFICADODESDEULTIMASINCRONIZACION, useGetSet = true)
    private boolean modificadoDesdeUltimaSincronizacion;

    //Relaciones
    @DatabaseField(columnName = BD,useGetSet = true, foreign = true, canBeNull = false)
    private BDPreguntas bdPreguntas;

    @DatabaseField(columnName = RESPUESTA_CORRECTA, foreign = true, canBeNull = false, useGetSet = true)
    private Respuesta respuestaCorrecta;

    @ForeignCollectionField(eager=false, foreignFieldName = "respuestas", columnName = RESPUESTAS)
    private ForeignCollection<Respuesta> respuestas;

    public Pregunta() {
        // ORMLite needs a no-arg constructor
    }

    public Pregunta(String contenido, boolean enServidor) {
        this.contenido = contenido;
        this.enServidor = enServidor;
    }

    public boolean isModificadoDesdeUltimaSincronizacion() {
        return modificadoDesdeUltimaSincronizacion;
    }

    public void setModificadoDesdeUltimaSincronizacion(boolean modificadoDesdeUltimaSincronizacion) {
        this.modificadoDesdeUltimaSincronizacion = modificadoDesdeUltimaSincronizacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public boolean isEnServidor() {
        return enServidor;
    }

    public void setEnServidor(boolean enServidor) {
        this.enServidor = enServidor;
    }

    public int getIdSincronizacion() {
        return idSincronizacion;
    }

    public void setIdSincronizacion(int idSincronizacion) {
        this.idSincronizacion = idSincronizacion;
    }

    public Date getFechaSincronizacion() {
        return fechaSincronizacion;
    }

    public void setFechaSincronizacion(Date fechaSincronizacion) {
        this.fechaSincronizacion = fechaSincronizacion;
    }

    public Respuesta getRespuestaCorrecta() {
        return respuestaCorrecta;
    }

    public void setRespuestaCorrecta(Respuesta respuestaCorrecta) {
        this.respuestaCorrecta = respuestaCorrecta;
    }

    public ForeignCollection<Respuesta> getRespuestas() {
        return respuestas;
    }

    public void setRespuestas(ForeignCollection<Respuesta> respuestas) {
        this.respuestas = respuestas;
    }

    public BDPreguntas getBdPreguntas() {
        return bdPreguntas;
    }

    public void setBdPreguntas(BDPreguntas bdPreguntas) {
        this.bdPreguntas = bdPreguntas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pregunta)) return false;

        Pregunta pregunta = (Pregunta) o;

        if (id != pregunta.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id;
    }
}