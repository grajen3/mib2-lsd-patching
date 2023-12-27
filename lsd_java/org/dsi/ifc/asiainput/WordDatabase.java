/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.asiainput;

public class WordDatabase {
    public String name;
    public int priority;

    public WordDatabase() {
        this.name = null;
        this.priority = 0;
    }

    public WordDatabase(String string, int n) {
        this.name = string;
        this.priority = n;
    }

    public String getName() {
        return this.name;
    }

    public int getPriority() {
        return this.priority;
    }

    public void setName(String string) {
        this.name = string;
    }

    public void setPriority(int n) {
        this.priority = n;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(150);
        stringBuffer.append("WordDatabase");
        stringBuffer.append('(');
        stringBuffer.append("name");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.name);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("priority");
        stringBuffer.append('=');
        stringBuffer.append(this.priority);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

