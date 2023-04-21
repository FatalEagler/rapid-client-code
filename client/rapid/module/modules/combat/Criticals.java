package client.rapid.module.modules.combat;

import client.rapid.event.events.Event;
import client.rapid.event.events.game.EventPacket;
import client.rapid.event.events.player.EventMotion;
import client.rapid.module.*;
import client.rapid.module.modules.Category;
import client.rapid.module.settings.Setting;
import client.rapid.util.*;
import net.minecraft.network.play.client.*;

@ModuleInfo(getName = "Criticals", getCategory = Category.COMBAT)
public class Criticals extends Module {
	private final Setting
	mode = new Setting("Mode", this, "Vanilla", "No Ground", "NCP"),
	delay = new Setting("Delay", this, 1000, 0, 2000, true);

	private final TimerUtil timer = new TimerUtil();

	public Criticals() {
		add(mode, delay);
	}
	
	public void onEnable() {
		if(mode.getMode().equals("No Ground") && mc.thePlayer.onGround)
			mc.thePlayer.jump();
	}
	
	public void onEvent(Event e) {
		if(e instanceof EventMotion && e.isPre()) {
			setTag(mode.getMode());

			if(mode.getMode().equals("No Ground") && mc.thePlayer.onGround)
				((EventMotion)e).setGround(false);
		}
		if(e instanceof EventPacket && e.isPre() && !((EventPacket)e).isIncoming()) {
			EventPacket event = (EventPacket)e;

			switch(mode.getMode()) {
				case "Vanilla":
				case "NCP":
				if(event.getPacket() instanceof C02PacketUseEntity) {
					C02PacketUseEntity packet = event.getPacket();

					if(packet.getAction() == C02PacketUseEntity.Action.ATTACK && mc.thePlayer.onGround && !mc.thePlayer.isInWater() && timer.sleep((int)delay.getValue())) {
						if (mode.getMode().equals("Vanilla")) {
							double[] heights = new double[] {0.013D, 0.012D, 0.011D, 0.01D};

							for (double height : heights)
								PacketUtil.sendPacketSilent(new C03PacketPlayer.C04PacketPlayerPosition(mc.thePlayer.posX, mc.thePlayer.posY + height, mc.thePlayer.posZ, false));
						} else {
							double[] heights = new double[] {0.11, 0.11001, 0.00003};

							for(double height : heights)
								PacketUtil.sendPacketSilent(new C03PacketPlayer.C04PacketPlayerPosition(mc.thePlayer.posX, mc.thePlayer.posY + height, mc.thePlayer.posZ, false));
						}
					}
				}
				break;
			}
		}
	}
}
