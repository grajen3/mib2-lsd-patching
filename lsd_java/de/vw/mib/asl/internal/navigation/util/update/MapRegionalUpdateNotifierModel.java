/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.util.update;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;

public class MapRegionalUpdateNotifierModel {
    private final IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[MapRegionalUpdateNotifierModel]");

    MapRegionalUpdateNotifierModel() {
    }

    public void showProgressIndicatorInDatabaseInfo(boolean bl) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("showProgressIndicator(").append(bl).append(")").log();
        }
        if (bl) {
            ServiceManager.aslPropertyManager.valueChangedInteger(-1141895168, 1);
        } else {
            ServiceManager.aslPropertyManager.valueChangedInteger(-1141895168, 0);
        }
    }

    public void updateProgressInDatabaseInfo(int n) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("updateProgress(").append(n).append(")").log();
        }
        ServiceManager.aslPropertyManager.valueChangedInteger(-1125117952, n);
    }
}

