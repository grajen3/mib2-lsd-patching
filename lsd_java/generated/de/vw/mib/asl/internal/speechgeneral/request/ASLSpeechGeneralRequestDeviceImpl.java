/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.speechgeneral.request;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.genericevents.ServiceRegister;

public final class ASLSpeechGeneralRequestDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLSpeechGeneralRequestDeviceImpl INSTANCE = new ASLSpeechGeneralRequestDeviceImpl();
    private static final String DEVICE_NAME;

    private ASLSpeechGeneralRequestDeviceImpl() {
    }

    public static ASLSpeechGeneralRequestDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "SpeechGeneral.Request";
    }

    @Override
    public int getTargetId() {
        return 14203;
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
        serviceRegister.registerService(416559168, 14203);
        serviceRegister.registerService(13905984, 14203);
        serviceRegister.registerService(30683200, 14203);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device SpeechGeneral.Request: ").append(n).toString());
    }

    @Override
    public ASLList getASLList(int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device SpeechGeneral.Request: ").append(n).toString());
    }

    @Override
    public ASLList createASLList(ASLListFactory aSLListFactory, int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device SpeechGeneral.Request: ").append(n).toString());
    }
}

