/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.mirrorlink;

public class Action {
    public int actionId;
    public String actionName;
    public boolean launchApp;

    public Action() {
        this.actionId = 0;
        this.actionName = "";
        this.launchApp = false;
    }

    public Action(int n, String string, boolean bl) {
        this.actionId = n;
        this.actionName = string;
        this.launchApp = bl;
    }

    public int getActionId() {
        return this.actionId;
    }

    public String getActionName() {
        return this.actionName;
    }

    public boolean isLaunchApp() {
        return this.launchApp;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(200);
        stringBuffer.append("Action");
        stringBuffer.append('(');
        stringBuffer.append("actionId");
        stringBuffer.append('=');
        stringBuffer.append(this.actionId);
        stringBuffer.append(',');
        stringBuffer.append("actionName");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.actionName);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("launchApp");
        stringBuffer.append('=');
        stringBuffer.append(this.launchApp);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

