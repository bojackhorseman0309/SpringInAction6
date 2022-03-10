package tacos.kitchen.messaging.jms;

import tacos.TacoOrder;

import javax.jms.JMSException;

public interface OrderReceiver {

    TacoOrder receiveOrder() throws JMSException;

}