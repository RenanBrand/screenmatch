package br.com.alura.screenmatch.modelos;

import br.com.alura.screenmatch.excecao.ErroConversaoAnoException;
import com.google.gson.annotations.SerializedName;

public class Titulo implements Comparable<Titulo> {
    @SerializedName("Title")
    private String nome;
    @SerializedName("Year")
    private int anoDeLancamento;
    private boolean incluidoNoPlano;
    private double somaDasAvaliacoes;
    private int totalDeAvaliacao;
    private int duracaoEmMinutos;

    public Titulo(TituloOmdb meuTituloOmdb) {
        this.nome = meuTituloOmdb.getTitle();
        if(meuTituloOmdb.getYear().length() > 4){
            throw new ErroConversaoAnoException("Não consegui converter o ano " + meuTituloOmdb.getYear()+ " porque tem mais de 4 caracteres.");
        }
        this.anoDeLancamento = Integer.parseInt(meuTituloOmdb.getYear());
        this.duracaoEmMinutos = Integer.parseInt(meuTituloOmdb.getRuntime().substring(0,3).replace(" ",""));
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setAnoDeLancamento(int anoDeLancamento) {
        this.anoDeLancamento = anoDeLancamento;
    }

    public void setDuracaoEmMinutos(int duracaoEmMinutos) {
        this.duracaoEmMinutos = duracaoEmMinutos;
    }
    public void setIncluidoNoPlano(boolean incluidoNoPlano) {
        this.incluidoNoPlano = incluidoNoPlano;
    }
    public String getNome() {
        return nome;
    }

    public int getAnoDeLancamento() {
        return anoDeLancamento;
    }

    public int getDuracaoEmMinutos() {
        return duracaoEmMinutos;
    }
    public boolean getIncluidoNoPlano() {
        return this.incluidoNoPlano;
    }
    public int getTotalDeAvaliacao(){
        return totalDeAvaliacao;
    }
    public void exibeFichaTecnica(){
        System.out.println("Nome do filme: "+ nome);
        System.out.println("Ano de Lançamento: "+ anoDeLancamento);
    }

    public void avalia(double nota){
        somaDasAvaliacoes += nota;
        totalDeAvaliacao++;
    }
    public double mediaAvalicacao(){
        return somaDasAvaliacoes / totalDeAvaliacao;
    }

    @Override
    public int compareTo(Titulo outroTitulo) {
        return this.getNome().compareTo(outroTitulo.getNome());
    }

    @Override
    public String toString() {
        return "Nome = " + nome + ", Ano de lançamento = " + anoDeLancamento + ", Tempo de duração = "+ duracaoEmMinutos;
    }
}
