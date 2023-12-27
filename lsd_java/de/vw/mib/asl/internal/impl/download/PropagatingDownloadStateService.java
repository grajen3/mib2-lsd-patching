/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.impl.download;

import de.vw.mib.asl.api.download.DownloadStateService;

public interface PropagatingDownloadStateService
extends DownloadStateService {
    default public void applyCurrentProgressState(int n) {
    }
}

