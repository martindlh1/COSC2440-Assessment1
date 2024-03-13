package model;
import com.google.gson.Gson;
import helper.IdGenerator;
import repository.CustomerRepository;

import java.util.*;

public class Claim {
    private final Number id;
    private Date date;
    private Number insured;
    private Date exam_date;
    private String[] doc;
    private Number amount;
    private BankInfo bankInfo;

    public Claim(Date date, Number insured, Date exam_date, String[] doc, Number amount, BankInfo bankInfo) {
        this.id = IdGenerator.generate10digitId();
        this.date = date;
        this.insured = insured;
        this.exam_date = exam_date;
        this.doc = doc;
        this.amount = amount;
        this.bankInfo = bankInfo;
    }

    public Number getId() {
        return this.id;
    }

    public void setAmount(Number amount) {
        this.amount = amount;
    }

    public Number getInsured() {
        return insured;
    }

    public void setInsured(Number insured) {
        this.insured = insured;
    }

    @Override
    public String toString() {
        return ">\tid: " + id +
                "\n\tdate: " + date +
                "\n\tinsured: " + insured +
                "\n\texam_date: " + exam_date +
                "\n\tdoc: " + Arrays.toString(doc) +
                "\n\tamount: " + amount +
                "\n\tbankInfo: " + bankInfo;
    }

    public String toDetailedString() {
        return ">\tid: " + id +
                "\n\tdate: " + date +
                "\n\tinsured: " + CustomerRepository.getInstance().getOne(insured).toClaimString() +
                "\n\texam_date: " + exam_date +
                "\n\tdoc: " + Arrays.toString(doc) +
                "\n\tamount: " + amount +
                "\n\tbankInfo: " + bankInfo;
    }

    public String toJson() {
        Gson gson = new Gson();
        return gson.toJson(this) + "\n";
    }
}
