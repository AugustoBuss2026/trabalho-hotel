import javax.swing.*;
import java.time.LocalDate;
import java.time.LocalTime;

public class CheckIN {
    String cpfConfirmar, quartoConfirmar;
    int i, f, contar;
    Cadastro ca;

    CheckIN(Cadastro ca) {
        this.ca = ca;
    }

    void CheckIn() {
        do {
            contar = -1;
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
                if (ca.reservaandamentoH.get(i)) {
                    JOptionPane.showMessageDialog(null, "Reserva já em andamento");
                    break;
                }
                if (cpfConfirmar.equals(ca.cpf.get(i).replaceAll("\\D", ""))) {
                    contar = i;
                }
            }
            if (contar == -1) {
                JOptionPane.showMessageDialog(null, "cpf não cadastrado em nosso sistema");
                break;
            }
        } while (cpfConfirmar.length() != 11 || !cpfConfirmar.matches("\\d+"));
        do {
            contar = -1;
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
                if (ca.reservaandammentoQ.get(i)) {
                    JOptionPane.showMessageDialog(null, "Reserva já em andamento");
                    break;
                }
                if (quartoConfirmar.equals(ca.nomeQuarto.get(i))) {
                    for (f = 0; f < ca.quartoAssociado.size(); f++) {
                        if (LocalDate.now().isBefore(ca.data1.get(i).get(f)) && LocalDate.now().isAfter(ca.data2.get(i).get(f))) {
                            JOptionPane.showMessageDialog(null, "Data de reserva imcompátivel");
                            return;
                        }else if (LocalTime.now().isBefore(ca.horario1.get(i).get(f)) && LocalTime.now().isAfter(ca.horario2.get(i).get(f))){
                            JOptionPane.showMessageDialog(null, "Horário de reserva imcompátivel");
                            return;
                        }else{
                            contar = i;
                            ca.reservaandamentoH.set(i, true);
                            ca.reservaandammentoQ.set(i, true);
                        }
                    }
                }
            }
            if (contar == -1) {
                JOptionPane.showMessageDialog(null, "Reserva inexistente");
                break;
            }
        } while (quartoConfirmar.length() != 3 || !quartoConfirmar.matches("\\d+"));
    }
}
