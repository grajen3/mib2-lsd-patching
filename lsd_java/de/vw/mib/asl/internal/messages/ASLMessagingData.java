/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.messages;

import java.util.HashSet;
import org.dsi.ifc.messaging.AttachmentInformation;
import org.dsi.ifc.messaging.MessagingAccount;
import org.dsi.ifc.organizer.AdbViewSize;
import org.dsi.ifc.organizer.DataSet;

public final class ASLMessagingData {
    public static int addressbookSize = 0;
    public static AttachmentInformation vCard = null;
    public static AdbViewSize viewSizeContacts = null;
    private static int defaultAccount = 0;
    private static MessagingAccount[] messagingAccounts = new MessagingAccount[0];
    public static HashSet newMessagesSetInternal = new HashSet();
    public static HashSet newMessagesSetExternal = new HashSet();
    public static long selectedContactEntryId = 0L;
    public static DataSet hwrResult = null;
    private static boolean temporarySavedMessage;
    public static MessagingAccount[] messagingAccountsDSI;

    private ASLMessagingData() {
    }

    public static void setTemporarySavedMessage(boolean bl) {
        temporarySavedMessage = bl;
    }

    public static boolean isTemporarySavedMessage() {
        return temporarySavedMessage;
    }

    public static int getDefaultAccount() {
        return defaultAccount;
    }

    public static int setDefaultAccount(int n) {
        defaultAccount = n;
        return n;
    }

    public static MessagingAccount[] getMessagingAccounts() {
        return messagingAccounts;
    }

    public static void setMessagingAccounts(MessagingAccount[] messagingAccountArray) {
        messagingAccounts = messagingAccountArray;
    }

    static {
        messagingAccountsDSI = new MessagingAccount[0];
    }
}

