package model;

import com.google.gson.Gson;
import helper.IdGenerator;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private Number id;
    private String full_name;
    private InsuranceCard insurance_card;
    private CustomerType type;
    private List<Claim> claims;

    public Customer(String full_name, CustomerType type) {
        this.id = IdGenerator.generate7digitId();
        this.full_name = full_name;
        this.insurance_card = null;
        this.type = type;
        this.claims = new ArrayList<>();
    }

    public Number getId() {
        return id;
    }

    @Override
    public String toString() {
        return ">\tid: " + id +
                "\n\tfull_name: " + full_name +
                "\n\tinsurance_card: " + insurance_card +
                "\n\ttype: " + type +
                "\n\tclaims: " + claims;
    }

    public String toJson() {
        Gson gson = new Gson();
        return gson.toJson(this) + "\n";
    }
}
