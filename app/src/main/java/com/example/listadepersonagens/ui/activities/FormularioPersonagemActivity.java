package com.example.listadepersonagens.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.listadepersonagens.R;
import com.example.listadepersonagens.dao.PersonagemDAO;
import com.example.listadepersonagens.model.Personagem;

public class FormularioPersonagemActivity extends AppCompatActivity {

    //Stats dos personagens
    private EditText campoNome;
    private EditText campoAltura;
    private EditText campoNascimento;

    //permite o dao por fora
    private final PersonagemDAO dao = new PersonagemDAO();

    private Personagem Personagem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_formulario_personagem );

        setTitle( "Formulário de Personagens" );
        inicializacaoCampos();

        configuraBotao();

        //Jogando os dados correspondentes ao personagens
        Intent dados = getIntent();
        if(dados.hasExtra("personagem")) {
            Personagem personagem = (Personagem) dados.getSerializableExtra("personagem");
            campoNome.setText(personagem.getNome());
            campoAltura.setText(personagem.getAltura());
            campoNascimento.setText(personagem.getNascimento());
        } else {
            Personagem = new Personagem();
        }
    }

    //Função do botão
    private void configuraBotao() {
        Button botaoSalvar = findViewById(R.id.button_salvar);

        botaoSalvar.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nome = campoNome.getText().toString();
                String altura = campoAltura.getText().toString();
                String nascimento = campoNascimento.getText().toString();

                //Construtor + função de salvar
                Personagem personagemSalvo = new Personagem(nome, altura, nascimento);
                dao.salva(personagemSalvo);
                finish();

                //Setando os valores
                personagemSalvo.setNome( nome );
                personagemSalvo.setAltura( altura );
                personagemSalvo.setNascimento( nascimento );
                dao.edita( personagemSalvo );
            }
        });
    }

    //Puxando os campos pelo ID
    private void inicializacaoCampos() {
        campoNome = findViewById( R.id.editText_nome );
        campoAltura = findViewById( R.id.editText_altura);
        campoNascimento = findViewById( R.id.editText_nascimento);

    }
}