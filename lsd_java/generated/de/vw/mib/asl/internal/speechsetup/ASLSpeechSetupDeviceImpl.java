/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.speechsetup;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.genericevents.ServiceRegister;

public final class ASLSpeechSetupDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLSpeechSetupDeviceImpl INSTANCE = new ASLSpeechSetupDeviceImpl();
    private static final String DEVICE_NAME;

    private ASLSpeechSetupDeviceImpl() {
    }

    public static ASLSpeechSetupDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "SpeechSetup";
    }

    @Override
    public int getTargetId() {
        return 15201;
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
        serviceRegister.registerService(1075200064, 15201);
        serviceRegister.registerService(1091977280, 15201);
        serviceRegister.registerService(1108754496, 15201);
        serviceRegister.registerService(1125531712, 15201);
        serviceRegister.registerService(1142308928, 15201);
        serviceRegister.registerService(1159086144, 15201);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device SpeechSetup: ").append(n).toString());
    }

    @Override
    public ASLList getASLList(int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device SpeechSetup: ").append(n).toString());
    }

    @Override
    public ASLList createASLList(ASLListFactory aSLListFactory, int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device SpeechSetup: ").append(n).toString());
    }
}

