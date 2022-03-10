package tacos.kitchen.messaging.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.stereotype.Component;
import tacos.TacoOrder;

import javax.jms.JMSException;
import javax.jms.Message;

@Component
public class JmsOrderReceiver implements OrderReceiver {
    private JmsTemplate jms;
    private MessageConverter converter;

    @Autowired
    public JmsOrderReceiver(JmsTemplate jms, MessageConverter converter) {
        this.jms = jms;
        this.converter = converter;
    }

    public TacoOrder receiveOrder() throws JMSException {
        return (TacoOrder) jms.receiveAndConvert("tacocloud.order.queue");
    }
}
