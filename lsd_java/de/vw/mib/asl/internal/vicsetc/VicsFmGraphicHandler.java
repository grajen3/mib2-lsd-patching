/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.vicsetc;

import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.vicsetc.VicsTarget;
import de.vw.mib.asl.internal.vicsetc.fmgraphic.transformer.VICSETCFmGraphicButtonInformationCollector;
import de.vw.mib.genericevents.EventGeneric;
import generated.de.vw.mib.asl.internal.vicsetc.fmgraphic.ASLVICSETCFmGraphicPropertyManager;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import org.dsi.ifc.asiatrafficinfomenu.ResourceInformation;
import org.dsi.ifc.asiatrafficinfomenu.TrafficMessage;

public class VicsFmGraphicHandler {
    public static final String SHORTCUT_MESSAGE_DEFAULT_VALUE;
    private final VicsTarget target;
    protected HashSet fmGraphicMenuResourcesLoaded = new HashSet();
    protected HashSet fmGraphicDetailResourcesLoaded = new HashSet();
    protected int fmGraphicMenuResourceIndex = 0;
    protected int fmGraphicDetailsResourceIndex = 0;
    protected boolean isEnterContextAfterUpdate = false;
    protected final GenericASLList fmGraphicsButtonInfoList;
    protected final List fmGraphicsMenuResourceList;
    protected final List fmGraphicsDetailsResourceList;

    public VicsFmGraphicHandler(VicsTarget vicsTarget, GenericASLList genericASLList) {
        this.target = vicsTarget;
        this.fmGraphicsButtonInfoList = genericASLList;
        this.fmGraphicsMenuResourceList = new ArrayList();
        this.fmGraphicsDetailsResourceList = new ArrayList();
    }

    protected void handleFmGraphicEnterContext() {
        this.target.traceMsg("enter fm graphic context.", this);
        this.fmGraphicsMenuResourceList.clear();
        this.resetFmGraphicMenuResourceIndex();
        this.target.vicsTrafficLists.updateTrafficMessages(this.target.currentInfos);
        TrafficMessage[] trafficMessageArray = this.target.vicsTrafficLists.getFmGraphicMessages();
        this.handleFmGraphicMenuMessagesAndButtons(trafficMessageArray);
        this.fmGraphicMenuResourcesLoaded.clear();
        if (trafficMessageArray.length > 0 && trafficMessageArray.length < 6) {
            this.fmGraphicMenuResourcesLoaded = this.target.requestResourceInformation(trafficMessageArray[0].contentID, this.fmGraphicMenuResourcesLoaded);
        } else if (trafficMessageArray.length >= 6) {
            this.fmGraphicMenuResourcesLoaded = this.target.requestResourceInformation(trafficMessageArray[0].contentID, this.fmGraphicMenuResourcesLoaded);
            this.fmGraphicMenuResourcesLoaded = this.target.requestResourceInformation(trafficMessageArray[6].contentID, this.fmGraphicMenuResourcesLoaded);
        } else {
            this.target.quitModelWaitState(1536840960, 0);
        }
    }

    protected void handleFmGraphicMenuMessagesAndButtons(TrafficMessage[] trafficMessageArray) {
        this.fmGraphicsButtonInfoList.clear();
        boolean bl = this.fmGraphicNotifiyModelIfMessagesAreAvailable(trafficMessageArray);
        if (bl) {
            this.extractMessagesFromAllMessagesForCurrentPage(trafficMessageArray);
            this.fmGraphicNotifyModelOnMenuImageCount(trafficMessageArray);
            this.fmGraphicnotifyModelAndUpdateButtonInfos(this.target.vicsTrafficLists.currentPageFmGraphicMessages);
        } else {
            this.fmGraphicMenuResourceIndex = 0;
            VicsTarget.writeIntegerToDatapool(966415616, 0);
            VicsTarget.writeIntegerToDatapool(949638400, 0);
        }
    }

    protected void extractMessagesFromAllMessagesForCurrentPage(TrafficMessage[] trafficMessageArray) {
        if (this.fmGraphicMenuResourceIndex > 0 && trafficMessageArray.length > 5) {
            int n = trafficMessageArray.length < 10 ? trafficMessageArray.length - 5 : 5;
            this.target.vicsTrafficLists.currentPageFmGraphicMessages = new TrafficMessage[n];
            System.arraycopy((Object)trafficMessageArray, 5, (Object)this.target.vicsTrafficLists.currentPageFmGraphicMessages, 0, n);
        } else {
            int n = trafficMessageArray.length < 6 ? trafficMessageArray.length : 5;
            this.target.vicsTrafficLists.currentPageFmGraphicMessages = new TrafficMessage[n];
            System.arraycopy((Object)trafficMessageArray, 0, (Object)this.target.vicsTrafficLists.currentPageFmGraphicMessages, 0, n);
        }
    }

    private void fmGraphicnotifyModelAndUpdateButtonInfos(TrafficMessage[] trafficMessageArray) {
        Object[] objectArray = new VICSETCFmGraphicButtonInformationCollector[trafficMessageArray.length];
        int n = this.fmGraphicMenuResourceIndex <= 0 ? 0 : 5;
        for (int i2 = 0; i2 < trafficMessageArray.length; ++i2) {
            TrafficMessage trafficMessage = trafficMessageArray[i2];
            objectArray[i2] = new VICSETCFmGraphicButtonInformationCollector(trafficMessage, new Integer(n + i2 + 1));
        }
        if (objectArray.length > 0) {
            this.fmGraphicsButtonInfoList.updateList(objectArray);
        }
    }

    private void fmGraphicNotifyModelOnMenuImageCount(TrafficMessage[] trafficMessageArray) {
        int n = 0;
        n = trafficMessageArray.length > 0 && trafficMessageArray.length < 6 ? 1 : 2;
        VicsTarget.writeIntegerToDatapool(949638400, n);
    }

    private void resetFmGraphicMenuResourceIndex() {
        if (!this.isEnterContextAfterUpdate) {
            this.fmGraphicMenuResourceIndex = 0;
            VicsTarget.writeIntegerToDatapool(966415616, this.fmGraphicMenuResourceIndex);
            VicsTarget.writeIntegerToDatapool(1805276416, this.fmGraphicMenuResourceIndex + 1);
        }
    }

    protected void handleFmGraphicTrafficMessageSelected(EventGeneric eventGeneric) {
        int n = eventGeneric.getInt(0);
        this.target.selectedMessage = this.target.vicsTrafficLists.currentPageFmGraphicMessages.length > 0 ? this.target.vicsTrafficLists.currentPageFmGraphicMessages[n] : null;
        this.target.traceMsg(new StringBuffer().append("Traffic message selected. ListIndex: ").append(n).append("\nMessage: ").append(this.target.selectedMessage).toString(), this);
        boolean bl = this.target.isMessageExpired(this.target.selectedMessage, 3);
        if (bl) {
            VicsTarget.writeBooleanToDatapool(1637504256, false);
        } else {
            this.target.stateMain.transStateFmGraphicDetails();
        }
    }

    private boolean fmGraphicNotifiyModelIfMessagesAreAvailable(TrafficMessage[] trafficMessageArray) {
        boolean bl;
        boolean bl2 = bl = trafficMessageArray.length > 0;
        if (bl) {
            VicsTarget.writeBooleanToDatapool(932861184, true);
        } else {
            VicsTarget.writeBooleanToDatapool(932861184, false);
        }
        return bl;
    }

    protected void handleFmGraphicDetailsToggleShortcut() {
        if (this.target.selectedMessage == null) {
            this.target.traceMsg("Message selected message was null.", this);
            return;
        }
        this.target.traceMsg(new StringBuffer().append("Message ").append(this.target.selectedMessage).append(" with the ID ").append(this.target.selectedMessage.trafficMessageID).append(" was selected as shortcut - VicsStateFmGraphicDetails").toString(), this);
        boolean bl = this.target.notfiyModelIfMessageExpired(1637504256, 3);
        if (bl) {
            this.fmGraphicToggleShortcut();
        }
    }

    private void fmGraphicToggleShortcut() {
        if (this.target.selectedMessage == null) {
            this.target.traceMsg("Selected message was null.", this);
            return;
        }
        if (this.target.isSelectedMessageShortcut()) {
            this.target.shortcutMessage = null;
            this.target.vicsEtcDP.setShortcutMessageChecked(false);
            this.target.vicsEtcDP.setShortcutMessageValue("-1");
        } else {
            this.target.shortcutMessage = this.target.selectedMessage;
            this.target.vicsEtcDP.setShortcutMessageValue(this.target.shortcutMessage.getValue());
            this.target.vicsEtcDP.setShortcutMessageChecked(true);
        }
    }

    protected void handleFmGraphicEnterDetails() {
        this.target.traceMsg("HSM_START - VicsStateFmGraphicDetails", this);
        this.fmGraphicsDetailsResourceList.clear();
        this.resetFmGraphicDetailsResourceIndex();
        boolean bl = this.target.notfiyModelIfMessageExpired(1637504256, 3);
        this.fmGraphicNotifyModelOnDetailsImageCount();
        if (bl) {
            this.fmGraphicSetCheckBoxForShortcut();
            this.fmGraphicRequestResourcesFromDsi();
        } else {
            this.fmGraphicDetailsResourceIndex = 0;
            VicsTarget.writeIntegerToDatapool(999970048, 0);
            VicsTarget.writeIntegerToDatapool(1805276416, 0);
            this.target.quitModelWaitState(1536840960, 0);
            this.target.quitModelWaitState(1536840960, 0);
        }
    }

    protected void fmGraphicNotifyModelOnDetailsImageCount() {
        if (this.target.selectedMessage == null) {
            this.target.traceMsg("Selected traffic message was null!", this);
            VicsTarget.writeIntegerToDatapool(983192832, 0);
            return;
        }
        int n = this.target.selectedMessage.detailContentIDs.length;
        VicsTarget.writeIntegerToDatapool(983192832, n);
    }

    protected void resetFmGraphicDetailsResourceIndex() {
        if (!this.isEnterContextAfterUpdate) {
            this.fmGraphicDetailsResourceIndex = 0;
            VicsTarget.writeIntegerToDatapool(999970048, this.fmGraphicDetailsResourceIndex);
            VicsTarget.writeIntegerToDatapool(1805276416, this.fmGraphicDetailsResourceIndex + 1);
        }
    }

    protected void fmGraphicSetCheckBoxForShortcut() {
        if (this.target.selectedMessage == null) {
            this.target.traceMsg("Message selected message was null.", this);
            return;
        }
        if (this.target.isSelectedMessageShortcut()) {
            VicsTarget.writeBooleanToDatapool(899306752, true);
        } else {
            VicsTarget.writeBooleanToDatapool(899306752, false);
        }
    }

    private void fmGraphicRequestResourcesFromDsi() {
        if (this.target.selectedMessage == null) {
            this.target.traceMsg("Message selected message was null.", this);
            return;
        }
        this.fmGraphicDetailResourcesLoaded.clear();
        if (this.target.selectedMessage.detailContentIDs.length <= 0) {
            this.target.quitModelWaitState(1536840960, 0);
        }
        for (int i2 = 0; i2 < this.target.selectedMessage.detailContentIDs.length; ++i2) {
            int n = this.target.selectedMessage.detailContentIDs[i2];
            this.fmGraphicDetailResourcesLoaded = this.target.requestResourceInformation(n, this.fmGraphicDetailResourcesLoaded);
        }
    }

    protected void handleFmGraphicMenuPressedNext() {
        this.target.traceMsg("PRESS_BUTTON_NEXT_MAIN_VIEW - VicsStateFmGraphic", this);
        if (this.fmGraphicMenuResourceIndex < 1) {
            ++this.fmGraphicMenuResourceIndex;
            ResourceInformation resourceInformation = (ResourceInformation)this.target.fmGraphicHandler.fmGraphicsMenuResourceList.get(this.target.fmGraphicHandler.fmGraphicMenuResourceIndex);
            VicsTarget.writeIntegerToDatapool(966415616, this.fmGraphicMenuResourceIndex);
            VicsTarget.writeIntegerToDatapool(1805276416, this.fmGraphicMenuResourceIndex + 1);
            VicsTarget.writeResourceLocatorToDatapool(2073711872, resourceInformation.getResourceLocator());
            this.handleFmGraphicMenuMessagesAndButtons(this.target.vicsTrafficLists.getFmGraphicMessages());
        } else {
            VicsTarget.writeIntegerToDatapool(966415616, 0);
            VicsTarget.writeIntegerToDatapool(1805276416, 0);
            VicsTarget.writeResourceLocatorToDatapool(2073711872, ASLVICSETCFmGraphicPropertyManager.MESSAGE_IMAGE_RESOURCE__DEFAULT_VALUE);
            this.target.quitModelWaitState(1536840960, 0);
        }
    }

    protected void handleFmGraphicMenuPressedPrev() {
        this.target.traceMsg("PRESS_BUTTON_PREV_MAIN_VIEW - VicsStateFmGraphic", this);
        if (this.fmGraphicMenuResourceIndex > 0) {
            --this.fmGraphicMenuResourceIndex;
            ResourceInformation resourceInformation = (ResourceInformation)this.target.fmGraphicHandler.fmGraphicsMenuResourceList.get(this.target.fmGraphicHandler.fmGraphicMenuResourceIndex);
            VicsTarget.writeIntegerToDatapool(966415616, this.fmGraphicMenuResourceIndex);
            VicsTarget.writeIntegerToDatapool(1805276416, this.fmGraphicMenuResourceIndex + 1);
            VicsTarget.writeResourceLocatorToDatapool(2073711872, resourceInformation.getResourceLocator());
            this.handleFmGraphicMenuMessagesAndButtons(this.target.vicsTrafficLists.getFmGraphicMessages());
        } else {
            VicsTarget.writeIntegerToDatapool(966415616, 0);
            VicsTarget.writeIntegerToDatapool(1805276416, 0);
            VicsTarget.writeResourceLocatorToDatapool(2073711872, ASLVICSETCFmGraphicPropertyManager.MESSAGE_IMAGE_RESOURCE__DEFAULT_VALUE);
            this.target.quitModelWaitState(1536840960, 0);
        }
    }

    protected void handleFmGraphicSubViewPressedNext() {
        this.target.traceMsg("PRESS_BUTTON_NEXT_SUB_VIEW - VicsStateFmGraphicDetails", this);
        boolean bl = this.target.notfiyModelIfMessageExpired(1637504256, 3);
        if (bl) {
            if (this.target.selectedMessage.detailContentIDs.length > this.fmGraphicDetailsResourceIndex + 1) {
                ++this.fmGraphicDetailsResourceIndex;
                ResourceInformation resourceInformation = (ResourceInformation)this.target.fmGraphicHandler.fmGraphicsDetailsResourceList.get(this.target.fmGraphicHandler.fmGraphicDetailsResourceIndex);
                VicsTarget.writeIntegerToDatapool(999970048, this.fmGraphicDetailsResourceIndex);
                VicsTarget.writeIntegerToDatapool(1805276416, this.fmGraphicDetailsResourceIndex + 1);
                VicsTarget.writeResourceLocatorToDatapool(2090489088, resourceInformation.getResourceLocator());
            }
        } else {
            this.resetDetailsViewInfos();
            this.target.quitModelWaitState(1536840960, 0);
        }
    }

    protected void handleFmGraphicSubViewPressedPrev() {
        this.target.traceMsg("PRESS_BUTTON_PREV_SUB_VIEW - VicsStateFmGraphicDetails", this);
        boolean bl = this.target.notfiyModelIfMessageExpired(1637504256, 3);
        if (bl) {
            if (this.fmGraphicDetailsResourceIndex > 0) {
                --this.fmGraphicDetailsResourceIndex;
                ResourceInformation resourceInformation = (ResourceInformation)this.target.fmGraphicHandler.fmGraphicsDetailsResourceList.get(this.target.fmGraphicHandler.fmGraphicDetailsResourceIndex);
                VicsTarget.writeIntegerToDatapool(999970048, this.fmGraphicDetailsResourceIndex);
                VicsTarget.writeIntegerToDatapool(1805276416, this.fmGraphicDetailsResourceIndex + 1);
                VicsTarget.writeResourceLocatorToDatapool(2090489088, resourceInformation.getResourceLocator());
            }
        } else {
            this.resetDetailsViewInfos();
            this.target.quitModelWaitState(1536840960, 0);
        }
    }

    protected void handleShortcutEnterContext() {
        this.target.traceMsg("enter shortcut context.", this);
        this.fmGraphicsDetailsResourceList.clear();
        this.resetFmGraphicDetailsResourceIndex();
        if (this.target.shortcutMessage == null) {
            TrafficMessage[] trafficMessageArray = this.target.vicsTrafficLists.getFmGraphicMessages();
            this.target.shortcutMessage = this.findPersistedShortcutMessage(trafficMessageArray);
            if (this.target.shortcutMessage == null) {
                this.target.traceMsg("shortcut message was null.", this);
                VicsTarget.writeBooleanToDatapool(664425728, false);
                this.resetDetailsViewInfos();
                this.target.quitModelWaitState(1570395392, 0);
                return;
            }
        }
        boolean bl = this.target.notfiyModelIfShortcutMessageExpired(664425728, 3);
        this.target.selectedMessage = this.target.shortcutMessage;
        this.fmGraphicNotifyModelOnDetailsImageCount();
        if (bl) {
            this.fmGraphicSetCheckBoxForShortcut();
            this.fmShortcutRequestMessageResources();
        } else {
            this.target.shortcutMessage = null;
            this.resetDetailsViewInfos();
            this.target.quitModelWaitState(1570395392, 0);
        }
    }

    protected void resetDetailsViewInfos() {
        this.target.traceMsg("resetDetailsViewInfos()", this);
        this.fmGraphicDetailsResourceIndex = 0;
        VicsTarget.writeIntegerToDatapool(999970048, 0);
        VicsTarget.writeIntegerToDatapool(1805276416, 0);
        VicsTarget.writeResourceLocatorToDatapool(2090489088, ASLVICSETCFmGraphicPropertyManager.MESSAGE_SUB_IMAGE_RESOURCE__DEFAULT_VALUE);
        VicsTarget.writeIntegerToDatapool(983192832, 0);
    }

    protected TrafficMessage findPersistedShortcutMessage(TrafficMessage[] trafficMessageArray) {
        this.target.traceMsg("findPersistedShortcutMessage()", this);
        for (int i2 = 0; i2 < trafficMessageArray.length; ++i2) {
            TrafficMessage trafficMessage = trafficMessageArray[i2];
            if (!this.target.isMessageShortcut(trafficMessage)) continue;
            this.target.traceMsg(new StringBuffer().append("findPersistedShortcutMessage() - message found: ").append(trafficMessage.getValue()).toString(), this);
            return trafficMessage;
        }
        return null;
    }

    private void fmShortcutRequestMessageResources() {
        int n = this.target.shortcutMessage.detailContentIDs.length;
        this.fmGraphicDetailResourcesLoaded.clear();
        for (int i2 = 0; i2 < n; ++i2) {
            int n2 = this.target.shortcutMessage.detailContentIDs[i2];
            this.fmGraphicDetailResourcesLoaded = this.target.requestResourceInformation(n2, this.fmGraphicDetailResourcesLoaded);
        }
    }

    protected void handleShortcutPressedNext() {
        this.target.traceMsg("BUTTON_NEXT_PRESSED - VicsStateShortcut", this);
        boolean bl = this.target.notfiyModelIfMessageExpired(664425728, 3);
        if (bl) {
            VicsTarget.writeBooleanToDatapool(1637504256, true);
            if (this.target.selectedMessage.detailContentIDs.length > this.fmGraphicDetailsResourceIndex + 1) {
                ++this.fmGraphicDetailsResourceIndex;
                ResourceInformation resourceInformation = (ResourceInformation)this.target.fmGraphicHandler.fmGraphicsDetailsResourceList.get(this.target.fmGraphicHandler.fmGraphicDetailsResourceIndex);
                VicsTarget.writeIntegerToDatapool(999970048, this.fmGraphicDetailsResourceIndex);
                VicsTarget.writeIntegerToDatapool(1805276416, this.fmGraphicDetailsResourceIndex + 1);
                VicsTarget.writeResourceLocatorToDatapool(2090489088, resourceInformation.getResourceLocator());
            }
        } else {
            this.resetDetailsViewInfos();
            this.target.quitModelWaitState(1570395392, 0);
        }
    }

    protected void handleShortcutPressedPrev() {
        this.target.traceMsg("BUTTON_PREV_PRESSED - VicsStateShortcut", this);
        boolean bl = this.target.notfiyModelIfMessageExpired(664425728, 3);
        if (bl) {
            if (this.fmGraphicDetailsResourceIndex > 0) {
                --this.fmGraphicDetailsResourceIndex;
                ResourceInformation resourceInformation = (ResourceInformation)this.target.fmGraphicHandler.fmGraphicsDetailsResourceList.get(this.target.fmGraphicHandler.fmGraphicDetailsResourceIndex);
                VicsTarget.writeIntegerToDatapool(999970048, this.fmGraphicDetailsResourceIndex);
                VicsTarget.writeIntegerToDatapool(1805276416, this.fmGraphicDetailsResourceIndex + 1);
                VicsTarget.writeResourceLocatorToDatapool(2090489088, resourceInformation.getResourceLocator());
            }
        } else {
            VicsTarget.writeBooleanToDatapool(1637504256, false);
            this.resetDetailsViewInfos();
            this.target.quitModelWaitState(1570395392, 0);
        }
    }

    protected void handleFmGraphicEnterContextAfterUpdate(EventGeneric eventGeneric) {
        this.target.traceMsg("ENTER_CONTEXT_AFTER_UPDATE - VicsStateFmGraphic", this);
        this.isEnterContextAfterUpdate = eventGeneric.getBoolean(0);
    }

    protected void handleShortcutEnterContextAfterUpdate(EventGeneric eventGeneric) {
        this.target.traceMsg("ENTER_CONTEXT_AFTER_UPDATE - VicsStateShortcut", this);
        this.isEnterContextAfterUpdate = eventGeneric.getBoolean(0);
    }

    protected void handleFmGraphicCheckIfCurrentMessageExpired() {
        this.target.traceMsg("EV_ASL_CHECK_IF_FM_GRAPHIC_MSG_EXPIRED - VicsStateFmGraphic", this);
        boolean bl = this.target.vicsTrafficLists.getFmGraphicMessages().length > 0;
        boolean bl2 = bl && this.target.isMessageExpired(this.target.selectedMessage, 3);
        this.target.traceMsg(new StringBuffer().append("The current fm graphic message ").append(this.target.selectedMessage).append(" is expired? ").append(bl2).toString(), this);
        if (bl2) {
            this.target.sendHMIEvent(614094080);
            this.target.stateMain.transStateMain();
        }
    }
}

