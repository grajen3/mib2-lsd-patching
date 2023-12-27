/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.online;

import org.dsi.ifc.base.DSIListener;

public interface DSIOnlineTourImportListener
extends DSIListener {
    default public void indicateToursAvailable(int n) {
    }

    default public void responseTourDownload(int n) {
    }

    default public void indicateTourDownloadFinished(int n, String string, String string2, int n2) {
    }
}

