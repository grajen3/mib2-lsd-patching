/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system;

import de.vw.mib.asl.internal.system.AslTargetSystemDate;
import de.vw.mib.asl.internal.system.DsiCarTimeUnitsLanguageListenerAdapter;
import org.dsi.ifc.cartimeunitslanguage.ClockDate;
import org.dsi.ifc.cartimeunitslanguage.ClockSources;
import org.dsi.ifc.cartimeunitslanguage.ClockTime;
import org.dsi.ifc.cartimeunitslanguage.ClockViewOptions;
import org.dsi.ifc.cartimeunitslanguage.UnitmasterViewOptions;

class AslTargetSystemDate$1
extends DsiCarTimeUnitsLanguageListenerAdapter {
    private final /* synthetic */ AslTargetSystemDate this$0;

    AslTargetSystemDate$1(AslTargetSystemDate aslTargetSystemDate) {
        this.this$0 = aslTargetSystemDate;
    }

    @Override
    public void updateClockFormat(int n, int n2) {
        this.this$0.dsiUpdateClockFormat(n);
    }

    @Override
    public void updateClockTime(ClockTime clockTime, int n) {
        this.this$0.dsiUpdateClockTime(clockTime);
    }

    @Override
    public void updateClockSource(int n, int n2) {
        this.this$0.dsiUpdateClockSource(n);
    }

    @Override
    public void updateDateFormat(int n, int n2) {
        this.this$0.dsiUpdateDateFormat(n);
    }

    @Override
    public void updateClockDate(ClockDate clockDate, int n) {
        this.this$0.dsiUpdateClockDate(clockDate);
    }

    @Override
    public void updateClockTimeSourcesAvailable(ClockSources clockSources, int n) {
        this.this$0.dsiUpdateClockTimeSourcesAvailable(clockSources);
    }

    @Override
    public void updateClockDayLightSaving(boolean bl, int n) {
        this.this$0.dsiUpdateClockDayLightSaving(bl);
    }

    @Override
    public void updateClockViewOptions(ClockViewOptions clockViewOptions, int n) {
        this.this$0.dsiUpdateClockViewOptions(clockViewOptions);
    }

    @Override
    public void updateUnitmasterViewOptions(UnitmasterViewOptions unitmasterViewOptions, int n) {
        this.this$0.dsiUpdateUnitmasterViewOptions(unitmasterViewOptions);
    }
}

