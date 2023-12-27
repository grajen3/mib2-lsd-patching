/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.testmode;

import de.vw.mib.asl.ASLPropertyManager;
import de.vw.mib.asl.internal.testmode.AbstractTestModeTarget;
import de.vw.mib.asl.internal.testmode.TestModeServices;
import de.vw.mib.desktop.DesktopManager;
import de.vw.mib.genericevents.EventGeneric;

public class RenderInfoTarget
extends AbstractTestModeTarget {
    private TestModeServices services;
    private ASLPropertyManager propertyManager;
    private DesktopManager desktopManager;

    public RenderInfoTarget(TestModeServices testModeServices) {
        super(testModeServices.getGenericEvents(), testModeServices.getLogger(), -170846976);
        this.services = testModeServices;
        this.propertyManager = testModeServices.getAslPropertyManager();
        this.desktopManager = testModeServices.getDesktopManager();
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 1075941831: {
                this.setRenderInfoEnabled(!this.desktopManager.isShowDebugOverlayEnabled());
                break;
            }
        }
    }

    public void run() {
        this.registerRenderInfoListener();
        this.updateRenderInfo(this.desktopManager.isShowDebugOverlayEnabled());
    }

    private void updateRenderInfo(boolean bl) {
        this.propertyManager.valueChangedBoolean(-575135488, bl);
    }

    private void setRenderInfoEnabled(boolean bl) {
        this.desktopManager.setShowDebugOverlayEnabled(bl);
        this.updateRenderInfo(bl);
    }

    private void registerRenderInfoListener() {
        this.services.getServiceRegister().addObserver(-946790080, this.getTargetId());
    }
}

