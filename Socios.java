package Sócios;

public class Socios {
    private String nome;
    private int idade;
    private double valorMensalidade;
    private boolean estaIndiplente = false;
    
    // Metódo para aplicar informações recebidas
    public Socios(String nome, int idade, double valorMensalidade, boolean estaIndiplente) {
        this.nome = nome;
        this.setIdade(idade); 
        this.setvalorMensalidade(valorMensalidade); 
        this.setestaIndiplente(estaIndiplente); 
    }
     
    // Getters e Setters

    public void setestaIndiplente(boolean estaIndiplente){
    this.estaIndiplente = estaIndiplente;

    if(this.estaIndiplente == true){ 
        aplicarMulta();
    }
    }
    

    public boolean getestaIdiplente(){
        return this.estaIndiplente;
    }

    public void setvalorMensalidade(double valorMensalidade){
        if(valorMensalidade<0){
            System.out.println("Mensalidade não pode ser negativa ou zero!! ");
            System.exit(0);
        }else{
            this.valorMensalidade = valorMensalidade;
        }
    }

    public double getvalorMensalidade(){
        return this.valorMensalidade;
    }

    public void setIdade(int idade){
        if(idade==0 || idade>120){
            System.out.println("Idade Irreal!!");
            System.exit(0);
        } else{
            this.idade= idade;
        }
    }

    public int getIdade(){
        return this.idade;
    }

    public void setnome(String nome){
        this.nome= nome;
    }

    public String getnome(){
        return this.nome;
    }
    
    // Metódo para plicar multa
    public void aplicarMulta(){
        valorMensalidade = valorMensalidade + (valorMensalidade * 0.05);
    }

    //Método para exibir informações
    public void exibirInformacoes(){
        System.out.println("Nome: " + nome);
        System.out.println("Mensalidade atual: " +valorMensalidade);
    }
}
