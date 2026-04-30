package SistemaBancario;

public class CuentaInversion extends CuentaBancaria{
    private double tasaAnual;
    private int    plazoMeses;
    private double penalizacionRetiroAnticipado;

    public CuentaInversion(String numeroCuenta, String titular, double saldo,
                           double tasaAnual, int plazoMeses,
                           double penalizacionRetiroAnticipado) {
        super(numeroCuenta, titular, saldo);
        this.tasaAnual                    = tasaAnual;
        this.plazoMeses                   = plazoMeses;
        this.penalizacionRetiroAnticipado = penalizacionRetiroAnticipado;
    }

    @Override
    public String describir() {
        return super.describir()
                + " | Plazo: " + plazoMeses + " meses"
                + " · Tasa anual: " + tasaAnual + "%";
    }

    // Sobreescritura: siempre devuelve la penalización
    @Override
    public double calcularComision() {
        return penalizacionRetiroAnticipado;
    }

    // Sobrecarga: sin penalización si ya se cumplió el plazo
    public double calcularComision(int mesesTranscurridos) {
        return mesesTranscurridos >= plazoMeses ? 0.0 : penalizacionRetiroAnticipado;
    }

    // Sobreescritura: siempre descuenta monto + penalización
    @Override
    public void realizarRetiro(double monto) {
        setSaldo(getSaldo() - monto - penalizacionRetiroAnticipado);
    }

}
