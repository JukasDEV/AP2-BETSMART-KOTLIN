package com.example.betsmart;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.ImageView;

public class TelaFinal extends Activity {

    private ProgressBar loadingProgressBar;
    private EditText editTextEmail;
    private TextView textViewRecomendacao;
    private TextView textViewMensagem;
    private ImageView imageViewRoletinha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_final);

        editTextEmail = findViewById(R.id.editTextEmail);
        loadingProgressBar = findViewById(R.id.loadingProgressBar);
        textViewRecomendacao = findViewById(R.id.textViewRecomendacao);
        textViewMensagem = findViewById(R.id.textViewMensagem);
        imageViewRoletinha = findViewById(R.id.imageViewRoletinha);

        // Oculta o email, a imagem e os textos inicialmente
        editTextEmail.setVisibility(View.INVISIBLE);
        imageViewRoletinha.setVisibility(View.INVISIBLE);
        textViewRecomendacao.setVisibility(View.INVISIBLE);
        textViewMensagem.setVisibility(View.INVISIBLE);

        // Simula um processo de carregamento com uma pausa de 2 segundos
        showLoading();
        new Handler().postDelayed(() -> {
            hideLoading();
            // Agora você pode verificar as respostas salvas e tomar decisões com base nelas
            verificarRespostas();
        }, 2000);
    }

    private void showLoading() {
        loadingProgressBar.setVisibility(ProgressBar.VISIBLE);
    }

    private void hideLoading() {
        loadingProgressBar.setVisibility(ProgressBar.GONE);
        // Exibe o email, a imagem e os textos agora que o loading está concluído
        editTextEmail.setVisibility(View.VISIBLE);
        imageViewRoletinha.setVisibility(View.VISIBLE);
        textViewRecomendacao.setVisibility(View.VISIBLE);
        textViewMensagem.setVisibility(View.VISIBLE);
    }

    private void verificarRespostas() {
        Intent intent = getIntent();
        if (intent != null) {
            String resposta = intent.getStringExtra("resposta");
            Log.d("Resposta", "Resposta recebida: " + resposta);

            // Verifica o valor da resposta e fornece recomendações com base nela
            if ("Opção 1 selecionada".equals(resposta)) {
                exibirImagemETexto(R.drawable.futebol, "Recomendo o mercado de apostas esportivas. Você é uma pessoa focada e fria, que não se deixa levar por ganância.");
            } else if ("Opção 2 selecionada".equals(resposta)) {
                exibirImagemETexto(R.drawable.roletinha, "Recomendo o mercado de cassino. Você busca dinheiro e é empenhado com a gestão.");
            } else if ("Opção 3 selecionada".equals(resposta)) {
                exibirImagemETexto(R.drawable.psiquiatra, "Recomendo procurar um psiquiatra. Você parece ser muito ganancioso, e isso pode não ser saudável para apostas.");
                // Se a opção 3 for selecionada, oculta o EditText e a mensagem
                ocultarInputEmailEMensagem();
            } else {
                exibirImagemETexto(R.drawable.psiquiatra, "Recomendo o mercado de apostas esportivas. Você é uma pessoa focada e fria, que não se deixa levar por ganância.");
                // Adicione mais casos conforme necessário
            }
        }
    }

    private void ocultarInputEmailEMensagem() {
        editTextEmail.setVisibility(View.GONE);
        textViewMensagem.setVisibility(View.GONE);
    }

    private void exibirImagemETexto(int resourceId, String recomendacao) {
        Log.d("Imagem e Texto", "Exibindo imagem e texto: " + resourceId + ", " + recomendacao);
        exibirImagemRoletinha(resourceId);
        exibirRecomendacao(recomendacao);
        exibirMensagem("Obrigado Por chegar até o final, estarei disponibilizando um Ebook e um grupo de dicas. Insira seu E-mail abaixo.");
    }


    private void exibirRecomendacao(String recomendacao) {
        textViewRecomendacao.setText(recomendacao);
        // Aqui você pode adicionar mais lógica com base nas respostas, se necessário
    }

    private void exibirMensagem(String mensagem) {
        textViewMensagem.setText(mensagem);
        // Aqui você pode adicionar mais lógica com base nas respostas, se necessário
    }

    private void exibirImagemRoletinha(int resourceId) {
        // Carrega a imagem "roletinha.png" usando o recurso de ID
        imageViewRoletinha.setImageResource(resourceId);
    }

    private void mostrarInputEmail() {
        // Aqui você pode adicionar lógica para exibir um formulário de email
        // ou fazer qualquer outra coisa relacionada ao caso em que a pessoa é conservadora
        textViewMensagem.setText("Preencha o formulário de email para receber o ebook");
    }
}
