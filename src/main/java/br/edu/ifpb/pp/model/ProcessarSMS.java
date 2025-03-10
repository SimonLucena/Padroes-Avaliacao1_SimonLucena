package br.edu.ifpb.pp.model;

import br.edu.ifpb.pp.adapters.translator.TranslatorAdapter;
import br.edu.ifpb.pp.adapters.translator.TranslatorWhatsMateAdapter;
import br.edu.ifpb.pp.api.SMSSender;
import br.edu.ifpb.pp.factory.SMSSenderFactory;

import java.util.Scanner;

public class ProcessarSMS {
    public boolean enviar(SMS sms, Scanner reader) throws Exception {
        System.out.print("Deseja traduzir a mensagem para português? (s/N): ");
        String resposta = reader.nextLine().trim().toLowerCase();

        if (resposta.equals("s")) {
            TranslatorAdapter translator = new TranslatorWhatsMateAdapter();
            sms.setTexto(translator.translate(sms.getTexto(), "pt"));
        }

        SMSSender smsSender = SMSSenderFactory.getSender(sms.getDestino());
        return smsSender.sendSMS(sms);
    }
}
