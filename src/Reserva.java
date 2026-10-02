import javax.swing.*;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Reserva {
    Period periodo;
    long totalDias;
    LocalDate dataAgora, d1, d2;
    Period period;
    DateTimeFormatter dateTimeFormatter;
    Cadastro ca;

    Reserva(Cadastro ca) {
        this.ca = ca;
    }

    String nomeProcura, quartoProcura, passarinf, dia, mes, ano, dia2, mes2, ano2;
    int i, f, numeros, qtreservador;
    double valorTotalReserva, valorTotal;
    ArrayList<LocalDate> data1Reserva = new ArrayList<>();
    ArrayList<LocalDate> data2Reserva = new ArrayList<>();

    void reservarQuarto() {
        valorTotal = 0;
        nomeProcura = JOptionPane.showInputDialog("Nome do hospede a reservar o quarto");
        for (i = 0; i < ca.nome.size(); i++) {
            if (nomeProcura.equalsIgnoreCase(ca.nome.get(i))) {
                if (ca.idade.get(i) < 18) {
                    passarinf = JOptionPane.showInputDialog("Cliente menor de idade, confirma se cliente está acompanhado de algum adulto [1]Sim [2]Não");
                    try {
                        numeros = Integer.parseInt(passarinf);
                    }catch (NumberFormatException e){
                        JOptionPane.showMessageDialog(null, "Digite um valor válido");
                    }
                    if (numeros == 1) {
                        JOptionPane.showMessageDialog(null, "Pode prosseguir");
                    } else if (numeros == 2) {
                        JOptionPane.showMessageDialog(null, "Cliente menor de idade sem acompanhamento");
                        return;
                    } else {
                        JOptionPane.showMessageDialog(null, "Valor inválido");
                        return;
                    }
                }
                if (ca.devendo.get(i) == true) {
                    JOptionPane.showMessageDialog(null, "Cliente devendo, não pode reservar um quarto");
                    return;
                }
                if (ca.listaNegra.get(i) == true) {
                    JOptionPane.showMessageDialog(null, "Cliente banido de nosso hotel");
                    return;
                }

                passarinf = JOptionPane.showInputDialog("Quer adicionar alguém serviço de nosso hotel?\n[1]Café no quarto\n[2]Massagem\n[3]Café no quarto/Massagem\n[0]Não");
                try {
                    numeros = Integer.parseInt(passarinf);
                }catch (NumberFormatException e){
                    JOptionPane.showMessageDialog(null, "Digite um valor válido");
                }
                if (numeros == 1) {
                    ca.cafe.set(i, true);
                    JOptionPane.showMessageDialog(null, "Serviço de café no quarto adicionado");
                } else if (numeros == 2) {
                    ca.massagem.set(i, true);
                    JOptionPane.showMessageDialog(null, "Serviço de massagem adicionado");
                } else if (numeros == 3) {
                    ca.cafe.set(i, true);
                    ca.massagem.set(i, true);
                    JOptionPane.showMessageDialog(null, "Serviço de café no quarto e de massagem adicionado");
                } else if (numeros == 0) {
                    JOptionPane.showMessageDialog(null, "Nenhum serviço adicionado");
                } else {
                    JOptionPane.showMessageDialog(null, "Valor inválido");
                    return;
                }

                quartoProcura = JOptionPane.showInputDialog("Nome do quarto que o cliente quer reservar");
                for (f = 0; f < ca.nomeQuarto.size(); f++) {
                    if (quartoProcura.equalsIgnoreCase(ca.nomeQuarto.get(f))) {
                        dataAgora = LocalDate.now();
                        passarinf = JOptionPane.showInputDialog("Quantos hospedes vão utilizar este quarto");
                        try {
                            qtreservador = Integer.parseInt(passarinf);
                        }catch (NumberFormatException e){
                            JOptionPane.showMessageDialog(null, "Digite um valor válido");
                        }
                        if (ca.qthospede.get(f) < qtreservador) {
                            JOptionPane.showMessageDialog(null, "Quantidade de hospedes superior à capacidade do quarto");
                            return;
                        }
                        if (ca.danificado.get(f) == true) {
                            JOptionPane.showMessageDialog(null, "Quarto está danificado, logo não disponível");
                            return;
                        }
                        try {
                            dia = JOptionPane.showInputDialog("Coloque o dia da reserva");
                            mes = JOptionPane.showInputDialog("Coloque o mês da reserva");
                            ano = JOptionPane.showInputDialog("Coloque o ano da reserva");
                            DateTimeFormatter formatadorData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                            d1 = LocalDate.parse(dia + "/" + mes + "/" + ano, formatadorData);
                            dia2 = JOptionPane.showInputDialog("Coloque o dia de fim da reserva");
                            mes2 = JOptionPane.showInputDialog("Coloque o mês de fim da reserva");
                            ano2 = JOptionPane.showInputDialog("Coloque o ano de fim da reserva");
                            d2 = LocalDate.parse(dia2 + "/" + mes2 + "/" + ano2, formatadorData);
                        }catch (DateTimeException e){
                            JOptionPane.showMessageDialog(null, "Digite um valor válido");
                        }
                        if (!d2.isAfter(d1)) {
                            JOptionPane.showMessageDialog(null, "A data final deve ser depois da data inicial");
                            return;
                        }
                        if (ca.data1.get(f) != null && ca.data2.get(f) != null) {
                            if (d1.isBefore(ca.data2.get(f)) && d2.isAfter(ca.data1.get(f))) {
                                JOptionPane.showMessageDialog(null, "Quarto ocupado");
                                return;
                            }
                        }
                        ca.data1.set(f, d1);
                        ca.data2.set(f, d2);
                        periodo = Period.between(d1, d2);
                        totalDias = ChronoUnit.DAYS.between(d1, d2);
                        valorTotalReserva = ca.valorD.get(f) * totalDias;
                        valorTotal += valorTotalReserva;
                        if (ca.cafe.get(i) == true) {
                            valorTotal += 50 * qtreservador;
                        }
                        if (ca.massagem.get(i) == true) {
                            valorTotal += 250;
                        }
                        ca.valorFinal.set(i, valorTotal);
                        ca.quartoAssociado.set(i, ca.nomeQuarto.get(f));
                        ca.clienteAssociado.set(f, ca.nome.get(i));
                        ca.ocupado.set(f, true);
                        data1Reserva.add(ca.data1.get(f));
                        data2Reserva.add(ca.data2.get(f));
                        JOptionPane.showMessageDialog(null, "RESERVOU O QUARTO " + ca.nomeQuarto.get(f) + "\n\nQuarto reservado por:\n" + totalDias + " Dias\n" + periodo.getMonths() + " Meses\n" + periodo.getYears() + " Anos\n" + "Qualidade do quarto: " + ca.qualidade.get(f) + "\nCapacidade do quarto: " + ca.qthospede.get(f) + "\nValor total: " + valorTotal);
                        ca.reservaH.set(i, "Quarto reservado por:\n" + totalDias + " Dias\n" + periodo.getMonths() + " Meses\n" + periodo.getYears() + " Anos\n" + "Qualidade do quarto: " + ca.qualidade.get(f) + "\nCapacidade do quarto: " + ca.qthospede.get(f) + "\nValor total: " + valorTotal);
                        ca.reservaQ.set(f, "Cliente reservou por:\n" + totalDias + " Dias\n" + periodo.getMonths() + " Meses\n" + periodo.getYears() + " Anos\n" + "Qualidade do quarto: " + ca.qualidade.get(f) + "\nCapacidade do quarto: " + ca.qthospede.get(f) + "\nValor total: " + valorTotal);
                        passarinf = JOptionPane.showInputDialog("Qual a forma de Pagamento\n[1]PIX\n[2]Débito\n[3]Crédito\n[4]Dinheiro\n[0]Desistir do pagamento");
                        try {
                            numeros = Integer.parseInt(passarinf);
                        }catch (NumberFormatException e){
                            JOptionPane.showMessageDialog(null, "Digite um valor válido");
                        }
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
                        } else if (numeros == 0) {
                            JOptionPane.showMessageDialog(null, "Hospedagem cancelada");
                            ca.cafe.set(i, false);
                            ca.massagem.set(i, false);
                            ca.data1.set(i, null);
                            ca.data2.set(i, null);
                            ca.valorFinal.set(i, null);
                            ca.devendo.set(i, false);
                            ca.quartoAssociado.set(i, null);
                            ca.ocupado.set(f, false);
                            ca.clienteAssociado.set(f, null);
                            ca.reservaQ.set(f, null);
                            return;
                        }
                    }
                }
            }
        }
        JOptionPane.showMessageDialog(null, "Cliente ou quarto não encontrados");
    }
}
