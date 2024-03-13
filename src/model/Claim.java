package model;
import com.google.gson.Gson;
import helper.IdGenerator;
import java.util.*;

public class Claim {
    private final Number id;
    private Date date;
    private Customer insured;
    private Date exam_date;
    private String[] doc;
    private Number amount;
    private BankInfo bankInfo;

    public Claim(Date date, Customer insured, Date exam_date, String[] doc, Number amount, BankInfo bankInfo) {
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

    public String toJson() {
        Gson gson = new Gson();
        return gson.toJson(this) + "\n";
    }
}
