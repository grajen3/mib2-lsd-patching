/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.speechgeneral.teleprompter;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.genericevents.ServiceRegister;

public final class ASLSpeechGeneralTeleprompterDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLSpeechGeneralTeleprompterDeviceImpl INSTANCE = new ASLSpeechGeneralTeleprompterDeviceImpl();
    private static final String DEVICE_NAME;

    private ASLSpeechGeneralTeleprompterDeviceImpl() {
    }

    public static ASLSpeechGeneralTeleprompterDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "SpeechGeneral.Teleprompter";
    }

    @Override
    public int getTargetId() {
        return 14207;
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
        serviceRegister.registerService(315895872, 14207);
        serviceRegister.registerService(332673088, 14207);
        serviceRegister.registerService(349450304, 14207);
        serviceRegister.registerService(366227520, 14207);
        serviceRegister.registerService(383004736, 14207);
        serviceRegister.registerService(399781952, 14207);
        serviceRegister.registerService(483668032, 14207);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device SpeechGeneral.Teleprompter: ").append(n).toString());
    }

    @Override
    public ASLList getASLList(int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device SpeechGeneral.Teleprompter: ").append(n).toString());
    }

    @Override
    public ASLList createASLList(ASLListFactory aSLListFactory, int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device SpeechGeneral.Teleprompter: ").append(n).toString());
    }
}

