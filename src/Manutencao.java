import javax.swing.*;

public class Manutencao {
    Cadastro ca;
    Manutencao(Cadastro ca){
        this.ca = ca;
    }
    String conDesQuartoProcura, passinf, devedr, valo;
    Integer numer, q, g;

    void reparo() {
            conDesQuartoProcura = JOptionPane.showInputDialog("Qual o quarto a ser reparado");
            for (q = 0; q < ca.nomeQuarto.size(); q++) {
                if (conDesQuartoProcura.equals(ca.nomeQuarto.get(q)) && ca.danificado.get(q) == true) {
                    JOptionPane.showMessageDialog(null, "Quarto reparado");
                    ca.danificado.set(q, false);
                    return;
                }
            }
            JOptionPane.showMessageDialog(null, "Quarto não encontrado");
        }
        void estrago (){
            conDesQuartoProcura = JOptionPane.showInputDialog("Qual o quarto que foi danificado");
            for (q = 0; q < ca.nomeQuarto.size(); q++) {
                if (conDesQuartoProcura.equals(ca.nomeQuarto.get(q)) && ca.danificado.get(q) == false) {
                    devedr = JOptionPane.showInputDialog("Qual cliente foi responsável pelo estrago\n(Se não foi por conta de um cliente não preencha e apenas prosiga)");
                    if (devedr == null || devedr.isEmpty()){
                        ca.danificado.set(q, true);
                        JOptionPane.showMessageDialog(null, "Quarto marcado como danificado");
                        return;
                    }
                    for (g = 0; g<ca.nome.size(); g++){
                        if (devedr.equals(ca.nome.get(g))){
                            valo = JOptionPane.showInputDialog("Qual o valor do estrago?");
                            do {
                                try {
                                    ca.divida.set(g, Double.parseDouble(valo));
                                    break;
                                } catch (NumberFormatException e) {
                                    JOptionPane.showMessageDialog(null, "Digite um valor válido");
                                    valo = JOptionPane.showInputDialog("Qual o valor do estrago?");
                                }
                            }while (true);
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