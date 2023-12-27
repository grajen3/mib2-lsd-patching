/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.tvtuner.api.impl;

import de.vw.mib.asl.api.tvtuner.ASLTvtunerAPI;
import de.vw.mib.asl.internal.tvtuner.accessor.TVTunerObjectAccessor;
import org.dsi.ifc.tvtuner.ServiceInfo;

public class ASLTvtunerAPIImpl
implements ASLTvtunerAPI {
    @Override
    public int getPresetPosition(ServiceInfo serviceInfo) {
        return TVTunerObjectAccessor.getPresetListHandler().getPresetPosition(serviceInfo);
    }
}

