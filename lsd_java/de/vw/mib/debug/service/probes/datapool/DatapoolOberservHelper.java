/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debug.service.probes.datapool;

import de.vw.mib.datapool.diag.DatapoolValueConverter;
import de.vw.mib.datapool.diag.DebugDatapoolObserver;
import de.vw.mib.debug.common.probes.datapool.DatapoolProbeConfiguration;
import de.vw.mib.debug.service.probes.datapool.DatapoolCodec;
import de.vw.mib.debugmanager.probes.ProbeSystemServices;

public class DatapoolOberservHelper
implements DebugDatapoolObserver {
    private ProbeSystemServices probeSystemServices;
    private boolean[] logEnabled;
    private boolean[] logWithValue;

    public DatapoolOberservHelper(ProbeSystemServices probeSystemServices) {
        this.probeSystemServices = probeSystemServices;
        this.logEnabled = new boolean[3];
        this.logWithValue = new boolean[3];
    }

    public void configure() {
        DatapoolProbeConfiguration datapoolProbeConfiguration = (DatapoolProbeConfiguration)this.probeSystemServices.getConfiguration();
        this.logEnabled[0] = datapoolProbeConfiguration.isLogChangeRequestsEnabled();
        this.logEnabled[1] = datapoolProbeConfiguration.isLogValueChangedEnabled();
        this.logEnabled[2] = datapoolProbeConfiguration.isLogValueChangedEnabled();
        this.logWithValue[0] = datapoolProbeConfiguration.isLogChangeRequestsWithValueAsStringEnabled();
        this.logWithValue[1] = datapoolProbeConfiguration.isLogValueChangedWithValueAsStringEnabled();
        this.logWithValue[2] = datapoolProbeConfiguration.isLogValueChangedWithValueAsStringEnabled();
    }

    @Override
    public void datapoolUpdate(byte by, int n, boolean bl) {
        if (!this.logEnabled[by]) {
            return;
        }
        if (this.logWithValue[by]) {
            DatapoolCodec datapoolCodec = (DatapoolCodec)this.probeSystemServices.borrowCodec();
            datapoolCodec.encodeDatapoolUpdate(by, n, DatapoolValueConverter.asValueString(bl));
            this.probeSystemServices.releaseCodec(datapoolCodec);
        } else {
            DatapoolCodec datapoolCodec = (DatapoolCodec)this.probeSystemServices.borrowCodec();
            datapoolCodec.encodeDatapoolUpdate(by, n);
            this.probeSystemServices.releaseCodec(datapoolCodec);
        }
    }

    @Override
    public void datapoolUpdate(byte by, int n, float f2) {
        if (!this.logEnabled[by]) {
            return;
        }
        if (this.logWithValue[by]) {
            DatapoolCodec datapoolCodec = (DatapoolCodec)this.probeSystemServices.borrowCodec();
            datapoolCodec.encodeDatapoolUpdate(by, n, DatapoolValueConverter.asValueString(f2));
            this.probeSystemServices.releaseCodec(datapoolCodec);
        } else {
            DatapoolCodec datapoolCodec = (DatapoolCodec)this.probeSystemServices.borrowCodec();
            datapoolCodec.encodeDatapoolUpdate(by, n);
            this.probeSystemServices.releaseCodec(datapoolCodec);
        }
    }

    @Override
    public void datapoolUpdate(byte by, int n, int n2) {
        if (!this.logEnabled[by]) {
            return;
        }
        if (this.logWithValue[by]) {
            DatapoolCodec datapoolCodec = (DatapoolCodec)this.probeSystemServices.borrowCodec();
            datapoolCodec.encodeDatapoolUpdate(by, n, DatapoolValueConverter.asValueString(n2));
            this.probeSystemServices.releaseCodec(datapoolCodec);
        } else {
            DatapoolCodec datapoolCodec = (DatapoolCodec)this.probeSystemServices.borrowCodec();
            datapoolCodec.encodeDatapoolUpdate(by, n);
            this.probeSystemServices.releaseCodec(datapoolCodec);
        }
    }

    @Override
    public void datapoolUpdate(byte by, int n, long l) {
        if (!this.logEnabled[by]) {
            return;
        }
        if (this.logWithValue[by]) {
            DatapoolCodec datapoolCodec = (DatapoolCodec)this.probeSystemServices.borrowCodec();
            datapoolCodec.encodeDatapoolUpdate(by, n, DatapoolValueConverter.asValueString(l));
            this.probeSystemServices.releaseCodec(datapoolCodec);
        } else {
            DatapoolCodec datapoolCodec = (DatapoolCodec)this.probeSystemServices.borrowCodec();
            datapoolCodec.encodeDatapoolUpdate(by, n);
            this.probeSystemServices.releaseCodec(datapoolCodec);
        }
    }

    @Override
    public void datapoolUpdate(byte by, int n, Object object) {
        if (!this.logEnabled[by]) {
            return;
        }
        if (this.logWithValue[by]) {
            DatapoolCodec datapoolCodec = (DatapoolCodec)this.probeSystemServices.borrowCodec();
            datapoolCodec.encodeDatapoolUpdate(by, n, DatapoolValueConverter.asValueString(object));
            this.probeSystemServices.releaseCodec(datapoolCodec);
        } else {
            DatapoolCodec datapoolCodec = (DatapoolCodec)this.probeSystemServices.borrowCodec();
            datapoolCodec.encodeDatapoolUpdate(by, n);
            this.probeSystemServices.releaseCodec(datapoolCodec);
        }
    }
}

