/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.audiosd.functions;

import de.vw.mib.bap.datatypes.BAPString;
import de.vw.mib.bap.mqbab2.audiosd.functions.AnnouncementInfo;

public class AnnouncementInfoArabic
extends AnnouncementInfo {
    @Override
    protected String getFMAnnouncementStationName(String string, int n) {
        String string2 = super.getFMAnnouncementStationName(string, n);
        if (BAPString.isArabic(string2)) {
            string2 = super.getFMAnnouncementStationName("", n);
        }
        return string2;
    }
}

