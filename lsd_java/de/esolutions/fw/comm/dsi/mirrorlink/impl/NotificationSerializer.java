/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.mirrorlink.impl;

import de.esolutions.fw.comm.dsi.mirrorlink.impl.ActionSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.mirrorlink.Action;
import org.dsi.ifc.mirrorlink.Notification;

public class NotificationSerializer {
    public static void putOptionalNotification(ISerializer iSerializer, Notification notification) {
        boolean bl = notification == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = notification.getNotiID();
            iSerializer.putInt32(n);
            String string = notification.getTitle();
            iSerializer.putOptionalString(string);
            String string2 = notification.getNotiBody();
            iSerializer.putOptionalString(string2);
            int n2 = notification.getAppId();
            iSerializer.putInt32(n2);
            Action[] actionArray = notification.getActionList();
            ActionSerializer.putOptionalActionVarArray(iSerializer, actionArray);
        }
    }

    public static void putOptionalNotificationVarArray(ISerializer iSerializer, Notification[] notificationArray) {
        boolean bl = notificationArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(notificationArray.length);
            for (int i2 = 0; i2 < notificationArray.length; ++i2) {
                NotificationSerializer.putOptionalNotification(iSerializer, notificationArray[i2]);
            }
        }
    }

    public static Notification getOptionalNotification(IDeserializer iDeserializer) {
        Notification notification = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            String string;
            String string2;
            int n2;
            notification = new Notification();
            notification.notiID = n2 = iDeserializer.getInt32();
            notification.title = string2 = iDeserializer.getOptionalString();
            notification.notiBody = string = iDeserializer.getOptionalString();
            notification.appId = n = iDeserializer.getInt32();
            Action[] actionArray = ActionSerializer.getOptionalActionVarArray(iDeserializer);
            notification.actionList = actionArray;
        }
        return notification;
    }

    public static Notification[] getOptionalNotificationVarArray(IDeserializer iDeserializer) {
        Notification[] notificationArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            notificationArray = new Notification[n];
            for (int i2 = 0; i2 < n; ++i2) {
                notificationArray[i2] = NotificationSerializer.getOptionalNotification(iDeserializer);
            }
        }
        return notificationArray;
    }
}

