/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.radio;

public class UnifiedRadioTextPlus {
    public int piSId;
    public int ensId;
    public int ecc;
    public int sCIDI;
    public int[] tags;
    public String[] content;
    public int source;

    public UnifiedRadioTextPlus() {
        this.ensId = 0;
        this.ecc = 0;
        this.piSId = 0;
        this.sCIDI = 0;
        this.tags = null;
        this.content = null;
        this.source = 0;
    }

    public UnifiedRadioTextPlus(int n, int n2, int n3, int n4, int[] nArray, String[] stringArray, int n5) {
        this.ensId = n2;
        this.ecc = n3;
        this.piSId = n;
        this.sCIDI = n4;
        this.tags = nArray;
        this.content = stringArray;
        this.source = n5;
    }

    public int getEnsId() {
        return this.ensId;
    }

    public int getEcc() {
        return this.ecc;
    }

    public int getPiSId() {
        return this.piSId;
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

    public int getSource() {
        return this.source;
    }

    public String toString() {
        int n;
        int n2;
        int n3;
        StringBuffer stringBuffer = new StringBuffer(300);
        stringBuffer.append("UnifiedRadioTextPlus");
        stringBuffer.append('(');
        stringBuffer.append("piSId");
        stringBuffer.append('=');
        stringBuffer.append(this.piSId);
        stringBuffer.append(',');
        stringBuffer.append("ensId");
        stringBuffer.append('=');
        stringBuffer.append(this.ensId);
        stringBuffer.append(',');
        stringBuffer.append("ecc");
        stringBuffer.append('=');
        stringBuffer.append(this.ecc);
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
        stringBuffer.append(',');
        stringBuffer.append("source");
        stringBuffer.append('=');
        stringBuffer.append(this.source);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

