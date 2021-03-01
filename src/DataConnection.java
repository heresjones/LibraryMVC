/*
* DataConnection holds the connection to data
* Also determines if the data to be accessed is valid.
* Over a network, this static singleton class would maintain connection
 */

public class DataConnection {
    String dataStream;
    private static DataConnection INSTANCE;

    private DataConnection(){
    }

    /*
     * Creates single instance of connection.
     * Two libraries cannot share an instance.
     */
    public static DataConnection getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new DataConnection();
        }
        return INSTANCE;
    }

    public void setDataStream(String dataStream){
        this. dataStream = dataStream;
    }

    public String getDataStream() throws Exception{

        //TODO: GRAB DATA
        try{
            dataStream = "TESTING";

        } catch (Exception ex) {

        }
        return this.dataStream;
    }

    public static void loadData() {

        try {
            //TODO: CHECK IF FILE EXISTS;
        } catch (Exception e) {
            System.out.println("Data Could Not Be Loaded");
            System.out.println("/nMessage: " + e.getMessage());
            e.printStackTrace();
        }
        return;
    }
}
