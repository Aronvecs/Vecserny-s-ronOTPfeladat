import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import Classes.Costumer;
import Classes.Payment;
import Validators.CostumerValidatorFactory;
import Validators.PaymentValidatorBase;
import Validators.PaymentValidatorFactory;


public class Main {
    static List<Costumer> costumers = new ArrayList<>();
    static List<Payment> payments = new ArrayList<>();
    static int paymentslines = 0;
    static int costuemrlines = 0;

    public Main() throws FileNotFoundException {
    }

    public static void main(String[] args) throws IOException {
        Path path = Path.of("src", "CSVFiles", "costumer.csv");
        ReadingCostumerCSVFile(path);
        path = Path.of("src", "CSVFiles", "payments.csv");
        ReadingPaymentCSVFile(path);

        for (Costumer c : costumers){
            System.out.println(c.toString());
        }
        System.out.println(costuemrlines);
        for (Payment c : payments){
            System.out.println(c.toString());
        }
        System.out.println(paymentslines);

        CostumersPurchases();

    }
    private static void asd(){
        List<Runnable> actions = new ArrayList<Runnable>();

    }

    private static void CostumersPurchases() throws IOException {
        File file = new File("report01.csv");
        file.createNewFile();
        PrintWriter outputfile = new PrintWriter(file);
        outputfile.println("Name,Address,PurchaseSum");
        payments.stream()
                .collect(Collectors.groupingBy(Payment::getCostumerId,
                        Collectors.summingInt(Payment::getSum)))
                .forEach((id,sumTargetCost)->{
                    outputfile.println(Objects.requireNonNull(FindCostumerByID(id)).getName()
                            +","+ Objects.requireNonNull(FindCostumerByID(id)).getAddress() +
                            ","+ sumTargetCost);
                });
        outputfile.close();
    }
    private static Costumer FindCostumerByID(String id){
        for (Costumer c : costumers){
            if (Objects.equals(c.getId(), id)){
                return c;
            }
        }
        return null;
    }
    private static void ReadingPaymentCSVFile(Path path) throws IOException {
        Files.lines(path)
                .skip(1)
                .map(Main::getPayment)
                .forEach((n)->{
                    if (n != null){
                        payments.add(n);
                    }
                });
    }
    private static void ReadingCostumerCSVFile(Path path) throws IOException {
        Files.lines(path)
                .skip(1)
                .map(Main::getCostumer)
                .forEach((n)->{
                    if (n != null){
                        costumers.add(n);
                    }
                });
    }
    private static Payment getPayment(String line) {
        paymentslines++;
        String[] fields = line.split(",");
        Date date = null;
        try {
            date = new SimpleDateFormat("dd/MM/yyyy").parse(fields[6]);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        Payment c = new Payment(fields[0], fields[1], fields[2], Integer.valueOf(fields[3]), fields[4], fields[5], date);
        var validatorFactory = new PaymentValidatorFactory();
        var validators = validatorFactory.GetValidators();

        return ValidationCheck(validators, c);
    }

    private static Payment ValidationCheck(Iterable<PaymentValidatorBase> validators, Payment c) {
        int acceptedValidatiors = 0;
        File file = new File("append.log");
        FileWriter fr = null;
        try {
            fr = new FileWriter(file, true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for (var validator : validators) {
            if (validator.Validate(c)){
                acceptedValidatiors++;
            }
            else{
                try {
                    fr.write("In the line: "+paymentslines +" "+validator.NotValid(c)+"\n");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        try {
            fr.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (acceptedValidatiors == size(validators)) {
            return c;
        }

        return null;
    }

    private static Costumer getCostumer(String line) {
        costuemrlines++;
        String[] fields = line.split(",");
        Costumer c = new Costumer(fields[1], fields[2], fields[3], fields[0]);
        var validatorFactory = new CostumerValidatorFactory();
        var validators = validatorFactory.GetValidators();

        int acceptedValidatiors = 0;
        File file = new File("append.log");//filename
        FileWriter fr = null;
        try {
            fr = new FileWriter(file, true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for (var validator : validators) {
            if (validator.Validate(c)){
                acceptedValidatiors++;
            }
            else{
                try {
                    fr.write("In the line: "+costuemrlines +" "+validator.NotValid(c)+"\n");//data
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        try {
            fr.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (acceptedValidatiors == size(validators)) {
            return c;
        }

        return null;
    }

    public static int size(Iterable data) {

        if (data instanceof List) {
            return ((List<?>) data).size();
        }
        int counter = 0;
        for (Object i : data) {
            counter++;
        }
        return counter;
    }


}