/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ugdo;

import de.vw.mib.asl.api.car.ASLCarFactory;
import de.vw.mib.asl.api.car.logger.CarLogger;
import de.vw.mib.asl.api.car.speller.Speller;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.framework.internal.framework.AbstractASLTarget;
import de.vw.mib.asl.internal.ugdo.ASLUGDOContainer;
import de.vw.mib.asl.internal.ugdo.ButtonListContext;
import de.vw.mib.asl.internal.ugdo.ButtonListController;
import de.vw.mib.asl.internal.ugdo.transformer.UGDOCollector;
import de.vw.mib.asl.internal.ugdo.transformer.UgdoFunctionCollector;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import generated.de.vw.mib.asl.internal.ListManager;
import generated.de.vw.mib.asl.internal.ugdo.transformer.UGDOSelectedUGDOKeyNrCollector;
import generated.de.vw.mib.asl.internal.ugdo.transformer.UGDOVersionInformationCollector;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.carcomfort.DSICarComfort;
import org.dsi.ifc.carcomfort.DSICarComfortListener;
import org.dsi.ifc.carcomfort.UGDOButtonListRA0;
import org.dsi.ifc.carcomfort.UGDOButtonListRA1;
import org.dsi.ifc.carcomfort.UGDOButtonListRA2;
import org.dsi.ifc.carcomfort.UGDOButtonListRA3;
import org.dsi.ifc.carcomfort.UGDOButtonListRA4;
import org.dsi.ifc.carcomfort.UGDOButtonListRA5;
import org.dsi.ifc.carcomfort.UGDOButtonListUpdateInfo;
import org.dsi.ifc.carcomfort.UGDOContent;
import org.dsi.ifc.carcomfort.UGDOSoftkeys;
import org.dsi.ifc.carcomfort.UGDOSpecialFeatures;
import org.dsi.ifc.carcomfort.UGDOSynchronisation;
import org.dsi.ifc.carcomfort.UGDOVersionData;
import org.dsi.ifc.carcomfort.UGDOViewOptions;
import org.dsi.ifc.generalvehiclestates.DSIGeneralVehicleStates;
import org.dsi.ifc.generalvehiclestates.DSIGeneralVehicleStatesListener;

public class HsmTargetUGDO
extends AbstractASLTarget
implements CarLogger,
ButtonListContext {
    DSICarComfort dsiCarComfort = (DSICarComfort)ASLUGDOContainer.getInstance().getDSIProxy().getService(this, class$org$dsi$ifc$carcomfort$DSICarComfort == null ? (class$org$dsi$ifc$carcomfort$DSICarComfort = HsmTargetUGDO.class$("org.dsi.ifc.carcomfort.DSICarComfort")) : class$org$dsi$ifc$carcomfort$DSICarComfort);
    DSICarComfortListener dsiCarComfortListener = (DSICarComfortListener)ASLUGDOContainer.getInstance().getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$carcomfort$DSICarComfortListener == null ? (class$org$dsi$ifc$carcomfort$DSICarComfortListener = HsmTargetUGDO.class$("org.dsi.ifc.carcomfort.DSICarComfortListener")) : class$org$dsi$ifc$carcomfort$DSICarComfortListener);
    private DSIGeneralVehicleStates dsiGeneralVehicleState = (DSIGeneralVehicleStates)ASLUGDOContainer.getInstance().getDSIProxy().getService(this, class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates == null ? (class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates = HsmTargetUGDO.class$("org.dsi.ifc.generalvehiclestates.DSIGeneralVehicleStates")) : class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates);
    private DSIGeneralVehicleStatesListener dsiGeneralVehicleStateListener = (DSIGeneralVehicleStatesListener)ASLUGDOContainer.getInstance().getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStatesListener == null ? (class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStatesListener = HsmTargetUGDO.class$("org.dsi.ifc.generalvehiclestates.DSIGeneralVehicleStatesListener")) : class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStatesListener);
    public static final int FUNCTION_ID_UGDO_RENAME;
    public static final int FUNCTION_ID_UGDO_TEACHIN;
    public static final int FUNCTION_ID_UGDO_SYNC;
    public static final int FUNCTION_ID_UGDO_RESET;
    public static final int FUNCTION_ID_UGDO_STANDARD;
    public static final int FUNCTION_ID_UGDO_FIXKITMODE;
    public static final int FUNCTION_ID_UGDO_DEFAULTMODE;
    public UGDOButtonListRA0[] cacheButtonList;
    private ButtonListController buttonListController;
    boolean funcationState = false;
    int functionReason = 0;
    boolean isButtonListAvailable = false;
    boolean processPopUp = false;
    private final int RESTORE_SPEED_THRESHOLD;
    private final int RESTORE_STAND_STILL;
    boolean isStandStillActive = true;
    boolean isSpeedToHighActive = false;
    private int rememberLastValueStandStill = -1;
    private UGDOContent contentAck = new UGDOContent();
    private UGDOContent contentUpdate = new UGDOContent();
    private Speller speller;
    private int currentEditingKey;
    private int currentTeachType;
    static /* synthetic */ Class class$org$dsi$ifc$carcomfort$DSICarComfort;
    static /* synthetic */ Class class$org$dsi$ifc$carcomfort$DSICarComfortListener;
    static /* synthetic */ Class class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates;
    static /* synthetic */ Class class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStatesListener;

    public HsmTargetUGDO(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
        this.RESTORE_SPEED_THRESHOLD = 100;
        this.RESTORE_STAND_STILL = 200;
    }

    @Override
    public int getDefaultTargetId() {
        return -1280960768;
    }

    @Override
    public int getSubClassifier() {
        return 0;
    }

    @Override
    public CarLogger getCarLogger() {
        return this;
    }

    public ButtonListController getButtonListController() {
        if (this.buttonListController == null) {
            this.buttonListController = new ButtonListController(this);
        }
        return this.buttonListController;
    }

    @Override
    public DSICarComfort getCarComfort() {
        return this.dsiCarComfort;
    }

    @Override
    public void buttonListUpdate() {
    }

    void registerToModelEvents() {
        this.addObservers(new int[]{-231593664, -198039232, -399365824, -382588608, -164484800, -500029120, -483251904, -466474688, -365811392, -449697472, -533583552, -265148096, -298702528, -315479744, -281925312, -332256960, -349034176, -248370880, -214816448, -114153152});
    }

    void registerToUGDOButtonListTotalNumberOfElements() {
        this.dsiCarComfort.setNotification(50, (DSIListener)this.dsiCarComfortListener);
    }

    void registerToUGDOButtonListUpdateInfo() {
        this.dsiCarComfort.setNotification(new int[]{49}, (DSIListener)this.dsiCarComfortListener);
    }

    void registerToUGDOContent() {
        this.dsiCarComfort.setNotification(new int[]{31}, (DSIListener)this.dsiCarComfortListener);
    }

    void registerToUGDODestinationReached() {
        this.dsiCarComfort.setNotification(new int[]{51}, (DSIListener)this.dsiCarComfortListener);
    }

    void registerToUGDOlearningData() {
        this.dsiCarComfort.setNotification(new int[]{30}, (DSIListener)this.dsiCarComfortListener);
    }

    void registerToUGDOOpenDoor() {
        this.dsiCarComfort.setNotification(new int[]{52}, (DSIListener)this.dsiCarComfortListener);
    }

    void registerToUGDOVersion() {
        this.dsiCarComfort.setNotification(new int[]{32}, (DSIListener)this.dsiCarComfortListener);
    }

    void registerToUGDOViewOption() {
        this.dsiCarComfort.setNotification(29, (DSIListener)this.dsiCarComfortListener);
    }

    void registerTargetToResponseListerner() {
        DSIProxyFactory.getDSIProxyAPI().getDSIProxy().addResponseListener(this, class$org$dsi$ifc$carcomfort$DSICarComfortListener == null ? (class$org$dsi$ifc$carcomfort$DSICarComfortListener = HsmTargetUGDO.class$("org.dsi.ifc.carcomfort.DSICarComfortListener")) : class$org$dsi$ifc$carcomfort$DSICarComfortListener, this.dsiCarComfortListener);
    }

    void registerToCarVelocityThreshold() {
        this.dsiGeneralVehicleState.setNotification(new int[]{7}, (DSIListener)this.dsiGeneralVehicleStateListener);
    }

    void registerToStandStill() {
        this.dsiGeneralVehicleState.setNotification(new int[]{22}, (DSIListener)this.dsiGeneralVehicleStateListener);
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        if (this.isTraceEnabled()) {
            this.trace().append("Event received CAR SERVICE: ").append(eventGeneric.getReceiverEventId()).log();
        }
        switch (eventGeneric.getReceiverEventId()) {
            case 106: {
                this.dsiCarComfort.setHMIIsReady(true);
                this.initUGDOContainter();
                this.registerToCarVelocityThreshold();
                this.registerToStandStill();
                this.registerToUGDOViewOption();
                this.registerToUGDOVersion();
                this.registerToModelEvents();
                this.registerToUGDOButtonListTotalNumberOfElements();
                this.registerToUGDOButtonListUpdateInfo();
                this.registerToUGDOContent();
                this.registerToUGDOlearningData();
                this.registerToUGDOOpenDoor();
                this.registerTargetToResponseListerner();
                this.fillDPWithDefalutButtonList();
                break;
            }
            case 1076441842: {
                this.dsiCarComfort.setUGDOSynchronisation(new UGDOSynchronisation(7, eventGeneric.getInt(0), 0));
                if (eventGeneric.getInt(1) != 0) break;
                this.dsiCarComfort.cancelUGDOPopup(new UGDOContent(0, 0, 0));
                this.resetUGDOContent(this.contentAck);
                this.resetUGDOContent(this.contentUpdate);
                break;
            }
            case 1076441844: {
                this.dsiCarComfort.abortUGDOLearning();
                break;
            }
            case 1076441850: {
                this.dsiCarComfort.cancelUGDOPopup(new UGDOContent(0, 0, 0));
                break;
            }
            case 1076441827: {
                this.dsiCarComfort.deleteUGDOButton(this.setSoftKeys(eventGeneric.getInt(0)));
                break;
            }
            case 1076441843: {
                if (eventGeneric.getBoolean(0)) {
                    this.dsiCarComfort.setUGDOSynchronisation(new UGDOSynchronisation(6, eventGeneric.getInt(1), 2));
                    break;
                }
                this.dsiCarComfort.setUGDOSynchronisation(new UGDOSynchronisation(6, eventGeneric.getInt(1), 1));
                break;
            }
            case 1076441829: {
                this.dsiCarComfort.setUGDOSynchronisation(new UGDOSynchronisation(0, eventGeneric.getInt(0), 0));
                if (eventGeneric.getInt(1) == 0) break;
                this.dsiCarComfort.cancelUGDOPopup(new UGDOContent(0, 0, 0));
                break;
            }
            case 1076441824: {
                this.currentEditingKey = eventGeneric.getInt(0);
                this.dsiCarComfort.startUGDOLearning(eventGeneric.getInt(1), eventGeneric.getInt(0));
                if (eventGeneric.getInt(1) == 0) break;
                this.dsiCarComfort.cancelUGDOPopup(new UGDOContent(0, 0, 0));
                this.resetUGDOContent(this.contentAck);
                this.resetUGDOContent(this.contentUpdate);
                break;
            }
            case 1076441849: {
                this.currentEditingKey = eventGeneric.getInt(0);
                switch (eventGeneric.getInt(2)) {
                    case 0: {
                        this.dsiCarComfort.startUGDOLearning(eventGeneric.getInt(1), eventGeneric.getInt(0));
                        break;
                    }
                    case 1: {
                        this.currentTeachType = 5;
                        this.getButtonListController().activateFixkitMode(eventGeneric.getInt(0));
                        break;
                    }
                    case 2: {
                        this.currentTeachType = 6;
                        this.getButtonListController().activateDefaultMode(eventGeneric.getInt(0));
                        break;
                    }
                }
                if (eventGeneric.getInt(1) == 0) break;
                this.dsiCarComfort.cancelUGDOPopup(new UGDOContent(0, 0, 0));
                this.resetUGDOContent(this.contentAck);
                this.resetUGDOContent(this.contentUpdate);
                break;
            }
            case 1076441826: {
                this.dsiCarComfort.deleteUGDOButton(this.setSoftKeysDeleteAll());
                break;
            }
            case 1076441841: {
                this.dsiCarComfort.cancelUGDOPopup(new UGDOContent());
                this.resetUGDOContent(this.contentAck);
                this.resetUGDOContent(this.contentUpdate);
                break;
            }
            case 1076441845: {
                break;
            }
            case 1076441832: {
                break;
            }
            case 1076441833: {
                break;
            }
            case 1076441834: {
                break;
            }
            case 1076441846: {
                this.speller = ASLCarFactory.getCarApi().createSpeller(0, -212260608);
                String string = eventGeneric.getString(2);
                if (string == null) {
                    string = "";
                }
                this.speller.setEnteredText(string);
                this.currentEditingKey = eventGeneric.getInt(0);
                break;
            }
            case 1076441835: {
                break;
            }
            case 1076441836: {
                this.speller.deleteCharacter();
                break;
            }
            case 1076441839: {
                break;
            }
            case 1076441837: {
                if (eventGeneric.getString(0) != null) {
                    this.speller.addCharacter(eventGeneric.getString(0));
                    break;
                }
                this.speller.addCharacter("");
                break;
            }
            case 1076441838: {
                this.speller.setCursorPosition(eventGeneric.getInt(0));
                break;
            }
            case 1076441840: {
                String string = this.speller.getEnteredText();
                this.getButtonListController().renameKey(this.currentEditingKey, string);
                break;
            }
        }
    }

    public void dsiCarComfortUpdateUGDOViewOptions(UGDOViewOptions uGDOViewOptions, int n) {
        if (this.isTraceEnabled()) {
            this.trace().append("VIEWOPTIONS: UGDOViewOptions:").append(uGDOViewOptions.toString()).log();
        }
        if (uGDOViewOptions.buttonList.state == 2) {
            this.evaluateViewOptions(uGDOViewOptions.learning.state, 1, uGDOViewOptions.learning.reason);
            this.evaluateViewOptions(uGDOViewOptions.learning.state, 4, uGDOViewOptions.learning.reason);
            this.evaluateViewOptions(uGDOViewOptions.synchronisation.state, 2, uGDOViewOptions.synchronisation.reason);
            this.evaluateViewOptions(uGDOViewOptions.deleteButton.state, 3, uGDOViewOptions.deleteButton.reason);
            if (uGDOViewOptions.learning.state != 2) {
                ASLUGDOContainer.collector[4] = new UgdoFunctionCollector(false, this.ugdoViewOptionsReason(uGDOViewOptions.learning.reason));
            }
            ASLUGDOContainer.functionExistent[0] = uGDOViewOptions.configuration.specialFeatures.doorName;
            ASLUGDOContainer.collector[0] = new UgdoFunctionCollector(uGDOViewOptions.configuration.specialFeatures.doorName, this.ugdoViewOptionsReason(uGDOViewOptions.buttonList.reason));
            ASLUGDOContainer.functionExistent[6] = uGDOViewOptions.configuration.specialFeatures.defaultMode;
            ASLUGDOContainer.collector[6] = new UgdoFunctionCollector(uGDOViewOptions.configuration.specialFeatures.defaultMode, this.ugdoViewOptionsReason(uGDOViewOptions.buttonList.reason));
            ASLUGDOContainer.functionExistent[5] = uGDOViewOptions.configuration.specialFeatures.fixkitMode;
            ASLUGDOContainer.collector[5] = new UgdoFunctionCollector(uGDOViewOptions.configuration.specialFeatures.fixkitMode, this.ugdoViewOptionsReason(uGDOViewOptions.buttonList.reason));
        } else {
            for (int i2 = 0; i2 < ASLUGDOContainer.collector.length; ++i2) {
                this.evaluateViewOptions(uGDOViewOptions.buttonList.state, i2, uGDOViewOptions.buttonList.reason);
            }
            this.sendHMIEvent(-27711232);
        }
        ListManager.getGenericASLList(-78042880).updateList(ASLUGDOContainer.collector);
        HsmTargetUGDO.writeFlagVectorToDatapool(-94820096, ASLUGDOContainer.functionExistent);
    }

    public void dsiCarComfortUpdateUGDOButtonListUpdateInfo(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, int n) {
        this.getButtonListController().getButtonListDsiListener().dsiCarComfortUpdateUGDOButtonListUpdateInfo(uGDOButtonListUpdateInfo, n);
    }

    public void dsiCarComfortUpdateUGDOButtonListTotalNumberOfElements(int n, int n2) {
        this.getButtonListController().getButtonListDsiListener().dsiCarComfortUpdateUGDOButtonListTotalNumberOfElements(n, n2);
    }

    public void dsiCarComfortResponseUGDOButtonListRA0(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, UGDOButtonListRA0[] uGDOButtonListRA0Array) {
        this.getButtonListController().getButtonListDsiListener().dsiCarComfortResponseUGDOButtonListRA0(uGDOButtonListUpdateInfo, uGDOButtonListRA0Array);
        this.isButtonListAvailable = true;
        this.processPopUp = true;
    }

    public void dsiCarComfortResponseUGDOButtonListRA1(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, UGDOButtonListRA1[] uGDOButtonListRA1Array) {
        this.getButtonListController().getButtonListDsiListener().dsiCarComfortResponseUGDOButtonListRA1(uGDOButtonListUpdateInfo, uGDOButtonListRA1Array);
    }

    public void dsiCarComfortResponseUGDOButtonListRA2(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, UGDOButtonListRA2[] uGDOButtonListRA2Array) {
        this.getButtonListController().getButtonListDsiListener().dsiCarComfortResponseUGDOButtonListRA2(uGDOButtonListUpdateInfo, uGDOButtonListRA2Array);
    }

    public void dsiCarComfortResponseUGDOButtonListRA3(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, UGDOButtonListRA3[] uGDOButtonListRA3Array) {
        this.getButtonListController().getButtonListDsiListener().dsiCarComfortResponseUGDOButtonListRA3(uGDOButtonListUpdateInfo, uGDOButtonListRA3Array);
    }

    public void dsiCarComfortResponseUGDOButtonListRA4(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, UGDOButtonListRA4[] uGDOButtonListRA4Array) {
        this.getButtonListController().getButtonListDsiListener().dsiCarComfortResponseUGDOButtonListRA4(uGDOButtonListUpdateInfo, uGDOButtonListRA4Array);
    }

    public void dsiCarComfortResponseUGDOButtonListRA5(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, UGDOButtonListRA5[] uGDOButtonListRA5Array) {
        this.getButtonListController().getButtonListDsiListener().dsiCarComfortResponseUGDOButtonListRA5(uGDOButtonListUpdateInfo, uGDOButtonListRA5Array);
        for (int i2 = 0; i2 < uGDOButtonListRA5Array.length; ++i2) {
            if (uGDOButtonListRA5Array[i2].pos != this.currentEditingKey) continue;
            this.dsiCarComfort.startUGDOLearning(0, uGDOButtonListRA5Array[i2].pos);
            return;
        }
    }

    public void dsiCarComfortResponseUGDOButtonListRAF(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, int[] nArray) {
        this.getButtonListController().getButtonListDsiListener().dsiCarComfortResponseUGDOButtonListRAF(uGDOButtonListUpdateInfo, nArray);
    }

    public void dsiCarComfortAcknowledgeUGDOLearning(int n, int n2) {
        switch (n) {
            case 1: {
                this.sendHMIEvent(-195483392);
                break;
            }
            case 2: {
                this.sendHMIEvent(-212260608);
                break;
            }
            case 244: {
                break;
            }
            case 3: {
                break;
            }
            case 240: 
            case 241: 
            case 242: 
            case 243: {
                this.sendHMIEvent(-178706176);
                break;
            }
            default: {
                this.trace().append("UNKNOWN_UGDO_LEARNING-STATE ").log();
            }
        }
    }

    public void dsiCarComfortAcknowledgeUGDOSynchronisation(UGDOSynchronisation uGDOSynchronisation) {
        switch (uGDOSynchronisation.state) {
            case 3: 
            case 5: 
            case 6: 
            case 7: 
            case 255: {
                break;
            }
            case 0: {
                this.sendHMIEvent(-161928960);
                break;
            }
            case 2: {
                this.sendHMIEvent(-128374528);
                break;
            }
            case 1: {
                this.sendHMIEvent(-145151744);
                break;
            }
            case 4: {
                this.sendHMIEvent(-111597312);
                break;
            }
            default: {
                this.trace().append("UNKNOWN_UGDO_SYNC-STATE ").log();
            }
        }
    }

    public void dsiCarComfortRequestUGDOSynchronisation(UGDOSynchronisation uGDOSynchronisation) {
        switch (uGDOSynchronisation.state) {
            case 0: 
            case 4: 
            case 255: {
                this.dsiCarComfort.responseUGDOSynchronisation(uGDOSynchronisation);
                break;
            }
            case 6: {
                this.sendHMIEvent(-61265664);
                this.dsiCarComfort.responseUGDOSynchronisation(uGDOSynchronisation);
                break;
            }
            case 2: {
                this.sendHMIEvent(-128374528);
                this.dsiCarComfort.responseUGDOSynchronisation(uGDOSynchronisation);
                break;
            }
            case 1: {
                this.sendHMIEvent(-145151744);
                this.dsiCarComfort.responseUGDOSynchronisation(uGDOSynchronisation);
                break;
            }
            case 7: {
                this.sendHMIEvent(-94820096);
                this.dsiCarComfort.responseUGDOSynchronisation(uGDOSynchronisation);
                break;
            }
            case 5: {
                this.sendHMIEvent(-94820096);
                this.dsiCarComfort.responseUGDOSynchronisation(uGDOSynchronisation);
                break;
            }
            case 3: {
                this.sendHMIEvent(-78042880);
                this.dsiCarComfort.responseUGDOSynchronisation(uGDOSynchronisation);
                break;
            }
            default: {
                this.trace().append("UNKNOWN_UGDO_SYNC-STATE ").log();
            }
        }
    }

    public void dsiCarComfortAcknowledgeUGDODeleteButton(boolean bl) {
        if (bl) {
            this.sendHMIEvent(-245815040);
        } else {
            this.sendHMIEvent(-229037824);
        }
    }

    public void dsiCarComfortRequestUGDOPopup(UGDOContent uGDOContent) {
        if (this.processPopUp) {
            if (!this.comparePopContent(uGDOContent, this.contentUpdate)) {
                switch (uGDOContent.content) {
                    case 1: {
                        break;
                    }
                    case 0: {
                        this.dsiCarComfort.cancelUGDOPopup(uGDOContent);
                        break;
                    }
                    case 2: {
                        this.dsiCarComfort.showUGDOPopup(uGDOContent);
                        break;
                    }
                    case 6: {
                        this.dsiCarComfort.showUGDOPopup(uGDOContent);
                        break;
                    }
                    case 3: {
                        this.dsiCarComfort.showUGDOPopup(uGDOContent);
                        break;
                    }
                    case 10: {
                        break;
                    }
                    case 4: {
                        this.dsiCarComfort.showUGDOPopup(uGDOContent);
                        break;
                    }
                    case 9: {
                        break;
                    }
                    case 8: {
                        break;
                    }
                    default: {
                        this.trace().append("UNKNOWN_UGDO_POPUP_REQUEST ").log();
                        break;
                    }
                }
            } else {
                this.trace().append("UGDO_POPUP_REQUEST_SAME_AS_UPDATEUGDOCONTENT ").log();
            }
        } else {
            uGDOContent.content = 0;
            this.dsiCarComfort.showUGDOPopup(uGDOContent);
            this.trace().append("UGDO_POPUP_REQUEST_CANNOT_BE_PROCESSED ").log();
        }
    }

    public void dsiCarComfortUpdateUGDOContent(UGDOContent uGDOContent, int n) {
        this.contentUpdate = uGDOContent;
        if (this.processPopUp) {
            if (!this.comparePopContent(this.contentUpdate, this.contentAck)) {
                switch (uGDOContent.content) {
                    case 1: {
                        break;
                    }
                    case 0: {
                        this.dsiCarComfort.showUGDOPopup(this.contentUpdate);
                        break;
                    }
                    case 2: {
                        this.dsiCarComfort.showUGDOPopup(this.contentUpdate);
                        break;
                    }
                    case 6: {
                        this.dsiCarComfort.showUGDOPopup(this.contentUpdate);
                        break;
                    }
                    case 3: {
                        this.dsiCarComfort.showUGDOPopup(this.contentUpdate);
                        break;
                    }
                    case 10: {
                        break;
                    }
                    case 4: {
                        this.dsiCarComfort.showUGDOPopup(this.contentUpdate);
                        break;
                    }
                    case 9: {
                        break;
                    }
                    case 8: {
                        break;
                    }
                    default: {
                        this.trace().append("UNKNOWN_UGDO_POPUP_UPDATE ").log();
                        break;
                    }
                }
            } else {
                this.trace().append("IGNORED:UGDO_POPUP_UPDATE_SAME_AS_ACK-UGDOCONTENT ").log();
            }
        } else {
            this.contentUpdate.content = 0;
            this.dsiCarComfort.showUGDOPopup(this.contentUpdate);
            this.trace().append("UGDO_POPUP_UPDATE_CANNOT_BE_PROCESSED ").log();
        }
    }

    public void dsiCarComfortAcknowledgeUGDOPopup(UGDOContent uGDOContent) {
        this.contentAck = uGDOContent;
        switch (uGDOContent.content) {
            case 1: {
                break;
            }
            case 0: {
                break;
            }
            case 2: {
                ListManager.getASLList(5908736).updateList(new UGDOSelectedUGDOKeyNrCollector[]{this.fillSelectedUGDOKeyNrCollector(uGDOContent, 0)});
                break;
            }
            case 6: {
                this.sendHMIEvent(-178706176);
                break;
            }
            case 3: {
                ListManager.getASLList(5908736).updateList(new UGDOSelectedUGDOKeyNrCollector[]{this.fillSelectedUGDOKeyNrCollector(uGDOContent, 1)});
                break;
            }
            case 10: {
                break;
            }
            case 4: {
                ListManager.getASLList(5908736).updateList(new UGDOSelectedUGDOKeyNrCollector[]{this.fillSelectedUGDOKeyNrCollector(uGDOContent, 2)});
                break;
            }
            case 9: {
                break;
            }
            case 8: {
                break;
            }
            default: {
                this.trace().append("UNKNOWN_UGDO_POPUP ").log();
            }
        }
    }

    public void dsiCarComfortUpdateUGDOVersionData(UGDOVersionData uGDOVersionData, int n) {
        UGDOVersionInformationCollector uGDOVersionInformationCollector = new UGDOVersionInformationCollector();
        uGDOVersionInformationCollector.ugdo_country_code = uGDOVersionData.countryCode;
        uGDOVersionInformationCollector.ugdo_software_version = uGDOVersionData.version;
        uGDOVersionInformationCollector.ugdo_state = uGDOVersionData.state;
        ListManager.getASLList(-245815040).updateList(new UGDOVersionInformationCollector[]{uGDOVersionInformationCollector});
    }

    public void dsiGeneralVehicleStatesUpdateCarVelocityThreshold(boolean bl, int n) {
        if (this.isTraceEnabled()) {
            this.trace().append("VIEWOPTIONS: Threshold: ").append(bl).log();
        }
        if (this.isTraceEnabled()) {
            this.trace().append("VIEWOPTIONS: car threshold: ").append(bl).log();
        }
        this.evaluateCarFunctionSpeedThreshold(bl);
    }

    public void dsiGeneralVehicleStatesUpdateVehicleStandstill(boolean bl, int n) {
        if (this.isTraceEnabled()) {
            this.trace().append("VIEWOPTIONS: esp data: ").append(bl).log();
        }
        if (this.rememberLastValueStandStill == -1) {
            int n2 = this.rememberLastValueStandStill = bl ? 0 : 1;
            if (this.isTraceEnabled()) {
                this.trace().append("VIEWOPTIONS: car standstill: ").append(bl).log();
            }
            this.evaluateCarFunctionStandStill(bl);
        } else if (this.rememberLastValueStandStill == 0 && !bl) {
            this.rememberLastValueStandStill = 1;
            if (this.isTraceEnabled()) {
                this.trace().append("VIEWOPTIONS: car standstill: ").append(bl).log();
            }
            this.evaluateCarFunctionStandStill(bl);
        } else if (this.rememberLastValueStandStill == 1 && bl) {
            this.rememberLastValueStandStill = 0;
            if (this.isTraceEnabled()) {
                this.trace().append("VIEWOPTIONS: car standstill: ").append(bl).log();
            }
            this.evaluateCarFunctionStandStill(bl);
        } else if (this.isTraceEnabled()) {
            this.trace().append("VIEWOPTIONS: car standstill: same value as previous update ").append(bl).log();
        }
    }

    private void fillDPWithDefalutButtonList() {
        this.cacheButtonList = this.defaultUGDOButtonListRA0();
        UGDOCollector[] uGDOCollectorArray = this.returnUGDOCollector(this.cacheButtonList);
        this.writeButtonListToDataPool(uGDOCollectorArray);
    }

    private UGDOCollector[] returnUGDOCollector(UGDOButtonListRA0[] uGDOButtonListRA0Array) {
        UGDOCollector[] uGDOCollectorArray = new UGDOCollector[uGDOButtonListRA0Array.length];
        for (int i2 = 0; i2 < uGDOCollectorArray.length; ++i2) {
            UGDOButtonListRA0 uGDOButtonListRA0 = uGDOButtonListRA0Array[i2];
            uGDOCollectorArray[i2] = new UGDOCollector(uGDOButtonListRA0.pos, uGDOButtonListRA0.name, uGDOButtonListRA0.positionLatitude, uGDOButtonListRA0.positionLongitude, uGDOButtonListRA0.learnedState, uGDOButtonListRA0.hardkey, uGDOButtonListRA0.softkey, uGDOButtonListRA0.specialFeatures.doorName, uGDOButtonListRA0.specialFeatures.gpsSupervision, uGDOButtonListRA0.specialFeatures.keyFob, uGDOButtonListRA0.specialFeatures.biDirectionalCommunication, HsmTargetUGDO.provideNameState(uGDOButtonListRA0.name, uGDOButtonListRA0.learnedState));
        }
        return uGDOCollectorArray;
    }

    private void writeButtonListToDataPool(UGDOCollector[] uGDOCollectorArray) {
        ListManager.getGenericASLList(-229037824).updateList(uGDOCollectorArray);
    }

    private UGDOButtonListRA0[] defaultUGDOButtonListRA0() {
        UGDOButtonListRA0[] uGDOButtonListRA0Array = new UGDOButtonListRA0[]{new UGDOButtonListRA0(), new UGDOButtonListRA0(), new UGDOButtonListRA0()};
        for (int i2 = 0; i2 < uGDOButtonListRA0Array.length; ++i2) {
            uGDOButtonListRA0Array[i2].hardkey = i2 + 1;
            uGDOButtonListRA0Array[i2].softkey = i2 + 1;
            uGDOButtonListRA0Array[i2].specialFeatures = new UGDOSpecialFeatures();
        }
        return uGDOButtonListRA0Array;
    }

    private void initUGDOContainter() {
        int n;
        for (n = ASLUGDOContainer.collector.length - 1; n >= 0; --n) {
            ASLUGDOContainer.collector[n] = new UgdoFunctionCollector(false, 6);
        }
        for (n = ASLUGDOContainer.functionExistent.length - 1; n >= 0; --n) {
            ASLUGDOContainer.functionExistent[n] = false;
        }
        for (n = ASLUGDOContainer.getInstance().getMenuCodingLength() - 1; n >= 0; --n) {
            ASLUGDOContainer.getInstance().setMenuCoding(n, false);
        }
    }

    public static int provideNameState(String string, int n) {
        int n2 = 0;
        switch (n) {
            case 0: {
                n2 = 0;
                break;
            }
            case 1: 
            case 2: 
            case 3: 
            case 4: 
            case 5: 
            case 6: {
                if (string.endsWith("")) {
                    n2 = 1;
                    break;
                }
                n2 = 2;
                break;
            }
        }
        return n2;
    }

    private UGDOSoftkeys setSoftKeys(int n) {
        UGDOSoftkeys uGDOSoftkeys = new UGDOSoftkeys();
        switch (n) {
            case 1: {
                uGDOSoftkeys.softkey1 = true;
                break;
            }
            case 2: {
                uGDOSoftkeys.softkey2 = true;
                break;
            }
            case 3: {
                uGDOSoftkeys.softkey3 = true;
                break;
            }
        }
        return uGDOSoftkeys;
    }

    private UGDOSoftkeys setSoftKeysDeleteAll() {
        return new UGDOSoftkeys(true, true, true, true, true, true, true, true, true, true, true, true, true, true, true);
    }

    private boolean comparePopContent(UGDOContent uGDOContent, UGDOContent uGDOContent2) {
        boolean bl = false;
        if (uGDOContent.content == uGDOContent2.content && uGDOContent.hardkey == uGDOContent2.hardkey && uGDOContent.softkey == uGDOContent2.softkey) {
            bl = true;
        }
        return bl;
    }

    private UGDOSelectedUGDOKeyNrCollector fillSelectedUGDOKeyNrCollector(UGDOContent uGDOContent, int n) {
        UGDOSelectedUGDOKeyNrCollector uGDOSelectedUGDOKeyNrCollector = new UGDOSelectedUGDOKeyNrCollector();
        uGDOSelectedUGDOKeyNrCollector.ugdo_hard_key_nr = uGDOContent.hardkey;
        uGDOSelectedUGDOKeyNrCollector.ugdo_soft_key_nr = uGDOContent.softkey;
        uGDOSelectedUGDOKeyNrCollector.ugdo_ugdo_selected_hardkey_learned_state = n;
        return uGDOSelectedUGDOKeyNrCollector;
    }

    private void resetUGDOContent(UGDOContent uGDOContent) {
        uGDOContent.content = 0;
        uGDOContent.hardkey = 0;
        uGDOContent.softkey = 0;
    }

    private void evaluateViewOptions(int n, int n2, int n3) {
        if (n == 0) {
            ASLUGDOContainer.functionExistent[n2] = false;
        } else {
            if (!ASLUGDOContainer.functionExistent[n2]) {
                ASLUGDOContainer.functionExistent[n2] = true;
            }
            if (ASLUGDOContainer.collector[n2].functionReason == 7 || ASLUGDOContainer.collector[n2].functionReason == 3) {
                if (n != 2) {
                    ASLUGDOContainer.collector[n2] = new UgdoFunctionCollector(n == 2, this.ugdoViewOptionsReason(n3));
                } else if (this.isStandStillActive && !this.isSpeedToHighActive) {
                    ASLUGDOContainer.collector[n2] = new UgdoFunctionCollector(n == 2, this.ugdoViewOptionsReason(n3));
                }
            } else {
                ASLUGDOContainer.collector[n2] = new UgdoFunctionCollector(n == 2, this.ugdoViewOptionsReason(n3));
                if (this.isStandStillActive) {
                    this.evaluateCarFunctionStandStill(this.isStandStillActive);
                }
                if (this.isSpeedToHighActive) {
                    this.evaluateCarFunctionSpeedThreshold(this.isSpeedToHighActive);
                }
            }
        }
    }

    int ugdoViewOptionsReason(int n) {
        switch (n) {
            case 1: {
                this.functionReason = 1;
                break;
            }
            case 3: {
                this.functionReason = 3;
                break;
            }
            case 2: {
                this.functionReason = 2;
                break;
            }
            case 4: {
                this.functionReason = 4;
                break;
            }
            case 8: {
                this.functionReason = 5;
                break;
            }
            case 13: {
                this.functionReason = 7;
                break;
            }
            default: {
                this.functionReason = 6;
            }
        }
        return this.functionReason;
    }

    protected void evaluateCarFunctionStandStill(boolean bl) {
        this.isStandStillActive = bl;
        if (!bl) {
            this.fillHmiList(ASLUGDOContainer.getInstance().getMenuStandStill(), 7);
        } else {
            for (int i2 = ASLUGDOContainer.getInstance().getMenuStandStill().length - 1; i2 >= 0; --i2) {
                if (!ASLUGDOContainer.getInstance().getMenuStandStill()[i2] || !ASLUGDOContainer.getInstance().isMenuCoded(i2)) continue;
                this.overwriteViewOptions(i2, 200);
            }
        }
    }

    void evaluateCarFunctionSpeedThreshold(boolean bl) {
        this.isSpeedToHighActive = bl;
        if (bl) {
            this.fillHmiList(ASLUGDOContainer.getInstance().getMenuSpeedThreshold(), 3);
        } else {
            for (int i2 = ASLUGDOContainer.getInstance().getMenuSpeedThreshold().length - 1; i2 >= 0; --i2) {
                if (!ASLUGDOContainer.getInstance().getMenuSpeedThreshold()[i2] || !ASLUGDOContainer.getInstance().isMenuCoded(i2)) continue;
                this.overwriteViewOptions(i2, 100);
            }
        }
    }

    private void fillHmiList(boolean[] blArray, int n) {
        for (int i2 = blArray.length - 1; i2 >= 0; --i2) {
            if (!blArray[i2] || !ASLUGDOContainer.getInstance().isMenuCoded(i2)) continue;
            this.overwriteViewOptions(i2, n);
        }
    }

    private void overwriteViewOptions(int n, int n2) {
        switch (n2) {
            case 100: {
                if (ASLUGDOContainer.collector[n].functionAvailable || ASLUGDOContainer.collector[n].functionReason != 3) break;
                ASLUGDOContainer.collector[n].functionAvailable = true;
                ASLUGDOContainer.collector[n].functionReason = 0;
                break;
            }
            case 200: {
                if (ASLUGDOContainer.collector[n].functionAvailable || ASLUGDOContainer.collector[n].functionReason != 7) break;
                ASLUGDOContainer.collector[n].functionAvailable = true;
                ASLUGDOContainer.collector[n].functionReason = 0;
                break;
            }
            default: {
                if (!ASLUGDOContainer.collector[n].functionAvailable) break;
                ASLUGDOContainer.collector[n].functionAvailable = false;
                ASLUGDOContainer.collector[n].functionReason = n2;
            }
        }
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

