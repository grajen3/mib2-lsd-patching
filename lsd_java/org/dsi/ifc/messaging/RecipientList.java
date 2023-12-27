/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.messaging;

public class RecipientList {
    public String[] to;
    public String[] cc;
    public String[] bcc;

    public RecipientList() {
    }

    public RecipientList(String[] stringArray, String[] stringArray2, String[] stringArray3) {
        this.to = stringArray;
        this.cc = stringArray2;
        this.bcc = stringArray3;
    }

    public String[] getTo() {
        return this.to;
    }

    public String[] getCc() {
        return this.cc;
    }

    public String[] getBcc() {
        return this.bcc;
    }

    public String toString() {
        int n;
        int n2;
        int n3;
        StringBuffer stringBuffer = new StringBuffer(150);
        stringBuffer.append("RecipientList");
        stringBuffer.append('(');
        stringBuffer.append("to");
        stringBuffer.append('[');
        if (this.to != null) {
            stringBuffer.append(this.to.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.to != null) {
            n3 = this.to.length;
            n2 = n3 - 1;
            for (n = 0; n < n3; ++n) {
                stringBuffer.append('\"');
                stringBuffer.append(this.to[n]);
                stringBuffer.append('\"');
                if (n >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.to);
        }
        stringBuffer.append('}');
        stringBuffer.append(',');
        stringBuffer.append("cc");
        stringBuffer.append('[');
        if (this.cc != null) {
            stringBuffer.append(this.cc.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.cc != null) {
            n3 = this.cc.length;
            n2 = n3 - 1;
            for (n = 0; n < n3; ++n) {
                stringBuffer.append('\"');
                stringBuffer.append(this.cc[n]);
                stringBuffer.append('\"');
                if (n >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.cc);
        }
        stringBuffer.append('}');
        stringBuffer.append(',');
        stringBuffer.append("bcc");
        stringBuffer.append('[');
        if (this.bcc != null) {
            stringBuffer.append(this.bcc.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.bcc != null) {
            n3 = this.bcc.length;
            n2 = n3 - 1;
            for (n = 0; n < n3; ++n) {
                stringBuffer.append('\"');
                stringBuffer.append(this.bcc[n]);
                stringBuffer.append('\"');
                if (n >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.bcc);
        }
        stringBuffer.append('}');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

