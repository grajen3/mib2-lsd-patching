/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.testmode.servicemode;

import de.vw.mib.asl.api.infotainmentrecorder.InfotainmentRecorderService;
import de.vw.mib.asl.internal.impl.testmode.TestModeServicesProvider;
import de.vw.mib.asl.internal.testmode.AbstractTestModeTarget;
import de.vw.mib.asl.internal.testmode.TestModeServices;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.ServiceRegister;

public class ServiceModeTarget
extends AbstractTestModeTarget {
    private final InfotainmentRecorderService infotainmentRecorderService;
    private final ServiceRegister serviceRegister;

    public ServiceModeTarget(GenericEvents genericEvents, String string) {
        super(genericEvents, TestModeServicesProvider.getTestModeServices().getLogger(), -204401408);
        TestModeServices testModeServices = TestModeServicesProvider.getTestModeServices();
        this.infotainmentRecorderService = testModeServices.getInfotainmentRecorderService();
        this.serviceRegister = testModeServices.getServiceRegister();
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 106: {
                this.registerObserver();
                break;
            }
            case 1075441829: {
                this.backupInfotainmentRecorder();
                break;
            }
        }
    }

    private void backupInfotainmentRecorder() {
        this.infotainmentRecorderService.backupInfotainmentRecorder();
    }

    private void registerObserver() {
        this.serviceRegister.addObserver(-1510991552, this.getTargetId());
    }
}

