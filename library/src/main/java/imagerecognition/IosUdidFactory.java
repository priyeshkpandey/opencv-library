package imagerecognition;

public class IosUdidFactory {

	private static ThreadLocal<String> iosUdidStorage = new InheritableThreadLocal<String>();
	
	public static void setUdid(String udid) throws Exception {
		String udidFromEnvironment = System.getenv("UDID");
		if (null != udidFromEnvironment) {
			iosUdidStorage.set(udidFromEnvironment);
		} else if (null != udid && !udid.trim().equals("")) {
			iosUdidStorage.set(udid);
		} else {
			throw new Exception("No UDID provided as part of environment variables or as a parameter to setUdid");
		}
	}
	
	public static String getUdid() {
		return iosUdidStorage.get();
	}
	
}
