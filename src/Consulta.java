import javax.swing.*;

public class Consulta {
    int i, f;
    Cadastro ca;

    Consulta(Cadastro ca) {
        this.ca = ca;
    }

    void ConsultaCliente() {
        for (i = 0; i < ca.nome.size(); i++) {
            JOptionPane.showMessageDialog(null, ca.nome.get(i) + "\nIdade: " + ca.idade.get(i));
            if (ca.listaNegra.get(i) == true) {
                JOptionPane.showMessageDialog(null, "Hospede na lista negra");
            }
            if (ca.devendo.get(i) == true) {
                JOptionPane.showMessageDialog(null, "Cliente dividado");
            }
            JOptionPane.showMessageDialog(null, "Quartos de reserva do cliente:");
            if (ca.quartoAssociado.get(i) != null) {
                JOptionPane.showMessageDialog(null, ca.quartoAssociado.get(i));
                JOptionPane.showMessageDialog(null, ca.reservaH.get(i));
            }
        }
    }

    void ConsultaQuarto() {
        for (i = 0; i < ca.nomeQuarto.size(); i++) {
            JOptionPane.showMessageDialog(null, ca.nomeQuarto.get(i));
            if (ca.ocupado.get(i) == true) {
                JOptionPane.showMessageDialog(null, "Quarto ocupado");
            }
            if (ca.danificado.get(i) == true) {
                JOptionPane.showMessageDialog(null, "Quarto danificado");
            }
            if (ca.clienteAssociado.get(i) != null) {
                JOptionPane.showMessageDialog(null, ca.clienteAssociado.get(i));
                JOptionPane.showMessageDialog(null, ca.reservaQ.get(i));
            }
        }
    }
}
