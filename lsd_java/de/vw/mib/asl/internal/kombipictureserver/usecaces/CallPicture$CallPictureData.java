/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.kombipictureserver.usecaces;

import de.vw.mib.asl.internal.kombipictureserver.common.util.KombiPictureServerUtil;
import org.dsi.ifc.global.ResourceLocator;

class CallPicture$CallPictureData {
    private final int _callID;
    private final int _dsiPictureType;
    private final ResourceLocator _resourceLocator;

    public CallPicture$CallPictureData(int n, int n2, ResourceLocator resourceLocator) {
        this._callID = n;
        this._dsiPictureType = n2;
        this._resourceLocator = resourceLocator;
    }

    public int getCallID() {
        return this._callID;
    }

    public int getDsiPictureType() {
        return this._dsiPictureType;
    }

    public ResourceLocator getResourceLocator() {
        return this._resourceLocator;
    }

    public boolean equalTo(CallPicture$CallPictureData callPicture$CallPictureData) {
        return this._callID == callPicture$CallPictureData._callID && this._dsiPictureType == callPicture$CallPictureData._dsiPictureType && KombiPictureServerUtil.compareResourceLocator(this._resourceLocator, callPicture$CallPictureData._resourceLocator);
    }
}

