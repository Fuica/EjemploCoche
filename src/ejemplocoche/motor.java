package ejemplocoche;

public class motor {
    //Atributos

    private double potencia;
    private double cilindrada;

    //Metodos
    //Constructor por defecto o predeterminado
    public motor() {
        potencia = 0;
        cilindrada = 0;
    }

    //Constructor de inicializacion
    public motor(double p, double c) {
        this.potencia = p;
        this.cilindrada = c;
    }

    //Constructor de copia
    public motor(motor m) {
        potencia = m.potencia;
        cilindrada = m.cilindrada;
    }

    public double getPotencia() {
        return potencia;
    }

    public void setPotencia(double potencia) {
        this.potencia = potencia;
    }

    public double getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(double cilindrada) {
        this.cilindrada = cilindrada;
    }
    
    public void print_motor() {
        System.out.println("******************");
        System.out.println("Potencia: " + getPotencia());
        System.out.println("Cilindrada: " + getCilindrada());
    }
}
