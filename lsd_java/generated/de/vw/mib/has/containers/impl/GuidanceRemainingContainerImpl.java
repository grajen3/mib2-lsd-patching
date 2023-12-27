/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.has.containers.impl;

import generated.de.vw.mib.has.containers.GuidanceRemainingContainer;
import generated.de.vw.mib.has.containers.impl.AbstractContainer;

public class GuidanceRemainingContainerImpl
extends AbstractContainer
implements GuidanceRemainingContainer {
    private static final byte ELEMENT_TIME_TO_DESTINATION;
    private static final byte ELEMENT_DISTANCE_TO_DESTINATION;
    private int attrTimeToDestination;
    private int attrDistanceToDestination;

    @Override
    public int getContainerId() {
        return 25;
    }

    @Override
    public boolean isValid() {
        return this.isTimeToDestinationSet() && this.isDistanceToDestinationSet();
    }

    @Override
    public int getTimeToDestination() {
        return this.attrTimeToDestination;
    }

    @Override
    public int getDistanceToDestination() {
        return this.attrDistanceToDestination;
    }

    @Override
    public boolean isTimeToDestinationSet() {
        return this._isElementSet((byte)0);
    }

    @Override
    public boolean isDistanceToDestinationSet() {
        return this._isElementSet((byte)1);
    }

    @Override
    public void setTimeToDestination(int n) {
        this.attrTimeToDestination = n;
        this._setElement((byte)0, true);
    }

    @Override
    public void setDistanceToDestination(int n) {
        this.attrDistanceToDestination = n;
        this._setElement((byte)1, true);
    }

    @Override
    public void unsetTimeToDestination() {
        this.attrTimeToDestination = 0;
        this._setElement((byte)0, false);
    }

    @Override
    public void unsetDistanceToDestination() {
        this.attrDistanceToDestination = 0;
        this._setElement((byte)1, false);
    }
}

