package Service;

import model.UsersModel;
import repository.Userepository;

import java.util.List;

public class UserService {
    private Userepository userepository = new Userepository();
    public List<UsersModel> UserList(){
        List<UsersModel> list = userepository.findUser();
        return list;
    }
}
