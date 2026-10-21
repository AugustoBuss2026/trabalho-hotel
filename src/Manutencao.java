import javax.swing.*;

public class Manutencao {
    Cadastro ca;

    Manutencao(Cadastro ca) {
        this.ca = ca;
    }

    String conDesQuartoProcura, devedr, valo, entitulacaodivida;
    Integer q, g, o;

    void reparo() {
        do {
            conDesQuartoProcura = JOptionPane.showInputDialog("Qual o quarto a ser reparado");
            if (conDesQuartoProcura == null){
                return;
            }
        } while (conDesQuartoProcura.isEmpty());
        for (q = 0; q < ca.nomeQuarto.size(); q++) {
            if (conDesQuartoProcura.equals(ca.nomeQuarto.get(q)) && ca.danificado.get(q) == true) {
                JOptionPane.showMessageDialog(null, "Quarto reparado");
                ca.danificado.set(q, false);
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Quarto não encontrado");
    }

    void estrago() {
        do {
            conDesQuartoProcura = JOptionPane.showInputDialog("Qual o quarto que foi danificado");
            if (conDesQuartoProcura == null){
                return;
            }
        } while (conDesQuartoProcura.isEmpty());
        for (q = 0; q < ca.nomeQuarto.size(); q++) {
            if (conDesQuartoProcura.equals(ca.nomeQuarto.get(q)) && ca.danificado.get(q) == false) {
                do {
                    devedr = JOptionPane.showInputDialog("Qual o CPF do cliente foi responsável pelo estrago\n(Se não foi por conta de um cliente digite 0)");
                    if (devedr == null){
                        return;
                    }
                }while (devedr.isEmpty());
                if (Integer.parseInt(devedr) == 0) {
                    ca.danificado.set(q, true);
                    JOptionPane.showMessageDialog(null, "Quarto marcado como danificado");
                    return;
                }
                for (g = 0; g < ca.nome.size(); g++) {
                    if (devedr.equals(ca.cpf.get(g))) {

                        do{
                            entitulacaodivida = JOptionPane.showInputDialog("Entitule a divída");
                            if (entitulacaodivida == null){
                                return;
                            }
                            for (o = 0; o<ca.nomeDivida.get(g).size(); o++){
                                if (entitulacaodivida.equalsIgnoreCase(ca.nomeDivida.get(g).get(o))){
                                    JOptionPane.showMessageDialog(null, "Nomeação de divída já utilizada");
                                    break;
                                }
                            }
                        }while (entitulacaodivida.isEmpty());

                        do {
                            valo = JOptionPane.showInputDialog("Qual o valor do estrago?");
                            if (valo == null){
                                return;
                            }
                        } while (valo.isEmpty() || !valo.matches("\\d+(\\.\\d+)?"));
                        ca.divida.get(g).add(Double.parseDouble(valo));
                        ca.nomeDivida.get(g).add(entitulacaodivida);
                        ca.devendo.set(g, true);
                        ca.danificado.set(q, true);
                        JOptionPane.showMessageDialog(null, "Quarto marcado como danificado");
                        return;
                    }
                }
            }
        }
        JOptionPane.showMessageDialog(null, "Quarto ou cliente não encontrados");
    }
}
