/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.online;

import org.dsi.ifc.online.DictationValueSentenceElement;

public class DictationValueSentence {
    public int voiceSourceID;
    public String voiceSourceName;
    public int voiceRecognizerAudioFormat;
    public String imageVoiceUrl;
    public String imageVoiceCheckSum;
    public DictationValueSentenceElement[] list;

    public DictationValueSentence() {
        this.list = null;
    }

    public DictationValueSentence(int n, String string, int n2, String string2, String string3, DictationValueSentenceElement[] dictationValueSentenceElementArray) {
        this.list = dictationValueSentenceElementArray;
        this.voiceSourceID = n;
        this.voiceSourceName = string;
        this.voiceRecognizerAudioFormat = n2;
        this.imageVoiceUrl = string2;
        this.imageVoiceCheckSum = string3;
    }

    public DictationValueSentenceElement[] getList() {
        return this.list;
    }

    public int getVoiceSourceID() {
        return this.voiceSourceID;
    }

    public String getVoiceSourceName() {
        return this.voiceSourceName;
    }

    public int getVoiceRecognizerAudioFormat() {
        return this.voiceRecognizerAudioFormat;
    }

    public String getImageVoiceUrl() {
        return this.imageVoiceUrl;
    }

    public String getImageVoiceCheckSum() {
        return this.imageVoiceCheckSum;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(500);
        stringBuffer.append("DictationValueSentence");
        stringBuffer.append('(');
        stringBuffer.append("voiceSourceID");
        stringBuffer.append('=');
        stringBuffer.append(this.voiceSourceID);
        stringBuffer.append(',');
        stringBuffer.append("voiceSourceName");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.voiceSourceName);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("voiceRecognizerAudioFormat");
        stringBuffer.append('=');
        stringBuffer.append(this.voiceRecognizerAudioFormat);
        stringBuffer.append(',');
        stringBuffer.append("imageVoiceUrl");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.imageVoiceUrl);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("imageVoiceCheckSum");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.imageVoiceCheckSum);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("list");
        stringBuffer.append('[');
        if (this.list != null) {
            stringBuffer.append(this.list.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.list != null) {
            int n = this.list.length;
            int n2 = n - 1;
            for (int i2 = 0; i2 < n; ++i2) {
                stringBuffer.append(this.list[i2]);
                if (i2 >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.list);
        }
        stringBuffer.append('}');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

