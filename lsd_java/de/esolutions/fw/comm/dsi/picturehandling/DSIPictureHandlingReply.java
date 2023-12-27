/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.picturehandling;

import org.dsi.ifc.global.ResourceLocator;

public interface DSIPictureHandlingReply {
    public static final String IPL_COMM_UUID;
    public static final String IPL_COMM_INTERFACE_KEY;
    public static final String IPL_COMM_INTERFACE_VERSION;
    public static final String IPL_COMM_MODULE_VERSION;

    default public void indicatePicture(int n, int n2, ResourceLocator resourceLocator, ResourceLocator resourceLocator2) {
    }

    default public void finishPictureRequest(int n) {
    }

    default public void asyncException(int n, String string, int n2) {
    }

    default public void yyIndication(String string, String string2) {
    }
}

