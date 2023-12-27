/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.imageserver;

import de.esolutions.fw.comm.asi.imageserver.Image;
import de.esolutions.fw.comm.asi.imageserver.ImageInfo;

public interface ImageServerReply {
    public static final String IPL_COMM_UUID;
    public static final String IPL_COMM_INTERFACE_KEY;
    public static final String IPL_COMM_INTERFACE_VERSION;
    public static final String IPL_COMM_MODULE_VERSION;

    default public void responseImage(String string, Image image, int n) {
    }

    default public void responseImageInformation(String string, ImageInfo imageInfo, int n) {
    }

    default public void updateASIVersion(String string, boolean bl) {
    }
}

