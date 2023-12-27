/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.ocu.control;

import de.vw.mib.asl.api.system.factoryreset.AbstractFactoryResetParticipant;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetCallback;
import de.vw.mib.asl.internal.online.ocu.OCUUpdateServiceFactory;
import de.vw.mib.asl.internal.online.ocu.states.OCUUpdateServiceTarget;

public class OCUUpdateServiceResetFactorySettings
extends AbstractFactoryResetParticipant {
    private final OCUUpdateServiceTarget _target;

    public OCUUpdateServiceResetFactorySettings(OCUUpdateServiceTarget oCUUpdateServiceTarget) {
        this._target = oCUUpdateServiceTarget;
    }

    @Override
    public void reset(FactoryResetCallback factoryResetCallback, int n) {
        if (factoryResetCallback != null) {
            OCUUpdateServiceFactory.getController(this._target).onResetFactorySettings();
            factoryResetCallback.notifyResetDone();
        }
    }
}

