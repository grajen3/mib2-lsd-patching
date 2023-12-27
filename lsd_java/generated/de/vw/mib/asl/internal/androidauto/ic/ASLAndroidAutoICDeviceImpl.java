/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.androidauto.ic;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.genericevents.ServiceRegister;

public final class ASLAndroidAutoICDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLAndroidAutoICDeviceImpl INSTANCE = new ASLAndroidAutoICDeviceImpl();
    private static final String DEVICE_NAME;

    private ASLAndroidAutoICDeviceImpl() {
    }

    public static ASLAndroidAutoICDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "AndroidAuto.IC";
    }

    @Override
    public int getTargetId() {
        return 13902;
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
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device AndroidAuto.IC: ").append(n).toString());
    }

    @Override
    public ASLList getASLList(int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device AndroidAuto.IC: ").append(n).toString());
    }

    @Override
    public ASLList createASLList(ASLListFactory aSLListFactory, int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device AndroidAuto.IC: ").append(n).toString());
    }
}

