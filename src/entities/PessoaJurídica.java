package entities;


public class PessoaJurídica extends Contribuinte {
    private Integer numeroFuncionarios;

    public PessoaJurídica(){
        super();
    }

    public PessoaJurídica(String nome, Double rendaAnual, int numeroFuncionarios){
        super(nome, rendaAnual);
        this.numeroFuncionarios = numeroFuncionarios;
    }

    public int getNumeroFuncionarios(){
        return numeroFuncionarios;
    }

    public void setNumeroFuncionarios(int numeroFuncionarios){
        this.numeroFuncionarios = numeroFuncionarios;
    }

    @Override
    public Double totalImposto() {
        double imposto = 0.0;
        if(numeroFuncionarios > 10){
            imposto = rendaAnual * .14;
        } else {
            imposto = rendaAnual * .16;
        }

        return imposto;
    }
}
