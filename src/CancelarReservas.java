import javax.swing.*;
import java.time.LocalDate;

public class CancelarReservas {
    Cadastro ca;

    CancelarReservas(Cadastro ca) {
        this.ca = ca;
    }

    String procurarCancelamentoNome, procurarCancelamentoQuarto, texto;
    int p, k;
    LocalDate d1D, d2D;

    void CR() {
        texto = "";
        procurarCancelamentoNome = JOptionPane.showInputDialog("Qual hospede quer cancelar");
        for (p = 0; p < ca.nome.size(); p++) {
            if (procurarCancelamentoNome.equals(ca.nome.get(p))) {
                if (ca.quartoAssociado.get(p) != null) {
                    texto += ca.quartoAssociado.get(p) + "\n";
                }
                if (texto.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Nenhum quarto associado ao cliente");
                    return;
                }
                JOptionPane.showMessageDialog(null, "Quartos associados: \n" + texto);
                procurarCancelamentoQuarto = JOptionPane.showInputDialog("Qual quarto a ser cancelado");
                for (k = 0; k < ca.nomeQuarto.size(); k++) {
                    if (procurarCancelamentoQuarto.equals(ca.nomeQuarto.get(k))) {
                        ca.quartoAssociado.set(p, null);
                        ca.cafe.set(p, false);
                        ca.massagem.set(p, false);
                        ca.data1.set(k, null);
                        ca.data2.set(k, null);
                        ca.valorFinal.set(p, null);
                        ca.devendo.set(p, false);
                        ca.ocupado.set(k, false);
                        ca.clienteAssociado.set(k, null);
                        ca.reservaQ.set(k, null);
                    }
                }
            }else {
                JOptionPane.showMessageDialog(null, "Cliente não encontrado");
                return;
            }
        }
    }
}
