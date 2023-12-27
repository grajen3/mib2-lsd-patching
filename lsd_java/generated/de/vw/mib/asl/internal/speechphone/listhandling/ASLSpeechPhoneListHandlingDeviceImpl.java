/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.speechphone.listhandling;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.genericevents.ServiceRegister;

public final class ASLSpeechPhoneListHandlingDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLSpeechPhoneListHandlingDeviceImpl INSTANCE = new ASLSpeechPhoneListHandlingDeviceImpl();
    private static final String DEVICE_NAME;

    private ASLSpeechPhoneListHandlingDeviceImpl() {
    }

    public static ASLSpeechPhoneListHandlingDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "SpeechPhone.ListHandling";
    }

    @Override
    public int getTargetId() {
        return 14906;
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
        serviceRegister.registerService(-2004731072, 14906);
        serviceRegister.registerService(-1987953856, 14906);
        serviceRegister.registerService(-1971176640, 14906);
        serviceRegister.registerService(-1954399424, 14906);
        serviceRegister.registerService(-1937622208, 14906);
        serviceRegister.registerService(-1920844992, 14906);
        serviceRegister.registerService(2088909632, 14906);
        serviceRegister.registerService(-1887290560, 14906);
        serviceRegister.registerService(-1870513344, 14906);
        serviceRegister.registerService(-1853736128, 14906);
        serviceRegister.registerService(-1551746240, 14906);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device SpeechPhone.ListHandling: ").append(n).toString());
    }

    @Override
    public ASLList getASLList(int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device SpeechPhone.ListHandling: ").append(n).toString());
    }

    @Override
    public ASLList createASLList(ASLListFactory aSLListFactory, int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device SpeechPhone.ListHandling: ").append(n).toString());
    }
}

