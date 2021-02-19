package messaggi;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * Message-Driven Bean implementation class for: InviaMessaggio
 */
@MessageDriven(
		activationConfig = { @ActivationConfigProperty(
				propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
		@ActivationConfigProperty(
				propertyName = "destination", propertyValue = "java:/jms/queue/biblioteca")
		})
public class InviaMessaggio implements MessageListener {

    /**
     * Default constructor. 
     */
    public InviaMessaggio() {
        // TODO Auto-generated constructor stub
    }
	
	/**
     * @see MessageListener#onMessage(Message)
     */
    public void onMessage(Message message) {
        // TODO Auto-generated method stub
        TextMessage messaggio = (TextMessage) message;
        try {
			System.out.println("Messaggio ricevuto: "+ messaggio.getText());
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

}
