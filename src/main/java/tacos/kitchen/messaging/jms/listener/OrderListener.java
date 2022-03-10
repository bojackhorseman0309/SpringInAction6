package tacos.kitchen.messaging.jms.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import tacos.TacoOrder;
@Profile("jms-listener")
@Component
public class OrderListener {
    private KitchenUI ui;
    @Autowired
    public OrderListener(KitchenUI ui) {
        this.ui = ui;
    }
    @JmsListener(destination = "tacocloud.order.queue")
    public void receiveOrder(TacoOrder order) {
        ui.displayOrder(order);
    }
}