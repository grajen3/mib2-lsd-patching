/*
 * Decompiled with CFR 0.151-SNAPSHOT (5569f06-dirty).
 */
package de.vw.mib.bap.mqbab2.common.api.androidauto;

import de.vw.mib.bap.mqbab2.common.api.APIFactoryInterface;
import de.vw.mib.bap.mqbab2.common.api.androidauto.AndroidAutoService;
import de.vw.mib.bap.mqbab2.common.api.androidauto.AndroidAutoServiceListener;
import de.vw.mib.bap.mqbab2.common.api.asl.ASLDataPoolAdapter;
import de.vw.mib.datapool.ASLDatapool;
import java.util.Iterator;
import java.util.List;

public class AndroidAutoASLDataAdapter
extends ASLDataPoolAdapter
implements AndroidAutoService {
    private APIFactoryInterface apiFactory;
    private static /*final*/int[] ANDROID_AUTO_ASL_PROPERTY_IDS_TO_LISTEN_TO = new int[]{895953920};

    public AndroidAutoASLDataAdapter(APIFactoryInterface aPIFactoryInterface, ASLDatapool aSLDatapool) {
        super(aSLDatapool);
        this.apiFactory = aPIFactoryInterface;
        this.register();
    }

    // @Override
    public boolean isAndroidAutoRouteGuidanceActive() {
        // return this.getDataPool().getBoolean(895953920, false);
        return false;
    }

    // @Override
    public void datapoolValueChanged(int n) {
        this._notifyServiceDelegates(n);
    }

    private void _notifyServiceDelegates(int n) {
        List list = this.getRegisteredServiceDelegates(n);
        if (list != null) {
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                AndroidAutoServiceListener androidAutoServiceListener = (AndroidAutoServiceListener)iterator.next();
                androidAutoServiceListener.updateAndroidAutoData(this, n);
            }
        }
    }

    // @Override
    protected int[] getPropertyIds() {
        return ANDROID_AUTO_ASL_PROPERTY_IDS_TO_LISTEN_TO;
    }

    // @Override
    protected int[] getListIds() {
        return null;
    }

    // @Override
    protected void listValueChanged(int n) {
        this._notifyServiceDelegates(n);
    }

    // @Override
    public void addAndroidAutoServiceListener(AndroidAutoServiceListener androidAutoServiceListener, int[] nArray) {
        this.registerServiceListener((Object)androidAutoServiceListener, nArray);
    }

    // @Override
    public void removeAndroidAutoServiceListener(AndroidAutoServiceListener androidAutoServiceListener, int[] nArray) {
        this.removeServiceListener(androidAutoServiceListener, nArray);
    }
}

