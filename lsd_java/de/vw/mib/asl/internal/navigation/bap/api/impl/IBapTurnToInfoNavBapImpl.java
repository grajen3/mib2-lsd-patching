/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.bap.api.impl;

import de.vw.mib.asl.api.navbap.IBapTurnToInfoNavBap;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import org.dsi.ifc.navigation.BapTurnToInfo;

public class IBapTurnToInfoNavBapImpl
implements IBapTurnToInfoNavBap {
    private String signPost;
    private String turnToInfo;

    public IBapTurnToInfoNavBapImpl(BapTurnToInfo bapTurnToInfo) {
        if (bapTurnToInfo != null) {
            this.signPost = bapTurnToInfo.getSignPost();
            this.turnToInfo = bapTurnToInfo.getTurnToInfo();
        } else {
            ServiceManager.logger.error(16384, "[IBapTurnToInfoNavBapImpl] bapTurnToInfo was null");
        }
    }

    @Override
    public String getSignPost() {
        return this.signPost;
    }

    @Override
    public String getTurnToInfo() {
        return this.turnToInfo;
    }
}

