/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.mirrorlink;

import org.dsi.ifc.global.ResourceLocator;

public class Application {
    public int appID;
    public String appName;
    public int appCategory;
    public ResourceLocator appIcon;
    public int certType;
    public int notLaunchableReason;

    public Application() {
        this.appID = -1;
        this.appName = "";
        this.appCategory = 0;
        this.appIcon = null;
        this.certType = -1;
        this.notLaunchableReason = 0;
    }

    public Application(int n, String string, int n2, ResourceLocator resourceLocator, int n3, int n4) {
        this.appID = n;
        this.appName = string;
        this.appCategory = n2;
        this.appIcon = resourceLocator;
        this.certType = n3;
        this.notLaunchableReason = n4;
    }

    public int getAppID() {
        return this.appID;
    }

    public String getAppName() {
        return this.appName;
    }

    public int getAppCategory() {
        return this.appCategory;
    }

    public ResourceLocator getAppIcon() {
        return this.appIcon;
    }

    public int getCertType() {
        return this.certType;
    }

    public int getNotLaunchableReason() {
        return this.notLaunchableReason;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(1350);
        stringBuffer.append("Application");
        stringBuffer.append('(');
        stringBuffer.append("appID");
        stringBuffer.append('=');
        stringBuffer.append(this.appID);
        stringBuffer.append(',');
        stringBuffer.append("appName");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.appName);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("appCategory");
        stringBuffer.append('=');
        stringBuffer.append(this.appCategory);
        stringBuffer.append(',');
        stringBuffer.append("appIcon");
        stringBuffer.append('=');
        stringBuffer.append(this.appIcon);
        stringBuffer.append(',');
        stringBuffer.append("certType");
        stringBuffer.append('=');
        stringBuffer.append(this.certType);
        stringBuffer.append(',');
        stringBuffer.append("notLaunchableReason");
        stringBuffer.append('=');
        stringBuffer.append(this.notLaunchableReason);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

