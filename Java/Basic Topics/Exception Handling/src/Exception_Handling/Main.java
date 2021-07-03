package Exception_Handling;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IAFCamelCaseException {
        User_Info usr1 = new User_Info();
        Scanner sc = new Scanner(System.in);

        System.out.println("--------------------------------------------------------------------------------------------------");

        System.out.println("\n\t\t\t----------Welcome to IIT Covid-19 Vaccine Registration Portal------");
        System.out.println("\t\t\tTo Complete your Registration Please fill the information Correctly.\n");


        try {
            System.out.print("Name: ");
            String name = sc.nextLine();
            usr1.setName(name);

            System.out.print("\nNID number: ");
            String nid = sc.nextLine();
            usr1.setNID_Serial(nid);

            System.out.print("\nMail address: ");
            String mail = sc.nextLine();
            usr1.setEmail(mail);

            System.out.println("\nRedirecting to the next page\n\t\t\t\t\n\t\t\t\t\t\t\t\t....Loading......\n");

        } catch (IAFCamelCaseException e) {
            System.out.println("\n" + "First letter of each word should be in Capital Letter(Camel Case Formate).");
            e.printStackTrace();
        } catch (IAFDigitCountException e) {
            System.out.println("\n" + "NID number length should be 10.");
            e.printStackTrace();
        } catch (IAFDomainNameError e) {
            System.out.println("\n" + "'" +e.getDomain_name() +"'" + " is not accepted here. Replace your domain name with 'iit.du.ac.bd'.");
            e.printStackTrace();
        }

    }
}
