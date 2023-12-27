/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.displaymanagement.displayoperation;

import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.internal.displaymanagement.displayoperation.AbstractDsiDisplayOperation;
import de.vw.mib.asl.framework.internal.displaymanagement.displayoperation.AbstractDsiDisplayOperation$DSIDisplayManagementListenerAsyncExceptionAdapter;
import de.vw.mib.asl.framework.internal.displaymanagement.displayoperation.SetUpdateRateOpertation$1;
import de.vw.mib.display.DisplayManagementResponse;
import de.vw.mib.log4mib.Logger;

public class SetUpdateRateOpertation
extends AbstractDsiDisplayOperation {
    private static final String LOGGING_DELIM;

    public SetUpdateRateOpertation(DSIProxy dSIProxy, Logger logger) {
        super(dSIProxy, logger);
    }

    public void run(DisplayManagementResponse displayManagementResponse, int n, int n2) {
        this.storeDsiResponse(displayManagementResponse);
        this.getDsiDisplayManagement().setUpdateRate(n, n2);
    }

    @Override
    protected AbstractDsiDisplayOperation$DSIDisplayManagementListenerAsyncExceptionAdapter createDSIDisplayManagementListenerAsyncExceptionAdapter() {
        return new SetUpdateRateOpertation$1(this);
    }
}

