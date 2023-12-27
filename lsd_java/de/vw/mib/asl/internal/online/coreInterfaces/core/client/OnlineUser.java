/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.coreInterfaces.core.client;

import de.vw.mib.util.Util;

public class OnlineUser {
    private int _userID;
    private String _userName;
    private int _userType;

    public int getUserID() {
        return this._userID;
    }

    public void setUserID(int n) {
        this._userID = n;
    }

    public String getUserName() {
        return this._userName;
    }

    public void setUserName(String string) {
        this._userName = string;
    }

    public int getUserType() {
        return this._userType;
    }

    public void setUserType(int n) {
        this._userType = n;
    }

    public void copyTo(OnlineUser onlineUser) {
        if (onlineUser != null && this != onlineUser) {
            this._userID = onlineUser.getUserID();
            this._userName = onlineUser.getUserName();
            this._userType = onlineUser.getUserType();
        }
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(300);
        stringBuffer.append("OnlineUser");
        stringBuffer.append('(');
        stringBuffer.append("UserName");
        stringBuffer.append('=');
        stringBuffer.append(!Util.isNullOrEmpty(this._userName) ? this._userName : "");
        stringBuffer.append(',');
        stringBuffer.append('\"');
        stringBuffer.append("UserID");
        stringBuffer.append('=');
        stringBuffer.append(this._userID);
        stringBuffer.append(',');
        stringBuffer.append('\"');
        stringBuffer.append("UserType");
        stringBuffer.append('=');
        stringBuffer.append(this._userType);
        stringBuffer.append('}');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

