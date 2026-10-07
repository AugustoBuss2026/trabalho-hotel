import javax.swing.*;

public class ListaNegraEDividas {
    Cadastro ca;

    ListaNegraEDividas(Cadastro ca) {
        this.ca = ca;
    }

    String procuraronme, pps, motivo;
    Integer m, decidir;

    void ListaNegra() {
        do {
            procuraronme = JOptionPane.showInputDialog("Qual é o CPF do cliente a entrar na lista negra");
        } while (procuraronme == null);
        for (m = 0; m < ca.nome.size(); m++) {
            if (procuraronme.equals(ca.cpf.get(m)) && ca.listaNegra.get(m) == false) {
                do {
                    motivo = JOptionPane.showInputDialog("Qual é o motivo");
                } while (motivo == null);
                ca.motivo.set(m, motivo);
                JOptionPane.showMessageDialog(null, ca.nome.get(m) + " foi adicionado a lista negra por " + ca.motivo.get(m));
                ca.listaNegra.set(m, true);
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Cliente não encontrado");
    }

    void Divida() {
        do {
            procuraronme = JOptionPane.showInputDialog("Qual é o CPF do cliente dividado");
        } while (procuraronme == null);
        for (m = 0; m < ca.nome.size(); m++) {
            if (procuraronme.equals(ca.cpf.get(m)) && ca.devendo.get(m) == true) {
                JOptionPane.showMessageDialog(null, ca.nome.get(m) + " dividado em " + ca.divida.get(m));
                do {
                    pps = JOptionPane.showInputDialog("[1]Prosseguir\n[2]Desistir do pagamento");
                    decidir = Integer.parseInt(pps);
                    switch (decidir) {
                        case 1:
                            JOptionPane.showMessageDialog(null, "Divída paga");
                            ca.divida.set(m, 0.0);
                            ca.devendo.set(m, false);
                            return;
                        case 2:
                            return;
                        default:
                            JOptionPane.showMessageDialog(null, "Digite entre 1 e 2");
                    }
                } while (pps == null || Integer.parseInt(pps) != 1 && Integer.parseInt(pps) != 2);
                JOptionPane.showMessageDialog(null, "Cliente não encontrado");
            }
        }
    }
}