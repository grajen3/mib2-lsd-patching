/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.speechphone.dialnumber;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.genericevents.ServiceRegister;

public final class ASLSpeechPhoneDialNumberDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLSpeechPhoneDialNumberDeviceImpl INSTANCE = new ASLSpeechPhoneDialNumberDeviceImpl();
    private static final String DEVICE_NAME;

    private ASLSpeechPhoneDialNumberDeviceImpl() {
    }

    public static ASLSpeechPhoneDialNumberDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "SpeechPhone.DialNumber";
    }

    @Override
    public int getTargetId() {
        return 14907;
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
        serviceRegister.registerService(2122464064, 14907);
        serviceRegister.registerService(2139241280, 14907);
        serviceRegister.registerService(-2138948800, 14907);
        serviceRegister.registerService(-2122171584, 14907);
        serviceRegister.registerService(-2105394368, 14907);
        serviceRegister.registerService(-2088617152, 14907);
        serviceRegister.registerService(-2071839936, 14907);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device SpeechPhone.DialNumber: ").append(n).toString());
    }

    @Override
    public ASLList getASLList(int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device SpeechPhone.DialNumber: ").append(n).toString());
    }

    @Override
    public ASLList createASLList(ASLListFactory aSLListFactory, int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device SpeechPhone.DialNumber: ").append(n).toString());
    }
}

