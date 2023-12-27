/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.ocu.control;

import de.vw.mib.asl.api.system.powerstate.ClampSignalAdapter;
import de.vw.mib.asl.internal.online.ocu.OCUUpdateServiceFactory;
import de.vw.mib.asl.internal.online.ocu.states.OCUUpdateServiceTarget;

public class OCUUpdateServiceClampSignal
extends ClampSignalAdapter {
    private final OCUUpdateServiceTarget _target;

    public OCUUpdateServiceClampSignal(OCUUpdateServiceTarget oCUUpdateServiceTarget) {
        this._target = oCUUpdateServiceTarget;
    }

    @Override
    public void onClamp15ValueChanged(boolean bl) {
        OCUUpdateServiceFactory.getController(this._target).onClampStatus(bl);
    }
}

