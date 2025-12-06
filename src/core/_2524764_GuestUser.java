package core;

import strategy._2524764_GuestFine;

public class _2524764_GuestUser extends _2524764_User {
    public _2524764_GuestUser(String userId, String name) {
        super(userId, name);
        this.fineStrategy = new _2524764_GuestFine();
    }

    @Override
    public String getUserType() { return "Guest"; }
}
