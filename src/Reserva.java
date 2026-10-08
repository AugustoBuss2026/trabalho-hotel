import javax.swing.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Reserva {
    Period periodo;
    long totalDias;
    LocalDate dataAgora, d1, d2;
    LocalTime horario1, horario2, limpa, horarioAgora;
    Cadastro ca;

    Reserva(Cadastro ca) {
        this.ca = ca;
    }

    String nomeProcura, quartoProcura, passarinf, dia, mes, ano, dia2, mes2, ano2, hora1, hora2, minuto1, minuto2, cpfformatado;
    int i, f, y, a, numeros, qtreservador, contar;
    double valorTotalReserva, valorTotal;
    Boolean cafe, massagem;

    void reservarQuarto() {
        valorTotal = 0;
        do {
            nomeProcura = JOptionPane.showInputDialog("CPF do hospede a reservar o quarto");
            if (nomeProcura == null) {
                return;
            }
        }while (nomeProcura.isEmpty());
        for (i = 0; i < ca.nome.size(); i++) {
            if (nomeProcura.equalsIgnoreCase(ca.cpf.get(i))) {
                if (ca.devendo.get(i) == true) {
                    JOptionPane.showMessageDialog(null, "Cliente devendo, não pode reservar um quarto");
                    return;
                }
                if (ca.listaNegra.get(i) == true) {
                    JOptionPane.showMessageDialog(null, "Cliente banido de nosso hotel");
                    return;
                }
                do {
                    cafe = false;
                    massagem = false;
                    passarinf = JOptionPane.showInputDialog("Quer adicionar alguém serviço de nosso hotel?\n[1]Café no quarto\n[2]Massagem\n[3]Café no quarto/Massagem\n[0]Não");
                    if (passarinf == null){
                        return;
                    }
                } while (passarinf.isEmpty() || Integer.parseInt(passarinf) != 1 && Integer.parseInt(passarinf) != 2 && Integer.parseInt(passarinf) != 0);
                numeros = Integer.parseInt(passarinf);
                if (numeros == 1) {
                    cafe = true;
                    JOptionPane.showMessageDialog(null, "Serviço de café no quarto adicionado");
                } else if (numeros == 2) {
                    massagem = true;
                    JOptionPane.showMessageDialog(null, "Serviço de massagem adicionado");
                } else if (numeros == 3) {
                    cafe = true;
                    massagem = true;
                    JOptionPane.showMessageDialog(null, "Serviço de café no quarto e de massagem adicionado");
                } else if (numeros == 0) {
                    JOptionPane.showMessageDialog(null, "Nenhum serviço adicionado");
                } else {
                    JOptionPane.showMessageDialog(null, "Valor inválido");
                    return;
                }
                do {
                    quartoProcura = JOptionPane.showInputDialog("Nome do quarto que o cliente quer reservar");
                    if (quartoProcura == null){
                        return;
                    }
                } while (quartoProcura.isEmpty());
                for (f = 0; f < ca.nomeQuarto.size(); f++) {
                    if (quartoProcura.equalsIgnoreCase(ca.nomeQuarto.get(f))) {
                        dataAgora = LocalDate.now();
                        do {
                            passarinf = JOptionPane.showInputDialog("Quantos hospedes maiores de idade vão utilizar este quarto");
                            if (passarinf == null){
                                return;
                            }
                        } while (passarinf.isEmpty() || Integer.parseInt(passarinf) < 18);
                        qtreservador = Integer.parseInt(passarinf);
                        if (ca.qthospede.get(f) < qtreservador) {
                            JOptionPane.showMessageDialog(null, "Quantidade de hospedes superior à capacidade do quarto");
                            return;
                        }
                        if (ca.danificado.get(f) == true) {
                            JOptionPane.showMessageDialog(null, "Quarto está danificado, logo não disponível");
                            return;
                        }
                        do {
                            dia = JOptionPane.showInputDialog("Coloque o dia da reserva");
                            if (dia == null){
                                return;
                            }
                        } while (dia.isEmpty() || dia.matches("\\d+") || dia.length() != 2);
                        do {
                            mes = JOptionPane.showInputDialog("Coloque o mês da reserva");
                            if (mes == null){
                                return;
                            }
                        } while (mes.isEmpty() || mes.matches("\\d+") || mes.length() != 2);
                        do {
                            ano = JOptionPane.showInputDialog("Coloque o ano da reserva");
                            if (ano == null){
                                return;
                            }
                        } while (ano.isEmpty() || ano.matches("\\d+") || ano.length() != 2);
                        DateTimeFormatter formatadorData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                        d1 = LocalDate.parse(dia + "/" + mes + "/" + ano, formatadorData);
                        do {
                            dia2 = JOptionPane.showInputDialog("Coloque o dia de fim da reserva");
                            if (dia2 == null){
                                return;
                            }
                        } while (dia2.isEmpty() || dia2.matches("\\d+") || dia2.length() != 2);
                        do {
                            mes2 = JOptionPane.showInputDialog("Coloque o mês de fim da reserva");
                            if (mes2 == null){
                                return;
                            }
                        } while (mes2.isEmpty() || mes2.matches("\\d+") || mes2.length() != 2);
                        do {
                            ano2 = JOptionPane.showInputDialog("Coloque o ano de fim da reserva");
                            if (ano2 == null){
                                return;
                            }
                        } while (ano2.isEmpty() || ano2.matches("\\d+") || ano2.length() != 2);
                        d2 = LocalDate.parse(dia2 + "/" + mes2 + "/" + ano2, formatadorData);
                        do {
                            hora1 = JOptionPane.showInputDialog("Horário de chegada (hora)");
                            if (hora1 == null){
                                return;
                            }
                        } while (hora1.isEmpty() || hora1.matches("\\d+") || hora1.length() != 2);
                        do {
                            minuto1 = JOptionPane.showInputDialog("Horário de chegada (minuto)");
                            if (minuto1 == null){
                                return;
                            }
                        }while (minuto1.isEmpty() || minuto1.matches("\\d+") || minuto1.length() != 2);
                        horario1 = LocalTime.of(Integer.parseInt(hora1), Integer.parseInt(minuto1));
                        do {
                            hora2 = JOptionPane.showInputDialog("Horário de partida (hora)");
                            if (hora2 == null){
                                return;
                            }
                        }while (hora2.isEmpty() || hora2.matches("\\d+") || hora2.length() != 2);
                        do {
                            minuto2 = JOptionPane.showInputDialog("Horário de partida (minuto)");
                            if (minuto2 == null){
                                return;
                            }
                        }while (minuto2.isEmpty() || minuto2.matches("\\d+") || minuto2.length() != 2);
                        horario2 = LocalTime.of(Integer.parseInt(hora2), Integer.parseInt(minuto2));

                        limpa = horario2.plusHours(2);
                        horarioAgora = LocalTime.now();
                        for (a = 0; a < ca.fimLimpeza.get(f).size(); a++) {
                            if (horarioAgora.isBefore(ca.fimLimpeza.get(f).get(a)) && horarioAgora.equals(ca.fimLimpeza.get(f).get(a))) {
                                JOptionPane.showMessageDialog(null, "Hórario indisponível, limpeza sendo feita");
                                return;
                            }
                        }
                        if (!d2.isAfter(d1)) {
                            JOptionPane.showMessageDialog(null, "A data final deve ser depois da data inicial");
                            return;
                        }

                        for (y = 0; y < ca.data1.get(f).size(); y++) {
                            if (ca.data1.get(f).get(y) != null && ca.data2.get(f).get(y) != null) {
                                if (d1.isBefore(ca.data2.get(f).get(y)) && d2.isAfter(ca.data1.get(f).get(y))) {
                                    JOptionPane.showMessageDialog(null, "Quarto ocupado, neste periodo");
                                    return;
                                }
                            }
                        }
                        if (cafe){
                            ca.cafe.get(i).add(true);
                            valorTotal += 50 * qtreservador;
                        }
                        if (massagem){
                            ca.massagem.get(i).add(true);
                            valorTotal += 250;
                        }
                        contar = ca.data1.get(f).size();
                        ca.fimLimpeza.get(f).add(limpa);
                        ca.data1.get(f).add(d1);
                        ca.data2.get(f).add(d2);
                        ca.horario1.get(f).add(horario1);
                        ca.horario2.get(f).add(horario2);
                        periodo = Period.between(d1, d2);
                        totalDias = ChronoUnit.DAYS.between(d1, d2);
                        valorTotalReserva = ca.valorD.get(f) * totalDias;
                        valorTotal += valorTotalReserva;
                        ca.valorFinal.get(i).add(valorTotal);
                        ca.quartoAssociado.get(i).add(ca.nomeQuarto.get(f));
                        ca.clienteAssociado.get(f).add(ca.nome.get(i));
                        ca.ocupado.set(f, true);
                        cpfformatado = ca.cpf.get(i);
                        cpfformatado = String.format("%s.%s.%s-%s",
                                cpfformatado.substring(0, 3),
                                cpfformatado.substring(3, 6),
                                cpfformatado.substring(6, 9),
                                cpfformatado.substring(9, 11));
                        JOptionPane.showMessageDialog(null, "RESERVOU O QUARTO " + ca.nomeQuarto.get(f) + "\n\nQuarto reservado por:\n" + totalDias + " Dias\n" + periodo.getMonths() + " Meses\n" + periodo.getYears() + " Anos\n" + "Qualidade do quarto: " + ca.qualidade.get(f) + "\nCapacidade do quarto: " + ca.qthospede.get(f) + "\nValor total: " + valorTotal);
                        ca.reservaH.get(i).add("Quarto reservado por: " + ca.nome.get(i) + " CPF: " + cpfformatado + "\nDurante: " + totalDias + " Dias\n" + periodo.getMonths() + " Meses\n" + periodo.getYears() + " Anos\n" + "Horário de chegada: " + ca.horario1.get(f).get(contar) + "\nQualidade do quarto: " + ca.qualidade.get(f) + "\nCapacidade do quarto: " + ca.qthospede.get(f) + "\nValor total: " + valorTotal);
                        ca.reservaQ.get(f).add("Cliente reservou o quarto: " + ca.nomeQuarto.get(f) + "\nDurante: " + totalDias + " Dias\n" + periodo.getMonths() + " Meses\n" + periodo.getYears() + " Anos\n" + "Horário de chegada: " + ca.horario1.get(f).get(contar) + "\nQualidade do quarto: " + ca.qualidade.get(f) + "\nCapacidade do quarto: " + ca.qthospede.get(f) + "\nValor total: " + valorTotal);
                        passarinf = JOptionPane.showInputDialog("Qual a forma de Pagamento\n[1]PIX\n[2]Débito\n[3]Crédito\n[4]Dinheiro\n[0]Desistir do pagamento");
                        do {
                            passarinf = JOptionPane.showInputDialog("Qual a forma de Pagamento\n[1]PIX\n[2]Débito\n[3]Crédito\n[4]Dinheiro\n[0]Desistir do pagamento");
                        }while (passarinf == null || passarinf.isEmpty() || Integer.parseInt(passarinf) != 1 && Integer.parseInt(passarinf) != 2 && Integer.parseInt(passarinf) != 3 && Integer.parseInt(passarinf) != 4 && Integer.parseInt(passarinf) != 0);
                        numeros = Integer.parseInt(passarinf);
                        if (numeros == 1) {
                            ca.formaDePagamento.set(i, "PIX");
                            JOptionPane.showMessageDialog(null, "Hospedagem paga com PIX");
                            return;
                        } else if (numeros == 2) {
                            ca.formaDePagamento.set(i, "Débito");
                            JOptionPane.showMessageDialog(null, "Hospedagem paga com débito");
                            return;
                        } else if (numeros == 3) {
                            ca.formaDePagamento.set(i, "Crédito");
                            JOptionPane.showMessageDialog(null, "Hospedagem paga com crédito");
                            return;
                        } else if (numeros == 4) {
                            ca.formaDePagamento.set(i, "Dinheiro");
                            JOptionPane.showMessageDialog(null, "Hospedagem paga em dinheiro");
                            return;
                        } else if (numeros == 0) {
                            JOptionPane.showMessageDialog(null, "Hospedagem cancelada");
                            ca.cafe.get(i).remove(contar);
                            ca.massagem.get(i).remove(contar);
                            ca.data1.get(f).remove(contar);
                            ca.data2.get(f).remove(contar);
                            ca.horario1.get(f).remove(contar);
                            ca.horario2.get(f).remove(contar);
                            ca.valorFinal.get(f).remove(contar);
                            ca.fimLimpeza.get(f).remove(contar);
                            ca.quartoAssociado.get(i).remove(contar);
                            ca.ocupado.set(f, false);
                            ca.clienteAssociado.get(f).remove(contar);
                            ca.reservaQ.get(f).remove(contar);
                            ca.reservaH.get(i).remove(contar);
                            return;
                        }
                    }
                }
            }
        }
        JOptionPane.showMessageDialog(null, "Cliente ou quarto não encontrados");
    }
}