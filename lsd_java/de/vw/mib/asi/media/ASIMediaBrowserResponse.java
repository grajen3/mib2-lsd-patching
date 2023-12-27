/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asi.media;

import de.esolutions.fw.comm.asi.hmisync.media.MediaEntry;
import de.vw.mib.asi.ASIResponse;

public interface ASIMediaBrowserResponse
extends ASIResponse {
    default public void responseChangeFolder(boolean bl) {
    }

    default public void responseAddSelection(boolean bl) {
    }

    default public void responseList(boolean bl, int n, MediaEntry[] mediaEntryArray) {
    }
}

