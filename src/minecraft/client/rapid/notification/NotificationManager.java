package client.rapid.notification;

import client.rapid.Wrapper;

import java.util.concurrent.LinkedBlockingQueue;

public class NotificationManager {
    private static final LinkedBlockingQueue<Notification> queue = new LinkedBlockingQueue<>();
    private static final Notification[] nots = new Notification[100];

    public static void addToQueue(Notification notification) {
        queue.add(notification);
    }

    public static void update() {
        for(int i = 0; i < Wrapper.getSettingsManager().getSettingByName("Notifications", "Amount").getValue(); i++) {
            if(nots[i] != null && !nots[i].isShown()) {
                nots[i].timer.reset();
                nots[i] = null;
            }

            if(nots[i] == null && !queue.isEmpty()) {
                nots[i] = queue.poll();
                nots[i].start();
                nots[i].timer.reset();
            }
        }
    }

    public static void render(int x, int y) {
        update();

        int i = 0;
        for(Notification notification : nots) {
            if(notification != null)
                notification.render(x, y - i);

            i += 26;
        }
    }

    public static LinkedBlockingQueue<Notification> getQueue() {
        return queue;
    }

}