/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.navsd.functions;

import de.vw.mib.bap.mqbab2.navsd.functions.CompassInfo;

public class CompassInfoNarNoNavi
extends CompassInfo {
    @Override
    protected int getBapCompassInfoAngle() {
        return this.getCarService().getCarCompassInfoAngle();
    }
}

