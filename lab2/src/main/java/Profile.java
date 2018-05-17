public class Profile {
    int id;
    String profile;
    int errorCode = 0;
    String error = "";

    public Profile() {
    }

    public Profile(int id, String profile) {
        this.id = id;
        this.profile = profile;
    }
}
