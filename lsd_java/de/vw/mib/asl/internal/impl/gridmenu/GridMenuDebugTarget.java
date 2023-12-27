/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.impl.gridmenu;

import de.vw.mib.asl.api.system.ASLSystemAPI;
import de.vw.mib.asl.internal.gridmenu.api.impl.GridMenuServices;
import de.vw.mib.asl.internal.impl.gridmenu.AbstractGridMenuTarget;
import de.vw.mib.configuration.ConfigurationManagerDiag;
import de.vw.mib.debug.screenshot.ScreenshotProvider;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.ServiceRegister;

public class GridMenuDebugTarget
extends AbstractGridMenuTarget {
    private final ConfigurationManagerDiag configurationManager;
    private final ASLSystemAPI systemApi;
    private final GridMenuServices gridMenuServices;

    public GridMenuDebugTarget(GridMenuServices gridMenuServices) {
        super(gridMenuServices.getGenericEvents(), gridMenuServices.getLogger(), -731571712);
        this.configurationManager = gridMenuServices.getConfigurationManager();
        this.systemApi = gridMenuServices.getSystemAPI();
        this.gridMenuServices = gridMenuServices;
        this.registerObservers(gridMenuServices.getServiceRegister());
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 1078541825: {
                this.takeScreenshot();
                break;
            }
            case 1078541824: {
                this.resetInfotainmentRecorder();
                break;
            }
        }
    }

    private void resetInfotainmentRecorder() {
        if (this.isTestmodeEnabled()) {
            this.systemApi.createAndSubmitHardkeyEvent(6, 3);
        }
    }

    private void takeScreenshot() {
        if (this.isTestmodeEnabled()) {
            ScreenshotProvider screenshotProvider = this.gridMenuServices.getScreenshotProvider();
            screenshotProvider.takeScreenshot();
        }
    }

    private boolean isTestmodeEnabled() {
        return this.configurationManager.isFeatureFlagSet(400);
    }

    private void registerObservers(ServiceRegister serviceRegister) {
        serviceRegister.addObserver(20859200, this.getTargetId());
        serviceRegister.addObserver(4081984, this.getTargetId());
    }
}

