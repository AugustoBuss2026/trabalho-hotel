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
            for (int f = 0; f < ca.quartoAssociado.size(); f++) {
                if (ca.quartoAssociado.get(f) != null) {
                    JOptionPane.showMessageDialog(null, ca.quartoAssociado.get(f));
                    JOptionPane.showMessageDialog(null, ca.reservaH.get(f));

                }
            }
        }
    }
        void ConsultaQuarto () {
            for (i = 0; i < ca.nomeQuarto.size(); i++) {
                JOptionPane.showMessageDialog(null, ca.nomeQuarto.get(i));
                if (ca.ocupado.get(i) == true) {
                    JOptionPane.showMessageDialog(null, "Quarto ocupado");
                }
                if (ca.danificado.get(i) == true) {
                    JOptionPane.showMessageDialog(null, "Quarto danificado");
                }
                for (int f = 0; f < ca.clienteAssociado.size(); f++) {
                    if (ca.clienteAssociado.get(f) != null) {
                        JOptionPane.showMessageDialog(null, ca.clienteAssociado.get(f));
                        JOptionPane.showMessageDialog(null, ca.reservaQ.get(f));
                    }
                }
            }
        }
}
