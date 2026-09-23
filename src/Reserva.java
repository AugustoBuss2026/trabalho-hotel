import javax.swing.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Reserva {
    long totalDias;
    LocalDate dataAgora;
    ArrayList<LocalDate> data1 = new ArrayList<>();
    ArrayList<LocalDate> data2 = new ArrayList<>();
    Period period;
    DateTimeFormatter dateTimeFormatter;
    Cadastro ca;
    Reserva(Cadastro ca){
        this.ca = ca;
    }
    String nomeProcura, quartoProcura, passarinf, dia, mes, ano, dia2, mes2, ano2;
    int i, f, numeros, reservasParar, qtreservador;
    double valorTotalReserva, valorTotal;
    void reservarQuarto() {
        nomeProcura = JOptionPane.showInputDialog("Nome do hospede a reservar o quarto");
        for (i = 0; i < ca.nome.size(); i++) {
            if (nomeProcura.equalsIgnoreCase(ca.nome.get(i))){
                if (ca.idade.get(i) < 18){
                    passarinf = JOptionPane.showInputDialog("Cliente menor de idade, confirma se cliente está acompanhado de algum adulto [1]Sim [2]Não");
                    numeros = Integer.parseInt(passarinf);
                    if (numeros == 1){
                        JOptionPane.showMessageDialog(null, "Pode prosseguir");
                    } else if (numeros == 2) {
                        JOptionPane.showMessageDialog(null, "Cliente menor de idade sem acompanhamento");
                        return;
                    }else {
                        JOptionPane.showMessageDialog(null,"Valor inválido");
                        return;
                    }
                }
                if (ca.devendo.get(i) == true){
                    JOptionPane.showMessageDialog(null,"Cliente devendo, não pode reservar um quarto");
                    return;
                }
                if (ca.listaNegra.get(i) == true){
                    JOptionPane.showMessageDialog(null, "Cliente banido de nosso hotel");
                    return;
                }
                passarinf = JOptionPane.showInputDialog("Quer adicionar alguém serviço de nosso hotel?\n[1]Café no quarto\n[2]Massagem\n[3]Café no quarto/Massagem\n[0]Não");
                numeros = Integer.parseInt(passarinf);
                if (numeros == 1){
                    ca.cafe.set(i, true);
                    JOptionPane.showMessageDialog(null, "Serviço de café no quarto adicionado");
                } else if (numeros == 2) {
                    ca.massagem.set(i, true);
                    JOptionPane.showMessageDialog(null, "Serviço de massagem adicionado");
                }else if (numeros == 3){
                    ca.cafe.set(i, true);
                    ca.massagem.set(i, true);
                    JOptionPane.showMessageDialog(null, "Serviço de café no quarto e de massagem adicionado");
                } else if (numeros == 0) {
                    JOptionPane.showMessageDialog(null, "Nenhum serviço adicionado");
                }else {
                    JOptionPane.showMessageDialog(null, "Valor inválido");
                    return;
                }

                quartoProcura = JOptionPane.showInputDialog("Nome do quarto que o cliente quer reservar");
                for (f = 0; f < ca.nomeQuarto.size(); f++){
                    if (quartoProcura.equalsIgnoreCase(ca.nomeQuarto.get(f))){
                        dataAgora = LocalDate.now();
                        passarinf = JOptionPane.showInputDialog("Quantos hospedes vão utilizar este quarto");
                        qtreservador = Integer.parseInt(passarinf);
                        if (ca.qthospede.get(f) < qtreservador){
                            JOptionPane.showMessageDialog(null, "Quantidade de hospedes superior à capacidade do quarto");
                            return;
                        }
                        if (ca.danificado.get(f) == true) {
                            JOptionPane.showMessageDialog(null, "Quarto está danificado, logo não disponível");
                            return;
                        }
                        for (int t = 0; t <= reservasParar; t++) {
                            if (dataAgora.isAfter(data1.get(t)) && dataAgora.isBefore(data2.get(t))) {
                                JOptionPane.showMessageDialog(null, "Quarto ocupado");
                                return;
                            }
                            dia = JOptionPane.showInputDialog("Coloque o dia da reserva");
                            mes = JOptionPane.showInputDialog("Coloque o mês da reserva");
                            ano = JOptionPane.showInputDialog("Coloque o ano da reserva");
                            DateTimeFormatter formatadorData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                            data1.add(LocalDate.parse(dia + "/" + mes + "/" + ano, formatadorData));
                            dia2 = JOptionPane.showInputDialog("Coloque o dia de fim da reserva");
                            mes2 = JOptionPane.showInputDialog("Coloque o mês de fim da reserva");
                            ano2 = JOptionPane.showInputDialog("Coloque o ano de fim da reserva");
                            data2.add(LocalDate.parse(dia2 + "/" + mes2 + "/" + ano2, formatadorData));
                            Period periodo = Period.between(data1.get(t), data2.get(t));
                            totalDias = ChronoUnit.DAYS.between(data1.get(t), data2.get(t));
                            valorTotalReserva = ca.valorD.get(f) * totalDias;
                            JOptionPane.showMessageDialog(null, "Quarto reservado por:\n" + periodo.getDays() + " Dias\n" + periodo.getMonths() + " Meses\n" + periodo.getYears() + " Anos");
                        }
                        reservasParar++;
                    }
                }
            }
        }
    }
}
