/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.speechrec;

public class GrammarStateInfo {
    public int grammarStatus;
    public int[] slotIds;

    public GrammarStateInfo() {
        this.grammarStatus = -1;
        this.slotIds = new int[0];
    }

    public GrammarStateInfo(int n, int[] nArray) {
        this.grammarStatus = n;
        this.slotIds = nArray;
    }

    public int getGrammarStatus() {
        return this.grammarStatus;
    }

    public int[] getSlotIds() {
        return this.slotIds;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(150);
        stringBuffer.append("GrammarStateInfo");
        stringBuffer.append('(');
        stringBuffer.append("grammarStatus");
        stringBuffer.append('=');
        stringBuffer.append(this.grammarStatus);
        stringBuffer.append(',');
        stringBuffer.append("slotIds");
        stringBuffer.append('[');
        if (this.slotIds != null) {
            stringBuffer.append(this.slotIds.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.slotIds != null) {
            int n = this.slotIds.length;
            int n2 = n - 1;
            for (int i2 = 0; i2 < n; ++i2) {
                stringBuffer.append(this.slotIds[i2]);
                if (i2 >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.slotIds);
        }
        stringBuffer.append('}');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

