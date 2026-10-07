import javax.swing.*;

public class Consulta {
    int i, f;
    String descricao1, descricao2, cpfformatado;
    Cadastro ca;

    Consulta(Cadastro ca) {
        this.ca= ca;
    }

    void ConsultaCliente() {
        for(i= 0; i< ca.nome.size(); i++) {
            cpfformatado = ca.cpf.get(i);
            cpfformatado = String.format("%s.%s.%s-%s",
                    cpfformatado.substring(0, 3),
                    cpfformatado.substring(3, 6),
                    cpfformatado.substring(6, 9),
                    cpfformatado.substring(9, 11));
            JOptionPane.showMessageDialog(null, "Nome:" + ca.nome.get(i) + "\nCPF: " + cpfformatado + "\nIdade: "+ ca.idade.get(i));
            if(ca.listaNegra.get(i) == true) {
                JOptionPane.showMessageDialog(null, "Hospede na lista negra");
            }
            if(ca.devendo.get(i) == true) {
                JOptionPane.showMessageDialog(null, "Cliente dividado");
            }
            JOptionPane.showMessageDialog(null, "Quartos de reserva do cliente:");
            if(!ca.quartoAssociado.get(i).isEmpty()) {
                descricao1= "";
                for(f= 0; f< ca.quartoAssociado.get(i).size(); f++) {
                    descricao1+= ca.reservaH.get(i).get(f) + "\n";
                }
                JOptionPane.showMessageDialog(null, descricao1);
            }
        }
    }

    void ConsultaQuarto() {
        for(i= 0; i< ca.nomeQuarto.size(); i++) {
            JOptionPane.showMessageDialog(null, ca.nomeQuarto.get(i));
            if(ca.ocupado.get(i) == true) {
                JOptionPane.showMessageDialog(null, "Quarto ocupado");
            }
            if(ca.danificado.get(i) == true) {
                JOptionPane.showMessageDialog(null, "Quarto danificado");
            }
            if(!ca.clienteAssociado.get(i).isEmpty()) {
                descricao2= "";
                for(f= 0; f< ca.clienteAssociado.get(i).size(); f++){
                    descricao2+= ca.reservaQ.get(i).get(f) + "\n";
                }
                JOptionPane.showMessageDialog(null, descricao2);
            }
        }
    }
}