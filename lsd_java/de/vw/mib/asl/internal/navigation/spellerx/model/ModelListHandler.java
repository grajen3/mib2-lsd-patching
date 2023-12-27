/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.spellerx.model;

import de.vw.mib.asl.api.navigation.ILocationWrapper;
import de.vw.mib.asl.api.navigation.map.AbstractDualListViewHandlerUpdateListener;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.framework.internal.framework.util.StringUtil;
import de.vw.mib.asl.internal.list.ASLCachedWindowList;
import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListElementFetcher;
import de.vw.mib.asl.internal.list.impl.ASLListItemSoftCacheImpl;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.navigation.gateway.AbstractNavGatewayListener;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdGetLocationFromLiValueListElement;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdRequestValueListByListIndex;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdSetLiValueListWindowSize;
import de.vw.mib.asl.internal.navigation.spellerx.SpellerContext;
import de.vw.mib.asl.internal.navigation.spellerx.XSpellerTarget;
import de.vw.mib.asl.internal.navigation.spellerx.model.ModelListHandler$1;
import de.vw.mib.asl.internal.navigation.spellerx.model.ModelUpdater;
import de.vw.mib.asl.internal.navigation.spellerx.states.StatePhoneNumber;
import de.vw.mib.genericevents.Target;
import generated.de.vw.mib.asl.internal.ListManager;
import java.util.ArrayList;
import java.util.Arrays;
import org.dsi.ifc.navigation.LIExtData;
import org.dsi.ifc.navigation.LIValueList;
import org.dsi.ifc.navigation.LIValueListElement;

public class ModelListHandler
extends AbstractNavGatewayListener
implements ASLListElementFetcher,
AbstractDualListViewHandlerUpdateListener {
    private static final int PHONENUMBER_TYPE;
    private static final int ENTEREDSTRING_TYPE;
    private final Target target;
    private final IExtLogger logger;
    private final GenericASLList aslList;
    private String listName;
    private int lastListSize;
    private int lastRequested = 0;
    private boolean frozen = false;
    private int listId = 0;
    private int selCritDesForList;
    private boolean isPreviewList;
    private static final int LIST_FETCH_SIZE;
    private String currentInput = "";
    private int currentSize;
    private final ArrayList pendingResolveCommands;
    private boolean resolveResults;
    private int inputFieldReadyConst;
    private final boolean readyForDualListView;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$LIValueListElement;

    public Target getTarget() {
        return this.target;
    }

    public ModelListHandler(Target target, IExtLogger iExtLogger, String string, int n, int n2, int n3, boolean bl, boolean bl2) {
        this.target = target;
        this.logger = iExtLogger;
        this.listId = n;
        this.readyForDualListView = bl2;
        this.aslList = ListManager.getGenericASLList(n);
        this.listName = string;
        this.lastListSize = 0;
        this.frozen = false;
        this.selCritDesForList = n2;
        this.inputFieldReadyConst = n3;
        this.isPreviewList = bl;
        this.aslList.enableWindowing(new ASLListItemSoftCacheImpl(), this, 25, 1);
        if (bl2) {
            this.aslList.addListViewListener(new ModelListHandler$1(this, this));
        }
        this.pendingResolveCommands = new ArrayList();
    }

    public LIValueListElement getListElement(int n) {
        this.logger.makeInfo().append("### CHECKING BEFORE CASTING LIST ELEMENT").log();
        Object object = this.aslList.getRowItemCacheOnly(n);
        if (object == null) {
            return null;
        }
        if (object.getClass() != (class$org$dsi$ifc$navigation$LIValueListElement == null ? (class$org$dsi$ifc$navigation$LIValueListElement = ModelListHandler.class$("org.dsi.ifc.navigation.LIValueListElement")) : class$org$dsi$ifc$navigation$LIValueListElement)) {
            return null;
        }
        return (LIValueListElement)object;
    }

    public void prepareListForInitialFill() {
        boolean bl = false;
        this.resolveResults = false;
        try {
            this.printTrace(new StringBuffer().append("preparing list '").append(this.listName).append("' for initial fill: set model.list=[], model.count=0").toString());
            this.lastListSize = 0;
            this.aslList.setSize(0);
            ModelUpdater.updateListCount(0, this.selCritDesForList);
            this.frozen = false;
        }
        catch (Exception exception) {
            this.logger.makeError().append(exception.toString()).log();
        }
    }

    public void prepareListForUpdate() {
        this.frozen = false;
        try {
            this.printTrace(new StringBuffer().append("preparing list '").append(this.listName).append("' for update: set model.list=[], model.count=").append(this.lastListSize).toString());
            this.aslList.setSize(0);
        }
        catch (Exception exception) {
            this.logger.makeError().append(exception.toString()).log();
        }
    }

    public void prepareListForRestore() {
        this.frozen = false;
        try {
            this.printTrace(new StringBuffer().append("preparing list '").append(this.listName).append("' for restore: model.count=").append(this.lastListSize).toString());
            ModelUpdater.updateListCount(this.lastListSize, this.selCritDesForList);
        }
        catch (Exception exception) {
            this.logger.makeError().append(exception.toString()).log();
        }
    }

    public void invalidateList() {
        this.frozen = true;
        try {
            this.printTrace(new StringBuffer().append("invalidating list '").append(this.listName).append("' model.list=[], model.count=0").toString());
            ModelUpdater.updateListCount(0, this.selCritDesForList);
        }
        catch (Exception exception) {
            this.logger.makeError().append(exception.toString()).log();
        }
    }

    public void freezeList() {
        this.printTrace(new StringBuffer().append("freezing list '").append(this.listName).append("'").toString());
        this.frozen = true;
    }

    public void updateItems(LIValueList lIValueList, long l, String string) {
        int n;
        int n2 = this.currentInput.length();
        this.currentInput = string;
        this.currentSize = 0;
        if (lIValueList == null || lIValueList.list == null || l == 0L) {
            this.printTrace(new StringBuffer().append("LIValueList for ").append(this.listName).append(" is NULL! ").toString());
            ModelUpdater.updateListCount(0, this.selCritDesForList);
            this.aslList.setSize(0);
            return;
        }
        this.currentSize = lIValueList.list.length;
        int n3 = 19;
        if (this.isPreviewList && lIValueList.list.length > 19) {
            l = 0;
            LIValueListElement[] lIValueListElementArray = new LIValueListElement[19];
            for (n = 0; n < 19; ++n) {
                lIValueListElementArray[n] = lIValueList.list[n];
            }
            lIValueList.list = lIValueListElementArray;
            lIValueList.hasNextPage = false;
            lIValueList.hasPrevPage = false;
        }
        if (this.listId == 3441) {
            this.prepareBasenameElements(lIValueList);
        }
        int n4 = this.lastListSize;
        this.aslList.setSize(0);
        this.lastRequested = 0;
        this.aslList.setSize((int)l);
        this.lastListSize = (int)l;
        if (lIValueList.list.length == 0) {
            this.lastRequested = -1;
        }
        this.printTrace(new StringBuffer().append("updating list '").append(this.listName).append(" model.list=").append(this.aslList).append(", model.count=").append(this.lastListSize).toString());
        n = 1;
        if (lIValueList.list.length > 0) {
            if (lIValueList.list[0].listIndex == 0 && SpellerContext.getActiveExtInterfaceField() == 0) {
                ModelUpdater.updateListCount((int)l, this.selCritDesForList);
                this.printTrace("LIST INDEX = 0");
                if (this.listId == -839905280 && !this.frozen && lIValueList.hasNextPage) {
                    this.setLongValueListMode();
                    this.setInputFieldReady(false);
                    new CmdRequestValueListByListIndex(this, 0, false).execute();
                }
            } else if (this.listId == -839905280 && !this.frozen) {
                if (lIValueList.hasNextPage) {
                    this.setLongValueListMode();
                    this.setInputFieldReady(false);
                    new CmdRequestValueListByListIndex(this, 0, false).execute();
                }
            } else if (lIValueList.list[0].criteriaNumber == 5) {
                this.fetchMoreElementsForExtInterface(lIValueList, l, string, false);
            } else if (!this.frozen) {
                this.printTrace("LIST INDEX != 0");
                if (lIValueList.hasNextPage) {
                    this.setLongValueListMode();
                    this.setInputFieldReady(false);
                    new CmdRequestValueListByListIndex(this, 0, false).execute();
                } else if (lIValueList.list.length == 1 && l == 0 && !lIValueList.hasNextPage && lIValueList.hasPrevPage) {
                    new CmdRequestValueListByListIndex(this, 0, false).execute();
                    n = 0;
                    this.aslList.updateListItems(1, lIValueList.list);
                }
            } else {
                this.logger.makeWarn().append("LIST UPDATE PREVENTED BECAUSE LIST ALREADY FROZEN").log();
            }
        }
        if (n != 0) {
            this.aslList.updateListItems(0, lIValueList.list);
        }
        if (!(l > (long)SpellerContext.listSizeLimit && l != 1L || this.isPreviewList)) {
            this.printTrace(new StringBuffer().append("notify model, that list size ").append(lIValueList.list.length).append(" falls below ").append(SpellerContext.listSizeLimit).toString());
            if (n4 == 0 || string.length() > n2 || l == 1L) {
                this.sendFallBelowNEventIfEnabled();
            }
        }
    }

    private void prepareBasenameElements(LIValueList lIValueList) {
        ArrayList arrayList = new ArrayList();
        this.printTrace("prepareBasenameElements: Checking list for basenames");
        for (int i2 = 0; i2 < lIValueList.list.length; ++i2) {
            LIValueListElement lIValueListElement = lIValueList.list[i2];
            this.printTrace(new StringBuffer().append("prepareBasenameElements: Checking ").append(lIValueListElement.data).toString());
            boolean bl = false;
            if (lIValueListElement.extendedData != null) {
                for (int i3 = 0; i3 < lIValueListElement.extendedData.length; ++i3) {
                    LIExtData lIExtData = lIValueListElement.getExtendedData()[i3];
                    if (lIExtData.type != 8) continue;
                    bl = true;
                    arrayList.add(new Integer(i2));
                    this.printTrace(new StringBuffer().append("prepareBasenameElements: ").append(lIValueListElement.data).append(" is basename entry").toString());
                    lIValueList.list[i2].data = new StringBuffer().append(lIValueList.list[i2].data).append(" ").append(lIExtData.getData()).toString();
                }
            }
            if (bl || !arrayList.contains(new Integer(i2 - 1))) continue;
            ArrayList arrayList2 = new ArrayList(Arrays.asList(lIValueListElement.extendedData));
            this.printTrace(new StringBuffer().append("prepareBasenameElements: Checking element ").append(lIValueListElement.data).append(" as FIRST_FSN").toString());
            arrayList2.add(new LIExtData(1000, "FIRST_FSN"));
            lIValueListElement.extendedData = (LIExtData[])arrayList2.toArray(new LIExtData[0]);
        }
    }

    private void sendFallBelowNEventIfEnabled() {
        this.printTrace("### send FALL_BELOW_N event");
        if (!Boolean.valueOf(System.getProperty("enableFiveElementList", "false")).booleanValue() && !StatePhoneNumber.restored) {
            ServiceManager.eventDispatcher.createAndSubmitHMIEvent(495);
        } else {
            this.printTrace(new StringBuffer().append("sendFallBelowNEventIfEnabled not sent: StatePhoneNumber.restored = ").append(StatePhoneNumber.restored).append(", enableFiveElementList = ").append(Boolean.valueOf(System.getProperty("enableFiveElementList", "false"))).toString());
        }
    }

    @Override
    public void fetchItems(ASLCachedWindowList aSLCachedWindowList, int n, int n2) {
        this.printTrace(new StringBuffer().append("list requests ").append(n2).append(" items starting at ").append(n).toString());
        if (this.frozen) {
            this.logger.makeWarn().append(this.listName).append("LIST HAS FROZEN: IGNORE REQUEST").log();
            return;
        }
        if (n < this.aslList.getSize()) {
            this.printTrace(new StringBuffer().append("ASLList size is: ").append(this.aslList.getSize()).append(" index is: ").append(n).toString());
        }
        if (this.lastRequested != n && n < this.aslList.getSize()) {
            this.setLongValueListMode();
            this.setInputFieldReady(false);
            new CmdRequestValueListByListIndex(this, n, true).execute();
            this.lastRequested = n;
        }
    }

    @Override
    public void fetchNextPage(ASLCachedWindowList aSLCachedWindowList, Object object, int n, int n2) {
        this.fetchItems(aSLCachedWindowList, n, n2);
    }

    @Override
    public void fetchPreviousPage(ASLCachedWindowList aSLCachedWindowList, Object object, int n, int n2) {
        this.fetchItems(aSLCachedWindowList, n, n2);
    }

    @Override
    public void handleCommandCmdRequestValueListByListIndex(CmdRequestValueListByListIndex cmdRequestValueListByListIndex) {
        this.setInputFieldReady(true);
        this.printTrace(new StringBuffer().append("updating list '").append(this.listName).append(" with [...] ").append(this.aslList).toString());
        this.printTrace(new StringBuffer().append("new calculated list size from DSI: ").append(cmdRequestValueListByListIndex.liValueList_lispValueListCount).toString());
        if (cmdRequestValueListByListIndex.liValueList_lispValueList != null && cmdRequestValueListByListIndex.liValueList_lispValueList.list != null) {
            this.currentSize += cmdRequestValueListByListIndex.liValueList_lispValueList.list.length;
            this.printTrace(new StringBuffer().append("dsi result for requested window arrived, returnCode=").append(cmdRequestValueListByListIndex.liResult_ReturnCode).append(")").toString());
            LIValueList lIValueList = cmdRequestValueListByListIndex.liValueList_lispValueList;
            long l = cmdRequestValueListByListIndex.liValueList_lispValueListCount;
            int n = 19;
            if (this.isPreviewList && lIValueList.list.length > 19) {
                l = 0;
                LIValueListElement[] lIValueListElementArray = new LIValueListElement[19];
                for (int i2 = 0; i2 < 19; ++i2) {
                    lIValueListElementArray[i2] = lIValueList.list[i2];
                }
                lIValueList.list = lIValueListElementArray;
                lIValueList.hasNextPage = false;
                lIValueList.hasPrevPage = false;
            }
            this.prepareBasenameElements(lIValueList);
            this.aslList.setSize((int)l);
            this.lastListSize = (int)l;
            if (lIValueList.list.length > 0 && lIValueList.list[0].hasListIndex) {
                this.aslList.updateListItems(lIValueList.list[0].listIndex, lIValueList.list);
            } else {
                this.aslList.updateListItems(cmdRequestValueListByListIndex.getAnchorIndex(), lIValueList.list);
            }
            if (l > 1L && cmdRequestValueListByListIndex.liValueList_lispValueListCount <= (long)SpellerContext.listSizeLimit && this.listId == -839905280 || this.resolveResults) {
                this.resolveElements(cmdRequestValueListByListIndex.liValueList_lispValueList);
            }
            if (lIValueList.list.length > 0 && lIValueList.list[0].criteriaNumber == 5) {
                this.fetchMoreElementsForExtInterface(cmdRequestValueListByListIndex.liValueList_lispValueList, cmdRequestValueListByListIndex.liValueList_lispValueListCount, cmdRequestValueListByListIndex.lispUpdateSpellerResult_lispCurrentInput, true);
            }
        } else {
            this.logger.warn("The returned cmd.liValueList_lispValueList or cmd.liValueList_lispValueList.list is null.");
        }
    }

    @Override
    public void listViewUpdated(boolean bl, ASLList aSLList, int n, int n2, Object[] objectArray) {
        if (this.readyForDualListView && !bl) {
            Object[] objectArray2 = this.getValidItems(aSLList, objectArray);
            int[][] nArray = new int[objectArray2.length][2];
            for (int i2 = 0; i2 < objectArray2.length; ++i2) {
                nArray[i2][0] = ((LIValueListElement)objectArray2[i2]).listIndex;
            }
            ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().storeVisibleLocationIDs(nArray);
        }
    }

    private Object[] getValidItems(ASLList aSLList, Object[] objectArray) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < objectArray.length; ++i2) {
            if (!aSLList.isValidItem(objectArray[i2])) continue;
            arrayList.add(objectArray[i2]);
        }
        return arrayList.toArray(new Object[arrayList.size()]);
    }

    private void fetchMoreElementsForExtInterface(LIValueList lIValueList, long l, String string, boolean bl) {
        if (SpellerContext.getActiveExtInterfaceField() != 0 && !StringUtil.isEmpty(string)) {
            if (bl) {
                XSpellerTarget.changeExtInterfaceList(lIValueList, l, null);
            }
            if (lIValueList.hasNextPage) {
                int n = lIValueList.list[lIValueList.list.length - 1].listIndex + 1;
                if (n == 1) {
                    n = this.currentSize;
                }
                if ((long)n < l) {
                    this.setLongValueListMode();
                    new CmdRequestValueListByListIndex(this, n, true).execute();
                }
            }
        }
    }

    @Override
    public void handleCommandCmdSetLiValueListWindowSize(CmdSetLiValueListWindowSize cmdSetLiValueListWindowSize) {
        SpellerContext.useShortLiValueList = false;
        SpellerContext.useShortLiValueListHnr = false;
        this.printTrace(new StringBuffer().append("SetLiValueListSize return code is: ").append(cmdSetLiValueListWindowSize.liResult_ReturnCode).append(" New window size is: ").append(cmdSetLiValueListWindowSize.getWindowSize()).toString());
    }

    private void setLongValueListMode() {
        if (SpellerContext.useShortLiValueList || SpellerContext.useShortLiValueListHnr) {
            this.printTrace("setLongValueListMode: Setting liValueListWindowSize = 25");
            new CmdSetLiValueListWindowSize(this, 20).execute();
        }
    }

    private void printTrace(String string) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append(new StringBuffer().append("[").append(this.listName).append("] ").append(string).toString()).log();
        }
    }

    private void resolveLiValueListElement(LIValueListElement lIValueListElement) {
        if (lIValueListElement != null) {
            CmdGetLocationFromLiValueListElement cmdGetLocationFromLiValueListElement = new CmdGetLocationFromLiValueListElement(this, lIValueListElement);
            this.pendingResolveCommands.add(cmdGetLocationFromLiValueListElement);
            cmdGetLocationFromLiValueListElement.execute();
            this.printTrace(new StringBuffer().append("resolveElements request navLocation for element = ").append(lIValueListElement.listIndex).toString());
        } else {
            this.printTrace("resolveLiValueListElement called with parameter null");
        }
    }

    public void resolveElements(LIValueList lIValueList) {
        if (lIValueList != null) {
            this.printTrace(new StringBuffer().append("resolveElements ( LIValueList elementcount = ").append(lIValueList.list.length).append(")").toString());
            for (int i2 = 0; i2 < lIValueList.list.length; ++i2) {
                this.resolveLiValueListElement(lIValueList.list[i2]);
            }
        } else {
            this.printTrace(new StringBuffer().append("resolveElements ( ASL List elementcount = ").append(this.aslList.getSize()).append(")").toString());
            for (int i3 = 0; i3 < this.aslList.getSize(); ++i3) {
                LIValueListElement lIValueListElement = this.getListElement(i3);
                if (lIValueListElement == null) continue;
                this.resolveLiValueListElement(lIValueListElement);
            }
        }
    }

    @Override
    public void handleCommandCmdGetLocationFromLiValueListElement(CmdGetLocationFromLiValueListElement cmdGetLocationFromLiValueListElement) {
        this.resolveResults = true;
        this.printTrace("handleCommandCmdGetLocationFromLiValueListElement");
        LIValueListElement lIValueListElement = cmdGetLocationFromLiValueListElement.liValueListElement;
        ILocationWrapper iLocationWrapper = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(cmdGetLocationFromLiValueListElement.lispGetLocationFromLiValueListElement_location);
        ArrayList arrayList = new ArrayList(Arrays.asList(lIValueListElement.extendedData));
        arrayList.add(new LIExtData(10000, iLocationWrapper.getPhonenumber()));
        arrayList.add(new LIExtData(10001, this.currentInput));
        lIValueListElement.extendedData = (LIExtData[])arrayList.toArray(new LIExtData[0]);
        this.printTrace(new StringBuffer().append("Appending LIValueListElement ").append(lIValueListElement.listIndex).append(" with phonenumber ").append(iLocationWrapper.getPhonenumber()).toString());
        this.pendingResolveCommands.remove(cmdGetLocationFromLiValueListElement);
        if (this.pendingResolveCommands.isEmpty()) {
            this.quitModelWaitstate("handleCommandCmdGetLocationFromLiValueListElement: All elements resovled");
        }
    }

    void quitModelWaitstate(String string) {
        this.printTrace(new StringBuffer().append("quitModelWaitstate with reason=").append(string).toString());
        ServiceManager.aslPropertyManager.valueChangedInteger(2831, 0);
    }

    private void setInputFieldReady(boolean bl) {
        this.printTrace(new StringBuffer().append("setInputFieldReady: ").append(bl).toString());
        ServiceManager.aslPropertyManager.valueChangedBoolean(this.inputFieldReadyConst, bl);
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

