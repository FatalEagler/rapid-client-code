package client.rapid.module.modules.visual;

import client.rapid.event.events.Event;
import client.rapid.event.events.game.EventPacket;
import client.rapid.event.events.player.EventMotion;
import client.rapid.module.Module;
import client.rapid.module.ModuleInfo;
import client.rapid.module.modules.Category;
import client.rapid.module.settings.Setting;
import net.minecraft.network.play.server.S03PacketTimeUpdate;

@ModuleInfo(getName = "Time Changer", getCategory = Category.VISUAL)
public class TimeChanger extends Module {
    private final Setting time = new Setting("Time", this, 17000, 0, 25000, true);

    public TimeChanger() {
        add(time);
    }

    @Override
    public void onEvent(Event e) {
        if(e instanceof EventPacket && e.isPre()) {
            EventPacket event = (EventPacket)e;
           if(event.getPacket() instanceof S03PacketTimeUpdate)
               event.cancel();
        }
        if(e instanceof EventMotion && e.isPre())
            mc.theWorld.setWorldTime((long)time.getValue());
    }
}
