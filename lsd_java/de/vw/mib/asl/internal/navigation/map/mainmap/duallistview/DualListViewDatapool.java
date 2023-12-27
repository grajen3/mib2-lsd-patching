/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.mainmap.duallistview;

import de.vw.mib.asl.internal.navigation.map.dsi.datapool.MapDataPool;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.DSIMapViewerControlFactoryVW;
import java.util.List;
import org.dsi.ifc.global.NavLocation;

public class DualListViewDatapool {
    private int content;
    private NavLocation cornerLowerRight;
    private NavLocation cornerUpperLeft;
    private int draggedX;
    private int draggedY;
    private List flagLocations;
    private int flagType;
    private boolean generalPOIVisibilityWasActive;
    private boolean isDragged;
    private final MapDataPool mapDataPool = DSIMapViewerControlFactoryVW.getMapDatapoolMain();
    private int selectedX;
    private int selectedY;
    private boolean showTmcMessageWasActive;

    public int getContent() {
        return this.content;
    }

    public NavLocation getCornerLowerRight() {
        return this.cornerLowerRight;
    }

    public NavLocation getCornerUpperLeft() {
        return this.cornerUpperLeft;
    }

    public int getDraggedX() {
        return this.draggedX;
    }

    public int getDraggedY() {
        return this.draggedY;
    }

    public List getFlagLocations() {
        return this.flagLocations;
    }

    public int getFlagType() {
        return this.flagType;
    }

    public int getOrientation() {
        return this.mapDataPool.getOrientation();
    }

    public int getSelectedX() {
        return this.selectedX;
    }

    public int getSelectedY() {
        return this.selectedY;
    }

    public int getViewType() {
        return this.mapDataPool.getViewType();
    }

    public boolean isDragged() {
        return this.isDragged;
    }

    public boolean isGeneralPOIVisibility() {
        return this.mapDataPool.isGeneralPOIVisibility();
    }

    public boolean isGeneralPOIVisibilityWasActive() {
        return this.generalPOIVisibilityWasActive;
    }

    public boolean isShowTmcMessages() {
        return this.mapDataPool.isShowTmcMessages();
    }

    public boolean isShowTmcMessageWasActive() {
        return this.showTmcMessageWasActive;
    }

    public void setContent(int n) {
        this.content = n;
    }

    public void setCornerLowerRight(NavLocation navLocation) {
        this.cornerLowerRight = navLocation;
    }

    public void setCornerUpperLeft(NavLocation navLocation) {
        this.cornerUpperLeft = navLocation;
    }

    public void setDragged(boolean bl) {
        this.isDragged = bl;
    }

    public void setDraggedX(int n) {
        this.draggedX = n;
    }

    public void setDraggedY(int n) {
        this.draggedY = n;
    }

    public void setFlagLocations(List list) {
        this.flagLocations = list;
    }

    public void setFlagType(int n) {
        this.flagType = n;
    }

    public void setGeneralPOIVisibilityWasActive(boolean bl) {
        this.generalPOIVisibilityWasActive = bl;
    }

    public void setSelectedX(int n) {
        this.selectedX = n;
    }

    public void setSelectedY(int n) {
        this.selectedY = n;
    }

    public void setShowTmcMessageWasActive(boolean bl) {
        this.showTmcMessageWasActive = bl;
    }
}

