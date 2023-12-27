/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.amfm.radiotext;

import de.vw.mib.asl.internal.radio.amfm.radiotext.Radiotext;
import de.vw.mib.asl.internal.radio.amfm.radiotext.RadiotextTarget;
import de.vw.mib.genericevents.GenericEvents;

public final class RadiotextFactory {
    private static Radiotext radioText;

    private RadiotextFactory() {
    }

    public static void createInstance(GenericEvents genericEvents) {
        if (radioText == null) {
            radioText = new RadiotextTarget(genericEvents);
        }
    }

    public static Radiotext getRadioTextInstance() {
        return radioText;
    }
}

