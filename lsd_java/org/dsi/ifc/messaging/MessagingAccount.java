/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.messaging;

public class MessagingAccount {
    public int accountID;
    public String accountName;
    public int accountType;
    public int supportsSMS;
    public boolean supportsEMail;
    public int offeredFolderTypes;
    public int memoryStatus;
    public int unreadMessageCount;
    public String btDeviceAddress;
    public String btUserFriendlyName;
    public String simCardId;

    public MessagingAccount() {
        this.accountID = -1;
        this.accountName = "";
        this.supportsSMS = 0;
        this.supportsEMail = false;
        this.offeredFolderTypes = 0;
        this.memoryStatus = 0;
        this.unreadMessageCount = 0;
        this.btDeviceAddress = "";
        this.btUserFriendlyName = "";
        this.simCardId = "";
    }

    public MessagingAccount(int n, String string, int n2, int n3, boolean bl, int n4, int n5, int n6, String string2, String string3, String string4) {
        this.accountID = n;
        this.accountName = string;
        this.accountType = n2;
        this.supportsSMS = n3;
        this.supportsEMail = bl;
        this.offeredFolderTypes = n4;
        this.memoryStatus = n5;
        this.unreadMessageCount = n6;
        this.btDeviceAddress = string2;
        this.btUserFriendlyName = string3;
        this.simCardId = string4;
    }

    public int getAccountID() {
        return this.accountID;
    }

    public String getAccountName() {
        return this.accountName;
    }

    public int getAccountType() {
        return this.accountType;
    }

    public int getSupportsSMS() {
        return this.supportsSMS;
    }

    public boolean isSupportsEMail() {
        return this.supportsEMail;
    }

    public int getOfferedFolderTypes() {
        return this.offeredFolderTypes;
    }

    public int getMemoryStatus() {
        return this.memoryStatus;
    }

    public int getUnreadMessageCount() {
        return this.unreadMessageCount;
    }

    public String getBtDeviceAddress() {
        return this.btDeviceAddress;
    }

    public String getBtUserFriendlyName() {
        return this.btUserFriendlyName;
    }

    public String getSimCardId() {
        return this.simCardId;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(750);
        stringBuffer.append("MessagingAccount");
        stringBuffer.append('(');
        stringBuffer.append("accountID");
        stringBuffer.append('=');
        stringBuffer.append(this.accountID);
        stringBuffer.append(',');
        stringBuffer.append("accountName");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.accountName);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("accountType");
        stringBuffer.append('=');
        stringBuffer.append(this.accountType);
        stringBuffer.append(',');
        stringBuffer.append("supportsSMS");
        stringBuffer.append('=');
        stringBuffer.append(this.supportsSMS);
        stringBuffer.append(',');
        stringBuffer.append("supportsEMail");
        stringBuffer.append('=');
        stringBuffer.append(this.supportsEMail);
        stringBuffer.append(',');
        stringBuffer.append("offeredFolderTypes");
        stringBuffer.append('=');
        stringBuffer.append(this.offeredFolderTypes);
        stringBuffer.append(',');
        stringBuffer.append("memoryStatus");
        stringBuffer.append('=');
        stringBuffer.append(this.memoryStatus);
        stringBuffer.append(',');
        stringBuffer.append("unreadMessageCount");
        stringBuffer.append('=');
        stringBuffer.append(this.unreadMessageCount);
        stringBuffer.append(',');
        stringBuffer.append("btDeviceAddress");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.btDeviceAddress);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("btUserFriendlyName");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.btUserFriendlyName);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("simCardId");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.simCardId);
        stringBuffer.append('\"');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

