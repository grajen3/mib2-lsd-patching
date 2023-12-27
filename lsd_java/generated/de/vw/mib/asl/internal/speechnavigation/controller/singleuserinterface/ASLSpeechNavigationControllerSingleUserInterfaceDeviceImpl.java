/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.speechnavigation.controller.singleuserinterface;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.asl.internal.speechnavigation.controller.singleuserinterface.transformer.SpeechNavigationControllerSingleUserInterfaceSUIResultDetailListTransformer;
import de.vw.mib.asl.internal.speechnavigation.controller.singleuserinterface.transformer.SpeechNavigationControllerSingleUserInterfaceSUIResultListTransformer;
import de.vw.mib.asl.internal.speechnavigation.controller.singleuserinterface.transformer.SpeechNavigationControllerSingleUserInterfaceSUISelectedResultTransformer;
import de.vw.mib.asl.internal.util.ListColumnsUtil;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.ServiceRegister;

public final class ASLSpeechNavigationControllerSingleUserInterfaceDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLSpeechNavigationControllerSingleUserInterfaceDeviceImpl INSTANCE = new ASLSpeechNavigationControllerSingleUserInterfaceDeviceImpl();
    private static final String DEVICE_NAME;
    private final IntObjectOptHashMap listsMap = new IntObjectOptHashMap(3);
    private ASLListFactory listFactory;

    private ASLSpeechNavigationControllerSingleUserInterfaceDeviceImpl() {
    }

    public static ASLSpeechNavigationControllerSingleUserInterfaceDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "SpeechNavigation.Controller.SingleUserInterface";
    }

    @Override
    public int getTargetId() {
        return 14425;
    }

    @Override
    public int getASLDeviceComplianceLevel() {
        return 2;
    }

    @Override
    public void registerASLLists(ASLListRegistry aSLListRegistry) {
        this.listFactory = aSLListRegistry.getASLListFactory();
        aSLListRegistry.registerASLDevice(-2146946048, this);
        aSLListRegistry.registerASLDevice(-2130168832, this);
        aSLListRegistry.registerASLDevice(-2113391616, this);
    }

    @Override
    public void registerASLServices(ServiceRegister serviceRegister) {
        serviceRegister.registerService(-1176423616, 14425);
        serviceRegister.registerService(-1159646400, 14425);
        serviceRegister.registerService(-1142869184, 14425);
        serviceRegister.registerService(-1126091968, 14425);
        serviceRegister.registerService(-1109314752, 14425);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        int[] nArray;
        switch (n) {
            case 3410048: {
                nArray = ListColumnsUtil.getSimpleIntArray(24);
                break;
            }
            case 3410049: {
                nArray = ListColumnsUtil.getSimpleIntArray(23);
                break;
            }
            case 3410050: {
                nArray = ListColumnsUtil.getSimpleIntArray(21);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device SpeechNavigation.Controller.SingleUserInterface: ").append(n).toString());
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
        return ASLSpeechNavigationControllerSingleUserInterfaceDeviceImpl.createGenericASLList(aSLListFactory, n);
    }

    public synchronized GenericASLList getGenericASLList(int n) {
        GenericASLList genericASLList = (GenericASLList)this.listsMap.get(n);
        if (null != genericASLList) {
            return genericASLList;
        }
        genericASLList = ASLSpeechNavigationControllerSingleUserInterfaceDeviceImpl.createGenericASLList(this.listFactory, n);
        this.listsMap.put(n, genericASLList);
        return genericASLList;
    }

    private static GenericASLList createGenericASLList(ASLListFactory aSLListFactory, int n) {
        GenericASLList genericASLList;
        switch (n) {
            case 3410048: {
                genericASLList = aSLListFactory.createGenericASLList(new SpeechNavigationControllerSingleUserInterfaceSUIResultListTransformer(), n, "SpeechNavigation.Controller.SingleUserInterface", "SUIResultList");
                break;
            }
            case 3410049: {
                genericASLList = aSLListFactory.createGenericASLList(new SpeechNavigationControllerSingleUserInterfaceSUIResultDetailListTransformer(), n, "SpeechNavigation.Controller.SingleUserInterface", "SUIResultDetailList");
                break;
            }
            case 3410050: {
                genericASLList = aSLListFactory.createGenericASLList(new SpeechNavigationControllerSingleUserInterfaceSUISelectedResultTransformer(), n, "SpeechNavigation.Controller.SingleUserInterface", "SUISelectedResult");
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for type GenericASLList and device SpeechNavigation.Controller.SingleUserInterface: ").append(n).toString());
            }
        }
        return genericASLList;
    }
}

