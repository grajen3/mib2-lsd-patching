/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.speechnavigation.controller.prerequisites;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.genericevents.ServiceRegister;

public final class ASLSpeechNavigationControllerPrerequisitesDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLSpeechNavigationControllerPrerequisitesDeviceImpl INSTANCE = new ASLSpeechNavigationControllerPrerequisitesDeviceImpl();
    private static final String DEVICE_NAME;

    private ASLSpeechNavigationControllerPrerequisitesDeviceImpl() {
    }

    public static ASLSpeechNavigationControllerPrerequisitesDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "SpeechNavigation.Controller.Prerequisites";
    }

    @Override
    public int getTargetId() {
        return 14410;
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
        serviceRegister.registerService(1675703104, 14410);
        serviceRegister.registerService(1692480320, 14410);
        serviceRegister.registerService(1709257536, 14410);
        serviceRegister.registerService(1726034752, 14410);
        serviceRegister.registerService(1742811968, 14410);
        serviceRegister.registerService(1759589184, 14410);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device SpeechNavigation.Controller.Prerequisites: ").append(n).toString());
    }

    @Override
    public ASLList getASLList(int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device SpeechNavigation.Controller.Prerequisites: ").append(n).toString());
    }

    @Override
    public ASLList createASLList(ASLListFactory aSLListFactory, int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device SpeechNavigation.Controller.Prerequisites: ").append(n).toString());
    }
}

