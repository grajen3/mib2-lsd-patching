/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.speechrec;

import org.dsi.ifc.speechrec.NBestSlot;

public class NBestListEntry {
    public int grammarId;
    public String recognizedString;
    public String recognizedTag;
    public int confidence;
    public int commandHierarchie;
    public int grammarType;
    public int graphemicGroupIndex;
    public NBestSlot[] slots;

    public NBestListEntry() {
        this.grammarId = -1;
        this.recognizedString = "";
        this.recognizedTag = "";
        this.confidence = 0;
        this.commandHierarchie = 0;
        this.grammarType = 0;
        this.graphemicGroupIndex = -1;
        this.slots = null;
    }

    public NBestListEntry(int n, String string, String string2, int n2, int n3, int n4, int n5, NBestSlot[] nBestSlotArray) {
        this.grammarId = n;
        this.recognizedString = string;
        this.recognizedTag = string2;
        this.confidence = n2;
        this.commandHierarchie = n3;
        this.grammarType = n4;
        this.graphemicGroupIndex = n5;
        this.slots = nBestSlotArray;
    }

    public int getGrammarId() {
        return this.grammarId;
    }

    public String getRecognizedString() {
        return this.recognizedString;
    }

    public String getRecognizedTag() {
        return this.recognizedTag;
    }

    public int getConfidence() {
        return this.confidence;
    }

    public int getCommandHierarchie() {
        return this.commandHierarchie;
    }

    public int getGrammarType() {
        return this.grammarType;
    }

    public int getGraphemicGroupIndex() {
        return this.graphemicGroupIndex;
    }

    public NBestSlot[] getSlots() {
        return this.slots;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(550);
        stringBuffer.append("NBestListEntry");
        stringBuffer.append('(');
        stringBuffer.append("grammarId");
        stringBuffer.append('=');
        stringBuffer.append(this.grammarId);
        stringBuffer.append(',');
        stringBuffer.append("recognizedString");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.recognizedString);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("recognizedTag");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.recognizedTag);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("confidence");
        stringBuffer.append('=');
        stringBuffer.append(this.confidence);
        stringBuffer.append(',');
        stringBuffer.append("commandHierarchie");
        stringBuffer.append('=');
        stringBuffer.append(this.commandHierarchie);
        stringBuffer.append(',');
        stringBuffer.append("grammarType");
        stringBuffer.append('=');
        stringBuffer.append(this.grammarType);
        stringBuffer.append(',');
        stringBuffer.append("graphemicGroupIndex");
        stringBuffer.append('=');
        stringBuffer.append(this.graphemicGroupIndex);
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

