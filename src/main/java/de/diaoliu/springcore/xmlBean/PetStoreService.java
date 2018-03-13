package de.diaoliu.springcore.xmlBean;

import lombok.Data;

@Data
public class PetStoreService {

    private AccountDao accountDao;
    private ItemDao itemDao;

    public boolean isAccountEnabled() {
        return accountDao.isEnabled();
    }

}
