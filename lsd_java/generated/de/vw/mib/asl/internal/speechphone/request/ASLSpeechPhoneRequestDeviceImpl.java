/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.speechphone.request;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.genericevents.ServiceRegister;

public final class ASLSpeechPhoneRequestDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLSpeechPhoneRequestDeviceImpl INSTANCE = new ASLSpeechPhoneRequestDeviceImpl();
    private static final String DEVICE_NAME;

    private ASLSpeechPhoneRequestDeviceImpl() {
    }

    public static ASLSpeechPhoneRequestDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "SpeechPhone.Request";
    }

    @Override
    public int getTargetId() {
        return 14903;
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
        serviceRegister.registerService(2072132416, 14903);
        serviceRegister.registerService(1619147584, 14903);
        serviceRegister.registerService(1635924800, 14903);
        serviceRegister.registerService(1652702016, 14903);
        serviceRegister.registerService(1669479232, 14903);
        serviceRegister.registerService(1686256448, 14903);
        serviceRegister.registerService(1703033664, 14903);
        serviceRegister.registerService(1719810880, 14903);
        serviceRegister.registerService(1736588096, 14903);
        serviceRegister.registerService(1753365312, 14903);
        serviceRegister.registerService(1770142528, 14903);
        serviceRegister.registerService(1786919744, 14903);
        serviceRegister.registerService(1803696960, 14903);
        serviceRegister.registerService(1820474176, 14903);
        serviceRegister.registerService(1837251392, 14903);
        serviceRegister.registerService(1854028608, 14903);
        serviceRegister.registerService(1870805824, 14903);
        serviceRegister.registerService(2021800768, 14903);
        serviceRegister.registerService(2038577984, 14903);
        serviceRegister.registerService(2055355200, 14903);
        serviceRegister.registerService(1887583040, 14903);
        serviceRegister.registerService(1921137472, 14903);
        serviceRegister.registerService(1937914688, 14903);
        serviceRegister.registerService(1954691904, 14903);
        serviceRegister.registerService(1971469120, 14903);
        serviceRegister.registerService(1988246336, 14903);
        serviceRegister.registerService(-1685963968, 14903);
        serviceRegister.registerService(-1669186752, 14903);
        serviceRegister.registerService(-1568523456, 14903);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device SpeechPhone.Request: ").append(n).toString());
    }

    @Override
    public ASLList getASLList(int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device SpeechPhone.Request: ").append(n).toString());
    }

    @Override
    public ASLList createASLList(ASLListFactory aSLListFactory, int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device SpeechPhone.Request: ").append(n).toString());
    }
}

