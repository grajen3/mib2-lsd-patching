/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carlight;

import org.dsi.ifc.carlight.IntLightMembersIlluminationSet;
import org.dsi.ifc.carlight.IntLightMembersMultiColor;
import org.dsi.ifc.carlight.IntLightSetupColors;
import org.dsi.ifc.carlight.IntLightTransmittableElements;

public class IntLightConfig {
    public boolean ambienceStateAutoAvailable;
    public boolean ambienceStatePrivacyAvailable;
    public int setupIlluminationSet1;
    public int setupIlluminationSet2;
    public int setupIlluminationSet3;
    public int setupIlluminationSet4;
    public int setupIlluminationSet5;
    public int setupIlluminationSet6;
    public int setupIlluminationSet7;
    public int setupIlluminationSet8;
    public IntLightMembersIlluminationSet membersIlluminationSet1;
    public IntLightMembersIlluminationSet membersIlluminationSet2;
    public IntLightMembersIlluminationSet membersIlluminationSet3;
    public IntLightMembersIlluminationSet membersIlluminationSet4;
    public IntLightMembersIlluminationSet membersIlluminationSet5;
    public IntLightMembersIlluminationSet membersIlluminationSet6;
    public IntLightMembersIlluminationSet membersIlluminationSet7;
    public IntLightMembersIlluminationSet membersIlluminationSet8;
    public int setupIlluminationProfile1;
    public int setupIlluminationProfile2;
    public int setupIlluminationProfile3;
    public int setupIlluminationProfile4;
    public int setupIlluminationProfile5;
    public int setupIlluminationProfile6;
    public int setupIlluminationProfile7;
    public int setupIlluminationProfile8;
    public IntLightTransmittableElements rgbColorListTransmittableElements;
    public IntLightMembersMultiColor membersMultiColor;
    public IntLightSetupColors setupColors;

    public IntLightConfig() {
        this.ambienceStateAutoAvailable = false;
        this.ambienceStatePrivacyAvailable = false;
        this.setupIlluminationSet1 = 0;
        this.setupIlluminationSet2 = 0;
        this.setupIlluminationSet3 = 0;
        this.setupIlluminationSet4 = 0;
        this.setupIlluminationSet5 = 0;
        this.setupIlluminationSet6 = 0;
        this.setupIlluminationSet7 = 0;
        this.setupIlluminationSet8 = 0;
        this.membersIlluminationSet1 = null;
        this.membersIlluminationSet2 = null;
        this.membersIlluminationSet3 = null;
        this.membersIlluminationSet4 = null;
        this.membersIlluminationSet5 = null;
        this.membersIlluminationSet6 = null;
        this.membersIlluminationSet7 = null;
        this.membersIlluminationSet8 = null;
        this.setupIlluminationProfile1 = 0;
        this.setupIlluminationProfile2 = 0;
        this.setupIlluminationProfile3 = 0;
        this.setupIlluminationProfile4 = 0;
        this.setupIlluminationProfile5 = 0;
        this.setupIlluminationProfile6 = 0;
        this.setupIlluminationProfile7 = 0;
        this.setupIlluminationProfile8 = 0;
        this.rgbColorListTransmittableElements = null;
        this.membersMultiColor = null;
        this.setupColors = null;
    }

    public IntLightConfig(boolean bl, boolean bl2, int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8, IntLightMembersIlluminationSet intLightMembersIlluminationSet, IntLightMembersIlluminationSet intLightMembersIlluminationSet2, IntLightMembersIlluminationSet intLightMembersIlluminationSet3, IntLightMembersIlluminationSet intLightMembersIlluminationSet4, IntLightMembersIlluminationSet intLightMembersIlluminationSet5, IntLightMembersIlluminationSet intLightMembersIlluminationSet6, IntLightMembersIlluminationSet intLightMembersIlluminationSet7, IntLightMembersIlluminationSet intLightMembersIlluminationSet8, int n9, int n10, int n11, int n12, int n13, int n14, int n15, int n16, IntLightTransmittableElements intLightTransmittableElements, IntLightMembersMultiColor intLightMembersMultiColor, IntLightSetupColors intLightSetupColors) {
        this.ambienceStateAutoAvailable = bl;
        this.ambienceStatePrivacyAvailable = bl2;
        this.setupIlluminationSet1 = n;
        this.setupIlluminationSet2 = n2;
        this.setupIlluminationSet3 = n3;
        this.setupIlluminationSet4 = n4;
        this.setupIlluminationSet5 = n5;
        this.setupIlluminationSet6 = n6;
        this.setupIlluminationSet7 = n7;
        this.setupIlluminationSet8 = n8;
        this.membersIlluminationSet1 = intLightMembersIlluminationSet;
        this.membersIlluminationSet2 = intLightMembersIlluminationSet2;
        this.membersIlluminationSet3 = intLightMembersIlluminationSet3;
        this.membersIlluminationSet4 = intLightMembersIlluminationSet4;
        this.membersIlluminationSet5 = intLightMembersIlluminationSet5;
        this.membersIlluminationSet6 = intLightMembersIlluminationSet6;
        this.membersIlluminationSet7 = intLightMembersIlluminationSet7;
        this.membersIlluminationSet8 = intLightMembersIlluminationSet8;
        this.setupIlluminationProfile1 = n9;
        this.setupIlluminationProfile2 = n10;
        this.setupIlluminationProfile3 = n11;
        this.setupIlluminationProfile4 = n12;
        this.setupIlluminationProfile5 = n13;
        this.setupIlluminationProfile6 = n14;
        this.setupIlluminationProfile7 = n15;
        this.setupIlluminationProfile8 = n16;
        this.rgbColorListTransmittableElements = intLightTransmittableElements;
        this.membersMultiColor = intLightMembersMultiColor;
        this.setupColors = intLightSetupColors;
    }

    public boolean isAmbienceStateAutoAvailable() {
        return this.ambienceStateAutoAvailable;
    }

    public boolean isAmbienceStatePrivacyAvailable() {
        return this.ambienceStatePrivacyAvailable;
    }

    public int getSetupIlluminationSet1() {
        return this.setupIlluminationSet1;
    }

    public int getSetupIlluminationSet2() {
        return this.setupIlluminationSet2;
    }

    public int getSetupIlluminationSet3() {
        return this.setupIlluminationSet3;
    }

    public int getSetupIlluminationSet4() {
        return this.setupIlluminationSet4;
    }

    public int getSetupIlluminationSet5() {
        return this.setupIlluminationSet5;
    }

    public int getSetupIlluminationSet6() {
        return this.setupIlluminationSet6;
    }

    public int getSetupIlluminationSet7() {
        return this.setupIlluminationSet7;
    }

    public int getSetupIlluminationSet8() {
        return this.setupIlluminationSet8;
    }

    public IntLightMembersIlluminationSet getMembersIlluminationSet1() {
        return this.membersIlluminationSet1;
    }

    public IntLightMembersIlluminationSet getMembersIlluminationSet2() {
        return this.membersIlluminationSet2;
    }

    public IntLightMembersIlluminationSet getMembersIlluminationSet3() {
        return this.membersIlluminationSet3;
    }

    public IntLightMembersIlluminationSet getMembersIlluminationSet4() {
        return this.membersIlluminationSet4;
    }

    public IntLightMembersIlluminationSet getMembersIlluminationSet5() {
        return this.membersIlluminationSet5;
    }

    public IntLightMembersIlluminationSet getMembersIlluminationSet6() {
        return this.membersIlluminationSet6;
    }

    public IntLightMembersIlluminationSet getMembersIlluminationSet7() {
        return this.membersIlluminationSet7;
    }

    public IntLightMembersIlluminationSet getMembersIlluminationSet8() {
        return this.membersIlluminationSet8;
    }

    public int getSetupIlluminationProfile1() {
        return this.setupIlluminationProfile1;
    }

    public int getSetupIlluminationProfile2() {
        return this.setupIlluminationProfile2;
    }

    public int getSetupIlluminationProfile3() {
        return this.setupIlluminationProfile3;
    }

    public int getSetupIlluminationProfile4() {
        return this.setupIlluminationProfile4;
    }

    public int getSetupIlluminationProfile5() {
        return this.setupIlluminationProfile5;
    }

    public int getSetupIlluminationProfile6() {
        return this.setupIlluminationProfile6;
    }

    public int getSetupIlluminationProfile7() {
        return this.setupIlluminationProfile7;
    }

    public int getSetupIlluminationProfile8() {
        return this.setupIlluminationProfile8;
    }

    public IntLightTransmittableElements getRgbColorListTransmittableElements() {
        return this.rgbColorListTransmittableElements;
    }

    public IntLightMembersMultiColor getMembersMultiColor() {
        return this.membersMultiColor;
    }

    public IntLightSetupColors getSetupColors() {
        return this.setupColors;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(13000);
        stringBuffer.append("IntLightConfig");
        stringBuffer.append('(');
        stringBuffer.append("ambienceStateAutoAvailable");
        stringBuffer.append('=');
        stringBuffer.append(this.ambienceStateAutoAvailable);
        stringBuffer.append(',');
        stringBuffer.append("ambienceStatePrivacyAvailable");
        stringBuffer.append('=');
        stringBuffer.append(this.ambienceStatePrivacyAvailable);
        stringBuffer.append(',');
        stringBuffer.append("setupIlluminationSet1");
        stringBuffer.append('=');
        stringBuffer.append(this.setupIlluminationSet1);
        stringBuffer.append(',');
        stringBuffer.append("setupIlluminationSet2");
        stringBuffer.append('=');
        stringBuffer.append(this.setupIlluminationSet2);
        stringBuffer.append(',');
        stringBuffer.append("setupIlluminationSet3");
        stringBuffer.append('=');
        stringBuffer.append(this.setupIlluminationSet3);
        stringBuffer.append(',');
        stringBuffer.append("setupIlluminationSet4");
        stringBuffer.append('=');
        stringBuffer.append(this.setupIlluminationSet4);
        stringBuffer.append(',');
        stringBuffer.append("setupIlluminationSet5");
        stringBuffer.append('=');
        stringBuffer.append(this.setupIlluminationSet5);
        stringBuffer.append(',');
        stringBuffer.append("setupIlluminationSet6");
        stringBuffer.append('=');
        stringBuffer.append(this.setupIlluminationSet6);
        stringBuffer.append(',');
        stringBuffer.append("setupIlluminationSet7");
        stringBuffer.append('=');
        stringBuffer.append(this.setupIlluminationSet7);
        stringBuffer.append(',');
        stringBuffer.append("setupIlluminationSet8");
        stringBuffer.append('=');
        stringBuffer.append(this.setupIlluminationSet8);
        stringBuffer.append(',');
        stringBuffer.append("membersIlluminationSet1");
        stringBuffer.append('=');
        stringBuffer.append(this.membersIlluminationSet1);
        stringBuffer.append(',');
        stringBuffer.append("membersIlluminationSet2");
        stringBuffer.append('=');
        stringBuffer.append(this.membersIlluminationSet2);
        stringBuffer.append(',');
        stringBuffer.append("membersIlluminationSet3");
        stringBuffer.append('=');
        stringBuffer.append(this.membersIlluminationSet3);
        stringBuffer.append(',');
        stringBuffer.append("membersIlluminationSet4");
        stringBuffer.append('=');
        stringBuffer.append(this.membersIlluminationSet4);
        stringBuffer.append(',');
        stringBuffer.append("membersIlluminationSet5");
        stringBuffer.append('=');
        stringBuffer.append(this.membersIlluminationSet5);
        stringBuffer.append(',');
        stringBuffer.append("membersIlluminationSet6");
        stringBuffer.append('=');
        stringBuffer.append(this.membersIlluminationSet6);
        stringBuffer.append(',');
        stringBuffer.append("membersIlluminationSet7");
        stringBuffer.append('=');
        stringBuffer.append(this.membersIlluminationSet7);
        stringBuffer.append(',');
        stringBuffer.append("membersIlluminationSet8");
        stringBuffer.append('=');
        stringBuffer.append(this.membersIlluminationSet8);
        stringBuffer.append(',');
        stringBuffer.append("setupIlluminationProfile1");
        stringBuffer.append('=');
        stringBuffer.append(this.setupIlluminationProfile1);
        stringBuffer.append(',');
        stringBuffer.append("setupIlluminationProfile2");
        stringBuffer.append('=');
        stringBuffer.append(this.setupIlluminationProfile2);
        stringBuffer.append(',');
        stringBuffer.append("setupIlluminationProfile3");
        stringBuffer.append('=');
        stringBuffer.append(this.setupIlluminationProfile3);
        stringBuffer.append(',');
        stringBuffer.append("setupIlluminationProfile4");
        stringBuffer.append('=');
        stringBuffer.append(this.setupIlluminationProfile4);
        stringBuffer.append(',');
        stringBuffer.append("setupIlluminationProfile5");
        stringBuffer.append('=');
        stringBuffer.append(this.setupIlluminationProfile5);
        stringBuffer.append(',');
        stringBuffer.append("setupIlluminationProfile6");
        stringBuffer.append('=');
        stringBuffer.append(this.setupIlluminationProfile6);
        stringBuffer.append(',');
        stringBuffer.append("setupIlluminationProfile7");
        stringBuffer.append('=');
        stringBuffer.append(this.setupIlluminationProfile7);
        stringBuffer.append(',');
        stringBuffer.append("setupIlluminationProfile8");
        stringBuffer.append('=');
        stringBuffer.append(this.setupIlluminationProfile8);
        stringBuffer.append(',');
        stringBuffer.append("rgbColorListTransmittableElements");
        stringBuffer.append('=');
        stringBuffer.append(this.rgbColorListTransmittableElements);
        stringBuffer.append(',');
        stringBuffer.append("membersMultiColor");
        stringBuffer.append('=');
        stringBuffer.append(this.membersMultiColor);
        stringBuffer.append(',');
        stringBuffer.append("setupColors");
        stringBuffer.append('=');
        stringBuffer.append(this.setupColors);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

