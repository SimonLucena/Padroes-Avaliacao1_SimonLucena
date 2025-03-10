package br.edu.ifpb.pp.adapters.sms;

import br.edu.ifpb.pp.model.SMS;

import java.util.ArrayList;
import java.util.List;

public class SMSVivoMessageAdapter implements SMSAdapter {
    @Override
    public String[] getMessage(SMS sms, int tamanhoMaxMensagem) {
        List<String> parts = new ArrayList<>();
        int start = 0;

        String message = sms.getTexto();

        while (start < message.length()) {
            int end = Math.min(start + tamanhoMaxMensagem, message.length());

            if(end < message.length() && message.charAt(end) != ' ') {
                int lastSpace = message.lastIndexOf(' ', end);
                if(lastSpace > start) {
                    end = lastSpace;
                }
            }

            parts.add(message.substring(start, end).trim());
            start = end+1;
        }

        return parts.toArray(new String[0]);
    }
}
