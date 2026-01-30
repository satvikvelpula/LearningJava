import java.io.*;
import java.net.*;
import java.util.ArrayList;


public class ReadCSV {

    public static void main(String[] args) {
        URL myUrl;
        String headerLine;
        String[] header;
        String line;
        String[] columns;
        int count = 1;
        ArrayList<Double> temp = new ArrayList<>();


        try {
            myUrl = new URL("https://users.metropolia.fi/~jarkkov/temploki.csv");
        } catch (MalformedURLException e) {
            System.err.println(e);
            return;
        }

        try {
            InputStream input_stream = myUrl.openStream();
            InputStreamReader input_stream_reader = new InputStreamReader(input_stream);
            BufferedReader bufferedInputStreamReader = new BufferedReader(input_stream_reader);

            headerLine = bufferedInputStreamReader.readLine();
            header = headerLine.split(";");

            String first_anchor = "";

            while ((line = bufferedInputStreamReader.readLine()) != null) {
                columns = line.split(";");
                String anchor = columns[0].substring(0, 2);
                if (first_anchor.isEmpty()) {
                    first_anchor = anchor;
                }

                if (!first_anchor.equals(anchor)) {
                    break;
                }

                count++;
                String value = columns[1].replace(",", ".");


                if (value.length() <= 1) {
                    continue;
                }

                if (value.trim().isEmpty()) {
                    continue;
                }

                try {
                    double change = Double.parseDouble(value.trim());
                    temp.add(change);

                } catch (NumberFormatException e){
                    System.out.println("Error. Value not convertible. ");
                }
            }




            double total = 0;

            for (int i = 0; i < temp.size(); i++) {
                total += temp.get(i);
                System.out.println(temp.get(i));
            }

            double average = total / temp.size();
            System.out.println(average);



        } catch (IOException e) {
            System.out.println("URL not valid. ");
        } {

        }
    }
}
