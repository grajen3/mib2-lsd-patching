/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.impl.homescreen.tileselection;

import de.vw.mib.asl.internal.impl.homescreen.tileselection.TileSelectionServiceImpl;

class TileSelectionServiceImpl$1
implements Runnable {
    private final /* synthetic */ TileSelectionServiceImpl this$0;

    TileSelectionServiceImpl$1(TileSelectionServiceImpl tileSelectionServiceImpl) {
        this.this$0 = tileSelectionServiceImpl;
    }

    @Override
    public void run() {
        this.this$0.installCurrentlySelectedTile();
    }
}

