
/**
 * Write a description of class Tester here.
 * 
 * @Nate Giffard 
 * @version (a version number or a date)
 */
import java.util.*;

public class Tester
{
    public void testLogEntry() {
        LogEntry le = new LogEntry("1.2.3.4", new Date(), "example request", 200, 500);
        System.out.println(le);
        LogEntry le2 = new LogEntry("1.2.100.4", new Date(), "example request 2", 300, 400);
        System.out.println(le2);
    }
    
    public void testLogAnalyzer() {
        String filename = "weblog1_log";
        LogAnalyzer logAnalyzer = new LogAnalyzer();
        logAnalyzer.readFile(filename);
        logAnalyzer.printAll();
    }
    public void testUniqIP() {
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("weblog2_log");
        int uniqueIPs = la.countUniqueIPs();
        System.out.println("//      //      //      //      //");
        System.out.println("There are "+uniqueIPs+" unique IPs");
    }
    public void testPrintAllHigherThanNum() {
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("weblog1_log");
        la.printAllHigherThanNum(400);
    }
    public void testUniqueIPVisitsOnDay() {
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("weblog2_log");
        String day = "Sep 24";
        ArrayList<String> uniqueVisits1 = la.uniqueIPVisitsOnDay(day);
        System.out.println("Number of unique IPs logged: "+uniqueVisits1.size());
        System.out.println("Unique IPs visited on " + day + ":");
        for (String s : uniqueVisits1) {
            System.out.println(s);
        }
    }
    public void testCountUniqueIPsInRange() {
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("weblog2_log");
        int count2 = la.countUniqueIPsInRange(200,299);
        System.out.println("Unique IPs with status code in range 200,299\n"+count2);
    }
    public void testCountVisitsPerIP() {
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("weblog1_log");
        HashMap<String,Integer> counts = la.countVisitsPerIP();
        for (String key : counts.keySet()) {
            System.out.println(key+" has "+counts.get(key)+" visits.");
        }
    }
    public void testMostNumberVisitsByIP() {
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("weblog2_log");
        HashMap<String,Integer> counts = la.countVisitsPerIP();
        int maxVisits = la.mostNumberVisitsByIP(counts);
        System.out.println("Max number of visits in log: "+maxVisits);
    }
    public void testIPsMostVisits() {
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("weblog2_log");
        HashMap<String,Integer> counts = la.countVisitsPerIP();
        ArrayList<String> ipList = la.iPsMostVisits(counts);
        System.out.println("List of IPs recorded with most visits in log:\n"+ipList);
    }
    public void testIpsForDays() {
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("weblog1_log");
        HashMap<String,ArrayList<String>> ipByDay = la.iPsForDays();
        for (String key : ipByDay.keySet()) {
            System.out.println(key+" has IPs "+ipByDay.get(key));
        }
    }
    public void testDayWithMostIPVisits() {
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("weblog2_log");
        HashMap<String,ArrayList<String>> ipByDay = la.iPsForDays();
        String dayWithMostVisits = la.dayWithMostIPVisits(ipByDay);
        System.out.println(dayWithMostVisits);
    }
    public void testIpsWithMostVisitsOnDay() {
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("weblog2_log");
        HashMap<String,ArrayList<String>> ipByDay = la.iPsForDays();
        String day = "Sep 30";
        ArrayList<String> ipsWithMostVisits = la.iPsWithMostVisitsOnDay(ipByDay,day);
        System.out.println(ipsWithMostVisits);
    }
}