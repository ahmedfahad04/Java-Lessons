package PracticeOnly;

class CheckedException extends Exception{
    public CheckedException(String message){
        super(message);
    }
}

class DataFetcher {
    public String fetchDataFromUrl(String url) throws CheckedException{
        if(url == null){
            throw new CheckedException("Url not Found");
        }

        String data = null;
        return data;
    }
}

class DataFetcherDemo{
    private DataFetcher dataFetcher;

    public DataFetcherDemo(){

    }

    public DataFetcherDemo(DataFetcher dataFetcher){
        this.dataFetcher = dataFetcher;
    }

//    public void fetchData(){
//        String url = "http://google.com";
//        try{
//            String fetchedData = dataFetcher.fetchDataFromUrl(url);
//            System.out.println("FETCHED DATA IS: "+fetchedData);
//        }
//        catch(CheckedException e){
//            e.printStackTrace();
//        }
//    }

    public void fetchedData() throws CheckedException{
        String url = "http://google.com";
        String fetchedData = dataFetcher.fetchDataFromUrl(url);
        System.out.println(fetchedData);
    }

}


public class EH{
    public static void main(String[] args) throws CheckedException {
//        DataFetcherDemo df = new DataFetcherDemo();
//        df.fetchedData();
        int a=5;
        int b=0;


        try{
            System.out.println(a/b);
        }
        catch (ArithmeticException e){
            System.out.println("Error Output");
            System.out.println(e.getMessage());
            System.out.println(e.toString());
            e.printStackTrace();
        }
    }
}
