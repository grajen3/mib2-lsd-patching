/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.impl.download;

import de.vw.mib.asl.api.download.DownloadStateListener;
import de.vw.mib.asl.internal.download.swdl2.Preconditions;
import de.vw.mib.asl.internal.impl.download.PropagatingDownloadStateService;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class DownloadStateServiceImpl
implements PropagatingDownloadStateService {
    private final Set listeners = new HashSet();
    private int currentDownloadProgressState = 3;

    @Override
    public int getDownloadProgressState() {
        return this.currentDownloadProgressState;
    }

    @Override
    public void addListener(DownloadStateListener downloadStateListener) {
        Preconditions.checkArgumentNotNull(downloadStateListener);
        this.listeners.add(downloadStateListener);
    }

    @Override
    public void removeListener(DownloadStateListener downloadStateListener) {
        this.listeners.remove(downloadStateListener);
    }

    @Override
    public void applyCurrentProgressState(int n) {
        this.currentDownloadProgressState = n;
        this.notifyDownloadStateListeners(n);
    }

    private void notifyDownloadStateListeners(int n) {
        Iterator iterator = this.listeners.iterator();
        while (iterator.hasNext()) {
            DownloadStateListener downloadStateListener = (DownloadStateListener)iterator.next();
            downloadStateListener.onNewDownloadProgressState(n);
        }
    }
}

