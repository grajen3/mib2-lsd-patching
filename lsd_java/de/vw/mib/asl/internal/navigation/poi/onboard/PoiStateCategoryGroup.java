/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.poi.onboard;

import de.vw.mib.asl.api.navigation.NavigationConfiguration;
import de.vw.mib.asl.internal.navigation.ASLNavigationDP;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdCancelSpeller;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdLiGetState;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdPoiStartSpellerAlongRoute;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdRequestValueListByListIndex;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdRestoreState;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdSetLiValueListWindowSize;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdStartSpeller;
import de.vw.mib.asl.internal.navigation.poi.onboard.PoiAbstractHsmState;
import de.vw.mib.asl.internal.navigation.poi.onboard.PoiDatapool;
import de.vw.mib.asl.internal.navigation.poi.onboard.PoiHsmTarget;
import de.vw.mib.asl.internal.navigation.poi.transformer.PoiCatGroupListCollector;
import de.vw.mib.asl.internal.navigation.poi.transformer.PoiCatListCollector;
import de.vw.mib.asl.internal.navigation.util.LocationWrapper;
import de.vw.mib.asl.internal.navigation.util.NaviHelper;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import java.util.ArrayList;
import org.dsi.ifc.navigation.LISpellerData;
import org.dsi.ifc.navigation.LIValueList;

public final class PoiStateCategoryGroup
extends PoiAbstractHsmState {
    private PoiHsmTarget myTarget;
    public static LISpellerData groupState;
    private PoiCatGroupListCollector[] groupList;
    public static ArrayList catGroupArrayList;

    public PoiStateCategoryGroup(PoiHsmTarget poiHsmTarget, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.myTarget = poiHsmTarget;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        if (this.myTarget.getTextLogger().isTraceEnabled(this.myTarget.getSubClassifier())) {
            this.myTarget.makeTrace(this).append("Received event ID:").append(eventGeneric.getReceiverEventId()).log();
        }
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                this.myTarget.myTrace(this, "HSM_ENTRY");
                break;
            }
            case 3: {
                this.myTarget.myTrace(this, "HSM_START");
                this.handleHsmStart();
                break;
            }
            case 4: {
                this.myTarget.myTrace(this, "HSM_EXIT");
                break;
            }
            default: {
                if (this.myTarget.getTextLogger().isTraceEnabled(this.myTarget.getSubClassifier())) {
                    this.myTarget.makeTrace(this).append("Received event which is not handled in this state (ID=").append(eventGeneric.getReceiverEventId()).append(")").log();
                }
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }

    @Override
    public void handleCommandCmdStartSpeller(CmdStartSpeller cmdStartSpeller) {
        this.myTarget.myCmdTrace(this, cmdStartSpeller);
        if (cmdStartSpeller.liResult_ReturnCode != 0L) {
            if (this.myTarget.getTextLogger().isTraceEnabled(this.myTarget.getSubClassifier())) {
                this.myTarget.makeTrace(this).append("Error! returnCode=").append(cmdStartSpeller.liResult_ReturnCode).log();
            }
            return;
        }
        this.handleLIVALUELIST(cmdStartSpeller.liValueList_lispValueList);
    }

    @Override
    public void handleCommandCmdPoiStartSpellerAlongRoute(CmdPoiStartSpellerAlongRoute cmdPoiStartSpellerAlongRoute) {
        this.myTarget.myCmdTrace(this, cmdPoiStartSpellerAlongRoute);
        if (cmdPoiStartSpellerAlongRoute.liResult_ReturnCode != 0L) {
            if (this.myTarget.getTextLogger().isTraceEnabled(this.myTarget.getSubClassifier())) {
                this.myTarget.makeError(this).append("Error! returnCode=").append(cmdPoiStartSpellerAlongRoute.liResult_ReturnCode).log();
            }
            return;
        }
        this.handleLIVALUELIST(cmdPoiStartSpellerAlongRoute.liValueList_lispValueList);
    }

    @Override
    public void handleCommandCmdLiGetState(CmdLiGetState cmdLiGetState) {
        this.myTarget.myCmdTrace(this, cmdLiGetState);
        this.handleLIGETSTATERESULT(cmdLiGetState.liGetStateResult_spellerState);
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

    @Override
    public void handleCommandCmdRestoreState(CmdRestoreState cmdRestoreState) {
        this.myTarget.myCmdTrace(this, cmdRestoreState);
        if (cmdRestoreState.liResult_ReturnCode != 0L) {
            if (this.myTarget.getTextLogger().isTraceEnabled(this.myTarget.getSubClassifier())) {
                this.myTarget.makeError(this).append("Error! returnCode=").append(cmdRestoreState.liResult_ReturnCode).log();
            }
            return;
        }
    }

    public void clearModelData() {
        this.myTarget.myTrace(this, "clearModelData");
        this.groupList = new PoiCatGroupListCollector[0];
        catGroupArrayList = new ArrayList();
        this.myTarget.notifierModel.notifyCategoryGroupListItemsUpdateList(this.groupList);
        this.myTarget.notifierModel.notifyCategoryListItemsUpdateList(new PoiCatListCollector[0]);
    }

    public void groupClosed() {
        this.myTarget.myTrace(this, "groupClosed");
        new CmdRestoreState(this, groupState).execute();
        this.myTarget.notifierModel.notifyCategoryOpenedIndex(-1);
        this.myTarget.notifierModel.notifyNaviPoiDataLoadFinished();
    }

    private void handleHsmStart() {
        if (this.myTarget.getTextLogger().isTraceEnabled(this.myTarget.getSubClassifier())) {
            this.myTarget.makeTrace(this).append("getPoiSearchArea:").append(ASLNavigationDP.getInstance().getPoiSearchArea()).log();
        }
        LocationWrapper locationWrapper = new LocationWrapper(PoiDatapool.getInstance().getReferenceLocation().getLatitude(), PoiDatapool.getInstance().getReferenceLocation().getLongitude());
        this.myTarget.getDsiNavigation().poiSetContext(locationWrapper.getLocation());
        this.myTarget.setSortOrder(NavigationConfiguration.POI_IS_SORT_ORDER_FOR_CATEGORY_CLASSES_NATURAL);
        new CmdSetLiValueListWindowSize(this, -1).execute();
        if (PoiDatapool.getInstance().getCurrentUseCase() != 12) {
            new CmdCancelSpeller(this).execute();
            this.myTarget.myTrace(this, "CmdStartSpeller");
            new CmdStartSpeller(this, 0xF800000, false, false, false).execute();
        } else {
            this.myTarget.myTrace(this, "CmdPoiStartSpellerAlongRoute");
            new CmdPoiStartSpellerAlongRoute(this, 0xF800000, 0L, 0L).execute();
        }
    }

    private void handleLIVALUELIST(LIValueList lIValueList) {
        this.myTarget.myTrace(this, "handleLIVALUELIST");
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
                new CmdRequestValueListByListIndex(this, catGroupArrayList.size(), true).execute();
            } else {
                this.groupList = new PoiCatGroupListCollector[catGroupArrayList.size()];
                catGroupArrayList.toArray(this.groupList);
                this.myTarget.notifierModel.notifyCategoryGroupListItemsUpdateList(this.groupList);
                this.myTarget.myTrace(this, "CmdLiGetState");
                new CmdLiGetState(this).execute();
                this.myTarget.notifierModel.notifyNaviPoiDataLoadFinished();
            }
        }
    }

    private void handleLIGETSTATERESULT(LISpellerData lISpellerData) {
        this.myTarget.myTrace(this, "liSpellerData updated.");
        groupState = lISpellerData;
    }

    private void appendValueListToResultList(LIValueList lIValueList) {
        this.myTarget.myTrace(this, "appendValueListToResultList");
        if (lIValueList == null) {
            this.myTarget.myError(this, "liValueList==null");
            return;
        }
        if (lIValueList.list == null) {
            this.myTarget.myError(this, "liValueList.list==null");
            return;
        }
        for (int i2 = 0; i2 < lIValueList.list.length; ++i2) {
            if (lIValueList.list[i2] != null) {
                if (this.myTarget.getTextLogger().isTraceEnabled(this.myTarget.getSubClassifier())) {
                    this.myTarget.makeTrace(this).append("Group category ").append(i2).append(":").append(lIValueList.list[i2].data).log();
                }
                if (lIValueList.list[i2].data != null) {
                    catGroupArrayList.add(new PoiCatGroupListCollector(lIValueList.list[i2].data, lIValueList.list[i2].criteriaNumber));
                    continue;
                }
                catGroupArrayList.add(new PoiCatGroupListCollector("LIValueList.list[].data = null!", lIValueList.list[i2].criteriaNumber));
                if (!this.myTarget.getTextLogger().isTraceEnabled(this.myTarget.getSubClassifier())) continue;
                this.myTarget.makeError(this).append("LIValueList.list[").append(i2).append("i].data = null!").log();
                continue;
            }
            catGroupArrayList.add(new PoiCatGroupListCollector("=null!", -1));
            if (!this.myTarget.getTextLogger().isTraceEnabled(this.myTarget.getSubClassifier())) continue;
            this.myTarget.makeError(this).append("LIValueList.list[").append(i2).append("i] = null!").log();
        }
    }

    static {
        catGroupArrayList = new ArrayList(0);
    }
}

