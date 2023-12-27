/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.speechmedia.playsimilar;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.genericevents.ServiceRegister;

public final class ASLSpeechMediaPlaySimilarDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLSpeechMediaPlaySimilarDeviceImpl INSTANCE = new ASLSpeechMediaPlaySimilarDeviceImpl();
    private static final String DEVICE_NAME;

    private ASLSpeechMediaPlaySimilarDeviceImpl() {
    }

    public static ASLSpeechMediaPlaySimilarDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "SpeechMedia.PlaySimilar";
    }

    @Override
    public int getTargetId() {
        return 14309;
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
        serviceRegister.registerService(-950390208, 14309);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device SpeechMedia.PlaySimilar: ").append(n).toString());
    }

    @Override
    public ASLList getASLList(int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device SpeechMedia.PlaySimilar: ").append(n).toString());
    }

    @Override
    public ASLList createASLList(ASLListFactory aSLListFactory, int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device SpeechMedia.PlaySimilar: ").append(n).toString());
    }
}

