import javax.swing.*;

public class Manutencao {
    Cadastro ca = new Cadastro();
    String conDesQuartoProcura, passinf, devedr, valo;
    Integer numer, q, g;

    void reparo() {
            conDesQuartoProcura = JOptionPane.showInputDialog("Qual o quarto a ser reparado");
            for (q = 0; q < ca.nomeQuarto.size(); q++) {
                if (conDesQuartoProcura.equals(ca.nomeQuarto.get(q)) && ca.danificado.get(q) == true) {
                    JOptionPane.showMessageDialog(null, "Quarto reparado");
                    ca.danificado.set(q, false);
                }
            }
        }
        void estrago (){
            conDesQuartoProcura = JOptionPane.showInputDialog("Qual o quarto que foi danificado");
            for (q = 0; q < ca.nomeQuarto.size(); q++) {
                if (conDesQuartoProcura.equals(ca.nomeQuarto.get(q)) && ca.danificado.get(q) == false) {
                    JOptionPane.showMessageDialog(null, "Quarto marcado como danificado");
                    for (g = 0; g<ca.nome.size(); g++){
                        devedr = JOptionPane.showInputDialog("Qual cliente foi responsável pelo estrago\n(Se não foi por conta de um cliente não preencha e apenas prosiga)");
                        if (devedr.equals(ca.nome.get(q))){
                            valo = JOptionPane.showInputDialog("Qual o valor do estrago?");
                            ca.divida.set(g, Double.parseDouble(valo));
                            ca.devendo.set(g, true);
                            ca.danificado.set(q, true);
                        }else if (devedr.isEmpty()){
                            ca.danificado.set(q, true);
                        }
                    }
                }
            }
        }
    }