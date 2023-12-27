/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.framework.reflection.util;

import de.vw.mib.asl.framework.internal.framework.dsi.util.RuntimeGeneratedConstants;

public interface Constants {
    public static final Object[] Z_ARGS = new Object[0];
    public static final String DSIPROXY_REFLECTION_PACKAGE;
    public static final String DSIPROXY_REFLECTION_CONFIG_CLASS;
    public static final String DSI_R_F_CC_ALL_FN;
    public static final int DSI_FACTORY_MCAO_CN_IDX;
    public static final int SERVICES_PS_IDS_IDX;
    public static final int SERVICES_MMAOS_IDS_IDX;
    public static final int LISTENERS_PS_IDS_IDX;
    public static final int LISTENERS_MMAOS_IDS_IDX;
    public static final int SYNC_CMP_ANALYZERS_MCAO_ID_IDX;
    public static final int SERVICE_CS_BITS;
    public static final int SERVICE_CS_FACTOR;
    public static final int SERVICE_FULL_C;
    public static final int SERVICE_REMAIN;
    public static final int SERVICE_C;
    public static final int LISTENER_CS_BITS;
    public static final int LISTENER_CS_FACTOR;
    public static final int LISTENER_FULL_C;
    public static final int LISTENER_REMAIN;
    public static final int LISTENER_C;
    public static final String M_R_F_CC_CL_NA;

    static {
        SERVICE_FULL_C = RuntimeGeneratedConstants.SERVICE_TS_NS.length >> 1;
        SERVICE_REMAIN = RuntimeGeneratedConstants.SERVICE_TS_NS.length - SERVICE_FULL_C * 2;
        SERVICE_C = SERVICE_REMAIN == 0 ? SERVICE_FULL_C : SERVICE_FULL_C + 1;
        LISTENER_FULL_C = RuntimeGeneratedConstants.LISTENER_TS_NS.length >> 1;
        LISTENER_REMAIN = RuntimeGeneratedConstants.LISTENER_TS_NS.length - LISTENER_FULL_C * 2;
        LISTENER_C = LISTENER_REMAIN == 0 ? LISTENER_FULL_C : LISTENER_FULL_C + 1;
    }
}

