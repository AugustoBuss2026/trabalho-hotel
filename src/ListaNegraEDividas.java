import javax.swing.*;

public class ListaNegraEDividas {
    Cadastro ca;
    ListaNegraEDividas(Cadastro ca){
        this.ca = ca;
    }
    String procuraronme, pps;
    Integer m, decidir;

    void ListaNegra(){
        procuraronme = JOptionPane.showInputDialog("Qual é o cliente a entrar na lista negra");
        for (m = 0; m<ca.nome.size(); m++){
            if (procuraronme.equals(ca.nome.get(m)) && ca.listaNegra.get(m) == false){
                ca.motivo.set(m, JOptionPane.showInputDialog("Qual é o motivo"));
                JOptionPane.showMessageDialog(null, ca.nome.get(m) + " foi adicionado a lista negra por " +ca.motivo.get(m));
                ca.listaNegra.set(m, true);
            }
        }
    }
    void Divida(){
        procuraronme = JOptionPane.showInputDialog("Qual é o cliente dividado");
        for (m = 0; m<ca.nome.size(); m++) {
            if (procuraronme.equals(ca.nome.get(m)) && ca.devendo.get(m) == true) {
                JOptionPane.showMessageDialog(null, ca.nome.get(m)+ " dividado em "+ca.divida.get(m));
                do {
                    pps = JOptionPane.showInputDialog("[1]Prosseguir\n[2]Desistir do pagamento");
                    decidir = Integer.parseInt(pps);
                    switch (decidir){
                        case 1:
                            JOptionPane.showMessageDialog(null, "Divída paga");
                            ca.divida.set(m, 0.0);
                            ca.devendo.set(m, false);
                            break;
                    }
                }while (decidir!=2);
            }
        }
    }
}
