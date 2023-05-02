package Service;

import model.UsersModel;
import repository.Userepository;

import java.util.List;

public class LoginService {
    private Userepository userepository = new Userepository();
    public boolean checkLogin(String email,String password){
        List<UsersModel> list = userepository.findByEmailAndPassword(email, password);
        return list.size() > 0 ;
    }
}
