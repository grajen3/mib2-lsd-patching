/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.sdars.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.sdars.SubscriptionStatus;

public class SubscriptionStatusSerializer {
    public static void putOptionalSubscriptionStatus(ISerializer iSerializer, SubscriptionStatus subscriptionStatus) {
        boolean bl = subscriptionStatus == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = subscriptionStatus.getSubscription();
            iSerializer.putInt32(n);
            int n2 = subscriptionStatus.getReasonCode();
            iSerializer.putInt32(n2);
            int n3 = subscriptionStatus.getSuspendDay();
            iSerializer.putInt32(n3);
            int n4 = subscriptionStatus.getSuspendMonth();
            iSerializer.putInt32(n4);
            int n5 = subscriptionStatus.getSuspendYear();
            iSerializer.putInt32(n5);
            String string = subscriptionStatus.getReasonText();
            iSerializer.putOptionalString(string);
            String string2 = subscriptionStatus.getPhoneNumber();
            iSerializer.putOptionalString(string2);
        }
    }

    public static void putOptionalSubscriptionStatusVarArray(ISerializer iSerializer, SubscriptionStatus[] subscriptionStatusArray) {
        boolean bl = subscriptionStatusArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(subscriptionStatusArray.length);
            for (int i2 = 0; i2 < subscriptionStatusArray.length; ++i2) {
                SubscriptionStatusSerializer.putOptionalSubscriptionStatus(iSerializer, subscriptionStatusArray[i2]);
            }
        }
    }

    public static SubscriptionStatus getOptionalSubscriptionStatus(IDeserializer iDeserializer) {
        SubscriptionStatus subscriptionStatus = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            String string;
            String string2;
            int n;
            int n2;
            int n3;
            int n4;
            int n5;
            subscriptionStatus = new SubscriptionStatus();
            subscriptionStatus.subscription = n5 = iDeserializer.getInt32();
            subscriptionStatus.reasonCode = n4 = iDeserializer.getInt32();
            subscriptionStatus.suspendDay = n3 = iDeserializer.getInt32();
            subscriptionStatus.suspendMonth = n2 = iDeserializer.getInt32();
            subscriptionStatus.suspendYear = n = iDeserializer.getInt32();
            subscriptionStatus.reasonText = string2 = iDeserializer.getOptionalString();
            subscriptionStatus.phoneNumber = string = iDeserializer.getOptionalString();
        }
        return subscriptionStatus;
    }

    public static SubscriptionStatus[] getOptionalSubscriptionStatusVarArray(IDeserializer iDeserializer) {
        SubscriptionStatus[] subscriptionStatusArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            subscriptionStatusArray = new SubscriptionStatus[n];
            for (int i2 = 0; i2 < n; ++i2) {
                subscriptionStatusArray[i2] = SubscriptionStatusSerializer.getOptionalSubscriptionStatus(iDeserializer);
            }
        }
        return subscriptionStatusArray;
    }
}

