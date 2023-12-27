/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.tts;

public class LanguageVoiceInfo {
    public String language;
    public int[] voiceIDs;
    public String[] voiceNames;

    public LanguageVoiceInfo() {
        this.language = null;
        this.voiceIDs = null;
        this.voiceNames = null;
    }

    public LanguageVoiceInfo(String string, int[] nArray, String[] stringArray) {
        this.language = string;
        this.voiceIDs = nArray;
        this.voiceNames = stringArray;
    }

    public String getLanguage() {
        return this.language;
    }

    public int[] getVoiceIDs() {
        return this.voiceIDs;
    }

    public String[] getVoiceNames() {
        return this.voiceNames;
    }

    public String toString() {
        int n;
        int n2;
        int n3;
        StringBuffer stringBuffer = new StringBuffer(200);
        stringBuffer.append("LanguageVoiceInfo");
        stringBuffer.append('(');
        stringBuffer.append("language");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.language);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("voiceIDs");
        stringBuffer.append('[');
        if (this.voiceIDs != null) {
            stringBuffer.append(this.voiceIDs.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.voiceIDs != null) {
            n3 = this.voiceIDs.length;
            n2 = n3 - 1;
            for (n = 0; n < n3; ++n) {
                stringBuffer.append(this.voiceIDs[n]);
                if (n >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.voiceIDs);
        }
        stringBuffer.append('}');
        stringBuffer.append(',');
        stringBuffer.append("voiceNames");
        stringBuffer.append('[');
        if (this.voiceNames != null) {
            stringBuffer.append(this.voiceNames.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.voiceNames != null) {
            n3 = this.voiceNames.length;
            n2 = n3 - 1;
            for (n = 0; n < n3; ++n) {
                stringBuffer.append('\"');
                stringBuffer.append(this.voiceNames[n]);
                stringBuffer.append('\"');
                if (n >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.voiceNames);
        }
        stringBuffer.append('}');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

