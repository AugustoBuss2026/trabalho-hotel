import javax.swing.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Cadastro {
    ArrayList<String> nome = new ArrayList<>();
    ArrayList<String> cpf = new ArrayList<>();
    ArrayList<String> formaDePagamento = new ArrayList<>();
    ArrayList<Integer> idade = new ArrayList<>();
    ArrayList<Boolean> devendo = new ArrayList<>();
    ArrayList<ArrayList<String>> quartoAssociado = new ArrayList<>();
    ArrayList<Boolean> listaNegra = new ArrayList<>();
    ArrayList<ArrayList<Boolean>> cafe = new ArrayList<>();
    ArrayList<ArrayList<Boolean>> massagem = new ArrayList<>();
    ArrayList<ArrayList<String>> reservaH = new ArrayList<>();
    ArrayList<String> motivo = new ArrayList<>();
    ArrayList<Double> divida = new ArrayList<>();

    ArrayList<ArrayList<LocalTime>> horario1 = new ArrayList<>();
    ArrayList<ArrayList<LocalTime>> horario2 = new ArrayList<>();
    ArrayList<String> nomeQuarto = new ArrayList<>();
    ArrayList<String> qualidade = new ArrayList<>();
    ArrayList<Boolean> danificado = new ArrayList<>();
    ArrayList<Boolean> ocupado = new ArrayList<>();
    ArrayList<Double> valorD = new ArrayList<>();
    ArrayList<Integer> qthospede = new ArrayList<>();
    ArrayList<ArrayList<LocalDate>> data1 = new ArrayList<>();
    ArrayList<ArrayList<LocalDate>> data2 = new ArrayList<>();
    ArrayList<ArrayList<Double>> valorFinal = new ArrayList<>();
    ArrayList<ArrayList<String>> reservaQ = new ArrayList<>();
    ArrayList<ArrayList<String>> clienteAssociado = new ArrayList<>();
    ArrayList<ArrayList<LocalTime>> fimLimpeza = new ArrayList<>();
    Integer selecionar, i;
    String transferidor, cpfinserir, passarquarto, passarnome;
    Boolean cpfexistente, quartoexistente;

    void cadastroCliente() {
        do{
            passarnome = JOptionPane.showInputDialog("Coloque o nome do hospede");
            if (passarnome == null){
                return;
            }
        }while (passarnome.isEmpty());
        do {
            cpfexistente = false;
            cpfinserir = JOptionPane.showInputDialog("Coloque o CPF do hospede");
            if (cpfinserir == null) {
                return;
            }
            if (cpfinserir.length() != 11) {
                JOptionPane.showMessageDialog(null, "O CPF deve ter 11 caracteres");
                continue;
            }
            if (!cpfinserir.matches("\\d+")) {
                JOptionPane.showMessageDialog(null, "Não use caracteres além de números, nosso sistema já formata-rá o CPF");
                continue;
            }
            for (i = 0; i < cpf.size(); i++) {
                if (cpfinserir.equals(cpf.get(i))) {
                    JOptionPane.showMessageDialog(null, "cpf já existente");
                    cpfexistente = true;
                    break;
                }
            }
        } while (cpfinserir.isEmpty() || cpfexistente || cpfinserir.length() != 11 || !cpfinserir.matches("\\d+"));
        do {
            transferidor = JOptionPane.showInputDialog("Coloque a idade do hospede");
            if (Integer.parseInt(transferidor) < 18){
                JOptionPane.showMessageDialog(null, "Não cadastramos menores de idade");
            }
            if (transferidor == null){
                return;
            }
        } while (transferidor.isEmpty() || Integer.parseInt(transferidor) < 18);
        cpf.add(cpfinserir);
        nome.add(passarnome);
        idade.add(Integer.parseInt(transferidor));
        formaDePagamento.add(null);
        quartoAssociado.add(new ArrayList<>());
        listaNegra.add(false);
        devendo.add(false);
        cafe.add(new ArrayList<>());
        massagem.add(new ArrayList<>());
        valorFinal.add(new ArrayList<>());
        reservaH.add(new ArrayList<>());
        motivo.add(null);
        divida.add(0.0);

    }

    void cadastroQuarto() {
        do {
            quartoexistente = false;
            passarquarto = JOptionPane.showInputDialog("Coloque o número do quarto");
            if (passarquarto == null) {
                return;
            }
            if (passarquarto.length() != 3) {
                JOptionPane.showMessageDialog(null, "Número de quarto deve conter 3 dígitos");
                continue;
            }
            if (!passarquarto.matches("\\d+")) {
                JOptionPane.showMessageDialog(null, "O nome do quarto deve conter apenas números");
                continue;
            }
            for (i = 0; i < nomeQuarto.size(); i++) {
                if (passarquarto.equals(nomeQuarto.get(i))) {
                    JOptionPane.showMessageDialog(null, "Quarto já existente");
                    quartoexistente = true;
                    break;
                }
            }
        } while (passarquarto.isEmpty() || quartoexistente || passarquarto.length() != 3 || !passarquarto.matches("\\d+"));
        do {
            transferidor = JOptionPane.showInputDialog("Qual a qualidade de quarto?\n[1]Standard\n[2]Deluxe\n[3]Suíte Júnior\n[4]Suíte Master\n[5]Suíte Presidencial");
            if (transferidor == null){
                return;
            }
        } while (transferidor.isEmpty() || Integer.parseInt(transferidor) != 1 && Integer.parseInt(transferidor) != 2 && Integer.parseInt(transferidor) != 3 && Integer.parseInt(transferidor) != 4 && Integer.parseInt(transferidor) != 5);
        selecionar = Integer.parseInt(transferidor);
        if (selecionar == 1) {
            qualidade.add("Standart");
            valorD.add(300.0);
        } else if (selecionar == 2) {
            qualidade.add("Deluxe");
            valorD.add(500.0);
        } else if (selecionar == 3) {
            qualidade.add("Suíte Júnior");
            valorD.add(725.0);
        } else if (selecionar == 4) {
            qualidade.add("Suíte Master");
            valorD.add(1200.0);
        } else if (selecionar == 5) {
            qualidade.add("Suíte Presidencial");
            valorD.add(3500.0);
        }
        do {
            transferidor = JOptionPane.showInputDialog("Quantos hospedes cabem no quarto?");
        } while (transferidor == null);
        nomeQuarto.add(passarquarto);
        qthospede.add(Integer.parseInt(transferidor));
        danificado.add(false);
        ocupado.add(false);
        data1.add(new ArrayList<>());
        data2.add(new ArrayList<>());
        reservaQ.add(new ArrayList<>());
        clienteAssociado.add(new ArrayList<>());
        horario1.add(new ArrayList<>());
        horario2.add(new ArrayList<>());
        fimLimpeza.add(new ArrayList<>());
    }
}