/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.audiosd.functions;

import de.vw.mib.bap.mqbpq.audiosd.functions.InfoListType;

public final class InfoListTypeNar
extends InfoListType {
    @Override
    protected int getBapInfoListType() {
        int n;
        switch (this.getArrowKeyScopeMode()) {
            case 0: {
                n = 2;
                break;
            }
            case 1: {
                n = 3;
                break;
            }
            default: {
                n = 255;
            }
        }
        return n;
    }
}

