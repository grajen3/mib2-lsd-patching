/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.sdis.version;

import de.esolutions.fw.comm.asi.sdis.version.SDISVersionReply;

public interface SDISVersionS {
    default public void setNotification(SDISVersionReply sDISVersionReply) {
    }

    default public void setNotification(long l, SDISVersionReply sDISVersionReply) {
    }

    default public void setNotification(long[] lArray, SDISVersionReply sDISVersionReply) {
    }

    default public void clearNotification(SDISVersionReply sDISVersionReply) {
    }

    default public void clearNotification(long l, SDISVersionReply sDISVersionReply) {
    }

    default public void clearNotification(long[] lArray, SDISVersionReply sDISVersionReply) {
    }
}

