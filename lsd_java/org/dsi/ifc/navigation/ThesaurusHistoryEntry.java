/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.navigation;

public class ThesaurusHistoryEntry {
    public int uid;
    public String expression;

    public ThesaurusHistoryEntry() {
        this.uid = 0;
        this.expression = "";
    }

    public ThesaurusHistoryEntry(int n, String string) {
        this.uid = n;
        this.expression = string;
    }

    public int getUid() {
        return this.uid;
    }

    public String getExpression() {
        return this.expression;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(150);
        stringBuffer.append("ThesaurusHistoryEntry");
        stringBuffer.append('(');
        stringBuffer.append("uid");
        stringBuffer.append('=');
        stringBuffer.append(this.uid);
        stringBuffer.append(',');
        stringBuffer.append("expression");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.expression);
        stringBuffer.append('\"');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

