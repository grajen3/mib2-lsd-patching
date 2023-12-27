/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.asl.service;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.internal.navigation.map.asl.service.ASLNavigationServiceMainMapTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.HsmState;
import de.vw.mib.util.StringBuilder;

public class ASLNavigationServiceMainMapStateInit
extends AbstractHsmState {
    private final ASLNavigationServiceMainMapTarget target;
    private final IExtLogger LOGGER;

    public ASLNavigationServiceMainMapStateInit(ASLNavigationServiceMainMapTarget aSLNavigationServiceMainMapTarget, String string, HsmState hsmState) {
        super(aSLNavigationServiceMainMapTarget.getHsm(), string, hsmState);
        String string2 = new StringBuilder("[ASLNavigationServiceMainMapStateInit-").append(aSLNavigationServiceMainMapTarget.targetId).append("]").toString();
        this.LOGGER = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, string2);
        this.target = aSLNavigationServiceMainMapTarget;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                this.handleEntry();
                break;
            }
            case 4: {
                break;
            }
            case 3: {
                this.handleStart();
                break;
            }
            default: {
                this.handleDefault(eventGeneric);
                return this.myParent;
            }
        }
        return null;
    }

    private void handleEntry() {
        this.LOGGER.trace("handleEntry()");
        this.target.initTarget();
    }

    private void handleStart() {
        this.LOGGER.trace("handleStart()");
        this.target.transStateWork();
    }

    private void handleDefault(EventGeneric eventGeneric) {
        if (this.LOGGER.isTraceEnabled()) {
            this.LOGGER.makeTrace().append("handleDefault(), event=").append(eventGeneric.toString()).log();
        }
    }
}

