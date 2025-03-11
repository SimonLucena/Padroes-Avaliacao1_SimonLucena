package br.edu.ifpb.pp.api;

import br.edu.ifpb.pp.model.SMS;
import java.time.format.DateTimeFormatter;

public class TimService implements SMSSender{
	private static TimService instance;

	private TimService() {} // Construtor privado evita instâncias externas

	public static TimService getInstance() {
		if (instance == null) {
			instance = new TimService();
		}
		return instance;
	}

	@Override
	public boolean sendSMS(SMS sms) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");   
		System.out.println("Tim SMS - " + dtf.format(sms.getTimestamp()));
		System.out.println("-------------------");
		System.out.println("From: " + sms.getOrigem());
		System.out.println("To  : " + sms.getDestino());
		System.out.println("-------------------");
		System.out.println(sms.getTexto());
		System.out.println("-------------------");
		System.out.println("Mensagem enviada com sucesso para o número da operadora TIM");
		System.out.println();
		return true;
	}

}
