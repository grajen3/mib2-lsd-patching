/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.speechtuner.data.frequency;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.asl.internal.speechtuner.data.frequency.transformer.SpeechTunerDataFrequencyAMFrequencyAndSubchannelTransformer;
import de.vw.mib.asl.internal.speechtuner.data.frequency.transformer.SpeechTunerDataFrequencyFMFrequencyAndSubchannelTransformer;
import de.vw.mib.asl.internal.util.ListColumnsUtil;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.ServiceRegister;

public final class ASLSpeechTunerDataFrequencyDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLSpeechTunerDataFrequencyDeviceImpl INSTANCE = new ASLSpeechTunerDataFrequencyDeviceImpl();
    private static final String DEVICE_NAME;
    private final IntObjectOptHashMap listsMap = new IntObjectOptHashMap(2);
    private ASLListFactory listFactory;

    private ASLSpeechTunerDataFrequencyDeviceImpl() {
    }

    public static ASLSpeechTunerDataFrequencyDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "SpeechTuner.Data.Frequency";
    }

    @Override
    public int getTargetId() {
        return 14807;
    }

    @Override
    public int getASLDeviceComplianceLevel() {
        return 2;
    }

    @Override
    public void registerASLLists(ASLListRegistry aSLListRegistry) {
        this.listFactory = aSLListRegistry.getASLListFactory();
        aSLListRegistry.registerASLDevice(-584959488, this);
        aSLListRegistry.registerASLDevice(-568182272, this);
    }

    @Override
    public void registerASLServices(ServiceRegister serviceRegister) {
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        int[] nArray;
        switch (n) {
            case 3810013: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 3810014: {
                nArray = ListColumnsUtil.getSimpleIntArray(3);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device SpeechTuner.Data.Frequency: ").append(n).toString());
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
        return ASLSpeechTunerDataFrequencyDeviceImpl.createGenericASLList(aSLListFactory, n);
    }

    public synchronized GenericASLList getGenericASLList(int n) {
        GenericASLList genericASLList = (GenericASLList)this.listsMap.get(n);
        if (null != genericASLList) {
            return genericASLList;
        }
        genericASLList = ASLSpeechTunerDataFrequencyDeviceImpl.createGenericASLList(this.listFactory, n);
        this.listsMap.put(n, genericASLList);
        return genericASLList;
    }

    private static GenericASLList createGenericASLList(ASLListFactory aSLListFactory, int n) {
        GenericASLList genericASLList;
        switch (n) {
            case 3810013: {
                genericASLList = aSLListFactory.createGenericASLList(new SpeechTunerDataFrequencyAMFrequencyAndSubchannelTransformer(), n, "SpeechTuner.Data.Frequency", "AMFrequencyAndSubchannel");
                break;
            }
            case 3810014: {
                genericASLList = aSLListFactory.createGenericASLList(new SpeechTunerDataFrequencyFMFrequencyAndSubchannelTransformer(), n, "SpeechTuner.Data.Frequency", "FMFrequencyAndSubchannel");
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for type GenericASLList and device SpeechTuner.Data.Frequency: ").append(n).toString());
            }
        }
        return genericASLList;
    }
}

