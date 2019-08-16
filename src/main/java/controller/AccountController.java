package controller;

import entity.Account;
import entity.QueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import service.AccountService;

import java.util.List;

@Controller
public class AccountController {
    @Autowired
    private AccountService accountService;

    @RequestMapping("/")
        public String all(Model model){
        List<Account> list=accountService.getAll();
        System.out.println(list);
        model.addAttribute("accountList",list);
        return "accountlist";
    }
    @RequestMapping("/edit")
    public String edit(Integer id,Model model){
        model.addAttribute("account",accountService.getById(id));
        return "update";
    }
    @RequestMapping("/delete")
    public String delete(Integer id){
        accountService.deleteAccount(id);
        return "forward:/";
    }
    @RequestMapping("/update")
    public String update(Account account){
        accountService.updateAccount(account);
        return "forward:/";
    }
    @RequestMapping("/batchDelete")
    public String batchDelete(QueryVo queryVo){
        List<Account> list=queryVo.getAccountList();
        for (Account account:list){
            accountService.deleteAccount(account.getId());
        }
        return"forward:/";
    }
    @RequestMapping("/batchUpdate")
    public String batchUpdate(QueryVo queryVo){
        List<Account> list=queryVo.getAccountList();
        for (Account account:list){
            accountService.updateAccount(account);
        }
        return "forward:/";
    }
    @RequestMapping("/getById")
    public String getById(Integer id,Model model){
        Account account=accountService.getById(id);
        if (account!=null){
            model.addAttribute("account",account);
            return "getById";
        }else{
            model.addAttribute("msg","不存在该ID用户");
            return "forward:/";
        }

    }

}
