/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.tvtuner;

public class StartUpConfig {
    public int systemID;
    public int oemCodingVar;
    public boolean linkingAvail;
    public boolean avSrcAvail;
    public boolean tvNormAvail;
    public boolean audioChannelAvail;
    public boolean videoFormatAvail;
    public boolean avNormAvail;
    public boolean avFormatAvail;
    public boolean subtitleAvail;
    public boolean ewsAvail;
    public boolean logoListAvail;
    public boolean tpegAvail;
    public boolean casAvail;
    public boolean skipBehaviourAvail;
    public boolean visualAudioAvail;
    public boolean tmTeletextAvail;
    public boolean tmDatabroadDVBAvail;
    public boolean tmDatabroadISDBAvail;
    public boolean tmDatabroadDTMBAvail;
    public boolean tmDatabroadDMBAvail;
    public boolean tmDatabroadATSCAvail;
    public boolean tmDatabroad1Avail;
    public boolean tmDatabroad2Avail;
    public boolean tmBWSAvail;
    public boolean tmSLSDLSAvail;
    public boolean tmTXTAvail;
    public boolean tmCASAvail;
    public boolean tmEPGAvail;
    public boolean tmVisualAudioAvail;
    public short[] requiredKeypanelList;
    public boolean browserListSortAvail;
    public boolean parentalControlReq;

    public StartUpConfig() {
        this.systemID = 0;
        this.oemCodingVar = 0;
        this.linkingAvail = false;
        this.avSrcAvail = false;
        this.tvNormAvail = false;
        this.audioChannelAvail = false;
        this.videoFormatAvail = false;
        this.avNormAvail = false;
        this.avFormatAvail = false;
        this.subtitleAvail = false;
        this.ewsAvail = false;
        this.logoListAvail = false;
        this.tpegAvail = false;
        this.casAvail = false;
        this.skipBehaviourAvail = false;
        this.visualAudioAvail = false;
        this.browserListSortAvail = false;
        this.parentalControlReq = false;
        this.tmTeletextAvail = false;
        this.tmDatabroadDVBAvail = false;
        this.tmDatabroadISDBAvail = false;
        this.tmDatabroadDTMBAvail = false;
        this.tmDatabroadDMBAvail = false;
        this.tmDatabroadATSCAvail = false;
        this.tmDatabroad1Avail = false;
        this.tmDatabroad2Avail = false;
        this.tmBWSAvail = false;
        this.tmSLSDLSAvail = false;
        this.tmTXTAvail = false;
        this.tmCASAvail = false;
        this.tmEPGAvail = false;
        this.tmVisualAudioAvail = false;
        this.requiredKeypanelList = null;
    }

    public StartUpConfig(int n, int n2, boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, boolean bl7, boolean bl8, boolean bl9, boolean bl10, boolean bl11, boolean bl12, boolean bl13, boolean bl14, boolean bl15, boolean bl16, boolean bl17, boolean bl18, boolean bl19, boolean bl20, boolean bl21, boolean bl22, boolean bl23, boolean bl24, boolean bl25, boolean bl26, boolean bl27, boolean bl28, short[] sArray, boolean bl29, boolean bl30) {
        this.systemID = n;
        this.oemCodingVar = n2;
        this.linkingAvail = bl;
        this.avSrcAvail = bl2;
        this.tvNormAvail = bl3;
        this.audioChannelAvail = bl4;
        this.videoFormatAvail = bl5;
        this.avNormAvail = bl6;
        this.avFormatAvail = bl7;
        this.subtitleAvail = bl8;
        this.ewsAvail = bl9;
        this.logoListAvail = bl10;
        this.tpegAvail = bl11;
        this.casAvail = bl12;
        this.skipBehaviourAvail = bl13;
        this.visualAudioAvail = bl14;
        this.browserListSortAvail = bl29;
        this.parentalControlReq = bl30;
        this.tmTeletextAvail = bl15;
        this.tmDatabroadDVBAvail = bl16;
        this.tmDatabroadISDBAvail = bl17;
        this.tmDatabroadDTMBAvail = bl18;
        this.tmDatabroadDMBAvail = bl19;
        this.tmDatabroadATSCAvail = bl20;
        this.tmDatabroad1Avail = bl21;
        this.tmDatabroad2Avail = bl22;
        this.tmBWSAvail = bl23;
        this.tmSLSDLSAvail = bl24;
        this.tmTXTAvail = bl25;
        this.tmCASAvail = bl26;
        this.tmEPGAvail = bl27;
        this.tmVisualAudioAvail = bl28;
        this.requiredKeypanelList = sArray;
    }

    public int getSystemID() {
        return this.systemID;
    }

    public int getOemCodingVar() {
        return this.oemCodingVar;
    }

    public boolean isLinkingAvail() {
        return this.linkingAvail;
    }

    public boolean isAvSrcAvail() {
        return this.avSrcAvail;
    }

    public boolean isTvNormAvail() {
        return this.tvNormAvail;
    }

    public boolean isAudioChannelAvail() {
        return this.audioChannelAvail;
    }

    public boolean isVideoFormatAvail() {
        return this.videoFormatAvail;
    }

    public boolean isAvNormAvail() {
        return this.avNormAvail;
    }

    public boolean isAvFormatAvail() {
        return this.avFormatAvail;
    }

    public boolean isSubtitleAvail() {
        return this.subtitleAvail;
    }

    public boolean isEwsAvail() {
        return this.ewsAvail;
    }

    public boolean isLogoListAvail() {
        return this.logoListAvail;
    }

    public boolean isTpegAvail() {
        return this.tpegAvail;
    }

    public boolean isCasAvail() {
        return this.casAvail;
    }

    public boolean isSkipBehaviourAvail() {
        return this.skipBehaviourAvail;
    }

    public boolean isVisualAudioAvail() {
        return this.visualAudioAvail;
    }

    public boolean isBrowserListSortAvail() {
        return this.browserListSortAvail;
    }

    public boolean isParentalControlReq() {
        return this.parentalControlReq;
    }

    public boolean isTmTeletextAvail() {
        return this.tmTeletextAvail;
    }

    public boolean isTmDatabroadDVBAvail() {
        return this.tmDatabroadDVBAvail;
    }

    public boolean isTmDatabroadISDBAvail() {
        return this.tmDatabroadISDBAvail;
    }

    public boolean isTmDatabroadDTMBAvail() {
        return this.tmDatabroadDTMBAvail;
    }

    public boolean isTmDatabroadDMBAvail() {
        return this.tmDatabroadDMBAvail;
    }

    public boolean isTmDatabroadATSCAvail() {
        return this.tmDatabroadATSCAvail;
    }

    public boolean isTmDatabroad1Avail() {
        return this.tmDatabroad1Avail;
    }

    public boolean isTmDatabroad2Avail() {
        return this.tmDatabroad2Avail;
    }

    public boolean isTmBWSAvail() {
        return this.tmBWSAvail;
    }

    public boolean isTmSLSDLSAvail() {
        return this.tmSLSDLSAvail;
    }

    public boolean isTmTXTAvail() {
        return this.tmTXTAvail;
    }

    public boolean isTmCASAvail() {
        return this.tmCASAvail;
    }

    public boolean isTmEPGAvail() {
        return this.tmEPGAvail;
    }

    public boolean isTmVisualAudioAvail() {
        return this.tmVisualAudioAvail;
    }

    public short[] getRequiredKeypanelList() {
        return this.requiredKeypanelList;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(1650);
        stringBuffer.append("StartUpConfig");
        stringBuffer.append('(');
        stringBuffer.append("systemID");
        stringBuffer.append('=');
        stringBuffer.append(this.systemID);
        stringBuffer.append(',');
        stringBuffer.append("oemCodingVar");
        stringBuffer.append('=');
        stringBuffer.append(this.oemCodingVar);
        stringBuffer.append(',');
        stringBuffer.append("linkingAvail");
        stringBuffer.append('=');
        stringBuffer.append(this.linkingAvail);
        stringBuffer.append(',');
        stringBuffer.append("avSrcAvail");
        stringBuffer.append('=');
        stringBuffer.append(this.avSrcAvail);
        stringBuffer.append(',');
        stringBuffer.append("tvNormAvail");
        stringBuffer.append('=');
        stringBuffer.append(this.tvNormAvail);
        stringBuffer.append(',');
        stringBuffer.append("audioChannelAvail");
        stringBuffer.append('=');
        stringBuffer.append(this.audioChannelAvail);
        stringBuffer.append(',');
        stringBuffer.append("videoFormatAvail");
        stringBuffer.append('=');
        stringBuffer.append(this.videoFormatAvail);
        stringBuffer.append(',');
        stringBuffer.append("avNormAvail");
        stringBuffer.append('=');
        stringBuffer.append(this.avNormAvail);
        stringBuffer.append(',');
        stringBuffer.append("avFormatAvail");
        stringBuffer.append('=');
        stringBuffer.append(this.avFormatAvail);
        stringBuffer.append(',');
        stringBuffer.append("subtitleAvail");
        stringBuffer.append('=');
        stringBuffer.append(this.subtitleAvail);
        stringBuffer.append(',');
        stringBuffer.append("ewsAvail");
        stringBuffer.append('=');
        stringBuffer.append(this.ewsAvail);
        stringBuffer.append(',');
        stringBuffer.append("logoListAvail");
        stringBuffer.append('=');
        stringBuffer.append(this.logoListAvail);
        stringBuffer.append(',');
        stringBuffer.append("tpegAvail");
        stringBuffer.append('=');
        stringBuffer.append(this.tpegAvail);
        stringBuffer.append(',');
        stringBuffer.append("casAvail");
        stringBuffer.append('=');
        stringBuffer.append(this.casAvail);
        stringBuffer.append(',');
        stringBuffer.append("skipBehaviourAvail");
        stringBuffer.append('=');
        stringBuffer.append(this.skipBehaviourAvail);
        stringBuffer.append(',');
        stringBuffer.append("visualAudioAvail");
        stringBuffer.append('=');
        stringBuffer.append(this.visualAudioAvail);
        stringBuffer.append(',');
        stringBuffer.append("tmTeletextAvail");
        stringBuffer.append('=');
        stringBuffer.append(this.tmTeletextAvail);
        stringBuffer.append(',');
        stringBuffer.append("tmDatabroadDVBAvail");
        stringBuffer.append('=');
        stringBuffer.append(this.tmDatabroadDVBAvail);
        stringBuffer.append(',');
        stringBuffer.append("tmDatabroadISDBAvail");
        stringBuffer.append('=');
        stringBuffer.append(this.tmDatabroadISDBAvail);
        stringBuffer.append(',');
        stringBuffer.append("tmDatabroadDTMBAvail");
        stringBuffer.append('=');
        stringBuffer.append(this.tmDatabroadDTMBAvail);
        stringBuffer.append(',');
        stringBuffer.append("tmDatabroadDMBAvail");
        stringBuffer.append('=');
        stringBuffer.append(this.tmDatabroadDMBAvail);
        stringBuffer.append(',');
        stringBuffer.append("tmDatabroadATSCAvail");
        stringBuffer.append('=');
        stringBuffer.append(this.tmDatabroadATSCAvail);
        stringBuffer.append(',');
        stringBuffer.append("tmDatabroad1Avail");
        stringBuffer.append('=');
        stringBuffer.append(this.tmDatabroad1Avail);
        stringBuffer.append(',');
        stringBuffer.append("tmDatabroad2Avail");
        stringBuffer.append('=');
        stringBuffer.append(this.tmDatabroad2Avail);
        stringBuffer.append(',');
        stringBuffer.append("tmBWSAvail");
        stringBuffer.append('=');
        stringBuffer.append(this.tmBWSAvail);
        stringBuffer.append(',');
        stringBuffer.append("tmSLSDLSAvail");
        stringBuffer.append('=');
        stringBuffer.append(this.tmSLSDLSAvail);
        stringBuffer.append(',');
        stringBuffer.append("tmTXTAvail");
        stringBuffer.append('=');
        stringBuffer.append(this.tmTXTAvail);
        stringBuffer.append(',');
        stringBuffer.append("tmCASAvail");
        stringBuffer.append('=');
        stringBuffer.append(this.tmCASAvail);
        stringBuffer.append(',');
        stringBuffer.append("tmEPGAvail");
        stringBuffer.append('=');
        stringBuffer.append(this.tmEPGAvail);
        stringBuffer.append(',');
        stringBuffer.append("tmVisualAudioAvail");
        stringBuffer.append('=');
        stringBuffer.append(this.tmVisualAudioAvail);
        stringBuffer.append(',');
        stringBuffer.append("requiredKeypanelList");
        stringBuffer.append('[');
        if (this.requiredKeypanelList != null) {
            stringBuffer.append(this.requiredKeypanelList.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.requiredKeypanelList != null) {
            int n = this.requiredKeypanelList.length;
            int n2 = n - 1;
            for (int i2 = 0; i2 < n; ++i2) {
                stringBuffer.append(this.requiredKeypanelList[i2]);
                if (i2 >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.requiredKeypanelList);
        }
        stringBuffer.append('}');
        stringBuffer.append(',');
        stringBuffer.append("browserListSortAvail");
        stringBuffer.append('=');
        stringBuffer.append(this.browserListSortAvail);
        stringBuffer.append(',');
        stringBuffer.append("parentalControlReq");
        stringBuffer.append('=');
        stringBuffer.append(this.parentalControlReq);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

