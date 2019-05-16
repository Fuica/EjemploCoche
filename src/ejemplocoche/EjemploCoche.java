package ejemplocoche;

class coche {
    //Atributos

    private int velocidad;
    private String color;
    private boolean arrancado;
    private String marca;
    private String modelo;
    private float potencia;
    private motor m;

    private static int num_coches = 0;

    //Metodos
    //Constructor por defecto o predeterminado
    coche() {
        velocidad = 0;
        color = "Desconocido";
        arrancado = false;
        marca = "Desconocida";
        modelo = "Desconocido";
        potencia = 0;
        m = motor();

        //Esto se ha modificado
        num_coches = num_coches + 1;
    }

    //Constructor de copia
    coche(coche c) {
        velocidad = c.velocidad;
        color = c.color;
        arrancado = c.arrancado;
        marca = c.marca;
        modelo = c.modelo;
        potencia = c.potencia;
        m = new motor(c.get_motor());

        num_coches++;
    }

    //Constructor de inicializacion 1
    coche(int v, String c, boolean a, String ma, String mo, float p, motor m) {
        velocidad = v;
        this.color = c;
        this.arrancado = a;
        this.marca = ma;
        this.modelo = mo;
        this.potencia = (float) m.getPotencia();
        this.m = m;

        num_coches++;
    }

    //Constructor de inicializacion 2
    coche(int v, String c, boolean a, String ma, String mo, float p, double potencia, double cilindrada) {
        this.velocidad = v;
        this.color = c;
        this.arrancado = a;
        this.marca = ma;
        this.modelo = mo;
        this.potencia = p;

        this.m = new motor(potencia, cilindrada);

        num_coches++;
    }

    //Asigno una velocidad al coche
    public void set_velocidad(int v) {
        this.velocidad = v;
    }
    //Devuelvo la velocidad del coche

    public int get_velocidad() {
       return this.velocidad;
        
    }

    //Setter para el atributo color
    public void set_color(String c) {
        this.color = c;
    }

    public String get_color() {
        return color;
    }

    public void set_arrancado(boolean a) {
        arrancado = a;
    }

    public boolean get_arrancado() {
        return arrancado;
    }

    public void set_marca(String ma) {
        marca = ma;
    }

    public String get_marca() {
        return marca;
    }

    public void set_modelo(String mo) {
        modelo = mo;
    }

    public String get_modelo() {
        return modelo;
    }

    public void set_potencia(float p) {
        potencia = p;
    }

    public float get_potencia() {
        return potencia;
    }

    public void acelerar(int v) {
        velocidad = velocidad + v;
    }

    public void frenar(int v) {
        velocidad = velocidad - v;
    }

    public static int get_num_coches() {
        return num_coches;
    }

    public motor get_motor() {
        return m;
    }

    public void set_motor(motor m) {
        this.m = m;
    }

    public void print_coche() {
        System.out.println("******************");
        System.out.println("Marca: " + get_marca());
        System.out.println("Modelo: " + get_modelo());
        System.out.println("Potencia: " + get_potencia());
        System.out.println("Color: " + get_color());
        System.out.println("Velocidad: " + get_velocidad());
        System.out.println("Arrancado: " + get_arrancado());

        System.out.println("****** MOTOR *******");
        m.print_motor();
    }
}

public class EjemploCoche {

    public static void main(String[] args) {
        coche c1 = new coche();

        motor m = new motor(120, 2000);
        coche c2 = new coche(120, "Rojo", true, "Ford", "Fiesta", 100, m);

        coche c3 = new coche(110, "Azul", true, "Opel", "Vectra", 100, 140, 1800);

        c1.print_coche();
        //Lectura de valores para c1
        c1.set_arrancado(true);
        c1.set_color("Azul");
        c1.set_modelo("Ford");

        c1.print_coche();

        c2.print_coche();

        System.out.println("Numero de coches creados accediendo desde un objeto: " + c1.get_num_coches());
        System.out.println("Numero de coches creados accediendo desde la clase: " + coche.get_num_coches());

        c2.frenar(30);

        c2.print_coche();

        //Asignamos la velocidad de c1 a c2
        c2.set_velocidad(c1.get_velocidad());

        //Asignar un motor al coche c1
        c1.set_motor(m);

        //Queremos que el coche c3 tenga el mismo motor que el coche c2
        c3.set_motor(c2.get_motor());

        System.out.println("Coche 1: " + c1.toString());
        System.out.println("Coche 2: " + c2.toString());
        System.out.println("Coche 3: " + c3.toString());

        //Copia en superficie
        //Puntero tipo coche que apunta a un objeto coche ya existente
        //Puedo modificar c2 desde c4 porque realmente son el mismo objeto
        coche c4;
        c4 = c2;

        System.out.println("Coche 2: " + c2.toString());
        System.out.println("Coche 4: " + c4.toString());

        c4.set_potencia(150);
        System.out.println("Potencia del coche 2: " + c2.get_potencia());

        //Copia en profundidad del objeto coche c2 en nuevo objeto coche c5
        coche c5 = new coche(c2);

        System.out.println("Coche 2: " + c2.toString());
        System.out.println("Coche 5: " + c5.toString());

        c5.set_marca("Opel");
        System.out.println("Marca del coche 5: " + c5.get_marca());
        System.out.println("Marca del coche 2: " + c2.get_marca());

        //Prueba de metodo equals. Compara en superficie
        if (c4.equals(c2)) {
            System.out.println("Los objetos c4 y c2 son iguales");
        }

        coche c6 = new coche(110, "Azul", true, "Opel", "Vectra", 100, 140, 1800);
        coche c7 = new coche(110, "Azul", true, "Opel", "Vectra", 100, 140, 1800);

        if (c7.equals(c6)) {
            System.out.println("Los objetos c4 y c2 son iguales");
        }

        //Acceso al metodo estatico numero de coches
        System.out.println("Numero de coches: " + coche.get_num_coches());
        System.out.println("Numero de coches: " + c1.get_num_coches());
        System.out.println("Numero de coches: " + c2.get_num_coches());
        System.out.println("Numero de coches: " + c3.get_num_coches());

    }
}
