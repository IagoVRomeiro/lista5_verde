import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.io.EOFException;
import java.io.FileNotFoundException;

class ArquivoTextoLeitura {

	public BufferedReader entrada;
	
	ArquivoTextoLeitura(String nomeArquivo) {	
		
		try {
			entrada = new BufferedReader(new FileReader(nomeArquivo));
		}
		catch (FileNotFoundException excecao) {
			System.out.println("Arquivo nao encontrado");
		}
	}
	
	public void fecharArquivo() {
		
		try {
			entrada.close();
		}
		catch (IOException excecao) {
			System.out.println("Erro no fechamento do arquivo de leitura: " + excecao);	
		}
	}
	
	@SuppressWarnings("finally")
	public String ler() {
		
		String textoEntrada = null;
		
		try {
			textoEntrada = entrada.readLine();
		}
		catch (EOFException excecao) { //Excecao de final de arquivo.
			textoEntrada = null;
		}
		catch (IOException excecao) {
			System.out.println("Erro de leitura: " + excecao);
			textoEntrada = null;
		}
		finally {
			return textoEntrada;
		}
	}
}
class Jogo {
    private int rank;
    private String nomeJogo;
    private String plataforma;
    private int ano;
    private String genero;
    private String editora;
    private double NA_Vendas;
    private double EU_Vendas;
    private double JP_Vendas;
    private double Outras_Vendas;
    private double Vendas_Global;
    

    public Jogo(int rank, String nomeJogo, String plataforma, int ano, String genero, String editora, double NA_Vendas,
            double EU_Vendas, double JP_Vendas, double Outras_Vendas, double Vendas_Global) {
        this.rank = rank;
        this.nomeJogo = nomeJogo;
        this.plataforma = plataforma;
        this.ano = ano;
        this.genero = genero;
        this.editora = editora;
        this.NA_Vendas = NA_Vendas;
        this.EU_Vendas = EU_Vendas;
        this.JP_Vendas = JP_Vendas;
        this.Outras_Vendas = Outras_Vendas;
        this.Vendas_Global = Vendas_Global;
    }

    public Jogo(String nomeJogo, String plataforma, int ano) {
        this.nomeJogo = nomeJogo;
        this.plataforma = plataforma;
        this.ano = ano;
    }

    public Jogo() {
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getNomeDoJogo() {
        return nomeJogo;
    }

    public void setNomeDoJogo(String nomeDoJogo) {
        this.nomeJogo = nomeDoJogo;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public double getNA_Vendas() {
        return NA_Vendas;
    }

    public void setNA_Vendas(double NA_Vendas) {
        this.NA_Vendas = NA_Vendas;
    }

    public double getEU_Vendas() {
        return EU_Vendas;
    }

    public void setEU_Vendas(double EU_Vendas) {
        this.EU_Vendas = EU_Vendas;
    }

    public double getJP_Vendas() {
        return JP_Vendas;
    }

    public void setJP_Vendas(double JP_Vendas) {
        this.JP_Vendas = JP_Vendas;
    }

    public double getOutras_Vendas() {
        return Outras_Vendas;
    }

    public void setOutras_Vendas(double Outras_Vendas) {
        this.Outras_Vendas = Outras_Vendas;
    }

    public double getVendas_Global() {
        return Vendas_Global;
    }

    public void setVendas_Global(double Vendas_Global) {
        this.Vendas_Global = Vendas_Global;
    }

    public Jogo clone() {
        return new Jogo(this.rank, this.nomeJogo, this.plataforma, this.ano, this.genero, this.editora, this.NA_Vendas,
                this.EU_Vendas, this.JP_Vendas, this.Outras_Vendas, this.Vendas_Global);
    }

    public void ler(String Dados) {
        String[] dados = Dados.split("\\|");
        this.rank = Integer.parseInt(dados[0]);
        this.nomeJogo = dados[1];
        this.plataforma = dados[2];
        this.ano = Integer.parseInt(dados[3]);
        this.genero = dados[4];
        this.editora = dados[5];
        this.NA_Vendas = Double.parseDouble(dados[6]);
        this.EU_Vendas = Double.parseDouble(dados[7]);
        this.JP_Vendas = Double.parseDouble(dados[8]);
        this.Outras_Vendas = Double.parseDouble(dados[9]);
        this.Vendas_Global = Double.parseDouble(dados[10]);

    }

    public void imprimir() {
        System.out.println(this);
    }

    public String toString() {
        return nomeJogo + ". " + plataforma + ". " + editora + ". " + ano + ". Vendas global: " + Vendas_Global + ". ";
    }
}

public class lista5Leitura {
    public static void main(String[] args) {
        ArrayList<Jogo> jogos = new ArrayList<>();

        ArquivoTextoLeitura txt = new ArquivoTextoLeitura("/tmp/jogos.txt");

        String linha = txt.ler();
        int qtdJogoInput=0, qtdEncontrado=0;

        while (linha != null) {

            Jogo jogo = new Jogo();
            jogo.ler(linha);
            jogos.add(jogo);
            linha = txt.ler();
        }

            linha = MyIO.readLine();
        while (!linha.equals("FIM")) {
            String[] info = linha.split(";");
            String nomeDoJogo = info[0];
            int ano = Integer.parseInt(info[1]);
            String editora = info[2];
            String plataforma = info[3];

            for (Jogo jogo : jogos) {
                if (jogo.getNomeDoJogo().equals(nomeDoJogo) && jogo.getAno() == ano && jogo.getEditora().equals(editora)
                        && jogo.getPlataforma().equals(plataforma)) {
                    MyIO.println(jogo.toString());
                    qtdEncontrado++;
                    break;
                }
            }
            qtdJogoInput++;
            linha = MyIO.readLine();
        }

        MyIO.println("Quantidade de jogos não encontrados: " + (qtdJogoInput - qtdEncontrado));
    }

}
