/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.speechheadline;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.genericevents.ServiceRegister;

public final class ASLSpeechHeadlineDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLSpeechHeadlineDeviceImpl INSTANCE = new ASLSpeechHeadlineDeviceImpl();
    private static final String DEVICE_NAME;

    private ASLSpeechHeadlineDeviceImpl() {
    }

    public static ASLSpeechHeadlineDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "SpeechHeadline";
    }

    @Override
    public int getTargetId() {
        return 15301;
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
        serviceRegister.registerService(-526630592, 15301);
        serviceRegister.registerService(-509853376, 15301);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device SpeechHeadline: ").append(n).toString());
    }

    @Override
    public ASLList getASLList(int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device SpeechHeadline: ").append(n).toString());
    }

    @Override
    public ASLList createASLList(ASLListFactory aSLListFactory, int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device SpeechHeadline: ").append(n).toString());
    }
}

