import javax.swing.*;

public class Reserva {
    Cadastro ca;
    Reserva(Cadastro ca){
        this.ca = ca;
    }
    String nomeProcura, quartoProcura;
    int i, f;
    void reservarQuarto() {
        nomeProcura = JOptionPane.showInputDialog("Nome do  hospede a reservar o quarto");
        for (i = 0; i < ca.nome.size(); i++) {
            if (nomeProcura.equalsIgnoreCase(ca.nome.get(i))){
                if (ca.devendo.get(i) == true){
                    System.err.println("Cliente devendo, não pode reservar um quarto");
                    return;
                }
                if (ca.listaNegra.get(i) == true){
                    System.err.println("Cliente banido de nosso hotel");
                    return;
                }
            }
        }
    }
}
