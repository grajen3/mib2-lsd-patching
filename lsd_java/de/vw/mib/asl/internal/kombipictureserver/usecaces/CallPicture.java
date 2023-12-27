/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.kombipictureserver.usecaces;

import de.vw.mib.asl.internal.kombipictureserver.common.api.bap.telephone.BapTelephoneCallInfo;
import de.vw.mib.asl.internal.kombipictureserver.common.api.bap.telephone.BapTelephoneDelegate;
import de.vw.mib.asl.internal.kombipictureserver.common.api.bap.telephone.BapTelephoneService;
import de.vw.mib.asl.internal.kombipictureserver.common.api.phone.asl.PhoneCallDelegate;
import de.vw.mib.asl.internal.kombipictureserver.common.api.phone.asl.PhoneCallInfo;
import de.vw.mib.asl.internal.kombipictureserver.common.api.phone.asl.PhoneCallService;
import de.vw.mib.asl.internal.kombipictureserver.usecaces.CallPicture$CallPictureData;
import de.vw.mib.asl.internal.kombipictureserver.usecaces.PictureServerUseCase;
import java.util.ArrayList;
import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.kombipictureserver.DSIKombiPictureServer;

public class CallPicture
extends PictureServerUseCase
implements PhoneCallDelegate,
BapTelephoneDelegate {
    private DSIKombiPictureServer _kombiPictureServer;
    private DSIListener _kombiPictureServerServiceResponder;
    private static final int KOMBI_PICTURE_SERVER_INVALID_CALL_ID;
    private static final int KOMBI_PICTURE_SERVER_NO_CALLS_CALL_ID;
    private PhoneCallService _phoneCallService;
    private static final int[] PHONE_CALL_SERVICE_SERVICES;
    private BapTelephoneService _bapTelephoneService;
    private static final int[] BAP_TELEPHONE_SERVICE_SERVICES;
    private ArrayList _lastCallPictureData;
    static /* synthetic */ Class class$org$dsi$ifc$kombipictureserver$DSIKombiPictureServer;
    static /* synthetic */ Class class$org$dsi$ifc$kombipictureserver$DSIKombiPictureServerListener;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$kombipictureserver$common$api$phone$asl$PhoneCallService;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$kombipictureserver$common$api$bap$telephone$BapTelephoneService;

    private DSIKombiPictureServer getKombiPictureServer() {
        if (this._kombiPictureServer == null) {
            this._kombiPictureServer = (DSIKombiPictureServer)this.getCategoryDelegate().getDsiService(this, class$org$dsi$ifc$kombipictureserver$DSIKombiPictureServer == null ? (class$org$dsi$ifc$kombipictureserver$DSIKombiPictureServer = CallPicture.class$("org.dsi.ifc.kombipictureserver.DSIKombiPictureServer")) : class$org$dsi$ifc$kombipictureserver$DSIKombiPictureServer);
            this._kombiPictureServerServiceResponder = this.getCategoryDelegate().addDsiServiceResponder(this, (DSIBase)this._kombiPictureServer, class$org$dsi$ifc$kombipictureserver$DSIKombiPictureServerListener == null ? (class$org$dsi$ifc$kombipictureserver$DSIKombiPictureServerListener = CallPicture.class$("org.dsi.ifc.kombipictureserver.DSIKombiPictureServerListener")) : class$org$dsi$ifc$kombipictureserver$DSIKombiPictureServerListener, null);
        }
        return this._kombiPictureServer;
    }

    private DSIListener getKombiPictureServerServiceResponder() {
        return this._kombiPictureServerServiceResponder;
    }

    private PhoneCallService getPhoneCallService() {
        if (this._phoneCallService == null) {
            this._phoneCallService = (PhoneCallService)this.getCategoryDelegate().getService(this, class$de$vw$mib$asl$internal$kombipictureserver$common$api$phone$asl$PhoneCallService == null ? (class$de$vw$mib$asl$internal$kombipictureserver$common$api$phone$asl$PhoneCallService = CallPicture.class$("de.vw.mib.asl.internal.kombipictureserver.common.api.phone.asl.PhoneCallService")) : class$de$vw$mib$asl$internal$kombipictureserver$common$api$phone$asl$PhoneCallService);
            this.getCategoryDelegate().registerServiceListener(this, class$de$vw$mib$asl$internal$kombipictureserver$common$api$phone$asl$PhoneCallService == null ? (class$de$vw$mib$asl$internal$kombipictureserver$common$api$phone$asl$PhoneCallService = CallPicture.class$("de.vw.mib.asl.internal.kombipictureserver.common.api.phone.asl.PhoneCallService")) : class$de$vw$mib$asl$internal$kombipictureserver$common$api$phone$asl$PhoneCallService, PHONE_CALL_SERVICE_SERVICES);
        }
        return this._phoneCallService;
    }

    private BapTelephoneService getBapTelephoneService() {
        if (this._bapTelephoneService == null) {
            this._bapTelephoneService = (BapTelephoneService)this.getCategoryDelegate().getService(this, class$de$vw$mib$asl$internal$kombipictureserver$common$api$bap$telephone$BapTelephoneService == null ? (class$de$vw$mib$asl$internal$kombipictureserver$common$api$bap$telephone$BapTelephoneService = CallPicture.class$("de.vw.mib.asl.internal.kombipictureserver.common.api.bap.telephone.BapTelephoneService")) : class$de$vw$mib$asl$internal$kombipictureserver$common$api$bap$telephone$BapTelephoneService);
            this.getCategoryDelegate().registerServiceListener(this, class$de$vw$mib$asl$internal$kombipictureserver$common$api$bap$telephone$BapTelephoneService == null ? (class$de$vw$mib$asl$internal$kombipictureserver$common$api$bap$telephone$BapTelephoneService = CallPicture.class$("de.vw.mib.asl.internal.kombipictureserver.common.api.bap.telephone.BapTelephoneService")) : class$de$vw$mib$asl$internal$kombipictureserver$common$api$bap$telephone$BapTelephoneService, BAP_TELEPHONE_SERVICE_SERVICES);
        }
        return this._bapTelephoneService;
    }

    @Override
    public void initialize() {
    }

    public void uninitialize() {
        this.getCategoryDelegate().removeDsiServiceResponder(this, class$org$dsi$ifc$kombipictureserver$DSIKombiPictureServerListener == null ? (class$org$dsi$ifc$kombipictureserver$DSIKombiPictureServerListener = CallPicture.class$("org.dsi.ifc.kombipictureserver.DSIKombiPictureServerListener")) : class$org$dsi$ifc$kombipictureserver$DSIKombiPictureServerListener, this.getKombiPictureServerServiceResponder(), null, (DSIBase)this._kombiPictureServer);
        this.getCategoryDelegate().removeServiceListener(this, class$de$vw$mib$asl$internal$kombipictureserver$common$api$phone$asl$PhoneCallService == null ? (class$de$vw$mib$asl$internal$kombipictureserver$common$api$phone$asl$PhoneCallService = CallPicture.class$("de.vw.mib.asl.internal.kombipictureserver.common.api.phone.asl.PhoneCallService")) : class$de$vw$mib$asl$internal$kombipictureserver$common$api$phone$asl$PhoneCallService, PHONE_CALL_SERVICE_SERVICES);
        this.getCategoryDelegate().removeServiceListener(this, class$de$vw$mib$asl$internal$kombipictureserver$common$api$bap$telephone$BapTelephoneService == null ? (class$de$vw$mib$asl$internal$kombipictureserver$common$api$bap$telephone$BapTelephoneService = CallPicture.class$("de.vw.mib.asl.internal.kombipictureserver.common.api.bap.telephone.BapTelephoneService")) : class$de$vw$mib$asl$internal$kombipictureserver$common$api$bap$telephone$BapTelephoneService, BAP_TELEPHONE_SERVICE_SERVICES);
    }

    @Override
    public int getIdentifier() {
        return 1117066752;
    }

    @Override
    public void executeSequence() {
        this.getKombiPictureServer();
        this.getPhoneCallService();
        this.getBapTelephoneService();
        this.getCategoryDelegate().updateAllServiceListeners(class$de$vw$mib$asl$internal$kombipictureserver$common$api$bap$telephone$BapTelephoneService == null ? (class$de$vw$mib$asl$internal$kombipictureserver$common$api$bap$telephone$BapTelephoneService = CallPicture.class$("de.vw.mib.asl.internal.kombipictureserver.common.api.bap.telephone.BapTelephoneService")) : class$de$vw$mib$asl$internal$kombipictureserver$common$api$bap$telephone$BapTelephoneService);
    }

    @Override
    public void updatePhonceCall(PhoneCallService phoneCallService, int n) {
        this._updateCallPicture(this._createCurrentCallPictureData());
    }

    @Override
    public void updateBapTelephone(BapTelephoneService bapTelephoneService, int n) {
        this._updateCallPicture(this._createCurrentCallPictureData());
    }

    public void dsiKombiPictureServerIndicationActiveCallPicture(int n) {
        this._sendCallPictureData(this.getLastCallPictureDatas(), CallPicture.mapFromBapCallID(n));
    }

    private static int mapFromBapCallID(int n) {
        int n2 = n >= 0 && n != 255 && n != 254 ? n + 1 : n;
        return n2;
    }

    private static int mapToBapCallID(int n) {
        int n2 = n > 0 && n != 255 && n != 254 ? n - 1 : n;
        return n2;
    }

    private ArrayList getLastCallPictureDatas() {
        if (this._lastCallPictureData == null) {
            this._lastCallPictureData = new ArrayList();
        }
        return this._lastCallPictureData;
    }

    private void _updateCallPicture(ArrayList arrayList) {
        boolean bl;
        ArrayList arrayList2 = this.getLastCallPictureDatas();
        if (arrayList.size() != arrayList2.size()) {
            bl = true;
        } else {
            bl = false;
            int n = arrayList2.size();
            for (int i2 = 0; i2 < n; ++i2) {
                CallPicture$CallPictureData callPicture$CallPictureData;
                CallPicture$CallPictureData callPicture$CallPictureData2 = (CallPicture$CallPictureData)arrayList.get(i2);
                if (callPicture$CallPictureData2.equalTo(callPicture$CallPictureData = (CallPicture$CallPictureData)arrayList2.get(i2))) continue;
                bl = true;
                break;
            }
        }
        if (bl) {
            this.getLastCallPictureDatas().clear();
            this.getLastCallPictureDatas().addAll(arrayList);
            this._sendCallPictureData(this.getLastCallPictureDatas(), 255);
        }
    }

    private void _sendCallPictureData(ArrayList arrayList, int n) {
        int n2 = arrayList.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            int n3;
            ResourceLocator resourceLocator;
            CallPicture$CallPictureData callPicture$CallPictureData = (CallPicture$CallPictureData)arrayList.get(i2);
            if (n != 255 && n != callPicture$CallPictureData.getCallID()) continue;
            if (CallPicture.transmissionOfCallPictureNeeded(callPicture$CallPictureData.getDsiPictureType())) {
                resourceLocator = callPicture$CallPictureData.getResourceLocator();
                n3 = resourceLocator == null ? 0 : callPicture$CallPictureData.getDsiPictureType();
            } else {
                resourceLocator = null;
                n3 = callPicture$CallPictureData.getDsiPictureType();
            }
            this.getKombiPictureServer().responseActiveCallPicture(CallPicture.mapToBapCallID(callPicture$CallPictureData.getCallID()), n3, resourceLocator);
        }
        if (arrayList.size() == 0) {
            this.getKombiPictureServer().responseActiveCallPicture(254, 0, null);
        }
    }

    private ArrayList _createCurrentCallPictureData() {
        ArrayList arrayList = new ArrayList();
        PhoneCallInfo[] phoneCallInfoArray = this.getPhoneCallService().getCallInfos();
        PhoneCallInfo[] phoneCallInfoArray2 = this.getPhoneCallService().getConferenceCallInfos();
        for (BapTelephoneCallInfo bapTelephoneCallInfo : this.getBapTelephoneService().getCallInfos()) {
            if (bapTelephoneCallInfo.getCallState() == 0) continue;
            PhoneCallInfo phoneCallInfo = CallPicture.findPhoneCallInfo(bapTelephoneCallInfo.getCallId(), phoneCallInfoArray);
            if (phoneCallInfo == null) {
                phoneCallInfo = CallPicture.findPhoneCallInfo(bapTelephoneCallInfo.getCallId(), phoneCallInfoArray2);
            }
            if (phoneCallInfo == null) continue;
            CallPicture$CallPictureData callPicture$CallPictureData = new CallPicture$CallPictureData(phoneCallInfo.getCallId(), CallPicture.mapBapCallTypeToDsiPictureType(bapTelephoneCallInfo.getCallType()), phoneCallInfo.getResourceLocator());
            arrayList.add(callPicture$CallPictureData);
        }
        return arrayList;
    }

    private static PhoneCallInfo findPhoneCallInfo(int n, PhoneCallInfo[] phoneCallInfoArray) {
        PhoneCallInfo phoneCallInfo = null;
        for (PhoneCallInfo phoneCallInfo2 : phoneCallInfoArray) {
            if (phoneCallInfo2.getCallId() != n) continue;
            phoneCallInfo = phoneCallInfo2;
            break;
        }
        return phoneCallInfo;
    }

    private static int mapBapCallTypeToDsiPictureType(int n) {
        int n2;
        switch (n) {
            case 5: {
                n2 = 5;
                break;
            }
            case 4: {
                n2 = 4;
                break;
            }
            case 6: {
                n2 = 2;
                break;
            }
            case 7: {
                n2 = 3;
                break;
            }
            case 1: {
                n2 = 1;
                break;
            }
            default: {
                n2 = 0;
            }
        }
        return n2;
    }

    private static boolean transmissionOfCallPictureNeeded(int n) {
        boolean bl;
        switch (n) {
            case 1: {
                bl = true;
                break;
            }
            default: {
                bl = false;
            }
        }
        return bl;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static {
        PHONE_CALL_SERVICE_SERVICES = PhoneCallDelegate.PHONE_CALL_PROPERTIES;
        BAP_TELEPHONE_SERVICE_SERVICES = BapTelephoneDelegate.BAP_TELEPHONE_PROPERTIES;
    }
}

