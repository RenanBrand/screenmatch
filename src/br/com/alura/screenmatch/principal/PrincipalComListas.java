package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Serie;
import br.com.alura.screenmatch.modelos.Titulo;
import br.com.alura.screenmatch.modelos.TituloOmdb;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class PrincipalComListas {
            public static void main(String[] args) {
                TituloOmdb meuTituloFilmeOmdb =new TituloOmdb("O poderoso chefão", "1970","160");
                TituloOmdb meuOutroTituloFilmeOmdb =new TituloOmdb("Dogville", "2003","160");
                TituloOmdb meuDoPauloTituloFilmeOmdb =new TituloOmdb("Avatar", "2023","180");
                Filme meuFilme = new Filme(meuTituloFilmeOmdb);
                meuFilme.avalia(9);
                Filme outroFilme = new Filme(meuOutroTituloFilmeOmdb);
                outroFilme.avalia(6);
                var filmeDoPaulo = new Filme(meuDoPauloTituloFilmeOmdb);
                filmeDoPaulo.avalia(10);
                TituloOmdb meuTituloOmdb =new TituloOmdb("Lost", "2000","60");
                Serie minhaSerie = new Serie(meuTituloOmdb);

                Filme f1 = filmeDoPaulo;

                ArrayList<Titulo> lista = new ArrayList<>();
                lista.add(filmeDoPaulo);
                lista.add(meuFilme);
                lista.add(outroFilme);
                lista.add(minhaSerie);
                for (Titulo item: lista) {
                    System.out.println(item.getNome());
                    if (item instanceof Filme && ((Filme) item).getClassificavel() > 2) {
                        Filme filme = (Filme) item;
                        System.out.println("Classificação " + filme.getClassificavel());
                    }
                }

                List<String> buscaPorArtista = new LinkedList<>();
                buscaPorArtista.add("Adam Sandler");
                buscaPorArtista.add("Paulo");
                buscaPorArtista.add("Jacqueline");
                System.out.println(buscaPorArtista);

                Collections.sort(buscaPorArtista);
                System.out.println("Depois da ordenação");
                System.out.println(buscaPorArtista);
                System.out.println("Lista de titulos ordenados");
                Collections.sort(lista);
                System.out.println(lista);
                lista.sort(Comparator.comparing(Titulo::getAnoDeLancamento));
                System.out.println("Ordenando por ano");
                System.out.println(lista);
    }
}
