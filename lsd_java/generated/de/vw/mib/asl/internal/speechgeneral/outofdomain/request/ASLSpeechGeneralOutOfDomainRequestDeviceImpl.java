/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.speechgeneral.outofdomain.request;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.genericevents.ServiceRegister;

public final class ASLSpeechGeneralOutOfDomainRequestDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLSpeechGeneralOutOfDomainRequestDeviceImpl INSTANCE = new ASLSpeechGeneralOutOfDomainRequestDeviceImpl();
    private static final String DEVICE_NAME;

    private ASLSpeechGeneralOutOfDomainRequestDeviceImpl() {
    }

    public static ASLSpeechGeneralOutOfDomainRequestDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "SpeechGeneral.OutOfDomain.Request";
    }

    @Override
    public int getTargetId() {
        return 14205;
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
        serviceRegister.registerService(47460416, 14205);
        serviceRegister.registerService(64237632, 14205);
        serviceRegister.registerService(81014848, 14205);
        serviceRegister.registerService(97792064, 14205);
        serviceRegister.registerService(114569280, 14205);
        serviceRegister.registerService(131346496, 14205);
        serviceRegister.registerService(148123712, 14205);
        serviceRegister.registerService(164900928, 14205);
        serviceRegister.registerService(181678144, 14205);
        serviceRegister.registerService(198455360, 14205);
        serviceRegister.registerService(215232576, 14205);
        serviceRegister.registerService(232009792, 14205);
        serviceRegister.registerService(248787008, 14205);
        serviceRegister.registerService(265564224, 14205);
        serviceRegister.registerService(282341440, 14205);
        serviceRegister.registerService(299118656, 14205);
        serviceRegister.registerService(433336384, 14205);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device SpeechGeneral.OutOfDomain.Request: ").append(n).toString());
    }

    @Override
    public ASLList getASLList(int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device SpeechGeneral.OutOfDomain.Request: ").append(n).toString());
    }

    @Override
    public ASLList createASLList(ASLListFactory aSLListFactory, int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device SpeechGeneral.OutOfDomain.Request: ").append(n).toString());
    }
}

