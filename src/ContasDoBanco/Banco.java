package ContasDoBanco;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Banco {

    private ArrayList<Conta> contas = new ArrayList<>();

    public void salvarContas() {
        try {
            FileWriter writer = new FileWriter("contas.txt");

            for (Conta c : contas) {
                writer.write(c.getNumero() + ";" + c.getTitular() + ";" + c.getSaldo() + "\n");
            }

            writer.close();
            System.out.println("Contas salvas com sucesso!");

        } catch (IOException e) {
            System.out.println("Erro ao salvar contas.");
        }
    }

    public void criarConta(int numero, String titular) {
        if (buscarConta(numero) != null) {
            System.out.println("Conta já existe!");
        } else {
            contas.add(new Conta(numero, titular));
            System.out.println("Conta criada!");
        }
    }

    public Conta buscarConta(int numero) {
        for (Conta c : contas) {
            if (c.getNumero() == numero) {
                return c;
            }
        }
        return null;
    }
}