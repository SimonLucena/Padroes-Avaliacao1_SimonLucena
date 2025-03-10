package br.edu.ifpb.pp.api;

import br.edu.ifpb.pp.model.SMS;

public interface SMSSender {

	boolean sendSMS(SMS sms);
}
