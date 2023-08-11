package proxy.roomDemo;
//代理类
public class UserServiceProxy implements UserService{
    public UserServiceImpl fangDong = new UserServiceImpl();
    @Override
    public void rent() {
        System.out.println("中介带租客看房");
        System.out.println("中介带租客收押金");

        //核心业务
        fangDong.rent();
    }
}
