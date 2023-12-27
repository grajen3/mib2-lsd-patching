/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.speechnavigation.controller.destinationdetails;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.asl.internal.util.ListColumnsUtil;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.ServiceRegister;
import generated.de.vw.mib.asl.internal.speechnavigation.controller.destinationdetails.transformer.SpeechNavigationControllerDestinationDetailsDestinationDetailCollector;
import generated.de.vw.mib.asl.internal.speechnavigation.controller.destinationdetails.transformer.SpeechNavigationControllerDestinationDetailsDestinationDetailTransformer;

public final class ASLSpeechNavigationControllerDestinationDetailsDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLSpeechNavigationControllerDestinationDetailsDeviceImpl INSTANCE = new ASLSpeechNavigationControllerDestinationDetailsDeviceImpl();
    private static final String DEVICE_NAME;
    private final IntObjectOptHashMap listsMap = new IntObjectOptHashMap(1);
    private ASLListFactory listFactory;

    private ASLSpeechNavigationControllerDestinationDetailsDeviceImpl() {
    }

    public static ASLSpeechNavigationControllerDestinationDetailsDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "SpeechNavigation.Controller.DestinationDetails";
    }

    @Override
    public int getTargetId() {
        return 14415;
    }

    @Override
    public int getASLDeviceComplianceLevel() {
        return 2;
    }

    @Override
    public void registerASLLists(ASLListRegistry aSLListRegistry) {
        this.listFactory = aSLListRegistry.getASLListFactory();
        aSLListRegistry.registerASLDevice(1544041472, this);
    }

    @Override
    public void registerASLServices(ServiceRegister serviceRegister) {
        serviceRegister.registerService(-2115947712, 14415);
        serviceRegister.registerService(-1948175552, 14415);
        serviceRegister.registerService(-1964952768, 14415);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        int[] nArray;
        switch (n) {
            case 3410012: {
                nArray = ListColumnsUtil.getSimpleIntArray(17);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device SpeechNavigation.Controller.DestinationDetails: ").append(n).toString());
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
        return ASLSpeechNavigationControllerDestinationDetailsDeviceImpl.createGenericASLList(aSLListFactory, n);
    }

    public synchronized GenericASLList getGenericASLList(int n) {
        GenericASLList genericASLList = (GenericASLList)this.listsMap.get(n);
        if (null != genericASLList) {
            return genericASLList;
        }
        genericASLList = ASLSpeechNavigationControllerDestinationDetailsDeviceImpl.createGenericASLList(this.listFactory, n);
        this.listsMap.put(n, genericASLList);
        return genericASLList;
    }

    private static GenericASLList createGenericASLList(ASLListFactory aSLListFactory, int n) {
        GenericASLList genericASLList;
        switch (n) {
            case 3410012: {
                genericASLList = aSLListFactory.createGenericASLList(new SpeechNavigationControllerDestinationDetailsDestinationDetailTransformer(), n, "SpeechNavigation.Controller.DestinationDetails", "DestinationDetail");
                genericASLList.updateList(new SpeechNavigationControllerDestinationDetailsDestinationDetailCollector[]{new SpeechNavigationControllerDestinationDetailsDestinationDetailCollector()});
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for type GenericASLList and device SpeechNavigation.Controller.DestinationDetails: ").append(n).toString());
            }
        }
        return genericASLList;
    }
}

