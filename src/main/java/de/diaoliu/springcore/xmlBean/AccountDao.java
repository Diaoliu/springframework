package de.diaoliu.springcore.xmlBean;

import lombok.Data;

import java.util.Date;
import java.util.Map;

@Data
public class AccountDao {

    private boolean enabled;
    private Date createdAt;
    private Map<String, Float> accounts;

    public AccountDao(boolean enabled) {
        this.enabled = enabled;
    }
}
