/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.navsd.functions;

import de.vw.mib.bap.mqbpq.navsd.functions.CompassInfo;

public final class CompassInfoNarNoNavi
extends CompassInfo {
    @Override
    protected int getBapCompassInfoAngle() {
        return this.getCarCompassInfoAngle();
    }
}

