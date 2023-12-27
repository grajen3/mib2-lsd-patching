/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.cio.internal;

import de.vw.mib.cio.CioActionParameters;
import de.vw.mib.cio.CioDispatcher;
import de.vw.mib.cio.CioIntent;
import de.vw.mib.cio.ContentInformationObject;
import de.vw.mib.cio.framework.diag.CioDiagListener;
import de.vw.mib.cio.internal.AbstractCio;
import de.vw.mib.cio.internal.DiagService;
import de.vw.mib.log4mib.Logger;

final class Dispatcher
implements CioDispatcher {
    private CioDiagListener diagService;
    private final Logger logger;

    Dispatcher(Logger logger) {
        this.logger = logger;
        this.diagService = CioDiagListener.EMPTY_DIAG_LISTENER;
    }

    @Override
    public void dispatch(ContentInformationObject contentInformationObject) {
        this.dispatchCio((AbstractCio)contentInformationObject, null);
    }

    @Override
    public void dispatch(CioIntent cioIntent) {
        if (cioIntent == null) {
            this.logger.warn(2).append("couldn't dispatch cio! Cio is null").log();
            return;
        }
        this.dispatch(cioIntent, null);
    }

    @Override
    public void dispatch(CioIntent cioIntent, CioActionParameters cioActionParameters) {
        this.dispatchCio((AbstractCio)cioIntent, cioActionParameters);
    }

    void setCioDiagService(DiagService diagService) {
        this.diagService = diagService;
    }

    private void dispatchCio(AbstractCio abstractCio, CioActionParameters cioActionParameters) {
        if (abstractCio == null) {
            this.logger.warn(2).append("couldn't dispatch cio! Cio intent is null!").log();
            return;
        }
        if (this.logger.isTraceEnabled(2)) {
            this.logger.trace(2).append("dispatch - cio: ").append(abstractCio).append(", action params: ").append(cioActionParameters).log();
        }
        this.diagService.onCioIntentExecute(abstractCio, cioActionParameters);
        abstractCio.execute(cioActionParameters);
    }
}

