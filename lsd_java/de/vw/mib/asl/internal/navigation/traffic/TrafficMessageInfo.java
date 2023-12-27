/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.traffic;

public class TrafficMessageInfo {
    private boolean messageFromOverviewList = true;
    private boolean urgentMessageDisplayed;
    private int lastReceivedFolderIndex = -1;
    private int offsetPosition;
    private int overviewTmcListMessageIndex;
    private long selectedMessageUID = -1L;
    private int overviewTmcListMessageSize;

    TrafficMessageInfo() {
    }

    int getLastReceivedFolderIndex() {
        return this.lastReceivedFolderIndex;
    }

    int getOffsetPosition() {
        return this.offsetPosition;
    }

    int getOverviewTmcListMessageIndex() {
        return this.overviewTmcListMessageIndex;
    }

    int getOverviewTmcListMessageSize() {
        return this.overviewTmcListMessageSize;
    }

    long getSelectedMessageUID() {
        return this.selectedMessageUID;
    }

    boolean isMessageFromOverviewList() {
        return this.messageFromOverviewList;
    }

    boolean isUrgentMessageDisplayed() {
        return this.urgentMessageDisplayed;
    }

    void nextOffsetPosition() {
        ++this.offsetPosition;
    }

    boolean overviewTmcListMessageIndexNextAvailable() {
        if (this.overviewTmcListMessageIndex + 1 < this.overviewTmcListMessageSize) {
            ++this.overviewTmcListMessageIndex;
            return true;
        }
        this.overviewTmcListMessageIndex = this.overviewTmcListMessageSize - 1;
        return false;
    }

    boolean overviewTmcListMessageIndexPreviousAvailable() {
        if (this.overviewTmcListMessageIndex - 1 >= 0) {
            --this.overviewTmcListMessageIndex;
            return true;
        }
        this.overviewTmcListMessageIndex = 0;
        return false;
    }

    void resetValue() {
        this.setOverviewTmcListMessageIndex(0);
        this.setMessageFromOverviewList(true);
        this.setOverviewTmcListMessageSize(0);
        this.setOffsetPosition(0);
    }

    void setLastReceivedFolderIndex(int n) {
        this.lastReceivedFolderIndex = n;
    }

    void setMessageFromOverviewList(boolean bl) {
        this.messageFromOverviewList = bl;
    }

    void setOffsetPosition(int n) {
        this.offsetPosition = n;
    }

    void setOverviewTmcListMessageIndex(int n) {
        this.overviewTmcListMessageIndex = n;
    }

    void setOverviewTmcListMessageSize(int n) {
        this.overviewTmcListMessageSize = n;
    }

    void setSelectedMessageUID(long l) {
        this.selectedMessageUID = l;
    }

    void setUrgentMessageDisplayed(boolean bl) {
        this.urgentMessageDisplayed = bl;
    }
}

