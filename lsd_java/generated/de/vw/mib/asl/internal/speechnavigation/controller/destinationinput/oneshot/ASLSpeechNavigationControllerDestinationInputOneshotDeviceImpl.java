/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.speechnavigation.controller.destinationinput.oneshot;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.asl.internal.speechnavigation.controller.destinationinput.oneshot.transformer.SpeechNavigationControllerDestinationInputOneshotOneshotResultDetailListTransformer;
import de.vw.mib.asl.internal.speechnavigation.controller.destinationinput.oneshot.transformer.SpeechNavigationControllerDestinationInputOneshotOneshotResultListTransformer;
import de.vw.mib.asl.internal.speechnavigation.controller.destinationinput.oneshot.transformer.SpeechNavigationControllerDestinationInputOneshotOneshotSelectedResultTransformer;
import de.vw.mib.asl.internal.util.ListColumnsUtil;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.ServiceRegister;

public final class ASLSpeechNavigationControllerDestinationInputOneshotDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLSpeechNavigationControllerDestinationInputOneshotDeviceImpl INSTANCE = new ASLSpeechNavigationControllerDestinationInputOneshotDeviceImpl();
    private static final String DEVICE_NAME;
    private final IntObjectOptHashMap listsMap = new IntObjectOptHashMap(3);
    private ASLListFactory listFactory;

    private ASLSpeechNavigationControllerDestinationInputOneshotDeviceImpl() {
    }

    public static ASLSpeechNavigationControllerDestinationInputOneshotDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "SpeechNavigation.Controller.DestinationInput.Oneshot";
    }

    @Override
    public int getTargetId() {
        return 14424;
    }

    @Override
    public int getASLDeviceComplianceLevel() {
        return 2;
    }

    @Override
    public void registerASLLists(ASLListRegistry aSLListRegistry) {
        this.listFactory = aSLListRegistry.getASLListFactory();
        aSLListRegistry.registerASLDevice(2064135168, this);
        aSLListRegistry.registerASLDevice(2080912384, this);
        aSLListRegistry.registerASLDevice(2097689600, this);
    }

    @Override
    public void registerASLServices(ServiceRegister serviceRegister) {
        serviceRegister.registerService(-1444859072, 14424);
        serviceRegister.registerService(-1461636288, 14424);
        serviceRegister.registerService(-1411304640, 14424);
        serviceRegister.registerService(-975097024, 14424);
        serviceRegister.registerService(-958319808, 14424);
        serviceRegister.registerService(-1394527424, 14424);
        serviceRegister.registerService(-1377750208, 14424);
        serviceRegister.registerService(-1360972992, 14424);
        serviceRegister.registerService(-1344195776, 14424);
        serviceRegister.registerService(-153013440, 14424);
        serviceRegister.registerService(-136236224, 14424);
        serviceRegister.registerService(-605998272, 14424);
        serviceRegister.registerService(-589221056, 14424);
        serviceRegister.registerService(-572443840, 14424);
        serviceRegister.registerService(-555666624, 14424);
        serviceRegister.registerService(-538889408, 14424);
        serviceRegister.registerService(-522112192, 14424);
        serviceRegister.registerService(-69127360, 14424);
        serviceRegister.registerService(-52350144, 14424);
        serviceRegister.registerService(-35572928, 14424);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        int[] nArray;
        switch (n) {
            case 3410043: {
                nArray = ListColumnsUtil.getSimpleIntArray(15);
                break;
            }
            case 3410044: {
                nArray = ListColumnsUtil.getSimpleIntArray(14);
                break;
            }
            case 3410045: {
                nArray = ListColumnsUtil.getSimpleIntArray(14);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device SpeechNavigation.Controller.DestinationInput.Oneshot: ").append(n).toString());
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
        return ASLSpeechNavigationControllerDestinationInputOneshotDeviceImpl.createGenericASLList(aSLListFactory, n);
    }

    public synchronized GenericASLList getGenericASLList(int n) {
        GenericASLList genericASLList = (GenericASLList)this.listsMap.get(n);
        if (null != genericASLList) {
            return genericASLList;
        }
        genericASLList = ASLSpeechNavigationControllerDestinationInputOneshotDeviceImpl.createGenericASLList(this.listFactory, n);
        this.listsMap.put(n, genericASLList);
        return genericASLList;
    }

    private static GenericASLList createGenericASLList(ASLListFactory aSLListFactory, int n) {
        GenericASLList genericASLList;
        switch (n) {
            case 3410043: {
                genericASLList = aSLListFactory.createGenericASLList(new SpeechNavigationControllerDestinationInputOneshotOneshotResultListTransformer(), n, "SpeechNavigation.Controller.DestinationInput.Oneshot", "OneshotResultList");
                break;
            }
            case 3410044: {
                genericASLList = aSLListFactory.createGenericASLList(new SpeechNavigationControllerDestinationInputOneshotOneshotResultDetailListTransformer(), n, "SpeechNavigation.Controller.DestinationInput.Oneshot", "OneshotResultDetailList");
                break;
            }
            case 3410045: {
                genericASLList = aSLListFactory.createGenericASLList(new SpeechNavigationControllerDestinationInputOneshotOneshotSelectedResultTransformer(), n, "SpeechNavigation.Controller.DestinationInput.Oneshot", "OneshotSelectedResult");
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for type GenericASLList and device SpeechNavigation.Controller.DestinationInput.Oneshot: ").append(n).toString());
            }
        }
        return genericASLList;
    }
}

