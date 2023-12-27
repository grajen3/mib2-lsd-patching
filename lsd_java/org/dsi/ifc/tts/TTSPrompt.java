/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.tts;

import org.dsi.ifc.tts.DynamicTTSPromptPart;

public class TTSPrompt {
    public int promptType;
    public String[] promptPartTexts;
    public int[] promptPartIds;
    public DynamicTTSPromptPart[] dynamicParts;

    public TTSPrompt() {
        this.promptType = 0;
        this.promptPartTexts = null;
        this.promptPartIds = null;
        this.dynamicParts = null;
    }

    public TTSPrompt(int n, String[] stringArray, int[] nArray, DynamicTTSPromptPart[] dynamicTTSPromptPartArray) {
        this.promptType = n;
        this.promptPartTexts = stringArray;
        this.promptPartIds = nArray;
        this.dynamicParts = dynamicTTSPromptPartArray;
    }

    public int getPromptType() {
        return this.promptType;
    }

    public String[] getPromptPartTexts() {
        return this.promptPartTexts;
    }

    public int[] getPromptPartIds() {
        return this.promptPartIds;
    }

    public DynamicTTSPromptPart[] getDynamicParts() {
        return this.dynamicParts;
    }

    public String toString() {
        int n;
        int n2;
        int n3;
        StringBuffer stringBuffer = new StringBuffer(250);
        stringBuffer.append("TTSPrompt");
        stringBuffer.append('(');
        stringBuffer.append("promptType");
        stringBuffer.append('=');
        stringBuffer.append(this.promptType);
        stringBuffer.append(',');
        stringBuffer.append("promptPartTexts");
        stringBuffer.append('[');
        if (this.promptPartTexts != null) {
            stringBuffer.append(this.promptPartTexts.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.promptPartTexts != null) {
            n3 = this.promptPartTexts.length;
            n2 = n3 - 1;
            for (n = 0; n < n3; ++n) {
                stringBuffer.append('\"');
                stringBuffer.append(this.promptPartTexts[n]);
                stringBuffer.append('\"');
                if (n >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.promptPartTexts);
        }
        stringBuffer.append('}');
        stringBuffer.append(',');
        stringBuffer.append("promptPartIds");
        stringBuffer.append('[');
        if (this.promptPartIds != null) {
            stringBuffer.append(this.promptPartIds.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.promptPartIds != null) {
            n3 = this.promptPartIds.length;
            n2 = n3 - 1;
            for (n = 0; n < n3; ++n) {
                stringBuffer.append(this.promptPartIds[n]);
                if (n >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.promptPartIds);
        }
        stringBuffer.append('}');
        stringBuffer.append(',');
        stringBuffer.append("dynamicParts");
        stringBuffer.append('[');
        if (this.dynamicParts != null) {
            stringBuffer.append(this.dynamicParts.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.dynamicParts != null) {
            n3 = this.dynamicParts.length;
            n2 = n3 - 1;
            for (n = 0; n < n3; ++n) {
                stringBuffer.append(this.dynamicParts[n]);
                if (n >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.dynamicParts);
        }
        stringBuffer.append('}');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

