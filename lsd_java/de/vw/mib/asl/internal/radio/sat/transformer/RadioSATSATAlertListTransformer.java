/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.sat.transformer;

import de.vw.mib.asl.internal.radio.sat.transformer.AlertCollector;
import generated.de.vw.mib.asl.internal.radio.sat.transformer.AbstractRadioSATSATAlertListTransformer;
import org.dsi.ifc.global.ResourceLocator;

public class RadioSATSATAlertListTransformer
extends AbstractRadioSATSATAlertListTransformer {
    @Override
    public boolean getBoolean(int n, Object object) {
        AlertCollector alertCollector = (AlertCollector)object;
        if (alertCollector == null) {
            return false;
        }
        switch (n) {
            case 9: {
                return alertCollector.isSportProgram();
            }
        }
        return false;
    }

    @Override
    public ResourceLocator getResourceLocator(int n, Object object) {
        AlertCollector alertCollector = (AlertCollector)object;
        if (alertCollector == null) {
            return new ResourceLocator();
        }
        switch (n) {
            case 3: {
                return alertCollector.getImage();
            }
        }
        return new ResourceLocator();
    }

    @Override
    public String getString(int n, Object object) {
        AlertCollector alertCollector = (AlertCollector)object;
        if (alertCollector == null) {
            return "";
        }
        switch (n) {
            case 0: {
                return alertCollector.getArtistName();
            }
            case 1: {
                return alertCollector.getChannelName();
            }
            case 2: {
                return Integer.toString(alertCollector.getChannelNumber());
            }
            case 4: {
                return alertCollector.getTeamAScore();
            }
            case 5: {
                return alertCollector.getTeamBScore();
            }
            case 6: {
                return alertCollector.getSongName();
            }
            case 7: {
                return alertCollector.getTeamAName();
            }
            case 8: {
                return alertCollector.getTeamBName();
            }
        }
        return "";
    }
}

