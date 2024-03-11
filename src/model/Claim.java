package model;

import com.google.gson.Gson;

import java.util.*;
import java.io.FileWriter;
import java.io.IOException;

public class Claim {
    private UUID id;
    private Date date;
    private Customer insured;
    private Date exam_date;
    private String[] doc;
    private Number amount;
    private BankInfo bankInfo;

    public Claim(Date date, Customer insured, Date exam_date, String[] doc, Number amount, BankInfo bankInfo) {
        this.id = UUID.randomUUID();
        this.date = date;
        this.insured = insured;
        this.exam_date = exam_date;
        this.doc = doc;
        this.amount = amount;
        this.bankInfo = bankInfo;
    }

    public UUID getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return "id: " + id +
                "\ndate: " + date +
                "\ninsured: " + insured +
                "\nexam_date: " + exam_date +
                "\ndoc: " + Arrays.toString(doc) +
                "\namount: " + amount +
                "\nbankInfo: " + bankInfo +
                "\n";
    }

    public String toJson() {
        Gson gson = new Gson();
        return gson.toJson(this) + "\n";
    }
}
