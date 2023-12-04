package br.com.alura.screenmatch.modelos;

public class TituloOmdb {
    private final String title;
    private final String year;
    private final String runtime;
    public TituloOmdb(String title, String year,String runtime) {
        this.title = title;
        this.year = year;
        this.runtime = runtime;
        // Inicialize outros atributos, se houver
    }
    public String getTitle() {
        return title;
    }

    public String getYear() {
        return year;
    }

    public String getRuntime() {
        return runtime;
    }

    @Override
    public String toString() {
        return "Titulo = " + title +
                ", Ano = " + year +
                ", runtime = " + runtime;
    }
}
