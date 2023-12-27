/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.speechnavigation.controller.guidance;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.asl.internal.util.ListColumnsUtil;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.ServiceRegister;
import generated.de.vw.mib.asl.internal.speechnavigation.controller.guidance.transformer.SpeechNavigationControllerGuidanceRouteInformationCollector;
import generated.de.vw.mib.asl.internal.speechnavigation.controller.guidance.transformer.SpeechNavigationControllerGuidanceRouteInformationTransformer;

public final class ASLSpeechNavigationControllerGuidanceDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLSpeechNavigationControllerGuidanceDeviceImpl INSTANCE = new ASLSpeechNavigationControllerGuidanceDeviceImpl();
    private static final String DEVICE_NAME;
    private final IntObjectOptHashMap listsMap = new IntObjectOptHashMap(1);
    private ASLListFactory listFactory;

    private ASLSpeechNavigationControllerGuidanceDeviceImpl() {
    }

    public static ASLSpeechNavigationControllerGuidanceDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "SpeechNavigation.Controller.Guidance";
    }

    @Override
    public int getTargetId() {
        return 14408;
    }

    @Override
    public int getASLDeviceComplianceLevel() {
        return 2;
    }

    @Override
    public void registerASLLists(ASLListRegistry aSLListRegistry) {
        this.listFactory = aSLListRegistry.getASLListFactory();
        aSLListRegistry.registerASLDevice(1527264256, this);
    }

    @Override
    public void registerASLServices(ServiceRegister serviceRegister) {
        serviceRegister.registerService(1994470208, 14408);
        serviceRegister.registerService(2011247424, 14408);
        serviceRegister.registerService(2028024640, 14408);
        serviceRegister.registerService(2044801856, 14408);
        serviceRegister.registerService(2061579072, 14408);
        serviceRegister.registerService(1239495488, 14408);
        serviceRegister.registerService(1256272704, 14408);
        serviceRegister.registerService(1273049920, 14408);
        serviceRegister.registerService(1289827136, 14408);
        serviceRegister.registerService(1306604352, 14408);
        serviceRegister.registerService(1323381568, 14408);
        serviceRegister.registerService(1340158784, 14408);
        serviceRegister.registerService(1356936000, 14408);
        serviceRegister.registerService(1373713216, 14408);
        serviceRegister.registerService(1860252480, 14408);
        serviceRegister.registerService(1927361344, 14408);
        serviceRegister.registerService(1944138560, 14408);
        serviceRegister.registerService(1960915776, 14408);
        serviceRegister.registerService(1977692992, 14408);
        serviceRegister.registerService(-1998507200, 14408);
        serviceRegister.registerService(-2099170496, 14408);
        serviceRegister.registerService(-2082393280, 14408);
        serviceRegister.registerService(-2065616064, 14408);
        serviceRegister.registerService(-2048838848, 14408);
        serviceRegister.registerService(-2032061632, 14408);
        serviceRegister.registerService(-2015284416, 14408);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        int[] nArray;
        switch (n) {
            case 3410011: {
                nArray = ListColumnsUtil.getSimpleIntArray(7);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device SpeechNavigation.Controller.Guidance: ").append(n).toString());
            }
        }
        return nArray;
    }

    @Override
    public ASLList getASLList(int n) {
        return this.getGenericASLList(n);
    }

    @Override
    public ASLList createASLList(ASLListFactory aSLListFactory, int n) {
        return ASLSpeechNavigationControllerGuidanceDeviceImpl.createGenericASLList(aSLListFactory, n);
    }

    public synchronized GenericASLList getGenericASLList(int n) {
        GenericASLList genericASLList = (GenericASLList)this.listsMap.get(n);
        if (null != genericASLList) {
            return genericASLList;
        }
        genericASLList = ASLSpeechNavigationControllerGuidanceDeviceImpl.createGenericASLList(this.listFactory, n);
        this.listsMap.put(n, genericASLList);
        return genericASLList;
    }

    private static GenericASLList createGenericASLList(ASLListFactory aSLListFactory, int n) {
        GenericASLList genericASLList;
        switch (n) {
            case 3410011: {
                genericASLList = aSLListFactory.createGenericASLList(new SpeechNavigationControllerGuidanceRouteInformationTransformer(), n, "SpeechNavigation.Controller.Guidance", "RouteInformation");
                genericASLList.updateList(new SpeechNavigationControllerGuidanceRouteInformationCollector[]{new SpeechNavigationControllerGuidanceRouteInformationCollector()});
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for type GenericASLList and device SpeechNavigation.Controller.Guidance: ").append(n).toString());
            }
        }
        return genericASLList;
    }
}

