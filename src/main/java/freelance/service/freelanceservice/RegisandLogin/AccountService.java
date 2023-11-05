package freelance.service.freelanceservice.RegisandLogin;
import freelance.service.freelanceservice.AccountDTO;

public interface AccountService {
    
    String addAccount(AccountDTO accountDTO);
    
    LoginResponse loginMesage(LoginDTO loginDTO);
}
