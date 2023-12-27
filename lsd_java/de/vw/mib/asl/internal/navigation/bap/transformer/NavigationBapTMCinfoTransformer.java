/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.bap.transformer;

import de.vw.mib.asl.internal.navigation.bap.transformer.NavigationBapTMCinfoCollector;
import generated.de.vw.mib.asl.internal.navigation.bap.transformer.AbstractNavigationBapTMCinfoTransformer;

public class NavigationBapTMCinfoTransformer
extends AbstractNavigationBapTMCinfoTransformer {
    @Override
    public int getInt(int n, Object object) {
        int n2 = 0;
        NavigationBapTMCinfoCollector navigationBapTMCinfoCollector = (NavigationBapTMCinfoCollector)object;
        switch (n) {
            case 5: {
                n2 = navigationBapTMCinfoCollector.infoLength;
                break;
            }
            case 6: {
                n2 = navigationBapTMCinfoCollector.infoLengthUnit;
                break;
            }
            case 1: {
                n2 = navigationBapTMCinfoCollector.infoPriority;
                break;
            }
            default: {
                throw new IllegalArgumentException();
            }
        }
        return n2;
    }

    @Override
    public String getString(int n, Object object) {
        String string = null;
        NavigationBapTMCinfoCollector navigationBapTMCinfoCollector = (NavigationBapTMCinfoCollector)object;
        switch (n) {
            case 3: {
                string = navigationBapTMCinfoCollector.infoLocation;
                break;
            }
            case 2: {
                string = navigationBapTMCinfoCollector.infoStreetName;
                break;
            }
            case 4: {
                string = navigationBapTMCinfoCollector.infoText;
                break;
            }
            default: {
                throw new IllegalArgumentException();
            }
        }
        return string;
    }

    @Override
    public long getLong(int n, Object object) {
        NavigationBapTMCinfoCollector navigationBapTMCinfoCollector = (NavigationBapTMCinfoCollector)object;
        switch (n) {
            case 0: {
                return navigationBapTMCinfoCollector.infoMessageID;
            }
        }
        throw new IllegalArgumentException();
    }
}

