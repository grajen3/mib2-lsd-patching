/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.online;

import org.dsi.ifc.online.PoiOnlineRecognitionListElement;
import org.dsi.ifc.online.PoiOnlineSearchValuelistElement;

public class PoiOnlineSearchValuelist {
    public int sourceID;
    public String sourceName;
    public int voiceRecognizerSourceID;
    public String voiceRecognizerSourceName;
    public int voiceRecognizerAudioFormat;
    public PoiOnlineRecognitionListElement[] recognitionList;
    public String imageUrl;
    public String imageCheckSum;
    public String imageVoiceUrl;
    public String imageVoiceCheckSum;
    public String imageMapUrl;
    public String imageMapCheckSum;
    public int sortKey;
    public PoiOnlineSearchValuelistElement[] list;

    public PoiOnlineSearchValuelist() {
        this.voiceRecognizerSourceID = 0;
        this.voiceRecognizerSourceName = "";
        this.voiceRecognizerAudioFormat = 0;
        this.recognitionList = null;
        this.sourceID = -1;
        this.sourceName = "";
        this.imageUrl = "";
        this.imageCheckSum = "";
        this.imageMapUrl = "";
        this.imageMapCheckSum = "";
        this.sortKey = -1;
        this.list = null;
    }

    public PoiOnlineSearchValuelist(int n, String string, int n2, String string2, int n3, PoiOnlineRecognitionListElement[] poiOnlineRecognitionListElementArray, String string3, String string4, String string5, String string6, String string7, String string8, int n4, PoiOnlineSearchValuelistElement[] poiOnlineSearchValuelistElementArray) {
        this.list = poiOnlineSearchValuelistElementArray;
        this.sourceID = n;
        this.sourceName = string;
        this.voiceRecognizerSourceID = n2;
        this.voiceRecognizerSourceName = string2;
        this.voiceRecognizerAudioFormat = n3;
        this.recognitionList = poiOnlineRecognitionListElementArray;
        this.imageUrl = string3;
        this.imageCheckSum = string4;
        this.imageVoiceUrl = string5;
        this.imageVoiceCheckSum = string6;
        this.imageMapUrl = string7;
        this.imageMapCheckSum = string8;
        this.sortKey = n4;
    }

    public PoiOnlineSearchValuelistElement[] getList() {
        return this.list;
    }

    public int getSourceID() {
        return this.sourceID;
    }

    public String getSourceName() {
        return this.sourceName;
    }

    public int getVoiceRecognizerSourceID() {
        return this.voiceRecognizerSourceID;
    }

    public String getVoiceRecognizerSourceName() {
        return this.voiceRecognizerSourceName;
    }

    public int getVoiceRecognizerAudioFormat() {
        return this.voiceRecognizerAudioFormat;
    }

    public PoiOnlineRecognitionListElement[] getRecognitionList() {
        return this.recognitionList;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public String getImageCheckSum() {
        return this.imageCheckSum;
    }

    public String getImageMapUrl() {
        return this.imageMapUrl;
    }

    public String getImageVoiceUrl() {
        return this.imageVoiceUrl;
    }

    public String getImageVoiceCheckSum() {
        return this.imageVoiceCheckSum;
    }

    public String getImageMapCheckSum() {
        return this.imageMapCheckSum;
    }

    public int getSortKey() {
        return this.sortKey;
    }

    public String toString() {
        int n;
        int n2;
        int n3;
        StringBuffer stringBuffer = new StringBuffer(1100);
        stringBuffer.append("PoiOnlineSearchValuelist");
        stringBuffer.append('(');
        stringBuffer.append("sourceID");
        stringBuffer.append('=');
        stringBuffer.append(this.sourceID);
        stringBuffer.append(',');
        stringBuffer.append("sourceName");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.sourceName);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("voiceRecognizerSourceID");
        stringBuffer.append('=');
        stringBuffer.append(this.voiceRecognizerSourceID);
        stringBuffer.append(',');
        stringBuffer.append("voiceRecognizerSourceName");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.voiceRecognizerSourceName);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("voiceRecognizerAudioFormat");
        stringBuffer.append('=');
        stringBuffer.append(this.voiceRecognizerAudioFormat);
        stringBuffer.append(',');
        stringBuffer.append("recognitionList");
        stringBuffer.append('[');
        if (this.recognitionList != null) {
            stringBuffer.append(this.recognitionList.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.recognitionList != null) {
            n3 = this.recognitionList.length;
            n2 = n3 - 1;
            for (n = 0; n < n3; ++n) {
                stringBuffer.append(this.recognitionList[n]);
                if (n >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.recognitionList);
        }
        stringBuffer.append('}');
        stringBuffer.append(',');
        stringBuffer.append("imageUrl");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.imageUrl);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("imageCheckSum");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.imageCheckSum);
        stringBuffer.append('\"');
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
        stringBuffer.append("imageMapUrl");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.imageMapUrl);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("imageMapCheckSum");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.imageMapCheckSum);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("sortKey");
        stringBuffer.append('=');
        stringBuffer.append(this.sortKey);
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
            n3 = this.list.length;
            n2 = n3 - 1;
            for (n = 0; n < n3; ++n) {
                stringBuffer.append(this.list[n]);
                if (n >= n2) continue;
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

