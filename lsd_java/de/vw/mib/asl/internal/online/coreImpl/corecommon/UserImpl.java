/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.coreImpl.corecommon;

import de.vw.mib.asl.internal.online.coreInterfaces.core.server.User;
import de.vw.mib.util.Util;

public class UserImpl
implements User {
    private int _userID;
    private String _userName;
    private int _deviceID;
    private boolean _mainUser;
    private int _userType;

    @Override
    public void setUserName(String string) {
        this._userName = string;
    }

    @Override
    public String getUserName() {
        return this._userName;
    }

    @Override
    public void setUserID(int n) {
        this._userID = n;
    }

    @Override
    public int getUserID() {
        return this._userID;
    }

    @Override
    public void setDeviceID(int n) {
        this._deviceID = n;
    }

    @Override
    public int getDeviceID() {
        return this._deviceID;
    }

    @Override
    public void setAsMainUser(boolean bl) {
        this._mainUser = bl;
    }

    @Override
    public boolean isMainUser() {
        return this._mainUser;
    }

    @Override
    public void setUserType(int n) {
        this._userType = n;
    }

    @Override
    public int getUserType() {
        return this._userType;
    }

    @Override
    public void copyTo(User user) {
        if (user != null) {
            this._userID = user.getUserID();
            this._userName = new String(user.getUserName());
            this._mainUser = user.isMainUser();
            this._userType = user.getUserType();
        }
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(300);
        stringBuffer.append("User");
        stringBuffer.append('(');
        stringBuffer.append("UserID");
        stringBuffer.append('=');
        stringBuffer.append(this._userID);
        stringBuffer.append(',');
        stringBuffer.append("UserName");
        stringBuffer.append('=');
        stringBuffer.append(!Util.isNullOrEmpty(this._userName) ? this._userName : "");
        stringBuffer.append(',');
        stringBuffer.append("DeviceID");
        stringBuffer.append('=');
        stringBuffer.append(this._deviceID);
        stringBuffer.append(',');
        stringBuffer.append("MainUser");
        stringBuffer.append('=');
        stringBuffer.append(this._mainUser);
        stringBuffer.append(',');
        stringBuffer.append("UserType");
        stringBuffer.append('=');
        stringBuffer.append(this._userType);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }

    @Override
    public boolean equalsTo(User user) {
        if (user == null) {
            return false;
        }
        if (this._userID != user.getUserID()) {
            return false;
        }
        if (!this._userName.equalsIgnoreCase(user.getUserName())) {
            return false;
        }
        if (this._mainUser != user.isMainUser()) {
            return false;
        }
        return this._userType == user.getUserType();
    }
}

