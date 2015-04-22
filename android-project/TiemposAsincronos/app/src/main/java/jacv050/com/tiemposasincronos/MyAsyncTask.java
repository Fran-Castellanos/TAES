package jacv050.com.tiemposasincronos;

import android.os.AsyncTask;
import android.widget.TextView;

public class MyAsyncTask extends AsyncTask<Void, String, Void> {
    private TextView txt;

    public MyAsyncTask(TextView txtView){
        txt=txtView;
    }

    @Override
    protected void onProgressUpdate(String... values) {
        txt.setText(values[0]);
    }

    @Override
    protected Void doInBackground(Void... params) {
        while(true){
            publishProgress(Integer.toString(Integer.parseInt(txt.getText().toString())+1));
            try {
                if(isCancelled())
                    break;

                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return null;
    }
}
