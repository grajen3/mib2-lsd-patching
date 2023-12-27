/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.climate;

import de.vw.mib.asl.internal.climate.transformer.ClimateAirDistributionSliderTransformer;
import de.vw.mib.asl.internal.climate.transformer.ClimateClimatePresetModeVectorsTransformer;
import de.vw.mib.asl.internal.climate.transformer.ClimateClimateProfileModeVectorTransformer;
import de.vw.mib.asl.internal.climate.transformer.ClimateTemperatureButtonModeVectorsTransformer;
import de.vw.mib.asl.internal.climate.transformer.ClimateTemperatureButtonTransformer;
import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.asl.internal.util.ListColumnsUtil;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.ServiceRegister;
import generated.de.vw.mib.asl.internal.climate.transformer.ClimateAirDistributionCollector;
import generated.de.vw.mib.asl.internal.climate.transformer.ClimateAirDistributionSliderFrontCollector;
import generated.de.vw.mib.asl.internal.climate.transformer.ClimateAirDistributionSliderFrontTransformer;
import generated.de.vw.mib.asl.internal.climate.transformer.ClimateAirDistributionSliderRearCollector;
import generated.de.vw.mib.asl.internal.climate.transformer.ClimateAirDistributionSliderRearTransformer;
import generated.de.vw.mib.asl.internal.climate.transformer.ClimateAirDistributionTransformer;
import generated.de.vw.mib.asl.internal.climate.transformer.ClimateClimateAirFlowStateCollector;
import generated.de.vw.mib.asl.internal.climate.transformer.ClimateClimateAirFlowStateTransformer;
import generated.de.vw.mib.asl.internal.climate.transformer.ClimateClimatePresetModeCollector;
import generated.de.vw.mib.asl.internal.climate.transformer.ClimateClimatePresetModeTransformer;
import generated.de.vw.mib.asl.internal.climate.transformer.ClimateCurrentTemperatureFondGroupCollector;
import generated.de.vw.mib.asl.internal.climate.transformer.ClimateCurrentTemperatureFondGroupTransformer;
import generated.de.vw.mib.asl.internal.climate.transformer.ClimateCurrentTemperatureFrontLeftGroupCollector;
import generated.de.vw.mib.asl.internal.climate.transformer.ClimateCurrentTemperatureFrontLeftGroupTransformer;
import generated.de.vw.mib.asl.internal.climate.transformer.ClimateCurrentTemperatureFrontRightGroupCollector;
import generated.de.vw.mib.asl.internal.climate.transformer.ClimateCurrentTemperatureFrontRightGroupTransformer;
import generated.de.vw.mib.asl.internal.climate.transformer.ClimateParkHeatingTimer1Collector;
import generated.de.vw.mib.asl.internal.climate.transformer.ClimateParkHeatingTimer1Transformer;
import generated.de.vw.mib.asl.internal.climate.transformer.ClimateParkHeatingTimer2Collector;
import generated.de.vw.mib.asl.internal.climate.transformer.ClimateParkHeatingTimer2Transformer;
import generated.de.vw.mib.asl.internal.climate.transformer.ClimateParkHeatingTimer3Collector;
import generated.de.vw.mib.asl.internal.climate.transformer.ClimateParkHeatingTimer3Transformer;
import generated.de.vw.mib.asl.internal.climate.transformer.ClimateTemperatureButtonModesCollector;
import generated.de.vw.mib.asl.internal.climate.transformer.ClimateTemperatureButtonModesTransformer;

public final class ASLClimateDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLClimateDeviceImpl INSTANCE = new ASLClimateDeviceImpl();
    private static final String DEVICE_NAME;
    private final IntObjectOptHashMap listsMap = new IntObjectOptHashMap(17);
    private ASLListFactory listFactory;

    private ASLClimateDeviceImpl() {
    }

    public static ASLClimateDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "Climate";
    }

    @Override
    public int getTargetId() {
        return 10021;
    }

    @Override
    public int getASLDeviceComplianceLevel() {
        return 2;
    }

    @Override
    public void registerASLLists(ASLListRegistry aSLListRegistry) {
        this.listFactory = aSLListRegistry.getASLListFactory();
        aSLListRegistry.registerASLDevice(328, this);
        aSLListRegistry.registerASLDevice(329, this);
        aSLListRegistry.registerASLDevice(330, this);
        aSLListRegistry.registerASLDevice(327, this);
        aSLListRegistry.registerASLDevice(331, this);
        aSLListRegistry.registerASLDevice(332, this);
        aSLListRegistry.registerASLDevice(333, this);
        aSLListRegistry.registerASLDevice(-508755712, this);
        aSLListRegistry.registerASLDevice(-928186112, this);
        aSLListRegistry.registerASLDevice(-911408896, this);
        aSLListRegistry.registerASLDevice(-693305088, this);
        aSLListRegistry.registerASLDevice(-626196224, this);
        aSLListRegistry.registerASLDevice(-659750656, this);
        aSLListRegistry.registerASLDevice(-290651904, this);
        aSLListRegistry.registerASLDevice(-491978496, this);
        aSLListRegistry.registerASLDevice(-307429120, this);
        aSLListRegistry.registerASLDevice(-525532928, this);
    }

    @Override
    public void registerASLServices(ServiceRegister serviceRegister) {
        serviceRegister.registerService(1711996992, 10021);
        serviceRegister.registerService(-436207552, 10021);
        serviceRegister.registerService(-419430336, 10021);
        serviceRegister.registerService(-452329408, 10021);
        serviceRegister.registerService(-402653120, 10021);
        serviceRegister.registerService(-385875904, 10021);
        serviceRegister.registerService(-369098688, 10021);
        serviceRegister.registerService(-352321472, 10021);
        serviceRegister.registerService(-335544256, 10021);
        serviceRegister.registerService(-318767040, 10021);
        serviceRegister.registerService(-301989824, 10021);
        serviceRegister.registerService(-285212608, 10021);
        serviceRegister.registerService(-268435392, 10021);
        serviceRegister.registerService(571080768, 10021);
        serviceRegister.registerService(-435552192, 10021);
        serviceRegister.registerService(-1215954624, 10021);
        serviceRegister.registerService(-1199177408, 10021);
        serviceRegister.registerService(-1081736896, 10021);
        serviceRegister.registerService(-1064959680, 10021);
        serviceRegister.registerService(-251658176, 10021);
        serviceRegister.registerService(1124466752, 10021);
        serviceRegister.registerService(-234880960, 10021);
        serviceRegister.registerService(-218103744, 10021);
        serviceRegister.registerService(-201326528, 10021);
        serviceRegister.registerService(-184549312, 10021);
        serviceRegister.registerService(-167772096, 10021);
        serviceRegister.registerService(-150994880, 10021);
        serviceRegister.registerService(-134217664, 10021);
        serviceRegister.registerService(-117440448, 10021);
        serviceRegister.registerService(-100663232, 10021);
        serviceRegister.registerService(-83886016, 10021);
        serviceRegister.registerService(-67108800, 10021);
        serviceRegister.registerService(-50331584, 10021);
        serviceRegister.registerService(-33554368, 10021);
        serviceRegister.registerService(-1568276160, 10021);
        serviceRegister.registerService(-930741952, 10021);
        serviceRegister.registerService(-913964736, 10021);
        serviceRegister.registerService(-16777152, 10021);
        serviceRegister.registerService(-150536128, 10021);
        serviceRegister.registerService(-133758912, 10021);
        serviceRegister.registerService(353042496, 10021);
        serviceRegister.registerService(369819712, 10021);
        serviceRegister.registerService(386596928, 10021);
        serviceRegister.registerService(403374144, 10021);
        serviceRegister.registerService(1107886144, 10021);
        serviceRegister.registerService(168493120, 10021);
        serviceRegister.registerService(0xB0B0040, 10021);
        serviceRegister.registerService(0x4090040, 10021);
        serviceRegister.registerService(-1551498944, 10021);
        serviceRegister.registerService(-1534721728, 10021);
        serviceRegister.registerService(-1601830592, 10021);
        serviceRegister.registerService(-1585053376, 10021);
        serviceRegister.registerService(-1517944512, 10021);
        serviceRegister.registerService(-1484390080, 10021);
        serviceRegister.registerService(-1467612864, 10021);
        serviceRegister.registerService(-1450835648, 10021);
        serviceRegister.registerService(-1434058432, 10021);
        serviceRegister.registerService(-1417281216, 10021);
        serviceRegister.registerService(-1249509056, 10021);
        serviceRegister.registerService(-1333395136, 10021);
        serviceRegister.registerService(-1266286272, 10021);
        serviceRegister.registerService(-1316617920, 10021);
        serviceRegister.registerService(-1283063488, 10021);
        serviceRegister.registerService(-1299840704, 10021);
        serviceRegister.registerService(-1232731840, 10021);
        serviceRegister.registerService(-897187520, 10021);
        serviceRegister.registerService(-1048182464, 10021);
        serviceRegister.registerService(-1182400192, 10021);
        serviceRegister.registerService(-1165622976, 10021);
        serviceRegister.registerService(-1148845760, 10021);
        serviceRegister.registerService(-1132068544, 10021);
        serviceRegister.registerService(-1115291328, 10021);
        serviceRegister.registerService(-1098514112, 10021);
        serviceRegister.registerService(-1031405248, 10021);
        serviceRegister.registerService(-1014628032, 10021);
        serviceRegister.registerService(-997850816, 10021);
        serviceRegister.registerService(-981073600, 10021);
        serviceRegister.registerService(-964296384, 10021);
        serviceRegister.registerService(-947519168, 10021);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        int[] nArray;
        switch (n) {
            case 328: {
                nArray = ListColumnsUtil.getSimpleIntArray(4);
                break;
            }
            case 329: {
                nArray = ListColumnsUtil.getSimpleIntArray(4);
                break;
            }
            case 330: {
                nArray = ListColumnsUtil.getSimpleIntArray(4);
                break;
            }
            case 327: {
                nArray = ListColumnsUtil.getSimpleIntArray(10);
                break;
            }
            case 331: {
                nArray = ListColumnsUtil.getSimpleIntArray(3);
                break;
            }
            case 332: {
                nArray = ListColumnsUtil.getSimpleIntArray(3);
                break;
            }
            case 333: {
                nArray = ListColumnsUtil.getSimpleIntArray(3);
                break;
            }
            case 110049: {
                nArray = ListColumnsUtil.getSimpleIntArray(3);
                break;
            }
            case 110024: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 110025: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 110038: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 110042: {
                nArray = ListColumnsUtil.getSimpleIntArray(4);
                break;
            }
            case 110040: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 110062: {
                nArray = ListColumnsUtil.getSimpleIntArray(3);
                break;
            }
            case 110050: {
                nArray = ListColumnsUtil.getSimpleIntArray(3);
                break;
            }
            case 110061: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 110048: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Climate: ").append(n).toString());
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
        return ASLClimateDeviceImpl.createGenericASLList(aSLListFactory, n);
    }

    public synchronized GenericASLList getGenericASLList(int n) {
        GenericASLList genericASLList = (GenericASLList)this.listsMap.get(n);
        if (null != genericASLList) {
            return genericASLList;
        }
        genericASLList = ASLClimateDeviceImpl.createGenericASLList(this.listFactory, n);
        this.listsMap.put(n, genericASLList);
        return genericASLList;
    }

    private static GenericASLList createGenericASLList(ASLListFactory aSLListFactory, int n) {
        GenericASLList genericASLList;
        switch (n) {
            case 328: {
                genericASLList = aSLListFactory.createGenericASLList(new ClimateParkHeatingTimer1Transformer(), n, "Climate", "ParkHeatingTimer1");
                genericASLList.updateList(new ClimateParkHeatingTimer1Collector[]{new ClimateParkHeatingTimer1Collector()});
                break;
            }
            case 329: {
                genericASLList = aSLListFactory.createGenericASLList(new ClimateParkHeatingTimer2Transformer(), n, "Climate", "ParkHeatingTimer2");
                genericASLList.updateList(new ClimateParkHeatingTimer2Collector[]{new ClimateParkHeatingTimer2Collector()});
                break;
            }
            case 330: {
                genericASLList = aSLListFactory.createGenericASLList(new ClimateParkHeatingTimer3Transformer(), n, "Climate", "ParkHeatingTimer3");
                genericASLList.updateList(new ClimateParkHeatingTimer3Collector[]{new ClimateParkHeatingTimer3Collector()});
                break;
            }
            case 327: {
                genericASLList = aSLListFactory.createGenericASLList(new ClimateAirDistributionTransformer(), n, "Climate", "AirDistribution");
                genericASLList.updateList(new ClimateAirDistributionCollector[]{new ClimateAirDistributionCollector()});
                break;
            }
            case 331: {
                genericASLList = aSLListFactory.createGenericASLList(new ClimateCurrentTemperatureFondGroupTransformer(), n, "Climate", "CurrentTemperatureFondGroup");
                genericASLList.updateList(new ClimateCurrentTemperatureFondGroupCollector[]{new ClimateCurrentTemperatureFondGroupCollector()});
                break;
            }
            case 332: {
                genericASLList = aSLListFactory.createGenericASLList(new ClimateCurrentTemperatureFrontLeftGroupTransformer(), n, "Climate", "CurrentTemperatureFrontLeftGroup");
                genericASLList.updateList(new ClimateCurrentTemperatureFrontLeftGroupCollector[]{new ClimateCurrentTemperatureFrontLeftGroupCollector()});
                break;
            }
            case 333: {
                genericASLList = aSLListFactory.createGenericASLList(new ClimateCurrentTemperatureFrontRightGroupTransformer(), n, "Climate", "CurrentTemperatureFrontRightGroup");
                genericASLList.updateList(new ClimateCurrentTemperatureFrontRightGroupCollector[]{new ClimateCurrentTemperatureFrontRightGroupCollector()});
                break;
            }
            case 110049: {
                genericASLList = aSLListFactory.createGenericASLList(new ClimateTemperatureButtonModeVectorsTransformer(), n, "Climate", "TemperatureButtonModeVectors");
                break;
            }
            case 110024: {
                genericASLList = aSLListFactory.createGenericASLList(new ClimateAirDistributionSliderFrontTransformer(), n, "Climate", "AirDistributionSliderFront");
                genericASLList.updateList(new ClimateAirDistributionSliderFrontCollector[]{new ClimateAirDistributionSliderFrontCollector()});
                break;
            }
            case 110025: {
                genericASLList = aSLListFactory.createGenericASLList(new ClimateAirDistributionSliderRearTransformer(), n, "Climate", "AirDistributionSliderRear");
                genericASLList.updateList(new ClimateAirDistributionSliderRearCollector[]{new ClimateAirDistributionSliderRearCollector()});
                break;
            }
            case 110038: {
                genericASLList = aSLListFactory.createGenericASLList(new ClimateClimateAirFlowStateTransformer(), n, "Climate", "ClimateAirFlowState");
                genericASLList.updateList(new ClimateClimateAirFlowStateCollector[]{new ClimateClimateAirFlowStateCollector()});
                break;
            }
            case 110042: {
                genericASLList = aSLListFactory.createGenericASLList(new ClimateClimatePresetModeVectorsTransformer(), n, "Climate", "ClimatePresetModeVectors");
                break;
            }
            case 110040: {
                genericASLList = aSLListFactory.createGenericASLList(new ClimateClimatePresetModeTransformer(), n, "Climate", "ClimatePresetMode");
                genericASLList.updateList(new ClimateClimatePresetModeCollector[]{new ClimateClimatePresetModeCollector()});
                break;
            }
            case 110062: {
                genericASLList = aSLListFactory.createGenericASLList(new ClimateTemperatureButtonTransformer(), n, "Climate", "TemperatureButton");
                break;
            }
            case 110050: {
                genericASLList = aSLListFactory.createGenericASLList(new ClimateTemperatureButtonModesTransformer(), n, "Climate", "TemperatureButtonModes");
                genericASLList.updateList(new ClimateTemperatureButtonModesCollector[]{new ClimateTemperatureButtonModesCollector()});
                break;
            }
            case 110061: {
                genericASLList = aSLListFactory.createGenericASLList(new ClimateAirDistributionSliderTransformer(), n, "Climate", "AirDistributionSlider");
                break;
            }
            case 110048: {
                genericASLList = aSLListFactory.createGenericASLList(new ClimateClimateProfileModeVectorTransformer(), n, "Climate", "ClimateProfileModeVector");
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for type GenericASLList and device Climate: ").append(n).toString());
            }
        }
        return genericASLList;
    }
}

