/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.kombipictureserver.common.api.phone;

import de.vw.mib.asl.internal.kombipictureserver.common.adapter.DataPoolAdapter;
import de.vw.mib.asl.internal.kombipictureserver.common.api.phone.PhoneCallAdapter$_PhoneCallInfo;
import de.vw.mib.asl.internal.kombipictureserver.common.api.phone.asl.PhoneCallDelegate;
import de.vw.mib.asl.internal.kombipictureserver.common.api.phone.asl.PhoneCallInfo;
import de.vw.mib.asl.internal.kombipictureserver.common.api.phone.asl.PhoneCallService;
import de.vw.mib.asl.internal.kombipictureserver.common.services.AslServiceRegistry;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.dsi.ifc.global.ResourceLocator;

public class PhoneCallAdapter
extends DataPoolAdapter
implements AslServiceRegistry,
PhoneCallService {
    private PhoneCallInfo[] _phoneCallInfos;
    private PhoneCallInfo[] _phoneConferenceCallInfos;
    private static final int[] PHONE_CALL_LIST_IDS = PhoneCallDelegate.PHONE_CALL_PROPERTIES;
    private static final int CONFERENCE_CALL_ID;
    private static final int INVALID_CALL_ID;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$kombipictureserver$common$api$phone$asl$PhoneCallService;

    public static Class getServiceClass() {
        return class$de$vw$mib$asl$internal$kombipictureserver$common$api$phone$asl$PhoneCallService == null ? (class$de$vw$mib$asl$internal$kombipictureserver$common$api$phone$asl$PhoneCallService = PhoneCallAdapter.class$("de.vw.mib.asl.internal.kombipictureserver.common.api.phone.asl.PhoneCallService")) : class$de$vw$mib$asl$internal$kombipictureserver$common$api$phone$asl$PhoneCallService;
    }

    @Override
    protected int[] getPropertyIds() {
        return null;
    }

    @Override
    protected int[] getListIds() {
        return PHONE_CALL_LIST_IDS;
    }

    @Override
    public void datapoolValueChanged(int n) {
        this._notifyServiceDelegates(n);
    }

    @Override
    protected void listValueChanged(int n) {
        this._storeAslListValue(n);
        this._notifyServiceDelegates(n);
    }

    private void _notifyServiceDelegates(int n) {
        List list = this.getRegisteredServiceDelegates(n);
        if (list != null) {
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                PhoneCallDelegate phoneCallDelegate = (PhoneCallDelegate)iterator.next();
                phoneCallDelegate.updatePhonceCall(this, n);
            }
        }
    }

    private static PhoneCallInfo[] _createCallInfos(int[] nArray, ResourceLocator[] resourceLocatorArray) {
        ArrayList arrayList = new ArrayList(nArray.length);
        int n = nArray.length;
        for (int i2 = 0; i2 < n; ++i2) {
            if (nArray[i2] == 254 || nArray[i2] == 0) continue;
            PhoneCallAdapter$_PhoneCallInfo phoneCallAdapter$_PhoneCallInfo = new PhoneCallAdapter$_PhoneCallInfo(nArray[i2], resourceLocatorArray[i2]);
            arrayList.add(phoneCallAdapter$_PhoneCallInfo);
        }
        return (PhoneCallInfo[])arrayList.toArray(new PhoneCallAdapter$_PhoneCallInfo[arrayList.size()]);
    }

    @Override
    public PhoneCallInfo[] getCallInfos() {
        if (this._phoneCallInfos == null) {
            this._phoneCallInfos = PhoneCallAdapter._createCallInfos(PhoneCallAdapter.getIntegerListColumn(1158, 0), PhoneCallAdapter.getResourceLocatorListColumn(1158, 9));
        }
        return this._phoneCallInfos;
    }

    @Override
    public PhoneCallInfo[] getConferenceCallInfos() {
        if (this._phoneConferenceCallInfos == null) {
            this._phoneConferenceCallInfos = PhoneCallAdapter._createCallInfos(PhoneCallAdapter.getIntegerListColumn(1160, 0), PhoneCallAdapter.getResourceLocatorListColumn(1160, 5));
        }
        return this._phoneConferenceCallInfos;
    }

    private void _storeAslListValue(int n) {
        if (n == 1158 || n == 1160) {
            this._phoneCallInfos = null;
            this._phoneConferenceCallInfos = null;
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

