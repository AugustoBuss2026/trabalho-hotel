import javax.swing.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
/*
Um hotel deseja desenvolver um sistema para controlar seus hóspedes, quartos e reservas.
O hotel possui diversos quartos, que podem apresentar diferentes capacidades e valores de diária. Por exemplo, alguns quartos podem acomodar duas pessoas enquanto outros podem acomodar uma quantidade maior de hóspedes.
Os hóspedes poderão realizar reservas informando o período em que pretendem permanecer no hotel.
Uma das principais necessidades do sistema é evitar que um mesmo quarto seja reservado para duas pessoas diferentes durante períodos que se sobreponham.
Ao realizar uma reserva, o sistema deverá registrar o hóspede, o quarto escolhido e as datas de entrada e saída.
Com base nessas datas, o sistema deverá calcular a quantidade de diárias e, posteriormente, o valor total da hospedagem.
Funcionalidades esperadas
Cadastro de hóspedes.
Cadastro de quartos.
Registro da capacidade do quarto.
Registro do valor da diária.
Criação de reservas.
Associação de reservas a hóspedes.
Associação de reservas a quartos.
Registro das datas de entrada e saída.
Cálculo da quantidade de diárias.
Cálculo do valor total.
Consulta das reservas de um hóspede.
Consulta das reservas de um quarto.
Cancelamento de reservas.
Pontos importantes
Um hóspede pode realizar várias reservas.
Um quarto pode possuir várias reservas ao longo do tempo.
Uma reserva pertence a um hóspede e a um quarto.
O mesmo quarto não pode possuir reservas conflitantes.
As datas devem ser consideradas para verificar disponibilidade.
A quantidade de diárias deve ser calculada a partir das datas.
O valor final depende da quantidade de diárias e do valor da diária.
Uma reserva cancelada deve deixar de ocupar aquele período.
 */

public class Cadastro {
        ArrayList<String> nome = new ArrayList<>();
        ArrayList<String> formaDePagamento = new ArrayList<>();
        ArrayList<Integer> idade = new ArrayList<>();
        ArrayList<Boolean> devendo = new ArrayList<>();
        ArrayList<String> quartoAssociado = new ArrayList<>();
        ArrayList<Boolean> listaNegra = new ArrayList<>();
        ArrayList<Boolean> cafe = new ArrayList<>();
        ArrayList<Boolean> massagem = new ArrayList<>();
        ArrayList<String> reservaH = new ArrayList<>();
        ArrayList<String> motivo = new ArrayList<>();
        ArrayList<Double> divida = new ArrayList<>();

    ArrayList<String> nomeQuarto = new ArrayList<>();
    ArrayList<String> qualidade = new ArrayList<>();
    ArrayList<Boolean> danificado = new ArrayList<>();
    ArrayList<Boolean> ocupado = new ArrayList<>();
    ArrayList<Double> valorD = new ArrayList<>();
    ArrayList<Integer> qthospede = new ArrayList<>();
    ArrayList<Integer> camaInd = new ArrayList<>();
    ArrayList<Integer> camaCas = new ArrayList<>();
    ArrayList<Integer> beliche = new ArrayList<>();
    ArrayList<LocalDate> data1 = new ArrayList<>();
    ArrayList<LocalDate> data2 = new ArrayList<>();
    ArrayList<Double> valorFinal = new ArrayList<>();
    ArrayList<String> reservaQ = new ArrayList<>();
    ArrayList<String> clienteAssociado = new ArrayList<>();
    ArrayList<Period> periodo = new ArrayList<>();


    Integer selecionar;
    String transferidor;

        void cadastroCliente() {
            nome.add(JOptionPane.showInputDialog("Coloque seu nome"));
            transferidor = JOptionPane.showInputDialog("Coloque sua idade");
            try {
                idade.add(Integer.parseInt(transferidor));
            }catch (NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Digite um valor válido");
            }
            formaDePagamento.add(null);
            quartoAssociado.add(null);
            listaNegra.add(false);
            devendo.add(false);
            cafe.add(false);
            massagem.add(false);
            valorFinal.add(null);
            reservaH.add(null);
            motivo.add(null);
            divida.add(0.0);
        }
        void cadastroQuarto() {
            nomeQuarto.add(JOptionPane.showInputDialog("Coloque o número do quarto"));
            transferidor = JOptionPane.showInputDialog("Qual a qualidade de quarto?\n[1]Standard\n[2]Deluxe\n[3]Suíte Júnior\n[4]Suíte Master\n[5]Suíte Presidencial");
            try {
                selecionar = Integer.parseInt(transferidor);
            }catch (NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Digite um valor válido");
            }
            if(selecionar == 1){
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
            }else {
                System.err.println("Valor inválido");
                return;
            }
            transferidor = JOptionPane.showInputDialog("Quantos hospedes cabem no quarto?\n[1]SGL\n[2]DBL\n[3]TWN\n[4]TRPL\n[5]QUAD");
            try {
                selecionar = Integer.parseInt(transferidor);
            }catch (NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Digite um valor válido");
            }
            if(selecionar == 1){
                qthospede.add(1);
                camaInd.add(1);
                camaCas.add(0);
                beliche.add(0);
            } else if (selecionar == 2) {
                qthospede.add(2);
                camaInd.add(0);
                camaCas.add(1);
                beliche.add(0);
            } else if (selecionar == 3) {
                qthospede.add(2);
                camaInd.add(2);
                camaCas.add(0);
                beliche.add(0);
            } else if (selecionar == 4) {
                qthospede.add(3);
                camaInd.add(1);
                camaCas.add(1);
                beliche.add(0);
            } else if (selecionar == 5) {
                qthospede.add(4);
                camaInd.add(0);
                camaCas.add(1);
                beliche.add(1);
            }else {
                System.err.println("Digite um valor válido");
                return;
            }
            danificado.add(false);
            ocupado.add(false);
            data1.add(null);
            data2.add(null);
            reservaQ.add(null);
            clienteAssociado.add(null);
            periodo.add(null);
        }
    }