package core;

import strategy._2524764_StudentFine;

public class _2524764_StudentUser extends _2524764_User {
    public _2524764_StudentUser(String userId, String name) {
        super(userId, name);
        this.fineStrategy = new _2524764_StudentFine();
    }

    @Override
    public String getUserType() { return "Student"; }
}
