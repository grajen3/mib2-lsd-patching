/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.diag;

import de.esolutions.fw.dsi.admin.DSIAdmin;
import de.esolutions.fw.dsi.config.AdapterConfig;
import de.esolutions.fw.dsi.diag.AdapterSnapshot;
import de.esolutions.fw.dsi.diag.DSIAdapterErrorLog;
import de.esolutions.fw.dsi.diag.IAdapterDiagnosis;
import de.esolutions.fw.dsi.diag.IAdapterErrorLog;
import de.esolutions.fw.dsi.diag.IAdapterSnapshot;

public class AdapterDiagnosis
implements IAdapterDiagnosis {
    private DSIAdmin admin;
    private IAdapterErrorLog errorLog;

    public AdapterDiagnosis(DSIAdmin dSIAdmin) {
        int n = AdapterConfig.getInstance().errorLogSize();
        this.errorLog = new DSIAdapterErrorLog(n);
        this.admin = dSIAdmin;
    }

    public AdapterDiagnosis(DSIAdmin dSIAdmin, IAdapterErrorLog iAdapterErrorLog) {
        this.admin = dSIAdmin;
        this.errorLog = iAdapterErrorLog;
    }

    @Override
    public IAdapterSnapshot createSnapshot() {
        AdapterSnapshot adapterSnapshot = new AdapterSnapshot(this.admin);
        return adapterSnapshot;
    }

    @Override
    public IAdapterErrorLog getErrorLog() {
        return this.errorLog;
    }
}

