/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.speechtuner.teleprompterhandling;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.genericevents.ServiceRegister;

public final class ASLSpeechTunerTeleprompterHandlingDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLSpeechTunerTeleprompterHandlingDeviceImpl INSTANCE = new ASLSpeechTunerTeleprompterHandlingDeviceImpl();
    private static final String DEVICE_NAME;

    private ASLSpeechTunerTeleprompterHandlingDeviceImpl() {
    }

    public static ASLSpeechTunerTeleprompterHandlingDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "SpeechTuner.TeleprompterHandling";
    }

    @Override
    public int getTargetId() {
        return 14804;
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
        serviceRegister.registerService(-939837120, 14804);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device SpeechTuner.TeleprompterHandling: ").append(n).toString());
    }

    @Override
    public ASLList getASLList(int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device SpeechTuner.TeleprompterHandling: ").append(n).toString());
    }

    @Override
    public ASLList createASLList(ASLListFactory aSLListFactory, int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device SpeechTuner.TeleprompterHandling: ").append(n).toString());
    }
}

