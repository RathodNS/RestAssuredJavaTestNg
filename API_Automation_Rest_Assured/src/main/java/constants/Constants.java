package constants;

import java.io.File;

import utils.File_Reader;

public final class Constants {
	public static final String PROJECT_PATH = System.getProperty("user.dir");
	public static final String BASE_URL =getBaseURL();
	public static final String GetALLPlayers_EndPoint="/players";
	public static final String GetPlayers_INFO_End_Point="/playersProfile";
    public static final String RESOURCES_FOLDER_PATH = PROJECT_PATH + File.separator + "/src/test/resources";

	
	public static String getBaseURL() {
		return new File_Reader().getConfig("base_uri");
	}
}
