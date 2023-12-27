/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.online;

import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.online.OperatorCallData;

public interface DSIOperatorCall
extends DSIBase {
    public static final String VERSION;
    public static final int TRANSFERTYPE_NOD;
    public static final int TRANSFERTYPE_DTMF;
    public static final int SERVICETYPE_UNKNOWN;
    public static final int SERVICETYPE_CONCIERGE;
    public static final int SERVICETYPE_OPERATOR;
    public static final int RESULTTYPE_OLDSESSION;
    public static final int RESULTTYPE_NEWSESSION;
    public static final int RESULTTYPE_CONNECTIONERROR;
    public static final int RESULTTYPE_INVALIDSESSION;
    public static final int RESULTTYPE_SERVERERROR;
    public static final int RP_RESPONSEOPERATORCALLRESULT;
    public static final int RP_RESPONSEOPERATORPHONENUMBER;
    public static final int RT_REQUESTOPERATORCALLRESULT;
    public static final int RT_REQUESTOPERATORPHONENUMBER;
    public static final int RT_SETLANGUAGE;

    default public void requestOperatorCallResult(String string, int n) {
    }

    default public void requestOperatorPhoneNumber(int n, OperatorCallData operatorCallData, boolean bl) {
    }

    default public void setLanguage(String string) {
    }
}

