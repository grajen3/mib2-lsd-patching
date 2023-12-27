/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.speechrec;

import org.dsi.ifc.speechrec.NBestSlot;

public class GraphemicGroup {
    public String groupText;
    public int graphemicGroupSize;
    public NBestSlot[] slots;

    public GraphemicGroup() {
        this.groupText = "";
        this.graphemicGroupSize = 0;
        this.slots = null;
    }

    public GraphemicGroup(String string, int n, NBestSlot[] nBestSlotArray) {
        this.groupText = string;
        this.graphemicGroupSize = n;
        this.slots = nBestSlotArray;
    }

    public String getGroupText() {
        return this.groupText;
    }

    public int getGraphemicGroupSize() {
        return this.graphemicGroupSize;
    }

    public NBestSlot[] getSlots() {
        return this.slots;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(200);
        stringBuffer.append("GraphemicGroup");
        stringBuffer.append('(');
        stringBuffer.append("groupText");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.groupText);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("graphemicGroupSize");
        stringBuffer.append('=');
        stringBuffer.append(this.graphemicGroupSize);
        stringBuffer.append(',');
        stringBuffer.append("slots");
        stringBuffer.append('[');
        if (this.slots != null) {
            stringBuffer.append(this.slots.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.slots != null) {
            int n = this.slots.length;
            int n2 = n - 1;
            for (int i2 = 0; i2 < n; ++i2) {
                stringBuffer.append(this.slots[i2]);
                if (i2 >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.slots);
        }
        stringBuffer.append('}');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

