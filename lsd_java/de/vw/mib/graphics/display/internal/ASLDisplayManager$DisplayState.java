/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.display.internal;

import de.vw.mib.collections.ints.IntIterator;
import de.vw.mib.collections.ints.IntOptHashSet;
import de.vw.mib.collections.ints.IntSet;
import de.vw.mib.graphics.Rectangle;
import de.vw.mib.graphics.display.internal.ASLDisplayManager;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Logger;
import java.util.ArrayList;
import java.util.List;

final class ASLDisplayManager$DisplayState {
    private final Logger logger;
    private final int displayID;
    protected final IntSet displayablesActive;
    private final IntSet displayablesToAdd;
    private final IntSet displayablesToRemove;
    private final List pendingUpdateRequests;
    private boolean updateRequired;
    private static final int DEFAULT_MIN_DISPLAYABLES;
    private static final int REQUEST_DISPLAYABLE_ID;
    private static final int REQUEST_TYPE;
    private static final int REQUEST_TYPE_CROPPING;
    private static final int REQUEST_TYPE_OPACITY;
    private static final int REQUEST_CROPPING_SRC_X;
    private static final int REQUEST_CROPPING_SRC_Y;
    private static final int REQUEST_CROPPING_SRC_WIDTH;
    private static final int REQUEST_CROPPING_SRC_HEIGHT;
    private static final int REQUEST_CROPPING_DST_X;
    private static final int REQUEST_CROPPING_DST_Y;
    private static final int REQUEST_CROPPING_DST_WIDTH;
    private static final int REQUEST_CROPPING_DST_HEIGHT;
    private static final int REQUEST_CROPPING_SIZE;
    private static final int REQUEST_OPACITY_VALUE;
    private static final int REQUEST_OPACITY_SIZE;
    private final /* synthetic */ ASLDisplayManager this$0;

    public ASLDisplayManager$DisplayState(ASLDisplayManager aSLDisplayManager, Logger logger, int n) {
        this.this$0 = aSLDisplayManager;
        this.logger = logger;
        this.displayID = n;
        this.displayablesActive = new IntOptHashSet(3);
        this.displayablesToRemove = new IntOptHashSet(3);
        this.displayablesToAdd = new IntOptHashSet(3);
        this.pendingUpdateRequests = new ArrayList(3);
        this.updateRequired = true;
    }

    public void addUpdateCroppingRequest(int n, Rectangle rectangle, Rectangle rectangle2) {
        int[] nArray = this.findRequest(n, 0);
        nArray[2] = rectangle.x;
        nArray[3] = rectangle.y;
        nArray[4] = rectangle.width;
        nArray[5] = rectangle.height;
        nArray[6] = rectangle2.x;
        nArray[7] = rectangle2.y;
        nArray[8] = rectangle2.width;
        nArray[9] = rectangle2.height;
    }

    public void addUpdateOpacityRequest(int n, int n2) {
        int[] nArray = this.findRequest(n, 1);
        nArray[2] = n2;
    }

    private int[] findRequest(int n, int n2) {
        int[] nArray;
        for (int i2 = this.pendingUpdateRequests.size() - 1; i2 >= 0; --i2) {
            int[] nArray2 = (int[])this.pendingUpdateRequests.get(i2);
            if (nArray2[0] != n || nArray2[1] != n2) continue;
            return nArray2;
        }
        switch (n2) {
            case 0: {
                nArray = new int[10];
                break;
            }
            case 1: {
                nArray = new int[3];
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Unsupported RequestType: ").append(n2).toString());
            }
        }
        nArray[0] = n;
        nArray[1] = n2;
        this.pendingUpdateRequests.add(nArray);
        this.updateRequired = true;
        return nArray;
    }

    public void addDisplayable(int n) {
        if (!this.displayablesToRemove.remove(n) && !this.displayablesActive.contains(n)) {
            this.displayablesToAdd.add(n);
            this.updateRequired = true;
        }
    }

    public void removeDisplayable(int n) {
        if (!this.displayablesToAdd.remove(n) && this.displayablesActive.contains(n)) {
            this.displayablesToRemove.add(n);
            this.updateRequired = true;
        }
    }

    public void updateDisplay() {
        if (this.updateRequired) {
            this.updateDisplayableVisibility();
            this.updateDisplayableParams();
            this.updateRequired = false;
        }
    }

    private void updateDisplayableParams() {
        if (!this.pendingUpdateRequests.isEmpty()) {
            block4: for (int i2 = this.pendingUpdateRequests.size() - 1; i2 >= 0; --i2) {
                int[] nArray = (int[])this.pendingUpdateRequests.get(i2);
                switch (nArray[1]) {
                    case 0: {
                        this.setCropping(nArray[0], nArray[2], nArray[3], nArray[4], nArray[5], nArray[6], nArray[7], nArray[8], nArray[9]);
                        continue block4;
                    }
                    case 1: {
                        this.setOpacity(nArray[0], nArray[2]);
                        continue block4;
                    }
                    default: {
                        throw new IllegalArgumentException(new StringBuffer().append("Unsupported request type ").append(nArray[1]).toString());
                    }
                }
            }
            this.pendingUpdateRequests.clear();
        }
    }

    private void updateDisplayableVisibility() {
        boolean bl = this.displayablesActive.addAll(this.displayablesToAdd);
        boolean bl2 = this.displayablesActive.removeAll(this.displayablesToRemove);
        if (bl || bl2) {
            this.beginDisplayContextSwitch();
            IntIterator intIterator = this.displayablesActive.iterator();
            while (intIterator.hasNext()) {
                int n = intIterator.next();
                this.enableDisplayable(n);
            }
            this.endDisplayContextSwitch();
            this.displayablesToAdd.clear();
            this.displayablesToRemove.clear();
        }
    }

    private void setCropping(int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9) {
        if (this.logger.isTraceEnabled(1)) {
            LogMessage logMessage = this.logger.trace(1);
            logMessage.append("setDisplayableCropping ").append(n).append(",displayID=").append(this.displayID);
            logMessage.append(",srcX=").append(n2);
            logMessage.append(",srcY=").append(n3);
            logMessage.append(",srcWidth=").append(n4);
            logMessage.append(",srcHeight=").append(n5);
            logMessage.append(",destX=").append(n6);
            logMessage.append(",destY=").append(n7);
            logMessage.append(",destWidth=").append(n8);
            logMessage.append(",destHeight=").append(n9);
            logMessage.log();
        }
        ASLDisplayManager.access$000(this.this$0).setCropping(n, this.displayID, n2, n3, n4, n5, n6, n7, n8, n9);
    }

    private void setOpacity(int n, int n2) {
        if (this.logger.isTraceEnabled(1)) {
            LogMessage logMessage = this.logger.trace(1);
            logMessage.append("setDisplayableAlpha(displayable=").append(n).append(",displayID=").append(this.displayID);
            logMessage.append(",alpha=").append(n2).append(")").log();
        }
        ASLDisplayManager.access$000(this.this$0).setOpacity(n, this.displayID, n2);
    }

    private void beginDisplayContextSwitch() {
        if (this.logger.isTraceEnabled(1)) {
            LogMessage logMessage = this.logger.trace(1);
            logMessage.append("beginDisplayContextSwitch(displayID=").append(this.displayID).append(")").log();
        }
        ASLDisplayManager.access$000(this.this$0).beginDisplayContextSwitch(this.displayID);
    }

    private void endDisplayContextSwitch() {
        if (this.logger.isTraceEnabled(1)) {
            LogMessage logMessage = this.logger.trace(1);
            logMessage.append("endDisplayContextSwitch(displayID=").append(this.displayID).append(")").log();
        }
        ASLDisplayManager.access$000(this.this$0).endDisplayContextSwitch(this.displayID);
    }

    private void enableDisplayable(int n) {
        if (this.logger.isTraceEnabled(1)) {
            LogMessage logMessage = this.logger.trace(1);
            logMessage.append("enableDisplayable(displayID=").append(this.displayID).append(", displayable=").append(n).append(" )").log();
        }
        ASLDisplayManager.access$000(this.this$0).enableDisplayable(n, this.displayID);
    }
}

