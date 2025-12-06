package core;

import strategy._2524764_FacultyFine;

public class _2524764_FacultyUser extends _2524764_User {
    public _2524764_FacultyUser(String userId, String name) {
        super(userId, name);
        this.fineStrategy = new _2524764_FacultyFine();
    }

    @Override
    public String getUserType() { return "Faculty"; }
}
