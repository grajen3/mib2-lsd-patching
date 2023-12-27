/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.speechtuner.request;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.genericevents.ServiceRegister;

public final class ASLSpeechTunerRequestDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLSpeechTunerRequestDeviceImpl INSTANCE = new ASLSpeechTunerRequestDeviceImpl();
    private static final String DEVICE_NAME;

    private ASLSpeechTunerRequestDeviceImpl() {
    }

    public static ASLSpeechTunerRequestDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "SpeechTuner.Request";
    }

    @Override
    public int getTargetId() {
        return 14802;
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
        serviceRegister.registerService(-470075072, 14802);
        serviceRegister.registerService(-1057277632, 14802);
        serviceRegister.registerService(-1040500416, 14802);
        serviceRegister.registerService(-738510528, 14802);
        serviceRegister.registerService(-906282688, 14802);
        serviceRegister.registerService(-688178880, 14802);
        serviceRegister.registerService(-520406720, 14802);
        serviceRegister.registerService(-671401664, 14802);
        serviceRegister.registerService(-654624448, 14802);
        serviceRegister.registerService(-503629504, 14802);
        serviceRegister.registerService(-637847232, 14802);
        serviceRegister.registerService(-486852288, 14802);
        serviceRegister.registerService(-621070016, 14802);
        serviceRegister.registerService(-604292800, 14802);
        serviceRegister.registerService(-587515584, 14802);
        serviceRegister.registerService(-570738368, 14802);
        serviceRegister.registerService(-553961152, 14802);
        serviceRegister.registerService(-1023723200, 14802);
        serviceRegister.registerService(-1006945984, 14802);
        serviceRegister.registerService(-990168768, 14802);
        serviceRegister.registerService(-973391552, 14802);
        serviceRegister.registerService(-537183936, 14802);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device SpeechTuner.Request: ").append(n).toString());
    }

    @Override
    public ASLList getASLList(int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device SpeechTuner.Request: ").append(n).toString());
    }

    @Override
    public ASLList createASLList(ASLListFactory aSLListFactory, int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device SpeechTuner.Request: ").append(n).toString());
    }
}

