package SistemaBancario;

public class CuentaCorriente extends CuentaBancaria{
    private double comisionPorTransaccion;
    private double limiteSobregiro;   // monto máximo que puede quedar en negativo

    public CuentaCorriente(String numeroCuenta, String titular, double saldo,
                           double comisionPorTransaccion, double limiteSobregiro) {
        super(numeroCuenta, titular, saldo);
        this.comisionPorTransaccion = comisionPorTransaccion;
        this.limiteSobregiro        = limiteSobregiro;
    }

    @Override
    public String describir() {
        return super.describir() + " | Comisión por transacción: $" + comisionPorTransaccion;
    }

    @Override
    public double calcularComision() {
        return comisionPorTransaccion;
    }

    // Sobreescritura: valida límite de sobregiro antes de retirar
    @Override
    public void realizarRetiro(double monto) {
        double saldoResultante = getSaldo() - monto - comisionPorTransaccion;

        if (saldoResultante < -limiteSobregiro) {
            System.out.println("Retiro no posible: superaría el límite de sobregiro de $"
                    + limiteSobregiro);
        } else {
            setSaldo(saldoResultante);
        }
    }

}
