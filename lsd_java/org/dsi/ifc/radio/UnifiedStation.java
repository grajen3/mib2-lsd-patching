/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.radio;

import org.dsi.ifc.global.ResourceLocator;

public class UnifiedStation {
    public String shortName;
    public String longName;
    public long frequency;
    public int piSId;
    public int ensId;
    public int ecc;
    public int sCIDI;
    public int scrollingPS;
    public boolean rds;
    public int audioQuality;
    public int tpAvailability;
    public byte[] ptyCodes;
    public boolean radioText;
    public boolean radioTextPlus;
    public boolean enhancedRadioText;
    public boolean slideshow;
    public ResourceLocator stationLogo;
    public boolean coChannel;

    public UnifiedStation() {
        this.shortName = "";
        this.longName = "";
        this.frequency = 0L;
        this.piSId = 0;
        this.ensId = 0;
        this.ecc = 0;
        this.sCIDI = 0;
        this.scrollingPS = 0;
        this.rds = false;
        this.audioQuality = 0;
        this.tpAvailability = 0;
        this.ptyCodes = null;
        this.radioText = false;
        this.radioTextPlus = false;
        this.enhancedRadioText = false;
        this.slideshow = false;
        this.stationLogo = null;
        this.coChannel = false;
    }

    public UnifiedStation(String string, String string2, long l, int n, int n2, int n3, int n4, int n5, boolean bl, int n6, int n7, byte[] byArray, boolean bl2, boolean bl3, boolean bl4, boolean bl5, ResourceLocator resourceLocator, boolean bl6) {
        this.shortName = string;
        this.longName = string2;
        this.frequency = l;
        this.piSId = n;
        this.ensId = n2;
        this.ecc = n3;
        this.sCIDI = n4;
        this.scrollingPS = n5;
        this.rds = bl;
        this.audioQuality = n6;
        this.tpAvailability = n7;
        this.ptyCodes = byArray;
        this.radioText = bl2;
        this.radioTextPlus = bl3;
        this.enhancedRadioText = bl4;
        this.slideshow = bl5;
        this.stationLogo = resourceLocator;
        this.coChannel = bl6;
    }

    public String getShortName() {
        return this.shortName;
    }

    public String getLongName() {
        return this.longName;
    }

    public long getFrequency() {
        return this.frequency;
    }

    public int getPiSId() {
        return this.piSId;
    }

    public int getEnsId() {
        return this.ensId;
    }

    public int getEcc() {
        return this.ecc;
    }

    public int getSCIDI() {
        return this.sCIDI;
    }

    public int getScrollingPS() {
        return this.scrollingPS;
    }

    public boolean isRds() {
        return this.rds;
    }

    public int getAudioQuality() {
        return this.audioQuality;
    }

    public int getTpAvailability() {
        return this.tpAvailability;
    }

    public byte[] getPtyCodes() {
        return this.ptyCodes;
    }

    public boolean isRadioText() {
        return this.radioText;
    }

    public boolean isRadioTextPlus() {
        return this.radioTextPlus;
    }

    public boolean isEnhancedRadioText() {
        return this.enhancedRadioText;
    }

    public boolean isSlideshow() {
        return this.slideshow;
    }

    public ResourceLocator getStationLogo() {
        return this.stationLogo;
    }

    public boolean isCoChannel() {
        return this.coChannel;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(1900);
        stringBuffer.append("UnifiedStation");
        stringBuffer.append('(');
        stringBuffer.append("shortName");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.shortName);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("longName");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.longName);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("frequency");
        stringBuffer.append('=');
        stringBuffer.append(this.frequency);
        stringBuffer.append(',');
        stringBuffer.append("piSId");
        stringBuffer.append('=');
        stringBuffer.append(this.piSId);
        stringBuffer.append(',');
        stringBuffer.append("ensId");
        stringBuffer.append('=');
        stringBuffer.append(this.ensId);
        stringBuffer.append(',');
        stringBuffer.append("ecc");
        stringBuffer.append('=');
        stringBuffer.append(this.ecc);
        stringBuffer.append(',');
        stringBuffer.append("sCIDI");
        stringBuffer.append('=');
        stringBuffer.append(this.sCIDI);
        stringBuffer.append(',');
        stringBuffer.append("scrollingPS");
        stringBuffer.append('=');
        stringBuffer.append(this.scrollingPS);
        stringBuffer.append(',');
        stringBuffer.append("rds");
        stringBuffer.append('=');
        stringBuffer.append(this.rds);
        stringBuffer.append(',');
        stringBuffer.append("audioQuality");
        stringBuffer.append('=');
        stringBuffer.append(this.audioQuality);
        stringBuffer.append(',');
        stringBuffer.append("tpAvailability");
        stringBuffer.append('=');
        stringBuffer.append(this.tpAvailability);
        stringBuffer.append(',');
        stringBuffer.append("ptyCodes");
        stringBuffer.append('[');
        if (this.ptyCodes != null) {
            stringBuffer.append(this.ptyCodes.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.ptyCodes != null) {
            int n = this.ptyCodes.length;
            int n2 = n - 1;
            for (int i2 = 0; i2 < n; ++i2) {
                stringBuffer.append(this.ptyCodes[i2]);
                if (i2 >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.ptyCodes);
        }
        stringBuffer.append('}');
        stringBuffer.append(',');
        stringBuffer.append("radioText");
        stringBuffer.append('=');
        stringBuffer.append(this.radioText);
        stringBuffer.append(',');
        stringBuffer.append("radioTextPlus");
        stringBuffer.append('=');
        stringBuffer.append(this.radioTextPlus);
        stringBuffer.append(',');
        stringBuffer.append("enhancedRadioText");
        stringBuffer.append('=');
        stringBuffer.append(this.enhancedRadioText);
        stringBuffer.append(',');
        stringBuffer.append("slideshow");
        stringBuffer.append('=');
        stringBuffer.append(this.slideshow);
        stringBuffer.append(',');
        stringBuffer.append("stationLogo");
        stringBuffer.append('=');
        stringBuffer.append(this.stationLogo);
        stringBuffer.append(',');
        stringBuffer.append("coChannel");
        stringBuffer.append('=');
        stringBuffer.append(this.coChannel);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

