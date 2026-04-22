package Sócios;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ArrayList<Socios> estante = new ArrayList<>();
        Scanner leitor = new Scanner(System.in);
        int somaIdade = 0;
        int media;
        int devendo = 0;
;        String resposta = "Sim";
// Onde vamos receber as informações
while (resposta.equalsIgnoreCase("Sim")) {
    System.out.println("Digite o nome do Sócio: ");
    String n = leitor.nextLine();

    System.out.println("Digite a idade do Sócio: ");
    int i = leitor.nextInt();

    System.out.println("Digite a mensalidade do Sócio: ");
    double v = leitor.nextDouble();

    System.out.println("Digite true se deve mensalidade: ");
    boolean s = leitor.nextBoolean();

    Socios novo = new Socios(n, i, v, s);

    estante.add(novo);

    somaIdade += novo.getIdade();
    if (novo.getestaIdiplente()) {
        devendo++;
    }

    leitor.nextLine();
    System.out.println("Deseja continuar: ");
    resposta = leitor.nextLine();
}
        // Calculo da média
        media= somaIdade/ estante.size();
        System.out.println("Média das idades: " + media);
        
        System.out.println("Sócios devendo: " + devendo);

        System.out.println("Sócios Cadastrados: ");

        // Verificação de Sócio VIP
        for(Socios j :  estante){
        if(j.getIdade()>18 && j.getvalorMensalidade()>100){
        double novoValor = j.getvalorMensalidade() * 0.90; 
        j.setvalorMensalidade(novoValor);
    
    System.out.println("Sócio " + j.getnome() + " agora é VIP!");        
}
        // Verificação de Sócio KID
        if(j.getIdade()<12){
            String tag= "[KIDS]" + j.getnome();
            j.setnome(tag);
        }
        // Sócios na terceira idade que devem mensalidade
        if(j.getIdade()>60 && j.getestaIdiplente()==true){
            System.out.println("Ligar para a cobrança prioritária: " + j.getnome());
        }
            if (j.getestaIdiplente() == true) {
                j.aplicarMulta();
            }
            j.exibirInformacoes();

        }
        // Escrevendo no arquivo .txt
        try {
    java.io.PrintWriter escritor = new java.io.PrintWriter("socios.txt");
    for (Socios s : estante) {
        escritor.println("Sócio: " + s.getnome() + " | Mensalidade: " + s.getvalorMensalidade());
    }
    escritor.close();
    System.out.println("Arquivo salvo com sucesso!");
} catch (java.io.FileNotFoundException e) {
    System.out.println("Erro ao criar o arquivo.");
}
        leitor.close();
    }

}