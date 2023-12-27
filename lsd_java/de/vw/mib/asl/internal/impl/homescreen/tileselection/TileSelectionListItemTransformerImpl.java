/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.impl.homescreen.tileselection;

import de.vw.mib.asl.api.homescreen.tileselection.TileSelectionListItemTransformer;
import de.vw.mib.asl.internal.impl.homescreen.tileselection.TileAppDescriptor;
import de.vw.mib.cio.CioIntent;

public class TileSelectionListItemTransformerImpl
implements TileSelectionListItemTransformer {
    @Override
    public long getTileAppIntent(Object object) {
        TileAppDescriptor tileAppDescriptor = this.retrieveTileAppDescriptor(object);
        CioIntent cioIntent = tileAppDescriptor.getTileApp();
        return cioIntent.getCioIntentId();
    }

    @Override
    public boolean isAppActive(Object object) {
        TileAppDescriptor tileAppDescriptor = this.retrieveTileAppDescriptor(object);
        return tileAppDescriptor.isSelected();
    }

    private TileAppDescriptor retrieveTileAppDescriptor(Object object) {
        if (!(object instanceof TileAppDescriptor)) {
            throw new IllegalArgumentException("The given input is now valid row item.");
        }
        return (TileAppDescriptor)object;
    }
}

