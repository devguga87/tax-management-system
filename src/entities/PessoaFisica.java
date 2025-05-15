package entities;

public class PessoaFisica extends Contribuinte{
    private Double gastosSaude;

    public PessoaFisica(){
        super();
    }

    public PessoaFisica(String nome, Double rendaAnual, Double gastosSaude){
        super(nome, rendaAnual);
        this.gastosSaude = gastosSaude;
    }

    public Double getGastosSaude(){
        return gastosSaude;
    }

    public void setGastosSaude(Double gastosSaude){
        this.gastosSaude = gastosSaude;
    }

    @Override
    public Double totalImposto() {
        double imposto = 0.0;
        if(rendaAnual < 20000.00){
            imposto = rendaAnual * .15;
        } else {
            imposto = rendaAnual * .25;
        }

        if(gastosSaude != 0.0){
            imposto -= (gastosSaude * .5);
        }
        return imposto;
    }
}
