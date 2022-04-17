import java.io.File;

public class FileUtil {
    public static String getCitiesFile(String testCase) {
        File f = new File(String.format("test/resources/%s/cities.json", testCase));
        return f.getAbsolutePath();
    }

    public static String getRoadsFile(String testCase) {
        File f = new File(String.format("test/resources/%s/roads.json", testCase));
        return f.getAbsolutePath();
    }
}
