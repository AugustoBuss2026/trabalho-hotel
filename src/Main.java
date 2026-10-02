import javax.swing.*;

void main() {
    Cadastro ca = new Cadastro();
    Reserva re = new Reserva(ca);
    Consulta con = new Consulta(ca);
    Manutencao ma = new Manutencao(ca);
    CancelarReservas cr = new CancelarReservas(ca);
    ListaNegraEDividas ln = new ListaNegraEDividas(ca);
    String passainf;
    int escolha = 0, escolha2 = 0, escolha3 = 0, escolha4 = 0, escolha5 = 0;


    do {
        passainf = JOptionPane.showInputDialog("Qual procedimento quer fazer?\n[1]Cadastro\n[2]Reserva\n[3]Consulta\n[4]Cancelar reserva\n[5]Reparo e danificado\n[6]Lista negra e dividas\n[99]SAIR");
        if (passainf == null){
            break;
        }
        try {
            escolha = Integer.parseInt(passainf);
            switch (escolha) {
                case 1:
                    do {
                        passainf = JOptionPane.showInputDialog("[1]Cliente\n[2]Quarto\n[99]VOLTAR");
                        if (passainf == null){
                            break;
                        }
                        try {
                            escolha2 = Integer.parseInt(passainf);
                            switch (escolha2) {
                                case 1:
                                    ca.cadastroCliente();
                                    break;
                                case 2:
                                    ca.cadastroQuarto();
                                    break;
                            }
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Digite um valor válido");
                        }
                    } while (escolha2 != 99);
                    break;
                case 2:
                    re.reservarQuarto();
                    break;
                case 3:
                    do {
                        passainf = JOptionPane.showInputDialog("[1]Cliente\n[2]Quarto\n[99]VOLTAR");
                        if (passainf == null){
                            break;
                        }
                        try {
                            escolha3 = Integer.parseInt(passainf);
                            switch (escolha3) {
                                case 1:
                                    con.ConsultaCliente();
                                    break;
                                case 2:
                                    con.ConsultaQuarto();
                                    break;
                            }
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Digite um valor válido");
                        }
                    } while (escolha3 != 99);
                    break;
                case 4:
                    cr.CR();
                    break;
                case 5:
                    do {
                        passainf = JOptionPane.showInputDialog("[1]Reparo\n[2]Danificado\n[99]Voltar");
                        if (passainf == null){
                            break;
                        }
                        try {
                            escolha4 = Integer.parseInt(passainf);
                            switch (escolha4) {
                                case 1:
                                    ma.reparo();
                                    break;
                                case 2:
                                    ma.estrago();
                                    break;
                            }
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Digite um valor válido");
                        }
                    } while (escolha4 != 99);
                    break;
                case 6:
                    do {
                        passainf = JOptionPane.showInputDialog("[1]Lista Negra\n[2]Divídas\n[99]Voltar");
                        if (passainf == null){
                            break;
                        }
                        try {
                            escolha5 = Integer.parseInt(passainf);
                            switch (escolha5) {
                                case 1:
                                    ln.ListaNegra();
                                    break;
                                case 2:
                                    ln.Divida();
                                    break;
                            }
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Digite um valor válido");
                        }
                    } while (escolha5 != 99);
                    break;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Digite um valor válido");
        }
    } while (escolha != 99);
}