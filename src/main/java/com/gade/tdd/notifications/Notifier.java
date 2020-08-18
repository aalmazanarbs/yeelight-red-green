package com.gade.tdd.notifications;

import com.intellij.notification.Notification;
import com.intellij.notification.NotificationDisplayType;
import com.intellij.notification.NotificationGroup;
import com.intellij.notification.NotificationType;

public class Notifier {

    private final NotificationGroup NOTIFICATION_GROUP = new NotificationGroup("Yeelight Red Green Notifications",
                                                                               NotificationDisplayType.STICKY_BALLOON,
                                                                    true);

    public void notifyError(final String text) {
        final Notification notification = NOTIFICATION_GROUP.createNotification(text, NotificationType.ERROR);
        notification.notify(null);
    }
}
