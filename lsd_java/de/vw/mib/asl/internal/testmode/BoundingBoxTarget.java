/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.testmode;

import de.vw.mib.asl.ASLPropertyManager;
import de.vw.mib.asl.internal.testmode.AbstractTestModeTarget;
import de.vw.mib.asl.internal.testmode.TestModeServices;
import de.vw.mib.desktop.DesktopManager;
import de.vw.mib.genericevents.EventGeneric;

public class BoundingBoxTarget
extends AbstractTestModeTarget {
    private TestModeServices services;
    private ASLPropertyManager propertyManager;
    private DesktopManager desktopManager;

    public BoundingBoxTarget(TestModeServices testModeServices) {
        super(testModeServices.getGenericEvents(), testModeServices.getLogger(), -187624192);
        this.services = testModeServices;
        this.propertyManager = testModeServices.getAslPropertyManager();
        this.desktopManager = testModeServices.getDesktopManager();
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 1075941832: {
                this.setBoundingBoxEnabled(!this.desktopManager.isShowBoundingBoxesEnabled());
                break;
            }
        }
    }

    public void run() {
        this.registerBoundingBoxListener();
        this.updateBoundingBox(this.desktopManager.isShowBoundingBoxesEnabled());
    }

    private void updateBoundingBox(boolean bl) {
        this.propertyManager.valueChangedBoolean(-558358272, bl);
    }

    private void setBoundingBoxEnabled(boolean bl) {
        this.desktopManager.setShowBoundingBoxesEnabled(bl);
        this.updateBoundingBox(bl);
    }

    private void registerBoundingBoxListener() {
        this.services.getServiceRegister().addObserver(-930012864, this.getTargetId());
    }
}

