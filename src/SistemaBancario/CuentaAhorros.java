package SistemaBancario;

public class CuentaAhorros extends CuentaBancaria{
    private double tasaInteresMensual;
    private double saldoMinimo;

    public CuentaAhorros(String numeroCuenta, String titular, double saldo,
                         double tasaInteresMensual, double saldoMinimo) {
        super(numeroCuenta, titular, saldo);
        this.tasaInteresMensual = tasaInteresMensual;
        this.saldoMinimo        = saldoMinimo;
    }

    // Sobreescritura: extiende la descripción del padre
    @Override
    public String describir() {
        return super.describir() + " | Tasa mensual: " + tasaInteresMensual + "%";
    }

    // Sobreescritura: comisión solo si el saldo baja del mínimo
    @Override
    public double calcularComision() {
        return getSaldo() >= saldoMinimo ? 0.0 : 12000.0;
    }

    // Sobrecarga: retiro urgente descuenta comisión automáticamente si baja del mínimo
    public void realizarRetiro(double monto, boolean esUrgente) {
        super.realizarRetiro(monto);                         // descuenta el monto
        if (esUrgente && getSaldo() < saldoMinimo) {
            setSaldo(getSaldo() - calcularComision());       // descuenta la comisión
        }
    }

    // Interés del mes sobre el saldo actual
    public double calcularInteresDelMes() {
        return getSaldo() * tasaInteresMensual / 100;
    }

}
