package br.com.senaijandira.jogodaforca;

import android.print.PrintAttributes;
import android.support.v4.view.MarginLayoutParamsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

//    Declaração dos elementos
    LinearLayout linear_botoes, linear_palavra;
    TextView txt_dica;
    Button[] arrayButton = new Button[26];
    String selecionada;
    TextView[] arrayTextView;
    String[] palavras = new String[] {"Amazonas", "São Paulo", "Minas Gerais"};

    View.OnClickListener listenerBtn = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Button btn = (Button) view;

            selecionada = palavras[new Random().nextInt(palavras.length)];
            txt_dica.setText(selecionada);

            btn.setEnabled(false);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        conectando com os elementos visuais do xml
        linear_botoes = (LinearLayout) findViewById(R.id.linear_botoes);
        linear_palavra = (LinearLayout) findViewById(R.id.linear_palavra);

        txt_dica = (TextView) findViewById(R.id.txt_dica);
//        vetor que contem os valores de cada botao(teclado)
        String[] letras = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

        selecionada = palavras[new Random().nextInt(palavras.length)];
        txt_dica.setText(selecionada);

//        criando as linhas de botoes
        LinearLayout linearBotoes1 = linearHorizontal();
        LinearLayout linearBotoes2 = linearHorizontal();
        LinearLayout linearBotoes3 = linearHorizontal();

//        loop para criar todos os botoes
        for(int i =0; i < arrayButton.length; i++) {
            arrayButton[i] = button();
        }

        int tamanhoPalavra = selecionada.length();

        for(int i =0; i < tamanhoPalavra; i++) {
            arrayTextView = new TextView[tamanhoPalavra];
            arrayTextView[i] = textView();
            linear_palavra.addView(arrayTextView[i]);
        }

//        loop para colocar as letras nos botoes da linha 1 e os adicionar na tela
        for(int i=0; i < 9; i ++){
            arrayButton[i].setText(letras[i]);
            linearBotoes1.addView(arrayButton[i]);
        }
//        loop para colocar as letras nos botoes da linha 2 e os adicionar na tela
        for(int i=9; i < 18; i ++){
            arrayButton[i].setText(letras[i]);
            linearBotoes2.addView(arrayButton[i]);
        }
//        loop para colocar as letras nos botoes da linha 3 e os adicionar na tela
        for(int i=18; i < 26; i ++){
            arrayButton[i].setText(letras[i]);
            linearBotoes3.addView(arrayButton[i]);
        }

//        adicionando as linhas de botoes em m linearLayout
        linear_botoes.addView(linearBotoes1);
        linear_botoes.addView(linearBotoes2);
        linear_botoes.addView(linearBotoes3);
    }

    //    Funçao para criar um linearLayout com orientação horizontal
    private LinearLayout linearHorizontal(){

        LinearLayout linear = new LinearLayout(this);
        linear.setOrientation(LinearLayout.HORIZONTAL);
        linear.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        linear.setGravity(Gravity.CENTER);

        return linear;
    }

    //    Funçao para criar um botão do jogo
    private  Button button(){

        Button btn =  new Button(this);
        btn.setText("-");
        btn.setTextSize(20);
        btn.setLayoutParams(new LinearLayout.LayoutParams(110, 110));
        btn.setOnClickListener(listenerBtn);

//        definindo o click do botao
        //btn.setOnClickListener();

        return btn;
    }

    private TextView textView(){

        TextView txt = new TextView(this);
        txt.setText("_");
        txt.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        txt.setTextColor(getResources().getColor(R.color.colorAccent));
        txt.setTextSize(15);
        txt.setPadding(5, 5,5,5);

        return txt;
    }
}
