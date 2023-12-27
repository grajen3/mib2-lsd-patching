/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debug.service.probes.datapool;

import de.vw.mib.datapool.diag.DebugDatapool;
import de.vw.mib.debug.service.probes.datapool.DatapoolOberservHelper;
import de.vw.mib.debugmanager.probes.AbstractDebugProbe;
import de.vw.mib.debugmanager.probes.ProbeSystemServices;

public final class DatapoolProbe
extends AbstractDebugProbe {
    private DebugDatapool datapool;
    private DatapoolOberservHelper datapoolObserverHelper;
    static /* synthetic */ Class class$de$vw$mib$datapool$ModelDatapool;

    public DatapoolProbe(ProbeSystemServices probeSystemServices) {
        super(probeSystemServices);
    }

    @Override
    protected boolean deactivateProbe() {
        this.datapool.unregisterObserver(this.datapoolObserverHelper);
        return true;
    }

    @Override
    protected boolean initProbe() {
        this.datapool = (DebugDatapool)this.probeSystemServices.getService((class$de$vw$mib$datapool$ModelDatapool == null ? (class$de$vw$mib$datapool$ModelDatapool = DatapoolProbe.class$("de.vw.mib.datapool.ModelDatapool")) : class$de$vw$mib$datapool$ModelDatapool).getName());
        this.datapoolObserverHelper = new DatapoolOberservHelper(this.probeSystemServices);
        return true;
    }

    @Override
    protected boolean activateProbe() {
        this.datapool.registerObserver(this.datapoolObserverHelper);
        return true;
    }

    @Override
    protected boolean cleanUpProbe() {
        return this.deactivateProbe();
    }

    @Override
    protected boolean configureProbe() {
        this.datapoolObserverHelper.configure();
        return true;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

