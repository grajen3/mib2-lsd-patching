/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.sat.transformer;

import generated.de.vw.mib.asl.internal.radio.sat.transformer.AbstractRadioSATManageAlertsListTransformer;
import org.dsi.ifc.sdars.SeekEntry;

public class RadioSATManageAlertsListTransformer
extends AbstractRadioSATManageAlertsListTransformer {
    @Override
    public String getString(int n, Object object) {
        SeekEntry seekEntry = (SeekEntry)object;
        if (seekEntry == null) {
            return "";
        }
        switch (n) {
            case 0: {
                return seekEntry.getTitle1();
            }
            case 1: {
                return seekEntry.getTitle2();
            }
        }
        return "";
    }

    @Override
    public boolean getBoolean(int n, Object object) {
        SeekEntry seekEntry = (SeekEntry)object;
        if (seekEntry == null) {
            return false;
        }
        switch (n) {
            case 2: {
                boolean bl = true;
                if ("".equals(seekEntry.getTitle2())) {
                    bl = false;
                }
                return bl;
            }
        }
        return false;
    }
}

