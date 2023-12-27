/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.configuration.internal;

import de.vw.mib.app.framework.assembly.ScreenAreaData;

final class ScreenAreaDataImpl
implements ScreenAreaData {
    private final String name;
    private final String type;
    private final int eventPrioRank;
    private final String[] popupGroups;
    private final boolean isDriverDistractionPreventionRelevant;
    private ScreenAreaData coveredScreenArea;

    ScreenAreaDataImpl(String string, String string2, int n, String[] stringArray, boolean bl) {
        this.name = string;
        this.type = string2;
        this.eventPrioRank = n;
        this.popupGroups = stringArray;
        this.isDriverDistractionPreventionRelevant = bl;
    }

    @Override
    public ScreenAreaData getCoveredScreenArea() {
        return this.coveredScreenArea;
    }

    @Override
    public int getEventPrioRank() {
        return this.eventPrioRank;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String[] getPopupGroups() {
        return this.popupGroups;
    }

    @Override
    public String getType() {
        return this.type;
    }

    @Override
    public boolean isDriverDistractionPreventionRelevant() {
        return this.isDriverDistractionPreventionRelevant;
    }

    @Override
    public boolean isPopupScreenArea() {
        return "Popup".equals(this.type);
    }

    void setCoveredScreenArea(ScreenAreaData screenAreaData) {
        this.coveredScreenArea = screenAreaData;
    }
}

