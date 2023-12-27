/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.messaging.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.messaging.MessagingAccount;

public class MessagingAccountSerializer {
    public static void putOptionalMessagingAccount(ISerializer iSerializer, MessagingAccount messagingAccount) {
        boolean bl = messagingAccount == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = messagingAccount.getAccountID();
            iSerializer.putInt32(n);
            String string = messagingAccount.getAccountName();
            iSerializer.putOptionalString(string);
            int n2 = messagingAccount.getAccountType();
            iSerializer.putInt32(n2);
            int n3 = messagingAccount.getSupportsSMS();
            iSerializer.putInt32(n3);
            boolean bl2 = messagingAccount.isSupportsEMail();
            iSerializer.putBool(bl2);
            int n4 = messagingAccount.getOfferedFolderTypes();
            iSerializer.putInt32(n4);
            int n5 = messagingAccount.getMemoryStatus();
            iSerializer.putInt32(n5);
            int n6 = messagingAccount.getUnreadMessageCount();
            iSerializer.putInt32(n6);
            String string2 = messagingAccount.getBtDeviceAddress();
            iSerializer.putOptionalString(string2);
            String string3 = messagingAccount.getBtUserFriendlyName();
            iSerializer.putOptionalString(string3);
            String string4 = messagingAccount.getSimCardId();
            iSerializer.putOptionalString(string4);
        }
    }

    public static void putOptionalMessagingAccountVarArray(ISerializer iSerializer, MessagingAccount[] messagingAccountArray) {
        boolean bl = messagingAccountArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(messagingAccountArray.length);
            for (int i2 = 0; i2 < messagingAccountArray.length; ++i2) {
                MessagingAccountSerializer.putOptionalMessagingAccount(iSerializer, messagingAccountArray[i2]);
            }
        }
    }

    public static MessagingAccount getOptionalMessagingAccount(IDeserializer iDeserializer) {
        MessagingAccount messagingAccount = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            String string;
            String string2;
            String string3;
            int n;
            int n2;
            int n3;
            boolean bl2;
            int n4;
            int n5;
            String string4;
            int n6;
            messagingAccount = new MessagingAccount();
            messagingAccount.accountID = n6 = iDeserializer.getInt32();
            messagingAccount.accountName = string4 = iDeserializer.getOptionalString();
            messagingAccount.accountType = n5 = iDeserializer.getInt32();
            messagingAccount.supportsSMS = n4 = iDeserializer.getInt32();
            messagingAccount.supportsEMail = bl2 = iDeserializer.getBool();
            messagingAccount.offeredFolderTypes = n3 = iDeserializer.getInt32();
            messagingAccount.memoryStatus = n2 = iDeserializer.getInt32();
            messagingAccount.unreadMessageCount = n = iDeserializer.getInt32();
            messagingAccount.btDeviceAddress = string3 = iDeserializer.getOptionalString();
            messagingAccount.btUserFriendlyName = string2 = iDeserializer.getOptionalString();
            messagingAccount.simCardId = string = iDeserializer.getOptionalString();
        }
        return messagingAccount;
    }

    public static MessagingAccount[] getOptionalMessagingAccountVarArray(IDeserializer iDeserializer) {
        MessagingAccount[] messagingAccountArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            messagingAccountArray = new MessagingAccount[n];
            for (int i2 = 0; i2 < n; ++i2) {
                messagingAccountArray[i2] = MessagingAccountSerializer.getOptionalMessagingAccount(iDeserializer);
            }
        }
        return messagingAccountArray;
    }
}

