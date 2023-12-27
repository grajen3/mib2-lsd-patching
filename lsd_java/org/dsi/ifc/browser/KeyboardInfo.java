/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.browser;

public class KeyboardInfo {
    public int type;
    public String title;
    public String initialText;
    public boolean sensitive;

    public KeyboardInfo() {
        this.type = 0;
        this.title = "";
        this.initialText = "";
        this.sensitive = false;
    }

    public KeyboardInfo(int n, String string, String string2, boolean bl) {
        this.type = n;
        this.title = string;
        this.initialText = string2;
        this.sensitive = bl;
    }

    public int getType() {
        return this.type;
    }

    public String getTitle() {
        return this.title;
    }

    public String getInitialText() {
        return this.initialText;
    }

    public boolean isSensitive() {
        return this.sensitive;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(250);
        stringBuffer.append("KeyboardInfo");
        stringBuffer.append('(');
        stringBuffer.append("type");
        stringBuffer.append('=');
        stringBuffer.append(this.type);
        stringBuffer.append(',');
        stringBuffer.append("title");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.title);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("initialText");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.initialText);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("sensitive");
        stringBuffer.append('=');
        stringBuffer.append(this.sensitive);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

