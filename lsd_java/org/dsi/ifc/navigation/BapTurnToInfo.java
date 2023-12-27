/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.navigation;

public class BapTurnToInfo {
    public String turnToInfo;
    public String signPost;

    public BapTurnToInfo(String string, String string2) {
        this.turnToInfo = string;
        this.signPost = string2;
    }

    public BapTurnToInfo() {
        this.turnToInfo = null;
        this.signPost = null;
    }

    public String getTurnToInfo() {
        return this.turnToInfo;
    }

    public String getSignPost() {
        return this.signPost;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(200);
        stringBuffer.append("BapTurnToInfo");
        stringBuffer.append('(');
        stringBuffer.append("turnToInfo");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.turnToInfo);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("signPost");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.signPost);
        stringBuffer.append('\"');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

