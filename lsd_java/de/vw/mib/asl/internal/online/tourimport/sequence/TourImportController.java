/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.tourimport.sequence;

import de.vw.mib.asl.api.navigation.memory.NavigationMemoryListenerAdapter;
import de.vw.mib.asl.internal.online.tourimport.TourImportFactory;
import de.vw.mib.asl.internal.online.tourimport.states.TourImportTarget;

public class TourImportController
extends NavigationMemoryListenerAdapter {
    final String _classname = super.getClass().getName();
    private TourImportTarget _target;

    public TourImportTarget getTarget() {
        if (this._target == null) {
            this._target = TourImportFactory.getOnlineTourImportTarget();
        }
        return this._target;
    }

    public void handleServiceFullFactoryReset() {
        if (TourImportFactory.getImportPropertyManager().isDownloadActive()) {
            this.getTarget().getDSITourImport().dismissTourDownload();
        }
        TourImportFactory.getImportPropertyManager().setToursAvailable(-1);
        TourImportFactory.getImportPropertyManager().setTourMemoryCapacity(-1);
        TourImportFactory.getImportPropertyManager().setRequestedTours(-1);
        TourImportFactory.getImportPropertyManager().setDownloadAllowed(true);
        TourImportFactory.getImportPropertyManager().setDownloadActive(false);
        if (this.getTarget().isTraceEnabled()) {
            this.getTarget().trace().append(this._classname).append(".handleServiceFullFactoryReset()").log();
        }
    }

    @Override
    public void importToursFromGpxResult(int n) {
        if (this.getTarget().isTraceEnabled()) {
            this.getTarget().trace().append(this._classname).append(".importToursFromGpxResult(").append(n).append(")").log();
        }
        TourImportFactory.getImportPropertyManager().setImportResult(n);
        switch (n) {
            case 1: {
                this._target.triggerObserver(-1585053440, null);
                break;
            }
            case 2: {
                this._target.triggerObserver(-1568276224, null);
                break;
            }
            case 3: {
                this.abortTourDownload();
                break;
            }
        }
    }

    @Override
    public void updateTourMemoryCapacity(int n) {
        if (this.getTarget().isTraceEnabled()) {
            this.getTarget().trace().append(this._classname).append(".updateTourMemoryCapacity(").append(n).append(")").log();
        }
        TourImportFactory.getImportPropertyManager().setTourMemoryCapacity(n);
    }

    @Override
    public void doTourDownload() {
        if (this.getTarget().isTraceEnabled()) {
            this.getTarget().trace().append(this._classname).append(".doTourDownload(").append(")").log();
        }
        this._target.triggerObserver(-1551499008, null);
    }

    @Override
    public void abortTourDownload() {
        if (this.getTarget().isTraceEnabled()) {
            this.getTarget().trace().append(this._classname).append(".abortTourDownload(").append(")").log();
        }
        this._target.triggerObserver(-1534721792, null);
    }
}

