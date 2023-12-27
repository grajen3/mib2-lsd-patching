/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.ocu.control;

import de.vw.mib.asl.api.ocu.onlineupdatev10.OnlineUpdateService;
import de.vw.mib.asl.api.ocu.onlineupdatev10.data.OnlineUpdateChallengeData;
import de.vw.mib.asl.api.ocu.onlineupdatev10.data.OnlineUpdateChallengeList;
import de.vw.mib.asl.api.ocu.onlineupdatev10.data.OnlineUpdateList;
import de.vw.mib.asl.api.ocu.onlineupdatev10.data.OnlineUpdateListEntry;
import de.vw.mib.asl.api.ocu.onlineupdatev10.data.OnlineUpdateState;
import de.vw.mib.asl.api.online.ASLOnlineFactory;
import de.vw.mib.asl.api.online.services.authenticate.OnlineAuthenticationListenerAdapter;
import de.vw.mib.asl.internal.online.ocu.OCUUpdateServiceFactory;
import de.vw.mib.asl.internal.online.ocu.common.OCUUpdateService;
import de.vw.mib.asl.internal.online.ocu.control.OCUUpdateServiceController$1;
import de.vw.mib.asl.internal.online.ocu.control.OCUUpdateServiceController$2;
import de.vw.mib.asl.internal.online.ocu.states.OCUUpdateServiceTarget;
import de.vw.mib.collections.ints.IntArrayList;
import de.vw.mib.util.Util;
import edu.emory.mathcs.backport.java.util.Arrays;
import java.util.Iterator;

public class OCUUpdateServiceController
extends OnlineAuthenticationListenerAdapter {
    private final String _classname = super.getClass().getName();
    private final OCUUpdateServiceTarget _target;
    private OCUUpdateService _currentService;
    private String _vinNumber;
    private int _state = 0;
    private OCUUpdateService[] _pendingServiecList;
    private boolean _clamp15Status;
    private int _spinCounter;
    private IntArrayList _shownPopups;
    private IntArrayList _clampOffPopups;
    private Thread _spinHashCalculationThread;

    public OCUUpdateServiceController(OCUUpdateServiceTarget oCUUpdateServiceTarget) {
        this._target = oCUUpdateServiceTarget;
    }

    private IntArrayList getClampOnPopups() {
        if (this._shownPopups == null) {
            this._shownPopups = new IntArrayList();
        }
        return this._shownPopups;
    }

    private IntArrayList getClampOffPopups() {
        if (this._clampOffPopups == null) {
            this._clampOffPopups = new IntArrayList();
        }
        return this._clampOffPopups;
    }

    private void notifyChange() {
        if (this._target.isTraceEnabled()) {
            this._target.trace().append(this._classname).append(".notifyChange( )").log();
        }
        if (!this.checkIfPopupAlreadyShowninClampCycle(this._state)) {
            OCUUpdateServiceFactory.getModelHandler().sendOCUUpdateInfo(this._currentService);
            OCUUpdateServiceFactory.getModelHandler().sendOCUUpdateServiceState(this._state);
        }
        this._currentService.setServiceInfoChanged(false);
        this.addPopupToList(this._state);
    }

    private boolean checkIfPopupAlreadyShowninClampCycle(int n) {
        return this._clamp15Status ? this.getClampOnPopups().contains(n) : this.getClampOffPopups().contains(n);
    }

    private void addPopupToList(int n) {
        switch (n) {
            case 1: 
            case 2: 
            case 3: {
                if (!this._clamp15Status) break;
                this.getClampOnPopups().add(n);
                break;
            }
            case 9: {
                if (this._clamp15Status) break;
                this.getClampOffPopups().add(n);
                break;
            }
        }
    }

    private void extractServiceEntries(OnlineUpdateList onlineUpdateList) {
        if (this._target.isTraceEnabled()) {
            this._target.trace().append(this._classname).append(".extractServiceEntries( )").log();
        }
        if (onlineUpdateList != null && !onlineUpdateList.getListData().isEmpty()) {
            Iterator iterator = onlineUpdateList.getListData().iterator();
            while (iterator.hasNext()) {
                OnlineUpdateListEntry onlineUpdateListEntry = (OnlineUpdateListEntry)iterator.next();
                if (this._currentService == null || onlineUpdateListEntry.getUpdateId().equalsIgnoreCase(this._currentService.getUpdateID())) {
                    this._currentService = this.fillServiceInfo(null, onlineUpdateListEntry, null, 2, this._currentService);
                    continue;
                }
                if (Util.isNullOrEmpty(this._pendingServiecList)) {
                    this._pendingServiecList = new OCUUpdateService[1];
                    this._pendingServiecList[0] = this.fillServiceInfo(null, onlineUpdateListEntry, null, 2, this._pendingServiecList[0]);
                    continue;
                }
                this._pendingServiecList = (OCUUpdateService[])Arrays.copyOf(this._pendingServiecList, this._pendingServiecList.length + 1);
                this._pendingServiecList[this._pendingServiecList.length - 1] = this.fillServiceInfo(null, onlineUpdateListEntry, null, 2, this._pendingServiecList[this._pendingServiecList.length - 1]);
            }
        }
    }

    private OCUUpdateService fillServiceInfo(OnlineUpdateState onlineUpdateState, OnlineUpdateListEntry onlineUpdateListEntry, OnlineUpdateChallengeData onlineUpdateChallengeData, int n, OCUUpdateService oCUUpdateService) {
        if (oCUUpdateService == null) {
            oCUUpdateService = new OCUUpdateService();
            oCUUpdateService.setUserName(ASLOnlineFactory.getAuthenticationService().getMainUserEnrolled());
            oCUUpdateService.setVINNumber(this._vinNumber);
        }
        switch (n) {
            case 1: {
                oCUUpdateService.setUpdateID(onlineUpdateState.getUpdateId());
                oCUUpdateService.setUpdateState(onlineUpdateState.getUpdateState().value());
                oCUUpdateService.setUpdateProgress(onlineUpdateState.getProgress());
                break;
            }
            case 2: {
                oCUUpdateService.setUpdateID(onlineUpdateListEntry.getUpdateId());
                oCUUpdateService.setEstimatedDuration(onlineUpdateListEntry.getEstimatedUpdateDuration() > 0 ? onlineUpdateListEntry.getEstimatedUpdateDuration() / 60 : onlineUpdateListEntry.getEstimatedUpdateDuration());
                oCUUpdateService.setDownloadSize(onlineUpdateListEntry.getDownloadSize());
                oCUUpdateService.setDescription(onlineUpdateListEntry.getUpdateDescription());
                break;
            }
            case 3: {
                oCUUpdateService.addChallengeData(onlineUpdateChallengeData.getChallengeType(), onlineUpdateChallengeData.getChallenge());
                break;
            }
        }
        return oCUUpdateService;
    }

    private void handleRemoteServiceUpdate() {
        if (this._target.isTraceEnabled()) {
            this._target.trace().append(this._classname).append(".handleRemoteServiceUpdate()").log();
        }
        if (this._currentService.isServiceInfoChanged()) {
            if (this._target.isTraceEnabled()) {
                this._target.trace().append(this._classname).append(new StringBuffer().append(".handleRemoteServiceUpdate(").append(this._currentService.toString()).append(")").toString()).log();
            }
            if (!Util.isNullOrEmpty(this._currentService.getUserName())) {
                this._currentService.setUserName(ASLOnlineFactory.getAuthenticationService().getMainUserEnrolled());
                this._currentService.setVINNumber(this._vinNumber);
            }
            if (this._clamp15Status) {
                switch (this._currentService.getUpdateState()) {
                    case 1: {
                        if (this._spinCounter >= 1) {
                            this.setState(14);
                            break;
                        }
                        this.setState(13);
                        ++this._spinCounter;
                        break;
                    }
                    case 2: {
                        this.setState(12);
                        break;
                    }
                    case 3: {
                        this.setState(11);
                        break;
                    }
                    case 4: {
                        if (Util.isNullOrEmpty(this._currentService.getUserName())) {
                            this.checkIfICEIsAvailable();
                            break;
                        }
                        this.setState(1);
                        break;
                    }
                    case 5: {
                        this.setState(5);
                        break;
                    }
                    case 7: {
                        this.setState(7);
                        break;
                    }
                    case 9: {
                        this.setState(7);
                        break;
                    }
                    case 10: {
                        this._state = 109;
                        break;
                    }
                    case 11: {
                        break;
                    }
                    case 13: {
                        this.setState(6);
                        break;
                    }
                    case 15: {
                        this.setState(8);
                        break;
                    }
                    case 16: {
                        this._state = 110;
                        break;
                    }
                }
            } else {
                switch (this._currentService.getUpdateState()) {
                    case 7: {
                        this.setState(7);
                        break;
                    }
                    case 9: {
                        this.setState(7);
                        break;
                    }
                    case 10: {
                        this.setState(9);
                        break;
                    }
                    case 11: {
                        break;
                    }
                    case 13: {
                        this.setState(6);
                        break;
                    }
                    case 15: {
                        this.setState(108);
                        break;
                    }
                }
            }
        }
    }

    private void callShowPopups(int n) {
        if (this._target.isTraceEnabled()) {
            this._target.trace().append(this._classname).append(new StringBuffer().append(".callShowPopups(").append(n).append(")").toString()).log();
        }
        int n2 = 0;
        switch (n) {
            case 101: {
                n2 = 1;
                break;
            }
            case 102: {
                n2 = 2;
                break;
            }
            case 103: {
                n2 = 3;
                break;
            }
            case 104: {
                n2 = 4;
                break;
            }
            case 105: {
                n2 = 5;
                break;
            }
            case 106: {
                n2 = 6;
                break;
            }
            case 107: {
                n2 = 7;
                break;
            }
            case 108: {
                n2 = 8;
                break;
            }
            case 9: {
                n2 = 109;
                OCUUpdateServiceFactory.getServiceHandler(this._target).sendUpdateServiceStatus(4, this.getCurrentService());
                break;
            }
            case 10: 
            case 110: {
                n2 = 110;
                break;
            }
            case 111: {
                n2 = 11;
                break;
            }
            case 112: {
                n2 = 12;
                break;
            }
            case 113: {
                n2 = 13;
                break;
            }
            case 114: {
                n2 = 14;
                break;
            }
            case 115: {
                n2 = 15;
                break;
            }
        }
        this.setState(n2);
    }

    private void callHidePopups(int n) {
        if (this._target.isTraceEnabled()) {
            this._target.trace().append(this._classname).append(new StringBuffer().append(".callHidePopups(").append(n).append(")").toString()).log();
        }
        int n2 = 0;
        switch (n) {
            case 1: {
                n2 = 101;
                break;
            }
            case 2: {
                n2 = 102;
                break;
            }
            case 3: {
                n2 = 103;
                break;
            }
            case 4: {
                n2 = 104;
                break;
            }
            case 5: {
                n2 = 105;
                break;
            }
            case 6: {
                n2 = 106;
                break;
            }
            case 7: {
                n2 = 107;
                break;
            }
            case 8: {
                n2 = 108;
                break;
            }
            case 9: 
            case 109: {
                n2 = 9;
                break;
            }
            case 10: 
            case 110: {
                n2 = 10;
                break;
            }
            case 11: {
                n2 = 111;
                break;
            }
            case 12: {
                n2 = 112;
                break;
            }
            case 13: {
                n2 = 113;
                break;
            }
            case 14: {
                n2 = 114;
                break;
            }
            case 15: {
                n2 = 115;
                break;
            }
        }
        this.setState(n2);
    }

    private void checkIfICEIsAvailable() {
        if (this._target.isTraceEnabled()) {
            this._target.trace().append(this._classname).append(".checkIfICEIsAvailable()").log();
        }
        ASLOnlineFactory.getOnlineCoreServices().checkOnlineServiceStatus(ASLOnlineFactory.getOnlineCoreServices().getServiceIDWithNumericServiceID(44), new OCUUpdateServiceController$1(this));
    }

    private void checkAndClosePopupIfOpen(int n, int n2) {
        if (this._target.isTraceEnabled()) {
            this._target.trace().append(this._classname).append(new StringBuffer().append(".checkAndClosePopupIfOpen( currentState = ").append(n).append(", previousState = ").append(n2).append(")").toString()).log();
        }
        if (!this.checkIfPopupAlreadyShowninClampCycle(n) && n2 > 0 && n < 100 && n2 < 100) {
            int n3 = 0;
            switch (n2) {
                case 1: {
                    n3 = 101;
                    break;
                }
                case 2: {
                    n3 = 102;
                    break;
                }
                case 3: {
                    n3 = 103;
                    break;
                }
                case 4: {
                    n3 = 104;
                    break;
                }
                case 5: {
                    n3 = 105;
                    break;
                }
                case 6: {
                    n3 = 106;
                    break;
                }
                case 7: {
                    n3 = 107;
                    break;
                }
                case 8: {
                    n3 = 108;
                    break;
                }
                case 9: {
                    n3 = 9;
                    this.notifyChange();
                    break;
                }
                case 10: {
                    n3 = 10;
                    this.notifyChange();
                    break;
                }
                case 11: {
                    n3 = 111;
                    break;
                }
                case 12: {
                    n3 = 112;
                    break;
                }
                case 13: {
                    n3 = 113;
                    break;
                }
                case 14: {
                    n3 = 114;
                    break;
                }
                case 15: {
                    n3 = 115;
                    break;
                }
            }
            if (n3 != 0) {
                OCUUpdateServiceFactory.getModelHandler().sendOCUUpdateServiceState(n3);
            }
        }
    }

    private void resetState() {
        switch (this._state) {
            case 15: 
            case 115: {
                this._state = 101;
                break;
            }
        }
    }

    public void updateOCURemoteService(OnlineUpdateService onlineUpdateService, OnlineUpdateState onlineUpdateState, OnlineUpdateList onlineUpdateList) {
        if (this._target.isTraceEnabled()) {
            this._target.trace().append(this._classname).append(".updateOCURemoteService( )").log();
        }
        if (onlineUpdateState != null && onlineUpdateState.getUpdateState().value() == 0) {
            if (this._currentService != null) {
                this._currentService.clearAll();
            }
            this._currentService = null;
            this._state = 0;
            return;
        }
        if (onlineUpdateList != null || onlineUpdateService.getOnlineUpdateList() != null) {
            this.extractServiceEntries(onlineUpdateService.getOnlineUpdateList());
        }
        if (onlineUpdateState != null) {
            this._currentService = this.fillServiceInfo(onlineUpdateState, null, null, 1, this._currentService);
            this.handleRemoteServiceUpdate();
        }
    }

    public void updateChallengeData(OnlineUpdateChallengeList onlineUpdateChallengeList) {
        if (this._target.isTraceEnabled()) {
            this._target.trace().append(this._classname).append(".updateChallengeData( )").log();
        }
        if (onlineUpdateChallengeList != null && this._currentService != null) {
            this._currentService.setHashProcedureVersion(onlineUpdateChallengeList.getHashProcedureVersion());
            Iterator iterator = onlineUpdateChallengeList.getListData().iterator();
            this._target.info().append(this._classname).append(new StringBuffer().append(".updateChallengeData( ) --> List elements = ").append(onlineUpdateChallengeList.getListData().size()).toString()).log();
            while (iterator.hasNext()) {
                OnlineUpdateChallengeData onlineUpdateChallengeData = (OnlineUpdateChallengeData)iterator.next();
                if (onlineUpdateChallengeData == null) continue;
                this._currentService = this.fillServiceInfo(null, null, onlineUpdateChallengeData, 3, this._currentService);
            }
            if (!Util.isNullOrEmpty(this.getCurrentService().getChallengeDataWithType(1)) && !Util.isNullOrEmpty(this.getCurrentService().getChallengeDataWithType(0))) {
                ASLOnlineFactory.getAuthenticationService().calculateSpinHash(ASLOnlineFactory.getOnlineCoreServices().getServiceIDWithNumericServiceID(51), this.getCurrentService().getSPinNumeric(), this.getCurrentService().getChallengeDataWithType(0), this.getCurrentService().getChallengeDataWithType(1), this.getCurrentService().getHashProcedureVersion(), this);
            } else {
                this._target.info().append(this._classname).append(".updateChallengeData( ) --> Either User or Session challenge are invalid ").log();
            }
        }
    }

    public void onClampStatus(boolean bl) {
        if (this._target.isTraceEnabled()) {
            this._target.trace().append(this._classname).append(new StringBuffer().append(".onClampStatus( ").append(bl).append(")").toString()).log();
        }
        this._clamp15Status = bl;
        if (this._currentService != null) {
            if (this._clamp15Status) {
                this.callShowPopups(this._state);
                this.getClampOffPopups().clear();
            } else {
                if (this._spinHashCalculationThread != null && this._spinHashCalculationThread.isAlive()) {
                    this._spinHashCalculationThread.interrupt();
                    this._spinHashCalculationThread = null;
                }
                this.callHidePopups(this._state);
                this.getClampOnPopups().clear();
                this.resetState();
                this._spinCounter = 0;
            }
        }
    }

    public void onResetFactorySettings() {
        if (this._target.isTraceEnabled()) {
            this._target.trace().append(this._classname).append(".onResetFactorySettings( )").log();
        }
        if (this._currentService != null && this._state == 1) {
            this.callHidePopups(this._state);
            this.checkIfICEIsAvailable();
        }
    }

    public void setNumericSPin(String string) {
        if (this._target.isTraceEnabled()) {
            this._target.trace().append(this._classname).append(new StringBuffer().append(".setNumericSPin( ").append(Util.isNullOrEmpty(string) ? "" : string).append(")").toString()).log();
        }
        if (this.getCurrentService() != null) {
            this.getCurrentService().setSPinNumeric(string);
            OCUUpdateServiceFactory.getServiceHandler(this._target).requestChallenge();
        } else if (this._target.isTraceEnabled()) {
            this._target.trace().append(this._classname).append(".setNumericSPin( )--> Current service is NULL").log();
        }
    }

    public OCUUpdateService getCurrentService() {
        return this._currentService;
    }

    public void setVINNumber(String string) {
        this._vinNumber = string;
        if (this._currentService != null) {
            this._currentService.setVINNumber(this._vinNumber);
        }
    }

    public void setState(int n) {
        if (this._target.isTraceEnabled()) {
            this._target.trace().append(this._classname).append(new StringBuffer().append(".setState( New State = ").append(n).append(" ExistingState = ").append(this._state).append(")").toString()).log();
        }
        if (this._state != n) {
            this.checkAndClosePopupIfOpen(n, this._state);
            this._state = n;
            this.notifyChange();
        }
    }

    @Override
    public void updateMainUserEnrolled(boolean bl, String string) {
        if (this._currentService != null) {
            if (!bl) {
                this.onResetFactorySettings();
            } else {
                this._currentService.setUserName(string);
            }
        }
    }

    @Override
    public void updateSpinHashResult(String string, int n) {
        if (this._target.isTraceEnabled()) {
            this._target.trace().append(this._classname).append(new StringBuffer().append(".updateSpinHashResult( Result = ").append(n).append(")").toString()).log();
        }
        if (n == 2) {
            this._spinHashCalculationThread = new Thread(new OCUUpdateServiceController$2(this), "Spin Thread");
            this._spinHashCalculationThread.setPriority(5);
            this._spinHashCalculationThread.start();
        } else if (n == 0) {
            OCUUpdateServiceFactory.getServiceHandler(this._target).sendForUpdateServiceAuthentication(string);
        } else {
            this._target.info().append(this._classname).append(".updateSpinHashResult()->result failure").log();
            this.callHidePopups(this._state);
            this.setState(11);
        }
    }

    @Override
    public void updateSpinRequired(String string) {
    }

    @Override
    public void setSPinResponse(String string, int n) {
    }

    public void postponeOnlineDownloadResponse(OnlineUpdateService onlineUpdateService, int n) {
        if (n != 0) {
            // empty if block
        }
    }

    public void confirmOnlineDownloadErrorResponse(OnlineUpdateService onlineUpdateService, int n) {
        if (n != 0) {
            // empty if block
        }
    }

    public void postponeUpdateInstallationResponse(OnlineUpdateService onlineUpdateService, int n) {
        if (n != 0) {
            // empty if block
        }
    }

    public void confirmUpdateInstallationResponse(OnlineUpdateService onlineUpdateService, int n) {
        if (n != 0) {
            // empty if block
        }
    }

    public void confirmErrorResponse(OnlineUpdateService onlineUpdateService, int n) {
        if (n != 0) {
            // empty if block
        }
    }

    public void authenticateOnlineDownloadResponse(OnlineUpdateService onlineUpdateService, int n) {
        if (this._spinHashCalculationThread != null && this._spinHashCalculationThread.isAlive()) {
            this._spinHashCalculationThread.interrupt();
        }
        this._spinHashCalculationThread = null;
        if (n != 0) {
            // empty if block
        }
    }

    public void confirmInstallationFinishedResponse(OnlineUpdateService onlineUpdateService, int n) {
        if (n != 0) {
            // empty if block
        }
    }

    public void confirmUpdateWithdrawnResponse(OnlineUpdateService onlineUpdateService, int n) {
        if (n != 0) {
            this._currentService = null;
            this._state = 0;
        }
    }

    public void requestChallengeResponse(OnlineUpdateService onlineUpdateService, int n) {
        if (n == 1 && this._currentService != null) {
            this._target.info().append(this._classname).append(".updateChallengeData()->challenge failed").log();
            this.callHidePopups(this._state);
            this.setState(11);
        }
    }

    static /* synthetic */ OCUUpdateServiceTarget access$000(OCUUpdateServiceController oCUUpdateServiceController) {
        return oCUUpdateServiceController._target;
    }

    static /* synthetic */ int access$100(OCUUpdateServiceController oCUUpdateServiceController) {
        return oCUUpdateServiceController._state;
    }

    static /* synthetic */ void access$200(OCUUpdateServiceController oCUUpdateServiceController, int n) {
        oCUUpdateServiceController.callHidePopups(n);
    }

    static /* synthetic */ String access$300(OCUUpdateServiceController oCUUpdateServiceController) {
        return oCUUpdateServiceController._classname;
    }
}

