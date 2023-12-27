/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.diag;

import de.esolutions.fw.dsi.diag.IAdapterErrorLog;
import de.esolutions.fw.dsi.diag.IAdapterSnapshot;

public interface IAdapterDiagnosis {
    default public IAdapterSnapshot createSnapshot() {
    }

    default public IAdapterErrorLog getErrorLog() {
    }
}

