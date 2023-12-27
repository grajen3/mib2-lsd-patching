/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carparkingsystem;

import org.dsi.ifc.carparkingsystem.VPSSupportedBVModes;
import org.dsi.ifc.carparkingsystem.VPSSupportedFVModes;
import org.dsi.ifc.carparkingsystem.VPSSupportedRVModes;
import org.dsi.ifc.carparkingsystem.VPSSupportedSVModes;
import org.dsi.ifc.carparkingsystem.VPSSupportedSplitscreens;
import org.dsi.ifc.carparkingsystem.VPSSupportedViews;

public class VPSConfiguration {
    public VPSSupportedSplitscreens supportedSplitScreens;
    public VPSSupportedViews supportedViews;
    public VPSSupportedRVModes supportedRVModes;
    public VPSSupportedFVModes supportedFVModes;
    public VPSSupportedSVModes supportedSVModes;
    public VPSSupportedBVModes supportedBVModes;
    public int birdview3DViewPlains;
    public int birdview3DViewPoints;

    public VPSConfiguration() {
        this.supportedSplitScreens = null;
        this.supportedViews = null;
        this.supportedRVModes = null;
        this.supportedFVModes = null;
        this.supportedSVModes = null;
        this.supportedBVModes = null;
        this.birdview3DViewPlains = 0;
        this.birdview3DViewPoints = 0;
    }

    public VPSConfiguration(VPSSupportedSplitscreens vPSSupportedSplitscreens, VPSSupportedViews vPSSupportedViews, VPSSupportedRVModes vPSSupportedRVModes, VPSSupportedFVModes vPSSupportedFVModes, VPSSupportedSVModes vPSSupportedSVModes, VPSSupportedBVModes vPSSupportedBVModes, int n, int n2) {
        this.supportedSplitScreens = vPSSupportedSplitscreens;
        this.supportedViews = vPSSupportedViews;
        this.supportedRVModes = vPSSupportedRVModes;
        this.supportedFVModes = vPSSupportedFVModes;
        this.supportedSVModes = vPSSupportedSVModes;
        this.supportedBVModes = vPSSupportedBVModes;
        this.birdview3DViewPlains = n;
        this.birdview3DViewPoints = n2;
    }

    public VPSSupportedSplitscreens getSupportedSplitScreens() {
        return this.supportedSplitScreens;
    }

    public VPSSupportedViews getSupportedViews() {
        return this.supportedViews;
    }

    public VPSSupportedRVModes getSupportedRVModes() {
        return this.supportedRVModes;
    }

    public VPSSupportedFVModes getSupportedFVModes() {
        return this.supportedFVModes;
    }

    public VPSSupportedSVModes getSupportedSVModes() {
        return this.supportedSVModes;
    }

    public VPSSupportedBVModes getSupportedBVModes() {
        return this.supportedBVModes;
    }

    public int getBirdview3DViewPlains() {
        return this.birdview3DViewPlains;
    }

    public int getBirdview3DViewPoints() {
        return this.birdview3DViewPoints;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(6450);
        stringBuffer.append("VPSConfiguration");
        stringBuffer.append('(');
        stringBuffer.append("supportedSplitScreens");
        stringBuffer.append('=');
        stringBuffer.append(this.supportedSplitScreens);
        stringBuffer.append(',');
        stringBuffer.append("supportedViews");
        stringBuffer.append('=');
        stringBuffer.append(this.supportedViews);
        stringBuffer.append(',');
        stringBuffer.append("supportedRVModes");
        stringBuffer.append('=');
        stringBuffer.append(this.supportedRVModes);
        stringBuffer.append(',');
        stringBuffer.append("supportedFVModes");
        stringBuffer.append('=');
        stringBuffer.append(this.supportedFVModes);
        stringBuffer.append(',');
        stringBuffer.append("supportedSVModes");
        stringBuffer.append('=');
        stringBuffer.append(this.supportedSVModes);
        stringBuffer.append(',');
        stringBuffer.append("supportedBVModes");
        stringBuffer.append('=');
        stringBuffer.append(this.supportedBVModes);
        stringBuffer.append(',');
        stringBuffer.append("birdview3DViewPlains");
        stringBuffer.append('=');
        stringBuffer.append(this.birdview3DViewPlains);
        stringBuffer.append(',');
        stringBuffer.append("birdview3DViewPoints");
        stringBuffer.append('=');
        stringBuffer.append(this.birdview3DViewPoints);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

