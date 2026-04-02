import ContasDoBanco.Banco;
import ContasDoBanco.Conta;
import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Banco banco = new Banco();
        Scanner scan = new Scanner(System.in);

        int opcao;

        do {
            System.out.println("\n1 - Criar conta");
            System.out.println("2 - Depositar");
            System.out.println("3 - Sacar");
            System.out.println("4 - Ver saldo");
            System.out.println("5 - Transferir");
            System.out.println("0 - Sair");

            opcao = scan.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Número da conta: ");
                    int numero = scan.nextInt();
                    scan.nextLine();

                    System.out.print("Nome do titular: ");
                    String titular = scan.nextLine();

                    banco.criarConta(numero, titular);
                    break;

                case 2:
                    System.out.print("Número da conta: ");
                    int numDep = scan.nextInt();

                    Conta contaDep = banco.buscarConta(numDep);

                    if (contaDep != null) {
                        System.out.print("Valor: ");
                        double valor = scan.nextDouble();
                        contaDep.depositar(valor);
                    }
                    break;

                case 3:
                    System.out.print("Número da conta: ");
                    numDep = scan.nextInt();

                    contaDep = banco.buscarConta(numDep);

                    if (contaDep != null) {
                        System.out.print("Valor: ");
                        double valor = scan.nextDouble();
                        contaDep.sacar(valor);
                    }
                    break;

                case 4:
                    System.out.print("Número da conta: ");
                    numDep = scan.nextInt();

                    contaDep = banco.buscarConta(numDep);

                    if (contaDep != null) {
                        contaDep.exibirSaldo();
                    }
                    break;

                case 5:
                    System.out.print("Conta de origem: ");
                    int origem = scan.nextInt();

                    System.out.print("Conta de destino: ");
                    int destino = scan.nextInt();

                    Conta contaOrigem = banco.buscarConta(origem);
                    Conta contaDestino = banco.buscarConta(destino);

                    if (contaOrigem != null && contaDestino != null) {
                        System.out.print("Valor da transferência: ");
                        double valor = scan.nextDouble();

                        contaOrigem.transferir(contaDestino, valor);
                    } else {
                        System.out.println("Conta não encontrada!");
                    }
                    if (origem == destino) {
                        System.out.println("Não é possível transferir para a mesma conta.");

                    }
                    break;
            }


        } while (opcao != 0);

        banco.salvarContas();
    }
}