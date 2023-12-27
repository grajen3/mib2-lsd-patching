/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechmedia.sources.model;

public class SourceModel {
    public static final int MAX_SD;
    public static final int MAX_USB;
    public static final int JUKEBOX;
    public static final int CD;
    public static final int DVD;
    public static final int SD_1;
    public static final int SD_2;
    public static final int USB_1;
    public static final int USB_2;
    public static final int USB_3;
    public static final int USB_4;
    public static final int BT;
    public static final int AUX;
    public static final int WLAN;
    public static final int TYPE_USB;
    public static final int TYPE_SD;
    public static final int UNKNOWN;
    public int id;
    public boolean available;

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("Source=(");
        stringBuffer.append("id='").append(this.id).append("' ");
        stringBuffer.append("available='").append(this.available).append("' ");
        stringBuffer.append(")");
        return stringBuffer.toString();
    }
}

