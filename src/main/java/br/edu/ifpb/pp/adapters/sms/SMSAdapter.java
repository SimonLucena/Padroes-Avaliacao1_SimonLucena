package br.edu.ifpb.pp.adapters.sms;

import br.edu.ifpb.pp.model.SMS;

public interface SMSAdapter {
    String[] getMessage(SMS sms, int tamanhoMaximoMensagem);
}
