package Exception_Handling;

public class User_Info {
    String name, NID, email;

    public void setName(String name) throws IAFCamelCaseException {
        this.name = name;

        String[] words = name.split("\\s"); //split according to spaces
        int cnt = 0;
        int segment = words.length; // counting words in string bases of spaces

        for (String word : words) {
            char ch = word.charAt(0);
			
            if (ch >= 'A' && ch <= 'Z') {
                cnt++;
            } else throw new IAFCamelCaseException();
        }
        if (cnt == segment) System.out.println("User Name OK!!");
    }

    public void setNID_Serial(String nid) throws IAFDigitCountException {
        this.NID = nid;
        int len = NID.length();

        // check option 1
        if (len == 10) {
            System.out.println("NID OK!!");
        } else throw new IAFDigitCountException();


    }

    public void setEmail(String email) throws IAFDomainNameError {
        this.email = email;
        String[] domain = email.split("@");

        if (domain[1].equals("iit.du.ac.bd")) {
            System.out.println("Email OK!!");
        } else throw new IAFDomainNameError(domain[1]);

    }


}