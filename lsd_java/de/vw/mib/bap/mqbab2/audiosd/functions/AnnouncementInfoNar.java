/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.audiosd.functions;

import de.vw.mib.bap.mqbab2.audiosd.functions.AnnouncementInfo;

public class AnnouncementInfoNar
extends AnnouncementInfo {
    @Override
    protected String formattedFMAnnouncementFrequency(int n) {
        return this.getFixFormatter().fmtIcFrequencyNAR(n, 0, -1);
    }
}

