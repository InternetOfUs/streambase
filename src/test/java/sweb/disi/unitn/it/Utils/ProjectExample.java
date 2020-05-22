package sweb.disi.unitn.it.Utils;

import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import sweb.disi.unitn.it.objects.contributions.iLogQAJsonView.QuestionAnswerView;
import sweb.disi.unitn.it.objects.experiment.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Arrays;
import java.util.List;

public class ProjectExample {

    private static final Logger logger = LogManager.getLogger(ProjectExample.class);

    public static final int GPS_ID = 1000000;//todo change to platform IDs ?
    public static final int NETWORK_ID = 1000001;
    public static  final int WIFI_SENSOR_ID = 1000002;
    public static  final int AUDIO_ID = 1000005;
    public static  final int BLUETOOTHLOGGING_ID = 1000006;
    public static  final int BLUETOOTHLELOGGING_ID = 1000007;
    public static  final int PHONECALL_IN_ID = 1000011;
    public static  final int PHONECALL_OUT_ID = 1000012;
    public static  final int SMS_IN_ID = 1000013;
    public static  final int SMS_OUT_ID = 1000014;
    public static  final int APP_USAGE_ID = 1000015;
    public static  final int WIFI_NETWORKS_SENSOR_ID = 1000016;
    public static final int SCREEN_ID = 1000017;
    public static final int DOZE_ID = 1000018;
    public static  final int BATTERY_CHARGE_ID = 1000019;
    public static  final int HEADSET_ID = 1000020;
    public static  final int MUSIC_ID = 1000021;
    public static  final int AIRPLANE_MODE_ID = 1000022;
    public static  final int RING_MODE_ID = 1000023;
    public static  final int USER_PRESENT_ID = 1000024;
    public static  final int BATTERY_LEVEL_ID = 1000025;
    public static  final int NOTIFICATION_ID = 1000026;
    public static  final int TOUCH_ID = 1000027;
    public static  final int CELLINFO_ID = 1000028;
    public static  final int MOVEMENT_ACTIVITY_ID = 1000029;

    public static  final int TYPE_ACCELEROMETER = 1;
    public static  final int TYPE_GRAVITY = 9;
    public static  final int TYPE_GYROSCOPE = 4;
    public static  final int TYPE_LINEAR_ACCELERATION = 10;
    public static  final int TYPE_ROTATION_VECTOR = 11;
    public static  final int TYPE_MAGNETIC_FIELD = 2;
    public static  final int TYPE_ORIENTATION = 3;
    public static  final int TYPE_PROXIMITY = 8;
    public static  final int TYPE_AMBIENT_TEMPERATURE = 13;
    public static  final int TYPE_LIGHT = 5;
    public static  final int TYPE_PRESSURE = 6;
    public static  final int TYPE_RELATIVE_HUMIDITY = 12;
    public static  final int TYPE_TEMPERATURE = 7;

    private static Experiment createProject() {
        try {

            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);

            JSONObject message = new JSONObject();
            message.put("it_IT", "Questo permesso consente ad i-Log di rimanere in esecuzione in background sul tuo telefonino. Ti chiediamo quindi di ignorare l\'opzione di ottimizzazione della batteria che pero\' non dovrebbe influire significativamente sull\'autonomia del telefonino.\n\n Nella schermata che si aprira\' dopo aver cliccato su \'Autorizza\', scorri in basso fino a che non trovi i-Log. Successivamente clicca su di esso e poi su \'Non ottimizzare\'. Per concludere, premi il tasto indietro per tornare ad i-Log.\n\nNota che questa procedura potrebbe essere differente in base al cellulare e/o sistema operativo che possiedi.\n\nSenza questo permesso, i-Log non puo\' funzionare :-(");
            message.put("en_US", "This permission allow i-Log to be executed in the background. We kindly ask you to ignore the battery optimisation option, since it does not affect your smartphone battery significantly.\n\nAfter clicking \'authorize\', scroll down in the new window to find i-Log. Then, click on it and on \'Don't optimize\'. Finally, press the back button to go back to i-Log.\n\nWithout this permission, i-Log cannot work :(");

            JSONObject confirmation = new JSONObject();
            confirmation.put("it_IT", "CONTINUA");
            confirmation.put("en_US", "CONTINUE");

            JSONObject title = new JSONObject();
            title = new JSONObject();
            title.put("it_IT", "Batteria");
            title.put("en_US", "Battery");

            JSONObject battery = new JSONObject();
            battery.put("singlesensor", "false");
            battery.put("title", title);
            battery.put("message", message);
            battery.put("confirmation", confirmation);
            battery.put("background", "ic_battery");
            battery.put("permission", "battery_permission");
            battery.put("skip", "false");
            battery.put("order", 1);

            message = new JSONObject();
            message.put("it_IT", "La posizione e\' cruciale per la buona riuscita dell\'esperimento in quanto ci permette di rilevare i tuoi spostamenti. Senza questa autorizzazione, l\'intero esperimento verrebbe compromesso. :-(");
            message.put("en_US", "Localization is very important for a Smart City application such as this one. It helps us to better understand your habits concerning how you move around the city.");

            confirmation = new JSONObject();
            confirmation.put("it_IT", "CONTINUA");
            confirmation.put("en_US", "CONTINUE");

            title = new JSONObject();
            title.put("it_IT", "Posizione");
            title.put("en_US", "Position");

            JSONObject fineLocation = new JSONObject();
            fineLocation.put("singlesensor", "true");
            fineLocation.put("title", title);
            fineLocation.put("message", message);
            fineLocation.put("confirmation", confirmation);
            fineLocation.put("background", "ic_location");
            fineLocation.put("permission", "android.permission.ACCESS_FINE_LOCATION");
            fineLocation.put("skip", "false");
            fineLocation.put("order", 2);

            message = new JSONObject();
            message.put("it_IT", "Periodicamente l\'applicazione deve scaricare i dati dal telefono. Questo puo\' avvenire in automatico non appena il tuo telefono si connette al Wi-Fi oppure devi farlo tu manualmente dal menu\' impostazioni, Impostazioni - Log - Sincronizza Log. Se autorizzi qui sotto la sincronizzazione avverra\' automaticamente non appena il telefono si connette al Wi-Fi. Se sai di avere una connessione internet a consumo non abilitare questa voce, ma sincronizza manualmente i dati in presenza di una connessione non a consumo.");
            message.put("en_US", "Periodically the application needs to upload data from the phone. This can happen automatically when the phone connects to a Wi-Fi network or you have do to it manually from the settings, Settings - Logs - Sync Logs. If you authorize below the process will be automatic and will save you time. Note that you should not authorize if you use a Wi-Fi network with limited data. At any rate, the synchronization will occur only if connected to a Wi-Fi network.");

            confirmation = new JSONObject();
            confirmation.put("it_IT", "CONTINUA");
            confirmation.put("en_US", "CONTINUE");

            title = new JSONObject();
            title.put("it_IT", "Sincronizzazione");
            title.put("en_US", "Synchronization");

            JSONObject wifiPermission = new JSONObject();
            wifiPermission.put("singlesensor", "false");
            wifiPermission.put("title", title);
            wifiPermission.put("message", message);
            wifiPermission.put("confirmation", confirmation);
            wifiPermission.put("background", "ic_wifi");
            wifiPermission.put("permission", "wifi_permission");
            wifiPermission.put("skip", "true");
            wifiPermission.put("order", 3);

            message = new JSONObject();
            message.put("it_IT", "Sapere quando ricevi una notifica (ma non il suo contenuto) ci aiuta a capire come interagisci con il tuo telefono.\n\nCerca i-Log nella lista di applicazioni nella nuova finestra che si aprirà dopo aver cliccato qui sotto e abilitalo. Conferma se necessario. Per concludere, premi il pulsante indietro per tornare ad i-Log.");
            message.put("en_US", "Knowing when you receive a notification (but not its content) helps us in understanding how you interact with your phone.\n\nAfter clicking on the button below, search for i-Log in the list in the windows that will appear and enable it. Confirm if necessary. Finally, press the back button to go back to i-Log.");

            confirmation = new JSONObject();
            confirmation.put("it_IT", "CONTINUA");
            confirmation.put("en_US", "CONTINUE");

            title = new JSONObject();
            title.put("it_IT", "Notifiche");
            title.put("en_US", "Notifications");

            JSONObject notification = new JSONObject();
            notification.put("singlesensor", "false");
            notification.put("title", title);
            notification.put("message", message);
            notification.put("confirmation", confirmation);
            notification.put("background", "ic_notifications");
            notification.put("permission", "notifications_permission");
            notification.put("skip", "true");
            notification.put("order", 4);

            message = new JSONObject();
            message.put("it_IT", "Raccogliere il nome dell\'applicazione in uso sul telefono ci aiuta a capire come interagisci con esso.\n\nCerca i-Log nella lista di applicazioni nella nuova finestra che si aprirà dopo aver cliccato qui sotto e cliccaci sopra. Successivamente abilita il permesso. Per concludere, premi il pulsante indietro per tornare ad i-Log.");
            message.put("en_US", "Collecting the names of the applications running on your phone helps us in understanding how you interact with it.\n\nAfter clicking on the button below, search for i-Log in the list in the windows that will appear and click on it. Then enable the permission. Finally, press the back button to go back to i-Log.");

            confirmation = new JSONObject();
            confirmation.put("it_IT", "CONTINUA");
            confirmation.put("en_US", "CONTINUE");

            title = new JSONObject();
            title.put("it_IT", "Applicazioni");
            title.put("en_US", "Applications");

            JSONObject usageStats = new JSONObject();
            usageStats.put("singlesensor", "false");
            usageStats.put("title", title);
            usageStats.put("message", message);
            usageStats.put("confirmation", confirmation);
            usageStats.put("background", "ic_applications");
            usageStats.put("permission", "applications_permission");
            usageStats.put("skip", "true");
            usageStats.put("order", 5);

            message = new JSONObject();
            message.put("it_IT", "Sapere quando tocchi lo schermo del telefono (ma non dove) ci aiuta a capire come interagisci con il tuo telefono.\n\nNella nuova finestra che si aprira dopo aver cliccato qui sotto abilita il permesso. Per concludere, premi il pulsante indietro per tornare ad i-Log.");
            message.put("en_US", "Knowing when you touch the screen of your smartphone (but notwhere the touch happens) helps us in understanding how you interact with your phones.\n\nAfter clicking on the button below, enable the permission. Finally, press the back button to go back to i-Log.");

            confirmation = new JSONObject();
            confirmation.put("it_IT", "CONTINUA");
            confirmation.put("en_US", "CONTINUE");

            title = new JSONObject();
            title.put("it_IT", "Interazione");
            title.put("en_US", "Interactions");

            JSONObject drawOnTop = new JSONObject();
            drawOnTop.put("singlesensor", "false");
            drawOnTop.put("title", title);
            drawOnTop.put("message", message);
            drawOnTop.put("confirmation", confirmation);
            drawOnTop.put("background", "ic_touch");
            drawOnTop.put("permission", "touch_permission");
            drawOnTop.put("skip", "true");
            drawOnTop.put("order", 6);

            JSONObject messagelow = new JSONObject();
            messagelow.put("it_IT", "La configurazione è terminata!\nAdesso basta che fai andare i-Log e rispondi alle domande quando possibile.\nHai dato %d permessi su %d; ricorda che se ne volessi dare di più, puoi farlo nelle impostazioni di i-Log.\nGrazie mille!");
            messagelow.put("en_US", "The configuration procedure is over!\nNow, just keep i-Log running and reply to the questions whenever possible.\nYou have provided %d permissions out of %d, please remember that if you want to provide more, you can do so in the i-Log Settings.\nThank you very much!");

            JSONObject messagehigh = new JSONObject();
            messagehigh.put("it_IT", "La configurazione è terminata!\nAdesso basta che fai andare i-Log e rispondi alle domande quando possibile.\nGrazie mille!");
            messagehigh.put("en_US", "The configuration procedure is over!\nYou don\'t need to do anything else, just keep i-Log running and reply to the questions whenever possible.\nThank you very much!");

            confirmation = new JSONObject();
            confirmation.put("it_IT", "FINISCI");
            confirmation.put("en_US", "FINISH");

            title = new JSONObject();
            title.put("it_IT", "Resoconto");
            title.put("en_US", "Summary");

            JSONObject finalMessage = new JSONObject();
            finalMessage.put("singlesensor", "false");
            finalMessage.put("title", title);
            finalMessage.put("messagelow", messagelow);
            finalMessage.put("messagehigh", messagehigh);
            finalMessage.put("confirmation", confirmation);
            finalMessage.put("background", "ic_summary");
            finalMessage.put("permission", "summary_permission");
            finalMessage.put("skip", "true");
            finalMessage.put("order", 11);

            JSONArray permissions = new JSONArray();
            permissions.put(battery);
            permissions.put(fineLocation);
            permissions.put(wifiPermission);
            permissions.put(notification);
            permissions.put(usageStats);
            permissions.put(drawOnTop);

            permissions.put(finalMessage);

            title.put("it_IT", "Benvenuto in EUROSTAT");
            title.put("en_US", "Welcome to EUROSTAT");

            JSONObject description = new JSONObject();
            description.put("it_IT", "EUROSTAT");
            description.put("en_US", "EUROSTAT");

            JSONObject configuration = new JSONObject();
            configuration.put("witmeedatapath", "/witmee/data");
            configuration.put("compressedlogextension", "bz2");
            configuration.put("logdir", "/logs");
            configuration.put("serverbaseurl", "http://streambase1.disi.unitn.it");
            configuration.put("portseparator", ":");
            configuration.put("separator", "/");
            configuration.put("endpointuploadprofile", "uploadprofile");
            configuration.put("endpointlogin", "login");
            configuration.put("endpointprojects", "projects");
            configuration.put("endpointsignup", "signup");
            configuration.put("endpointupload", "upload");
            configuration.put("loggingrestartinterval", 1000);
            configuration.put("sensorcollectionfrequency", 70000);
            configuration.put("minimumbatterylevel", 5);
            configuration.put("bluetoothcollectionfrequency", 60000);
            configuration.put("questionnairenotificationid", 404);
            configuration.put("wificollectionfrequency", 60000);
            configuration.put("cellinfofrequency", 60000);
            configuration.put("mainnotificationid", 505);
            configuration.put("updatenotificationid", 606);
            configuration.put("serverport", 8090);
            configuration.put("applicationcollectionfrequency", 5000);
            configuration.put("bluetoothlecollectionfrequency", 60000);
            configuration.put("bluetoothlescanduration", 1000);
            configuration.put("questionnairenumberofquestions", 5);
            configuration.put("questionnairenotificationinterval", 1800000);
            configuration.put("locationcollectionfrequency", 60000);
            configuration.put("logfilesizelimitsize", 10000000);
            configuration.put("snoozenotifications", false);
            configuration.put("startdate", "20200301");
            configuration.put("enddate", "20200315");

            JSONObject informedConsent = new JSONObject();
            informedConsent.put("it_IT", "Informativa ex art. 13 del D. lgs. 196/2003 per la App “i-Log”\n" +
                    "\n" +
                    "Gentile partecipante, \n" +
                    "\n" +
                    "nell’ambito del progetto di ricerca “QROWD - Because Big Data Integration is Humanly Possible”, scaricando l’App i-Log sul Suo dispositivo mobile (smartphone) la stessa avrà l’accesso, tra gli altri, ai servizi di localizzazione presenti sul Suo dispositivo e associabili all’App medesima. Lei può attivare o disattivare liberamente l’accesso a tali servizi direttamente dalle impostazioni del Suo dispositivo mobile, ma in mancanza dei dati di localizzazione, le finalità del Progetto di ricerca non potranno essere più perseguite. Potrà inoltre decidere in ogni momento di interrompere la Sua partecipazione al progetto. Durante il progetto potranno infine esserLe somministrate eventuali sfide (challenges) alla cui partecipazione potrà essere collegata l’attribuzione di punti per il raggiungimento di premi. \n" +
                    "\n" +
                    "Prima di scaricare l’App i-Log sul Suo dispositivo mobile, La invitiamo pertanto a leggere la seguente Informativa ex art. 13 del D. lgs. 196/2003 (di seguito Codice della privacy).\n" +
                    "\n" +
                    "Finalità di Trattamento: i Suoi dati personali saranno raccolti e trattati nell’ambito delle finalità di ricerca del progetto europeo “QROWD - Because Big Data Integration is Humanly Possible” che mira ad integrare diversi tipi di dati presenti sul territorio, anche con quelli relativi alle Sue abitudini di trasporto, al fine di ottenere informazioni a valore aggiunto e fornire sia una visione d'insieme completa della mobilità cittadina in tutte le sue forme, che la progettazione e/o miglioramento di servizi in grado di sfruttare tali informazioni. Specifiche  finalità sono in particolare: (i) calcolare il modal split cittadino, un metodo di rilevazione dell’utilizzo in percentuale di vari mezzi di trasporto in città; (ii) calcolare il modal split personale, una rilevazione degli itinerari di viaggio personali; (iii) effettuare altre analisi relative alla mobilità e sostenibilità urbana. \n" +
                    "\n" +
                    "Contitolari del trattamento: Università degli Studi di Trento (di seguito anche “UNITN”), con sede via Calepina n. 14 - 38122 Trento (TN) e il Comune di Trento con sede in Via Belenzani 19- 38122 Trento (TN). \n" +
                    "\n" +
                    "Categoria dei dati trattati: i dati personali riguardano indirizzo email, dati anagrafici, nonché altri dati raccolti automaticamente tramite i sensori del Suo dispositivo mobile, quali ad esempio i dati relativi all’ubicazione. Una lista completa dei sensori si trova sul sito Web: http://trams.disi.unitn.it.\n" +
                    "\n" +
                    "Categoria di destinatari: I Suoi dati saranno trattati dal personale dipendente e/o collaboratore specificamente autorizzato di UNITN e del Comune di Trento. I Suoi dati potranno essere comunicati in forma anonima e/o aggregata agli altri membri del progetto QROWD per le finalità del progetto stesso. Per dettagli ulteriori sul progetto può visitare il seguente indirizzo: http://qrowd-project.eu/. \n" +
                    "\n" +
                    "Modalità di trattamento: I Suoi dati personali saranno trattati con modalità e procedure coerenti con le finalità sopra indicate, mediante l’adozione di misure adeguate ed idonee a garantirne la sicurezza e la riservatezza, ivi compresa la preventiva pseudonimizzazione dei dati stessi. Il trattamento dei dati sarà effettuato mediante l’ausilio di strumenti elettronici, previo sistema di autenticazione da parte dei soli soggetti autorizzati. I Suoi dati personali saranno custoditi in conformità degli obblighi di sicurezza previsti dal Codice della Privacy e conservati per il periodo di durata del Progetto di ricerca stesso. \n" +
                    "\n" +
                    "Comunicazione e/o diffusione: I Suoi dati personali non saranno oggetto di comunicazione e/o diffusione se non in forma anonima e/o aggregata. La divulgazione dei risultati statistici e/o scientifici (ad esempio mediante pubblicazione di articoli scientifici, piattaforma http://trento.qrowd-project.eu) potrà avvenire soltanto in forma aggregata o in ogni caso secondo modalità che non La rendano identificabile neppure tramite dati identificativi indiretti. I risultati statistici e/o scientifici relativi ai dati sulla Sua mobilità saranno disponibili in modalità disaggregata esclusivamente sul Suo dispositivo smartphone. \n" +
                    "\n" +
                    "Esercizio dei diritti: Lei ha diritto di accedere in ogni momento ai Suoi dati personali e conoscere come vengono trattati; ha altresì il diritto di chiedere l’aggiornamento, rettifica, integrazione e/o cancellazione, chiederne il blocco ed opporsi al loro trattamento qualora effettuato in violazione di legge (art. 7 D.Lgs. 196/2003). Per l'esercizio dei Suoi diritti nonché per informazioni ulteriori può rivolgersi ai seguenti recapiti e-mail: fausto.giunchiglia@unitn.it; segreteria_generale@comune.trento.it\n" +
                    "\n" +
                    "Può altresì consultare le pagine del progetto ai seguenti link: http://qrowd-project.eu, http://trams.disi.unitn.it e sul portale del Comune di Trento www.comune.trento.it/qrowd.");
            informedConsent.put("en_US", "Informativa ex art. 13 del D. lgs. 196/2003 per la App “i-Log”\n" +
                    "\n" +
                    "Gentile partecipante, \n" +
                    "\n" +
                    "nell’ambito del progetto di ricerca “QROWD - Because Big Data Integration is Humanly Possible”, scaricando l’App i-Log sul Suo dispositivo mobile (smartphone) la stessa avrà l’accesso, tra gli altri, ai servizi di localizzazione presenti sul Suo dispositivo e associabili all’App medesima. Lei può attivare o disattivare liberamente l’accesso a tali servizi direttamente dalle impostazioni del Suo dispositivo mobile, ma in mancanza dei dati di localizzazione, le finalità del Progetto di ricerca non potranno essere più perseguite. Potrà inoltre decidere in ogni momento di interrompere la Sua partecipazione al progetto. Durante il progetto potranno infine esserLe somministrate eventuali sfide (challenges) alla cui partecipazione potrà essere collegata l’attribuzione di punti per il raggiungimento di premi. \n" +
                    "\n" +
                    "Prima di utilizzare l’App i-Log sul Suo dispositivo mobile, La invitiamo pertanto a leggere la seguente Informativa ex art. 13 del D. lgs. 196/2003 (di seguito Codice della privacy).\n" +
                    "\n" +
                    "Finalità di Trattamento: i Suoi dati personali saranno raccolti e trattati nell’ambito delle finalità di ricerca del progetto europeo “QROWD - Because Big Data Integration is Humanly Possible” che mira ad integrare diversi tipi di dati presenti sul territorio, anche con quelli relativi alle Sue abitudini di trasporto, al fine di ottenere informazioni a valore aggiunto e fornire sia una visione d'insieme completa della mobilità cittadina in tutte le sue forme, che la progettazione e/o miglioramento di servizi in grado di sfruttare tali informazioni. Specifiche  finalità sono in particolare: (i) calcolare il modal split cittadino, un metodo di rilevazione dell’utilizzo in percentuale di vari mezzi di trasporto in città; (ii) calcolare il modal split personale, una rilevazione degli itinerari di viaggio personali; (iii) effettuare altre analisi relative alla mobilità e sostenibilità urbana. \n" +
                    "\n" +
                    "Contitolari del trattamento: Università degli Studi di Trento (di seguito anche “UNITN”), con sede via Calepina n. 14 - 38122 Trento (TN) e il Comune di Trento con sede in Via Belenzani 19- 38122 Trento (TN). \n" +
                    "\n" +
                    "Categoria dei dati trattati: i dati personali riguardano indirizzo email, dati anagrafici, nonché altri dati raccolti automaticamente tramite i sensori del Suo dispositivo mobile, quali ad esempio i dati relativi all’ubicazione. Una lista completa dei sensori si trova sul sito Web: http://trams.disi.unitn.it.\n" +
                    "\n" +
                    "Categoria di destinatari: I Suoi dati saranno trattati dal personale dipendente e/o collaboratore specificamente autorizzato di UNITN e del Comune di Trento. I Suoi dati potranno essere comunicati in forma anonima e/o aggregata agli altri membri del progetto QROWD per le finalità del progetto stesso. Per dettagli ulteriori sul progetto può visitare il seguente indirizzo: http://qrowd-project.eu/. \n" +
                    "\n" +
                    "Modalità di trattamento: I Suoi dati personali saranno trattati con modalità e procedure coerenti con le finalità sopra indicate, mediante l’adozione di misure adeguate ed idonee a garantirne la sicurezza e la riservatezza, ivi compresa la preventiva pseudonimizzazione dei dati stessi. Il trattamento dei dati sarà effettuato mediante l’ausilio di strumenti elettronici, previo sistema di autenticazione da parte dei soli soggetti autorizzati. I Suoi dati personali saranno custoditi in conformità degli obblighi di sicurezza previsti dal Codice della Privacy e conservati per il periodo di durata del Progetto di ricerca stesso. \n" +
                    "\n" +
                    "Comunicazione e/o diffusione: I Suoi dati personali non saranno oggetto di comunicazione e/o diffusione se non in forma anonima e/o aggregata. La divulgazione dei risultati statistici e/o scientifici (ad esempio mediante pubblicazione di articoli scientifici, piattaforma http://trento.qrowd-project.eu) potrà avvenire soltanto in forma aggregata o in ogni caso secondo modalità che non La rendano identificabile neppure tramite dati identificativi indiretti. I risultati statistici e/o scientifici relativi ai dati sulla Sua mobilità saranno disponibili in modalità disaggregata esclusivamente sul Suo dispositivo smartphone. \n" +
                    "\n" +
                    "Esercizio dei diritti: Lei ha diritto di accedere in ogni momento ai Suoi dati personali e conoscere come vengono trattati; ha altresì il diritto di chiedere l’aggiornamento, rettifica, integrazione e/o cancellazione, chiederne il blocco ed opporsi al loro trattamento qualora effettuato in violazione di legge (art. 7 D.Lgs. 196/2003). Per l'esercizio dei Suoi diritti nonché per informazioni ulteriori può rivolgersi ai seguenti recapiti e-mail: fausto.giunchiglia@unitn.it; segreteria_generale@comune.trento.it\n" +
                    "\n" +
                    "Può altresì consultare le pagine del progetto ai seguenti link: http://qrowd-project.eu, http://trams.disi.unitn.it e sul portale del Comune di Trento www.comune.trento.it/qrowd.");

            JSONArray profile = new JSONArray("[{\"q\": {\"p\": [{\"t\": \"Main activity status\",\"l\": \"en-US\"}, {\"t\": \"Che lavoro fai?\",\"l\": \"it-IT\"}],\"c\": [],\"at\": \"s\",\"t\": \"t\",\"id\": 1},\"a\": [{\"p\": [{\"t\": \"Employed full-time\",\"l\": \"en-US\"}, {\"t\": \"Lavoratore\",\"l\": \"it-IT\"}],\"c\": [],\"c_id\": -1,\"id\": 1}, {\"p\": [{\"t\": \"Employed part-time\",\"l\": \"en-US\"}, {\"t\": \"Part-time\",\"l\": \"it-IT\"}],\"c\": [],\"c_id\": -1,\"id\": 2}, {\"p\": [{\"t\": \"On leave\",\"l\": \"en-US\"}, {\"t\": \"Anno Sabbatico\",\"l\": \"it-IT\"}],\"c\": [],\"c_id\": -1,\"id\": 3}, {\"p\": [{\"t\": \"Unemployed\",\"l\": \"en-US\"}, {\"t\": \"Disoccupato\",\"l\": \"it-IT\"}],\"c\": [],\"c_id\": -1,\"id\": 4}, {\"p\": [{\"t\": \"Pupil, student, further training, unpaid traineeship\",\"l\": \"en-US\"}, {\"t\": \"Studente\",\"l\": \"it-IT\"}],\"c\": [],\"c_id\": -1,\"id\": 5}, {\"p\": [{\"t\": \"In retirement or early retirement or has given up business;\",\"l\": \"en-US\"}, {\"t\": \"Pensionato\",\"l\": \"it-IT\"}],\"c\": [],\"c_id\": -1,\"id\": 6}, {\"p\": [{\"t\": \"Fulfilling domestic tasks\",\"l\": \"en-US\"}, {\"t\": \"Casalingo/a\",\"l\": \"it-IT\"}],\"c\": [],\"c_id\": -1,\"id\": 7}, {\"p\": [{\"t\": \"Other\",\"l\": \"en-US\"}, {\"t\": \"Altro\",\"l\": \"it-IT\"}],\"c\": [],\"c_id\": -1,\"id\": 8}]}, {\"q\": {\"p\": [{\"t\": \"What is your age?\",\"l\": \"en-US\"}, {\"t\": \"Quanti anni hai?\",\"l\": \"it-IT\"}],\"c\": [],\"at\": \"s\",\"t\": \"t\",\"id\": 2},\"a\": [{\"p\": [{\"t\": \"16 - 17\",\"l\": \"en-US\"}, {\"t\": \"16 - 24\",\"l\": \"it-IT\"}],\"c\": [],\"c_id\": -1,\"id\": 1}, {\"p\": [{\"t\": \"25 - 34\",\"l\": \"en-US\"}, {\"t\": \"25 - 34\",\"l\": \"it-IT\"}],\"c\": [],\"c_id\": -1,\"id\": 2}, {\"p\": [{\"t\": \"18 - 19\",\"l\": \"en-US\"}, {\"t\": \"18 - 19\",\"l\": \"it-IT\"}],\"c\": [],\"c_id\": -1,\"id\": 3}, {\"p\": [{\"t\": \"20 - 24\",\"l\": \"en-US\"}, {\"t\": \"20 - 24\",\"l\": \"it-IT\"}],\"c\": [],\"c_id\": -1,\"id\": 4}, {\"p\": [{\"t\": \"25 - 29\",\"l\": \"en-US\"}, {\"t\": \"25 - 29\",\"l\": \"it-IT\"}],\"c\": [],\"c_id\": -1,\"id\": 5}, {\"p\": [{\"t\": \"30 - 34\",\"l\": \"en-US\"}, {\"t\": \"30 - 34\",\"l\": \"it-IT\"}],\"c\": [],\"c_id\": -1,\"id\": 6}, {\"p\": [{\"t\": \"35 - 39\",\"l\": \"en-US\"}, {\"t\": \"35 - 39\",\"l\": \"it-IT\"}],\"c\": [],\"c_id\": -1,\"id\": 7}, {\"p\": [{\"t\": \"40 - 44\",\"l\": \"en-US\"}, {\"t\": \"40 - 44\",\"l\": \"it-IT\"}],\"c\": [],\"c_id\": -1,\"id\": 8}, {\"p\": [{\"t\": \"45 - 49\",\"l\": \"en-US\"}, {\"t\": \"45 - 49\",\"l\": \"it-IT\"}],\"c\": [],\"c_id\": -1,\"id\": 9}, {\"p\": [{\"t\": \"50 - 54\",\"l\": \"en-US\"}, {\"t\": \"50 - 54\",\"l\": \"it-IT\"}],\"c\": [],\"c_id\": -1,\"id\": 10}, {\"p\": [{\"t\": \"55 - 59\",\"l\": \"en-US\"}, {\"t\": \"55 - 59\",\"l\": \"it-IT\"}],\"c\": [],\"c_id\": -1,\"id\": 11}, {\"p\": [{\"t\": \"60 - 64\",\"l\": \"en-US\"}, {\"t\": \"60 - 64\",\"l\": \"it-IT\"}],\"c\": [],\"c_id\": -1,\"id\": 12}, {\"p\": [{\"t\": \"65 - 69\",\"l\": \"en-US\"}, {\"t\": \"65 - 69\",\"l\": \"it-IT\"}],\"c\": [],\"c_id\": -1,\"id\": 13}, {\"p\": [{\"t\": \"70 - 74\",\"l\": \"en-US\"}, {\"t\": \"70 - 74\",\"l\": \"it-IT\"}],\"c\": [],\"c_id\": -1,\"id\": 14}, {\"p\": [{\"t\": \"Greater than 74\",\"l\": \"en-US\"}, {\"t\": \"Maggiore di 74\",\"l\": \"it-IT\"}],\"c\": [],\"c_id\": -1,\"id\": 15}]}, {\"q\": {\"p\": [{\"t\": \"What is your gender?\",\"l\": \"en-US\"}, {\"t\": \"Di che sesso sei?\",\"l\": \"it-IT\"}],\"c\": [],\"at\": \"s\",\"t\": \"t\",\"id\": 3},\"a\": [{\"p\": [{\"t\": \"Male\",\"l\": \"en-US\"}, {\"t\": \"Uomo\",\"l\": \"it-IT\"}],\"c\": [],\"c_id\": -1,\"id\": 1}, {\"p\": [{\"t\": \"Female\",\"l\": \"en-US\"}, {\"t\": \"Donna\",\"l\": \"it-IT\"}],\"c\": [],\"c_id\": -1,\"id\": 2}]}, {\"q\": {\"p\": [{\"t\": \"How many people live with you (comprehending you)?\",\"l\": \"en-US\"}, {\"t\": \"Quante persone vivono insieme a te (compreso te)?\",\"l\": \"it-IT\"}],\"c\": [],\"at\": \"s\",\"t\": \"t\",\"id\": 4},\"a\": [{\"p\": [{\"t\": \"1\",\"l\": \"en-US\"}, {\"t\": \"1\",\"l\": \"it-IT\"}],\"c\": [],\"c_id\": -1,\"id\": 1}, {\"p\": [{\"t\": \"2\",\"l\": \"en-US\"}, {\"t\": \"2\",\"l\": \"it-IT\"}],\"c\": [],\"c_id\": -1,\"id\": 2}, {\"p\": [{\"t\": \"3\",\"l\": \"en-US\"}, {\"t\": \"3\",\"l\": \"it-IT\"}],\"c\": [],\"c_id\": -1,\"id\": 3}, {\"p\": [{\"t\": \"4\",\"l\": \"en-US\"}, {\"t\": \"4\",\"l\": \"it-IT\"}],\"c\": [],\"c_id\": -1,\"id\": 4}, {\"p\": [{\"t\": \"5\",\"l\": \"en-US\"}, {\"t\": \"5\",\"l\": \"it-IT\"}],\"c\": [],\"c_id\": -1,\"id\": 5}, {\"p\": [{\"t\": \"More than 5\",\"l\": \"en-US\"}, {\"t\": \"Più di 5\",\"l\": \"it-IT\"}],\"c\": [],\"c_id\": -1,\"id\": 6}]}, {\"q\": {\"p\": [{\"t\": \"Do you have a driving license?\",\"l\": \"en-US\"}, {\"t\": \"Hai la patente?\",\"l\": \"it-IT\"}],\"c\": [],\"at\": \"s\",\"t\": \"t\",\"id\": 5},\"a\": [{\"p\": [{\"t\": \"Yes\",\"l\": \"en-US\"}, {\"t\": \"Si\",\"l\": \"it-IT\"}],\"c\": [],\"c_id\": -1,\"id\": 1}, {\"p\": [{\"t\": \"No\",\"l\": \"en-US\"}, {\"t\": \"No\",\"l\": \"it-IT\"}],\"c\": [],\"c_id\": -1,\"id\": 2}]}, {\"q\": {\"p\": [{\"t\": \"How many vehicles are available to all you cohabitants?\",\"l\": \"en-US\"}, {\"t\": \"Quanti veicoli sono disponibili nel tuo nucleo familiare?\",\"l\": \"it-IT\"}],\"c\": [],\"at\": \"s\",\"t\": \"t\",\"id\": 6},\"a\": [{\"p\": [{\"t\": \"0\",\"l\": \"en-US\"}, {\"t\": \"0\",\"l\": \"it-IT\"}],\"c\": [],\"c_id\": -1,\"id\": 1}, {\"p\": [{\"t\": \"1\",\"l\": \"en-US\"}, {\"t\": \"1\",\"l\": \"it-IT\"}],\"c\": [],\"c_id\": -1,\"id\": 2}, {\"p\": [{\"t\": \"2\",\"l\": \"en-US\"}, {\"t\": \"2\",\"l\": \"it-IT\"}],\"c\": [],\"c_id\": -1,\"id\": 3}, {\"p\": [{\"t\": \"3\",\"l\": \"en-US\"}, {\"t\": \"3\",\"l\": \"it-IT\"}],\"c\": [],\"c_id\": -1,\"id\": 4}, {\"p\": [{\"t\": \"4\",\"l\": \"en-US\"}, {\"t\": \"4\",\"l\": \"it-IT\"}],\"c\": [],\"c_id\": -1,\"id\": 5}, {\"p\": [{\"t\": \"5\",\"l\": \"en-US\"}, {\"t\": \"5\",\"l\": \"it-IT\"}],\"c\": [],\"c_id\": -1,\"id\": 6}, {\"p\": [{\"t\": \"More than 5\",\"l\": \"en-US\"}, {\"t\": \"Più di 5\",\"l\": \"it-IT\"}],\"c\": [],\"c_id\": -1,\"id\": 7}]}]");

            JSONArray sensors = new JSONArray();
            sensors.put(new JSONObject("{'id': "+GPS_ID+"}"));
            sensors.put(new JSONObject("{'id': "+NETWORK_ID+"}"));
            sensors.put(new JSONObject("{'id': "+WIFI_SENSOR_ID+"}"));
            sensors.put(new JSONObject("{'id': "+APP_USAGE_ID+"}"));
            sensors.put(new JSONObject("{'id': "+WIFI_NETWORKS_SENSOR_ID+"}"));
            sensors.put(new JSONObject("{'id': "+SCREEN_ID+"}"));
            sensors.put(new JSONObject("{'id': "+DOZE_ID+"}"));
            sensors.put(new JSONObject("{'id': "+BATTERY_CHARGE_ID+"}"));
            sensors.put(new JSONObject("{'id': "+HEADSET_ID+"}"));
            sensors.put(new JSONObject("{'id': "+MUSIC_ID+"}"));
            sensors.put(new JSONObject("{'id': "+AIRPLANE_MODE_ID+"}"));
            sensors.put(new JSONObject("{'id': "+RING_MODE_ID+"}"));
            sensors.put(new JSONObject("{'id': "+USER_PRESENT_ID+"}"));
            sensors.put(new JSONObject("{'id': "+BATTERY_LEVEL_ID+"}"));
            sensors.put(new JSONObject("{'id': "+NOTIFICATION_ID+"}"));
            sensors.put(new JSONObject("{'id': "+TOUCH_ID+"}"));
            sensors.put(new JSONObject("{'id': "+CELLINFO_ID+"}"));
            sensors.put(new JSONObject("{'id': "+TYPE_ACCELEROMETER+"}"));
            sensors.put(new JSONObject("{'id': "+TYPE_GRAVITY+"}"));
            sensors.put(new JSONObject("{'id': "+TYPE_GYROSCOPE+"}"));
            sensors.put(new JSONObject("{'id': "+TYPE_LINEAR_ACCELERATION+"}"));
            sensors.put(new JSONObject("{'id': "+TYPE_ROTATION_VECTOR+"}"));
            sensors.put(new JSONObject("{'id': "+TYPE_MAGNETIC_FIELD+"}"));
            sensors.put(new JSONObject("{'id': "+TYPE_ORIENTATION+"}"));
            sensors.put(new JSONObject("{'id': "+TYPE_PROXIMITY+"}"));
            sensors.put(new JSONObject("{'id': "+TYPE_AMBIENT_TEMPERATURE+"}"));
            sensors.put(new JSONObject("{'id': "+TYPE_LIGHT+"}"));
            sensors.put(new JSONObject("{'id': "+TYPE_PRESSURE+"}"));
            sensors.put(new JSONObject("{'id': "+TYPE_RELATIVE_HUMIDITY+"}"));
            sensors.put(new JSONObject("{'id': "+TYPE_TEMPERATURE+"}"));
            sensors.put(new JSONObject("{'id': "+MOVEMENT_ACTIVITY_ID+"}"));

            MultiLanguageText _title = mapper.readValue(title.toString(), MultiLanguageText.class);
            Configuration _configuration = mapper.readValue(configuration.toString(), Configuration.class);
            MultiLanguageText _description = mapper.readValue(description.toString(), MultiLanguageText.class);
            MultiLanguageText _informedConsent = mapper.readValue(informedConsent.toString(), MultiLanguageText.class);
            List<Permission> _permissions = Arrays.asList(mapper.readValue(permissions.toString(), Permission[].class));
            List<QuestionAnswerView> _profile = Arrays.asList(mapper.readValue(profile.toString(), QuestionAnswerView[].class));
            List<SensorId> _sensors= Arrays.asList(mapper.readValue(sensors.toString(), SensorId[].class));


            Experiment project = new Experiment(2022, "testexperiment",
                    _title,
                    _configuration,
                    _description,
                    "https://www.tesla.com/sites/default/files/images/software_update.jpg",
                    _informedConsent,
                    _permissions,
                    _profile,
                    _sensors);
            
            return project;
            } catch(Exception e) {
            logger.error(e.getMessage());
            logger.error(e.getStackTrace());
        }
        return null;
    }
    
    public static Experiment getExperiment() {
        return createProject();
    }
    
}
