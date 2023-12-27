/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.speechphone.teleprompterhandling;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.genericevents.ServiceRegister;

public final class ASLSpeechPhoneTeleprompterHandlingDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLSpeechPhoneTeleprompterHandlingDeviceImpl INSTANCE = new ASLSpeechPhoneTeleprompterHandlingDeviceImpl();
    private static final String DEVICE_NAME;

    private ASLSpeechPhoneTeleprompterHandlingDeviceImpl() {
    }

    public static ASLSpeechPhoneTeleprompterHandlingDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "SpeechPhone.TeleprompterHandling";
    }

    @Override
    public int getTargetId() {
        return 14905;
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
        serviceRegister.registerService(2005023552, 14905);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device SpeechPhone.TeleprompterHandling: ").append(n).toString());
    }

    @Override
    public ASLList getASLList(int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device SpeechPhone.TeleprompterHandling: ").append(n).toString());
    }

    @Override
    public ASLList createASLList(ASLListFactory aSLListFactory, int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device SpeechPhone.TeleprompterHandling: ").append(n).toString());
    }
}

