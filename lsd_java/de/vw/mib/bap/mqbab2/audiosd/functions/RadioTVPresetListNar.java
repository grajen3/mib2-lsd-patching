/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.audiosd.functions;

import de.vw.mib.bap.mqbab2.audiosd.functions.RadioTVPresetList;

public class RadioTVPresetListNar
extends RadioTVPresetList {
    @Override
    protected String formatFrequencyOrReturnPresetName(String string, int n, int n2, int n3) {
        String string2 = n != 0 ? this.getFixFormatter().fmtIcFrequencyNAR(n, n2, n3) : "";
        return string2;
    }
}

