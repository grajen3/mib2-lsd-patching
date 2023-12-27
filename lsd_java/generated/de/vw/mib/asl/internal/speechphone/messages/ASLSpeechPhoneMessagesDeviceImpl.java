/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.speechphone.messages;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.genericevents.ServiceRegister;

public final class ASLSpeechPhoneMessagesDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLSpeechPhoneMessagesDeviceImpl INSTANCE = new ASLSpeechPhoneMessagesDeviceImpl();
    private static final String DEVICE_NAME;

    private ASLSpeechPhoneMessagesDeviceImpl() {
    }

    public static ASLSpeechPhoneMessagesDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "SpeechPhone.Messages";
    }

    @Override
    public int getTargetId() {
        return 14908;
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
        serviceRegister.registerService(-1652409536, 14908);
        serviceRegister.registerService(-1635632320, 14908);
        serviceRegister.registerService(-2038285504, 14908);
        serviceRegister.registerService(-1585300672, 14908);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device SpeechPhone.Messages: ").append(n).toString());
    }

    @Override
    public ASLList getASLList(int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device SpeechPhone.Messages: ").append(n).toString());
    }

    @Override
    public ASLList createASLList(ASLListFactory aSLListFactory, int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device SpeechPhone.Messages: ").append(n).toString());
    }
}

