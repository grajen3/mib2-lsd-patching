/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.splitscreen;

import de.vw.mib.asl.api.navigation.IOverlayData;
import org.dsi.ifc.global.ResourceLocator;

public class OverlayData
implements IOverlayData {
    String name = "";
    String exitNumber = "";
    boolean exitNumberVisibility = false;
    int distanceToManeuver = 0;
    ResourceLocator colorIndicatorIcon = null;
    int[] laneDirections = new int[0];
    int[] laneInfos = new int[0];
    int[] laneMarkingsLeft = new int[0];
    int[] laneMarkingsRight = new int[0];
    int laneNumber = 0;
    boolean laneGuidanceAvailable = false;
    ResourceLocator headlineIcon = null;
    boolean headlineIconVisibility = false;
    String signPostInfo = "";

    @Override
    public String getName() {
        return this.name;
    }

    public void setName(String string) {
        this.name = string;
    }

    @Override
    public String getExitNumber() {
        return this.exitNumber;
    }

    public void setExitNumber(String string) {
        this.exitNumber = string;
    }

    @Override
    public boolean getExitNumberVisibility() {
        return this.exitNumberVisibility;
    }

    public void setExitNumberVisibility(boolean bl) {
        this.exitNumberVisibility = bl;
    }

    @Override
    public int getDistanceToManeuver() {
        return this.distanceToManeuver;
    }

    public void setDistanceToManeuver(int n) {
        this.distanceToManeuver = n;
    }

    @Override
    public ResourceLocator getColorIndicatorIcon() {
        return this.colorIndicatorIcon;
    }

    public void setColorIndicatorIcon(ResourceLocator resourceLocator) {
        this.colorIndicatorIcon = resourceLocator;
    }

    @Override
    public int[] getLaneDirections() {
        return this.laneDirections;
    }

    public void setLaneDirections(int[] nArray) {
        this.laneDirections = nArray;
    }

    @Override
    public int[] getLaneInfos() {
        return this.laneInfos;
    }

    public void setLaneInfos(int[] nArray) {
        this.laneInfos = nArray;
    }

    @Override
    public int[] getLaneMarkingsLeft() {
        return this.laneMarkingsLeft;
    }

    public void setLaneMarkingsLeft(int[] nArray) {
        this.laneMarkingsLeft = nArray;
    }

    @Override
    public int[] getLaneMarkingsRight() {
        return this.laneMarkingsRight;
    }

    public void setLaneMarkingsRight(int[] nArray) {
        this.laneMarkingsRight = nArray;
    }

    @Override
    public int getLaneNumber() {
        return this.laneNumber;
    }

    public void setLaneNumber(int n) {
        this.laneNumber = n;
    }

    @Override
    public boolean getLaneGuidanceAvailable() {
        return this.laneGuidanceAvailable;
    }

    public void setLaneGuidanceAvailable(boolean bl) {
        this.laneGuidanceAvailable = bl;
    }

    @Override
    public ResourceLocator getHeadlineIcon() {
        return this.headlineIcon;
    }

    public void setHeadlineIcon(ResourceLocator resourceLocator) {
        this.headlineIcon = resourceLocator;
    }

    @Override
    public boolean getHeadlineIconVisibility() {
        return this.headlineIconVisibility;
    }

    public void setHeadlineIconVisibility(boolean bl) {
        this.headlineIconVisibility = bl;
    }

    @Override
    public String getSignPostInfo() {
        return this.signPostInfo;
    }

    public void setSignPostInfo(String string) {
        this.signPostInfo = string;
    }
}

