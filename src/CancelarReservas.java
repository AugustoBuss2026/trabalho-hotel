import javax.swing.*;
import java.time.LocalDate;

public class CancelarReservas {
    Cadastro ca = new Cadastro();
    String procurarCancelamentoNome, procurarCancelamentoQuarto, texto;
    int p, k;
    LocalDate d1D, d2D;

    void CR() {
        procurarCancelamentoNome = JOptionPane.showInputDialog("Qual hospede quer cancelar");
        for (p = 0; p < ca.nome.size(); p++) {
            if (procurarCancelamentoNome.equals(ca.nome.get(p))){
                JOptionPane.showMessageDialog(null, "Nenhum cliente com esse nome");
                return;
            }
            if (ca.quartoAssociado.get(p) != null) {
                texto += ca.quartoAssociado.get(p) + "\n";
            }
        }
        if (texto.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum quarto associado ao cliente");
            return;
        }
        JOptionPane.showMessageDialog(null, "Quartos associados: \n" + texto);
        procurarCancelamentoQuarto = JOptionPane.showInputDialog("Qual quarto a ser cancelado");
        for (k = 0; k < ca.nomeQuarto.size(); k++){
            if (procurarCancelamentoQuarto.equals(ca.quartoAssociado.get(k))){
                ca.quartoAssociado.set(k, null);
                ca.cafe.set(k, false);
                ca.massagem.set(k, false);
                ca.data1.set(k, null);
                ca.data2.set(k, null);
                ca.valorFinal.set(k, null);
                ca.devendo.set(k, false);
            }
        }
    }
}
