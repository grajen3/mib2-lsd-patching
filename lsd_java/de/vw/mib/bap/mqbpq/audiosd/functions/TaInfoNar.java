/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.audiosd.functions;

import de.vw.mib.bap.mqbpq.audiosd.functions.TaInfo;

public final class TaInfoNar
extends TaInfo {
    @Override
    protected String formattedFMAnnouncementFrequency(int n) {
        return this.getLanguageUtil().formatFrequencyNAR(n, 0, -1);
    }
}

