/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.homescreen.tileselection;

import de.vw.mib.asl.api.homescreen.tileselection.TileSelectionAppDescription;
import de.vw.mib.asl.api.homescreen.tileselection.TileSelectionListItemTransformer;

public interface TileSelectionAppService {
    default public void registerTileSelectionApp(TileSelectionAppDescription tileSelectionAppDescription) {
    }

    default public TileSelectionListItemTransformer getTransformer() {
    }
}

