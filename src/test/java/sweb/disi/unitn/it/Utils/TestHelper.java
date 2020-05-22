/*package sweb.disi.unitn.it.Utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import sweb.disi.unitn.it.sweb.disi.unitn.it.objects.JsonStructure;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public final class TestHelper {

	final static Logger logger = LogManager.getLogger(TestHelper.class);

	private static String email1 = "user1@test.com";

	private static String email2 = "user2@test.com";


	public static void dropMysql(MysqlProperties mysqlProperties){
		try {
			DAOFactory da = DAOFactory.getInstance(mysqlProperties);
			da.dropDatabase();

		}catch (Exception e){
			logger.error(e.getMessage());
			logger.error(e.getStackTrace());
		}
	}

	public static void createUsersInMysql(User user, MysqlProperties mysqlProperties){

		try {
			DAOFactory da = DAOFactory.getInstance(mysqlProperties);
			da.initializeDatabaseAndTables();
			UserDAO userDAO= da.getUserDAO();
			userDAO.create(user);

		}catch (Exception e){
			logger.error(e.getMessage());
			logger.error(e.getStackTrace());
		}

	}

	public static void deleteUsersInMysql(MysqlProperties mysqlProperties){

		UserDAO userDAO = null;

		try {
			DAOFactory da = DAOFactory.getInstance(mysqlProperties);
			da.initializeDatabaseAndTables();
			userDAO = da.getUserDAO();
		}catch (Exception e){
			logger.error(e.getMessage());
		}

		List<User> users = userDAO.getAllUsers();

		for (User user : users){
			userDAO.deleteByEmail(user.getEmail());
		}
	}

	public static void createUsersInMysql(MysqlProperties mysqlProperties){

		UserDAO userDAO = null;

		try {
			DAOFactory da = DAOFactory.getInstance(mysqlProperties);
			da.initializeDatabaseAndTables();
			userDAO = da.getUserDAO();
		}catch (Exception e){
			logger.error(e.getMessage());
		}


		String salt1 = "id1";
		String firebase1 = "token1";
		String role1 = "user";
		String project1 = "testexperiment";

		User user1 = new User(email1, salt1, firebase1, role1, project1);

		String salt2 = "id2";
		String firebase2 = "token2";
		String role2 = "user";
		String project2 = "testexperiment";

		User user2 = new User(email2, salt2, firebase2, role2, project2);


		userDAO.create(user1);
		userDAO.create(user2);
	}

	public MysqlProperties getMysqlProperties() {
		MysqlProperties mysqlProperties = new MysqlProperties();
		mysqlProperties.setAddress("localhost");
		mysqlProperties.setUsername("root");
		mysqlProperties.setPassword("root");
		mysqlProperties.setDatabase("ilogbaseTest");
		mysqlProperties.setMax_pool_size("10");
		mysqlProperties.setConfig_tables_file("createMySqlTableQueries.xml");
		mysqlProperties.setTable_users("users");

		return mysqlProperties;
	}

	public static JsonStructure generateCassandraContent(CassandraProperties cassandraProperties, User user, String property, String timestamp) throws Exception {

		HashMap<String, Class<?>> map = getMapTablenameToModel(cassandraProperties);

		StreamDataService streamDataService = new StreamDataService(cassandraProperties);

		JsonStructure obj = generateContent(user, timestamp, map.get(property));
		streamDataService.saveDataEntity(obj);

		return obj;
	}

	public static void deleteCassandraContent(CassandraProperties cassandraProperties, Class<?> cl) throws CustomException {

		HashMap<Class<?>, String> map = mapClassToTableName(cassandraProperties);

		StreamDataService streamDataService = new StreamDataService(cassandraProperties);

		if (cassandraProperties.getApplicationKeyspace().contains("test")) {

			streamDataService.getCassandraSession().executeAsync("TRUNCATE " + cassandraProperties.getApplicationKeyspace() + "." + map.get(cl));
		}

		else{
			throw new CustomException("Cassandra Keyspace " + cassandraProperties.getApplicationKeyspace() + "doesn't seem to be for testing purposes." +
					"will not delete it as it doesn't contain \"test\" in its name");
		}

	}

	public static void deleteCassandraContent(CassandraProperties cassandraProperties, String property) throws CustomException {

		StreamDataService streamDataService = new StreamDataService(cassandraProperties);

		if (cassandraProperties.getApplicationKeyspace().contains("test")) {

			streamDataService.getCassandraSession().executeAsync("TRUNCATE " + cassandraProperties.getApplicationKeyspace() + "." + property);
		}

		else{
			throw new CustomException("Cassandra Keyspace " + cassandraProperties.getApplicationKeyspace() + "doesn't seem to be for testing purposes." +
					"will not delete it as it doesn't contain \"test\" in its name");
		}

	}

	public static JsonStructure generateContent(String userId, Class<?>...clazzes) throws IOException, Exception {
		return generateContent(userId, "20190825205900123", clazzes );
	}

	public static JsonStructure generateContent(User user, String timestamp, Class<?>...clazzes) throws Exception{
		JsonStructure content = new JsonStructure();
		content.experimentId = user.getProject();
		content.userId = user.getSalt();
		Entity entity = new Entity(content.userId, Entity.USER_TYPE);
		content.entity = entity;

		content.setProperties(generateSensorContent(user.getSalt(), user.getProject(), timestamp, clazzes));

		return content;

	}

	public static JsonStructure generateContent(String userId, String timestamp, Class<?>...clazzes ) throws IOException, Exception {

		JsonStructure content = new JsonStructure();
		content.experimentId = "testexperiment";
		content.userId = userId;
		Entity entity = new Entity(userId, Entity.USER_TYPE);
		content.entity = entity;

		content.setProperties(generateSensorContent(content.userId, content.experimentId, timestamp, clazzes));

		return content;
	}

	private static List<Property> generateSensorContent(String userId, String experimentId, String timestamp, Class<?>...clazzes) throws Exception {

		ObjectMapper mapper = new ObjectMapper();

		String jsonQuestion = "[{\"q\":{\"p\":[{\"t\":\"What are you doing?\",\"l\":\"en-US\"},{\"t\":\"Cosa stai facendo?\",\"l\":\"it-IT\"}],\"at\":\"s\",\"t\":\"t\",\"id\":1},\"a\":[{\"p\":[{\"t\":\"Sleeping\",\"l\":\"en-US\"},{\"t\":\"Sleeping\",\"l\":\"it-IT\"}],\"c_id\":74549,\"id\":1},{\"p\":[{\"t\":\"Eating\",\"l\":\"en-US\"},{\"t\":\"Eating\",\"l\":\"it-IT\"}],\"c_id\":4317,\"id\":2},{\"p\":[{\"t\":\"Doing personal care, e.g. showering\",\"l\":\"en-US\"},{\"t\":\"Doing personal care, e.g. showering\",\"l\":\"it-IT\"}],\"c_id\":3406,\"id\":3},{\"p\":[{\"t\":\"Working (Paid for)\",\"l\":\"en-US\"},{\"t\":\"Working (Paid for)\",\"l\":\"it-IT\"}],\"c_id\":3405,\"id\":4},{\"p\":[{\"t\":\"Studying\",\"l\":\"en-US\"},{\"t\":\"Studying\",\"l\":\"it-IT\"}],\"c_id\":31428,\"id\":5},{\"p\":[{\"t\":\"Doing housework\",\"l\":\"en-US\"},{\"t\":\"Doing housework\",\"l\":\"it-IT\"}],\"c_id\":31429,\"id\":6},{\"p\":[{\"t\":\"Caring for children/family\",\"l\":\"en-US\"},{\"t\":\"Caring for children/family\",\"l\":\"it-IT\"}],\"c_id\":4581,\"id\":7},{\"p\":[{\"t\":\"Engaging in voluntary work\",\"l\":\"en-US\"},{\"t\":\"Engaging in voluntary work\",\"l\":\"it-IT\"}],\"c_id\":31429,\"id\":8},{\"p\":[{\"t\":\"Engaging socially with other people\",\"l\":\"en-US\"},{\"t\":\"Engaging socially with other people\",\"l\":\"it-IT\"}],\"c_id\":31230,\"id\":9},{\"p\":[{\"t\":\"Engaging in online social media\",\"l\":\"en-US\"},{\"t\":\"Engaging in online social media\",\"l\":\"it-IT\"}],\"c_id\":31231,\"id\":10},{\"p\":[{\"t\":\"Talking on the phone\",\"l\":\"en-US\"},{\"t\":\"Talking on the phone\",\"l\":\"it-IT\"}],\"c_id\":1488,\"id\":11},{\"p\":[{\"t\":\"Participating in cultural activities\",\"l\":\"en-US\"},{\"t\":\"Participating in cultural activities\",\"l\":\"it-IT\"}],\"c_id\":25864,\"id\":12},{\"p\":[{\"t\":\"Reading\",\"l\":\"en-US\"},{\"t\":\"Reading\",\"l\":\"it-IT\"}],\"c_id\":25865,\"id\":13},{\"p\":[{\"t\":\"Doing sport and outdoor activities\",\"l\":\"en-US\"},{\"t\":\"Doing sport and outdoor activities\",\"l\":\"it-IT\"}],\"c_id\":25866,\"id\":14},{\"p\":[{\"t\":\"Engaging in hobbies, other leisure activity\",\"l\":\"en-US\"},{\"t\":\"Engaging in hobbies, other leisure activity\",\"l\":\"it-IT\"}],\"c_id\":4421,\"id\":15},{\"p\":[{\"t\":\"Going to or coming from work/study\",\"l\":\"en-US\"},{\"t\":\"Going to or coming from work/study\",\"l\":\"it-IT\"}],\"c_id\":4422,\"id\":16},{\"p\":[{\"t\":\"Travelling\",\"l\":\"en-US\"},{\"t\":\"Travelling\",\"l\":\"it-IT\"}],\"c_id\":2681,\"id\":17},{\"p\":[{\"t\":\"Doing nothing\",\"l\":\"en-US\"},{\"t\":\"Doing nothing\",\"l\":\"it-IT\"}],\"c_id\":2206,\"id\":18},{\"p\":[{\"t\":\"Other activity not listed above\",\"l\":\"en-US\"},{\"t\":\"Other activity not listed above\",\"l\":\"it-IT\"}],\"c_id\":2260,\"id\":19}]},{\"q\":{\"p\":[{\"t\":\"Where are you?\",\"l\":\"en-US\"},{\"t\":\"Dove sei?\",\"l\":\"it-IT\"}],\"at\":\"s\",\"c\":[{\"q\":1,\"a\":1},{\"q\":1,\"a\":2},{\"q\":1,\"a\":3},{\"q\":1,\"a\":4},{\"q\":1,\"a\":5},{\"q\":1,\"a\":6},{\"q\":1,\"a\":7},{\"q\":1,\"a\":8},{\"q\":1,\"a\":9},{\"q\":1,\"a\":10},{\"q\":1,\"a\":11},{\"q\":1,\"a\":12},{\"q\":1,\"a\":13},{\"q\":1,\"a\":14},{\"q\":1,\"a\":15},{\"q\":1,\"a\":18},{\"q\":1,\"a\":19}],\"t\":\"t\",\"id\":2},\"a\":[{\"p\":[{\"t\":\"Home\",\"l\":\"en-US\"},{\"t\":\"Home\",\"l\":\"it-IT\"}],\"c_id\":16418,\"id\":1},{\"p\":[{\"t\":\"Workplace or school\",\"l\":\"en-US\"},{\"t\":\"Workplace or school\",\"l\":\"it-IT\"}],\"c_id\":19369,\"id\":2},{\"p\":[{\"t\":\"Other people?s home\",\"l\":\"en-US\"},{\"t\":\"Other people?s home\",\"l\":\"it-IT\"}],\"c_id\":12345,\"id\":3},{\"p\":[{\"t\":\"Restaurant or canteen\",\"l\":\"en-US\"},{\"t\":\"Restaurant or canteen\",\"l\":\"it-IT\"}],\"c_id\":43042,\"id\":4},{\"p\":[{\"t\":\"Cafe or pub\",\"l\":\"en-US\"},{\"t\":\"Cafe or pub\",\"l\":\"it-IT\"}],\"c_id\":22500,\"id\":5},{\"p\":[{\"t\":\"Shopping centres, markets, other shops\",\"l\":\"en-US\"},{\"t\":\"Shopping centres, markets, other shops\",\"l\":\"it-IT\"}],\"c_id\":99932,\"id\":6},{\"p\":[{\"t\":\"Hotel, guesthouse, camping site\",\"l\":\"en-US\"},{\"t\":\"Hotel, guesthouse, camping site\",\"l\":\"it-IT\"}],\"c_id\":99933,\"id\":7},{\"p\":[{\"t\":\"Public garden, park, playground\",\"l\":\"en-US\"},{\"t\":\"Public garden, park, playground\",\"l\":\"it-IT\"}],\"c_id\":25604,\"id\":8},{\"p\":[{\"t\":\"Square or urban area\",\"l\":\"en-US\"},{\"t\":\"Square or urban area\",\"l\":\"it-IT\"}],\"c_id\":18937,\"id\":9},{\"p\":[{\"t\":\"Forest or rural area\",\"l\":\"en-US\"},{\"t\":\"Forest or rural area\",\"l\":\"it-IT\"}],\"c_id\":18937,\"id\":10},{\"p\":[{\"t\":\"Gym, swimming pool\",\"l\":\"en-US\"},{\"t\":\"Gym, swimming pool\",\"l\":\"it-IT\"}],\"c_id\":18938,\"id\":11},{\"p\":[{\"t\":\"Movie theater, theater, museum\",\"l\":\"en-US\"},{\"t\":\"Movie theater, theater, museum\",\"l\":\"it-IT\"}],\"c_id\":18939,\"id\":12},{\"p\":[{\"t\":\"Other place not listed above\",\"l\":\"en-US\"},{\"t\":\"Other place not listed above\",\"l\":\"it-IT\"}],\"c_id\":16382,\"id\":13}]},{\"q\":{\"p\":[{\"t\":\"How are you travelling?\",\"l\":\"en-US\"},{\"t\":\"Come ti stavi spostando?\",\"l\":\"it-IT\"}],\"c\":[{\"q\":1,\"a\":16},{\"q\":1,\"a\":17}],\"at\":\"s\",\"t\":\"t\",\"id\":3},\"a\":[{\"p\":[{\"t\":\"On foot\",\"l\":\"en-US\"},{\"t\":\"On foot\",\"l\":\"it-IT\"}],\"c_id\":1429,\"id\":1},{\"p\":[{\"t\":\"By bicycle\",\"l\":\"en-US\"},{\"t\":\"By bicycle\",\"l\":\"it-IT\"}],\"c_id\":110000,\"id\":2},{\"p\":[{\"t\":\"By motorcycle\",\"l\":\"en-US\"},{\"t\":\"By motorcycle\",\"l\":\"it-IT\"}],\"c_id\":24812,\"id\":3},{\"p\":[{\"t\":\"By car\",\"l\":\"en-US\"},{\"t\":\"By car\",\"l\":\"it-IT\"}],\"c_id\":1516,\"id\":4},{\"p\":[{\"t\":\"By metro/subway\",\"l\":\"en-US\"},{\"t\":\"By metro/subway\",\"l\":\"it-IT\"}],\"c_id\":20797,\"id\":5},{\"p\":[{\"t\":\"By train\",\"l\":\"en-US\"},{\"t\":\"By train\",\"l\":\"it-IT\"}],\"c_id\":15188,\"id\":6},{\"p\":[{\"t\":\"Other transport mode not listed above\",\"l\":\"en-US\"},{\"t\":\"Other transport mode not listed above\",\"l\":\"it-IT\"}],\"c_id\":15189,\"id\":7}]},{\"q\":{\"p\":[{\"t\":\"Who is with you?\",\"l\":\"en-US\"},{\"t\":\"Con chi sei?\",\"l\":\"it-IT\"}],\"at\":\"s\",\"t\":\"t\",\"id\":4},\"a\":[{\"p\":[{\"t\":\"Nobody\",\"l\":\"en-US\"},{\"t\":\"Nobody\",\"l\":\"it-IT\"}],\"c_id\":115093,\"id\":1},{\"p\":[{\"t\":\"Partner\",\"l\":\"en-US\"},{\"t\":\"Partner\",\"l\":\"it-IT\"}],\"c_id\":55915,\"id\":2},{\"p\":[{\"t\":\"Other relative(s) who live with me\",\"l\":\"en-US\"},{\"t\":\"Other relative(s) who live with me\",\"l\":\"it-IT\"}],\"c_id\":54154,\"id\":3},{\"p\":[{\"t\":\"Other relative(s) who do not live with me\",\"l\":\"en-US\"},{\"t\":\"Other relative(s) who do not live with m\",\"l\":\"it-IT\"}],\"c_id\":56792,\"id\":4},{\"p\":[{\"t\":\"Friend(s)\",\"l\":\"en-US\"},{\"t\":\"Friend(s)\",\"l\":\"it-IT\"}],\"c_id\":54905,\"id\":5},{\"p\":[{\"t\":\"Work colleague(s)\",\"l\":\"en-US\"},{\"t\":\"Work colleague(s)\",\"l\":\"it-IT\"}],\"c_id\":53140,\"id\":6},{\"p\":[{\"t\":\"Other person(s) known to the respondent\",\"l\":\"en-US\"},{\"t\":\"Other person(s) known to the respondent\",\"l\":\"it-IT\"}],\"c_id\":53141,\"id\":7}]},{\"q\":{\"p\":[{\"t\":\"What is your mood?\",\"l\":\"en-US\"},{\"t\":\"What is your mood?\",\"l\":\"it-IT\"}],\"at\":\"s\",\"t\":\"t\",\"id\":5},\"a\":[{\"p\":[{\"t\":\"uD83DuDE01\",\"l\":\"en-US\"},{\"t\":\"uD83DuDE01\",\"l\":\"it-IT\"}],\"c_id\":-1,\"id\":1},{\"p\":[{\"t\":\"uD83DuDE0A\",\"l\":\"en-US\"},{\"t\":\"uD83DuDE0A\",\"l\":\"it-IT\"}],\"c_id\":-1,\"id\":2},{\"p\":[{\"t\":\"uD83DuDE10\",\"l\":\"en-US\"},{\"t\":\"uD83DuDE10\",\"l\":\"it-IT\"}],\"c_id\":-1,\"id\":3},{\"p\":[{\"t\":\"uD83DuDE41\",\"l\":\"en-US\"},{\"t\":\"uD83DuDE41\",\"l\":\"it-IT\"}],\"c_id\":-1,\"id\":4},{\"p\":[{\"t\":\"uD83DuDE1E\",\"l\":\"en-US\"},{\"t\":\"uD83DuDE1E\",\"l\":\"it-IT\"}],\"c_id\":-1,\"id\":5}]}]\n";

		List<QuestionAnswerView> question = Arrays.asList(mapper.readValue(jsonQuestion, QuestionAnswerView[].class));

		List<Property> propertiesList = new ArrayList<>();

		for (Class<?> clazz : clazzes) {
			Property properties = new Property();
			if (clazz.equals(WF.class)) {
				WF sensor = new WF(experimentId, userId, timestamp, "9c:1c:12:af:93:25", "_Free Airport WiFi", "false");
				properties.getWifievent().add(sensor);
			} else if (clazz.equals(WN.class)) {
				List<String> capabilities = new ArrayList<String>();
				capabilities.add("WPA-PSK-TKIP");
				capabilities.add("WPA2-PSK-CCMP");
				WN sensor = new WN(experimentId, userId, timestamp, "32:91:8f:65:5b:6f", capabilities, 5240, -6600, "Telecom-58300775");
				properties.getWifinetworksevent().add(sensor);
			} else if (clazz.equals(NL.class)) {
				Point location = new Point(-1, 46.04129, 11.13807);
				NL sensor = new NL(experimentId, userId,timestamp, (float) 12.89, location, null);
				properties.getLocationeventpertimenetwork().add(sensor);
			} else if (clazz.equals(GL.class)) {
				Point location = new Point(12.136, 46.04129, 11.13807);
				GL sensor = new GL(experimentId, userId, timestamp, (float) 12.23 , (float) 89.34, location, (float) 3374.0, null);
				properties.getLocationeventpertime().add(sensor);
			} else if (clazz.equals(BM.class)) {
				BM sensor = new BM(experimentId, userId, timestamp, 100, 100);
				properties.getBatterymonitoringlog().add(sensor);
			} else if (clazz.equals(SM.class)) {
				SM sensor = new SM(experimentId, userId, timestamp, "10000", "True");
				properties.getSensormonitoringlog().add(sensor);
			} else if (clazz.equals(AC.class)) {
				AC sensor = new AC(experimentId, userId, timestamp, 12, 23, 23);
				properties.getAccelerometerevent().add(sensor);
			} else if (clazz.equals(AT.class)) {
				AT sensor = new AT(experimentId, userId, timestamp, (float) 33.7);
				properties.getAmbienttemperatureevent().add(sensor);
			} else if (clazz.equals(GR.class)) {
				GR sensor = new GR(experimentId, userId, timestamp, 1, 2, 3);
				properties.getGravityevent().add(sensor);
			} else if (clazz.equals(GY.class)) {
				GY sensor = new GY(experimentId, userId, timestamp, 3, 4, 5);
				properties.getGyroscopeevent().add(sensor);
			} else if (clazz.equals(LA.class)) {
				LA sensor = new LA(experimentId, userId, timestamp, 9, 8, 77);
				properties.getLinearaccelerationevent().add(sensor);
			} else if (clazz.equals(LI.class)) {
				LI sensor = new LI(experimentId, userId, timestamp, 12);
				properties.getLightevent().add(sensor);
			} else if (clazz.equals(MF.class)) {
				MF sensor = new MF(experimentId, userId, timestamp, 9, 8, 7);
				properties.getMagneticfieldevent().add(sensor);
			} else if (clazz.equals(OR.class)) {
				OR sensor = new OR(experimentId, userId, timestamp, 88, 77, 66);
				properties.getOrientationevent().add(sensor);
			} else if (clazz.equals(PE.class)) {
				PE sensor = new PE(experimentId, userId, timestamp, 23);
				properties.getPressureevent().add(sensor);
			} else if (clazz.equals(PO.class)) {
				PO sensor = new PO(experimentId, userId, timestamp, 3);
				properties.getProximityevent().add(sensor);
			} else if (clazz.equals(RH.class)) {
				RH sensor = new RH(experimentId, userId, timestamp, 15) ;
				properties.getRelativehumidityevent().add(sensor);
			} else if (clazz.equals(RV.class)) {
				RV sensor = new RV(experimentId, userId, timestamp, 4, 5, 4, 10);
				properties.getRotationvectorevent().add(sensor);
			} else if (clazz.equals(BN.class)) {
				BN sensor = new BN(experimentId, userId, timestamp, "5B:56:9B:EA:4F:ED", "BOND_NONE", "name", (float )10.3);
				properties.getBluetoothnormalevent().add(sensor);
			} else if (clazz.equals(BL.class)) {
				BL sensor = new BL(experimentId, userId, timestamp, "5B:56:9B:EA:4F:ED", "BOND_NONE", "name", (float) 33.0);
				properties.getBluetoothlowenergyevent().add(sensor);
			} else if (clazz.equals(AM.class)) {
				AM sensor = new AM(experimentId, userId, timestamp, true);
				properties.getAirplanemodeevent().add(sensor);
			} else if (clazz.equals(BC.class)) {
				BC sensor = new BC(experimentId, userId, timestamp, true , "charging_ac");
				properties.getBatterychargeevent().add(sensor);
			} else if (clazz.equals(DO.class)) {
				DO sensor = new DO(experimentId, userId, timestamp, true);
				properties.getDozeevent().add(sensor);
			} else if (clazz.equals(HP.class)) {
				HP sensor = new HP(experimentId, userId, timestamp, true);
				properties.getHeadsetplugevent().add(sensor);
			} else if (clazz.equals(RM.class)) {
				RM sensor = new RM(experimentId, userId, timestamp, "mode_normal");
				properties.getRingmodeevent().add(sensor);
			} else if (clazz.equals(MU.class)) {
				MU sensor = new MU(experimentId, userId, timestamp, true);
				properties.getMusicevent().add(sensor);
			} else if (clazz.equals(ST.class)) {
				ST sensor = new ST(userId, timestamp, "7.1.1", "OSVersion", "deviceModel", "manufacturer", 12, "eventType", "eventPayload");
				properties.getStatisticevents().add(sensor);
			} else if (clazz.equals(AP.class)) {
				AP sensor = new AP(experimentId, userId, timestamp, "net.oneplus.launcher");
				properties.getApplicationevent().add(sensor);
			} else if (clazz.equals(CI.class)) {
				CI sensor = new CI(experimentId, userId, timestamp, "00390471999999", "Pippo", "CALL_LOST", "20171108175654757", "20171108175638304", 16453);
				properties.getPhonecallinevent().add(sensor);
			} else if (clazz.equals(CO.class)) {
				CO sensor = new CO(experimentId, userId, timestamp, "00390809996000", "Pippo", "20171108175654757", "20171108175638304", 16453);
				properties.getPhonecalloutevent().add(sensor);
			} else if (clazz.equals(SI.class)) {
				SI sensor = new SI(experimentId, userId, timestamp, "00390809996000", "Pippo");
				properties.getSmsinevent().add(sensor);
			} else if (clazz.equals(SO.class)) {
				SO sensor = new SO(experimentId, userId, timestamp, "00390809996000", "Pippo");
				properties.getSmsoutevent().add(sensor);
			} else if (clazz.equals(CN.class)) {
				CN sensor = new CN(experimentId, userId, timestamp, 13, "cellId", "type");
				properties.getCellularnetwork().add(sensor);
			} else if (clazz.equals(NE.class)) {
				NE sensor = new NE(experimentId, userId, timestamp, "notificationStatus", "nodificationId", "notificationPackage", true, false);
				properties.getNotificationevent().add(sensor);
			} else if (clazz.equals(SC.class)) {
				SC sensor = new SC(experimentId, userId, timestamp, "SCREEN_ON");
				properties.getScreenevent().add(sensor);
			} else if (clazz.equals(TE.class)) {
				TE Sensor = new TE(experimentId, userId, timestamp);
				properties.getTouchevent().add(Sensor);
			} else if (clazz.equals(MV.class)) {
				MV sensor = new MV(experimentId, userId, timestamp, "W3siT25Gb290Ijo5MH0seyJXYWxraW5nIjo5MH0seyJSdW5uaW5nIjoxMH1d,20191015221324902");
				properties.getActivityevent().add(sensor);
			} else if (clazz.equals(TimediaryAnswer.class)) {
				TimediaryAnswer sensor = new TimediaryAnswer(experimentId, userId, "a8dasfa8", timestamp, timestamp, timestamp,
						30099, 8456222, getAnswersExamples(), getPayloadExamples(), "day");
				properties.getTimediariesanswers().add(sensor);
			} else if (clazz.equals(TaskAnswer.class)) {
				TaskAnswer sensor = new TaskAnswer(experimentId, userId,"a8dasfa8", timestamp, timestamp, timestamp, 10000, 20000,
						getAnswersExamples(), getPayloadExamples(), "20190910");
				properties.getTaskanswers().add(sensor);
			} else if (clazz.equals(TaskQuestion.class)) {

				TaskQuestion sensor = new TaskQuestion(experimentId, userId, "a8dasfa8", "20190808", timestamp, question, "status", "title");
				properties.getTaskquestions().add(sensor);
			}else if (clazz.equals(TimediaryQuestion.class)) {

				TimediaryQuestion sensor = new TimediaryQuestion(experimentId, userId, "a8dasfa8", "20190808", timestamp, question, "status", "title");
				properties.getTimediariesquestions().add(sensor);
			}else if (clazz.equals(ChallengeAnswer.class)) {
				ChallengeAnswer sensor = new ChallengeAnswer(experimentId, userId, "a8dasfa8", timestamp, timestamp, timestamp,
						30099, 8456222, getAnswersExamples(), getPayloadExamples(), "day");
				properties.getChallengesanswers().add(sensor);
			} else if (clazz.equals(ChallengeSubscription.class)) {
				ChallengeSubscription sensor = new ChallengeSubscription(experimentId, userId, "a8dasfa8","status",getPayloadExamples(), timestamp);
				properties.getChallengesubscriptions().add(sensor);
			}else if (clazz.equals(AU.class)) {
				AU sensor = new AU(experimentId, userId, timestamp, "audioStream");
				properties.getAudioevent().add(sensor);
			}
			propertiesList.add(properties);
		}

		return propertiesList;
	}

	private static List<List<AnswerContentView>> getAnswersExamples() throws IOException{

		ObjectMapper mapper = new ObjectMapper();

		JSONArray jsonAnswer = new JSONArray("[[{\"cnt\":\"Very Good\",\"qid\":1,\"aid\":2,\"cid\":-1}]]");

		List<List<AnswerContentView>> answer = mapper.readValue(jsonAnswer.toString(), new TypeReference<List<List<AnswerContentView>>>(){});

		return answer;
	}
	
	private static List<PayloadView> getPayloadExamples() throws Exception{

		ObjectMapper mapper = new ObjectMapper();
		String jsonPayload = "[{\"payload\":{\"data\":{\"lat\":41.71099668,\"long\":16.05088394}},\"qid\":1},{\"payload\":{\"metadata\":{\"lat\":41.7109949,\"long\":16.0508843,\"timestamp\":\"20200317152102000\"},\"picture\":\"/9j/4RU2RXhpZgAATUUA\"},\"qid\":2},{\"payload\":{},\"qid\":3},{\"payload\":{},\"qid\":4}]";

		List<PayloadView> payload = Arrays.asList(mapper.readValue(jsonPayload, PayloadView[].class));

	    return payload;
	}


	private static HashMap<String, Class<?>> getMapTablenameToModel(CassandraProperties cassandraProperties) {
		HashMap<String, Class<?>> mappingTablenameToModel = new HashMap<>();

		mappingTablenameToModel = new HashMap<String, Class<?>>();
		mappingTablenameToModel.put(cassandraProperties.getTable_wifievent(), WF.class);
		mappingTablenameToModel.put(cassandraProperties.getTable_wifinetworksevent(), WN.class);
		mappingTablenameToModel.put(cassandraProperties.getTable_audioevent(), AU.class);
		mappingTablenameToModel.put(cassandraProperties.getTable_locationeventpertime(), NL.class);
		mappingTablenameToModel.put(cassandraProperties.getTable_locationeventpertime(), GL.class);
		mappingTablenameToModel.put(cassandraProperties.getTable_batterymonitoringlog(), BM.class);
		mappingTablenameToModel.put(cassandraProperties.getTable_sensormonitoringlog(), SM.class);
		mappingTablenameToModel.put(cassandraProperties.getTable_accelerometerevent(), AC.class);
		mappingTablenameToModel.put(cassandraProperties.getTable_ambienttemperatureevent(), AT.class);
		mappingTablenameToModel.put(cassandraProperties.getTable_gravityevent(), GR.class);
		mappingTablenameToModel.put(cassandraProperties.getTable_gyroscopeevent(), GY.class);
		mappingTablenameToModel.put(cassandraProperties.getTable_linearaccelerationevent(), LA.class);
		mappingTablenameToModel.put(cassandraProperties.getTable_lightevent(), LI.class);
		mappingTablenameToModel.put(cassandraProperties.getTable_magneticfieldevent(), MF.class);
		//this class is associated with two table name: activitiespertime and activitiesperlabel
		mappingTablenameToModel.put(cassandraProperties.getTable_activitiespertime() + "#" + cassandraProperties.getTable_activitiesperlabel(), MV.class);
		mappingTablenameToModel.put(cassandraProperties.getTable_orientationevent(), OR.class);
		mappingTablenameToModel.put(cassandraProperties.getTable_pressureevent(), PE.class);
		mappingTablenameToModel.put(cassandraProperties.getTable_proximityevent(), PO.class);
		mappingTablenameToModel.put(cassandraProperties.getTable_relativehumidityevent(), RH.class);
		mappingTablenameToModel.put(cassandraProperties.getTable_rotationvectorevent(), RV.class);
		mappingTablenameToModel.put(cassandraProperties.getTable_bluetoothlowenergyevent(), BL.class);
		mappingTablenameToModel.put(cassandraProperties.getTable_bluetoothnormalevent(), BN.class);
		mappingTablenameToModel.put(cassandraProperties.getTable_airplanemodeevent(), AM.class);
		mappingTablenameToModel.put(cassandraProperties.getTable_batterychargeevent(), BC.class);
		mappingTablenameToModel.put(cassandraProperties.getTable_dozeevent(), DO.class);
		mappingTablenameToModel.put(cassandraProperties.getTable_headsetplugevent(), HP.class);
		mappingTablenameToModel.put(cassandraProperties.getTable_musicevent(), MU.class);
		mappingTablenameToModel.put(cassandraProperties.getTable_ringmodeevent(), RM.class);
		mappingTablenameToModel.put(cassandraProperties.getKeyspace_users() + "." + cassandraProperties.getTable_statistics(), ST.class);
		mappingTablenameToModel.put(cassandraProperties.getTable_applicationevent(), AP.class);
		mappingTablenameToModel.put(cassandraProperties.getTable_phonecallinevent(), CI.class);
		mappingTablenameToModel.put(cassandraProperties.getTable_cellularnetwork(), CN.class);
		mappingTablenameToModel.put(cassandraProperties.getTable_phonecalloutevent(), CO.class);
		mappingTablenameToModel.put(cassandraProperties.getTable_notificationevent(), NE.class);
		mappingTablenameToModel.put(cassandraProperties.getTable_screenevent(), SC.class);
		mappingTablenameToModel.put(cassandraProperties.getTable_smsinevent(), SI.class);
		mappingTablenameToModel.put(cassandraProperties.getTable_smsoutevent(), SO.class);
		mappingTablenameToModel.put(cassandraProperties.getTable_touchevent(), TE.class);
		mappingTablenameToModel.put(cassandraProperties.getTable_timediariesquestions(), TimediaryQuestion.class);
		mappingTablenameToModel.put(cassandraProperties.getTable_timediariesanswers(), TimediaryAnswer.class);
		mappingTablenameToModel.put(cassandraProperties.getTable_tasksanswers(), TaskAnswer.class);
		mappingTablenameToModel.put(cassandraProperties.getTable_tasksquestions(), TaskQuestion.class);
		mappingTablenameToModel.put(cassandraProperties.getTable_challengesanswers(), ChallengeAnswer.class);
		mappingTablenameToModel.put(cassandraProperties.getTable_challengesubscriptions(), ChallengeSubscription.class);

		return mappingTablenameToModel;
	}

	public static HashMap<Class<?>, String> mapClassToTableName(CassandraProperties cassandraProperties) {
		HashMap<Class<?>, String> mappingModelTablename = new HashMap<Class<?>, String>();
		mappingModelTablename.put(WF.class, cassandraProperties.getTable_wifievent());
		mappingModelTablename.put(WN.class, cassandraProperties.getTable_wifinetworksevent());
		mappingModelTablename.put(AU.class, cassandraProperties.getTable_audioevent());
		mappingModelTablename.put(NL.class, cassandraProperties.getTable_locationeventpertime());
		mappingModelTablename.put(GL.class, cassandraProperties.getTable_locationeventpertime());
		mappingModelTablename.put(BM.class, cassandraProperties.getTable_batterymonitoringlog());
		mappingModelTablename.put(SM.class, cassandraProperties.getTable_sensormonitoringlog());
		mappingModelTablename.put(AC.class, cassandraProperties.getTable_accelerometerevent());
		mappingModelTablename.put(AT.class, cassandraProperties.getTable_ambienttemperatureevent());
		mappingModelTablename.put(GR.class, cassandraProperties.getTable_gravityevent());
		mappingModelTablename.put(GY.class, cassandraProperties.getTable_gyroscopeevent());
		mappingModelTablename.put(LA.class, cassandraProperties.getTable_linearaccelerationevent());
		mappingModelTablename.put(LI.class, cassandraProperties.getTable_lightevent());
		mappingModelTablename.put(MF.class, cassandraProperties.getTable_magneticfieldevent());
		//this class is associated with two table name: activitiespertime and activitiesperlabel
		mappingModelTablename.put(MV.class, cassandraProperties.getTable_activitiespertime() + "#" + cassandraProperties.getTable_activitiesperlabel());
		mappingModelTablename.put(OR.class, cassandraProperties.getTable_orientationevent());
		mappingModelTablename.put(PE.class, cassandraProperties.getTable_pressureevent());
		mappingModelTablename.put(PO.class, cassandraProperties.getTable_proximityevent());
		mappingModelTablename.put(RH.class, cassandraProperties.getTable_relativehumidityevent());
		mappingModelTablename.put(RV.class, cassandraProperties.getTable_rotationvectorevent());
		mappingModelTablename.put(BL.class, cassandraProperties.getTable_bluetoothlowenergyevent());
		mappingModelTablename.put(BN.class, cassandraProperties.getTable_bluetoothnormalevent());
		mappingModelTablename.put(AM.class, cassandraProperties.getTable_airplanemodeevent());
		mappingModelTablename.put(BC.class, cassandraProperties.getTable_batterychargeevent());
		mappingModelTablename.put(DO.class, cassandraProperties.getTable_dozeevent());
		mappingModelTablename.put(HP.class, cassandraProperties.getTable_headsetplugevent());
		mappingModelTablename.put(MU.class, cassandraProperties.getTable_musicevent());
		mappingModelTablename.put(RM.class, cassandraProperties.getTable_ringmodeevent());
		mappingModelTablename.put(ST.class, cassandraProperties.getKeyspace_users() + "." + cassandraProperties.getTable_statistics());
		mappingModelTablename.put(AP.class, cassandraProperties.getTable_applicationevent());
		mappingModelTablename.put(CI.class, cassandraProperties.getTable_phonecallinevent());
		mappingModelTablename.put(CN.class, cassandraProperties.getTable_cellularnetwork());
		mappingModelTablename.put(CO.class, cassandraProperties.getTable_phonecalloutevent());
		mappingModelTablename.put(NE.class, cassandraProperties.getTable_notificationevent());
		mappingModelTablename.put(SC.class, cassandraProperties.getTable_screenevent());
		mappingModelTablename.put(SI.class, cassandraProperties.getTable_smsinevent());
		mappingModelTablename.put(SO.class, cassandraProperties.getTable_smsoutevent());
		mappingModelTablename.put(TE.class, cassandraProperties.getTable_touchevent());
		mappingModelTablename.put(TimediaryAnswer.class, cassandraProperties.getTable_timediariesanswers());
		mappingModelTablename.put(TimediaryQuestion.class, cassandraProperties.getTable_timediariesquestions());
		mappingModelTablename.put(TaskAnswer.class, cassandraProperties.getTable_tasksanswers());
		mappingModelTablename.put(TaskQuestion.class, cassandraProperties.getTable_tasksquestions());
		mappingModelTablename.put(ChallengeAnswer.class, cassandraProperties.getTable_challengesanswers());
		mappingModelTablename.put(ChallengeSubscription.class, cassandraProperties.getTable_challengesubscriptions());

		return mappingModelTablename;
	}


}
*/