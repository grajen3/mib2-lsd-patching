/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.phonetiles.setup.settings;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.genericevents.ServiceRegister;

public final class ASLPhoneTileSSetupSettingsDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLPhoneTileSSetupSettingsDeviceImpl INSTANCE = new ASLPhoneTileSSetupSettingsDeviceImpl();
    private static final String DEVICE_NAME;

    private ASLPhoneTileSSetupSettingsDeviceImpl() {
    }

    public static ASLPhoneTileSSetupSettingsDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "PhoneTileS.Setup.Settings";
    }

    @Override
    public int getTargetId() {
        return 17705;
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
        serviceRegister.registerService(-197433792, 17705);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device PhoneTileS.Setup.Settings: ").append(n).toString());
    }

    @Override
    public ASLList getASLList(int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device PhoneTileS.Setup.Settings: ").append(n).toString());
    }

    @Override
    public ASLList createASLList(ASLListFactory aSLListFactory, int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device PhoneTileS.Setup.Settings: ").append(n).toString());
    }
}

