/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.datapool.internal;

import de.vw.mib.app.framework.AppDefinition;
import de.vw.mib.datapool.AppAdapterListItemControlManager;
import de.vw.mib.datapool.internal.AppAdapterListItemControl;
import de.vw.mib.datapool.internal.InitialAppAdapterList;
import de.vw.mib.hmi.utils.Preconditions;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.log4mib.LoggerFactory;

public class AppAdapterListItemControlManagerImpl
implements AppAdapterListItemControlManager {
    private static final int LOG_SUB_CLASSIFIER;
    private final AppDefinition appDefinition;
    private final Logger logger;
    private final int[] initialSizes;
    private AppAdapterListItemControl[] listItemControls;

    public AppAdapterListItemControlManagerImpl(AppDefinition appDefinition, int[] nArray, LoggerFactory loggerFactory) {
        Preconditions.checkNotNull(appDefinition, "appDefinition");
        Preconditions.checkNotNull(nArray, "initialSizes");
        Preconditions.checkNotNull(loggerFactory, "loggerFactroy");
        this.appDefinition = appDefinition;
        this.initialSizes = nArray;
        this.listItemControls = new AppAdapterListItemControl[nArray.length];
        this.logger = loggerFactory.getLogger(8);
    }

    @Override
    public AppAdapterListItemControl getListItemControl(int n) {
        if (n >= 0 && n < this.listItemControls.length) {
            AppAdapterListItemControl appAdapterListItemControl = this.listItemControls[n];
            if (appAdapterListItemControl == null) {
                this.listItemControls[n] = appAdapterListItemControl = this.createListItemControl(n);
            }
            return appAdapterListItemControl;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(new StringBuffer().append("AppAdapterListId is invalid: ").append(n).toString());
        this.logger.error(64).append("App instance {").append(this.appDefinition.getAppInstanceName()).append("} adapter - Illegal access to app adapter list id '").append(n).append("'.").attachThrowable(illegalArgumentException).log();
        throw illegalArgumentException;
    }

    private AppAdapterListItemControl createListItemControl(int n) {
        int n2 = this.initialSizes[n];
        return new AppAdapterListItemControl(InitialAppAdapterList.defaultValues(n2));
    }
}

