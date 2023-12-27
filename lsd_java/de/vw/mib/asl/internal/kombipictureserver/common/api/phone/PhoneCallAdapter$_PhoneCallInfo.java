/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.kombipictureserver.common.api.phone;

import de.vw.mib.asl.internal.kombipictureserver.common.api.phone.asl.PhoneCallInfo;
import org.dsi.ifc.global.ResourceLocator;

class PhoneCallAdapter$_PhoneCallInfo
implements PhoneCallInfo {
    private final int _callId;
    private final ResourceLocator _resourceLocator;

    public PhoneCallAdapter$_PhoneCallInfo(int n, ResourceLocator resourceLocator) {
        this._callId = n;
        this._resourceLocator = resourceLocator;
    }

    @Override
    public int getCallId() {
        return this._callId;
    }

    @Override
    public ResourceLocator getResourceLocator() {
        return this._resourceLocator;
    }
}

