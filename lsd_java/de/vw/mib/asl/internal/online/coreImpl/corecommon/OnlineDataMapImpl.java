/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.coreImpl.corecommon;

import de.vw.mib.asl.internal.online.coreImpl.corecommon.collection.OnlineDataMap;

public class OnlineDataMapImpl
implements OnlineDataMap {
    private final String _serviecID;
    private final int _serviceNumericID;
    private final String _serviceName;
    private final int[] _serviceGroup;
    private final int[] _serviceCategory;
    private final boolean _serviceInvisible;
    private final int _versionNumber;

    public OnlineDataMapImpl(String string, int n, String string2, int[] nArray, int[] nArray2, boolean bl, int n2) {
        this._serviecID = string;
        this._serviceNumericID = n;
        this._serviceName = string2;
        this._serviceGroup = nArray;
        this._serviceCategory = nArray2;
        this._serviceInvisible = bl;
        this._versionNumber = n2;
    }

    @Override
    public String getServiceID() {
        return this._serviecID;
    }

    @Override
    public int getServiceNumericID() {
        return this._serviceNumericID;
    }

    @Override
    public String getServiceName() {
        return this._serviceName;
    }

    @Override
    public int[] getServiceGroup() {
        return this._serviceGroup;
    }

    @Override
    public int[] getServiceCategory() {
        return this._serviceCategory;
    }

    @Override
    public boolean isServiceInvisible() {
        return this._serviceInvisible;
    }

    @Override
    public int getVersion() {
        return this._versionNumber;
    }
}

