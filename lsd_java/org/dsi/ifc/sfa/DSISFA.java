/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.sfa;

import org.dsi.ifc.base.DSIBase;

public interface DSISFA
extends DSIBase {
    public static final String VERSION;
    public static final int ATTR_AUDIOREQUEST;
    public static final int ATTR_DISPLAYREQUEST;
    public static final int RT_AUDIOREQUESTRESULT;
    public static final int RT_DISPLAYREQUESTRESULT;
    public static final int RT_REQUESTKEYTOUCHEVALUATION;
    public static final int RT_REQUESTDISPLAYNOTVISIBLE;
    public static final int RP_RESPONSEKEYTOUCHEVALUATION;
    public static final int RP_RESPONSEDISPLAYNOTVISIBLE;

    default public void audioRequestResult(int n, int n2) {
    }

    default public void displayRequestResult(int n, int n2) {
    }

    default public void requestKeyTouchEvaluation(int n) {
    }

    default public void requestDisplayNotVisible() {
    }
}

