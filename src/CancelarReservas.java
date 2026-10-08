import javax.swing.*;

public class CancelarReservas {
    Cadastro ca;

    CancelarReservas(Cadastro ca) {
        this.ca= ca;
    }

    String procurarCancelamentoNome, procurarCancelamentoQuarto, texto;
    int p, k, z, t, contar, contar2;

    void CR() {
        texto= "";
        contar = -1;
        contar2 = -1;
        do {
            procurarCancelamentoNome = JOptionPane.showInputDialog("Qual o CPF do hospede quer cancelar");
            if (procurarCancelamentoNome == null){
                return;
            }
        }while (procurarCancelamentoNome.isEmpty());
        for(p= 0; p< ca.nome.size(); p++) {
            if(procurarCancelamentoNome.equals(ca.cpf.get(p))) {
                for(z= 0; z< ca.quartoAssociado.get(p).size(); z++) {
                    texto += ca.quartoAssociado.get(p).get(z) + "\n";
                }
                if(texto.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Nenhum quarto associado ao cliente");
                    return;
                }
                JOptionPane.showMessageDialog(null, "Quartos associados:\n"+ texto);
                do {
                    procurarCancelamentoQuarto = JOptionPane.showInputDialog("Qual quarto a ser cancelado");
                    if (procurarCancelamentoQuarto == null){
                        return;
                    }
                }while(procurarCancelamentoQuarto.isEmpty());
                for(t= 0; t< ca.quartoAssociado.get(p).size(); t++) {
                    if(ca.quartoAssociado.get(p).get(t).equalsIgnoreCase(procurarCancelamentoQuarto)) {
                        contar= t;
                    }
                }

                for(k= 0; k< ca.nomeQuarto.size(); k++) {
                    if(procurarCancelamentoQuarto.equals(ca.nomeQuarto.get(k))) {
                        for(t= 0; t< ca.clienteAssociado.get(k).size(); t++) {
                            if(ca.clienteAssociado.get(k).get(t).equalsIgnoreCase(procurarCancelamentoNome)) {
                                contar2= t;
                            }
                        }
                        if (contar == -1 || contar2 == -1){
                            JOptionPane.showMessageDialog(null, "Reserva não encontrada");
                            return;
                        }
                        ca.quartoAssociado.get(p).remove(contar);
                        ca.cafe.get(p).remove(contar);
                        ca.massagem.get(p).remove(contar);
                        ca.data1.get(k).remove(contar2);
                        ca.data2.get(k).remove(contar2);
                        ca.horario1.get(k).remove(contar2);
                        ca.horario2.get(k).remove(contar2);
                        ca.fimLimpeza.get(k).remove(contar2);
                        ca.valorFinal.get(p).remove(contar);
                        ca.ocupado.set(k, !ca.data1.get(k).isEmpty());
                        ca.clienteAssociado.get(k).remove(contar2);
                        ca.reservaQ.get(k).remove(contar2);
                        ca.reservaH.get(p).remove(contar);
                        return;
                    }
                }
            }
        }
        JOptionPane.showMessageDialog(null, "Cliente não encontrados");
    }
}