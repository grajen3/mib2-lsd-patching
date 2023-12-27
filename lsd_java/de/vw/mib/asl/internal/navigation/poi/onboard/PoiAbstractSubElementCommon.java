/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.poi.onboard;

import de.vw.mib.asl.api.system.ASLSystemFactory;
import de.vw.mib.asl.internal.navigation.caching.CacheClient;
import de.vw.mib.asl.internal.navigation.caching.HsmCacheHandler;
import de.vw.mib.asl.internal.navigation.caching.IconKey;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdLiGetState;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdRequestValueListByListIndex;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdSelectListItem;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdStartSpeller;
import de.vw.mib.asl.internal.navigation.poi.onboard.PoiAbstractHsmState;
import de.vw.mib.asl.internal.navigation.poi.onboard.PoiDatapool;
import de.vw.mib.asl.internal.navigation.poi.onboard.PoiHsmTarget;
import de.vw.mib.asl.internal.navigation.poi.onboard.PoiStateDetail;
import de.vw.mib.asl.internal.navigation.poi.onboard.PoiStateElementNoSurrounding;
import de.vw.mib.asl.internal.navigation.poi.onboard.PoiStateElementSurrounding;
import de.vw.mib.asl.internal.navigation.poi.transformer.PoiResultSubListCollector;
import de.vw.mib.asl.internal.navigation.util.NaviHelper;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import java.util.ArrayList;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.navigation.LISpellerData;
import org.dsi.ifc.navigation.LIValueList;

public abstract class PoiAbstractSubElementCommon
extends PoiAbstractHsmState
implements CacheClient {
    protected PoiHsmTarget myTarget;
    protected boolean getParentPOIState;
    protected static final int MAX_NUMBER_OF_ELEMENTS;
    public static int listSelection;
    public static PoiResultSubListCollector[] subPoiResultList;
    public static ArrayList subPoiArrayList;
    public static LISpellerData subPOIState;

    public PoiAbstractSubElementCommon(PoiHsmTarget poiHsmTarget, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.myTarget = poiHsmTarget;
    }

    protected void handleHsmStart() {
        PoiStateDetail.isChild = true;
        PoiStateElementSurrounding.ignoreUpdates = true;
        PoiStateElementNoSurrounding.stopRequestingValueList = true;
        this.clearModelData();
        this.getParentPOIState = true;
        this.myTarget.myTrace(this, "CmdLiGetState");
        new CmdLiGetState(this).execute();
    }

    public void clearModelData() {
        subPoiResultList = new PoiResultSubListCollector[0];
        subPoiArrayList = new ArrayList();
        this.myTarget.notifierModel.notifySubResultListItemsUpdateList(subPoiResultList);
    }

    protected void handleLIVALUELIST(LIValueList lIValueList) {
        this.myTarget.myTrace(this, "LIValueList list updated.");
        boolean bl = false;
        if (lIValueList != null && lIValueList.list != null) {
            if (this.myTarget.getTextLogger().isTraceEnabled(this.myTarget.getSubClassifier())) {
                this.myTarget.makeTrace(this).append("Length of LIValueList:").append(lIValueList.list.length).log();
            }
            if (lIValueList.list.length > 0) {
                bl = true;
            } else {
                this.myTarget.myError(this, "LIValueList.list.length == 0!");
                NaviHelper.getInstance().resetNaviContext("LIValueList.list.length == 0!");
            }
        } else {
            this.myTarget.myError(this, "LIValueList == null");
            NaviHelper.getInstance().resetNaviContext("LIValueList == null");
        }
        if (bl) {
            this.appendValueListToResultList(lIValueList);
            if (lIValueList != null && lIValueList.isHasNextPage()) {
                this.myTarget.myTrace(this, "CmdRequestValueListByListIndex");
                new CmdRequestValueListByListIndex(this, subPoiArrayList.size(), true).execute();
            } else {
                subPoiResultList = new PoiResultSubListCollector[subPoiArrayList.size()];
                subPoiArrayList.toArray(subPoiResultList);
                this.myTarget.notifierModel.notifySubResultListItemsUpdateList(subPoiResultList);
                this.myTarget.myTrace(this, "CmdLiGetState");
                new CmdLiGetState(this).execute();
            }
        }
    }

    private void appendValueListToResultList(LIValueList lIValueList) {
        this.myTarget.myTrace(this, "appendValueListToResultList");
        for (int i2 = 0; i2 < lIValueList.list.length && subPoiArrayList.size() < 200; ++i2) {
            if (lIValueList.list[i2] != null) {
                int n;
                String string = lIValueList.list[i2].data;
                ResourceLocator resourceLocator = HsmCacheHandler.resourceIdForPOIIcon(lIValueList.list[i2].iconIndex, lIValueList.list[i2].subIconIndex, 0, this, new Integer(subPoiArrayList.size()));
                if (this.myTarget.getTextLogger().isTraceEnabled(this.myTarget.getSubClassifier())) {
                    this.myTarget.makeTrace(this).append("Element:").append(i2).append(" Name: ").append(string).log();
                }
                int n2 = NaviHelper.getInstance().calculateDistance(lIValueList.list[i2].getLongitude(), lIValueList.list[i2].getLatitude(), PoiDatapool.getInstance().getReferenceLocation().getLongitude(), PoiDatapool.getInstance().getReferenceLocation().getLatitude());
                boolean bl = true;
                if (ASLSystemFactory.getSystemApi().getFeatureFlagValueBEV()) {
                    n = NaviHelper.getInstance().calculateDistance(lIValueList.list[i2].getLongitude(), lIValueList.list[i2].getLatitude(), PoiDatapool.getInstance().getCcp().getLongitude(), PoiDatapool.getInstance().getCcp().getLatitude());
                    int n3 = (int)((double)PoiDatapool.getInstance().getRemainingBatteryRangeFixed() * 0.95 / 1.25);
                    if (n3 < n) {
                        // empty if block
                    }
                }
                n = NaviHelper.getInstance().calculateDirectionIndex(PoiDatapool.getInstance().getReferenceLocation().getLongitude(), PoiDatapool.getInstance().getReferenceLocation().getLatitude(), lIValueList.list[i2].getLongitude(), lIValueList.list[i2].getLatitude(), PoiDatapool.getInstance().getReferenceDirection());
                subPoiArrayList.add(new PoiResultSubListCollector(resourceLocator, string, n2, n, bl));
                continue;
            }
            subPoiArrayList.add(new PoiResultSubListCollector(null, "=null!", 0, 0, false));
            if (!this.myTarget.getTextLogger().isTraceEnabled(this.myTarget.getSubClassifier())) continue;
            this.myTarget.makeError(this).append("LIValueList.list[").append(i2).append("] = null!").log();
        }
    }

    @Override
    public ResourceLocator getDefaultIcon() {
        return null;
    }

    @Override
    public void handleIconCacheUpdate(IconKey iconKey, ResourceLocator resourceLocator, Object object) {
        int n;
        if (this.myTarget.getTextLogger().isTraceEnabled(this.myTarget.getSubClassifier())) {
            this.myTarget.makeTrace(this).append("handleIconCacheUpdate index:").append((Integer)object).log();
        }
        if ((n = ((Integer)object).intValue()) < subPoiArrayList.size()) {
            ((PoiResultSubListCollector)PoiAbstractSubElementCommon.subPoiArrayList.get((int)n)).resourceLocator = resourceLocator;
            if (subPoiResultList.length != 0 && n < subPoiResultList.length) {
                PoiAbstractSubElementCommon.subPoiResultList[n].resourceLocator = resourceLocator;
                Object[] objectArray = new PoiResultSubListCollector[]{subPoiResultList[n]};
                this.myTarget.notifierModel.notifySubResultListItemsUpdateItems((Integer)object, objectArray);
            }
        } else if (this.myTarget.getTextLogger().isTraceEnabled(this.myTarget.getSubClassifier())) {
            this.myTarget.makeError(this).append("Index out of bounds (index:").append(n).append(" size:").append(subPoiArrayList.size()).append(")").log();
        }
    }

    @Override
    public void handleCommandCmdSelectListItem(CmdSelectListItem cmdSelectListItem) {
        this.myTarget.myCmdTrace(this, cmdSelectListItem);
        if (cmdSelectListItem.liResult_ReturnCode != 0L) {
            if (this.myTarget.getTextLogger().isTraceEnabled(this.myTarget.getSubClassifier())) {
                this.myTarget.makeError(this).append("Error! returnCode=").append(cmdSelectListItem.liResult_ReturnCode).log();
            }
            return;
        }
        this.handleLICURRENTSTATE(cmdSelectListItem.liCurrentState_liCurrentLD);
    }

    @Override
    public void handleCommandCmdStartSpeller(CmdStartSpeller cmdStartSpeller) {
        this.myTarget.myCmdTrace(this, cmdStartSpeller);
        if (cmdStartSpeller.liResult_ReturnCode != 0L) {
            if (this.myTarget.getTextLogger().isTraceEnabled(this.myTarget.getSubClassifier())) {
                this.myTarget.makeError(this).append("Error! returnCode=").append(cmdStartSpeller.liResult_ReturnCode).log();
            }
            return;
        }
        this.handleLIVALUELIST(cmdStartSpeller.liValueList_lispValueList);
    }

    @Override
    public void handleCommandCmdRequestValueListByListIndex(CmdRequestValueListByListIndex cmdRequestValueListByListIndex) {
        this.myTarget.myCmdTrace(this, cmdRequestValueListByListIndex);
        if (cmdRequestValueListByListIndex.liResult_ReturnCode != 0L) {
            if (this.myTarget.getTextLogger().isTraceEnabled(this.myTarget.getSubClassifier())) {
                this.myTarget.makeError(this).append("Error! returnCode=").append(cmdRequestValueListByListIndex.liResult_ReturnCode).log();
            }
            return;
        }
        this.handleLIVALUELIST(cmdRequestValueListByListIndex.liValueList_lispValueList);
    }

    protected void handleLICURRENTSTATE(NavLocation navLocation) {
        this.myTarget.myTrace(this, "liCurrentState updated.");
        this.myTarget.getDsiNavigation().poiSetContext(navLocation);
        this.myTarget.myTrace(this, "CmdStartSpeller");
        new CmdStartSpeller(this, 0x7800000, false, false, false).execute();
    }

    static {
        subPoiArrayList = null;
    }
}

