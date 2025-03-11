package br.edu.ifpb.pp.factory;

import br.edu.ifpb.pp.api.SMSSender;
import br.edu.ifpb.pp.api.TimService;
import br.edu.ifpb.pp.api.VivoService;

public class SMSSenderFactory {
    public static SMSSender getSender(String numero) {
        return switch (numero.substring(0, 2)) {
            // Tim
            case "41" -> TimService.getInstance();
            // Vivo
            case "15" -> VivoService.getInstance();
            // Oi/Outras operadoras
            default -> throw new IllegalArgumentException("Operadora não suportada");
        };
    }
}
