/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.displaymanagement.displayoperation;

import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.internal.displaymanagement.displayoperation.AbstractDsiDisplayOperation$DSIDisplayManagementListenerAsyncExceptionAdapter;
import de.vw.mib.display.DisplayManagementResponse;
import de.vw.mib.log4mib.Logger;
import edu.emory.mathcs.backport.java.util.ArrayDeque;
import org.dsi.ifc.displaymanagement.DSIDisplayManagement;

public abstract class AbstractDsiDisplayOperation {
    private static final String LOGGING_DELIM;
    private DSIDisplayManagement dsiDisplayManagement;
    private ArrayDeque responseList = new ArrayDeque();
    private Logger logger;
    static /* synthetic */ Class class$org$dsi$ifc$displaymanagement$DSIDisplayManagement;
    static /* synthetic */ Class class$org$dsi$ifc$displaymanagement$DSIDisplayManagementListener;

    public AbstractDsiDisplayOperation(DSIProxy dSIProxy, Logger logger) {
        this.logger = logger;
        this.connectToDsi(dSIProxy);
    }

    public DSIDisplayManagement getDsiDisplayManagement() {
        return this.dsiDisplayManagement;
    }

    protected abstract AbstractDsiDisplayOperation$DSIDisplayManagementListenerAsyncExceptionAdapter createDSIDisplayManagementListenerAsyncExceptionAdapter() {
    }

    protected void storeDsiResponse(DisplayManagementResponse displayManagementResponse) {
        this.responseList.add(displayManagementResponse);
    }

    protected void reportSuccess() {
        DisplayManagementResponse displayManagementResponse = (DisplayManagementResponse)this.responseList.poll();
        if (displayManagementResponse != null) {
            displayManagementResponse.finished(1);
        }
    }

    protected Logger getLogger() {
        return this.logger;
    }

    void reportError() {
        DisplayManagementResponse displayManagementResponse = (DisplayManagementResponse)this.responseList.poll();
        if (displayManagementResponse != null) {
            displayManagementResponse.finished(0);
            this.logger.error(4096, "[AbstractDsiDisplayOparation] Invalid dsi display operation was requested");
        }
    }

    private void connectToDsi(DSIProxy dSIProxy) {
        this.dsiDisplayManagement = (DSIDisplayManagement)dSIProxy.getService(null, class$org$dsi$ifc$displaymanagement$DSIDisplayManagement == null ? (class$org$dsi$ifc$displaymanagement$DSIDisplayManagement = AbstractDsiDisplayOperation.class$("org.dsi.ifc.displaymanagement.DSIDisplayManagement")) : class$org$dsi$ifc$displaymanagement$DSIDisplayManagement);
        dSIProxy.addResponseListener(null, class$org$dsi$ifc$displaymanagement$DSIDisplayManagementListener == null ? (class$org$dsi$ifc$displaymanagement$DSIDisplayManagementListener = AbstractDsiDisplayOperation.class$("org.dsi.ifc.displaymanagement.DSIDisplayManagementListener")) : class$org$dsi$ifc$displaymanagement$DSIDisplayManagementListener, this.createDSIDisplayManagementListenerAsyncExceptionAdapter());
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

