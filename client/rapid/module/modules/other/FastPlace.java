package client.rapid.module.modules.other;

import client.rapid.event.events.Event;
import client.rapid.event.events.player.EventMotion;
import client.rapid.event.events.player.EventUpdate;
import client.rapid.module.*;
import client.rapid.module.modules.Category;
import client.rapid.module.settings.Setting;

@ModuleInfo(getName = "Fast Place", getCategory = Category.OTHER)
public class FastPlace extends Module {
    private Setting delay = new Setting("Delay", this, 0, 0, 5, true);

    public FastPlace() {
        add(delay);
    }

    public void onDisable() {
        mc.rightClickDelayTimer = 6;
    }

    public void onEvent(Event e) {
        if(e instanceof EventUpdate && e.isPre()) {
            mc.rightClickDelayTimer = (int) delay.getValue();
        }
    }
}