/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.speechnavigation.controller.lastdestinations;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.asl.internal.speechnavigation.controller.lastdestinations.transformer.SpeechNavigationControllerLastDestinationsLastDestinationDetailListTransformer;
import de.vw.mib.asl.internal.speechnavigation.controller.lastdestinations.transformer.SpeechNavigationControllerLastDestinationsLastDestinationListTransformer;
import de.vw.mib.asl.internal.speechnavigation.controller.lastdestinations.transformer.SpeechNavigationControllerLastDestinationsLastDestinationSelectedItemTransformer;
import de.vw.mib.asl.internal.util.ListColumnsUtil;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.ServiceRegister;

public final class ASLSpeechNavigationControllerLastDestinationsDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLSpeechNavigationControllerLastDestinationsDeviceImpl INSTANCE = new ASLSpeechNavigationControllerLastDestinationsDeviceImpl();
    private static final String DEVICE_NAME;
    private final IntObjectOptHashMap listsMap = new IntObjectOptHashMap(3);
    private ASLListFactory listFactory;

    private ASLSpeechNavigationControllerLastDestinationsDeviceImpl() {
    }

    public static ASLSpeechNavigationControllerLastDestinationsDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "SpeechNavigation.Controller.LastDestinations";
    }

    @Override
    public int getTargetId() {
        return 14406;
    }

    @Override
    public int getASLDeviceComplianceLevel() {
        return 2;
    }

    @Override
    public void registerASLLists(ASLListRegistry aSLListRegistry) {
        this.listFactory = aSLListRegistry.getASLListFactory();
        aSLListRegistry.registerASLDevice(1393046528, this);
        aSLListRegistry.registerASLDevice(1409823744, this);
        aSLListRegistry.registerASLDevice(1426600960, this);
    }

    @Override
    public void registerASLServices(ServiceRegister serviceRegister) {
        serviceRegister.registerService(-1981729984, 14406);
        serviceRegister.registerService(1172386624, 14406);
        serviceRegister.registerService(1189163840, 14406);
        serviceRegister.registerService(1205941056, 14406);
        serviceRegister.registerService(1558262592, 14406);
        serviceRegister.registerService(1541485376, 14406);
        serviceRegister.registerService(1793143616, 14406);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        int[] nArray;
        switch (n) {
            case 3410003: {
                nArray = ListColumnsUtil.getSimpleIntArray(3);
                break;
            }
            case 3410004: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 3410005: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device SpeechNavigation.Controller.LastDestinations: ").append(n).toString());
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
        return ASLSpeechNavigationControllerLastDestinationsDeviceImpl.createGenericASLList(aSLListFactory, n);
    }

    public synchronized GenericASLList getGenericASLList(int n) {
        GenericASLList genericASLList = (GenericASLList)this.listsMap.get(n);
        if (null != genericASLList) {
            return genericASLList;
        }
        genericASLList = ASLSpeechNavigationControllerLastDestinationsDeviceImpl.createGenericASLList(this.listFactory, n);
        this.listsMap.put(n, genericASLList);
        return genericASLList;
    }

    private static GenericASLList createGenericASLList(ASLListFactory aSLListFactory, int n) {
        GenericASLList genericASLList;
        switch (n) {
            case 3410003: {
                genericASLList = aSLListFactory.createGenericASLList(new SpeechNavigationControllerLastDestinationsLastDestinationListTransformer(), n, "SpeechNavigation.Controller.LastDestinations", "LastDestinationList");
                break;
            }
            case 3410004: {
                genericASLList = aSLListFactory.createGenericASLList(new SpeechNavigationControllerLastDestinationsLastDestinationDetailListTransformer(), n, "SpeechNavigation.Controller.LastDestinations", "LastDestinationDetailList");
                break;
            }
            case 3410005: {
                genericASLList = aSLListFactory.createGenericASLList(new SpeechNavigationControllerLastDestinationsLastDestinationSelectedItemTransformer(), n, "SpeechNavigation.Controller.LastDestinations", "LastDestinationSelectedItem");
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for type GenericASLList and device SpeechNavigation.Controller.LastDestinations: ").append(n).toString());
            }
        }
        return genericASLList;
    }
}

