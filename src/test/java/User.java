public class User
{
    private String login;
    private String password;

    public User (String login, String password)
    {
        this.login = login;
        this.password = password;
    }

    public String getLogin()
    {
        return login;
    }

    public void setLogin(String newLogin)
    {
        login = newLogin;
    }

    public String getPassword()
    {
        return password;
    }

    public void getPassword(String newPassword)
    {
        password = newPassword;
    }
}
