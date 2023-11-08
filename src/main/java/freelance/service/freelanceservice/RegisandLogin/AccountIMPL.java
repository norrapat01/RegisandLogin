package freelance.service.freelanceservice.RegisandLogin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import freelance.service.freelanceservice.Account;
import freelance.service.freelanceservice.AccountDTO;

@Service
public class AccountIMPL implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public String addAccount(AccountDTO accountDTO) {
        Account account = new Account(accountDTO.getAccountid(), accountDTO.getAccountname(), accountDTO.getEmail(), accountDTO.getNumberCard(), accountDTO.getPassword());
        accountRepository.save(account);
        return account.getAccountname();
    }

    @Override
    public LoginResponse loginMesage(LoginDTO loginDTO) {
        String msg = "";
        Account account1 = accountRepository.findByEmail(loginDTO.getEmail());
        if (account1 != null) {
            String password = loginDTO.getPassword();
            String storedPassword = account1.getPassword();
            if (password.equals(storedPassword)) {
                return new LoginResponse("Login Success", true);
            } else {
                return new LoginResponse("Login Failed", false);
            }
        } else {
            return new LoginResponse("Email not exists", false);
        }
    }
}
