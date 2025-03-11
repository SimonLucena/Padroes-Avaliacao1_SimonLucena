package br.edu.ifpb.pp.model;

import br.edu.ifpb.pp.adapters.translator.TranslatorWhatsMate;
import br.edu.ifpb.pp.api.SMSSender;
import br.edu.ifpb.pp.factory.SMSSenderFactory;

import java.util.Scanner;

public class ProcessarSMS {
    public boolean enviar(SMS sms, boolean traducao) throws Exception {
        if (traducao) {
            TranslatorWhatsMate translator = new TranslatorWhatsMate();
            sms.setTexto(translator.translate(sms.getTexto(), "pt"));
        }

        SMSSender smsSender = SMSSenderFactory.getSender(sms.getDestino());
        return smsSender.sendSMS(sms);
    }
}
