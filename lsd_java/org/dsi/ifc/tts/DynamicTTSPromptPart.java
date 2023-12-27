/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.tts;

public class DynamicTTSPromptPart {
    public String key;
    public String value;
    public String alternativeText;

    public DynamicTTSPromptPart() {
        this.key = null;
        this.value = null;
        this.alternativeText = null;
    }

    public DynamicTTSPromptPart(String string, String string2, String string3) {
        this.key = string;
        this.value = string2;
        this.alternativeText = string3;
    }

    public String getKey() {
        return this.key;
    }

    public String getValue() {
        return this.value;
    }

    public String getAlternativeText() {
        return this.alternativeText;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(250);
        stringBuffer.append("DynamicTTSPromptPart");
        stringBuffer.append('(');
        stringBuffer.append("key");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.key);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("value");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.value);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("alternativeText");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.alternativeText);
        stringBuffer.append('\"');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

