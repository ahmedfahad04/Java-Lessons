package Exception_Handling;

class IAFCamelCaseException extends Exception{

    public IAFCamelCaseException(){
    }
}

class IAFDigitCountException extends Exception{
    public IAFDigitCountException(){
    }
}


class IAFDomainNameError extends Exception{
    private final String domain_name;

    public IAFDomainNameError(String dname){
        this.domain_name = dname;
    }

    public String getDomain_name() {
        return domain_name;
    }
}