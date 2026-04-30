package SistemaBancario;

public class main {
    public static void main (String[] args){
        // Variables de tipo padre que guardan instancias de distintas hijas
        CuentaBancaria cuentaAhorros   = new CuentaAhorros(
                "AH-001", "Laura Gómez", 2_000_000, 0.8, 500_000);

        CuentaBancaria cuentaCorriente = new CuentaCorriente(
                "CC-002", "Empresa XYZ", 5_000_000, 15_000, 1_000_000);

        CuentaBancaria cuentaInversion = new CuentaInversion(
                "INV-003", "Carlos Ríos", 10_000_000, 12.5, 12, 250_000);

        CuentaBancaria[] cuentas = {cuentaAhorros, cuentaCorriente, cuentaInversion};

        // --- describir() ---
        System.out.println("===== DESCRIPCIÓN DE CUENTAS =====");
        for (CuentaBancaria c : cuentas) {
            System.out.println(c.describir());   // Java ejecuta la versión correcta de cada hija
        }

        // --- calcularComision() ---
        System.out.println("\n===== COMISIONES =====");
        for (CuentaBancaria c : cuentas) {
            System.out.println(c.getNumeroCuenta()
                    + " → Comisión: $" + c.calcularComision());
        }

        // --- realizarRetiro(500_000) ---
        System.out.println("\n===== RETIRO DE $500.000 =====");
        for (CuentaBancaria c : cuentas) {
            c.realizarRetiro(500_000);
            System.out.println(c.getNumeroCuenta()
                    + " → Saldo resultante: $" + c.getSaldo());

        }
    }
}
