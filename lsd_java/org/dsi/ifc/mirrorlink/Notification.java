/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.mirrorlink;

import org.dsi.ifc.mirrorlink.Action;

public class Notification {
    public int notiID;
    public String title;
    public String notiBody;
    public int appId;
    public Action[] actionList;

    public Notification() {
        this.notiID = 0;
        this.title = "";
        this.notiBody = "";
        this.appId = 0;
        this.actionList = null;
    }

    public Notification(int n, String string, String string2, int n2, Action[] actionArray) {
        this.notiID = n;
        this.title = string;
        this.notiBody = string2;
        this.appId = n2;
        this.actionList = actionArray;
    }

    public int getNotiID() {
        return this.notiID;
    }

    public String getTitle() {
        return this.title;
    }

    public String getNotiBody() {
        return this.notiBody;
    }

    public int getAppId() {
        return this.appId;
    }

    public Action[] getActionList() {
        return this.actionList;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(300);
        stringBuffer.append("Notification");
        stringBuffer.append('(');
        stringBuffer.append("notiID");
        stringBuffer.append('=');
        stringBuffer.append(this.notiID);
        stringBuffer.append(',');
        stringBuffer.append("title");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.title);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("notiBody");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.notiBody);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("appId");
        stringBuffer.append('=');
        stringBuffer.append(this.appId);
        stringBuffer.append(',');
        stringBuffer.append("actionList");
        stringBuffer.append('[');
        if (this.actionList != null) {
            stringBuffer.append(this.actionList.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.actionList != null) {
            int n = this.actionList.length;
            int n2 = n - 1;
            for (int i2 = 0; i2 < n; ++i2) {
                stringBuffer.append(this.actionList[i2]);
                if (i2 >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.actionList);
        }
        stringBuffer.append('}');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

