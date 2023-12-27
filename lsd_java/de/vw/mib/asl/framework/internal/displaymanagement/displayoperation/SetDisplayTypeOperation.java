/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.displaymanagement.displayoperation;

import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.internal.displaymanagement.displayoperation.AbstractDsiDisplayOperation;
import de.vw.mib.asl.framework.internal.displaymanagement.displayoperation.AbstractDsiDisplayOperation$DSIDisplayManagementListenerAsyncExceptionAdapter;
import de.vw.mib.asl.framework.internal.displaymanagement.displayoperation.SetDisplayTypeOperation$1;
import de.vw.mib.display.DisplayManagementResponse;
import de.vw.mib.log4mib.Logger;

public class SetDisplayTypeOperation
extends AbstractDsiDisplayOperation {
    private static final String LOGGING_DELIM;

    public SetDisplayTypeOperation(DSIProxy dSIProxy, Logger logger) {
        super(dSIProxy, logger);
    }

    public void run(DisplayManagementResponse displayManagementResponse, int n, int n2) {
        this.storeDsiResponse(displayManagementResponse);
        this.getDsiDisplayManagement().setDisplayType(n, n2);
    }

    @Override
    protected AbstractDsiDisplayOperation$DSIDisplayManagementListenerAsyncExceptionAdapter createDSIDisplayManagementListenerAsyncExceptionAdapter() {
        return new SetDisplayTypeOperation$1(this);
    }
}

