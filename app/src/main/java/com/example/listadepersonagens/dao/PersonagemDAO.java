package com.example.listadepersonagens.dao;

import com.example.listadepersonagens.model.Personagem;

import java.util.ArrayList;
import java.util.List;

public class PersonagemDAO {

    private  final  static List<Personagem> personagens = new ArrayList<>();

    private  static int contadorDeId = 1;

    //Salvando e colocando ID
    public void salva(Personagem personagemSalvo) {
        personagemSalvo.setId(contadorDeId);
        personagens.add(personagemSalvo);
        contadorDeId++;
    }

    //Editando os personagens
    public void edita(Personagem personagem){
        Personagem personagemEscolhido = null;
        for(Personagem p:
        personagens){
            if(p.getId() == personagem.getId()){
            personagemEscolhido = p;
            }
        }
        if(personagemEscolhido != null){
            int posicaoDoPersonagem = personagens.indexOf( personagemEscolhido );
            personagens.set( posicaoDoPersonagem,personagem );
        }
    }

    //Retornando TODOS personagens!!
    public List<Personagem> todos() {

        return  new ArrayList<>(personagens);
    }
}
