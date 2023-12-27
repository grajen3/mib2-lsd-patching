/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.speechnavigation.controller.navigatecontact;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.genericevents.ServiceRegister;

public final class ASLSpeechNavigationControllerNavigateContactDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLSpeechNavigationControllerNavigateContactDeviceImpl INSTANCE = new ASLSpeechNavigationControllerNavigateContactDeviceImpl();
    private static final String DEVICE_NAME;

    private ASLSpeechNavigationControllerNavigateContactDeviceImpl() {
    }

    public static ASLSpeechNavigationControllerNavigateContactDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "SpeechNavigation.Controller.NavigateContact";
    }

    @Override
    public int getTargetId() {
        return 14411;
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
        serviceRegister.registerService(1809920832, 14411);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device SpeechNavigation.Controller.NavigateContact: ").append(n).toString());
    }

    @Override
    public ASLList getASLList(int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device SpeechNavigation.Controller.NavigateContact: ").append(n).toString());
    }

    @Override
    public ASLList createASLList(ASLListFactory aSLListFactory, int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device SpeechNavigation.Controller.NavigateContact: ").append(n).toString());
    }
}

