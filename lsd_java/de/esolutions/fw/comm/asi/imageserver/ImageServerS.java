/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.imageserver;

import de.esolutions.fw.comm.asi.imageserver.ImageServerReply;

public interface ImageServerS {
    default public void requestImage(String[] stringArray, byte by, boolean bl, ImageServerReply imageServerReply) {
    }

    default public void requestImageInformation(String[] stringArray, ImageServerReply imageServerReply) {
    }

    default public void setNotification(ImageServerReply imageServerReply) {
    }

    default public void setNotification(long l, ImageServerReply imageServerReply) {
    }

    default public void setNotification(long[] lArray, ImageServerReply imageServerReply) {
    }

    default public void clearNotification(ImageServerReply imageServerReply) {
    }

    default public void clearNotification(long l, ImageServerReply imageServerReply) {
    }

    default public void clearNotification(long[] lArray, ImageServerReply imageServerReply) {
    }
}

