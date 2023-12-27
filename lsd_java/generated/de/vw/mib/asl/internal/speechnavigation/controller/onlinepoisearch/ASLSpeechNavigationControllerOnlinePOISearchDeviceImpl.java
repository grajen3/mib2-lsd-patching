/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.speechnavigation.controller.onlinepoisearch;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.asl.internal.speechnavigation.controller.onlinepoisearch.transformer.SpeechNavigationControllerOnlinePOISearchOnlinePOIListTransformer;
import de.vw.mib.asl.internal.speechnavigation.controller.onlinepoisearch.transformer.SpeechNavigationControllerOnlinePOISearchSelectedOnlinePOITransformer;
import de.vw.mib.asl.internal.util.ListColumnsUtil;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.ServiceRegister;

public final class ASLSpeechNavigationControllerOnlinePOISearchDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLSpeechNavigationControllerOnlinePOISearchDeviceImpl INSTANCE = new ASLSpeechNavigationControllerOnlinePOISearchDeviceImpl();
    private static final String DEVICE_NAME;
    private final IntObjectOptHashMap listsMap = new IntObjectOptHashMap(2);
    private ASLListFactory listFactory;

    private ASLSpeechNavigationControllerOnlinePOISearchDeviceImpl() {
    }

    public static ASLSpeechNavigationControllerOnlinePOISearchDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "SpeechNavigation.Controller.OnlinePOISearch";
    }

    @Override
    public int getTargetId() {
        return 14413;
    }

    @Override
    public int getASLDeviceComplianceLevel() {
        return 2;
    }

    @Override
    public void registerASLLists(ASLListRegistry aSLListRegistry) {
        this.listFactory = aSLListRegistry.getASLListFactory();
        aSLListRegistry.registerASLDevice(2114466816, this);
        aSLListRegistry.registerASLDevice(2131244032, this);
    }

    @Override
    public void registerASLServices(ServiceRegister serviceRegister) {
        serviceRegister.registerService(1843475264, 14413);
        serviceRegister.registerService(-1327418560, 14413);
        serviceRegister.registerService(-1310641344, 14413);
        serviceRegister.registerService(-1293864128, 14413);
        serviceRegister.registerService(-1243532480, 14413);
        serviceRegister.registerService(-1277086912, 14413);
        serviceRegister.registerService(-1260309696, 14413);
        serviceRegister.registerService(-1226755264, 14413);
        serviceRegister.registerService(-1209978048, 14413);
        serviceRegister.registerService(-1193200832, 14413);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        int[] nArray;
        switch (n) {
            case 3410046: {
                nArray = ListColumnsUtil.getSimpleIntArray(5);
                break;
            }
            case 3410047: {
                nArray = ListColumnsUtil.getSimpleIntArray(5);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device SpeechNavigation.Controller.OnlinePOISearch: ").append(n).toString());
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
        return ASLSpeechNavigationControllerOnlinePOISearchDeviceImpl.createGenericASLList(aSLListFactory, n);
    }

    public synchronized GenericASLList getGenericASLList(int n) {
        GenericASLList genericASLList = (GenericASLList)this.listsMap.get(n);
        if (null != genericASLList) {
            return genericASLList;
        }
        genericASLList = ASLSpeechNavigationControllerOnlinePOISearchDeviceImpl.createGenericASLList(this.listFactory, n);
        this.listsMap.put(n, genericASLList);
        return genericASLList;
    }

    private static GenericASLList createGenericASLList(ASLListFactory aSLListFactory, int n) {
        GenericASLList genericASLList;
        switch (n) {
            case 3410046: {
                genericASLList = aSLListFactory.createGenericASLList(new SpeechNavigationControllerOnlinePOISearchOnlinePOIListTransformer(), n, "SpeechNavigation.Controller.OnlinePOISearch", "OnlinePOIList");
                break;
            }
            case 3410047: {
                genericASLList = aSLListFactory.createGenericASLList(new SpeechNavigationControllerOnlinePOISearchSelectedOnlinePOITransformer(), n, "SpeechNavigation.Controller.OnlinePOISearch", "SelectedOnlinePOI");
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for type GenericASLList and device SpeechNavigation.Controller.OnlinePOISearch: ").append(n).toString());
            }
        }
        return genericASLList;
    }
}

