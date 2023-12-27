/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.thinkblue.calc;

import de.vw.mib.asl.api.car.thinkblue.TBTServiceListener;
import de.vw.mib.asl.api.system.ASLSystemFactory;
import de.vw.mib.asl.framework.api.diagnosis.config.EcoHmi;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.car.framework.services.ServiceFactory;
import de.vw.mib.asl.internal.car.thinkblue.ASLTargetThinkBlue;
import de.vw.mib.asl.internal.car.thinkblue.AverageData;
import de.vw.mib.asl.internal.car.thinkblue.ConsumptionHistoryDiagram;
import de.vw.mib.asl.internal.car.thinkblue.HistoryDiagram;
import de.vw.mib.asl.internal.car.thinkblue.PersistableHighFreq;
import de.vw.mib.asl.internal.car.thinkblue.PersistableMidFreq;
import de.vw.mib.asl.internal.car.thinkblue.TBTExtensionInterface;
import de.vw.mib.asl.internal.car.thinkblue.calc.BlueCalculator;
import de.vw.mib.asl.internal.car.thinkblue.calc.IrisCircularList;
import de.vw.mib.asl.internal.car.thinkblue.calc.Trend;
import de.vw.mib.asl.internal.car.thinkblue.calc.TrendConsum;
import de.vw.mib.has.HAS;
import de.vw.mib.has.HASContext;
import de.vw.mib.has.HASEngineAPI;
import de.vw.mib.util.StringBuilder;
import edu.emory.mathcs.backport.java.util.Arrays;
import generated.de.vw.mib.asl.internal.ListManager;
import generated.de.vw.mib.asl.internal.car.tbt.transformer.CarTBTBluePointsStatistics_1Collector;
import generated.de.vw.mib.asl.internal.car.tbt.transformer.CarTBTConsumptionStatisticsElectricCollector;
import generated.de.vw.mib.asl.internal.car.tbt.transformer.CarTBTConsumptionStatistics_1Collector;
import generated.de.vw.mib.has.containers.ThinkBlueDataContainer;
import generated.de.vw.mib.has.containers.ThinkBlueEventContainer;
import generated.de.vw.mib.has.contexts.car.CarProperties;

public class BlueManager {
    private static final String HAS_PROP_HINT_ECO;
    private static final String HAS_PROP_HINT_SPEED;
    private static final String HAS_PROP_HINT_SIGHT;
    protected static final int HISTORY_BAR_NEWSTYLE;
    protected static final int HISTORY_BAR_OLDSTYLE;
    private IrisCircularList irisSegmentsList;
    private BlueCalculator calculator;
    private CarTBTBluePointsStatistics_1Collector bpStatistics = new CarTBTBluePointsStatistics_1Collector();
    private CarTBTBluePointsStatistics_1Collector[] bpStatisticsArray = new CarTBTBluePointsStatistics_1Collector[]{this.bpStatistics};
    private CarTBTConsumptionStatistics_1Collector avgConsumptionStatistics = new CarTBTConsumptionStatistics_1Collector();
    private CarTBTConsumptionStatistics_1Collector[] avgConsumptionStatisticsArray = new CarTBTConsumptionStatistics_1Collector[]{this.avgConsumptionStatistics};
    private CarTBTConsumptionStatisticsElectricCollector avgConsumptionStatisticsEV;
    private CarTBTConsumptionStatisticsElectricCollector[] avgConsumptionStatisticsArrayEV;
    private Trend trend;
    private TrendConsum trendConsum;
    private int secCounter;
    private CarProperties hasCarProperties;
    private ThinkBlueDataContainer hasThinkBlueDataContainer;
    private ThinkBlueEventContainer hasThinkBlueEventContainer;
    private int currentGear;
    private int recommendedGear;
    private int timeTrend = 10;
    private int timeTrendShort = 30;
    private int timeTrendLong = 180;
    private PersistableHighFreq persistableFreqHigh;
    private PersistableMidFreq persistableFreqMid;
    private int currConsumptionUnit1 = -1;
    private int historyNewStyleElements;
    private HistoryDiagram ecoDiagram;
    private ConsumptionHistoryDiagram consumptionDiagram;
    private ConsumptionHistoryDiagram consumptionDiagramElectric;
    private int currConsumptionUnit2;
    private AverageData sinceStartBluePointAvg = new AverageData();
    private TBTExtensionInterface skodaExtension;
    private ASLTargetThinkBlue myTarget;
    private int ecoAverageTrip;
    private int bluePoints;
    private boolean trendValue;
    private boolean trendConsumValue = true;
    static /* synthetic */ Class class$de$vw$mib$asl$api$car$thinkblue$TBTServiceListener;

    public BlueManager(ASLTargetThinkBlue aSLTargetThinkBlue) {
        this.myTarget = aSLTargetThinkBlue;
    }

    public void init() {
        int n;
        this.irisSegmentsList = new IrisCircularList();
        this.trend = new Trend();
        this.trendConsum = new TrendConsum();
        this.ecoDiagram = new HistoryDiagram();
        this.ecoDiagram.setValues(this.bpStatistics.car_tbt_blue_points_values__1);
        this.ecoDiagram.setStates(this.bpStatistics.car_tbt_blue_points_states__1);
        this.consumptionDiagram = new ConsumptionHistoryDiagram();
        float[] fArray = new float[this.avgConsumptionStatistics.car_tbt_consumption_values__1.length];
        for (n = 0; n < fArray.length; ++n) {
            fArray[n] = this.avgConsumptionStatistics.car_tbt_consumption_values__1[n];
        }
        this.consumptionDiagram.setValues(fArray);
        this.consumptionDiagram.setStates(this.avgConsumptionStatistics.car_tbt_consumption_states__1);
        if (ASLTargetThinkBlue.isHybrid) {
            this.avgConsumptionStatisticsEV = new CarTBTConsumptionStatisticsElectricCollector();
            this.avgConsumptionStatisticsArrayEV = new CarTBTConsumptionStatisticsElectricCollector[]{this.avgConsumptionStatisticsEV};
            fArray = new float[this.avgConsumptionStatistics.car_tbt_consumption_values__1.length];
            for (n = 0; n < fArray.length; ++n) {
                fArray[n] = this.avgConsumptionStatistics.car_tbt_consumption_values__1[n];
            }
            this.consumptionDiagramElectric = new ConsumptionHistoryDiagram();
            this.consumptionDiagramElectric.setValues(fArray);
            this.consumptionDiagramElectric.setStates(this.avgConsumptionStatisticsEV.car_tbt_consumption_electric_states);
        }
        this.persistableFreqHigh = new PersistableHighFreq();
        this.persistableFreqMid = new PersistableMidFreq();
        this.readPersistenceDataAll();
        this.initHAS();
    }

    private void initHAS() {
        HASEngineAPI hASEngineAPI = HAS.getInstance().getEngine();
        HASContext hASContext = hASEngineAPI.getRegistry().getContextByName("Car");
        this.hasCarProperties = (CarProperties)hASContext.getPropertiesImpl();
        this.hasThinkBlueDataContainer = (ThinkBlueDataContainer)HAS.getInstance().getFactory().createContainer(44);
        this.hasThinkBlueEventContainer = (ThinkBlueEventContainer)HAS.getInstance().getFactory().createContainer(54);
        hASContext.setContextState(2);
    }

    public void readPersistenceDataAll() {
        ServiceManager.persistence.loadPersistable(5021, 0, this.persistableFreqHigh);
        ServiceManager.aslPropertyManager.valueChangedInteger(10412, this.persistableFreqHigh.getEcoAvgMid());
        this.getTBTServiceListener().updateBluePoints(this.persistableFreqHigh.getEcoAvgMid());
        int n = this.persistableFreqHigh.getIrisCursorPos();
        ServiceManager.aslPropertyManager.valueChangedInteger(10413, n);
        this.getTBTServiceListener().updateCurrentIrisSegment(n);
        int[] nArray = this.persistableFreqHigh.getIrisSegments();
        nArray = Arrays.copyOf(nArray, nArray.length);
        this.irisSegmentsList.list = nArray;
        this.irisSegmentsList.setCurrentBarPosition(n);
        ServiceManager.aslPropertyManager.valueChangedIntegerArray(10414, this.irisSegmentsList.list);
        this.getTBTServiceListener().updateIrisSegmentsValues(this.irisSegmentsList.list);
        this.irisSegmentsList.setCounter(this.persistableFreqHigh.getIrisAddedElems());
        AverageData averageData = this.persistableFreqHigh.readLongTermData();
        ServiceManager.aslPropertyManager.valueChangedInteger(10615, averageData.calculateAverage());
        this.skodaExtension.setLongTermData(averageData);
        averageData = this.persistableFreqHigh.readSinceRefuelData();
        ServiceManager.aslPropertyManager.valueChangedInteger(10616, averageData.calculateAverage());
        this.skodaExtension.setSinceRefuelData(averageData);
        ServiceManager.persistence.loadPersistable(5021, 0, this.persistableFreqMid);
        int[] nArray2 = this.persistableFreqMid.getHistoryEco();
        this.bpStatistics.car_tbt_blue_points_values__1 = Arrays.copyOf(nArray2, nArray2.length);
        this.ecoDiagram.setValues(this.bpStatistics.car_tbt_blue_points_values__1);
        float[] fArray = this.persistableFreqMid.getHistoryCons();
        this.consumptionDiagram.setValues(fArray);
        this.avgConsumptionStatistics.car_tbt_consumption_values__1 = this.consumptionDiagram.getValues();
        this.historyNewStyleElements = this.persistableFreqMid.getHistoryStyle();
        if (this.historyNewStyleElements > 30) {
            this.historyNewStyleElements = 30;
        }
        this.ecoDiagram.setNewStyleStateElements(this.historyNewStyleElements);
        this.consumptionDiagram.setNewStyleStateElements(this.historyNewStyleElements);
        ListManager.getGenericASLList(10439).updateList(this.avgConsumptionStatisticsArray);
        ListManager.getGenericASLList(10438).updateList(this.bpStatisticsArray);
    }

    public void reset() {
        this.secCounter = 0;
        this.sinceStartBluePointAvg.reset();
        this.historyNewStyleElements = 0;
        this.trend.reset();
        this.trendConsum.reset();
        this.trendValue = true;
        ServiceManager.aslPropertyManager.valueChangedBoolean(10429, this.trendValue);
        this.getTBTServiceListener().updateBluePointsTrend(this.trendValue);
        this.trendConsumValue = true;
        ServiceManager.aslPropertyManager.valueChangedBoolean(10430, this.trendConsumValue);
        this.getTBTServiceListener().updateConsumptionTrend(this.trendConsumValue);
        this.irisSegmentsList.reset();
        ServiceManager.aslPropertyManager.valueChangedIntegerArray(10414, this.irisSegmentsList.list);
        this.getTBTServiceListener().updateIrisSegmentsValues(this.irisSegmentsList.list);
        ServiceManager.aslPropertyManager.valueChangedInteger(10413, this.irisSegmentsList.getCurrentBarPosition());
        this.getTBTServiceListener().updateCurrentIrisSegment(this.irisSegmentsList.getCurrentBarPosition());
        this.bluePoints = 100;
        ServiceManager.aslPropertyManager.valueChangedInteger(10412, this.bluePoints);
        this.getTBTServiceListener().updateBluePoints(this.bluePoints);
        this.ecoAverageTrip = 0;
        ServiceManager.aslPropertyManager.valueChangedInteger(10470, this.ecoAverageTrip);
        this.getTBTServiceListener().updateEcoAverageTrip(this.ecoAverageTrip);
        this.ecoDiagram.reset();
        this.consumptionDiagram.reset();
        if (ASLTargetThinkBlue.isHybrid) {
            this.consumptionDiagramElectric.reset();
        }
        ListManager.getGenericASLList(10438).updateList(this.bpStatisticsArray);
        ListManager.getGenericASLList(10439).updateList(this.avgConsumptionStatisticsArray);
        this.deletePersistData();
        this.setHASAvgShort(0);
        this.setHASAvgTrip(0);
        this.updateHASEco();
        this.updateHASHint();
    }

    private void deletePersistData() {
        this.persistableFreqHigh.storeEcoAvgMid(0);
        this.persistableFreqHigh.storeIrisCursorPos(0);
        this.persistableFreqHigh.storeIrisSegments(this.irisSegmentsList.list);
        this.storePersistDataHigh();
        this.persistableFreqMid.setTrendEco(false);
        this.persistableFreqMid.setTrendCons(false);
        this.persistableFreqMid.setHistoryStyle(this.historyNewStyleElements);
        this.storePersistDataMid();
    }

    public void onHB() {
        this.secCounter += 5;
        this.processHB(this.secCounter);
    }

    private void processHB(int n) {
        this.processHBLevel0();
        if (this.timeTrend == 0) {
            ASLTargetThinkBlue.logMsg.error(1, "TBT.timeTrend value 0. Diag data error");
            this.timeTrend = 10;
        }
        if (this.timeTrendLong == 0) {
            ASLTargetThinkBlue.logMsg.error(1, "TBT.timeTrendLong value 0. Diag data error");
            this.timeTrendLong = 180;
        }
        if (this.timeTrendShort == 0) {
            ASLTargetThinkBlue.logMsg.error(1, "TBT.timeTrendShort value 0. Diag data error");
            this.timeTrendShort = 30;
        }
        if (n % this.timeTrend == 0) {
            this.processHBLevel1();
        }
        if (n % this.timeTrendShort == 0) {
            this.processHBLevel2();
        }
        if (n % 60 == 0) {
            this.processHBLevel3();
        }
        if (n % this.timeTrendLong == 0) {
            this.processHBLevel4();
        }
        if (n % 300 == 0) {
            // empty if block
        }
    }

    private void processHBLevel0() {
        this.updateIris();
        this.updateHASEco();
    }

    private void processHBLevel1() {
        this.updateTrend();
    }

    private void processHBLevel2() {
        this.trendConsum.onTimeoutShort();
    }

    private void processHBLevel3() {
        this.historyNewStyleElements = this.historyNewStyleElements < 30 ? ++this.historyNewStyleElements : 30;
        this.persistableFreqMid.setHistoryStyle(this.historyNewStyleElements);
        this.ecoDiagram.calculateAverage();
        this.bpStatistics.car_tbt_blue_points_values__1 = this.ecoDiagram.getValues();
        this.bpStatistics.car_tbt_blue_points_states__1 = this.ecoDiagram.getStates();
        this.consumptionDiagram.calculateAverage();
        this.avgConsumptionStatistics.car_tbt_consumption_values__1 = this.consumptionDiagram.getValues();
        this.avgConsumptionStatistics.car_tbt_consumption_states__1 = this.consumptionDiagram.getStates();
        if (ASLTargetThinkBlue.isHybrid) {
            this.consumptionDiagramElectric.calculateAverage();
            this.avgConsumptionStatisticsEV.car_tbt_consumption_electric_values = this.consumptionDiagramElectric.getValues();
            this.avgConsumptionStatisticsEV.car_tbt_consumption_electric_states = this.consumptionDiagramElectric.getStates();
            ListManager.getGenericASLList(10440).updateList(this.avgConsumptionStatisticsArrayEV);
        }
        ListManager.getGenericASLList(10438).updateList(this.bpStatisticsArray);
        ListManager.getGenericASLList(10439).updateList(this.avgConsumptionStatisticsArray);
        this.persistableFreqMid.setHistoryEco(this.bpStatistics.car_tbt_blue_points_values__1);
        this.persistableFreqMid.setHistoryCons(this.consumptionDiagram.getValuesAsFloat());
        this.storePersistDataMid();
    }

    private void processHBLevel4() {
        this.updateTrendLong();
    }

    private void updateIris() {
        int n = 0;
        n = this.calculator.getAvgBPAndReset();
        this.sinceStartBluePointAvg.addValue(n);
        this.skodaExtension.addBluePoints(n);
        this.ecoDiagram.addValue(n);
        this.irisSegmentsList.add(n);
        this.trend.addData(n);
        ServiceManager.aslPropertyManager.valueChangedIntegerArray(10414, this.irisSegmentsList.list);
        this.getTBTServiceListener().updateIrisSegmentsValues(this.irisSegmentsList.list);
        ServiceManager.aslPropertyManager.valueChangedInteger(10413, this.irisSegmentsList.getCurrentBarPosition());
        this.getTBTServiceListener().updateCurrentIrisSegment(this.irisSegmentsList.getCurrentBarPosition());
        this.bluePoints = this.irisSegmentsList.getBPAverage();
        ServiceManager.aslPropertyManager.valueChangedInteger(10412, this.bluePoints);
        this.getTBTServiceListener().updateBluePoints(this.bluePoints);
        this.ecoAverageTrip = this.sinceStartBluePointAvg.calculateAverage();
        ServiceManager.aslPropertyManager.valueChangedInteger(10470, this.ecoAverageTrip);
        this.getTBTServiceListener().updateEcoAverageTrip(this.ecoAverageTrip);
        ServiceManager.aslPropertyManager.valueChangedInteger(10615, this.skodaExtension.getLongTermAverage());
        ServiceManager.aslPropertyManager.valueChangedInteger(10616, this.skodaExtension.getSinceRefuelAverage());
        this.setHASAvgShort(n);
        this.setHASAvgTrip(this.ecoAverageTrip);
        this.persistableFreqHigh.storeEcoAvgMid(this.bluePoints);
        this.persistableFreqHigh.storeIrisCursorPos(this.irisSegmentsList.getCurrentBarPosition());
        this.persistableFreqHigh.storeIrisSegments(this.irisSegmentsList.list);
        this.persistableFreqHigh.storeIrisAddedElems(this.irisSegmentsList.getCounter());
        this.persistableFreqHigh.storeLongTermData(this.skodaExtension.getLongTermData());
        this.persistableFreqHigh.storeSinceRefuelData(this.skodaExtension.getSinceRefuelData());
        this.storePersistDataHigh();
    }

    private void storePersistDataHigh() {
        ServiceManager.persistence.storePersistable(5021, 0, this.persistableFreqHigh);
    }

    private void storePersistDataMid() {
        ServiceManager.persistence.storePersistable(5021, 0, this.persistableFreqMid);
    }

    private void updateTrend() {
        this.trendValue = this.trend.calculateTrend();
        ServiceManager.aslPropertyManager.valueChangedBoolean(10429, this.trendValue);
        this.getTBTServiceListener().updateBluePointsTrend(this.trendValue);
        this.trendConsumValue = this.trendConsum.calculateTrend();
        ServiceManager.aslPropertyManager.valueChangedBoolean(10430, this.trendConsumValue);
        this.getTBTServiceListener().updateConsumptionTrend(this.trendConsumValue);
    }

    private void updateTrendLong() {
        this.trend.onTimeoutLong();
        this.trendConsum.onTimeoutLong();
        this.updateTrend();
    }

    public void updateDrivingState() {
        this.updateHASHint();
    }

    public void onCurrentConsum1(float f2) {
        this.consumptionDiagram.addValue(f2);
    }

    public void onCurrentConsum2(float f2) {
        this.consumptionDiagramElectric.addValue(f2);
    }

    public void onShortTermConsumptionValue1(float f2) {
        this.trendConsum.addData(f2);
    }

    public void onShortTermConsumptionUnit1Change(int n) {
        boolean bl = this.convertConsumptionDiagram(this.consumptionDiagram, this.currConsumptionUnit1, n);
        if (bl) {
            this.avgConsumptionStatistics.car_tbt_consumption_values__1 = this.consumptionDiagram.getValues();
            this.avgConsumptionStatistics.car_tbt_consumption_states__1 = this.consumptionDiagram.getStates();
            ListManager.getGenericASLList(10439).updateList(this.avgConsumptionStatisticsArray);
        }
        this.trendConsum.onConsumptionUnitChange(this.currConsumptionUnit1, n);
        this.currConsumptionUnit1 = n;
    }

    public void onShortTermConsumptionUnit2(int n) {
        boolean bl = this.convertConsumptionDiagram(this.consumptionDiagramElectric, this.currConsumptionUnit2, n);
        if (bl) {
            this.avgConsumptionStatisticsEV.car_tbt_consumption_electric_values = this.consumptionDiagramElectric.getValues();
            this.avgConsumptionStatisticsEV.car_tbt_consumption_electric_states = this.consumptionDiagramElectric.getStates();
            ListManager.getGenericASLList(10440).updateList(this.avgConsumptionStatisticsArrayEV);
        }
        this.currConsumptionUnit2 = n;
    }

    private boolean convertConsumptionDiagram(ConsumptionHistoryDiagram consumptionHistoryDiagram, int n, int n2) {
        if (n == -1) {
            n = n2;
            return false;
        }
        if (n == n2) {
            return false;
        }
        consumptionHistoryDiagram.convertValues(n, n2);
        return true;
    }

    public void setPersistentValues(EcoHmi ecoHmi) {
        if (ecoHmi.contains(822)) {
            this.timeTrend = ecoHmi.getValue(822);
        }
        if (ecoHmi.contains(823)) {
            this.timeTrendShort = ecoHmi.getValue(823);
        }
        if (ecoHmi.contains(824)) {
            this.timeTrendLong = ecoHmi.getValue(824);
        }
    }

    private void setHASAvgShort(int n) {
        this.hasThinkBlueDataContainer.setAvgShort(n);
    }

    private void setHASAvgTrip(int n) {
        this.hasThinkBlueDataContainer.setAvgTrip(n);
    }

    private void updateHASEco() {
        this.hasCarProperties.updateCurrentThinkBlue(this.hasThinkBlueDataContainer);
    }

    private void updateHASHint() {
        String string = null;
        int n = this.calculator.getCurrentDrivingHint();
        if (n == 2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("G").append(this.currentGear).append("x").append(this.recommendedGear);
            string = stringBuilder.toString();
        } else if (n == 3) {
            string = "Sight";
        } else if (n == 1) {
            string = "Speed";
        } else if (n == 0) {
            string = "Eco";
        }
        if (string == null) {
            this.hasThinkBlueEventContainer.unsetDescription();
            this.hasThinkBlueEventContainer.unsetTimeStamp();
        } else {
            this.hasThinkBlueEventContainer.setDescription(string);
            this.hasThinkBlueEventContainer.setTimeStamp(ASLSystemFactory.getSystemApi().getCurrentTimestamp());
        }
        this.hasCarProperties.updateThinkBlueEvent(this.hasThinkBlueEventContainer);
    }

    public void setGears(int n, int n2) {
        this.currentGear = n;
        this.recommendedGear = n2;
    }

    public void onStopBPCalculation() {
        this.updateHASHint();
    }

    public PersistableMidFreq getPersistableFreqMid() {
        return this.persistableFreqMid;
    }

    public void setPersistableFreqMid(PersistableMidFreq persistableMidFreq) {
        this.persistableFreqMid = persistableMidFreq;
    }

    public void setCalculator(BlueCalculator blueCalculator) {
        this.calculator = blueCalculator;
    }

    public void setConsumptionTrendLimit(float f2) {
        this.trendConsum.setTrendLimit(f2);
    }

    public void setSkodaHandler(TBTExtensionInterface tBTExtensionInterface) {
        this.skodaExtension = tBTExtensionInterface;
    }

    private TBTServiceListener getTBTServiceListener() {
        return (TBTServiceListener)ServiceFactory.getInstance().getServiceProviderRegistry().getServiceListener(class$de$vw$mib$asl$api$car$thinkblue$TBTServiceListener == null ? (class$de$vw$mib$asl$api$car$thinkblue$TBTServiceListener = BlueManager.class$("de.vw.mib.asl.api.car.thinkblue.TBTServiceListener")) : class$de$vw$mib$asl$api$car$thinkblue$TBTServiceListener);
    }

    public IrisCircularList getIrisSegmentsList() {
        return this.irisSegmentsList;
    }

    public PersistableHighFreq getPersistableFreqHigh() {
        return this.persistableFreqHigh;
    }

    public boolean isTrendValue() {
        return this.trendValue;
    }

    public boolean isTrendConsumValue() {
        return this.trendConsumValue;
    }

    public int getEcoAverageTrip() {
        return this.ecoAverageTrip;
    }

    public int getBluePoints() {
        return this.bluePoints;
    }

    public int getCurrentGear() {
        return this.currentGear;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

