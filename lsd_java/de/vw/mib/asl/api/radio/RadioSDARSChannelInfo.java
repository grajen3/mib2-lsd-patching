/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.radio;

import org.dsi.ifc.global.ResourceLocator;

public class RadioSDARSChannelInfo {
    private String channelName = "";
    private int channelNumber = 0;
    private int serviceID = 0;
    private String artist = "";
    private String title = "";
    private ResourceLocator channelLogo = null;

    public String getChannelName() {
        return this.channelName;
    }

    public void setChannelName(String string) {
        this.channelName = null != string ? string : "";
    }

    public int getChannelNumber() {
        return this.channelNumber;
    }

    public void setChannelNumber(int n) {
        this.channelNumber = n;
    }

    public int getServiceID() {
        return this.serviceID;
    }

    public void setServiceID(int n) {
        this.serviceID = n;
    }

    public String getArtist() {
        return this.artist;
    }

    public void setArtist(String string) {
        this.artist = null != string ? string : "";
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String string) {
        this.title = null != string ? string : "";
    }

    public ResourceLocator getChannelLogo() {
        return this.channelLogo;
    }

    public void setChannelLogo(ResourceLocator resourceLocator) {
        this.channelLogo = resourceLocator;
    }
}

