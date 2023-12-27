/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.vicsetc.shortcut;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.genericevents.ServiceRegister;

public final class ASLVICSETCShortcutDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLVICSETCShortcutDeviceImpl INSTANCE = new ASLVICSETCShortcutDeviceImpl();
    private static final String DEVICE_NAME;

    private ASLVICSETCShortcutDeviceImpl() {
    }

    public static ASLVICSETCShortcutDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "VICSETC.Shortcut";
    }

    @Override
    public int getTargetId() {
        return 16605;
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
        serviceRegister.registerService(74667328, 16605);
        serviceRegister.registerService(1114854720, 16605);
        serviceRegister.registerService(980636992, 16605);
        serviceRegister.registerService(326325568, 16605);
        serviceRegister.registerService(343102784, 16605);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device VICSETC.Shortcut: ").append(n).toString());
    }

    @Override
    public ASLList getASLList(int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device VICSETC.Shortcut: ").append(n).toString());
    }

    @Override
    public ASLList createASLList(ASLListFactory aSLListFactory, int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device VICSETC.Shortcut: ").append(n).toString());
    }
}

