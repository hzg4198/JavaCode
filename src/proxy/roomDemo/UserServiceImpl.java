package proxy.roomDemo;

public class UserServiceImpl implements UserService {

    @Override
    public void rent() {
        System.out.println("房东出租房屋成功 收钱");
    }
}
