/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.selectiontiles.transformer;

import de.vw.mib.asl.api.homescreen.ASLHomeScreenFactory;
import de.vw.mib.asl.api.homescreen.tileselection.TileSelectionListItemTransformer;
import generated.de.vw.mib.asl.internal.selectiontiles.transformer.AbstractSelectionTileSAppListTransformer;

public class SelectionTileSAppListTransformer
extends AbstractSelectionTileSAppListTransformer {
    @Override
    public boolean getBoolean(int n, Object object) {
        return this.getTransformer().isAppActive(object);
    }

    @Override
    public long getLong(int n, Object object) {
        return this.getTransformer().getTileAppIntent(object);
    }

    private TileSelectionListItemTransformer getTransformer() {
        return ASLHomeScreenFactory.getHomeScreenApi().getTileSelectionAppService().getTransformer();
    }
}

