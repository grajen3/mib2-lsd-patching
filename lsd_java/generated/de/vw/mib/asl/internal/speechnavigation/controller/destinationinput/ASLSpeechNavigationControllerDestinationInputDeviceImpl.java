/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.speechnavigation.controller.destinationinput;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.asl.internal.speechnavigation.controller.destinationinput.transformer.SpeechNavigationControllerDestinationInputMultistepResultDetailListTransformer;
import de.vw.mib.asl.internal.speechnavigation.controller.destinationinput.transformer.SpeechNavigationControllerDestinationInputMultistepResultListTransformer;
import de.vw.mib.asl.internal.speechnavigation.controller.destinationinput.transformer.SpeechNavigationControllerDestinationInputMultistepSelectedResultTransformer;
import de.vw.mib.asl.internal.util.ListColumnsUtil;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.ServiceRegister;
import generated.de.vw.mib.asl.internal.speechnavigation.controller.destinationinput.transformer.SpeechNavigationControllerDestinationInputLocationCollector;
import generated.de.vw.mib.asl.internal.speechnavigation.controller.destinationinput.transformer.SpeechNavigationControllerDestinationInputLocationTransformer;

public final class ASLSpeechNavigationControllerDestinationInputDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLSpeechNavigationControllerDestinationInputDeviceImpl INSTANCE = new ASLSpeechNavigationControllerDestinationInputDeviceImpl();
    private static final String DEVICE_NAME;
    private final IntObjectOptHashMap listsMap = new IntObjectOptHashMap(4);
    private ASLListFactory listFactory;

    private ASLSpeechNavigationControllerDestinationInputDeviceImpl() {
    }

    public static ASLSpeechNavigationControllerDestinationInputDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "SpeechNavigation.Controller.DestinationInput";
    }

    @Override
    public int getTargetId() {
        return 14414;
    }

    @Override
    public int getASLDeviceComplianceLevel() {
        return 2;
    }

    @Override
    public void registerASLLists(ASLListRegistry aSLListRegistry) {
        this.listFactory = aSLListRegistry.getASLListFactory();
        aSLListRegistry.registerASLDevice(1560818688, this);
        aSLListRegistry.registerASLDevice(1627927552, this);
        aSLListRegistry.registerASLDevice(1644704768, this);
        aSLListRegistry.registerASLDevice(1661481984, this);
    }

    @Override
    public void registerASLServices(ServiceRegister serviceRegister) {
        serviceRegister.registerService(1877029696, 14414);
        serviceRegister.registerService(2078356288, 14414);
        serviceRegister.registerService(-1092537536, 14414);
        serviceRegister.registerService(2095133504, 14414);
        serviceRegister.registerService(2111910720, 14414);
        serviceRegister.registerService(2128687936, 14414);
        serviceRegister.registerService(2145465152, 14414);
        serviceRegister.registerService(-2132724928, 14414);
        serviceRegister.registerService(-1746848960, 14414);
        serviceRegister.registerService(-1428081856, 14414);
        serviceRegister.registerService(-840879296, 14414);
        serviceRegister.registerService(-824102080, 14414);
        serviceRegister.registerService(-807324864, 14414);
        serviceRegister.registerService(-790547648, 14414);
        serviceRegister.registerService(-505334976, 14414);
        serviceRegister.registerService(-488557760, 14414);
        serviceRegister.registerService(-471780544, 14414);
        serviceRegister.registerService(-455003328, 14414);
        serviceRegister.registerService(-438226112, 14414);
        serviceRegister.registerService(-421448896, 14414);
        serviceRegister.registerService(-404671680, 14414);
        serviceRegister.registerService(-320785600, 14414);
        serviceRegister.registerService(-387894464, 14414);
        serviceRegister.registerService(-371117248, 14414);
        serviceRegister.registerService(-354340032, 14414);
        serviceRegister.registerService(-337562816, 14414);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        int[] nArray;
        switch (n) {
            case 3410013: {
                nArray = ListColumnsUtil.getSimpleIntArray(16);
                break;
            }
            case 3410017: {
                nArray = ListColumnsUtil.getSimpleIntArray(3);
                break;
            }
            case 3410018: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 3410019: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device SpeechNavigation.Controller.DestinationInput: ").append(n).toString());
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
        return ASLSpeechNavigationControllerDestinationInputDeviceImpl.createGenericASLList(aSLListFactory, n);
    }

    public synchronized GenericASLList getGenericASLList(int n) {
        GenericASLList genericASLList = (GenericASLList)this.listsMap.get(n);
        if (null != genericASLList) {
            return genericASLList;
        }
        genericASLList = ASLSpeechNavigationControllerDestinationInputDeviceImpl.createGenericASLList(this.listFactory, n);
        this.listsMap.put(n, genericASLList);
        return genericASLList;
    }

    private static GenericASLList createGenericASLList(ASLListFactory aSLListFactory, int n) {
        GenericASLList genericASLList;
        switch (n) {
            case 3410013: {
                genericASLList = aSLListFactory.createGenericASLList(new SpeechNavigationControllerDestinationInputLocationTransformer(), n, "SpeechNavigation.Controller.DestinationInput", "Location");
                genericASLList.updateList(new SpeechNavigationControllerDestinationInputLocationCollector[]{new SpeechNavigationControllerDestinationInputLocationCollector()});
                break;
            }
            case 3410017: {
                genericASLList = aSLListFactory.createGenericASLList(new SpeechNavigationControllerDestinationInputMultistepResultListTransformer(), n, "SpeechNavigation.Controller.DestinationInput", "MultistepResultList");
                break;
            }
            case 3410018: {
                genericASLList = aSLListFactory.createGenericASLList(new SpeechNavigationControllerDestinationInputMultistepResultDetailListTransformer(), n, "SpeechNavigation.Controller.DestinationInput", "MultistepResultDetailList");
                break;
            }
            case 3410019: {
                genericASLList = aSLListFactory.createGenericASLList(new SpeechNavigationControllerDestinationInputMultistepSelectedResultTransformer(), n, "SpeechNavigation.Controller.DestinationInput", "MultistepSelectedResult");
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for type GenericASLList and device SpeechNavigation.Controller.DestinationInput: ").append(n).toString());
            }
        }
        return genericASLList;
    }
}

