
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        GerenciadorSocios g = new GerenciadorSocios();
        g.lerDados();
        Scanner leitor = new Scanner(System.in);
        int opcao = 0;
        // do while para as opções
        do {
            System.out.println("1. Cadastrar\n2. Pesquisar\n3. Relatorio\n4. Sair\n5. Remover Sócio");
            opcao = leitor.nextInt();
            leitor.nextLine();
            switch (opcao) {
                case 1:
                    System.out.println("Digite o nome do Sócio: ");
                    String n = leitor.nextLine();

                    System.out.println("Digite a idade do Sócio: ");
                    int i = leitor.nextInt();

                    System.out.println("Digite a mensalidade do Sócio: ");
                    double v = leitor.nextDouble();
                    leitor.nextLine();
                    System.out.println("Digite se deve mensalidade, sim ou não: ");
                    String sn = leitor.nextLine();
                    boolean s= sn.equalsIgnoreCase("sim");
                    Socios novo = new Socios(n, i, v, s);
                    g.getEstante().add(novo);
                    g.salvarDados();
                    break;
                case 2:
                    g.procurar();
                    break;
                case 3:
                    g.mediaeDevendo();
                    break;
                case 4:
                    System.out.println("Saindo...");
                    System.exit(0);
                    break;
                case 5:
                    g.remover();
                    break;
            }
        } while (opcao != 5);
        leitor.close();
    }


    }
