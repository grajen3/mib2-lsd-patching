/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.tvtuner;

import org.dsi.ifc.tvtuner.AudioChannel;
import org.dsi.ifc.tvtuner.ServiceInfo;
import org.dsi.ifc.tvtuner.Time;

public class ProgramInfo {
    public ServiceInfo serviceInfo;
    public String channelName;
    public int normArea;
    public int videoFormat;
    public AudioChannel[] availableAudioChannels;
    public int selectedAudioChannel;
    public int epgFlag;
    public int teletextFlag;
    public int variantDatabroadcastFlag;
    public int databroadcastFlag1;
    public int databroadcastFlag2;
    public int bwsFlag;
    public int slsFlag;
    public int txtFlag;
    public int casFlag;
    public int visAudioFlag;
    public int announcement;
    public int caDescriptor;
    public int casStatus;
    public short parentalRating;
    public Time nowStartTime;
    public Time nowEndTime;
    public String nowProgramInfo;
    public Time nextStartTime;
    public Time nextEndTime;
    public String nextProgramInfo;
    public int subtitleFlag;

    public ProgramInfo() {
        this.serviceInfo = null;
        this.channelName = null;
        this.normArea = 0;
        this.videoFormat = 0;
        this.availableAudioChannels = null;
        this.selectedAudioChannel = 0;
        this.epgFlag = 0;
        this.teletextFlag = 0;
        this.variantDatabroadcastFlag = 0;
        this.databroadcastFlag1 = 0;
        this.databroadcastFlag2 = 0;
        this.bwsFlag = 0;
        this.slsFlag = 0;
        this.txtFlag = 0;
        this.casFlag = 0;
        this.visAudioFlag = 0;
        this.announcement = 0;
        this.caDescriptor = 0;
        this.casStatus = 0;
        this.parentalRating = 0;
        this.nowStartTime = null;
        this.nowEndTime = null;
        this.nowProgramInfo = null;
        this.nextStartTime = null;
        this.nextEndTime = null;
        this.nextProgramInfo = null;
        this.subtitleFlag = 0;
    }

    public ProgramInfo(ServiceInfo serviceInfo, String string, int n, int n2, AudioChannel[] audioChannelArray, int n3, int n4, int n5, int n6, int n7, int n8, int n9, int n10, int n11, int n12, int n13, int n14, int n15, int n16, short s, Time time, Time time2, String string2, Time time3, Time time4, String string3, int n17) {
        this.serviceInfo = serviceInfo;
        this.channelName = string;
        this.normArea = n;
        this.videoFormat = n2;
        this.availableAudioChannels = audioChannelArray;
        this.selectedAudioChannel = n3;
        this.epgFlag = n4;
        this.teletextFlag = n5;
        this.variantDatabroadcastFlag = n6;
        this.databroadcastFlag1 = n7;
        this.databroadcastFlag2 = n8;
        this.bwsFlag = n9;
        this.slsFlag = n10;
        this.txtFlag = n11;
        this.casFlag = n12;
        this.visAudioFlag = n13;
        this.announcement = n14;
        this.caDescriptor = n15;
        this.casStatus = n16;
        this.parentalRating = s;
        this.nowStartTime = time;
        this.nowEndTime = time2;
        this.nowProgramInfo = string2;
        this.nextStartTime = time3;
        this.nextEndTime = time4;
        this.nextProgramInfo = string3;
        this.subtitleFlag = n17;
    }

    public ServiceInfo getServiceInfo() {
        return this.serviceInfo;
    }

    public String getChannelName() {
        return this.channelName;
    }

    public int getNormArea() {
        return this.normArea;
    }

    public int getVideoFormat() {
        return this.videoFormat;
    }

    public AudioChannel[] getAvailableAudioChannels() {
        return this.availableAudioChannels;
    }

    public int getSelectedAudioChannel() {
        return this.selectedAudioChannel;
    }

    public int getEpgFlag() {
        return this.epgFlag;
    }

    public int getTeletextFlag() {
        return this.teletextFlag;
    }

    public int getVariantDatabroadcastFlag() {
        return this.variantDatabroadcastFlag;
    }

    public int getDatabroadcastFlag1() {
        return this.databroadcastFlag1;
    }

    public int getDatabroadcastFlag2() {
        return this.databroadcastFlag2;
    }

    public int getBwsFlag() {
        return this.bwsFlag;
    }

    public int getSlsFlag() {
        return this.slsFlag;
    }

    public int getTxtFlag() {
        return this.txtFlag;
    }

    public int getCasFlag() {
        return this.casFlag;
    }

    public int getVisAudioFlag() {
        return this.visAudioFlag;
    }

    public int getAnnouncement() {
        return this.announcement;
    }

    public int getCaDescriptor() {
        return this.caDescriptor;
    }

    public int getCasStatus() {
        return this.casStatus;
    }

    public short getParentalRating() {
        return this.parentalRating;
    }

    public Time getNowStartTime() {
        return this.nowStartTime;
    }

    public Time getNowEndTime() {
        return this.nowEndTime;
    }

    public String getNowProgramInfo() {
        return this.nowProgramInfo;
    }

    public Time getNextStartTime() {
        return this.nextStartTime;
    }

    public Time getNextEndTime() {
        return this.nextEndTime;
    }

    public String getNextProgramInfo() {
        return this.nextProgramInfo;
    }

    public int getSubtitleFlag() {
        return this.subtitleFlag;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(6500);
        stringBuffer.append("ProgramInfo");
        stringBuffer.append('(');
        stringBuffer.append("serviceInfo");
        stringBuffer.append('=');
        stringBuffer.append(this.serviceInfo);
        stringBuffer.append(',');
        stringBuffer.append("channelName");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.channelName);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("normArea");
        stringBuffer.append('=');
        stringBuffer.append(this.normArea);
        stringBuffer.append(',');
        stringBuffer.append("videoFormat");
        stringBuffer.append('=');
        stringBuffer.append(this.videoFormat);
        stringBuffer.append(',');
        stringBuffer.append("availableAudioChannels");
        stringBuffer.append('[');
        if (this.availableAudioChannels != null) {
            stringBuffer.append(this.availableAudioChannels.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.availableAudioChannels != null) {
            int n = this.availableAudioChannels.length;
            int n2 = n - 1;
            for (int i2 = 0; i2 < n; ++i2) {
                stringBuffer.append(this.availableAudioChannels[i2]);
                if (i2 >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.availableAudioChannels);
        }
        stringBuffer.append('}');
        stringBuffer.append(',');
        stringBuffer.append("selectedAudioChannel");
        stringBuffer.append('=');
        stringBuffer.append(this.selectedAudioChannel);
        stringBuffer.append(',');
        stringBuffer.append("epgFlag");
        stringBuffer.append('=');
        stringBuffer.append(this.epgFlag);
        stringBuffer.append(',');
        stringBuffer.append("teletextFlag");
        stringBuffer.append('=');
        stringBuffer.append(this.teletextFlag);
        stringBuffer.append(',');
        stringBuffer.append("variantDatabroadcastFlag");
        stringBuffer.append('=');
        stringBuffer.append(this.variantDatabroadcastFlag);
        stringBuffer.append(',');
        stringBuffer.append("databroadcastFlag1");
        stringBuffer.append('=');
        stringBuffer.append(this.databroadcastFlag1);
        stringBuffer.append(',');
        stringBuffer.append("databroadcastFlag2");
        stringBuffer.append('=');
        stringBuffer.append(this.databroadcastFlag2);
        stringBuffer.append(',');
        stringBuffer.append("bwsFlag");
        stringBuffer.append('=');
        stringBuffer.append(this.bwsFlag);
        stringBuffer.append(',');
        stringBuffer.append("slsFlag");
        stringBuffer.append('=');
        stringBuffer.append(this.slsFlag);
        stringBuffer.append(',');
        stringBuffer.append("txtFlag");
        stringBuffer.append('=');
        stringBuffer.append(this.txtFlag);
        stringBuffer.append(',');
        stringBuffer.append("casFlag");
        stringBuffer.append('=');
        stringBuffer.append(this.casFlag);
        stringBuffer.append(',');
        stringBuffer.append("visAudioFlag");
        stringBuffer.append('=');
        stringBuffer.append(this.visAudioFlag);
        stringBuffer.append(',');
        stringBuffer.append("announcement");
        stringBuffer.append('=');
        stringBuffer.append(this.announcement);
        stringBuffer.append(',');
        stringBuffer.append("caDescriptor");
        stringBuffer.append('=');
        stringBuffer.append(this.caDescriptor);
        stringBuffer.append(',');
        stringBuffer.append("casStatus");
        stringBuffer.append('=');
        stringBuffer.append(this.casStatus);
        stringBuffer.append(',');
        stringBuffer.append("parentalRating");
        stringBuffer.append('=');
        stringBuffer.append(this.parentalRating);
        stringBuffer.append(',');
        stringBuffer.append("nowStartTime");
        stringBuffer.append('=');
        stringBuffer.append(this.nowStartTime);
        stringBuffer.append(',');
        stringBuffer.append("nowEndTime");
        stringBuffer.append('=');
        stringBuffer.append(this.nowEndTime);
        stringBuffer.append(',');
        stringBuffer.append("nowProgramInfo");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.nowProgramInfo);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("nextStartTime");
        stringBuffer.append('=');
        stringBuffer.append(this.nextStartTime);
        stringBuffer.append(',');
        stringBuffer.append("nextEndTime");
        stringBuffer.append('=');
        stringBuffer.append(this.nextEndTime);
        stringBuffer.append(',');
        stringBuffer.append("nextProgramInfo");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.nextProgramInfo);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("subtitleFlag");
        stringBuffer.append('=');
        stringBuffer.append(this.subtitleFlag);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

