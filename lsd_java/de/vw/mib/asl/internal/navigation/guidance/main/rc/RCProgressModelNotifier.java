/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.guidance.main.rc;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.framework.internal.framework.AbstractASLHsmTarget;
import de.vw.mib.asl.internal.navigation.guidance.main.rc.ASLCalculatedRouteListElement;
import de.vw.mib.log4mib.LogMessage;
import generated.de.vw.mib.asl.internal.ListManager;
import generated.de.vw.mib.asl.internal.navigation.guidance.transformer.NavigationGuidanceCalculationProgressesCollector;

public class RCProgressModelNotifier {
    private IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(32, super.getClass().toString(), true);
    NavigationGuidanceCalculationProgressesCollector collector = new NavigationGuidanceCalculationProgressesCollector();

    public void reset() {
        this.collector.navigation_guidance_calculation_progress = 0;
        this.collector.navigation_guidance_calculation_progress_alternate_route1 = 0;
        this.collector.navigation_guidance_calculation_progress_alternate_route2 = 0;
        this.collector.navigation_guidance_calculation_progress_alternate_route3 = 0;
        this.collector.navigation_guidance_calculation_progress_alternate_route4 = 0;
        this.notifyModel();
        AbstractASLHsmTarget.writeIntegerToDatapool(2112884736, 0);
    }

    public void updateASLElementProgress(ASLCalculatedRouteListElement aSLCalculatedRouteListElement) {
        switch (aSLCalculatedRouteListElement.getModelCalculationIndex()) {
            case 0: {
                this.collector.navigation_guidance_calculation_progress = aSLCalculatedRouteListElement.getCalculatedRouteListElement().calculationPercentage;
                break;
            }
            case 1: {
                this.collector.navigation_guidance_calculation_progress_alternate_route1 = aSLCalculatedRouteListElement.getCalculatedRouteListElement().calculationPercentage;
                break;
            }
            case 2: {
                this.collector.navigation_guidance_calculation_progress_alternate_route2 = aSLCalculatedRouteListElement.getCalculatedRouteListElement().calculationPercentage;
                break;
            }
            case 3: {
                this.collector.navigation_guidance_calculation_progress_alternate_route3 = aSLCalculatedRouteListElement.getCalculatedRouteListElement().calculationPercentage;
                break;
            }
            case 4: {
                this.collector.navigation_guidance_calculation_progress_alternate_route4 = aSLCalculatedRouteListElement.getCalculatedRouteListElement().calculationPercentage;
                break;
            }
        }
    }

    public void notifyModel() {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(" notifyModel()");
            LogMessage logMessage = this.logger.makeTrace();
            logMessage.append("Route 0: ");
            logMessage.append(this.collector.navigation_guidance_calculation_progress);
            logMessage.append(" Route 1: ");
            logMessage.append(this.collector.navigation_guidance_calculation_progress_alternate_route1);
            logMessage.append(" Route 2: ");
            logMessage.append(this.collector.navigation_guidance_calculation_progress_alternate_route2);
            logMessage.append(" Route 3: ");
            logMessage.append(this.collector.navigation_guidance_calculation_progress_alternate_route3);
            logMessage.append(" Route 4: ");
            logMessage.append(this.collector.navigation_guidance_calculation_progress_alternate_route4);
            logMessage.log();
        }
        ListManager.getGenericASLList(823).updateList(new NavigationGuidanceCalculationProgressesCollector[]{this.collector});
    }
}

