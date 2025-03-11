package br.edu.ifpb.pp;

import br.edu.ifpb.pp.model.ProcessarSMS;
import br.edu.ifpb.pp.model.SMS;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner reader = new Scanner(System.in);

        Map<Integer, String[]> contatos = new HashMap<>();
        contatos.put(1, new String[]{"Antonio(Vivo)", "1583987142899"});
        contatos.put(2, new String[]{"Jessica(Vivo)", "1583994022319"});
        contatos.put(3, new String[]{"João(Tim)", "4183988221133"});
        contatos.put(4, new String[]{"Maria(Tim)", "4183997426871"});

        String origem = "1583988885544";
        System.out.printf("Serviço de envio de SMS | [%s]%n%n", origem);

        // Padrão: " Bom dia. Seu boleto ja esta disponivel para pagamento. "
        System.out.println("Digite a mensagem: ");
        String mensagem = reader.nextLine();

        System.out.println("Selecione o contato que deseja enviar a mensagem: ");
        for (Map.Entry<Integer, String[]> entry : contatos.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue()[0]);
        }

        System.out.print("Digite o número do contato escolhido: ");
        int escolha = reader.nextInt();
        reader.nextLine(); // Consumir a quebra de linha

        // Validar a escolha
        if (!contatos.containsKey(escolha)) {
            System.out.println("Opção inválida! Encerrando o programa.");
            return;
        }
        String destino = contatos.get(escolha)[1];
        System.out.println();

        System.out.print("Deseja traduzir a mensagem para português? (s/N): ");
        String resposta = reader.nextLine().trim().toLowerCase();

        SMS sms = new SMS(origem,destino,mensagem);

        ProcessarSMS envio = new ProcessarSMS();
        if(!envio.enviar(sms,resposta.equals("s"))){
            System.out.println("Falha ao enviar o SMS");
        }

        reader.close();
    }
}