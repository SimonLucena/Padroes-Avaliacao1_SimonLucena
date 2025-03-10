package br.edu.ifpb.pp.factory;

import br.edu.ifpb.pp.api.SMSSender;
import br.edu.ifpb.pp.api.TimService;
import br.edu.ifpb.pp.api.VivoService;

public class SMSSenderFactory {
    private static final SMSSender timSender = new TimService();
    private static final SMSSender vivoSender = new VivoService();

    public static SMSSender getSender(String numero) {
        return switch (numero.substring(0, 2)) {
            // Tim
            case "41" -> timSender;
            // Vivo
            case "15" -> vivoSender;
            // Oi/Outras operadoras
            default -> throw new IllegalArgumentException("Operadora não suportada");
        };
    }
}
