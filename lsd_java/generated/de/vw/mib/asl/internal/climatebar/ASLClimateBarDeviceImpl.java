/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.climatebar;

import de.vw.mib.asl.internal.climatebar.transformer.ClimateBarClimateBarProfileModeVectorTransformer;
import de.vw.mib.asl.internal.climatebar.transformer.ClimateBarClimateBarSeatHeaterValueVectorTransformer;
import de.vw.mib.asl.internal.climatebar.transformer.ClimateBarClimateBarTemperatureRangeTransformer;
import de.vw.mib.asl.internal.climatebar.transformer.ClimateBarClimateBarTemperatureTransformer;
import de.vw.mib.asl.internal.climatebar.transformer.ClimateBarClimateSeatVentilationValueVectorTransformer;
import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.list.ItemTransformer;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.asl.internal.util.ListColumnsUtil;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.ServiceRegister;
import generated.de.vw.mib.asl.internal.climatebar.transformer.ClimateBarClimateBarTemperatureModesCollector;
import generated.de.vw.mib.asl.internal.climatebar.transformer.ClimateBarClimateBarTemperatureModesTransformer;

public final class ASLClimateBarDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLClimateBarDeviceImpl INSTANCE = new ASLClimateBarDeviceImpl();
    private static final String DEVICE_NAME;
    private final IntObjectOptHashMap listsMap = new IntObjectOptHashMap(8);
    private ASLListFactory listFactory;
    private static final String PACKAGE_BASE_IMPL;

    private ASLClimateBarDeviceImpl() {
    }

    public static ASLClimateBarDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "ClimateBar";
    }

    @Override
    public int getTargetId() {
        return 14701;
    }

    @Override
    public int getASLDeviceComplianceLevel() {
        return 2;
    }

    @Override
    public void registerASLLists(ASLListRegistry aSLListRegistry) {
        this.listFactory = aSLListRegistry.getASLListFactory();
        aSLListRegistry.registerASLDevice(832321536, this);
        aSLListRegistry.registerASLDevice(849098752, this);
        aSLListRegistry.registerASLDevice(1117534208, this);
        aSLListRegistry.registerASLDevice(1436301312, this);
        aSLListRegistry.registerASLDevice(1453078528, this);
        aSLListRegistry.registerASLDevice(1520187392, this);
        aSLListRegistry.registerASLDevice(1151088640, this);
        aSLListRegistry.registerASLDevice(1184643072, this);
    }

    @Override
    public void registerASLServices(ServiceRegister serviceRegister) {
        serviceRegister.registerService(695547968, 14701);
        serviceRegister.registerService(544553024, 14701);
        serviceRegister.registerService(561330240, 14701);
        serviceRegister.registerService(578107456, 14701);
        serviceRegister.registerService(628439104, 14701);
        serviceRegister.registerService(645216320, 14701);
        serviceRegister.registerService(611661888, 14701);
        serviceRegister.registerService(661993536, 14701);
        serviceRegister.registerService(678770752, 14701);
        serviceRegister.registerService(712325184, 14701);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        int[] nArray;
        switch (n) {
            case 3710001: {
                nArray = ListColumnsUtil.getSimpleIntArray(3);
                break;
            }
            case 3710002: {
                nArray = ListColumnsUtil.getSimpleIntArray(3);
                break;
            }
            case 3710018: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 3710037: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 3710038: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 3710042: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 3710020: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 3710022: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device ClimateBar: ").append(n).toString());
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
        return ASLClimateBarDeviceImpl.createGenericASLList(aSLListFactory, n);
    }

    public synchronized GenericASLList getGenericASLList(int n) {
        GenericASLList genericASLList = (GenericASLList)this.listsMap.get(n);
        if (null != genericASLList) {
            return genericASLList;
        }
        genericASLList = ASLClimateBarDeviceImpl.createGenericASLList(this.listFactory, n);
        this.listsMap.put(n, genericASLList);
        return genericASLList;
    }

    private static GenericASLList createGenericASLList(ASLListFactory aSLListFactory, int n) {
        GenericASLList genericASLList;
        switch (n) {
            case 3710001: {
                genericASLList = aSLListFactory.createGenericASLList(new ClimateBarClimateBarTemperatureModesTransformer(), n, "ClimateBar", "ClimateBarTemperatureModes");
                genericASLList.updateList(new ClimateBarClimateBarTemperatureModesCollector[]{new ClimateBarClimateBarTemperatureModesCollector()});
                break;
            }
            case 3710002: {
                genericASLList = aSLListFactory.createGenericASLList(new ClimateBarClimateBarTemperatureTransformer(), n, "ClimateBar", "ClimateBarTemperature");
                break;
            }
            case 3710018: {
                genericASLList = aSLListFactory.createGenericASLList(new ClimateBarClimateBarProfileModeVectorTransformer(), n, "ClimateBar", "ClimateBarProfileModeVector");
                break;
            }
            case 3710037: {
                genericASLList = aSLListFactory.createGenericASLList(ASLClimateBarDeviceImpl.getDeprecatedTransformer(n, aSLListFactory, "ClimateBarTemperatureRangeCelsius"), n, "ClimateBar", "ClimateBarTemperatureRangeCelsius");
                break;
            }
            case 3710038: {
                genericASLList = aSLListFactory.createGenericASLList(ASLClimateBarDeviceImpl.getDeprecatedTransformer(n, aSLListFactory, "ClimateBarTemperatureRangeFahrenheit"), n, "ClimateBar", "ClimateBarTemperatureRangeFahrenheit");
                break;
            }
            case 3710042: {
                genericASLList = aSLListFactory.createGenericASLList(new ClimateBarClimateBarTemperatureRangeTransformer(), n, "ClimateBar", "ClimateBarTemperatureRange");
                break;
            }
            case 3710020: {
                genericASLList = aSLListFactory.createGenericASLList(new ClimateBarClimateSeatVentilationValueVectorTransformer(), n, "ClimateBar", "ClimateSeatVentilationValueVector");
                break;
            }
            case 3710022: {
                genericASLList = aSLListFactory.createGenericASLList(new ClimateBarClimateBarSeatHeaterValueVectorTransformer(), n, "ClimateBar", "ClimateBarSeatHeaterValueVector");
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for type GenericASLList and device ClimateBar: ").append(n).toString());
            }
        }
        return genericASLList;
    }

    private static ItemTransformer getDeprecatedTransformer(int n, ASLListFactory aSLListFactory, String string) {
        String string2;
        String string3;
        switch (n) {
            case 3710037: {
                string3 = "de.vw.mib.asl.internal.climatebar.transformer.";
                string2 = "ClimateBarClimateBarTemperatureRangeCelsiusTransformer";
                break;
            }
            case 3710038: {
                string3 = "de.vw.mib.asl.internal.climatebar.transformer.";
                string2 = "ClimateBarClimateBarTemperatureRangeFahrenheitTransformer";
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid deprecated list id for device ClimateBar: ").append(n).toString());
            }
        }
        return aSLListFactory.getDeprecatedTransformer(n, string3, string2, "ClimateBar", string);
    }
}

