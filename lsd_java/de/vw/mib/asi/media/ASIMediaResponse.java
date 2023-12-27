/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asi.media;

import de.esolutions.fw.comm.asi.hmisync.media.MediaEntry;
import de.vw.mib.asi.ASIResponse;

public interface ASIMediaResponse
extends ASIResponse {
    default public void indicationCmdBlocked(int n) {
    }

    default public void responsePlayList(boolean bl, int n, MediaEntry[] mediaEntryArray) {
    }

    default public void responseSetPlaySelection(boolean bl) {
    }

    default public void responsePlayMoreFrom(long l, int n, int n2) {
    }
}

