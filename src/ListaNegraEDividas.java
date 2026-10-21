import javax.swing.*;

public class ListaNegraEDividas {
    Cadastro ca;

    ListaNegraEDividas(Cadastro ca) {
        this.ca = ca;
    }

    String procuraronme, pps, motivo, procurardivida;
    Integer m, t, decidir;
    int conta;

    void ListaNegra() {
        conta = -1;
        do {
            procuraronme = JOptionPane.showInputDialog("Qual é o CPF do cliente a entrar na lista negra");
            if (procuraronme == null){
                return;
            }
        } while (procuraronme.isEmpty());
        for (m = 0; m < ca.nome.size(); m++) {
            if (procuraronme.equals(ca.cpf.get(m)) && ca.listaNegra.get(m) == false) {
                do {
                    motivo = JOptionPane.showInputDialog("Qual é o motivo");
                    if (motivo == null){
                        return;
                    }
                } while (motivo.isEmpty());
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
            if (procuraronme == null){
                return;
            }
        } while (procuraronme.isEmpty());

        for (m = 0; m < ca.cpf.size(); m++) {
            if (procuraronme.equals(ca.cpf.get(m)) && ca.devendo.get(m) == true) {
                do{
                    conta = 0;
                    procurardivida = JOptionPane.showInputDialog("Qual a divída");
                    if (procurardivida == null){
                        return;
                    }
                    for (t = 0; t < ca.nomeDivida.get(m).size(); t++){
                        if (procurardivida.equalsIgnoreCase(ca.nomeDivida.get(m).get(t))){
                            conta = t;
                        }
                    }
                    if (conta == -1){
                        JOptionPane.showMessageDialog(null, "Divída não encontrada");
                        break;
                    }
                }while (procurardivida.isEmpty());
                JOptionPane.showMessageDialog(null, ca.nome.get(m) + " dividado em " + ca.divida.get(m).get(conta));
                do {
                    pps = JOptionPane.showInputDialog("[1]Prosseguir\n[2]Desistir do pagamento");
                    if (pps == null){
                        return;
                    }
                    decidir = Integer.parseInt(pps);
                    switch (decidir) {
                        case 1:
                            JOptionPane.showMessageDialog(null, "Divída paga");
                            ca.divida.get(m).remove(conta);
                            if (ca.divida.get(m).get(1) == null) {
                                ca.devendo.set(m, false);
                            }else {
                                JOptionPane.showMessageDialog(null, "Hospede ainda tem divídas");
                            }
                            return;
                        case 2:
                            return;
                        default:
                            JOptionPane.showMessageDialog(null, "Digite entre 1 e 2");
                    }
                } while (pps.isEmpty() || Integer.parseInt(pps) != 1 && Integer.parseInt(pps) != 2);
                JOptionPane.showMessageDialog(null, "Cliente não encontrado");
            }
        }
    }
}