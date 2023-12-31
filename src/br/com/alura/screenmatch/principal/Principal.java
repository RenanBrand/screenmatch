package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.calculos.CalculadoraDeTempo;
import br.com.alura.screenmatch.calculos.FiltroRecomendacao;
import br.com.alura.screenmatch.modelos.Episodio;
import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Serie;
import br.com.alura.screenmatch.modelos.TituloOmdb;

import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {
        TituloOmdb meuTituloFilmeOmdb =new TituloOmdb("O poderoso chefão", "1970","160");
        TituloOmdb meuOutroTituloFilmeOmdb =new TituloOmdb("Dogville", "1970","160");
        Filme meuFilme = new Filme(meuTituloFilmeOmdb);
        meuFilme.setDuracaoEmMinutos(180);
        System.out.println("Duração: "+ meuFilme.getDuracaoEmMinutos());
        meuFilme.exibeFichaTecnica();
        meuFilme.avalia(8);
        meuFilme.avalia(5);
        meuFilme.avalia(10);
        System.out.println(meuFilme.mediaAvalicacao());
        System.out.println("total de avaliação:" + meuFilme.getTotalDeAvaliacao());
        TituloOmdb meuTituloOmdb =new TituloOmdb("Lost", "2000","60");

        Serie minhaSerie = new Serie(meuTituloOmdb);
        minhaSerie.setDuracaoEmMinutos(24);
        minhaSerie.exibeFichaTecnica();
        minhaSerie.setTemporadas(10);
        minhaSerie.setEpisodiosPorTemporada(10);
        minhaSerie.setMinutosPorEpisodio(50);
        System.out.println("Duração da serie: "+ minhaSerie.getDuracaoEmMinutos());

        CalculadoraDeTempo calculadora = new CalculadoraDeTempo();
        calculadora.inclui(meuFilme);
        calculadora.inclui(minhaSerie);
        System.out.println(calculadora.getTempoTotal());

        FiltroRecomendacao filtro = new FiltroRecomendacao();
        filtro.filtra(meuFilme);
        Episodio episodio = new Episodio();
        episodio.setNumero(1);
        episodio.setSerie(minhaSerie);
        episodio.setTotalVisualizacoes(300);
        filtro.filtra(episodio);
        filtro.filtra(episodio);

        var filmeDoPaulo = new Filme(meuOutroTituloFilmeOmdb);
        filmeDoPaulo.setDuracaoEmMinutos(200);
        filmeDoPaulo.avalia(10);

        ArrayList<Filme> listaDeFilmes = new ArrayList<>();
        listaDeFilmes.add(filmeDoPaulo);
        listaDeFilmes.add(meuFilme);
        System.out.println("Tamanho da lista " + listaDeFilmes.size());
        System.out.println("Primeiro filme " + listaDeFilmes.get(0).getNome());
        System.out.println(listaDeFilmes);
        System.out.println("toString do filme " + listaDeFilmes.get(0).toString());
    }
}