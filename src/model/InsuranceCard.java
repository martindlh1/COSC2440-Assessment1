package model;

import com.google.gson.Gson;
import helper.IdGenerator;

import java.util.Date;

public class InsuranceCard {
    private Number id;
    private Number holder;
    private Number policy_owner;
    private Date expiration;

    public InsuranceCard(Number holder, Number policy_owner, Date expiration) {
        this.id = IdGenerator.generate10digitId();
        this.holder = holder;
        this.policy_owner = policy_owner;
        this.expiration = expiration;
    }

    public Number getId() {
        return id;
    }

    public String toJson() {
        Gson gson = new Gson();
        return gson.toJson(this) + "\n";
    }
}
