import javax.swing.*;
import java.time.LocalDate;
import java.time.LocalTime;

public class CheckOUT {
    String cpfConfirmar, quartoConfirmar, passarinf;
    int i, f, contar1, contar2, numeros;
    Cadastro ca;

    CheckOUT(Cadastro ca) {
        this.ca = ca;
    }

    void CheckOut() {
        do {
            contar1 = -1;
            cpfConfirmar = JOptionPane.showInputDialog("Coloque o CPF do hospede");
            if (cpfConfirmar == null) {
                return;
            }
            if (cpfConfirmar.length() != 11) {
                JOptionPane.showMessageDialog(null, "O CPF deve ter 11 caracteres");
            }
            if (!cpfConfirmar.matches("\\d+")) {
                JOptionPane.showMessageDialog(null, "Não use caracteres além de números, nosso sistema já formata-rá o CPF");
            }
            if (cpfConfirmar.isEmpty()) {
                break;
            }
            for (i = 0; i < ca.cpf.size(); i++) {
                if (!ca.reservaandamentoH.get(i)) {
                    JOptionPane.showMessageDialog(null, "Reserva não está em andamento");
                    break;
                }
                if (cpfConfirmar.equals(ca.cpf.get(i).replaceAll("\\D", ""))) {
                    contar1 = i;
                }
            }
            if (contar1 == -1) {
                JOptionPane.showMessageDialog(null, "cpf não cadastrado em nosso sistema");
                break;
            }
        } while (cpfConfirmar.length() != 11 || !cpfConfirmar.matches("\\d+"));
        do {
            contar2 = -1;
            quartoConfirmar = JOptionPane.showInputDialog("Coloque o número do quarto");
            if (quartoConfirmar == null) {
                return;
            }
            if (quartoConfirmar.length() != 3) {
                JOptionPane.showMessageDialog(null, "Número de quarto deve conter 3 dígitos");
                continue;
            }
            if (!quartoConfirmar.matches("\\d+")) {
                JOptionPane.showMessageDialog(null, "O nome do quarto deve conter apenas números");
                continue;
            }
            for (i = 0; i < ca.nomeQuarto.size(); i++) {
                if (!ca.reservaandammentoQ.get(i)) {
                    JOptionPane.showMessageDialog(null, "Reserva do quarto não está em andamento não está em andamento");
                    break;
                }
                if (quartoConfirmar.equals(ca.nomeQuarto.get(i))) {
                    for (f = 0; f < ca.quartoAssociado.size(); f++) {
                        if (LocalDate.now().isBefore(ca.data1.get(i).get(f)) && LocalDate.now().isAfter(ca.data2.get(i).get(f))) {
                            JOptionPane.showMessageDialog(null, "Data de reserva incompátivel");
                            return;
                        } else if (LocalTime.now().isBefore(ca.horario1.get(i).get(f)) && LocalTime.now().isAfter(ca.horario2.get(i).get(f))) {
                            JOptionPane.showMessageDialog(null, "Horário de reserva incompátivel");
                            return;
                        } else {
                            contar2 = i;
                            ca.reservaandamentoH.set(i, false);
                            ca.reservaandammentoQ.set(i, false);
                            ca.quartoAssociado.get(i).remove(contar1);
                            ca.cafe.get(i).remove(contar1);
                            ca.massagem.get(i).remove(contar1);
                            ca.data1.get(f).remove(contar2);
                            ca.data2.get(f).remove(contar2);
                            ca.horario1.get(f).remove(contar2);
                            ca.horario2.get(f).remove(contar2);
                            ca.valorFinal.get(i).remove(contar1);
                            ca.ocupado.set(f, !ca.data1.get(f).isEmpty());
                            ca.clienteAssociado.get(f).remove(contar2);
                            ca.reservaQ.get(f).remove(contar2);
                            ca.reservaH.get(i).remove(contar1);
                        }
                    }
                }
            }
            if (contar2 == -1) {
                JOptionPane.showMessageDialog(null, "Reserva inexistente");
                break;
            }
        } while (quartoConfirmar.length() != 3 || !quartoConfirmar.matches("\\d+"));
        if (ca.pagamentoadiado.get(contar1)) {
            do {
                passarinf = JOptionPane.showInputDialog("Valor total: "+ ca.valorFinal.get(contar1)+".\nQual a forma de Pagamento\n[1]PIX\n[2]Débito\n[3]Crédito\n[4]Dinheiro");
            } while (passarinf == null || passarinf.isEmpty() || Integer.parseInt(passarinf) != 1 && Integer.parseInt(passarinf) != 2 && Integer.parseInt(passarinf) != 3 && Integer.parseInt(passarinf) != 4 && Integer.parseInt(passarinf) != 0);
            numeros = Integer.parseInt(passarinf);
            if (numeros == 1) {
                ca.formaDePagamento.set(i, "PIX");
                JOptionPane.showMessageDialog(null, "Hospedagem paga com PIX");
            } else if (numeros == 2) {
                ca.formaDePagamento.set(i, "Débito");
                JOptionPane.showMessageDialog(null, "Hospedagem paga com débito");
            } else if (numeros == 3) {
                ca.formaDePagamento.set(i, "Crédito");
                JOptionPane.showMessageDialog(null, "Hospedagem paga com crédito");
            } else if (numeros == 4) {
                ca.formaDePagamento.set(i, "Dinheiro");
                JOptionPane.showMessageDialog(null, "Hospedagem paga em dinheiro");
            }
        }
    }
}
