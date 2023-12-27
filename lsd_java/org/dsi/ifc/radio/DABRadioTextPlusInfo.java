/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.radio;

public class DABRadioTextPlusInfo {
    public int ensID;
    public int ensECC;
    public int sID;
    public int sCIDI;
    public int[] tags;
    public String[] content;

    public DABRadioTextPlusInfo() {
        this.ensID = 0;
        this.ensECC = 0;
        this.sID = 0;
        this.sCIDI = 0;
        this.tags = new int[0];
        this.content = new String[0];
    }

    public DABRadioTextPlusInfo(int n, int n2, int n3, int n4, int[] nArray, String[] stringArray) {
        this.ensID = n;
        this.ensECC = n2;
        this.sID = n3;
        this.sCIDI = n4;
        this.tags = nArray;
        this.content = stringArray;
    }

    public int getEnsID() {
        return this.ensID;
    }

    public int getEnsECC() {
        return this.ensECC;
    }

    public int getSID() {
        return this.sID;
    }

    public int getSCIDI() {
        return this.sCIDI;
    }

    public int[] getTags() {
        return this.tags;
    }

    public String[] getContent() {
        return this.content;
    }

    public String toString() {
        int n;
        int n2;
        int n3;
        StringBuffer stringBuffer = new StringBuffer(250);
        stringBuffer.append("DABRadioTextPlusInfo");
        stringBuffer.append('(');
        stringBuffer.append("ensID");
        stringBuffer.append('=');
        stringBuffer.append(this.ensID);
        stringBuffer.append(',');
        stringBuffer.append("ensECC");
        stringBuffer.append('=');
        stringBuffer.append(this.ensECC);
        stringBuffer.append(',');
        stringBuffer.append("sID");
        stringBuffer.append('=');
        stringBuffer.append(this.sID);
        stringBuffer.append(',');
        stringBuffer.append("sCIDI");
        stringBuffer.append('=');
        stringBuffer.append(this.sCIDI);
        stringBuffer.append(',');
        stringBuffer.append("tags");
        stringBuffer.append('[');
        if (this.tags != null) {
            stringBuffer.append(this.tags.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.tags != null) {
            n3 = this.tags.length;
            n2 = n3 - 1;
            for (n = 0; n < n3; ++n) {
                stringBuffer.append(this.tags[n]);
                if (n >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.tags);
        }
        stringBuffer.append('}');
        stringBuffer.append(',');
        stringBuffer.append("content");
        stringBuffer.append('[');
        if (this.content != null) {
            stringBuffer.append(this.content.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.content != null) {
            n3 = this.content.length;
            n2 = n3 - 1;
            for (n = 0; n < n3; ++n) {
                stringBuffer.append('\"');
                stringBuffer.append(this.content[n]);
                stringBuffer.append('\"');
                if (n >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.content);
        }
        stringBuffer.append('}');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

