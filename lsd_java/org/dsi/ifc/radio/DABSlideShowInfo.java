/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.radio;

import org.dsi.ifc.global.ResourceLocator;

public class DABSlideShowInfo {
    public int ensID;
    public int ensECC;
    public int sID;
    public int sCIDI;
    public ResourceLocator slideshowImage;
    public int category;

    public DABSlideShowInfo() {
        this.ensID = 0;
        this.ensECC = 0;
        this.sID = 0;
        this.sCIDI = 0;
        this.slideshowImage = new ResourceLocator();
        this.category = 0;
    }

    public DABSlideShowInfo(int n, int n2, int n3, int n4, ResourceLocator resourceLocator, int n5) {
        this.ensID = n;
        this.ensECC = n2;
        this.sID = n3;
        this.sCIDI = n4;
        this.slideshowImage = resourceLocator;
        this.category = n5;
    }

    public int getEnsID() {
        return this.ensID;
    }

    public int getEnsECC() {
        return this.ensECC;
    }

    public int getSID() {
        return this.sID;
    }

    public int getSCIDI() {
        return this.sCIDI;
    }

    public ResourceLocator getSlideshowImage() {
        return this.slideshowImage;
    }

    public int getCategory() {
        return this.category;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(1300);
        stringBuffer.append("DABSlideShowInfo");
        stringBuffer.append('(');
        stringBuffer.append("ensID");
        stringBuffer.append('=');
        stringBuffer.append(this.ensID);
        stringBuffer.append(',');
        stringBuffer.append("ensECC");
        stringBuffer.append('=');
        stringBuffer.append(this.ensECC);
        stringBuffer.append(',');
        stringBuffer.append("sID");
        stringBuffer.append('=');
        stringBuffer.append(this.sID);
        stringBuffer.append(',');
        stringBuffer.append("sCIDI");
        stringBuffer.append('=');
        stringBuffer.append(this.sCIDI);
        stringBuffer.append(',');
        stringBuffer.append("slideshowImage");
        stringBuffer.append('=');
        stringBuffer.append(this.slideshowImage);
        stringBuffer.append(',');
        stringBuffer.append("category");
        stringBuffer.append('=');
        stringBuffer.append(this.category);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

