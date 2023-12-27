/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.navigation.overlay.setup;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.genericevents.ServiceRegister;

public final class ASLNavigationOverlaySetupDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLNavigationOverlaySetupDeviceImpl INSTANCE = new ASLNavigationOverlaySetupDeviceImpl();
    private static final String DEVICE_NAME;

    private ASLNavigationOverlaySetupDeviceImpl() {
    }

    public static ASLNavigationOverlaySetupDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "Navigation.Overlay.Setup";
    }

    @Override
    public int getTargetId() {
        return 12106;
    }

    @Override
    public int getASLDeviceComplianceLevel() {
        return 2;
    }

    @Override
    public void registerASLLists(ASLListRegistry aSLListRegistry) {
    }

    @Override
    public void registerASLServices(ServiceRegister serviceRegister) {
        serviceRegister.registerService(-3665856, 12106);
        serviceRegister.registerService(-355987392, 12106);
        serviceRegister.registerService(-339210176, 12106);
        serviceRegister.registerService(-322432960, 12106);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Navigation.Overlay.Setup: ").append(n).toString());
    }

    @Override
    public ASLList getASLList(int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Navigation.Overlay.Setup: ").append(n).toString());
    }

    @Override
    public ASLList createASLList(ASLListFactory aSLListFactory, int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Navigation.Overlay.Setup: ").append(n).toString());
    }
}

