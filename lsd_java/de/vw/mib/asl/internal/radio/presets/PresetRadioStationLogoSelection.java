/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.presets;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.radiodata.RadioDataApi;
import de.vw.mib.genericevents.EventGeneric;

public class PresetRadioStationLogoSelection {
    public static void setUserSelectedStationLogo(EventGeneric eventGeneric) {
        try {
            RadioDataApi.setUserSelectedStationLogoSouthSide(eventGeneric);
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }
}

