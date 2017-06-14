package madik.com.br.quizxmr;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import static madik.com.br.quizxmr.R.id.progressBar;

public class MainActivity extends AppCompatActivity {

    final Handler handler =  new Handler();
    final ArrayAdapter adapter=null;
    final String msg_correta="Resposta correta.";
    final String msg_incorreta="ERROU!";
    public int contador=0;
    public int score=0;


   String question ="";
    String r1="";
    String r2="";
    String r3="";
    String r4="";
    String r5="";
    String r6="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button botao = (Button)findViewById(R.id.button);



        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                botao.setText("Próxima");
                callServer(null,null);
                contador++;

            }
        });

    }

    public void callServer(final String method, final String data){

        new Thread(){

            String[] arrayOpcoes = new String[6];
            boolean[] arrayBoolean = new boolean[6];
            int[]  arrayBooleano= new int[6]; // Para mysql
            @Override
            public void run(){

                    //String resposta=HttpConnection.getSetDataWeb("http://192.168.1.85:8080/questions/"+contador,"GET",data);
                    //String resposta=HttpConnection.getSetDataWeb("http://192.168.1.85:8080/quizxmr/conexao?vetor="+contador,"GET",data);
                String resposta=HttpConnection.getSetDataWeb("http://transvinicexpress.com/quizxmr/conexao.php?vetor="+contador,"GET",data);


                try {
                    //Para ws em php
                    JSONArray jsonArray = new JSONArray("["+resposta+"]");

                    //Para ws em spring
                    //JSONArray jsonArray = new JSONArray(resposta);

                      //for (int i=0;i<jsonArray.length();i++){
                      JSONObject jsonObject = jsonArray.getJSONObject(0);

                    question = (String)jsonObject.get("question");

                    arrayOpcoes[0] = (String)jsonObject.get("r1");
                    arrayOpcoes[1] = (String)jsonObject.get("r2");
                    arrayOpcoes[2] = (String)jsonObject.get("r3");
                    arrayOpcoes[3] = (String)jsonObject.get("r4");
                    arrayOpcoes[4] = (String)jsonObject.get("r5");
                    arrayOpcoes[5] = (String)jsonObject.get("r6");

                    /* só funciona campos boolean
                    arrayBoolean[0] = jsonObject.getBoolean("r1bool");
                    arrayBoolean[1] = jsonObject.getBoolean("r2bool");
                    arrayBoolean[2] = jsonObject.getBoolean("r3bool");
                    arrayBoolean[3] = jsonObject.getBoolean("r4bool");
                    arrayBoolean[4] = jsonObject.getBoolean("r5bool");
                    arrayBoolean[5] = jsonObject.getBoolean("r6bool");
                    */

                    //para mysql
                    arrayBooleano[0] = jsonObject.getInt("r1bool");
                    arrayBooleano[1] = jsonObject.getInt("r2bool");
                    arrayBooleano[2] = jsonObject.getInt("r3bool");
                    arrayBooleano[3] = jsonObject.getInt("r4bool");
                    arrayBooleano[4] = jsonObject.getInt("r5bool");
                    arrayBooleano[5] = jsonObject.getInt("r6bool");

                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            ListView listview = (ListView)findViewById(R.id.opcoes);
                            final ArrayAdapter<String> adapter = new ArrayAdapter<String>( getBaseContext(),android.R.layout.simple_selectable_list_item,arrayOpcoes);

                            final TextView text = (TextView)findViewById(R.id.txt1);
                            text.setText(question);
                            listview.setAdapter(adapter);

                            TextView text_score = (TextView)findViewById(R.id.txt_score);
                            text_score.setText("SCORE: "+score);

                            ProgressBar progressbar = (ProgressBar)findViewById(progressBar);
                            progressbar.setMax(100);

                            float progress= (float) contador/16;
                            int progress2= Math.round(progress*100);
                            progressbar.setProgress(progress2);

                            listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {


                                @Override
                                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                                    //Se o indice da opçao selecionada for igual a zero
                                    if(adapter.getItemId(position)==0){

                                        //verifica o valor do indice zero do array de respostas.
                                        if(arrayBooleano[0]==1 ){
                                            score++;
                                            Toast.makeText(MainActivity.this, msg_correta, Toast.LENGTH_SHORT).show();
                                        }else{
                                            Toast.makeText(MainActivity.this, msg_incorreta, Toast.LENGTH_SHORT).show();
                                        }
                                    }

                                    if(adapter.getItemId(position)==1){
                                        if(arrayBooleano[1]==1){
                                            score++;
                                            Toast.makeText(MainActivity.this, msg_correta, Toast.LENGTH_SHORT).show();

                                        }else{
                                            Toast.makeText(MainActivity.this, msg_incorreta, Toast.LENGTH_SHORT).show();
                                        }
                                    }


                                    if(adapter.getItemId(position)==2){

                                        if(arrayBooleano[2]==1){
                                            score++;
                                            Toast.makeText(MainActivity.this, msg_correta, Toast.LENGTH_SHORT).show();

                                        }else{
                                            Toast.makeText(MainActivity.this, msg_incorreta, Toast.LENGTH_SHORT).show();
                                        }
                                    }


                                    if(adapter.getItemId(position)==3){

                                        if(arrayBooleano[3]==1){
                                            score++;
                                            Toast.makeText(MainActivity.this, msg_correta, Toast.LENGTH_SHORT).show();
                                        }else{
                                            Toast.makeText(MainActivity.this, msg_incorreta, Toast.LENGTH_SHORT).show();
                                        }
                                    }

                                    if(adapter.getItemId(position)==4){
                                        if(arrayBooleano[4]==1){
                                            score++;
                                            Toast.makeText(MainActivity.this, msg_correta, Toast.LENGTH_SHORT).show();
                                        }else{
                                            Toast.makeText(MainActivity.this, msg_incorreta, Toast.LENGTH_SHORT).show();
                                        }
                                    }

                                    if(adapter.getItemId(position)==5){
                                        if(arrayBooleano[5]==1){
                                            score++;
                                            Toast.makeText(MainActivity.this, msg_correta, Toast.LENGTH_SHORT).show();
                                        }else{
                                            Toast.makeText(MainActivity.this, msg_incorreta, Toast.LENGTH_SHORT).show();
                                        }
                                    }

                                }
                            } );


                        }
                    });

                    //}

                }catch (JSONException e){}
            }
        }.start();

    }

    private String generateJson(Questions questions){
        String answer="";
        JSONObject jo = new JSONObject();
        JSONArray je = new JSONArray();

        try {
            jo.put("id",questions.getId());
            jo.put("Question",questions.getQuestion());
            jo.put("opt1",questions.getR1());
            jo.put("opt2",questions.getR2());
            jo.put("opt3",questions.getR3());
            jo.put("opt4",questions.getR4());
            jo.put("opt5",questions.getR5());
            je.put(jo);
        }
        catch (JSONException ex){ ex.printStackTrace();  }
        return jo.toString();
    }

}