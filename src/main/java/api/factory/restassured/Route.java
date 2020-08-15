package api.factory.restassured;

public class Route {
    private static final String BASE_PATH = "student";

    private static final String STUDENT_LIST = "/list";

    public static String getBasePath() {
        return BASE_PATH;
    }

    public static String getStudentListPath() {
        return BASE_PATH + STUDENT_LIST;
    }

    public static String getStudentIDPath(String studentId) {
        return BASE_PATH + studentId;
    }
}
