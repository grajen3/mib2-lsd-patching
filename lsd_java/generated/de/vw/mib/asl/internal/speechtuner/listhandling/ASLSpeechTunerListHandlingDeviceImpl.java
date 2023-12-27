/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.speechtuner.listhandling;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.genericevents.ServiceRegister;

public final class ASLSpeechTunerListHandlingDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLSpeechTunerListHandlingDeviceImpl INSTANCE = new ASLSpeechTunerListHandlingDeviceImpl();
    private static final String DEVICE_NAME;

    private ASLSpeechTunerListHandlingDeviceImpl() {
    }

    public static ASLSpeechTunerListHandlingDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "SpeechTuner.ListHandling";
    }

    @Override
    public int getTargetId() {
        return 14806;
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
        serviceRegister.registerService(-889505472, 14806);
        serviceRegister.registerService(-872728256, 14806);
        serviceRegister.registerService(-855951040, 14806);
        serviceRegister.registerService(-839173824, 14806);
        serviceRegister.registerService(-822396608, 14806);
        serviceRegister.registerService(-721733312, 14806);
        serviceRegister.registerService(-704956096, 14806);
        serviceRegister.registerService(-805619392, 14806);
        serviceRegister.registerService(-788842176, 14806);
        serviceRegister.registerService(-453297856, 14806);
        serviceRegister.registerService(-772064960, 14806);
        serviceRegister.registerService(-755287744, 14806);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device SpeechTuner.ListHandling: ").append(n).toString());
    }

    @Override
    public ASLList getASLList(int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device SpeechTuner.ListHandling: ").append(n).toString());
    }

    @Override
    public ASLList createASLList(ASLListFactory aSLListFactory, int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device SpeechTuner.ListHandling: ").append(n).toString());
    }
}

