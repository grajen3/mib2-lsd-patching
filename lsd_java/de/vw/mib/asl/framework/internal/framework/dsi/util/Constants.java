/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.framework.dsi.util;

import de.vw.mib.collections.ints.IntObjectMap;
import de.vw.mib.reflection.pool.ObjArrayPool;
import de.vw.mib.reflection.pool.SynchronizedObjArrayPool;
import org.dsi.ifc.base.DSIListener;

public interface Constants {
    public static final int UNDEFINED_TARGET_ID;
    public static final int ALL_TARGETS_ID;
    public static final int NOT_SET;
    public static final String C_CC_CL_PACKAGE;
    public static final String C_CC_CL_NA;
    public static final String C_CC_ALL_FN;
    public static final int INST_DEP_OBJ_S_P_IDX;
    public static final int LISTENERS_ASYNC_EXC_MS_IDS_IDX;
    public static final Class[] Z_PTS;
    public static final Object[] Z_ARGS;
    public static final String P_T_CC_CL_PACKAGE;
    public static final String P_T_CC_CL_NA;
    public static final String P_T_CC_ALL_FN;
    public static final int SERVICES_NOTIF_ATTRS_IDX;
    public static final int LISTENERS_NOTIF_MS_IDS_IDX;
    public static final int LISTENERS_NON_VALIDATE_NOTIF_MS_IDS_IDX;
    public static final int LISTENERS_NON_DISCARDABLE_NOTIF_MS_IDS_IDX;
    public static final int LISTENERS_INDIC_MS_IDS_IDX;
    public static final int SERVICES_SYNC_MS_IDS_IDX;
    public static final int LISTENERS_SYNC_MS_IDS_IDX;
    public static final int SYNC_CMP_ANALYZERS_CS_IDS_IDX;
    public static final int SERVICES_ASYNC_EXC_RTS_IDX;
    public static final int SERVICES_SYNC_REQ_TIMEOUTS_IDX;
    public static final int SERVICES_SYNC_REQUEST_TYPES_IDX;
    public static final int SERVICES_TYPES_IDX;
    public static final int DSI_RT_OFFSET;
    public static final int DEFAULT_REQUEST_TIMEOUT;
    public static final int FACTOR_REQUEST_TIMEOUT;
    public static final byte REQUEST_TYPE_UNKNOWN;
    public static final byte REQUEST_TYPE_NON_SYNC;
    public static final byte REQUEST_TYPE_SIMPLE;
    public static final byte REQUEST_TYPE_SEQUENCE;
    public static final byte REQUEST_TYPE_CHOICE;
    public static final byte REQUEST_TYPE_COMPLEX;
    public static final int SERVICE_REQUEST_INDEX_SHIFT;
    public static final int SERVICE_REQUEST_INDEX_MASK;
    public static final byte SERVICE_TYPE_UNSET;
    public static final byte SERVICE_TYPE_UNKNOWN;
    public static final byte SERVICE_TYPE_NON_SYNC;
    public static final byte SERVICE_TYPE_SIMPLE;
    public static final byte SERVICE_TYPE_SEQUENCE;
    public static final byte SERVICE_TYPE_CHOICE;
    public static final byte SERVICE_TYPE_COMPLEX;
    public static final byte SERVICE_TYPE_MULTIPLE;
    public static final String U_CC_CL_PACKAGE;
    public static final String U_CC_CL_NA;
    public static final String U_CC_ALL_FN;
    public static final int SERVICES_SYNC_MS_NS_IDX;
    public static final int LISTENERS_SYNC_MS_NS_IDX;
    public static final int D_IPS_IDX;
    public static final ObjArrayPool PROXY_OAP;
    public static final IntObjectMap[] PROXY_PENDIG_CS;
    public static final DSIListener[] NOTIF_LISTENER_SKELETON_MX;
    public static final DSIListener[] RES_LISTENER_SKELETON_MX;

    static {
        Z_PTS = new Class[0];
        Z_ARGS = new Object[0];
        PROXY_OAP = new SynchronizedObjArrayPool(0);
        PROXY_PENDIG_CS = new IntObjectMap[176];
        NOTIF_LISTENER_SKELETON_MX = new DSIListener[176];
        RES_LISTENER_SKELETON_MX = new DSIListener[176];
    }
}

