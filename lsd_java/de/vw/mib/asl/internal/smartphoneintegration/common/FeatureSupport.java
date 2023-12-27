/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.smartphoneintegration.common;

import de.vw.mib.asl.internal.smartphoneintegration.common.SingleFeatureSupport;
import de.vw.mib.asl.internal.smartphoneintegration.common.SmartPhoneIntegrationHelper;

public class FeatureSupport {
    private SingleFeatureSupport gal = new SingleFeatureSupport();
    private SingleFeatureSupport mirrorlink = new SingleFeatureSupport();
    private SingleFeatureSupport carplay = new SingleFeatureSupport();
    private SingleFeatureSupport carlifeAndroid = new SingleFeatureSupport();
    private SingleFeatureSupport carlifeIOS = new SingleFeatureSupport();

    public SingleFeatureSupport getGal() {
        return this.gal;
    }

    public SingleFeatureSupport getMirrorlink() {
        return this.mirrorlink;
    }

    public SingleFeatureSupport getCarplay() {
        return this.carplay;
    }

    public SingleFeatureSupport getCarlifeAndroid() {
        return this.carlifeAndroid;
    }

    public SingleFeatureSupport getCarlifeIOS() {
        return this.carlifeIOS;
    }

    public void setCoding(boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5) {
        this.gal.setCoded(bl);
        this.mirrorlink.setCoded(bl2);
        this.carplay.setCoded(bl3);
        this.carlifeAndroid.setCoded(bl4);
        this.carlifeIOS.setCoded(bl5);
    }

    public void setSWAPState(int n) {
        this.gal.setSWAP(SmartPhoneIntegrationHelper.isSWaPSupported(n, 4));
        this.mirrorlink.setSWAP(SmartPhoneIntegrationHelper.isSWaPSupported(n, 1));
        this.carplay.setSWAP(SmartPhoneIntegrationHelper.isSWaPSupported(n, 2));
        this.carlifeAndroid.setSWAP(SmartPhoneIntegrationHelper.isSWaPSupported(n, 8));
        this.carlifeIOS.setSWAP(SmartPhoneIntegrationHelper.isSWaPSupported(n, 8));
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(200);
        stringBuffer.append("FeatureSupport: (");
        stringBuffer.append("GAL: ");
        stringBuffer.append(this.getGal().toString());
        stringBuffer.append(',');
        stringBuffer.append("Mirrorlink: ");
        stringBuffer.append(this.getMirrorlink().toString());
        stringBuffer.append(',');
        stringBuffer.append("Carplay: ");
        stringBuffer.append(this.getCarplay().toString());
        stringBuffer.append(',');
        stringBuffer.append("Carlife(Android): ");
        stringBuffer.append(this.getCarlifeAndroid().toString());
        stringBuffer.append(',');
        stringBuffer.append("Carlife(iOS): ");
        stringBuffer.append(this.getCarlifeIOS().toString());
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

