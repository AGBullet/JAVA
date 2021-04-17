package server;

public class DBAuthServise implements AuthService{
    @Override
    public String getNicknameByLoginAndPassword(String login, String password) {
        return SQLite.nickNameByLoginAndPassword(login,password);
    }

    @Override
    public boolean registration(String login, String password, String nickname) {
        return SQLite.register(login, password, nickname);
    }

    @Override
    public boolean changeNick(String oldNickname, String newNickName) {
        return false;
    }
}
