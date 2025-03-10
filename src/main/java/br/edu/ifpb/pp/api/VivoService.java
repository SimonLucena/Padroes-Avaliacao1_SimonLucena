package br.edu.ifpb.pp.api;

import br.edu.ifpb.pp.adapters.sms.SMSAdapter;
import br.edu.ifpb.pp.adapters.sms.SMSVivoMessageAdapter;
import br.edu.ifpb.pp.model.SMS;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class VivoService implements SMSSender {
	private final SMSAdapter adapter = new SMSVivoMessageAdapter();

	@Override
	public boolean sendSMS(SMS sms) {
		try {
			enviarSMS(sms.getOrigem(), sms.getDestino(), sms.getTimestamp(), adapter.getMessage(sms, 120));
		} catch (SMSException e) {
			throw new RuntimeException(e);
		}
		return true;
	}

	public void enviarSMS(String origem, String destino, LocalDateTime time, String[] msgs) throws SMSException {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

		if (msgs.length == 0){
			throw new SMSException("Mensagem vazia. Nao e possivel o envio");
		}

		System.out.println("Vivo SMS");
		System.out.println("Enviado em " + dtf.format(time));
		System.out.println("-------------------");
		System.out.println("From: " + origem);
		System.out.println("To: " + destino);
		System.out.println("-------------------");
        for (String msg : msgs) {
            System.out.printf("-> %s%n", msg);
        }
		System.out.println("-------------------");
		System.out.println("Mensagem enviada com sucesso para o número da operadora Vivo");
	}
}
