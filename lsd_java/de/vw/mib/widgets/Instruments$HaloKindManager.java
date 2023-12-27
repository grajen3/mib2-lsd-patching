/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.widgets.Instruments;
import de.vw.mib.widgets.Instruments$HaloKind;
import de.vw.mib.widgets.Instruments$HaloKindFreePositioning;
import de.vw.mib.widgets.Instruments$HaloKindImageMapping;

final class Instruments$HaloKindManager {
    private Instruments$HaloKindManager() {
    }

    public static Instruments$HaloKind createHaloKind(Instruments instruments) {
        switch (instruments.get_mode()) {
            case 2: {
                return new Instruments$HaloKindFreePositioning(instruments);
            }
            case 1: {
                return new Instruments$HaloKindImageMapping(instruments);
            }
        }
        return null;
    }
}

