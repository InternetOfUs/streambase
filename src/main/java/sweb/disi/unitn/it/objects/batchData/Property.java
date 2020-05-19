package sweb.disi.unitn.it.objects.batchData;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import sweb.disi.unitn.it.objects.android.sensors.ambience.WF;
import sweb.disi.unitn.it.objects.android.sensors.ambience.WN;
import sweb.disi.unitn.it.objects.android.sensors.audio.AU;
import sweb.disi.unitn.it.objects.android.sensors.locations.GL;
import sweb.disi.unitn.it.objects.android.sensors.locations.NL;
import sweb.disi.unitn.it.objects.android.sensors.metalog.BM;
import sweb.disi.unitn.it.objects.android.sensors.metalog.SM;
import sweb.disi.unitn.it.objects.android.sensors.sensors.*;
import sweb.disi.unitn.it.objects.android.sensors.social.BL;
import sweb.disi.unitn.it.objects.android.sensors.social.BN;
import sweb.disi.unitn.it.objects.android.sensors.system.*;
import sweb.disi.unitn.it.objects.android.sensors.virtual.*;
import sweb.disi.unitn.it.objects.contributions.*;

import java.util.ArrayList;
import java.util.List;


@JsonInclude(Include.NON_EMPTY)
public class Property {
    private List<WF> wifievent;
    private List<WN> wifinetworksevent;
    private List<AU> audioevent;
    private List<NL> locationeventpertimenetwork;
    private List<GL> locationeventpertime;
    private List<BM> batterymonitoringlog;
    private List<SM> sensormonitoringlog;
    private List<AC> accelerometerevent;
    private List<AT> ambienttemperatureevent;
    private List<GR> gravityevent;
    private List<GY> gyroscopeevent;
    private List<LA> linearaccelerationevent;
    private List<LI> lightevent;
    private List<MF> magneticfieldevent;
    private List<MV> activityevent; //to verify the name
    private List<OR> orientationevent;
    private List<PE> pressureevent;
    private List<PO> proximityevent;
    private List<RH> relativehumidityevent;
    private List<RV> rotationvectorevent;
    private List<BL> bluetoothlowenergyevent;
    private List<BN> bluetoothnormalevent;
    private List<AM> airplanemodeevent;
    private List<BC> batterychargeevent;
    private List<DO> dozeevent;
    private List<HP> headsetplugevent;
    private List<MU> musicevent;
    private List<RM> ringmodeevent;
    private List<ST> statisticevents;
    private List<AP> applicationevent;
    private List<CI> phonecallinevent;
    private List<CN> cellularnetwork;
    private List<CO> phonecalloutevent;
    private List<NE> notificationevent;
    private List<SC> screenevent;
    private List<SI> smsinevent;
    private List<SO> smsoutevent;
    private List<TE> touchevent;
    private List<TimediaryQuestion> timediariesquestions;
    private List<TimediaryAnswer> timediariesanswers;
    private List<TaskAnswer> taskanswers;
    private List<TaskQuestion> taskquestions;
    private List<ChallengeAnswer> challengesanswers;
    private List<ChallengeSubscription> challengesubscriptions;

    public List<WF> getWifievent() {
        if (wifievent == null)
            wifievent = new ArrayList<WF>();
        return wifievent;
    }
    public List<WN> getWifinetworksevent() {
        if (wifinetworksevent == null)
            wifinetworksevent = new ArrayList<WN>();
        return wifinetworksevent;
    }
    public List<AU> getAudioevent() {
        if (audioevent == null)
            audioevent = new ArrayList<AU>();
        return audioevent;
    }
    public List<NL> getLocationeventpertimenetwork() {
        if (locationeventpertimenetwork == null)
            locationeventpertimenetwork = new ArrayList<NL>();
        return locationeventpertimenetwork;
    }
    public List<GL> getLocationeventpertime(){
        if (locationeventpertime == null)
            locationeventpertime = new ArrayList<GL>();
        return locationeventpertime;
    }
    public List<BM> getBatterymonitoringlog() {
        if (batterymonitoringlog == null)
            batterymonitoringlog = new ArrayList<BM>();
        return batterymonitoringlog;
    }
    public List<SM> getSensormonitoringlog() {
        if (sensormonitoringlog == null)
            sensormonitoringlog = new ArrayList<SM>();
        return sensormonitoringlog;
    }
    public List<AC> getAccelerometerevent() {
        if (accelerometerevent == null)
            accelerometerevent = new ArrayList<AC>();
        return accelerometerevent;
    }
    public List<AT> getAmbienttemperatureevent() {
        if (ambienttemperatureevent == null)
            ambienttemperatureevent = new ArrayList<AT>();
        return ambienttemperatureevent;
    }
    public List<GR> getGravityevent() {
        if (gravityevent == null)
            gravityevent = new ArrayList<GR>();
        return gravityevent;
    }
    public List<GY> getGyroscopeevent() {
        if (gyroscopeevent == null)
            gyroscopeevent = new ArrayList<GY>();
        return gyroscopeevent;
    }
    public List<LA> getLinearaccelerationevent() {
        if (linearaccelerationevent == null)
            linearaccelerationevent = new ArrayList<LA>();
        return linearaccelerationevent;
    }
    public List<LI> getLightevent() {
        if (lightevent == null)
            lightevent = new ArrayList<LI>();
        return lightevent;
    }
    public List<MF> getMagneticfieldevent() {
        if (magneticfieldevent == null)
            magneticfieldevent = new ArrayList<MF>();
        return magneticfieldevent;
    }
    public List<MV> getActivityevent() {
        if (activityevent == null)
            activityevent = new ArrayList<MV>();
        return activityevent;
    }
    public List<OR> getOrientationevent() {
        if (orientationevent == null)
            orientationevent = new ArrayList<OR>();
        return orientationevent;
    }
    public List<PE> getPressureevent() {
        if (pressureevent == null)
            pressureevent = new ArrayList<PE>();
        return pressureevent;
    }
    public List<PO> getProximityevent() {
        if (proximityevent == null)
            proximityevent = new ArrayList<PO>();
        return proximityevent;
    }
    public List<RH> getRelativehumidityevent() {
        if (relativehumidityevent == null)
            relativehumidityevent = new ArrayList<RH>();
        return relativehumidityevent;
    }
    public List<RV> getRotationvectorevent() {
        if (rotationvectorevent == null)
            rotationvectorevent = new ArrayList<RV>();
        return rotationvectorevent;
    }
    public List<BL> getBluetoothlowenergyevent() {
        if (bluetoothlowenergyevent == null)
            bluetoothlowenergyevent = new ArrayList<BL>();
        return bluetoothlowenergyevent;
    }
    public List<BN> getBluetoothnormalevent() {
        if (bluetoothnormalevent == null)
            bluetoothnormalevent = new ArrayList<BN>();
        return bluetoothnormalevent;
    }
    public List<AM> getAirplanemodeevent() {
        if (airplanemodeevent == null)
            airplanemodeevent = new ArrayList<AM>();
        return airplanemodeevent;
    }
    public List<BC> getBatterychargeevent() {
        if (batterychargeevent == null)
            batterychargeevent = new ArrayList<BC>();
        return batterychargeevent;
    }
    public List<DO> getDozeevent() {
        if (dozeevent == null)
            dozeevent = new ArrayList<DO>();
        return dozeevent;
    }
    public List<HP> getHeadsetplugevent() {
        if (headsetplugevent == null)
            headsetplugevent = new ArrayList<HP>();
        return headsetplugevent;
    }
    public List<MU> getMusicevent() {
        if (musicevent == null)
            musicevent = new ArrayList<MU>();
        return musicevent;
    }
    public List<RM> getRingmodeevent() {
        if (ringmodeevent == null)
            ringmodeevent = new ArrayList<RM>();
        return ringmodeevent;
    }
    public List<ST> getStatisticevents() {
        if (statisticevents == null)
            statisticevents = new ArrayList<ST>();
        return statisticevents;
    }
    public List<AP> getApplicationevent() {
        if (applicationevent == null)
            applicationevent = new ArrayList<AP>();
        return applicationevent;
    }
    public List<CI> getPhonecallinevent() {
        if (phonecallinevent == null)
            phonecallinevent = new ArrayList<CI>();
        return phonecallinevent;
    }
    public List<CN> getCellularnetwork() {
        if (cellularnetwork == null)
            cellularnetwork = new ArrayList<CN>();
        return cellularnetwork;
    }
    public List<CO> getPhonecalloutevent() {
        if (phonecalloutevent == null)
            phonecalloutevent = new ArrayList<CO>();
        return phonecalloutevent;
    }
    public List<NE> getNotificationevent() {
        if (notificationevent == null)
            notificationevent = new ArrayList<NE>();
        return notificationevent;
    }
    public List<SC> getScreenevent() {
        if (screenevent == null)
            screenevent = new ArrayList<SC>();
        return screenevent;
    }
    public List<SI> getSmsinevent() {
        if (smsinevent == null)
            smsinevent = new ArrayList<SI>();
        return smsinevent;
    }
    public List<SO> getSmsoutevent() {
        if (smsoutevent == null)
            smsoutevent = new ArrayList<SO>();
        return smsoutevent;
    }
    public List<TE> getTouchevent() {
        if (touchevent == null)
            touchevent = new ArrayList<TE>();
        return touchevent;
    }
    public List<TimediaryAnswer> getTimediariesanswers() {
        if (timediariesanswers == null)
            timediariesanswers = new ArrayList<TimediaryAnswer>();
        return timediariesanswers;
    }

    public List<TimediaryQuestion> getTimediariesquestions() {
        if (timediariesquestions == null)
            timediariesquestions = new ArrayList<TimediaryQuestion>();
        return timediariesquestions;
    }
    public List<TaskAnswer> getTaskanswers() {
        if (taskanswers == null)
            taskanswers = new ArrayList<TaskAnswer>();
        return taskanswers;
    }
    public List<TaskQuestion> getTaskquestions() {
        if (taskquestions == null)
            taskquestions = new ArrayList<TaskQuestion>();
        return taskquestions;
    }

    public List<ChallengeSubscription> getChallengesubscriptions() {
        if (challengesubscriptions == null)
            challengesubscriptions = new ArrayList<ChallengeSubscription>();
        return challengesubscriptions;
    }

    public List<ChallengeAnswer> getChallengesanswers() {
        if (challengesanswers == null)
            challengesanswers = new ArrayList<ChallengeAnswer>();
        return challengesanswers;
    }

}
