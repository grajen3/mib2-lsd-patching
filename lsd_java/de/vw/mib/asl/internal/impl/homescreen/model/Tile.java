/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.impl.homescreen.model;

import de.vw.mib.cio.CioIntent;

public class Tile {
    private static final String SCREEN_AREA_TILE_L;
    private static final String SCREEN_AREA_TILE_S;
    private final String usage;
    private final int usageIndex;
    private final int tileId;
    private final String screenArea;
    private CioIntent app;

    public Tile(String string, int n, int n2) {
        this.usage = string;
        this.usageIndex = n;
        this.tileId = n2;
        this.screenArea = this.getScreenArea(string, n);
    }

    public String getUsage() {
        return this.usage;
    }

    public int getUsageIndex() {
        return this.usageIndex;
    }

    public int getTileId() {
        return this.tileId;
    }

    public String getScreenArea() {
        return this.screenArea;
    }

    public CioIntent getApp() {
        return this.app;
    }

    public void setApp(CioIntent cioIntent) {
        this.app = cioIntent;
    }

    private String getScreenArea(String string, int n) {
        if ("BigTile".equals(string)) {
            return "ScreenAreaTileL";
        }
        if ("SmallTile".equals(string)) {
            int n2 = n + 1;
            return new StringBuffer().append("ScreenAreaTileS").append(n2).toString();
        }
        throw new IllegalArgumentException("Cannot create screenArea since it is not usage type");
    }

    public String toString() {
        return new StringBuffer().append("Tile [usage=").append(this.usage).append(", usageIndex=").append(this.usageIndex).append(", tileId=").append(this.tileId).append(", screenArea=").append(this.screenArea).append(", app=").append(this.app).append("]").toString();
    }
}

