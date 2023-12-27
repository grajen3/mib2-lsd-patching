/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.messaging;

public class Template {
    public int id;
    public String body;
    public boolean readOnly;

    public Template() {
        this.id = -1;
        this.body = "";
        this.readOnly = false;
    }

    public Template(int n, String string, boolean bl) {
        this.id = n;
        this.body = string;
        this.readOnly = bl;
    }

    public int getId() {
        return this.id;
    }

    public String getBody() {
        return this.body;
    }

    public boolean isReadOnly() {
        return this.readOnly;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(150);
        stringBuffer.append("Template");
        stringBuffer.append('(');
        stringBuffer.append("id");
        stringBuffer.append('=');
        stringBuffer.append(this.id);
        stringBuffer.append(',');
        stringBuffer.append("body");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.body);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("readOnly");
        stringBuffer.append('=');
        stringBuffer.append(this.readOnly);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

