import java.util.ArrayList;
import java.io.PrintWriter;
import java.util.Scanner;


public class GerenciadorSocios {
    Scanner leitor = new Scanner(System.in);
    
    // Criando o Array List
    private ArrayList<Socios> estante = new ArrayList<>();

    public ArrayList<Socios> getEstante() {
        return estante;
    }
    // Método para ler dados
    public void lerDados(){
        try {
            java.io.File arquivo = new java.io.File("socios.txt");
            if (arquivo.exists()) {
                Scanner leitorArquivo = new Scanner(arquivo);

                while (leitorArquivo.hasNextLine()) {
                    String linha = leitorArquivo.nextLine();

                    String[] pedacos = linha.split(";");

                    String nome = pedacos[0];
                    int idade = Integer.parseInt(pedacos[1]);
                    double valor = Double.parseDouble(pedacos[2]);
                    boolean divida = Boolean.parseBoolean(pedacos[3]);

                    Socios s = new Socios(nome, idade, valor, divida);
                    estante.add(s);
                }
                leitorArquivo.close();
                System.out.println("Memória carregada!");
            }
        } catch (Exception e) {
            System.out.println("Ainda não há dados para carregar.");
        }
    }
    //Método para salvar os Dados
    public void salvarDados() {
        try {
            PrintWriter escritor = new PrintWriter("socios.txt");
            for (Socios s : estante) {
                escritor.println(s.getnome() + ";" + s.getIdade() + ";" +
                        s.getvalorMensalidade() + ";" + s.getestaIdiplente());
            }
            escritor.close();
            System.out.println("Arquivo atualizado!");
        } catch (Exception e) {
            System.out.println("Erro ao salvar dados.");
        }
    }

    // Método para o relatório
    public void mediaeDevendo() {
        if (estante.isEmpty()) {
            System.out.println("Lista vazia!");
            return;
        }
        int somaIdade = 0;
        int devendo = 0;
        for (Socios j : estante) {
            somaIdade += j.getIdade();
            if (j.getestaIdiplente())
                devendo++;
        }
        System.out.println("Média das idades: " + (somaIdade / estante.size()));
        System.out.println("Sócios devendo: " + devendo);
    }

    // Método para pesquisa
    public void procurar() {
        System.out.println("Digite o nome para busca: ");
        String busca = leitor.nextLine();
        boolean achou = false;
        for (Socios j : estante) {
            if (j.getnome().equalsIgnoreCase(busca)) {
                j.exibirInformacoes();
                achou = true;
            }
        }
        if (!achou) {
            System.out.println("Sócio não encontrado!");
        }
    }

    // Método para apagar um Sócio do .txt
    public void remover(){
                System.out.println("Digite o nome do Sócio: ");
                    String nome= leitor.nextLine();
                    Socios alvo = null;
                    for(Socios j: estante){
                        if(j.getnome().equalsIgnoreCase(nome)){
                            alvo = j;
                            break;
                        }
                    }
                    if(alvo !=null){
                        estante.remove(alvo);
                        salvarDados();
                        System.err.println("Sócio Removido.");
                    }else{
                        System.err.println("Sócio não encontrado.");
                    }
    }

}
