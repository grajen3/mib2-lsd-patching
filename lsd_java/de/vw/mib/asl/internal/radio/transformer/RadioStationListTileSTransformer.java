/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.transformer;

import de.vw.mib.asl.internal.list.ItemTransformer;
import de.vw.mib.asl.internal.radio.transformer.TileListCollector;
import generated.de.vw.mib.asl.internal.radio.transformer.AbstractRadioStationListTileSTransformer;
import org.dsi.ifc.global.ResourceLocator;

public class RadioStationListTileSTransformer
extends AbstractRadioStationListTileSTransformer
implements ItemTransformer {
    @Override
    public String getString(int n, Object object) {
        switch (n) {
            case 0: {
                return ((TileListCollector)object).stationName;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public ResourceLocator getResourceLocator(int n, Object object) {
        switch (n) {
            case 1: {
                return ((TileListCollector)object).stationLogo;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public int getInt(int n, Object object) {
        switch (n) {
            case 3: {
                return ((TileListCollector)object).listIndex;
            }
        }
        throw new IllegalArgumentException();
    }
}

