/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.coreImpl.adapterMOD;

import de.vw.mib.asl.internal.online.coreImpl.adapterMOD.control.CoreServiceMODController;
import de.vw.mib.asl.internal.online.coreImpl.adapterMOD.control.CoreServiceMODNotifier;
import de.vw.mib.asl.internal.online.coreImpl.adapterMOD.impl.CoreServiceMODAdapterImpl;
import de.vw.mib.asl.internal.online.coreImpl.adapterMOD.impl.CoreServiceMODExternalImpl;
import de.vw.mib.asl.internal.online.coreImpl.adapterMOD.states.CoreServiceMODTarget;
import de.vw.mib.asl.internal.online.coreImpl.corecommon.CoreServiceCommonFactory;
import de.vw.mib.asl.internal.online.coreInterfaces.adapter.CoreServiceAdapter;
import de.vw.mib.asl.internal.online.coreInterfaces.core.server.Device;
import de.vw.mib.asl.internal.online.coreInterfaces.external.CoreServiceExternal;

public final class CoreServiceMODFactory {
    private static CoreServiceAdapter _adapterImpl;
    private static CoreServiceExternal _externalImpl;
    private static CoreServiceMODController _controller;
    private static CoreServiceMODNotifier _notifier;
    private static Device _device;

    public static CoreServiceAdapter getAdapter(CoreServiceMODTarget coreServiceMODTarget) {
        if (_adapterImpl == null && coreServiceMODTarget != null) {
            _adapterImpl = new CoreServiceMODAdapterImpl(coreServiceMODTarget);
        }
        return _adapterImpl;
    }

    public static CoreServiceExternal getExternal(CoreServiceMODTarget coreServiceMODTarget) {
        if (_externalImpl == null && coreServiceMODTarget != null) {
            _externalImpl = new CoreServiceMODExternalImpl(coreServiceMODTarget);
        }
        return _externalImpl;
    }

    public static CoreServiceMODController getController(CoreServiceMODTarget coreServiceMODTarget) {
        if (_controller == null && coreServiceMODTarget != null) {
            _controller = new CoreServiceMODController(coreServiceMODTarget);
        }
        return _controller;
    }

    public static CoreServiceMODNotifier getNotifier() {
        if (_notifier == null) {
            _notifier = new CoreServiceMODNotifier();
        }
        return _notifier;
    }

    public static Device getMODDevice() {
        if (_device == null) {
            _device = CoreServiceCommonFactory.getDeviceInstance(2, "MOD Device");
        }
        return _device;
    }
}

